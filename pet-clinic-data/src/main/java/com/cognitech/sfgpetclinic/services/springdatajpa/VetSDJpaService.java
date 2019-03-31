/*
 * Created by User on 31/03/2019
 */

package com.cognitech.sfgpetclinic.services.springdatajpa;

import com.cognitech.sfgpetclinic.model.Vet;
import com.cognitech.sfgpetclinic.repositories.VetRepository;
import com.cognitech.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService
{
    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository)
    {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll()
    {
        Set<Vet> vets = new HashSet<>();
        this.vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong)
    {
        return this.vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet vet)
    {
        return this.vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet)
    {
        this.vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long aLong)
    {
        this.vetRepository.deleteById(aLong);
    }
}
