package com.wy.upms.system.domain;

/**
 * @author wangyu
 * @title: SystemInfo
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/21 13:50
 */
public class SoftwareSysInfo {
    private Integer flowId;
    private String sysName;
    private String createTime;

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SoftwareSystemInfo{" +
                "flowId=" + flowId +
                ", systemName='" + sysName + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
