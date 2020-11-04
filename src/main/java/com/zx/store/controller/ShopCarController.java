package com.zx.store.controller;

import com.zx.store.bean.ShopCar;
import com.zx.store.bean.ShopCarDTO;
import com.zx.store.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ShopCarController {

    @Autowired
    private ShopCarService shopCarService;

    @RequestMapping(value = "/putInShopCar", method = RequestMethod.POST)
    @ResponseBody
    public String putInShopCar(@RequestBody ShopCarDTO shopCarDTO, HttpSession session) {
        //    Integer goodsId,String userName,String goodsSize,String goodsColor,String goodsQuantity
        Integer goodsId = (Integer) session.getAttribute("id");
        String userName = (String) session.getAttribute("loginUser");
        ShopCar shopCar = ShopCar.builder()
                .goodsColor(shopCarDTO.getColor())
                .goodsId(goodsId)
                .goodsQuantity(shopCarDTO.getQuantity())
                .goodsSize(shopCarDTO.getSize())
                .userName(userName)
                .build();
        shopCarService.insertShopCar(shopCar);
        System.out.println("shopCarDTO = " + shopCarDTO + ", goodsId = " + goodsId + ", userName = " + userName);
        return "success";
    }
}
