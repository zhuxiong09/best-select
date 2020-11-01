package com.zx.store.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailPage {
    private Integer id;
    private double newPrice;
    private double oldPrice;
    private String content;
    private String summary;
    private String brandName;
    private String goodsName;
    private String categoryName;
}