package com.example.makeup.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "item_img")
@NoArgsConstructor
public class ItemImg {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String imgName;  //이미지 파일명

    private String orilName; //원본 이미지명

    private String imgUrl;   //이미지 조회경로

    private String repimgYn;  //대표이미지


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


}
