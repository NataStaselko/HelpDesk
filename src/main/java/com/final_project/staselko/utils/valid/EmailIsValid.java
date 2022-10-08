package com.final_project.staselko.utils.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = MailValidator.class)
@Documented
public @interface EmailIsValid {
    String message() default "Please make sure you are using a valid email";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
