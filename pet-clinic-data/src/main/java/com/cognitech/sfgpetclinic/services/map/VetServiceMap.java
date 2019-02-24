/*
 * Created by User on 10/02/2019
 */

package com.cognitech.sfgpetclinic.services.map;

import com.cognitech.sfgpetclinic.model.Speciality;
import com.cognitech.sfgpetclinic.model.Vet;
import com.cognitech.sfgpetclinic.services.SpecialityService;
import com.cognitech.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService
{
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService)
    {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll()
    {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet)
    {
        if (vet != null)
        {
            if (vet.getSpecialities() != null)
            {
                vet.getSpecialities().forEach(speciality ->
                {
                    if (speciality.getId() == null)
                    {
                        Speciality savedSpecialty = this.specialityService.save(speciality);
                        speciality.setId(savedSpecialty.getId());
                    }
                });
            }
            return super.save(vet);
        }
        else
        {
            return null;
        }
    }

    @Override
    public void delete(Vet vet)
    {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
