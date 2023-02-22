package com.chrissy.springbootmall.controller;

import com.chrissy.springbootmall.dto.UserLoginRequest;
import com.chrissy.springbootmall.dto.UserRegisterRequest;
import com.chrissy.springbootmall.model.User;
import com.chrissy.springbootmall.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/users/register")
    public ModelAndView register(@ModelAttribute UserRegisterRequest userRegisterRequest, Model model) throws JsonProcessingException {
        model.addAttribute("userRegisterRequest", userRegisterRequest);

        Integer userId = userService.register(userRegisterRequest);
        User user = userService.getUserById(userId);
        MyAddAttribute(user, model);// login、register重複的程式

        return new ModelAndView("submit");
    }


    @PostMapping("/users/login")
    public ModelAndView login(@ModelAttribute UserLoginRequest userLoginRequest,
                              Model model) throws JsonProcessingException {

            model.addAttribute("userLoginRequest", userLoginRequest);

            User user = userService.login(userLoginRequest);
            if (user == null) {
                return new ModelAndView("error");
            } else {
                MyAddAttribute(user, model);// login、register重複的程式
                return new ModelAndView("submit");
            }
        }


    private void MyAddAttribute(User user, Model model) {
        model.addAttribute("userId", user.getUserId());
        model.addAttribute("userAuth", user.getUserAuth());
    }

}

