package com.dhia.springpetclinic.bootstrap;

import com.dhia.springpetclinic.model.Owner;
import com.dhia.springpetclinic.model.Vet;
import com.dhia.springpetclinic.services.OwnerService;
import com.dhia.springpetclinic.services.VetService;
import com.dhia.springpetclinic.services.map.OwnerMapService;
import com.dhia.springpetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerSerice;
    private final VetService vetService;

    public DataLoader() {
        this.ownerSerice = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("firstNameOne");
        owner1.setLastName("lastNameOne");

        ownerSerice.save(1L, owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("firstNameTwo");
        owner1.setLastName("lastNameTwo");

        ownerSerice.save(2L, owner2);

        System.out.println("Loaded Oweners...");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("vetFirstNameOne");
        vet1.setLastName("vetLastNameOne");

        vetService.save(3L, vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("vetFirstNameTwo");
        vet2.setLastName("vetLastNameTwo");

        vetService.save(4L, vet2);

        System.out.println("Loaded Vets...");
    }
}
