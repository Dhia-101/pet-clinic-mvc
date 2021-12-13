package com.dhia.springpetclinic.services;

import com.dhia.springpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
    List<Owner> findByLastNameLike(String lastName);
}
