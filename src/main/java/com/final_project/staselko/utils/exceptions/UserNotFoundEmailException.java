package com.final_project.staselko.utils.exceptions;

import org.springframework.stereotype.Component;


public class UserNotFoundEmailException extends RuntimeException {
    public UserNotFoundEmailException(String email) {
        super("User not found with email: " + email);
    }
}

