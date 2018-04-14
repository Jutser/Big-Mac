package com.dream.big.mac;

import com.dream.big.mac.system.mapper.RoleMapper;
import com.dream.big.mac.system.mapper.UserMapper;
import com.dream.big.mac.system.model.Role;
import com.dream.big.mac.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/14 0:34
 */
public class BigMacUserDetailService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByAccount(username);
        if (user == null) {
            throw new UsernameNotFoundException("username " + username + " not found");
        }
        //用于添加用户的权限
        List<Role> roles = roleMapper.getRoles(user.getUserAccount());
        return new BigMacUserDetails(user,roles);
    }
}
