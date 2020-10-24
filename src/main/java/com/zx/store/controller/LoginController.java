package com.zx.store.controller;

import com.zx.store.bean.User;
import com.zx.store.mapper.LoginMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private LoginMapping loginMapping;

    @RequestMapping("/login")
    public String login() {

        return "login";
    }

//    @RequestMapping("/index")
//    public String index(){
//
//        return "index";
//    }

    @PostMapping(value = "/login")
    public String userLogin(@RequestParam String username, @RequestParam String password,
                            HttpSession session, Map<String,Object> map) {
        session.setAttribute("loginUser", username);
        User user1 = loginMapping.selectByEmailAndPassword(username,password);
        User user2 = loginMapping.selectByUsernameAndPassword(username,password);
        if (user1 != null || user2 != null) {
            return "redirect:/home.html";
        }else {
            map.put("msg","登陆失败，请重新登录");
            return "login";
        }

    }

}
