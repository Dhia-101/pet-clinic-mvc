package com.dhia.springpetclinic.services.map;

import com.dhia.springpetclinic.model.Vet;
import com.dhia.springpetclinic.services.CrudService;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Long id, Vet vet) {
        return super.save(id, vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
