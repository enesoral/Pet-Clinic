package com.petclinic.petclinic.repositories;

import com.petclinic.petclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
