package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.User;

import javax.persistence.criteria.Expression;


public interface UserDao {
    User getUserByName();

}
