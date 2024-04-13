package com.vti.homestaybooking.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Blob;

@Getter
@Setter
public class RoomUpdateForm {
    @NotBlank
    @Length(max = 255)
    private String type;
    @NotBlank
    private Blob image;
    @NotBlank
    @Length(max = 255)
    private String description;
    @NotBlank
    @Length(max = 255)
    private BigDecimal price;
}
