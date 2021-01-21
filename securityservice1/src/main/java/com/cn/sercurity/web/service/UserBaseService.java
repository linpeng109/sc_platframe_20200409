package com.cn.sercurity.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "UserBaseService", url = "http://localhost:8801/userbase")
public interface UserBaseService {
    @RequestMapping("/findbyusername/{username}")
    public String loadByUsername(@PathVariable("username") String username);
}
