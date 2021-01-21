package com.cn.userbaseservice.web.controller;

import com.cn.userbaseservice.jpa.entity.AuthorityBase;
import com.cn.userbaseservice.jpa.entity.UserBase;
import com.cn.userbaseservice.web.services.AuthorityService;
import com.cn.userbaseservice.web.services.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/userbase")
@CrossOrigin(allowedHeaders = "*", origins = "*", maxAge = 3600)
public class UserBaseController {
    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/init")
    public UserBase init() {
        AuthorityBase admin = new AuthorityBase();
        admin.authority = "ROLE_ADMIN";
        authorityService.save(admin);

        AuthorityBase common = new AuthorityBase();
        common.authority = "ROLE_COMMON";
        authorityService.save(common);

        AuthorityBase guest = new AuthorityBase();
        guest.authority = "ROLE_GUEST";
        authorityService.save(guest);

        UserBase abcd = new UserBase();
        abcd.username = "abcd";
        abcd.password = "abcd";
        abcd.authorities.add(admin);
        abcd.authorities.add(common);
        abcd.authorities.add(guest);
        userBaseService.save(abcd);

        return abcd;
    }

    @RequestMapping("/findbyusername/{username}")
    public UserBase findByUsername(@PathVariable("username") String username) {
        return userBaseService.findByUsername(username);
    }

    @RequestMapping("/countall")
    public int countall() {
        return userBaseService.count();
    }

    @RequestMapping("/insert/{num}")
    public List<UserBase> insert(@PathVariable("num") int num) {
        List<UserBase> result = new ArrayList<UserBase>();
        int authority_size = (int) authorityService.countAll();
        List<AuthorityBase> authorityBases = authorityService.findAll();
        for (int i = 0; i < num; ++i) {
            UserBase userBase = new UserBase();
            String randomStr = UUID.randomUUID().toString().substring(24, 32);
            userBase.username = randomStr;
            userBase.password = randomStr;
            int randomInt = new Random().nextInt(authority_size);
            AuthorityBase randomAuthorityBase = authorityBases.get(randomInt);
            userBase.authorities.add(randomAuthorityBase);
            userBaseService.save(userBase);
            result.add(userBase);
        }
        return result;
    }

    @RequestMapping("/findall")
    public List<UserBase> findByAll() {
        return userBaseService.findAll();
    }

    @RequestMapping("/findbypage/{pagesize}/{pagenum}")
    public Page<UserBase> findByPage(@PathVariable("pagesize") int pageSize, @PathVariable("pagenum") int pageNum) {
        return userBaseService.findByPage(pageSize, pageNum);
    }
}
