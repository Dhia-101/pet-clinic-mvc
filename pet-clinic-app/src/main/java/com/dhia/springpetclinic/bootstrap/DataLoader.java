package com.dhia.springpetclinic.bootstrap;

import com.dhia.springpetclinic.model.Owner;
import com.dhia.springpetclinic.model.Vet;
import com.dhia.springpetclinic.services.OwnerService;
import com.dhia.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerSerice;
    private final VetService vetService;

    public DataLoader(OwnerService ownerSerice, VetService vetService) {
        this.ownerSerice = ownerSerice;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("firstNameOne");
        owner1.setLastName("lastNameOne");

        Owner owner2 = new Owner();
        owner2.setFirstName("firstNameTwo");
        owner2.setLastName("lastNameTwo");

        ownerSerice.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("firstNameThree");
        owner3.setLastName("lastNameThree");

        ownerSerice.save(owner3);

        System.out.println("Loaded Oweners...");

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
