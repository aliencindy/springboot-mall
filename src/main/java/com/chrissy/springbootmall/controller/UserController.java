package com.chrissy.springbootmall.controller;

import com.chrissy.springbootmall.dto.UserLoginRequest;
import com.chrissy.springbootmall.dto.UserRegisterRequest;
import com.chrissy.springbootmall.model.User;
import com.chrissy.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;


//    @PostMapping("/users/register")
//    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
//        Integer userId = userService.register(userRegisterRequest);
//        User user = userService.getUserById(userId);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }
//
//    @PostMapping("/users/login")
//    public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
//        User user = userService.login(userLoginRequest);
//
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//
//    }
    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestParam String email, @RequestParam String password) {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail(email);
        userRegisterRequest.setPassword(password);

        Integer userId = userService.register(userRegisterRequest);
        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail(email);
        userLoginRequest.setPassword(password);

        User user = userService.login(userLoginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(user);

    }


}

