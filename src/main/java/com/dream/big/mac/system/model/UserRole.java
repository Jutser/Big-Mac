package com.dream.big.mac.system.model;

import java.io.Serializable;

/**
 * @Author: JiangChen
 * @Description:用户角色中间表
 * @Date 2018/4/14 14:22
 */
public class UserRole implements Serializable{

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户主键ID
     */
    private Integer usreId;
    /**
     * 角色主键ID
     */
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsreId() {
        return usreId;
    }

    public void setUsreId(Integer usreId) {
        this.usreId = usreId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
