package com.dhia.springpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {
    private PetType type;
    private Owner owner;
    private String name;
    private LocalDate birthdate;

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
