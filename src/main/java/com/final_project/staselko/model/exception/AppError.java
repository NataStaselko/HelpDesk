package com.final_project.staselko.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class AppError {
    private  String fieldName;
    private  String message;

    public AppError(String message) {
        this.message = message;
    }

    public AppError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
