package com.vti.homestaybooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Blob;

@Entity
@Getter
@Setter

public class Room {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_price")
    private BigDecimal price ;

    @Column(name ="room_image")
    private Blob roomImage;

    @Column(name = "room_description")
    private String roomDescription;

    @ManyToOne
    @JoinColumn(name="homestay_id" , nullable = false)
    private Homestay homestay;

}
