package com.final_project.staselko.dao.impl;

import com.final_project.staselko.dao.CategoryDao;
import com.final_project.staselko.dao.HibernateDao;
import com.final_project.staselko.model.entiti.Category;
import com.final_project.staselko.model.entiti.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryDaoImpl extends HibernateDao<Category> implements CategoryDao {

    public CategoryDaoImpl() {
        setModelClass(Category.class);
    }

    @Override
    public Optional<Category> findByName(String name) {
        Optional<Category> category = Optional.empty();
        category = Optional.ofNullable(getByParam("name", name));
        return category;
    }
}
