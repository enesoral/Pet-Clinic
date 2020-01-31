package com.petclinic.petclinic.services;

import com.petclinic.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}