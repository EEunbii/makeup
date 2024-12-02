package com.example.makeup.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_id")
public class Item {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ino; //상품번호

    @Column(nullable = false, length = 60)
    private String itemNm; //상품이름

    @Column(nullable = false)
    private int price;  //가격

    private String itemDetail; //상품상세설명

    @OneToMany()
    private List<ItemImg> itemImgList;
}


