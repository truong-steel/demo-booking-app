package com.vti.homestaybooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name="role")
    private Role role;
    public enum Role {
        ADMIN , USER , OWNER
    }
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<UserRoom> userRooms;

}