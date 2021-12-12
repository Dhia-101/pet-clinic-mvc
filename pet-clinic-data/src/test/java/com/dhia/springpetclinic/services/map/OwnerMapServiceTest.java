package com.dhia.springpetclinic.services.map;

import com.dhia.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(1L);
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Owner owner = ownerMapService.findById(1L);
        System.out.println(owner.getId());
        assertEquals(1L, owner.getId());
    }

    @Test
    void saveWithId() {
        Owner owner = new Owner();
        owner.setId(2L);
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveWithoutId() {
        Owner owner = new Owner();
        Owner savedOwner = ownerMapService.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertNull(ownerMapService.findById(1L));
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(1L));

        assertNull(ownerMapService.findById(1L));
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1L);

        assertNotNull(owner);
        assertEquals(1L, owner.getId());

    }


}