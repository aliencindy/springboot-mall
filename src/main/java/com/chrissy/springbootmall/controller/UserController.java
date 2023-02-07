package com.chrissy.springbootmall.controller;

import com.chrissy.springbootmall.dto.UserLoginRequest;
import com.chrissy.springbootmall.dto.UserRegisterRequest;
import com.chrissy.springbootmall.model.User;
import com.chrissy.springbootmall.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;


//    @PostMapping("/users/register")//By teacher
//    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
//        Integer userId = userService.register(userRegisterRequest);
//        User user = userService.getUserById(userId);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }
//
//    @PostMapping("/users/login")//By teacher
//    public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
//        User user = userService.login(userLoginRequest);
//
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//
//    }
    @PostMapping("/users/register")
    public ModelAndView register(@ModelAttribute UserRegisterRequest userRegisterRequest,Model model) throws JsonProcessingException {
        model.addAttribute("userRegisterRequest",userRegisterRequest);

        Integer userId = userService.register(userRegisterRequest);
        User user = userService.getUserById(userId);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(user);

        model.addAttribute("msg", jsonResult);
        return new ModelAndView("/submit");
    }

//    @PostMapping("/users/login") // OK

//    public ResponseEntity<User> login(@RequestParam String email,
//                                      @RequestParam String password) {
//        UserLoginRequest userLoginRequest = new UserLoginRequest();
//        userLoginRequest.setEmail(email);
//        userLoginRequest.setPassword(password);
//
//        User user = userService.login(userLoginRequest);
//
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//
//    }

    @PostMapping("/users/login")// OK
    public ModelAndView login(@ModelAttribute UserLoginRequest userLoginRequest, Model model) throws JsonProcessingException {
        model.addAttribute("userLoginRequest", userLoginRequest);

        User user = userService.login(userLoginRequest);
        if(user==null){
            model.addAttribute("msg", "hi");
        }else{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResult = objectMapper.writeValueAsString(user);
            model.addAttribute("msg",jsonResult);
        }
        return new ModelAndView("/submit");
    }

}

