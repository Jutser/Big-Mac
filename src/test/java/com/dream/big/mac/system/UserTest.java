package com.dream.big.mac.system;

import com.dream.big.mac.BigMacApplication;
import com.dream.big.mac.system.model.User;
import com.dream.big.mac.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: JiangChen
 * @Description:用户测试类
 * @Date 2018/4/13 23:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BigMacApplication.class)
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void saveUser(){
        User user = new User();
        user.setUserAccount("admin");
        user.setPassword("123456");
        user.setUserName("超级管理员");
        user.setSex(1);
        user.setCreateName("admin");
        user.setCreateTime(new Date());
        userService.insertUser(user);
    }
}
