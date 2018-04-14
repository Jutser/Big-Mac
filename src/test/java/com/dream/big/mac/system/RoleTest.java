package com.dream.big.mac.system;

import com.dream.big.mac.BigMacApplication;
import com.dream.big.mac.system.mapper.RoleMapper;
import com.dream.big.mac.system.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: JiangChen
 * @Description:角色测试类
 * @Date 2018/4/14 15:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BigMacApplication.class)
public class RoleTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void saveUser(){
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        role.setViewName("超级管理员角色");
        role.setIsActive(1);
        role.setCreateName("admin");
        role.setCreateTime(new Date());
        roleMapper.insertRole(role);
    }

}
