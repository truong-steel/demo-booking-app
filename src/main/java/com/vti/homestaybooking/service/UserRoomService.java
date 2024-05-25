package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.UserRoomDto;
import com.vti.homestaybooking.entity.UserRoom;
import com.vti.homestaybooking.form.UserRoomCreateForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoomService {
    UserRoomDto createBooking(Long roomId , Long userId,UserRoomCreateForm form);
    List<UserRoom> findAllBooking(Long userId);
    UserRoomDto findBookingById(Long id);
    void deleteBooking(Long id);
}