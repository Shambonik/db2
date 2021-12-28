package com.example.db2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sportsman")
@Getter
@Setter
public class Sportsman extends Person{

    @ManyToOne
    private Trainer trainer;

    @ManyToOne
    private Category category;

    @ManyToOne
    private CompetitionCategory competitionCategory;

    private int points;

}
