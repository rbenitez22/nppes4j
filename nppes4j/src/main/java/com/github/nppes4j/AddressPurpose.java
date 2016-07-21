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
public enum AddressPurpose
{
    LOCATION,MAILING,OTHER;
    
    public static AddressPurpose safeValueOf(String name)
    {
        try
        {
            return AddressPurpose.valueOf(name);
        }
        catch(IllegalArgumentException e)
        {
            return OTHER;
        }
    }
}
