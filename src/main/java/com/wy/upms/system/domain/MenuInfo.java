package com.wy.upms.system.domain;

import java.util.List;

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
    private Integer menuLevel;
    private Integer menuParentId;
    private String createTime;

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
    public String toString() {
        return "MenuInfo{" +
                "folwId=" + flowId +
                ", menuName='" + menuName + '\'' +
                ", menuLevel=" + menuLevel +
                ", menuParentId=" + menuParentId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
