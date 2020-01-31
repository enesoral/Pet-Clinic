package com.petclinic.petclinic.services.map;

import com.petclinic.petclinic.models.Person;
import com.petclinic.petclinic.services.CrudService;

import java.util.Set;

public class PersonMapService extends AbstractMapService<Person, Long> implements CrudService<Person, Long> {
    @Override
    public Person save(Person object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Person findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Person> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Person object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}