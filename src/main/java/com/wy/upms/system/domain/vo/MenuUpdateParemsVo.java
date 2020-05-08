package com.wy.upms.system.domain.vo;

import com.wy.upms.system.domain.MenuInfo;

/**
 * @author wangyu
 * @title: MenuVo
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/5/8 23:38
 */
public class MenuUpdateParemsVo extends MenuInfo {
    private Integer depId;
    private Integer roleId;
    private Integer userId;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
