package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.Category;

import java.util.Optional;

public interface CategoryDao {
    Optional<Category> findByName(String name);
}
