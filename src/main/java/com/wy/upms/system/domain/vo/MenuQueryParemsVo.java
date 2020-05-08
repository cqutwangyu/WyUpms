package com.wy.upms.system.domain.vo;

/**
 * @author wangyu
 * @title: MenuQueryParems
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/24 14:54
 */
public class MenuQueryParemsVo {
    private Integer sysId;
    private Integer depId;
    private Integer roleId;
    private Integer userId;
    private Integer menuLevel;
    private Integer menuParentId;

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

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }
}
