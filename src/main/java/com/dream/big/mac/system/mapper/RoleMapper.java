package com.dream.big.mac.system.mapper;

import com.dream.big.mac.system.model.Role;

import java.util.List;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/4/14 14:51
 */
public interface RoleMapper {

    /**
     *  根据账号获取角色信息
     * @param account
     * @return
     */
    List<Role> getRoles(String account);

    /**
     *  保存角色信息
     * @param role
     * @return
     */
    int insertRole(Role role);

}
