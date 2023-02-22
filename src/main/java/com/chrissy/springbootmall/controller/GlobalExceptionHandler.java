package com.chrissy.springbootmall.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ModelAndView handleResponseStatusException(ResponseStatusException ex) {
        HttpStatus status = ex.getStatus();
        String reason = ex.getReason();

        System.out.println("ex.getRawStatusCode()： "+ex.getRawStatusCode());
        System.out.println("getReason()： "+ex.getReason());
        System.out.println("ex.getCause().getMessage()： "+ex.getCause().getMessage());


        if (status == HttpStatus.BAD_REQUEST) {
            reason = ex.getReason();

        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("status", status.value());
        modelAndView.addObject("reason", reason);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}