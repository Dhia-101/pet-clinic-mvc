package com.dhia.springpetclinic.services.map;

import com.dhia.springpetclinic.model.Vet;
import com.dhia.springpetclinic.services.SpecialtiesService;
import com.dhia.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtiesService specialtiesService;

    public VetMapService(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

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
    public Vet save(Vet vet) {
        if(vet.getSpecialties().size() > 0) {
            vet.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null) {
                    specialty.setId(specialtiesService.save(specialty).getId());
                }
            });
        }

        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
