package com.zx.store.controller;

import com.zx.store.bean.*;
import com.zx.store.mapper.PropertyMapper;
import com.zx.store.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsDetailsController {
    @Autowired
    private PropertyMapper propertyMapper;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ModelAndView showDetails(@PathVariable("id") Integer id, HttpSession session) {
        session.setAttribute("id", id);
        ModelAndView modelAndView;
        //查询详情页信息
        GoodsDetail goodsDetail = goodsService.selectGoodsDetailsByGoodsId(id);
        System.out.println(goodsDetail);
        //查询详情页属性信息
        List<Property> properties = propertyMapper.selectPropertyByGoodsId(id);
        String cotton = properties.get(0).getPropertyValue();
        String casual = properties.get(1).getPropertyValue();
        //查询详情页属性图片
        List<GoodsDetailImage> goodsDetailImages = propertyMapper.selectGoodsDetailImageByGoodsId(id);
        System.out.println(goodsDetailImages.size());
        //查询详情页属性尺寸
        List<Size> sizes = propertyMapper.selectSizeByGoodsId(id);
        System.out.println(sizes.get(1).getPropertyValue());
        //查询详情页属性颜色
        List<Color> colors = propertyMapper.selectColorByGoodsId(id);
        System.out.println(colors.size());

        Map<String, Object> model = new HashMap<>();
        model.put("goodsDetail", goodsDetail);
        model.put("Cotton", cotton);
        model.put("Casual", casual);
        model.put("sizes", sizes);
        model.put("detailImages", goodsDetailImages);
        model.put("colors", colors);
        modelAndView = new ModelAndView("product-details", model);
        return modelAndView;
    }
}
