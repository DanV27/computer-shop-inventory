package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = InvRangeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInvRange {

    String message() default
            "Inventory must be between Min and Max (and Min must be <= Max)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
