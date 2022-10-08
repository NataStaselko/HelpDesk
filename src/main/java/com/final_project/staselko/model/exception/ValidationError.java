package com.final_project.staselko.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ValidationError {
    private final List<AppError> errors;
}
