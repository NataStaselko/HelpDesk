package com.final_project.staselko.dao.impl;

import com.final_project.staselko.dao.HibernateDao;
import com.final_project.staselko.dao.UserDao;
import com.final_project.staselko.model.entiti.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl extends HibernateDao<User> implements UserDao {

    public UserDaoImpl() {
        setModelClass(User.class);
    }

    @Override
    public Optional<User> getUserByEmail(String value) {
        Optional<User> user = Optional.empty();
        user = Optional.ofNullable(getByStringParam("email", value));
        return user;
    }
}
