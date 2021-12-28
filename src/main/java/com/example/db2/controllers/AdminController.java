package com.example.db2.controllers;

import com.example.db2.dto.AddCompetitionDto;
import com.example.db2.dto.AddCompetitionJuryDto;
import com.example.db2.dto.AddJuryDto;
import com.example.db2.entities.Trainer;
import com.example.db2.services.CategoryService;
import com.example.db2.services.CompetitionCategoryService;
import com.example.db2.services.JuryService;
import com.example.db2.services.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final TrainerService trainerService;
    private final CompetitionCategoryService competitionCategoryService;
    private final CategoryService categoryService;
    private final JuryService juryService;

    @GetMapping("/trainers")
    public String getTrainersPage(Model model){
        model.addAttribute("list", trainerService.findAll());
        return "admin/trainers";
    }

    @GetMapping("/add_trainer")
    public String getAddTrainerPage(Model model){
        model.addAttribute("trainer", new Trainer());
        return "admin/add_trainer";
    }

    @PostMapping("/add_trainer")
    public String addTrainer(Trainer trainer){
        trainerService.addTrainer(trainer);
        return "redirect:/admin/trainers";
    }

    @GetMapping("/competitions")
    public String getCompetitionsPage(Model model){
        model.addAttribute("list", competitionCategoryService.findAll());
        return "admin/competitions";
    }

    @GetMapping("/add_competition")
    public String getAddCompetitionPage(Model model){
        model.addAttribute("competition", new AddCompetitionDto());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/add_competition";
    }

    @PostMapping("/add_competition")
    public String addCompetition(AddCompetitionDto dto){
        competitionCategoryService.addCompetitionCategory(dto);
        return "redirect:/admin/competitions";
    }

    @GetMapping("/juries")
    public String getJuriesPage(Model model){
        model.addAttribute("list", juryService.findAll());
        return "admin/juries";
    }

    @GetMapping("/add_jury")
    public String getAddJuryPage(Model model){
        model.addAttribute("jury", new AddJuryDto());
        return "admin/add_jury";
    }

    @PostMapping("/add_jury")
    public String addJury(AddJuryDto dto){
        juryService.addJury(dto);
        return "redirect:/admin/juries";
    }

    @GetMapping("/competition/{id}/edit_jury")
    public String getCompetitionJuriesPage(@PathVariable("id") long id, Model model){
        model.addAttribute("competition", competitionCategoryService.getById(id));
        model.addAttribute("add_competition_jury", new AddCompetitionJuryDto());
        model.addAttribute("juries", juryService.findAll());
        return "admin/competition_juries";
    }

    @PutMapping("/competition/{id}/add_jury")
    public String addCompetitionJury(@PathVariable("id") long id, AddCompetitionJuryDto dto){
        competitionCategoryService.addJury(id, dto);
        return "redirect:/admin/competition/"+id+"/edit_jury";
    }


    @DeleteMapping("/competition/{id}/delete_jury/{juryId}")
    public String deleteCompetitionJury(@PathVariable("id") long competitionId, @PathVariable("juryId") long juryId){
        competitionCategoryService.deleteJury(competitionId, juryId);
        return "redirect:/admin/competition/"+competitionId+"/edit_jury";
    }
}
