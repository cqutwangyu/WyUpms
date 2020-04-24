package com.wy.upms.system.domain;

/**
 * @author wangyu
 * @title: RoleInfo
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/21 14:38
 */
public class RoleInfo {
    private String sysName;
    //db
    private Integer flowId;
    private Integer sysId;
    private String roleName;
    private String createTime;

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "flowId=" + flowId +
                ", sysId=" + sysId +
                ", roleName='" + roleName + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
