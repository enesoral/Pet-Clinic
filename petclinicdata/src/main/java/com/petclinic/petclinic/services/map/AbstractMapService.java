package com.petclinic.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    T findById(ID id) {
        return map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}