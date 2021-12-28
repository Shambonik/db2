package com.example.db2.repos;

import com.example.db2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Category getById(Long id);
}
