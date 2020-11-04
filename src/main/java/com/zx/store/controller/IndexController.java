package com.zx.store.controller;

import com.zx.store.bean.Goods;
import com.zx.store.bean.User;
import com.zx.store.service.GoodsService;
import com.zx.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam String username, @RequestParam String password,
                                  HttpSession session, Map<String, Object> map) {
        session.setAttribute("loginUser", username);


        User user1 = userService.selectUserByEmailAndPassword(username, password);
        User user2 = userService.selectUserByUsernameAndPassword(username, password);

        List<Goods> goods = goodsService.selectAllGoods();
        System.out.println("*******************" + goods.get(0));
        Map<String, Object> model = new HashMap<>();
        model.put("goods", goods);
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("index", model);
        if (user1 != null || user2 != null) {
            return modelAndView;
        } else {
            map.put("msg", "登陆失败，请重新登录");
            modelAndView = new ModelAndView("login");
            return modelAndView;
        }
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView;

        List<Goods> goods = goodsService.selectAllGoods();
        System.out.println(goods.size());
        Map<String, Object> model = new HashMap<>();
        model.put("goods", goods);
        modelAndView = new ModelAndView("index", model);
        return modelAndView;
    }

}
