package com.final_project.staselko.utils.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MailValidator implements ConstraintValidator<EmailIsValid, String> {
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
