package com.example.db2.repos;

import com.example.db2.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Long> {
    List<Trainer> findAll();
    Trainer getById(Long id);
}
