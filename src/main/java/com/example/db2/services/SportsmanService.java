package com.example.db2.services;

import com.example.db2.dto.AddSportsmanDto;
import com.example.db2.dto.SportsmenListDto;
import com.example.db2.entities.CompetitionCategory;
import com.example.db2.entities.Sportsman;
import com.example.db2.repos.SportsmanRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportsmanService {
    private final SportsmanRepo sportsmanRepo;
    private final TrainerService trainerService;
    private final CategoryService categoryService;
    private final CompetitionCategoryService competitionCategoryService;

    public List<Sportsman> findAll(){
        return sportsmanRepo.findAll();
    }

    public Sportsman getById(Long id){
        return sportsmanRepo.getById(id);
    }

    public List<Sportsman> findAllByCompetitionCategory(CompetitionCategory competitionCategory){
        return sportsmanRepo.findAllByCompetitionCategory(competitionCategory);
    }

    public void addSportsman(AddSportsmanDto dto){
        Sportsman sportsman = new Sportsman();
        sportsman.setFirstName(dto.getFirstName());
        sportsman.setLastName(dto.getLastName());
        sportsman.setMiddleName(dto.getMiddleName());
        sportsman.setTrainer(trainerService.getById(dto.getTrainerId()));
        sportsman.setCategory(categoryService.getById(dto.getCategoryId()));
        sportsman.setCompetitionCategory(competitionCategoryService.getById(dto.getCompetitionCategoryId()));
        sportsmanRepo.save(sportsman);
    }

    public void editPoints(SportsmenListDto dto){
        dto.getList()
                .forEach((sportsman) -> {
                    Sportsman sportsmanFromDb = getById(sportsman.getId());
                    sportsmanFromDb.setPoints(sportsman.getPoints());
                    sportsmanRepo.save(sportsmanFromDb);
                });
    }
}
