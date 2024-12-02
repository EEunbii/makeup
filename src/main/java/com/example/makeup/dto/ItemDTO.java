package com.example.makeup.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 50, message = "상품명은 2~50자 입니다.")
    private String itemNm;  //상품이름

    @NotNull
    private int price;

    @NotBlank
    private int stockNumber;

    @NotBlank
    private String itemDetail;

    private List<ItemImgDTO> itemImgDTOList;



}
