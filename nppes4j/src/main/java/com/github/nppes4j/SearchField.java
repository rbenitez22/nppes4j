/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j;

/**
 *
 * @author Roberto C. Benitez
 */
public enum SearchField
{
    NUMBER("number"),
    TYPE("enumeration_type"),
    TAXONOMY("taxonomy_description"),
    PROVIDER_FIRST_NAME("first_name"),
    PROVIDER_LAST_NAME("last_name"),
    ORGANIZATION_NAME("organization_name"),
    ADDRESS_PURPOSE("address_purpose"),
    CITY("city"),
    STATE("state"),
    POSTAL_CODE("postal_code"),
    COUNTRY_CODE("country_code"),
    RESULT_LIMIT("limit"),
    SKIP_COUNT("skip"),
    PRETTY_PRINT("pretty");
    
    final String fieldName;
    
    SearchField(String name)
    {
        fieldName=name;
    }

    public String getFieldName()
    {
        return fieldName;
    }
    
    
}
