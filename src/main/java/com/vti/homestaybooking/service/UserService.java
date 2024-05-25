
package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.UserDto;
import com.vti.homestaybooking.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
}
