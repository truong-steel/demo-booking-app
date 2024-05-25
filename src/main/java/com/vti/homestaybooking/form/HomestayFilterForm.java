package com.vti.homestaybooking.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HomestayFilterForm {
    private String search ;
    private LocalDate minCreatedDate;
    private LocalDate maxCreatedDate;
}