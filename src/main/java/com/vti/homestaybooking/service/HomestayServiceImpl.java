package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.HomestayDto;
import com.vti.homestaybooking.entity.Homestay;
import com.vti.homestaybooking.form.HomestayCreateForm;
import com.vti.homestaybooking.form.HomestayFilterForm;
import com.vti.homestaybooking.form.HomestayUpdateForm;
import com.vti.homestaybooking.repository.HomestayRepository;
import com.vti.homestaybooking.specification.HomestaySpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class HomestayServiceImpl implements HomestayService {
    @Autowired
    private final HomestayRepository homestayRepository;
    private final ModelMapper modelMapper;
    @Override
    public Page<HomestayDto> getAllHomestay(HomestayFilterForm form , Pageable pageable) {
        var spec = HomestaySpecification.buildSpec(form);
        return homestayRepository.findAll( spec ,pageable)
                .map(homestay -> modelMapper.map(homestay,HomestayDto.class).withSelfRel());
    }

//    @Override
//    public List<HomestayDto> findByParameters(String city, LocalDate startDate, LocalDate endDate) {
//         return homestayRepository.findAllByCityDateAndTotalGuest(city , startDate , endDate )
//                 .map(homestay -> modelMapper.map(homestay , HomestayDto.class).withSelfRel());
//
//    }

    @Override
    public HomestayDto findById(Long id) {
        return homestayRepository.findById(id)
                .map(homestay -> modelMapper.map(homestay, HomestayDto.class).withSelfRel())
                .orElse(null);
    }

    @Override
    public HomestayDto createHomestay(HomestayCreateForm form) {
        var homestay = modelMapper.map(form , Homestay.class);
        var savedHomestay = homestayRepository.save(homestay);
        return modelMapper.map(savedHomestay,HomestayDto.class);
    }

    @Override
    public HomestayDto updateHomestay(Long id , HomestayUpdateForm form) {
        var homestay = homestayRepository.findById(id).orElse(null);
        modelMapper.map(form , homestay);
        var savedHomestay = homestayRepository.save(homestay);
        return modelMapper.map(savedHomestay , HomestayDto.class);
    }

    @Override
    public void deleteHomestay(Long id) {
        homestayRepository.deleteById(id);
    }
}