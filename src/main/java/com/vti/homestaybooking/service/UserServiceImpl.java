package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.UserDto;
import com.vti.homestaybooking.dto.UserRoomDto;
import com.vti.homestaybooking.entity.User;
import com.vti.homestaybooking.form.UserCreateForm;
import com.vti.homestaybooking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public UserDto create(UserCreateForm form) {
        var user = modelMapper.map(form , User.class);
        var savedUser = userRepository.save(user);
        return modelMapper.map(savedUser , UserDto.class);
    }
}