package com.rev.pms.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CartController {

    @GetMapping
    public String welcomeMsg(){
        return "Welcome to my Cart application, deployment automated (push to github and dockerhub by Jenkins";
    }
}
