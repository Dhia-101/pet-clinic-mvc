package com.dhia.springpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private PetType type;

    @Column(name = "owner")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

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

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}
