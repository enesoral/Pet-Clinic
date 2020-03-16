package com.petclinic.petclinic.services;

import com.petclinic.petclinic.models.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastName(String lastName);
}