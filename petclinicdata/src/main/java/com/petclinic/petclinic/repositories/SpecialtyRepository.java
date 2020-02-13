package com.petclinic.petclinic.repositories;

import com.petclinic.petclinic.models.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
