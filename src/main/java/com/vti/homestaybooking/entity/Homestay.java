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
@Table(name = "homestay")
public class Homestay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "homestay_name" , unique = true)
    private String homestayName;

    @Column(name = "homestay_type" )
    private String homestayType;

    @Column(name = "city")
    private String city;

    @Column(name = "description" , length = 2000)
    private String description;

    @Column(name="homestay_image")
    private String homestayImage;

    @Column(name = "rating" , length = 1)
    private String rating;

    @Column(name = "lowest_price")
    private String lowestPrice;

    @OneToMany(mappedBy = "homestay" , cascade = CascadeType.ALL)
    private List<Room> rooms;

}