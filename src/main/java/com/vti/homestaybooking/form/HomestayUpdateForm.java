package com.vti.homestaybooking.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Getter
@Setter
public class HomestayUpdateForm {
    @NotBlank
    @Length(max = 255)
    private String name;
    @NotBlank
    @Length(max = 255)
    private String address;
    @NotBlank
    @Length(max = 255)
    private String description;
    @NotBlank
    @Length(max = 255)
    private BigDecimal lowestPrice;
}
