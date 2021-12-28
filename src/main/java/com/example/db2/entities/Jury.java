package com.example.db2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "jury")
@Getter
@Setter
public class Jury extends Person{
    @ManyToMany
    @JoinTable(
            name = "jury_competition_category",
            joinColumns = @JoinColumn(name = "jury_id"),
            inverseJoinColumns = @JoinColumn(name = "competition_category_id"))
    Set<CompetitionCategory> competitionCategories;
}
