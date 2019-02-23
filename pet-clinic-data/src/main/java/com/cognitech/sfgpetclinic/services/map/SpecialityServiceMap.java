/*
 * Created by User on 23/02/2019
 */

package com.cognitech.sfgpetclinic.services.map;

import com.cognitech.sfgpetclinic.model.Speciality;
import com.cognitech.sfgpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService
{
    @Override
    public Set<Speciality> findAll()
    {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality)
    {
        super.delete(speciality);
    }

    @Override
    public Speciality save(Speciality speciality)
    {
        return super.save(speciality);
    }

    @Override
    public Speciality findById(Long id)
    {
        return super.findById(id);
    }
}
