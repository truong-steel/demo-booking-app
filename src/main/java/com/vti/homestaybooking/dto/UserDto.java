package com.vti.homestaybooking.dto;

import com.vti.homestaybooking.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private User.Role role;
}