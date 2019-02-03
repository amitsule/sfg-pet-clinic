/*
 * Created by User on 03/02/2019
 */

package com.cognitech.sfgpetclinic.services;

import com.cognitech.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService
{
    Vet  findById(Long id);

    Vet save(Vet Vet);

    Set<Vet> findAll();
}
