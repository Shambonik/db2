package com.example.db2.repos;

import com.example.db2.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {
    List<Trainer> findAll();
}
