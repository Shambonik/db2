package com.example.db2.services;

import com.example.db2.dto.AddCompetitionDto;
import com.example.db2.dto.AddCompetitionJuryDto;
import com.example.db2.entities.CompetitionCategory;
import com.example.db2.entities.Jury;
import com.example.db2.repos.CompetitionCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionCategoryService {
    private final CompetitionCategoryRepo competitionCategoryRepo;
    private final CategoryService categoryService;
    private final JuryService juryService;

    public List<CompetitionCategory> findAll(){
        return competitionCategoryRepo.findAll();
    }

    public CompetitionCategory getById(Long id){
        return competitionCategoryRepo.getById(id);
    }

    public void addCompetitionCategory(AddCompetitionDto dto){
        CompetitionCategory competitionCategory = new CompetitionCategory();
        competitionCategory.setDateTime(LocalDateTime.parse(dto.getDateTime()));
        competitionCategory.setCategory(categoryService.getById(dto.getCategoryId()));
        competitionCategoryRepo.save(competitionCategory);
    }

    public void addJury(Long id, AddCompetitionJuryDto dto){
        CompetitionCategory competitionCategory = getById(id);
        juryService.addJuryToCompetition(dto.getJuryId(), competitionCategory);
    }

    public void deleteJury(long competitionId, long juryId){
        CompetitionCategory competitionCategory = getById(competitionId);
        juryService.deleteJuryFromCompetition(juryId, competitionCategory);
    }
}
