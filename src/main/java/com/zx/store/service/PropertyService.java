package com.zx.store.service;


import com.zx.store.bean.Color;
import com.zx.store.bean.GoodsDetailImage;
import com.zx.store.bean.Property;
import com.zx.store.bean.Size;

import java.util.List;

public interface PropertyService {

    public List<Property> selectPropertyByGoodsId(Integer id);

    public List<GoodsDetailImage> selectGoodsDetailImageByGoodsId(Integer id);

    public List<Size> selectSizeByGoodsId(Integer id);

    public List<Color> selectColorByGoodsId(Integer id);
}
