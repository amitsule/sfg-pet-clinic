/*
 * Created by User on 02/02/2019
 */

package com.cognitech.sfgpetclinic.model;

public class Person extends BaseEntity
{
    private String firstName;
    private String lastName;

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
}
