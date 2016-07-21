/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j.entity;

import com.github.nppes4j.EntityType;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class OrganizationalProvider implements Provider
{
    private final EntityType type;
    
     private long number;
    
    private String status;
    private String name;
    private boolean organiationalSubpart;
    private LocalDate enumerationDate;
    
    private List<Address> addresses;
    private List<Taxonomy> taxanomies;
    private List<Identifier> identifiers;
    
    private AuthorizedOfficial authorizedOfficial;

    public OrganizationalProvider()
    {
        type=EntityType.NPI2;
    }

    public AuthorizedOfficial getAuthorizedOfficial()
    {
        return authorizedOfficial;
    }

    public void setAuthorizedOfficial(AuthorizedOfficial authorizedOfficial)
    {
        this.authorizedOfficial = authorizedOfficial;
    }

    @Override
    public long getNumber()
    {
        return number;
    }

    @Override
    public void setNumber(long number)
    {
        this.number=number;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEnumerationDate(LocalDate enumerationDate)
    {
        this.enumerationDate = enumerationDate;
    }
    
    @Override
    public EntityType getType()
    {
        return type;
    }

    @Override
    public LocalDate getEnumerationDate()
    {
        return enumerationDate;
    }

    @Override
    public List<Address> getAddresses()
    {
        return addresses;
    }

    @Override
    public List<Identifier> getIdentifiers()
    {
        return identifiers;
    }

    @Override
    public List<Taxonomy> getTaxanomies()
    {
        return taxanomies;
    }

    @Override
    public void setAddresses(List<Address> addresses)
    {
        this.addresses=addresses;
    }

    @Override
    public void setIdentifiers(List<Identifier> identifiers)
    {
        this.identifiers=identifiers;
    }

    @Override
    public void setTaxanomies(List<Taxonomy> taxonomies)
    {
        this.taxanomies=taxonomies;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isOrganiationalSubpart()
    {
        return organiationalSubpart;
    }

    public void setOrganiationalSubpart(boolean organiationalSubpart)
    {
        this.organiationalSubpart = organiationalSubpart;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + (int) (this.number ^ (this.number >>> 32));
        hash = 97 * hash + Objects.hashCode(this.status);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + (this.organiationalSubpart ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.enumerationDate);
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
        final OrganizationalProvider other = (OrganizationalProvider) obj;
        if (this.number != other.number)
        {
            return false;
        }
        if (this.organiationalSubpart != other.organiationalSubpart)
        {
            return false;
        }
        if (!Objects.equals(this.status, other.status))
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (this.type != other.type)
        {
            return false;
        }
        if (!Objects.equals(this.enumerationDate, other.enumerationDate))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "OrganizationalProvider{" + "type=" + type + ", number=" + number + ", status=" + status + ", name=" + name + ", organiationalSubpart=" + organiationalSubpart + ", enumerationDate=" + enumerationDate + '}';
    }
    
    
}
