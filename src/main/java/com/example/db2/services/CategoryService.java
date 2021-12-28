package com.example.db2.services;

import com.example.db2.entities.Category;
import com.example.db2.repos.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public List<Category> findAll(){
        return categoryRepo.findAll();
    }

    public Category getById(Long id){
        return categoryRepo.getById(id);
    }
}
