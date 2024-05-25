package com.vti.homestaybooking.controller;

import com.vti.homestaybooking.dto.UserRoomDto;
import com.vti.homestaybooking.entity.UserRoom;
import com.vti.homestaybooking.form.UserRoomCreateForm;
import com.vti.homestaybooking.service.UserRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class BookingController {
    private final UserRoomService userRoomService;

    @PostMapping("/api/booking/{roomId}/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRoomDto create(@PathVariable("roomId") Long roomId , @PathVariable("userId") Long userId ,@RequestBody UserRoomCreateForm form ) {
        return userRoomService.createBooking(roomId, userId ,form);
    }
    @GetMapping("/api/booking/{id}")
    public UserRoomDto findBookingById(@PathVariable("id") Long id) {
        return userRoomService.findBookingById(id);
    }
    @DeleteMapping("/api/booking/{id}")
    public void delete(@PathVariable("id") Long id){
        userRoomService.deleteBooking(id);
    }
    @GetMapping("/api/booking")
    public List<UserRoom> findAllBooking(Long userId) {
        return userRoomService.findAllBooking(userId);
    }
}