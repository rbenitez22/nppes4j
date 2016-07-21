/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j;

import javax.json.JsonObject;

/**
 *
 * @author Roberto C. Benitez
 */
public class NppesException extends Exception
{

    /**
     * Creates a new instance of <code>NppeException</code> without detail
     * message.
     */
    public NppesException()
    {
    }

    /**
     * Constructs an instance of <code>NppeException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NppesException(String msg)
    {
        super(msg);
    }
    
    public NppesException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
    
    public NppesException(JsonObject apiErrorNode)
    {
        super(getApiErrorNodeString(apiErrorNode));
    }
    
    public static String getApiErrorNodeString(JsonObject apiErrorNode)
    {
        StringBuilder builder= new StringBuilder();
        for(String key : apiErrorNode.keySet())
        {
            String string="(" + key + ") " + apiErrorNode.getString(key);
            if(builder.length()> 1)
            {
                builder.append(";  ");
            }
            builder.append(string);
        }
        return builder.toString();
    }
}
