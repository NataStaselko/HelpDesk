package com.final_project.staselko.utils.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value.indexOf("@") >= 0
                && value.indexOf(".") >= 0
                && !value.startsWith(".")
                && !value.startsWith("@")
                && !value.endsWith(".")
                && !value.endsWith("@")
                && value.length()<=100) {
            return true;
        }
        return false;
    }
}
