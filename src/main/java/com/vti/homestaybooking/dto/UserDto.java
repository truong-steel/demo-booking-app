package com.vti.homestaybooking.dto;

import com.vti.homestaybooking.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String token;
    private String password;
    private List<String> roles;

}