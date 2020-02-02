package com.petclinic.petclinic.bootstrap;

import com.petclinic.petclinic.models.Owner;
import com.petclinic.petclinic.models.Vet;
import com.petclinic.petclinic.services.OwnerService;
import com.petclinic.petclinic.services.VetService;
import com.petclinic.petclinic.services.map.OwnerMapService;
import com.petclinic.petclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer() {
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Enes");
        owner1.setLastName("Oral");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Hasan");
        owner2.setFirstName("Oral");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Oreo");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Garip");
        vet2.setLastName("Kont");

        vetService.save(vet2);
    }
}
