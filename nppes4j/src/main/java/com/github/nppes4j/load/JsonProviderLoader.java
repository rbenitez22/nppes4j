/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j.load;

import com.github.nppes4j.AddressPurpose;
import com.github.nppes4j.Country;
import com.github.nppes4j.EntityType;
import com.github.nppes4j.NppesException;
import com.github.nppes4j.UsState;
import com.github.nppes4j.entity.Address;
import com.github.nppes4j.entity.AuthorizedOfficial;
import com.github.nppes4j.entity.Identifier;
import com.github.nppes4j.entity.IndividualProvider;
import com.github.nppes4j.entity.OrganizationalProvider;
import com.github.nppes4j.entity.Provider;
import com.github.nppes4j.entity.Taxonomy;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 *
 * @author Roberto C. Benitez
 */
public class JsonProviderLoader
{
    private final JsonObject source;
    
    public JsonProviderLoader(JsonObject source)
    {
        this.source = source;
    }

    public Provider load() throws NppesException
    {
        int number=getInt(source, JsonResultKeys.NUMBER);
        
        
        Provider provider = createProviderInstance();
        provider.setNumber(number);
        
        List<Address> addresses=loadAddresses();
        List<Identifier> identifiers=loadIdentifiers();
        List<Taxonomy> taxonomies=loadTaxonomies();
        
        provider.setNumber(number);
        provider.setAddresses(addresses);
        provider.setIdentifiers(identifiers);
        provider.setTaxanomies(taxonomies);
        
        return provider;
        
    }
    
    private void loadIndividualdBasic(IndividualProvider provider)
    {
        JsonObject basic=source.getJsonObject(JsonResultKeys.BASIC.getNppesName());
        
        String credential=basic.getString("credential","");
        LocalDate date=null;
        String strDate=basic.getString("enumeration_date","");
        if(!(strDate==null || strDate.isEmpty()))
        {
            date=LocalDate.parse(strDate);
        }
        
        String firstName=basic.getString("first_name","");
        String middleName=basic.getString("middle_name", "");
        String lastName=basic.getString("last_name","");
        String preffix=basic.getString("name_prefix","");
        boolean soleProprietor=getBoolean(basic, "sole_proprietor");
        
        provider.setPrefix(preffix);
        provider.setFirstName(firstName);
        provider.setMiddleName(middleName);
        provider.setLastName(lastName);
        provider.setEnumerationDate(date);
        provider.setSoleProprietor(soleProprietor);
        provider.setCredential(credential);
        
    }
    
     public List<Taxonomy> loadTaxonomies() throws NppesException
    {
        JsonResultKeys key=JsonResultKeys.TAXONOMIES;
        assertHasKey(source, key);
        
        List<Taxonomy> list= new ArrayList<>();
        JsonArray array=source.getJsonArray(key.getNppesName());
        
        for(int i=0;i<array.size();i++)
        {
            JsonObject idObject=array.getJsonObject(i);
            Taxonomy tax=createTaxonomy(idObject);
            list.add(tax);
        }
        
       return list;
    }
    
    public Taxonomy createTaxonomy(JsonObject json)
    {
        String code=json.getString("code");
        String descr=json.getString("desc");
        String license=json.getString("license");
        boolean primary=json.getBoolean("primary");
        String state=json.getString("state");
        
        Taxonomy tax= new Taxonomy();
        tax.setCode(code);
        tax.setDescription(descr);
        tax.setLicense(license);
        tax.setPrimary(primary);
        tax.setState(state);
        
        return tax;
    }
    
    public List<Identifier> loadIdentifiers() throws NppesException
    {
        JsonResultKeys key=JsonResultKeys.IDENTIFIERS;
        assertHasKey(source, key);
        
        List<Identifier> list= new ArrayList<>();
        JsonArray array=source.getJsonArray(key.getNppesName());
        
        for(int i=0;i<array.size();i++)
        {
            JsonObject idObject=array.getJsonObject(i);
            Identifier ident=createIdentifier(idObject);
            list.add(ident);
        }
        
       return list;
    }
    
    public Identifier createIdentifier(JsonObject json)
    {
        String code=json.getString("code");
        String descr=json.getString("desc");
        String identifier=json.getString("identifier");
        String issuer=json.getString("issuer");
        String state=json.getString("state");
        
        Identifier id= new Identifier();
        id.setCode(code);
        id.setDescription(descr);
        id.setId(identifier);
        id.setIssuer(issuer);
        id.setState(state);
        
        return id;
    }
    
    public List<Address> loadAddresses() throws NppesException
    {
        JsonResultKeys key=JsonResultKeys.ADDRESSES;
        assertHasKey(source, key);
        
        List<Address> list= new ArrayList<>();
        JsonArray addresses=source.getJsonArray(key.getNppesName());
        for(int i=0;i<addresses.size();i++)
        {
            JsonObject jsonAddr=addresses.getJsonObject(i);
            Address addr=createAddress(jsonAddr);
            list.add(addr);
        }
        return list;
    }

    private void assertHasKey(JsonObject object, JsonResultKeys key) throws NppesException
    {
        if(!object.containsKey(key.getNppesName()))
        {
            throw new NppesException("JsonObject does not contain key " + key.getNppesName());
        }
    }

    public Address createAddress(JsonObject addressObject)
    {
        String line1=addressObject.getString("address_1","");
        String line2=addressObject.getString("address_2","");
        AddressPurpose purp= AddressPurpose.safeValueOf(addressObject.getString("address_purpose",""));
        String city=addressObject.getString("city","");
        
        UsState state=UsState.valueOf(addressObject.getString("state",""));
        Country country=Country.valueOf(addressObject.getString("country_code",""));
        String faxNumber=addressObject.getString("fax_number","");
        String telephoneNumber=addressObject.getString("telephone_number","");
        String postalCode=addressObject.getString("postal_code","");
        
        
        Address address= new Address();
        address.setLine1(line1);
        address.setLine2(line2);
        address.setPurpose(purp);
        address.setCity(city);
        address.setState(state);
        address.setCountry(country);
        address.setPostalCode(postalCode);
        address.setFaxNumber(faxNumber);
        address.setTelephoneNumber(telephoneNumber);
        
        return address;
    }
    
    private void loadOrganizationLBasic(OrganizationalProvider provider)
    {
        JsonObject basic=source.getJsonObject(JsonResultKeys.BASIC.getNppesName());
        
        AuthorizedOfficial auth=createAuthorizedOfficial(basic);
        provider.setAuthorizedOfficial(auth);
        
        String name=basic.getString("organization_name","");
        
        String strDate=basic.getString("enumeration_date", "");
        LocalDate date=null;
        if(!strDate.isEmpty())
        {
            date=LocalDate.parse(strDate);
        }
        
        boolean subpart=getBoolean(basic, "organizationl_subpart");
        String status=basic.getString("status", "");
        
        provider.setName(name);
        provider.setEnumerationDate(date);
        provider.setStatus(status);
        provider.setOrganiationalSubpart(subpart);

    }
    
    private AuthorizedOfficial createAuthorizedOfficial(JsonObject orgBasicNode)
    {
        String credential=orgBasicNode.getString("authorized_official_credential", "");
        String firstName=orgBasicNode.getString("authorized_official_first_name", "");
        String middleName=orgBasicNode.getString("authorized_official_middle_name", "");
        String lastName=orgBasicNode.getString("authorized_official_last_name", "");
        String namePrefix=orgBasicNode.getString("authorized_official_name_prefix", "");
        String title=orgBasicNode.getString("authorized_official_title_or_position", "");
        String telephoneNumber=orgBasicNode.getString("authorized_official_telephone_number", "");
        
        AuthorizedOfficial auth= new AuthorizedOfficial();
        auth.setCredential(credential);
        auth.setFirstName(firstName);
        auth.setMiddleName(middleName);
        auth.setLastName(lastName);
        auth.setPrefix(namePrefix);
        auth.setTitle(title);
        auth.setTelephoneNumber(telephoneNumber);
        
        return auth;
    }

    private Provider createProviderInstance() throws NppesException
    {
        EntityType type=EntityType.forNppesName(getString(source, JsonResultKeys.ENUMERATION_TYPE));
        
        if(type==EntityType.NPI1)
        {
            IndividualProvider ip =new IndividualProvider();
            loadIndividualdBasic(ip);
            return ip;
        }
        else if(type==EntityType.NPI2)
        {
            OrganizationalProvider op = new OrganizationalProvider();
            loadOrganizationLBasic(op);
            return op;
        }
        else
        {
            throw new NppesException("Unrecognized " + JsonResultKeys.ENUMERATION_TYPE.getNppesName());
        }
        
    }
    
    private int getInt(JsonObject object,JsonResultKeys key)
    {
        return object.getInt(key.getNppesName());
    }
    
    private String getString(JsonObject object,JsonResultKeys key)
    {
        return object.getString(key.getNppesName());
    }
    
    private LocalDate getLocalDate(JsonObject object, JsonResultKeys key)
    {
        String string=getString(object, key);
        return LocalDate.parse(string);
    }
    
    private boolean getBoolean(JsonObject object,String key)
    {
        String string=object.getString(key,"false");
        
        return (!(string==null || string.isEmpty()) 
                && (string.toLowerCase().matches("(yes)|(y)|(true)|(t)|(1)")));
        
    }
    
}
