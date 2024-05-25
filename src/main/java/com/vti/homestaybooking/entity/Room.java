package com.vti.homestaybooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

@Entity
@Getter
@Setter

public class Room {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_price")
    private BigDecimal roomPrice ;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "room_description")
    private String roomDescription;

    @ManyToOne
    @JoinColumn(name="homestay_id" , nullable = false)
    private Homestay homestay;

    @OneToMany(mappedBy = "room" , cascade = CascadeType.ALL)
    private List<UserRoom> userRooms;

}