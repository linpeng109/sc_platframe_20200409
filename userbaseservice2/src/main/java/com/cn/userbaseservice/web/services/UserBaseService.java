package com.cn.userbaseservice.web.services;

import com.cn.userbaseservice.jpa.dao.UserBaseDao;
import com.cn.userbaseservice.jpa.entity.UserBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBaseService {
    @Resource
    public UserBaseDao userBaseDao;

    public List<UserBase> findAll() {
        return userBaseDao.findAll();
    }

    public int count() {
        return (int) userBaseDao.count();
    }

    public UserBase save(UserBase userBase) {
        return userBaseDao.save(userBase);
    }

    public UserBase findByUsername(String username) {
        return userBaseDao.findByUsername(username);
    }

    public Page<UserBase> findByPage(int pageSize, int pageNum) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        return userBaseDao.findAllBy(pageRequest);
    }
}
