package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.User;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.Optional;


public interface UserDao {
    Optional<User> getUserByEmail(String value);

    Optional<User> getUserById(Long id);
}
