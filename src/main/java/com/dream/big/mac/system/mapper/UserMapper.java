package com.dream.big.mac.system.mapper;

import com.dream.big.mac.system.model.User;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/13 22:38
 */
public interface UserMapper {

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
