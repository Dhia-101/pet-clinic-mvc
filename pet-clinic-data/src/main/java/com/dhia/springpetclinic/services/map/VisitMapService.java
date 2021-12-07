package com.dhia.springpetclinic.services.map;

import com.dhia.springpetclinic.model.Visit;
import com.dhia.springpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long visitId) {
        super.deleteById(visitId);
    }

    @Override
    public Visit save(Visit visit) {
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit findById(Long visitId) {
        return super.findById(visitId);
    }
}
