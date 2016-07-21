/*
 * Copyright 2016 Roberto C. Benitez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.nppes4j;

import com.github.nppes4j.entity.Address;
import com.github.nppes4j.entity.Identifier;
import com.github.nppes4j.entity.IndividualProvider;
import com.github.nppes4j.entity.OrganizationalProvider;
import com.github.nppes4j.entity.Provider;
import com.github.nppes4j.entity.Taxonomy;
import java.io.File;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Roberto C. Benitez
 */
public class NppesClientTest
{

    public NppesClientTest()
    {
    }

    @Test public void testDownload()
    {
        try
        {
            int skip = 0;
            int size = 10;
            for (int i = 0; i < 5; i++)
            {
                NppesClient.forNpi1()
                        .withLastName("Robinson")
                        .inState(UsState.TX)
                        .inCity("Houston")
                        .skip(skip)
                        .limit(size)
                        .prettyPrint()
                        .download(new File("c:/tmp/nppes/download-tests.json"), false);
                skip += size;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test public void testNpi1LastNameStateSearch()
    {
        try
        {
            List<IndividualProvider> list = NppesClient.forNpi1()
                    .withLastName("Smith")
                    .inState(UsState.TX)
                    .search();

            System.out.println("Results found: " + list.size());
            for (IndividualProvider prov : list)
            {
                System.out.printf("%s, %s(%s)\n", prov.getLastName(), prov.getFirstName(), prov.getNumber());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test public void testOrganizationSearch()
    {
        try
        {
            List<OrganizationalProvider> list = NppesClient.forNpi2()
                    .withOrganizationName("Methodist*")
                    .inState(UsState.TX)
                    .inCity("Houston")
                    .limit(5)
                    .skip(5)
                    .search();

            System.out.println("Results found: " + list.size());
            for (Provider provider : list)
            {
                System.out.printf("[%s] %s\n", provider.getNumber(), provider.getName());
                System.out.println("\tAddresses");
                for (Address addr : provider.getAddresses())
                {
                    System.out.printf("\t\t%s, %s %s\n", addr.getLine1(), addr.getCity(), addr.getState());
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testGenereric()
    {
        try
        {
            List<Provider> list = NppesClient.loadLocal("c:/tmp/nppes/organization.json");
            System.out.printf("Results Found: %s\n", list.size());
            int i = 1;
            for (Provider prov : list)
            {
                System.out.printf("[%s] %s : %s(%s)\n", (i++), prov.getType().getNppesName(), prov.getName(), prov.getNumber());
                System.out.println("Auth Official");

                System.out.println("Addresses");
                for (Address address : prov.getAddresses())
                {
                    System.out.printf("\t%s %s, %s,  %s %s\n", address.getLine1(), address.getLine2(), address.getCity(), address.getState(), address.getPostalCode());
                }

                System.out.println("Identifiers");
                for (Identifier id : prov.getIdentifiers())
                {
                    System.out.printf("\t[%s] %s @ %s - %s\n", id.getId(), id.getIssuer(), id.getState(), id.getDescription());
                }

                System.out.println("Taxanomies");
                for (Taxonomy tax : prov.getTaxanomies())
                {
                    System.out.printf("\t%s(%s) - %s\n", tax.getLicense(), tax.getState(), tax.getDescription());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
