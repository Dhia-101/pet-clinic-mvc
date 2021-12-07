package com.dhia.springpetclinic.services.springDataJpa;

import com.dhia.springpetclinic.model.Specialty;
import com.dhia.springpetclinic.repositories.SpecialtyRepository;
import com.dhia.springpetclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPA")
public class SpecialtySDJpaService implements SpecialtiesService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long specialtyId) {
        return specialtyRepository.findById(specialtyId).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialtyId) {
        specialtyRepository.delete(specialtyId);
    }

    @Override
    public void deleteById(Long specialtyId) {
        specialtyRepository.deleteById(specialtyId);
    }
}
