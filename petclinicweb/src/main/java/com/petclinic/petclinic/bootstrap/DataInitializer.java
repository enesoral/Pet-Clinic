package com.petclinic.petclinic.bootstrap;

import com.petclinic.petclinic.models.*;
import com.petclinic.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialityService;
    private final VisitService visitService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        PetType bird = new PetType();
        bird.setName("bird");
        PetType saveBirdPetType = petTypeService.save(bird);

        Specialty radiology = new Specialty();
        radiology.setName("Radiology");
        radiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setName("Surgery");
        surgery = specialityService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setName("Dentistry");
        dentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Enes");
        owner1.setLastName("Oral");
        owner1.setAddress("1336 sk. No:4 Gürçeşme");
        owner1.setCity("İzmir");
        owner1.setTelephone("0553 634 52 24");
        Pet enesPet = new Pet();
        enesPet.setPetType(saveCatPetType);
        enesPet.setName("Oreo");
        enesPet.setOwner(owner1);
        enesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(enesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");
        owner2.setAddress("9583 SE. Valley View Street");
        owner2.setCity("Olympia");
        owner2.setTelephone("1-555-3010-050");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setName("Rosco");
        mikesPet.setOwner(owner2);
        mikesPet.setBirthDate(LocalDate.now());
        Pet mikesPet2 = new Pet();
        mikesPet2.setPetType(saveDogPetType);
        mikesPet2.setName("Golden");
        mikesPet2.setOwner(owner2);
        mikesPet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(mikesPet);
        owner2.getPets().add(mikesPet2);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Jonathan");
        owner3.setLastName("Rodd");
        owner3.setAddress("1101 Independence Ave SE");
        owner3.setCity("San Franciso");
        owner3.setTelephone("1-555-9748-915");
        Pet jonathanPet = new Pet();
        jonathanPet.setPetType(saveBirdPetType);
        jonathanPet.setName("Angel");
        jonathanPet.setOwner(owner3);
        jonathanPet.setBirthDate(LocalDate.now());
        owner3.getPets().add(jonathanPet);

        ownerService.save(owner3);

        Visit enesPetVisit = new Visit();
        enesPetVisit.setPet(enesPet);
        enesPetVisit.setDate(LocalDate.now());
        enesPetVisit.setDescription("Sneezy Kitty");

        visitService.save(enesPetVisit);

        Visit mikesPetVisit = new Visit();
        mikesPetVisit.setPet(mikesPet);
        mikesPetVisit.setDate(LocalDate.now());
        mikesPetVisit.setDescription("Sneezy Doggy");

        visitService.save(mikesPetVisit);


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgery);
        vet2.getSpecialities().add(dentistry);

        vetService.save(vet2);
    }
}
