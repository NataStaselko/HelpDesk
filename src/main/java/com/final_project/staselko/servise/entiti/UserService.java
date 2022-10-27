package com.final_project.staselko.servise.entiti;

import com.final_project.staselko.model.dto.UserDto;
import com.final_project.staselko.model.entiti.User;

public interface UserService {
    UserDto getUserByEmail(String email);

    User getUserById(Long id);
}
