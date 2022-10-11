package com.final_project.staselko.converter.dto;

import com.final_project.staselko.model.dto.UserDto;
import com.final_project.staselko.model.entiti.User;

public interface UserConverter {
    User toUser(UserDto userDto);

    UserDto toUserDto(User user);
}
