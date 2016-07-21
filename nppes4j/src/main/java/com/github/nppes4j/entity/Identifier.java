/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j.entity;

import java.util.Objects;

/**
 *
 * @author Roberto C. Benitez
 */
public class Identifier
{
    private String id;
    private String code;
    private String state;
    private String issuer;
    private String description;

    public Identifier()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getIssuer()
    {
        return issuer;
    }

    public void setIssuer(String issuer)
    {
        this.issuer = issuer;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.code);
        hash = 83 * hash + Objects.hashCode(this.state);
        hash = 83 * hash + Objects.hashCode(this.issuer);
        hash = 83 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Identifier other = (Identifier) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        if (!Objects.equals(this.code, other.code))
        {
            return false;
        }
        if (!Objects.equals(this.state, other.state))
        {
            return false;
        }
        if (!Objects.equals(this.issuer, other.issuer))
        {
            return false;
        }
        if (!Objects.equals(this.description, other.description))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Identifier{" + "id=" + id + ", code=" + code + ", state=" + state + ", issuer=" + issuer + ", description=" + description + '}';
    }
    
    
}
