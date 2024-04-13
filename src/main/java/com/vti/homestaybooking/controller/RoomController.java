package com.vti.homestaybooking.controller;

import com.vti.homestaybooking.dto.RoomDto;
import com.vti.homestaybooking.entity.Homestay;
import com.vti.homestaybooking.entity.Room;
import com.vti.homestaybooking.form.RoomCreateForm;
import com.vti.homestaybooking.form.RoomFilterForm;
import com.vti.homestaybooking.form.RoomUpdateForm;
import com.vti.homestaybooking.repository.RoomRepository;
import com.vti.homestaybooking.service.HomestayService;
import com.vti.homestaybooking.service.RoomService;
import com.vti.homestaybooking.validation.HomestayIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class RoomController {
    @Autowired
    private final RoomService roomService;
    private final HomestayService homestayService;

    @PostMapping("/api/homestays/{homestayId}/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDto create(Long homestayId , RoomCreateForm form) {
        return roomService.create(homestayId , form);
    }
    @GetMapping("/api/rooms")
    public Page<RoomDto> findAll(RoomFilterForm form , Pageable pageable) {
        return roomService.findAll(form,pageable);
    }
    @GetMapping("/api/homestays/{homestayId}/rooms")
    public Page<RoomDto> findByHomestayId(@PathVariable("homestayId") Long homestayId , Pageable pageable) {
        return roomService.findByPostId(homestayId , pageable);
    }
    @GetMapping("/api/rooms/{id}")
    public RoomDto findById(@PathVariable("id") Long id){
        return roomService.findById(id);
    }
    @PutMapping("/api/rooms/{id}")
    public RoomDto update(@PathVariable("id") Long id ,@RequestBody @Valid RoomUpdateForm form) {
        return roomService.update(id , form);
    }
    @DeleteMapping("/api/rooms/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        roomService.delete(id);
    }
}
