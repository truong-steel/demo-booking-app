package com.vti.homestaybooking.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HomestayIdExistsValidator.class )
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface HomestayIdExists {
    String message() default "{homestay.id.Exists.message}";
    Class<?>[] groups() default{};
    @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
    @Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    @Documented
    static @interface List {
        jakarta.validation.constraints.NotBlank[] value();
    }
}
