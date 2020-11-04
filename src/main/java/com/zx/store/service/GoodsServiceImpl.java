package com.zx.store.service;

import com.zx.store.bean.Goods;
import com.zx.store.bean.GoodsDetail;
import com.zx.store.bean.ShopCar;
import com.zx.store.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectAllGoods() {
        return goodsMapper.selectAllGoods();
    }

    @Override
    public GoodsDetail selectGoodsDetailsByGoodsId(Integer id) {
        return goodsMapper.selectGoodsDetailsByGoodsId(id);
    }
}
