/*
 * Created by User on 30/03/2019
 */

package com.cognitech.sfgpetclinic.repositories;

import com.cognitech.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long>
{
}
