package com.example.db2.repos;

import com.example.db2.entities.CompetitionCategory;
import com.example.db2.entities.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsmanRepo extends JpaRepository<Sportsman, Long> {
    List<Sportsman> findAll();
    Sportsman getById(Long id);
    List<Sportsman> findAllByCompetitionCategory(CompetitionCategory competitionCategory);
}
