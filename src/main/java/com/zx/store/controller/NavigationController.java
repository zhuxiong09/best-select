package com.zx.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @RequestMapping("/login")
    public String login() {

        return "login";
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
