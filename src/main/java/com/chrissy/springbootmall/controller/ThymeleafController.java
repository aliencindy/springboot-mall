package com.chrissy.springbootmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("/SpringBootMall") // 首頁
    public String SpringBootMall() {

        return "SpringBootMall";
    }

    @GetMapping("/login") // 跳轉到登入畫面
    public String login(){
        return "login";
    }

    @GetMapping("/register") // 跳轉到註冊畫面
    public String register(){
        return "register";
    }

}
