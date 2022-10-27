package com.final_project.staselko.servise.entiti.impl;

import com.final_project.staselko.converter.dto.UserConverter;
import com.final_project.staselko.dao.UserDao;
import com.final_project.staselko.model.dto.UserDto;
import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.servise.entiti.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserConverter userConverter;

    @Override
    @Transactional
    public UserDto getUserByEmail(String email) {
        return userConverter.toUserDto(userDao.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("user not found with email: " + email)));
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id: " + id));
    }
}
