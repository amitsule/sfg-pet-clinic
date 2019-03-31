/*
 * Created by User on 31/03/2019
 */

package com.cognitech.sfgpetclinic.services.springdatajpa;

import com.cognitech.sfgpetclinic.model.PetType;
import com.cognitech.sfgpetclinic.repositories.PetTypeRepository;
import com.cognitech.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService
{
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository)
    {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll()
    {
        Set<PetType> petTypes = new HashSet<>();
        this.petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong)
    {
        return this.petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType petType)
    {
        return this.petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType)
    {
        this.petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long aLong)
    {
        this.petTypeRepository.deleteById(aLong);
    }
}
