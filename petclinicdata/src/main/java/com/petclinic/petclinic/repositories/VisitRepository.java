package com.petclinic.petclinic.repositories;

import com.petclinic.petclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
