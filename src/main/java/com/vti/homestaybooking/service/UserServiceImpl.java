package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.UserDto;
import com.vti.homestaybooking.dto.UserRoomDto;
import com.vti.homestaybooking.entity.Role;
import com.vti.homestaybooking.entity.User;
import com.vti.homestaybooking.exception.UserAlreadyExistsException;
import com.vti.homestaybooking.form.UserCreateForm;
import com.vti.homestaybooking.repository.UserRepository;
import com.vti.homestaybooking.request.LoginRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException(user.getEmail() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
//        Role userRole = roleRepository.findByName("ROLE_CUSTOMER").get();
//        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}