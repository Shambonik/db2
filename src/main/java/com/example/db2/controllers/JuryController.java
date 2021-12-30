package com.example.db2.controllers;

import com.example.db2.dto.SportsmenListDto;
import com.example.db2.entities.CompetitionCategory;
import com.example.db2.entities.User;
import com.example.db2.services.CompetitionCategoryService;
import com.example.db2.services.JuryService;
import com.example.db2.services.SportsmanService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jury")
@RequiredArgsConstructor
public class JuryController {
    private final JuryService juryService;
    private final CompetitionCategoryService competitionCategoryService;
    private final SportsmanService sportsmanService;

    @GetMapping
    public String getCompetitionsPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("jury", juryService.getById(user.getJury().getId()));
        return "jury/competitions";
    }

    @GetMapping("/competition/{id}/edit_points")
    public String getEditPointsPage(@PathVariable("id") long id, Model model){
        CompetitionCategory competitionCategory = competitionCategoryService.getById(id);
        model.addAttribute("competition", competitionCategory);
        model.addAttribute("sportsmen", new SportsmenListDto(sportsmanService.findAllByCompetitionCategory(competitionCategory)));
        return "jury/edit_points";
    }

    @PutMapping("/edit_points")
    public String editPoints(SportsmenListDto dto){
        sportsmanService.editPoints(dto);
        return "redirect:/jury";
    }

}
