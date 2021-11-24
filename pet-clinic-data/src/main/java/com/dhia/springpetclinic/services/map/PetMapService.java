package com.dhia.springpetclinic.services.map;

import com.dhia.springpetclinic.model.Pet;
import com.dhia.springpetclinic.services.CrudService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet save(Long id, Pet pet) {
        return super.save(id, pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
