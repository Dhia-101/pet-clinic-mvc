package com.dhia.springpetclinic.services.springDataJpa;

import com.dhia.springpetclinic.model.Owner;
import com.dhia.springpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(new Owner(2L));
        returnOwnersSet.add(new Owner(3L));

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        Owner returnedOwner = new Owner();
        returnedOwner.setId(1L);

        when(ownerRepository.findById(any())).thenReturn(java.util.Optional.of(returnedOwner));
        // doReturn(returnedOwner).when(service).findById(any());


        Owner owner = service.findById(1L);

        assertEquals(owner.getId(), 1L);
        verify(ownerRepository).findById(any());
    }

    @Test
    void findByIdUnexistant() {

        when(ownerRepository.findById(any())).thenReturn(java.util.Optional.empty());
        // returns object to the service from repository mock


        Owner owner = service.findById(1L);

        assertNull(owner);
        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner(2L);
        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void delete() {
        service.delete(new Owner());
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(any());

    }
}