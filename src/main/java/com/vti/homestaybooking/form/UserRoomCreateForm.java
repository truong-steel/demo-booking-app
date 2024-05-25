package com.vti.homestaybooking.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
@Getter
@Setter
public class UserRoomCreateForm {
    @NotBlank
    @CreationTimestamp
    private LocalDate startDate;
    @NotBlank
    @UpdateTimestamp
    private LocalDate endDate;
    @NotBlank
    private int totalGuest;

}