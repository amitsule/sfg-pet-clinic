/*
 * Created by User on 03/02/2019
 */

package com.cognitech.sfgpetclinic.services;

import com.cognitech.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
    Owner findByLastName(String lastName);
}
