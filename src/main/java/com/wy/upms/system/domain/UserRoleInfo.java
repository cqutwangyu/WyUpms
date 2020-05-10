package com.wy.upms.system.domain;

/**
 * @author wangyu
 * @title: UserRoleInfo
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/5/10 1:39
 */
public class UserRoleInfo {
    private Integer flowId;
    private Integer userId;
    private Integer roleId;

    public UserRoleInfo(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
    public UserRoleInfo() {
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
