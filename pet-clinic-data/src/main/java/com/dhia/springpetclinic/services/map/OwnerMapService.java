package com.dhia.springpetclinic.services.map;

import com.dhia.springpetclinic.model.Owner;
import com.dhia.springpetclinic.model.Pet;
import com.dhia.springpetclinic.services.OwnerService;
import com.dhia.springpetclinic.services.PetService;
import com.dhia.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null && owner.getPets() != null) {
            owner.getPets().forEach(pet -> {
                if( pet.getType() != null) {
                    if( pet.getType().getId() == null ){
                        pet.setType(petTypeService.save(pet.getType()));
                    }
                } else {
                    throw new RuntimeException("Pet Type is required");
                }
                if(pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
        return super.save(owner);
    }
}
