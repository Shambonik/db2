package com.example.db2.repos;

import com.example.db2.entities.Jury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuryRepo extends JpaRepository<Jury, Long> {
    List<Jury> findAll();
    Jury getById(Long id);
}
