package com.wy.upms.system.domain;

/**
 * @author wangyu
 * @title: PermissionInfo
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/21 14:59
 */
public class PermissionInfo {
    private Integer depId;
    private Integer userId;
    //db
    private Integer flowId;
    private Integer roleId;
    private Integer sysId;
    private Integer menuId;
    private Integer menuParentId;

    private Boolean query;
    private Boolean edit;
    private Boolean export;
    private Boolean impower;
    private String createTime;

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Boolean getQuery() {
        return query;
    }

    public void setQuery(Boolean query) {
        this.query = query;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    public Boolean getExport() {
        return export;
    }

    public void setExport(Boolean export) {
        this.export = export;
    }

    public Boolean getImpower() {
        return impower;
    }

    public void setImpower(Boolean impower) {
        this.impower = impower;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PermissionInfo{" +
                "flowId=" + flowId +
                ", roleId=" + roleId +
                ", sysId=" + sysId +
                ", menuId=" + menuId +
                ", query=" + query +
                ", edit=" + edit +
                ", export=" + export +
                ", impower=" + impower +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
