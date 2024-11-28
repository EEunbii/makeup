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
    @GeneratedValue()
    private Long id;
}
