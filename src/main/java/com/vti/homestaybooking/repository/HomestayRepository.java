package com.vti.homestaybooking.repository;

import com.vti.homestaybooking.dto.HomestayDto;
import com.vti.homestaybooking.entity.Homestay;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HomestayRepository extends
        JpaSpecificationExecutor<Homestay> ,
        JpaRepository<Homestay , Long>
{
    @Query(value="select * from homestay h where id in (\n" +
            "select homestay_id from room r where not exists (\n" +
            "\tselect 1 from user_room ur \n" +
            "    where r.id = ur.room_id \n" +
            "\tand ur.startDate >= :startDate\n" +
            "\tand ur.endDate <= :endDate\n" +
            ")\n" +
            ") and h.city = :city",
            nativeQuery = true)
    List<HomestayDto> findAllByCityDateAndTotalGuest(String city , LocalDate startDate , LocalDate endDate );
//    List<HomestayDto> findAllByHostId ( Long id );
}