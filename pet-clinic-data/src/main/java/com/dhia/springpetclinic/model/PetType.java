package com.dhia.springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {

    @Column
    private String name;

    @Override
    public String toString() {
        return name;
    }


}
