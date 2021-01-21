package com.cn.userbaseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserbaseserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.cn.userbaseservice.UserbaseserviceApplication.class, args);
    }

}
