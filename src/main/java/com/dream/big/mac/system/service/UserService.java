package com.dream.big.mac.system.service;

import com.dream.big.mac.system.model.User;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/13 22:39
 */
public interface UserService {

    /**
     *  根据账号获取登陆信息
     * @param account
     * @return
     */
    User getUserByAccount(String account);

    /**
     *  新增用户
     * @param user
     * @return
     */
     int insertUser(User user);
}
