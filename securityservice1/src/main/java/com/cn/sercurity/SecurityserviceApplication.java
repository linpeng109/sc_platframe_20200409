package com.cn.sercurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableFeignClients
public class SecurityserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityserviceApplication.class, args);
    }

}
