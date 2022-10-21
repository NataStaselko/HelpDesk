package com.final_project.staselko.utils.exceptions;


public class UserNotFoundEmailException extends RuntimeException {
    public UserNotFoundEmailException(String email) {
        super("User not found with email: " + email);
    }
}

