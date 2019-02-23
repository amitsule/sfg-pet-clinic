/*
 * Created by User on 02/02/2019
 */

package com.cognitech.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person
{
    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities()
    {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities)
    {
        this.specialities = specialities;
    }
}
