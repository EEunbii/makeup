package com.example.makeup.entity;

import jakarta.persistence.*;

@Entity
public class review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "member_id")
    private Long id;


    @Column(name = "")
    private String reviewcontent;


    @OneToMany(mappedBy = "item",fetch)













}
