package com.cn.userbaseservice.jpa.dao;

import com.cn.userbaseservice.jpa.entity.AuthorityBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityBaseDao extends JpaRepository<AuthorityBase,String> {
}
