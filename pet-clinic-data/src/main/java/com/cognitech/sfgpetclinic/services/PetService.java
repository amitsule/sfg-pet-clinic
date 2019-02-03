/*
 * Created by User on 03/02/2019
 */

package com.cognitech.sfgpetclinic.services;

import com.cognitech.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService
{
    Pet  findById(Long id);

    Pet save(Pet Pet);

    Set<Pet> findAll();
}
