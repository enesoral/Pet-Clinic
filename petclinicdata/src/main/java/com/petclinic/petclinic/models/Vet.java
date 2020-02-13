package com.petclinic.petclinic.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(columnDefinition = "vet_id"),
            inverseJoinColumns = @JoinColumn(columnDefinition = "specialty_id"))
    private Set<Specialty> specialities = new HashSet<>();
}