package com.dhia.springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visit")
public class Visit extends BaseEntity {

    @Column(name = "visit_date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
