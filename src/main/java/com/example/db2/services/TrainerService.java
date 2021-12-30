package com.example.db2.services;

import com.example.db2.entities.Trainer;
import com.example.db2.repos.TrainerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepo trainerRepo;

    public List<Trainer> findAll(){
        return trainerRepo.findAll();
    }

    public Trainer getById(Long id){
        return trainerRepo.getById(id);
    }

    public void addTrainer(Trainer trainer){
        trainerRepo.save(trainer);
    }
}
