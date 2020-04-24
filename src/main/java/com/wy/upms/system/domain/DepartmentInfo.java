package com.wy.upms.system.domain;

/**
 * @author wangyu
 * @title: department
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/23 14:33
 */
public class DepartmentInfo {
    private String sysName;
    //db
    private Integer flowId;
    private String depName;
    private String sysId;
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

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
