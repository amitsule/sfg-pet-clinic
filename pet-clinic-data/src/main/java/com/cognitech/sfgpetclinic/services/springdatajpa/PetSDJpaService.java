/*
 * Created by User on 31/03/2019
 */

package com.cognitech.sfgpetclinic.services.springdatajpa;

import com.cognitech.sfgpetclinic.model.Pet;
import com.cognitech.sfgpetclinic.repositories.PetRepository;
import com.cognitech.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService
{
    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository)
    {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll()
    {
        Set<Pet> pets = new HashSet<>();
        this.petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong)
    {
        return this.petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet pet)
    {
        return this.petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet)
    {
        this.petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long aLong)
    {
        this.petRepository.deleteById(aLong);
    }
}
