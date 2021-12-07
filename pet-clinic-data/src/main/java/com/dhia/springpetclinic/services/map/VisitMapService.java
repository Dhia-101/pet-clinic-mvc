package com.dhia.springpetclinic.services.map;

import com.dhia.springpetclinic.model.Visit;
import com.dhia.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
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
        if(visit == null || visit.getPet() == null || visit.getPet().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
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
