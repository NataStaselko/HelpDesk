package com.final_project.staselko.converter.dto.impl;

import com.final_project.staselko.converter.dto.UserConverter;
import com.final_project.staselko.model.dto.UserDto;
import com.final_project.staselko.model.entiti.User;

public class UserConverterImpl implements UserConverter {
    @Override
    public User toUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(user.getPassword());
        return user;
    }

    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirst_name(user.getFirst_name());
        userDto.setLast_name(user.getLast_name());
        userDto.setEmail(user.getEmail());
        userDto.setRole_id(user.getRole_id());
        return userDto;
    }
}
