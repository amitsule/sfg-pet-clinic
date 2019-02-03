/*
 * Created by User on 03/02/2019
 */

package com.cognitech.sfgpetclinic.services;

import com.cognitech.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService
{
    Owner findByLastName(String lastName);

    Owner  findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
