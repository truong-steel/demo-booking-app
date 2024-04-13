package com.vti.homestaybooking.form;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Blob;

@Getter
@Setter
public class HomestayCreateForm {
    @NotBlank
    @Length(max = 255)
    private String name;
    @NotBlank
    @Length(max = 255)
    private String address;
    @NotBlank
    @Length(max = 255)
    private String city;
    @NotBlank
    @Length(max = 255)
    private String type;
    @NotBlank
    @Length(max = 255)
    private String description;
    @NotBlank
    @Length(max = 255)
    private BigDecimal lowestPrice;
    @Lob
    private Blob image;
}
