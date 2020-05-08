package com.wy.upms.system.domain;

import java.util.List;
import java.util.Objects;

/**
 * @author wangyu
 * @title: MenuInfo
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/21 14:47
 */
public class MenuInfo {
    private List<MenuInfo> children;
    private Boolean query;
    private Boolean edit;
    private Boolean export;
    private Boolean impower;
    //db
    private Integer flowId;
    private Integer sysId;
    private String menuName;
    private String path;
    private String component;
    private String icon;
    private String perms;
    private Integer orderNum;
    private Integer menuLevel;
    private Integer menuParentId;
    private String createTime;

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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

    public List<MenuInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuInfo> children) {
        this.children = children;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuInfo menuInfo = (MenuInfo) o;
        return Objects.equals(flowId, menuInfo.flowId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, query, edit, export, impower, flowId, sysId, menuName, path, component, icon, perms, orderNum, menuLevel, menuParentId, createTime);
    }
}
