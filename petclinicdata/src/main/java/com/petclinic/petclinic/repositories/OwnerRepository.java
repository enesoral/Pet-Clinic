package com.petclinic.petclinic.repositories;

import com.petclinic.petclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
