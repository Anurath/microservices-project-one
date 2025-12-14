package com.ima.user.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="micro_user")
public class User {

    @Id
    @Column(name="ID")
    private String userId;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String emial;

    @Column(name="ABOUT")
    private String about;

    @Column(name="PHONE")
    private long phno;


    @Transient
    private List<Ratings> ratings = new ArrayList<>();
}


