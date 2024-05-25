package com.vti.homestaybooking.repository;

import com.vti.homestaybooking.entity.UserRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoomRepository extends JpaRepository<UserRoom, Long> {
    //    List<UserRoom> findAllByDate(LocalDate startDate , LocalDate endDate);
    List<UserRoom> findAllByUserId(Long id);
}