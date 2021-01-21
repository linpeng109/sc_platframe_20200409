package com.cn.userbaseservice.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "authority_base")
@GenericGenerator(strategy = "uuid", name = "system-uuid")
@Data
public class AuthorityBase implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "authority_id", length = 32)
    public String authorityId;

    @Column(name = "authority", length = 100, unique = true)
    public String authority;

}
