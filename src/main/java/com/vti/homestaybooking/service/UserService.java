
package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.UserDto;
import com.vti.homestaybooking.entity.User;
import com.vti.homestaybooking.form.UserCreateForm;
import com.vti.homestaybooking.request.LoginRequest;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    List<User> getUsers();

//    public boolean authenticate(LoginRequest request);
}
