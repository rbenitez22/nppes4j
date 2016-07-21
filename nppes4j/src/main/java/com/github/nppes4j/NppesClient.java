/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j;

import com.github.nppes4j.entity.IndividualProvider;
import com.github.nppes4j.entity.OrganizationalProvider;
import com.github.nppes4j.entity.Provider;
import com.github.nppes4j.load.JsonProviderLoader;
import com.github.nppes4j.load.JsonResultKeys;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Roberto C. Benitez
 * @param <T>
 */
public final class NppesClient<T extends Provider>
{
    public final int SEARCH_LIMIT_MIN=1;
    public final int SEARCH_LIMIT_MAX=200;
    public final String API_URL="https://npiregistry.cms.hhs.gov/api/";
    
    private final EntityType type;
    private final StringBuilder searchBuffer = new StringBuilder();
    
    private NppesClient(EntityType type)
    {
        this.type=type;
        with(SearchField.TYPE, type.getNppesName());
    }
    
    public NppesClient<T> with(SearchField field, String criterion)
    {
        addCriteria(criterion, field);
        
        return this;
    }

    public void addCriteria(String criterion, SearchField field) throws IllegalArgumentException
    {
        validateCriterion(criterion, field);
        
        if(searchBuffer.length() > 0)
        {
            searchBuffer.append("&");
        }
        
        String string=field.getFieldName() + "=" + criterion;
        searchBuffer.append(string);
    }

    private void validateCriterion(String criterion, SearchField field) throws IllegalArgumentException
    {
        if(criterion==null || criterion.isEmpty())
        {
            throw new IllegalArgumentException("No criteroin value provide");
        }
        
        if (((field == SearchField.PROVIDER_FIRST_NAME || field == SearchField.PROVIDER_LAST_NAME)
                && type != EntityType.NPI1)
                || (field == SearchField.ORGANIZATION_NAME && type != EntityType.NPI2))
        {
            String string = String.format("Invalid Search Criteria. Cannot use search field '%s' with entity type '%s'", field, type.getNppesName());
            throw new IllegalArgumentException(string);
        }

        if(field==SearchField.RESULT_LIMIT || field ==SearchField.SKIP_COUNT)
        {
            int number=Integer.valueOf(criterion);
            if(field==SearchField.RESULT_LIMIT && (number < SEARCH_LIMIT_MIN || number > SEARCH_LIMIT_MAX))
            {
                String string=String.format("Search Result limit must be between '%s' and '%s'", SEARCH_LIMIT_MIN,SEARCH_LIMIT_MAX);
                throw new IllegalArgumentException(string);
            }
        }
    }
    
    public NppesClient<T> inCountry(Country country)
    {
        with(SearchField.COUNTRY_CODE,country.name());
        
        return this;
    }
    
    public NppesClient<T> inState(UsState state)
    {
        with(SearchField.STATE,state.name());
        return this;
    }
    
    public NppesClient<T> inCity(String city)
    {
        with(SearchField.CITY,city);
        
        return this;
    }
    
    public NppesClient<T> prettyPrint()
    {
        return with(SearchField.PRETTY_PRINT,"true");
    }
    
    public NppesClient<T> withFirstName(String name)
    {
        with(SearchField.PROVIDER_FIRST_NAME,name);
        
        return this;
    }
    
    public NppesClient<T> withLastName(String name)
    {
        with(SearchField.PROVIDER_LAST_NAME,name);
        
        return this;
    }
    
    public NppesClient<T> withOrganizationName(String name)
    {
        with(SearchField.ORGANIZATION_NAME,name);
        
        return this;
    }
    
    public NppesClient<T> withNumber(String number)
    {
        with(SearchField.NUMBER,number);
        
        return this;
    }
    
    public NppesClient<T> limit(int limit)
    {
        return with(SearchField.RESULT_LIMIT,Integer.toString(limit));
    }
    
    public NppesClient<T> skip(int skipCount)
    {
        return with(SearchField.SKIP_COUNT, Integer.toString(skipCount));
    }
    
    /**
     * Search the NPPES NPI Registry <code>https://npiregistry.cms.hhs.gov/api</code> with the criteria entered.
     * Visit <code>https://npiregistry.cms.hhs.gov/registry/help-api</code> for help as well as terms of service.
     * @return List of providers matching selected criteria.
     * @throws NppesException 
     */
    public List<T> search() throws NppesException
    {
        if(searchBuffer.length()==0)
        {
            throw new IllegalStateException("No Search criteria has been provided");
        }
        
        
        
        URL url=createUrl();
       try
       {
           return load(url.openStream());
       }
       catch(IOException e)
       {
           throw new NppesException("Error while making API call: " + e.getMessage(),e);
       }
       
    }
    
    /**
     * Download data from the NPPES NPI Registry <code>https://npiregistry.cms.hhs.gov/api</code> with the criteria entered.
     * Visit <code>https://npiregistry.cms.hhs.gov/registry/help-api</code> for help as well as terms of service.
     * @param outputFilePath file location where data should be saved
     * @param append flag indicating whether file should be appended if it exists
     * @throws IOException 
     */
    public void download(String outputFilePath,boolean append) throws IOException
    {
        download(new File(outputFilePath), append);
    }
    
    /**
     * Download data from the NPPES NPI Registry <code>https://npiregistry.cms.hhs.gov/api</code> with the criteria entered.
     * Visit <code>https://npiregistry.cms.hhs.gov/registry/help-api</code> for help as well as terms of service.
     * @param outputFile file location where data should be saved
     * @param append flag indicating whether file should be appended if it exists
     * @throws IOException 
     */
    public void download(File outputFile,boolean append) throws IOException
    {
        if(searchBuffer.length()==0)
        {
            throw new IllegalStateException("No Search criteria has been provided");
        }
        
        URL url=createUrl();
       try(InputStream is = url.openStream();
               OutputStream os = new FileOutputStream(outputFile,append))
       {
           while(true)
           {
               byte[] buffer= new byte[1024];
               int i=is.read(buffer);
               if(i<0){break;}
               os.write(buffer, 0, i);
           }
       }
       
    }
    
    private static <T extends Provider> List<T> load(InputStream is) throws NppesException
    {
        List<T> list = new ArrayList<>();
        try (JsonReader reader = Json.createReader(is))
        {
            JsonObject json=reader.readObject();
            Set<String> rootKeys=json.keySet();
            
            JsonResultKeys errorsKey=JsonResultKeys.ERRORS;
            
            if(rootKeys.contains(errorsKey.getNppesName()))
            {
                JsonObject errors=json.getJsonObject(errorsKey.getNppesName());
                throw new NppesException(errors);        
            }
            
            JsonResultKeys resultsKey=JsonResultKeys.RESULTS;
            
            if(!rootKeys.contains(resultsKey.getNppesName()))
            {
                throw new NppesException(resultsKey.getNppesName() + " node not found in JSON response");
            }
            
            JsonArray results=json.getJsonArray(resultsKey.getNppesName());
            
            for(int i=0; i<results.size();i++)
            {
                JsonObject node=results.getJsonObject(i);
                JsonProviderLoader loader = new JsonProviderLoader(node);
                T provider=(T)loader.load();
                list.add(provider);
            }
            
        }
        return list;
    }

    private URL createUrl()
    {
        String urlSpec=API_URL + "?" + searchBuffer.toString();
        try
        {
            URL url = new URL(urlSpec);
            return url;
        }
        catch(Exception e)
        {
            throw new RuntimeException("Error creating API URL call. " + e.getMessage(), e);
                    
        }
    }
    
    /**
     * Create an NPPES Client for NPI-1 (Individual) type Provider
     * @return List of {@link IndividualProvider}
     */
    public static NppesClient<IndividualProvider> forNpi1()
    {
        return new NppesClient<>(EntityType.NPI1);
    }
    
    /**
     * Create an NPPES Client for NPI-2 (Organizational) type Provider
     * @return List of {@link OrganizationalProvider}
     */
    public static NppesClient<OrganizationalProvider> forNpi2()
    {
        return new NppesClient<>(EntityType.NPI2);
    }
    
    /**
     * Load {@link Provider}s from a local file.  A client is expected to check whether the {@link Provider}
     * elements are {@link IndividualProvider}s or {@link OrganizationalProvider}s,
     * @param jsonFilePath
     * @return List of {@link Provider}
     * @throws NppesException 
     */
    public static  List<Provider> loadLocal(String jsonFilePath) throws NppesException
    {
        return loadLocal(new File(jsonFilePath));
    }
    
    /**
     * Load {@link Provider}s from a local file.  A client is expected to check whether the {@link Provider}
     * elements are {@link IndividualProvider}s or {@link OrganizationalProvider}.
     * @param jsonFile
     * @return List of {@link Provider}
     * @throws NppesException 
     */
    public static   List<Provider> loadLocal(File jsonFile) throws NppesException
    {
        List<Provider> list;
        
        try(InputStream is = new FileInputStream(jsonFile))
        {
            list=load(is);
        }
        catch(IOException e)
        {
            throw new NppesException("Error loading local NPPES JSON file. " + e.getMessage(), e);
        }
        
        return list;
    }
}
