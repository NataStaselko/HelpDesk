package com.final_project.staselko.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AppError {
    private final String fieldName;
    private final String message;
}
