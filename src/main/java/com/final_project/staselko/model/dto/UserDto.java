package com.final_project.staselko.model.dto;

import com.final_project.staselko.model.enums.Role;
import com.final_project.staselko.utils.annotations.EmailValid;
import com.final_project.staselko.utils.annotations.PasswordValid;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {

    private Long id;

    @NotEmpty(message = "the first_name cannot be empty")
    private String first_name;

    @NotEmpty(message = "the last_name cannot be empty")
    private String last_name;

    @NotEmpty(message = "the role cannot be empty")
    private Role role_id;

    @EmailValid
    private String email;

    @PasswordValid
    private String password;
}
