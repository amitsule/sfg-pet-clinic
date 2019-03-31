/*
 * Created by User on 31/03/2019
 */

package com.cognitech.sfgpetclinic.services.springdatajpa;

import com.cognitech.sfgpetclinic.model.Speciality;
import com.cognitech.sfgpetclinic.repositories.SpecialtyRepository;
import com.cognitech.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialityService
{
    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository)
    {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll()
    {
        Set<Speciality> specialities = new HashSet<>();
        this.specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong)
    {
        return this.specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality)
    {
        return this.specialtyRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality)
    {
        this.specialtyRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long aLong)
    {
        this.specialtyRepository.deleteById(aLong);
    }
}
