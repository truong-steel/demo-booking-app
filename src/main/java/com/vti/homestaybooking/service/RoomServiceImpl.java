package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.RoomDto;
import com.vti.homestaybooking.entity.Room;
import com.vti.homestaybooking.form.RoomCreateForm;
import com.vti.homestaybooking.form.RoomFilterForm;
import com.vti.homestaybooking.form.RoomUpdateForm;
import com.vti.homestaybooking.repository.HomestayRepository;
import com.vti.homestaybooking.repository.RoomRepository;
import com.vti.homestaybooking.specification.RoomSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{
    @Autowired
    private final RoomRepository roomRepository;
    private final HomestayRepository homestayRepository;
    private final ModelMapper modelMapper;
    @Override
    public RoomDto create(Long homestayId, RoomCreateForm form) {
        var homestay = homestayRepository.findById(homestayId).orElse(null);
        var room = modelMapper.map(form , Room.class);
        room.setHomestay(homestay);
        var savedRoom = roomRepository.save(room);
        return modelMapper.map(savedRoom,RoomDto.class);
    }

    @Override
    public Page<RoomDto> findAll(RoomFilterForm form, Pageable pageable) {
        var spec = RoomSpecification.buildSpec(form);
        return roomRepository.findAll(spec,pageable)
                .map(comment -> modelMapper.map(comment, RoomDto.class).withSelfRel());
    }

    @Override
    public Page<RoomDto> findByPostId(Long homestayId, Pageable pageable) {
        return roomRepository.findByHomestayId(homestayId,pageable)
                .map(comment -> modelMapper.map(comment,RoomDto.class).withSelfRel());
    }

    @Override
    public RoomDto findById(Long id) {
        return roomRepository.findById(id)
                .map(comment -> modelMapper.map(comment, RoomDto.class))
                .orElse(null);
    }

    @Override
    public RoomDto update(Long id, RoomUpdateForm form) {
        var room = roomRepository.findById(id).orElse(null);
        modelMapper.map(form, room);
        var savedComment = roomRepository.save(room);
        return modelMapper.map(savedComment, RoomDto.class);
    }

    @Override
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}