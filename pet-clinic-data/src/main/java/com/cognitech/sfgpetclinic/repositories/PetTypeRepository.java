/*
 * Created by User on 30/03/2019
 */

package com.cognitech.sfgpetclinic.repositories;

import com.cognitech.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long>
{
}
