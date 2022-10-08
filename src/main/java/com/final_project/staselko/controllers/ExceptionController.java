package com.final_project.staselko.controllers;

import com.final_project.staselko.model.exception.AppError;
import com.final_project.staselko.model.exception.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionController {

   /* @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError catchExceptions(RuntimeException exception) {
        return new AppError("exception", exception.getMessage());
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationError catchValidException(MethodArgumentNotValidException e) {
        final List<AppError> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new AppError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ValidationError(errors);
    }
}
