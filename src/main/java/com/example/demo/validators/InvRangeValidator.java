package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InvRangeValidator
        implements ConstraintValidator<ValidInvRange, Part> {

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part == null) return true;

        int min = part.getMinInv();
        int max = part.getMaxInv();
        int inv = part.getInv();

        //custom messages
        context.disableDefaultConstraintViolation();

        //min must be <= Max
        if (min > max) {
            context.buildConstraintViolationWithTemplate("Min Inventory cannot be > Max Inventory.")
                    .addPropertyNode("minInv")
                    .addConstraintViolation();
            return false;
        }

        // inv too low
        if (inv < min) {
            context.buildConstraintViolationWithTemplate("Inventory is below the minimum allowed (" + min + ").")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
            return false;
        }
        // inv too  high
        if (inv > max) {
            context.buildConstraintViolationWithTemplate("Inventory exceeds the maximum allowed (" + max + ").")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

}
