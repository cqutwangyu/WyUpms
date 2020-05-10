package com.wy.upms.system.domain.vo;

import com.wy.upms.system.domain.MenuInfo;

import java.util.List;

/**
 * @author wangyu
 * @title: RouterVo
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/5/3 19:36
 */
public class RouterVo {
    private boolean alwaysShow;
    private List<RouterVo> children;
    private MetaVo meta;
    private String name;
    private String component;
    private String path;
    private String redirect;

    public RouterVo(MenuInfo menu) {
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isAlwaysShow() {
        return alwaysShow;
    }

    public void setAlwaysShow(boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    public List<RouterVo> getChildren() {
        return children;
    }

    public void setChildren(List<RouterVo> children) {
        this.children = children;
    }

    public MetaVo getMeta() {
        return meta;
    }

    public void setMeta(MetaVo meta) {
        this.meta = meta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
}
