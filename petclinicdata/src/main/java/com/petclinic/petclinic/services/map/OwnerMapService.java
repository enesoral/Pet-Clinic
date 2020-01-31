package com.petclinic.petclinic.services.map;

import com.petclinic.petclinic.models.Owner;
import com.petclinic.petclinic.services.CrudService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}