package com.final_project.staselko.servise.impl;

import com.final_project.staselko.converter.dto.UserConverter;
import com.final_project.staselko.dao.UserDao;
import com.final_project.staselko.model.dto.UserDto;
import com.final_project.staselko.servise.UserService;
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
    public UserDto getUserByEmail(String email) {
        return userConverter.toUserDto(userDao.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException(email)));
    }
}
