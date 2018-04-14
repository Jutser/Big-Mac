package com.dream.big.mac.system.service.impl;

import com.dream.big.mac.passwordSecurity.PasswordEncrypting;
import com.dream.big.mac.system.mapper.UserMapper;
import com.dream.big.mac.system.model.User;
import com.dream.big.mac.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/13 22:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public int insertUser(User user) {
        try{
            //用户密码加密
            String password = "123456" + "{" + user.getUserAccount() + "}";
            password = PasswordEncrypting.getHashEnocde(password);
            user.setPassword(password);
            userMapper.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
}
