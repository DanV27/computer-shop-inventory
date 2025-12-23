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

        if (min > max) return false;

        return inv >= min && inv <= max;
    }
}
