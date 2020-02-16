package com.petclinic.petclinic.services.springdatajpa;

import com.petclinic.petclinic.models.Owner;
import com.petclinic.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private static final Long ID = 1L;
    private static final String FIRST_NAME = "Enes";
    private static final String LAST_NAME = "Oral";

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ID).firstName(FIRST_NAME).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(Optional.of(owner));
        Owner owner = service.findByLastName(LAST_NAME);
        verify(ownerRepository, times(1)).findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = service.save(owner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(ID)).thenReturn(Optional.of(owner));
        Owner returnedOwner = service.findById(1L);
        verify(ownerRepository, times(1)).findById(ID);
        assertNotNull(returnedOwner);
        assertEquals(ID, returnedOwner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner returnedOwner = service.findById(anyLong());
        verify(ownerRepository, times(1)).findById(anyLong());
        assertNull(returnedOwner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(owner);
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> returnedSet = service.findAll();
        assertEquals(owners.size(), returnedSet.size());
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository).delete(owner);
    }

    @Test
    void deleteById() {
        service.deleteById(ID);
        verify(ownerRepository).deleteById(ID);
    }
}