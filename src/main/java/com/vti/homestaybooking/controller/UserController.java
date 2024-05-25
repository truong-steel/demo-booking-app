package com.vti.homestaybooking.controller;

import com.vti.homestaybooking.dto.UserDto;
import com.vti.homestaybooking.form.UserCreateForm;
import com.vti.homestaybooking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;
    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserCreateForm form){
        return userService.create(form);
    }
}