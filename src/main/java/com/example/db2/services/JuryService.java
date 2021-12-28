package com.example.db2.services;

import com.example.db2.dto.AddJuryDto;
import com.example.db2.entities.CompetitionCategory;
import com.example.db2.entities.Jury;
import com.example.db2.entities.User;
import com.example.db2.entities.enums.Role;
import com.example.db2.repos.JuryRepo;
import com.example.db2.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JuryService {
    private final JuryRepo juryRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public List<Jury> findAll(){
        return juryRepo.findAll();
    }

    public Jury getById(Long id){
        return juryRepo.getById(id);
    }

    public void addJuryToCompetition(Long id, CompetitionCategory competitionCategory){
        Jury jury = getById(id);
        jury.getCompetitionCategories().add(competitionCategory);
        juryRepo.save(jury);
    }

    public void deleteJuryFromCompetition(Long id, CompetitionCategory competitionCategory){
        Jury jury = getById(id);
        jury.getCompetitionCategories().stream()
                .filter(c -> c.getId() == competitionCategory.getId())
                .forEach(c -> jury.getCompetitionCategories().remove(c));
        juryRepo.save(jury);
    }

    public void addJury(AddJuryDto dto){
        User user = new User();
        Jury jury = new Jury();
        jury.setFirstName(dto.getFirstName());
        jury.setMiddleName(dto.getMiddleName());
        jury.setLastName(dto.getLastName());
        juryRepo.save(jury);
        user.setJury(jury);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.JURY));
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepo.save(user);
    }
}
