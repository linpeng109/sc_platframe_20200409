package com.cn.userbaseservice.web.services;

import com.cn.userbaseservice.jpa.dao.AuthorityBaseDao;
import com.cn.userbaseservice.jpa.entity.AuthorityBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityBaseDao authorityBaseDao;

    public long countAll() {
        return authorityBaseDao.count();
    }

    public AuthorityBase save(AuthorityBase authorityBase) {
        return authorityBaseDao.save(authorityBase);
    }

    public List<AuthorityBase> findAll() {
        return authorityBaseDao.findAll();
    }

}
