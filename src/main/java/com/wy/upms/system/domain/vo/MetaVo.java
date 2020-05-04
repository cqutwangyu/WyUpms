package com.wy.upms.system.domain.vo;

/**
 * @author wangyu
 * @title: MetaInfo
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/5/3 19:31
 */
public class MetaVo {
    private String title;
    private String icon;

    public MetaVo(String menuName, String icon) {
        this.title=menuName;
        this.icon=icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
