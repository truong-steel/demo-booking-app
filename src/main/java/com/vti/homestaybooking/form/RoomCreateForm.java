package com.vti.homestaybooking.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Blob;

@Getter
@Setter
public class RoomCreateForm {
    @NotBlank
    @Length(max = 255)
    private String roomType;
    @NotBlank
    private Blob roomImage;
    @NotBlank
    @Length(max = 255)
    private String roomDescription;
    @NotBlank
    @Length(max = 255)
    private BigDecimal roomPrice;
}