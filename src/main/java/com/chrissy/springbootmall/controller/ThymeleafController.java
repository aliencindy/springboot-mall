package com.chrissy.springbootmall.controller;

import com.chrissy.springbootmall.dto.UserLoginRequest;
import com.chrissy.springbootmall.dto.UserRegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("/index") // 首頁
    public String SpringBootMall() {

        return "index";
    }

    @GetMapping("/login") // 跳轉到登入畫面
    public String login(Model model){
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        model.addAttribute("userLoginRequest",userLoginRequest);// （變數名稱，變數值)
        return "login";
    }

    @GetMapping("/register") // 跳轉到註冊畫面
    public String register(Model model){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        model.addAttribute("userRegisterRequest",userRegisterRequest);
        return "register";
    }

}
