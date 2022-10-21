package com.final_project.staselko.controllers.exceptions;

import com.final_project.staselko.model.exception.AppError;
import com.final_project.staselko.model.exception.ValidationError;
import com.final_project.staselko.utils.exceptions.UserNotFoundEmailException;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.NoResultException;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ExceptionController{

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

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError catchValidExceptions(DateTimeParseException exception) {
        return new AppError(exception.getParsedString(), "The date format error");
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppError catchValidExceptions(IllegalArgumentException exception) {
        return new AppError(exception.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppError notFound(RuntimeException exception) {
        return new AppError(exception.getMessage(), "User not found");
    }

}
