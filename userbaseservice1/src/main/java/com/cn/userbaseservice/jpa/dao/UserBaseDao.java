package com.cn.userbaseservice.jpa.dao;

import com.cn.userbaseservice.jpa.entity.UserBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBaseDao extends PagingAndSortingRepository<UserBase, String> {
    public UserBase findByUsername(String username);

    public Page<UserBase> findAllBy(Pageable pageable);

    public List<UserBase> findAll();
}
