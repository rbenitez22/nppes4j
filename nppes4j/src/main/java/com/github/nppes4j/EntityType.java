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
public enum EntityType
{
    NPI1("Individual Providers","NPI-1"),
    NPI2("Organizational Providers","NPI-2");

    final String description;
    final String nppesName;

    EntityType(String desc,String name)
    {
        description = desc;
        nppesName=name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getNppesName()
    {
        return nppesName;
    }
    
    public static EntityType forNppesName(String name)
    {
        for(EntityType type : values())
        {
            if(type.getNppesName().equals(name)){return type;}
        }
        throw new IllegalArgumentException("No enum constant found " + EntityType.class.getName() + " for NPPES Name " + name);
    }

}
