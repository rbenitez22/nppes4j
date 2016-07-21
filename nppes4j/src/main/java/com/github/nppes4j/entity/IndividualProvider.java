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

/**
 *
 * @author Roberto C. Benitez
 */
public class IndividualProvider implements Provider
{
    private long number;
    private final EntityType type=EntityType.NPI1;
    
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String credential;
    private LocalDate enumerationDate;
    private String gender;
    
    private boolean soleProprietor;
    
    private List<Address> addresses;
    private List<Taxonomy> taxanomies;
    private List<Identifier> identifiers;

    public IndividualProvider()
    {
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public boolean isSoleProprietor()
    {
        return soleProprietor;
    }

    public void setSoleProprietor(boolean soleProprietor)
    {
        this.soleProprietor = soleProprietor;
    }

    @Override
    public EntityType getType()
    {
        return type;
    }

    @Override
    public long getNumber()
    {
        return number;
    }

    @Override
    public void setNumber(long number)
    {
        this.number = number;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    public String getCredential()
    {
        return credential;
    }

    public void setCredential(String credential)
    {
        this.credential = credential;
    }

    @Override
    public LocalDate getEnumerationDate()
    {
        return enumerationDate;
    }

    public void setEnumerationDate(LocalDate enumerationDate)
    {
        this.enumerationDate = enumerationDate;
    }

    @Override
    public String getName()
    {
        return String.format("%s, %s",lastName,firstName);
    }

    @Override
    public List<Address> getAddresses()
    {
        return addresses;
    }

    @Override
    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }

    @Override
    public List<Taxonomy> getTaxanomies()
    {
        return taxanomies;
    }

    @Override
    public void setTaxanomies(List<Taxonomy> taxanomies)
    {
        this.taxanomies = taxanomies;
    }

    @Override
    public List<Identifier> getIdentifiers()
    {
        return identifiers;
    }

    @Override
    public void setIdentifiers(List<Identifier> identifiers)
    {
        this.identifiers = identifiers;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 97 * hash + (int) (this.number ^ (this.number >>> 32));
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.prefix);
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.middleName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.suffix);
        hash = 97 * hash + Objects.hashCode(this.credential);
        hash = 97 * hash + Objects.hashCode(this.enumerationDate);
        hash = 97 * hash + Objects.hashCode(this.gender);
        hash = 97 * hash + (this.soleProprietor ? 1 : 0);
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
        final IndividualProvider other = (IndividualProvider) obj;
        if (this.number != other.number)
        {
            return false;
        }
        if (this.soleProprietor != other.soleProprietor)
        {
            return false;
        }
        if (!Objects.equals(this.prefix, other.prefix))
        {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName))
        {
            return false;
        }
        if (!Objects.equals(this.middleName, other.middleName))
        {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName))
        {
            return false;
        }
        if (!Objects.equals(this.suffix, other.suffix))
        {
            return false;
        }
        if (!Objects.equals(this.credential, other.credential))
        {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender))
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
        return "IndividualProvider{" + "number=" + number + ", type=" + type + ", prefix=" + prefix + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", suffix=" + suffix + ", credential=" + credential + ", enumerationDate=" + enumerationDate + ", gender=" + gender + ", soleProprietor=" + soleProprietor + '}';
    }
    
    
}
