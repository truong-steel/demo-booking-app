package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.UserRoomDto;
import com.vti.homestaybooking.entity.UserRoom;
import com.vti.homestaybooking.form.UserRoomCreateForm;
import com.vti.homestaybooking.repository.RoomRepository;
import com.vti.homestaybooking.repository.UserRepository;
import com.vti.homestaybooking.repository.UserRoomRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserRoomServiceImpl implements UserRoomService {
    @Autowired
    private final UserRoomRepository userRoomRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;
    @Override
    public UserRoomDto createBooking(Long roomId , Long userId ,UserRoomCreateForm form) {
        var room = roomRepository.findById(roomId).orElse(null);
        var user = userRepository.findById(userId).orElse(null);
        var booking = modelMapper.map(form , UserRoom.class);
        booking.setRoom(room);
        booking.setUser(user);
        var savedBooking = userRoomRepository.save(booking);

        return modelMapper.map(savedBooking , UserRoomDto.class);
    }

    @Override
    public List<UserRoom> findAllBooking(Long userId) {
        return userRepository.findById(userId).get().getUserRooms().stream().toList();
    }

    @Override
    public UserRoomDto findBookingById(Long id) {
        return userRoomRepository.findById(id)
                .map(booking -> modelMapper.map(booking , UserRoomDto.class)).orElse(null);
    }

    @Override
    public void deleteBooking(Long id) {
        userRoomRepository.deleteById(id);
    }
}