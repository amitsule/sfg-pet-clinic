/*
 * Created by User on 10/02/2019
 */

package com.cognitech.sfgpetclinic.services.map;

import com.cognitech.sfgpetclinic.model.Owner;
import com.cognitech.sfgpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService
{
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
        return super.save(owner.getId(), owner);
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
