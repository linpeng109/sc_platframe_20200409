package com.cn.sercurity;

import com.alibaba.fastjson.JSONPObject;
import com.cn.sercurity.config.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

@SpringBootTest
class SecurityserviceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Test
    public void testUserDetailsServiceImpl() {
        UserDetails result = userDetailsService.loadUserByUsername("abcd");
        System.out.println(result);

    }
}
