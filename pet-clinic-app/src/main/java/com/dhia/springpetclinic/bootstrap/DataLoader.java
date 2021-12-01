package com.dhia.springpetclinic.bootstrap;

import com.dhia.springpetclinic.model.Owner;
import com.dhia.springpetclinic.model.PetType;
import com.dhia.springpetclinic.model.Vet;
import com.dhia.springpetclinic.services.OwnerService;
import com.dhia.springpetclinic.services.PetTypeService;
import com.dhia.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService
    ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = petTypeService.save(new PetType("dog"));
        PetType cat = petTypeService.save(new PetType("cat"));

        Owner owner1 = new Owner();
        owner1.setFirstName("firstNameOne");
        owner1.setLastName("lastNameOne");

        Owner owner2 = new Owner();
        owner2.setFirstName("firstNameTwo");
        owner2.setLastName("lastNameTwo");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("firstNameThree");
        owner3.setLastName("lastNameThree");

        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("vetFirstNameOne");
        vet1.setLastName("vetLastNameOne");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vetFirstNameTwo");
        vet2.setLastName("vetLastNameTwo");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
