package com.zx.store.controller;

import com.zx.store.bean.*;
import com.zx.store.mapper.LoginMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private LoginMapping loginMapping;

    @RequestMapping("/login")
    public String login() {

        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam String username, @RequestParam String password,
                                  HttpSession session, Map<String, Object> map) {
        session.setAttribute("loginUser", username);

        User user1 = loginMapping.selectByEmailAndPassword(username, password);
        User user2 = loginMapping.selectByUsernameAndPassword(username, password);

        List<Goods> goods = loginMapping.selectAllGoods();
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

        List<Goods> goods = loginMapping.selectAllGoods();
        System.out.println(goods.size());
        Map<String, Object> model = new HashMap<>();
        model.put("goods", goods);
        modelAndView = new ModelAndView("index", model);
        return modelAndView;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ModelAndView showDetails(@PathVariable("id") Integer id) {
        ModelAndView modelAndView;
        //查询详情页信息
        DetailPage detailPage = loginMapping.selectShopCarById(id);
        System.out.println(detailPage);
        //查询详情页属性信息
        List<Property> properties = loginMapping.selectPropertyById(id);
        String cotton = properties.get(0).getPropertyValue();
        String casual = properties.get(1).getPropertyValue();
        //查询详情页属性图片
        List<DetailImage> detailImages = loginMapping.selectDetailImageById(id);
        System.out.println(detailImages.size());
        //查询详情页属性尺寸
        List<Size> sizes = loginMapping.selectSizeById(id);
        System.out.println(sizes.get(1).getPropertyValue());
        //查询详情页属性颜色
        List<Color> colors = loginMapping.selectColorById(id);
        System.out.println(colors.size());

        Map<String, Object> model = new HashMap<>();
        model.put("detailPage", detailPage);
        model.put("Cotton", cotton);
        model.put("Casual", casual);
        model.put("sizes", sizes);
        model.put("detailImages", detailImages);
        model.put("colors", colors);
        modelAndView = new ModelAndView("product-details", model);
        return modelAndView;
    }

//    @RequestMapping("/details")
//    public String details() {
//
//        return "product-details";
//    }


    @RequestMapping("/putInShopCar")
    public String putInShopCar() {

        return "cart";
    }

    @RequestMapping("/wishlist")
    public String wishlist() {

        return "wishlist";
    }

    @RequestMapping("/about")
    public String about() {

        return "about";
    }

    @RequestMapping("/blog")
    public String blog() {

        return "blog";
    }

    @RequestMapping("/blog-details")
    public String blogDetails() {

        return "blog-details";
    }

    @RequestMapping("/cart")
    public String cart() {

        return "cart";
    }

    @RequestMapping("/checkout")
    public String checkout() {

        return "checkout";
    }

    @RequestMapping("/compare")
    public String compare() {

        return "compare";
    }

    @RequestMapping("/contact")
    public String contact() {

        return "contact";
    }

    @RequestMapping("/my-account")
    public String myAccount() {

        return "my-account";
    }

    @RequestMapping("/product-details")
    public String productDetails() {

        return "product-details";
    }

    @RequestMapping("/shop-full")
    public String shopFull() {

        return "shop-full";
    }

}
