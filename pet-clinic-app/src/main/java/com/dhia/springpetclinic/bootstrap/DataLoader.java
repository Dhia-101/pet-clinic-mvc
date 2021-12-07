package com.dhia.springpetclinic.bootstrap;

import com.dhia.springpetclinic.model.*;
import com.dhia.springpetclinic.services.OwnerService;
import com.dhia.springpetclinic.services.PetTypeService;
import com.dhia.springpetclinic.services.SpecialtiesService;
import com.dhia.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialtiesService specialtiesService
    ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        // check if data already loaded
        // optimise code logic
        if(vetService.findAll().size() == 0) {
            LoadData();
        }

    }

    private void LoadData() {
        PetType dog = petTypeService.save(new PetType("dog"));
        PetType cat = petTypeService.save(new PetType("cat"));

        Owner owner1 = new Owner();
        owner1.setFirstName("firstNameOne");
        owner1.setLastName("lastNameOne");
        owner1.setAddress("address 1");
        owner1.setCity("city 1");
        owner1.setTelephone("12345678");

        Pet pet1 = new Pet();
        pet1.setType(dog);
        pet1.setName("pet one");
        pet1.setOwner(owner1);
        pet1.setBirthdate(LocalDate.now());

        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setFirstName("firstNameTwo");
        owner2.setLastName("lastNameTwo");
        owner2.setAddress("address 2");
        owner2.setCity("city 2");
        owner2.setTelephone("87654321");

        Pet pet2 = new Pet();
        pet2.setType(cat);
        pet2.setName("pet two");
        pet2.setOwner(owner2);
        pet2.setBirthdate(LocalDate.now());

        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("firstNameThree");
        owner3.setLastName("lastNameThree");

        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        // specialties
        Specialty radiologie = specialtiesService.save(new Specialty("radiologie"));


        Specialty dentist = specialtiesService.save(new Specialty("dentist"));

        // vets
        Vet vet1 = new Vet();
        vet1.setFirstName("vetFirstNameOne");
        vet1.setLastName("vetLastNameOne");

        vet1.getSpecialties().add(radiologie);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vetFirstNameTwo");
        vet2.setLastName("vetLastNameTwo");

        vet2.getSpecialties().add(dentist);

        vetService.save(vet2);

        // visits
        Visit visitOne = new Visit();
        visitOne.setDate(LocalDate.now());
        visitOne.setPet(pet1);
        visitOne.setDescription("description visit One");

        System.out.println("Loaded Vets...");
    }
}
