package com.zx.store.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String image;
    private String newPrice;
    private String oldPrice;
}
