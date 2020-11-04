package com.zx.store.service;

import com.zx.store.bean.ShopCar;
import com.zx.store.mapper.ShopCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopCarServiceImpl implements ShopCarService {
    @Autowired
    private ShopCarMapper shopCarMapper;

    @Override
    public void insertShopCar(ShopCar shopCar) {
        shopCarMapper.insertShopCar(shopCar.getGoodsId(),
                shopCar.getUserName(),
                shopCar.getGoodsSize(),
                shopCar.getGoodsColor(),
                shopCar.getGoodsQuantity());
    }
}
//.goodsCInteger goodsId,String userName,String goodsSize,String goodsColor,String goodsQuantity