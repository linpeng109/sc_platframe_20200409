package com.cn.sercurity.config;

import com.alibaba.fastjson.JSONObject;
import com.cn.sercurity.web.service.UserBaseService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserBaseService userBaseService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String json_userDetails = userBaseService.loadByUsername(username);
        /*
         * 将自定义的用户与权限信息转换为User对象（包含Authority对象组）
         */
        JSONObject jsonObject = JSONObject.parseObject(json_userDetails);
        UserDetailsImpl user = new UserDetailsImpl();
        user.setUserId(jsonObject.getString("userId"));
        user.setUsername(jsonObject.getString("username"));
        user.setPassword(jsonObject.getString("password"));
        user.setAccountNonExpired(jsonObject.getBoolean("accountNonExpired"));
        user.setAccountNonLocked(jsonObject.getBoolean("accountNonLocked"));
        user.setCredentialsNonExpired(jsonObject.getBoolean("credentialsNonExpired"));
        user.setEnabled(jsonObject.getBoolean("enabled"));
        Set<GrantedAuthorityImpl> authorities = new HashSet<>();
        List<Object> grantedAuthorityList = jsonObject.getJSONArray("authorities");
        for (Object o : grantedAuthorityList) {
            JSONObject object = (JSONObject) o;
            String authorityId = object.getString("authorityId");
            String authority = object.getString("authority");
            GrantedAuthorityImpl grantedAuthority = new GrantedAuthorityImpl();
            grantedAuthority.setAuthorityId(authorityId);
            grantedAuthority.setAuthority(authority);
            authorities.add(grantedAuthority);
        }
//        System.out.println(authorities);
        user.setAuthorities(authorities);
        return user;
    }

}
