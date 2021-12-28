package com.example.db2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "competition_category")
@Getter
@Setter
public class CompetitionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Category category;

    private LocalDateTime dateTime;

    @ManyToMany(mappedBy = "competitionCategories")
    Set<Jury> juries;
}
