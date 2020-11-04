package com.zx.store.service;

import com.zx.store.bean.GoodsDetail;
import com.zx.store.bean.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    public List<Goods> selectAllGoods();

    public GoodsDetail selectGoodsDetailsByGoodsId(Integer id);
}
