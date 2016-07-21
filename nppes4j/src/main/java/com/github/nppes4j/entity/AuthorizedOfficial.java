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
public class AuthorizedOfficial
{
    private String prefix;
    private String credential;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String title;
    
    private String telephoneNumber;

    public AuthorizedOfficial()
    {
    }

    public String getCredential()
    {
        return credential;
    }

    public void setCredential(String credential)
    {
        this.credential = credential;
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.prefix);
        hash = 37 * hash + Objects.hashCode(this.credential);
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.middleName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.suffix);
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.telephoneNumber);
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
        final AuthorizedOfficial other = (AuthorizedOfficial) obj;
        if (!Objects.equals(this.prefix, other.prefix))
        {
            return false;
        }
        if (!Objects.equals(this.credential, other.credential))
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
        if (!Objects.equals(this.title, other.title))
        {
            return false;
        }
        if (!Objects.equals(this.telephoneNumber, other.telephoneNumber))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "AuthorizedOfficial{" + "prefix=" + prefix + ", credential=" + credential + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", suffix=" + suffix + ", title=" + title + ", telephoneNumber=" + telephoneNumber + '}';
    }
   
}
