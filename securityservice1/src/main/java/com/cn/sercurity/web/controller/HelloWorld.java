package com.cn.sercurity.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorld {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World !";
    }
}

