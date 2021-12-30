package com.example.db2.repos;

import com.example.db2.entities.CompetitionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionCategoryRepo extends JpaRepository<CompetitionCategory, Long> {
    List<CompetitionCategory> findAll();
    CompetitionCategory getById(Long id);
}
