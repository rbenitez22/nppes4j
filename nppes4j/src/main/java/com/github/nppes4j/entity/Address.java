/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j.entity;

import com.github.nppes4j.AddressPurpose;
import com.github.nppes4j.Country;
import com.github.nppes4j.UsState;
import java.util.Objects;

/**
 *
 * @author Roberto C. Benitez
 */
public class Address
{
    private String line1;
    private String line2;
    private String city;
    private UsState state;
    private String postalCode;
    private Country country;
    
    private String telephoneNumber;
    private String faxNumber;
    private AddressPurpose purpose;

    public Address()
    {
    }

    public String getLine1()
    {
        return line1;
    }

    public void setLine1(String line1)
    {
        this.line1 = line1;
    }

    public String getLine2()
    {
        return line2;
    }

    public void setLine2(String line2)
    {
        this.line2 = line2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public UsState getState()
    {
        return state;
    }

    public void setState(UsState state)
    {
        this.state = state;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public Country getCountry()
    {
        return country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFaxNumber()
    {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber)
    {
        this.faxNumber = faxNumber;
    }

    public AddressPurpose getPurpose()
    {
        return purpose;
    }

    public void setPurpose(AddressPurpose purpose)
    {
        this.purpose = purpose;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.line1);
        hash = 97 * hash + Objects.hashCode(this.line2);
        hash = 97 * hash + Objects.hashCode(this.city);
        hash = 97 * hash + Objects.hashCode(this.state);
        hash = 97 * hash + Objects.hashCode(this.postalCode);
        hash = 97 * hash + Objects.hashCode(this.country);
        hash = 97 * hash + Objects.hashCode(this.telephoneNumber);
        hash = 97 * hash + Objects.hashCode(this.faxNumber);
        hash = 97 * hash + Objects.hashCode(this.purpose);
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.line1, other.line1))
        {
            return false;
        }
        if (!Objects.equals(this.line2, other.line2))
        {
            return false;
        }
        if (!Objects.equals(this.city, other.city))
        {
            return false;
        }
        if (!Objects.equals(this.postalCode, other.postalCode))
        {
            return false;
        }
        if (!Objects.equals(this.telephoneNumber, other.telephoneNumber))
        {
            return false;
        }
        if (!Objects.equals(this.faxNumber, other.faxNumber))
        {
            return false;
        }
        if (this.state != other.state)
        {
            return false;
        }
        if (this.country != other.country)
        {
            return false;
        }
        if (this.purpose != other.purpose)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Address{" + "line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", country=" + country + ", telephoneNumber=" + telephoneNumber + ", faxNumber=" + faxNumber + ", purpose=" + purpose + '}';
    }
    
    
}
