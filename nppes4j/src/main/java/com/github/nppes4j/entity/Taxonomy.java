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
public class Taxonomy
{
    private String code;
    private String license;
    private String state;
    private boolean primary;
    private String description;

    public Taxonomy()
    {
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getLicense()
    {
        return license;
    }

    public void setLicense(String license)
    {
        this.license = license;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public boolean isPrimary()
    {
        return primary;
    }

    public void setPrimary(boolean primary)
    {
        this.primary = primary;
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
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.code);
        hash = 29 * hash + Objects.hashCode(this.license);
        hash = 29 * hash + Objects.hashCode(this.state);
        hash = 29 * hash + (this.primary ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.description);
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
        final Taxonomy other = (Taxonomy) obj;
        if (this.primary != other.primary)
        {
            return false;
        }
        if (!Objects.equals(this.code, other.code))
        {
            return false;
        }
        if (!Objects.equals(this.license, other.license))
        {
            return false;
        }
        if (!Objects.equals(this.state, other.state))
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
        return "Taxonomy{" + "code=" + code + ", license=" + license + ", state=" + state + ", primary=" + primary + ", description=" + description + '}';
    }
    
}
