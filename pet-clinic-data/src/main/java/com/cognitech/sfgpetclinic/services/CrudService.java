package com.cognitech.sfgpetclinic.services;/*
 * Created by User on 10/02/2019
 */

import java.util.Set;

public interface CrudService<T, ID>
{
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    T deleteById(ID id);
}
