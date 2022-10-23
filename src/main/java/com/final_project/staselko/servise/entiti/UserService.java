package com.final_project.staselko.servise.entiti;

import com.final_project.staselko.model.dto.UserDto;

public interface UserService {
    UserDto getUserByEmail(String email);
}
