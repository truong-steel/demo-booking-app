package com.vti.homestaybooking.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class UserRoomDto {
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private int totalGuest;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}