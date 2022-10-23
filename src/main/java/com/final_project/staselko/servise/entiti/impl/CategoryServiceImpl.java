package com.final_project.staselko.servise.entiti.impl;

import com.final_project.staselko.dao.CategoryDao;
import com.final_project.staselko.model.entiti.Category;
import com.final_project.staselko.servise.entiti.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryDao categoryDao;

    @Override
    @Transactional
    public Category findByName(String name) {

        return categoryDao.findByName(name).
                orElseThrow(() -> new RuntimeException("Category: " + name + " not found"));
    }
}

