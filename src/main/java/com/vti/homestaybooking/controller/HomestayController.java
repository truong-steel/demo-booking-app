package com.vti.homestaybooking.controller;

import com.vti.homestaybooking.dto.HomestayDto;
import com.vti.homestaybooking.entity.Homestay;
import com.vti.homestaybooking.form.HomestayCreateForm;
import com.vti.homestaybooking.form.HomestayFilterForm;
import com.vti.homestaybooking.form.HomestayUpdateForm;
import com.vti.homestaybooking.service.HomestayService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
public class HomestayController {
    @Autowired
    private HomestayService homestayService;

    @GetMapping("/api/homestays")
    public Page<HomestayDto> getAllHomestay(HomestayFilterForm form , Pageable pageable){
        return homestayService.getAllHomestay(form,pageable);
    }

    @GetMapping("/api/homestays/{id}")
    public HomestayDto getHomestayById(@PathVariable("id") Long id){
        return homestayService.findById(id);
    }

    @PostMapping("/api/homestays")
    @ResponseStatus(HttpStatus.CREATED)
    public HomestayDto create(@RequestBody HomestayCreateForm form) {
        return homestayService.createHomestay(form);
    }
    @PutMapping("/api/homestays/{id}")
    public HomestayDto update(@PathVariable("id") Long id ,@RequestBody HomestayUpdateForm form) {
        return homestayService.updateHomestay(id ,form);
    }
    @DeleteMapping("/api/homestays/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        homestayService.deleteHomestay(id);
    }
}
