/*
 * Created by User on 10/02/2019
 */

package com.cognitech.sfgpetclinic.services.map;

import com.cognitech.sfgpetclinic.model.Pet;
import com.cognitech.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService
{
    @Override
    public Set<Pet> findAll()
    {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet)
    {
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet)
    {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
