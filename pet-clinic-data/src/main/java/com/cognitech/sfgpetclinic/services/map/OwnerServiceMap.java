/*
 * Created by User on 10/02/2019
 */

package com.cognitech.sfgpetclinic.services.map;

import com.cognitech.sfgpetclinic.model.Owner;
import com.cognitech.sfgpetclinic.model.Pet;
import com.cognitech.sfgpetclinic.services.OwnerService;
import com.cognitech.sfgpetclinic.services.PetService;
import com.cognitech.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService
{
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService)
    {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll()
    {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner)
    {
        if (owner != null)
        {
            if (owner.getPets() != null)
            {
                owner.getPets().forEach(pet ->
                {
                    if (pet.getPetType() != null)
                    {
                        if (pet.getPetType().getId() == null)
                        {
                            pet.setPetType(this.petTypeService.save(pet.getPetType()));
                        }
                    }
                    else
                    {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null)
                    {
                        Pet savedPet = this.petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        }
        else
        {
            return null;
        }
    }

    @Override
    public void delete(Owner owner)
    {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }

    @Override
    // TODO: 17/02/2019
    public Owner findByLastName(String lastName)
    {
        return null;
    }
}
