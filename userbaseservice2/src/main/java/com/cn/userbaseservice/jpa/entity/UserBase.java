package com.cn.userbaseservice.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_base")
@GenericGenerator(strategy = "uuid", name = "system-uuid")
@Data
public class UserBase implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "user_id", length = 32)
    public String userId;

    @Column(name = "username", length = 32, unique = true)
    public String username;

    @Column(name = "password", length = 32)
    public String password;

    @Column(name = "account_non_expired", nullable = false)
    @Type(type = "java.lang.Boolean")
    public boolean accountNonExpired = true;

    @Column(name = "account_non_locked")
    @Type(type = "java.lang.Boolean")
    public boolean accountNonLocked = true;

    @Column(name = "credentials_non_expired")
    @Type(type = "java.lang.Boolean")
    public boolean credentialsNonExpired = true;

    @Column(name = "enabled")
    @Type(type = "java.lang.Boolean")
    public boolean enabled = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "userbase_authoritybase",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "authority_id")}
    )
    public List<com.cn.userbaseservice.jpa.entity.AuthorityBase> authorities = new ArrayList<AuthorityBase>();

}
