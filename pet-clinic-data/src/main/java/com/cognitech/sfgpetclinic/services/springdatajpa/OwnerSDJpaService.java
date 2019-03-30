/*
 * Created by User on 30/03/2019
 */

package com.cognitech.sfgpetclinic.services.springdatajpa;

import com.cognitech.sfgpetclinic.model.Owner;
import com.cognitech.sfgpetclinic.repositories.OwnerRepository;
import com.cognitech.sfgpetclinic.repositories.PetRepository;
import com.cognitech.sfgpetclinic.repositories.PetTypeRepository;
import com.cognitech.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService
{
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository)
    {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName)
    {
        return this.ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll()
    {
        Set<Owner> owners = new HashSet<>();
        this.ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong)
    {
        return this.ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner owner)
    {
        return this.ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner)
    {
        this.ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long aLong)
    {
        this.ownerRepository.deleteById(aLong);
    }
}
