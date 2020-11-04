package com.zx.store.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopCar {
    private Integer goodsId;
    private String userName;
    private String goodsSize;
    private String goodsColor;
    private String goodsQuantity;
}
