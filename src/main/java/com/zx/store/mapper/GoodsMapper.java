package com.zx.store.mapper;

import com.zx.store.bean.GoodsDetail;
import com.zx.store.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    public List<Goods> selectAllGoods();

    public GoodsDetail selectGoodsDetailsByGoodsId(Integer id);
}

