package com.petclinic.petclinic.services;

import com.petclinic.petclinic.models.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet Vet);
    Set<Vet> findAll();
}
