package com.vti.homestaybooking.repository;

import com.vti.homestaybooking.entity.Homestay;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomestayRepository extends JpaSpecificationExecutor<Homestay> , JpaRepository<Homestay , Long> {
}
