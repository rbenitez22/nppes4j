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
public enum UsState
{
    AA("ARMED FORCES AMERICAS"),
    AE("ARMED FORCES EUROPE / CANADA / MIDDLE EAST /  AFRICA"),
    AK("ALASKA"),
    AL("ALABAMA"),
    AP("ARMED FORCES PACIFIC"),
    AR("ARKANSAS"),
    AS("AMERICAN SAMOA"),
    AZ("ARIZONA"),
    CA("CALIFORNIA"),
    CO("COLORADO"),
    CT("CONNECTICUT"),
    DC("DISTRICT OF COLUMBIA"),
    DE("DELAWARE"),
    FL("FLORIDA"),
    FM("FEDERATED STATES OF MICRONESIA"),
    GA("GEORGIA"),
    GU("GUAM"),
    HI("HAWAII"),
    IA("IOWA"),
    ID("IDAHO"),
    IL("ILLINOIS"),
    IN("INDIANA"),
    KS("KANSAS"),
    KY("KENTUCKY"),
    LA("LOUISIANA"),
    MA("MASSACHUSETTS"),
    MD("MARYLAND"),
    ME("MAINE"),
    MH("MARSHALL ISLANDS"),
    MI("MICHIGAN"),
    MN("MINNESOTA"),
    MO("MISSOURI"),
    MP("MARIANA ISLANDS, NORTHERN"),
    MS("MISSISSIPPI"),
    MT("MONTANA"),
    NC("NORTH CAROLINA"),
    ND("NORTH DAKOTA"),
    NE("NEBRASKA"),
    NH("NEW HAMPSHIRE"),
    NJ("NEW JERSEY"),
    NM("NEW MEXICO"),
    NV("NEVADA"),
    NY("NEW YORK"),
    OH("OHIO"),
    OK("OKLAHOMA"),
    OR("OREGON"),
    PA("PENNSYLVANIA"),
    PR("PUERTO RICO"),
    RI("RHODE ISLAND"),
    SC("SOUTH CAROLINA"),
    SD("SOUTH DAKOTA"),
    TN("TENNESSEE"),
    TX("TEXAS"),
    UT("UTAH"),
    VA("VIRGINIA"),
    VI("VIRGIN ISLANDS"),
    VT("VERMONT"),
    WA("WASHINGTON"),
    WI("WISCONSIN"),
    WV("WEST VIRGINIA"),
    WY("WYOMING");

    
    final String name;
    UsState(String string)
    {
        name=string;
    }

    public String getName()
    {
        return name;
    }
    
}
