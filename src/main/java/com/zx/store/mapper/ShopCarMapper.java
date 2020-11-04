package com.zx.store.mapper;

import com.zx.store.bean.ShopCar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopCarMapper {

    //    id,goodsId,username,goods_name,goods_size,goods_color,goods_quantity,created_at,updated_at
//    default,1,'zhu','name','xx','red','11',default,default
    public void insertShopCar(Integer goodsId,String userName,String goodsSize,String goodsColor,String goodsQuantity);
}

