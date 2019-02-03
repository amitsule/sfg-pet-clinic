/*
 * Created by User on 02/02/2019
 */

package com.cognitech.sfgpetclinic.model;

/**
 * Class used for type of Pet
 */
public class PetType extends BaseEntity
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
