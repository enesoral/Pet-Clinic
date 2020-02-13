package com.petclinic.petclinic.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(columnDefinition = "vet_id"),
            inverseJoinColumns = @JoinColumn(columnDefinition = "specialty_id"))
    private Set<Specialty> specialities;

    public Set<Specialty> getSpecialities() {
        if (this.specialities == null) {
            specialities = new HashSet<>();
        }
        return specialities;
    }

    public void setSpecialities(Set<Specialty> specialities) {
        this.specialities = specialities;
    }
}
