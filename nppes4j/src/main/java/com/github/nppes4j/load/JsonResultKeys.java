/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j.load;

/**
 *
 * @author Roberto C. Benitez
 */
public enum JsonResultKeys
{
    ERRORS("Errors"),
    RESULT_COUNT,
    RESULTS,
    ADDRESSES,
    BASIC,
    ENUMERATION_TYPE,
    IDENTIFIERS,
    NUMBER,
    TAXONOMIES;
    
    final String nppesName;

    JsonResultKeys(String nppesName)
    {
        this.nppesName = nppesName;
    }

    private JsonResultKeys()
    {
        this.nppesName = name().toLowerCase();
    }

    public String getNppesName()
    {
        return nppesName;
    }
    
    public String getLowerCaseName()
    {
        return this.name().toLowerCase();
    }
    
}
