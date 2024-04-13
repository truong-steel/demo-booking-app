package com.vti.homestaybooking.validation;

import com.vti.homestaybooking.repository.HomestayRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class HomestayIdExistsValidator implements ConstraintValidator<HomestayIdExists , Long> {
    private final HomestayRepository homestayRepository;
    @Autowired
    public HomestayIdExistsValidator (HomestayRepository homestayRepository) {
        this.homestayRepository = homestayRepository;
    }
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return homestayRepository.existsById(id);
    }
}
