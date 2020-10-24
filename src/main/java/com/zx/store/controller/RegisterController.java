package com.zx.store.controller;

import com.zx.store.bean.User;
import com.zx.store.mapper.LoginMapping;
import com.zx.store.mapper.RegisterMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private RegisterMapping registerMapping;

    @Autowired
    private LoginMapping loginMapping;

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping ("/userRegister")
    public String userRegister(@RequestParam String username, @RequestParam String password, @RequestParam String email,
                               @RequestParam String gender, @RequestParam String phone, Map<String,Object> map,
                               HttpSession session){
        System.out.println("username = " + username + ", password = "
                            + password + ", email = " + email + ", gender = " + gender + ", phone = " + phone);
        User user1 = loginMapping.selectByUsername(username);
        User user2 = loginMapping.selectByEmail(email);
//        System.out.println(user1);
        if(user1!=null||user2!=null){
//            map.put("msg","用户名输入错误！");
            return "register_fail";
        }else {
            User user=new User(null,username,password,email,gender,phone);
            registerMapping.insertUser(user);
            return "register_success";
        }
    }
}
