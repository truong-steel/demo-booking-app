package com.vti.homestaybooking.service;

import com.vti.homestaybooking.dto.HomestayDto;
import com.vti.homestaybooking.entity.Homestay;
import com.vti.homestaybooking.form.HomestayCreateForm;
import com.vti.homestaybooking.form.HomestayFilterForm;
import com.vti.homestaybooking.form.HomestayUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HomestayService {
    Page<HomestayDto> getAllHomestay (HomestayFilterForm form , Pageable pageable);
    //    List<HomestayDto> findByHost (Long id);
//    List<HomestayDto> findByParameters (String city , LocalDate startDate , LocalDate endDate );
    HomestayDto findById(Long id);
    HomestayDto createHomestay(HomestayCreateForm form);
    HomestayDto updateHomestay(Long id , HomestayUpdateForm form);
    void deleteHomestay(Long id);
}