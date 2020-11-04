package com.zx.store.service;

import com.zx.store.bean.Color;
import com.zx.store.bean.GoodsDetailImage;
import com.zx.store.bean.Property;
import com.zx.store.bean.Size;
import com.zx.store.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public List<Property> selectPropertyByGoodsId(Integer id) {
        return propertyMapper.selectPropertyByGoodsId(id);
    }

    @Override
    public List<GoodsDetailImage> selectGoodsDetailImageByGoodsId(Integer id) {
        return propertyMapper.selectGoodsDetailImageByGoodsId(id);
    }

    @Override
    public List<Size> selectSizeByGoodsId(Integer id) {
        return propertyMapper.selectSizeByGoodsId(id);
    }

    @Override
    public List<Color> selectColorByGoodsId(Integer id) {
        return propertyMapper.selectColorByGoodsId(id);
    }
}
