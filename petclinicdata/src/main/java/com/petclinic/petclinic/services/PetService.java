package com.petclinic.petclinic.services;

import com.petclinic.petclinic.models.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet Pet);
    Set<Pet> findAll();
}
