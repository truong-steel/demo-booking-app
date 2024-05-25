package com.vti.homestaybooking.repository;

import com.vti.homestaybooking.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> , JpaSpecificationExecutor<Room> {
    Page<Room> findByHomestayId (Long homestayId , Pageable pageable);
}