package com.example.db2.repos;

import com.example.db2.entities.CompetitionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionCategoryRepo extends JpaRepository<CompetitionCategory, Long> {
    List<CompetitionCategory> findAll();
    CompetitionCategory getById(Long id);
}
