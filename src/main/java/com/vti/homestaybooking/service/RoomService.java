package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.RoomDto;
import com.vti.homestaybooking.entity.Room;
import com.vti.homestaybooking.form.RoomCreateForm;
import com.vti.homestaybooking.form.RoomFilterForm;
import com.vti.homestaybooking.form.RoomUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    RoomDto create(Long homestayId, RoomCreateForm form);
    Page<RoomDto> findAll(RoomFilterForm form , Pageable pageable);
    Page<RoomDto> findByPostId(Long homestayId,Pageable pageable);
    RoomDto findById(Long id);
    RoomDto update(Long id, RoomUpdateForm form);
    void delete(Long id);
}