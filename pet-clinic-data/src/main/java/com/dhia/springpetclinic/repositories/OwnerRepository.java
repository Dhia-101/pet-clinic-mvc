package com.dhia.springpetclinic.repositories;

import com.dhia.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    List<Owner> findAllByLastNameLike(String lastName);

}
