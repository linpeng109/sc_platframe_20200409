package com.cn.sercurity.web.controller;

import com.cn.sercurity.web.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userbase")
public class UserBaseContorller {
    @Autowired
    private UserBaseService userBaseService;

    @RequestMapping(value = "/findbyusername/{username}")
    public String loadByUsername(@PathVariable("username") String username) {
        return userBaseService.loadByUsername(username);
    }
}
