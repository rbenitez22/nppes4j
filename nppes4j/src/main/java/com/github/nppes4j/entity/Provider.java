/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.nppes4j.entity;

import com.github.nppes4j.EntityType;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Roberto C. Benitez
 */
public interface Provider
{
    public long getNumber();
    public void setNumber(long number);
    public String getName();
    public EntityType getType();
    public LocalDate getEnumerationDate();
    
    public List<Address> getAddresses();
    public void setAddresses(List<Address> addresses);
    public List<Identifier> getIdentifiers();
    public void setIdentifiers(List<Identifier> identifiers);
    public List<Taxonomy> getTaxanomies();
    public void setTaxanomies(List<Taxonomy> taxonomies);
    
}
