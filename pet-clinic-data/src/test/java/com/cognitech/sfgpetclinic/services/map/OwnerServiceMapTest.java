/*
 * Created by User on 27/04/2019
 */

package com.cognitech.sfgpetclinic.services.map;

import com.cognitech.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest
{
    OwnerServiceMap ownerServiceMap;

    final Long OWNER_ID = 1L;
    final String LASTNAME = "Smith";

    @BeforeEach
    void setUp()
    {
        this.ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        this.ownerServiceMap.save(Owner.builder().id(this.OWNER_ID).firstName("Test").lastName(this.LASTNAME).build());
    }

    @Test
    void findAll()
    {
        Set<Owner> ownerSet = this.ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById()
    {
        Owner owner = this.ownerServiceMap.findById(OWNER_ID);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void saveExistingID()
    {
        Long id = 2L;
        Owner newOwner = Owner.builder().id(id).build();
        Owner savedOwner = this.ownerServiceMap.save(newOwner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoID()
    {
        Owner savedOwner = this.ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete()
    {
        this.ownerServiceMap.delete(this.ownerServiceMap.findById(OWNER_ID));
        assertEquals(0, this.ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById()
    {
        this.ownerServiceMap.deleteById(OWNER_ID);
        assertEquals(0, this.ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName()
    {
        Owner newOwner = this.ownerServiceMap.findByLastName(LASTNAME);
        assertNotNull(newOwner);
        assertEquals(OWNER_ID, newOwner.getId());
    }

    @Test
    void findByLastNameNotFound()
    {
        Owner newOwner = this.ownerServiceMap.findByLastName("someone_else");
        assertNull(newOwner);
    }
}