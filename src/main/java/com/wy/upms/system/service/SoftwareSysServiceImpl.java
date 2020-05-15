package com.wy.upms.system.service;

import com.wy.sso.user.domain.RoleInfo;
import com.wy.upms.framework.AbstractService;
import com.wy.upms.system.domain.DepartmentInfo;
import com.wy.upms.system.domain.MenuInfo;
import com.wy.upms.system.domain.PermissionInfo;
import com.wy.upms.system.domain.SoftwareSysInfo;
import com.wy.upms.system.domain.vo.MenuQueryParemsVo;
import com.wy.upms.system.domain.vo.MetaVo;
import com.wy.upms.system.domain.vo.RouterVo;
import com.wy.upms.system.mapper.SoftwareSysDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author wangyu
 * @title: SystemServiceImpl
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/21 13:56
 */
@Service
public class SoftwareSysServiceImpl extends AbstractService implements SoftwareSystemService {

    @Autowired
    private SoftwareSysDao softwareSysDao;

    @Override
    public Object addSystem(SoftwareSysInfo softwareSysInfo) throws Exception {
        return result(softwareSysDao.insertSystemInfo(softwareSysInfo));
    }

    @Override
    public Object addRole(RoleInfo roleInfo) throws Exception {
        return result(softwareSysDao.insertRoleInfo(roleInfo));
    }

    @Override
    public Object addMenu(MenuInfo menuInfo) throws Exception {
        return result(softwareSysDao.insertMenuInfo(menuInfo));
    }

    @Override
    @Transactional
    public Object putPermission(PermissionInfo perInfo) throws Exception {
        int flag = 0;
        if (perInfo.getFlowId() == null) {
            flag = softwareSysDao.insertPermission(perInfo);
        } else {
            flag = softwareSysDao.updatePermission(perInfo);
        }
        updateChildPermission(perInfo);
        updateParentPermission(perInfo);
        return result(flag);
    }

    private void updateChildPermission(PermissionInfo parentPer) {
        List<PermissionInfo> childPerList = softwareSysDao.selectChildPermissionByParams(parentPer);
        if (childPerList.isEmpty()) {
            buildChildPermissions(parentPer, true);
        }
        for (PermissionInfo childPer : childPerList) {
            childPer.setQuery(parentPer.getQuery());
            childPer.setEdit(parentPer.getEdit());
            childPer.setExport(parentPer.getExport());
            childPer.setImpower(parentPer.getImpower());
            softwareSysDao.updatePermission(childPer);
        }
    }

    private void updateParentPermission(PermissionInfo childPer) {
        if (childPer.getMenuParentId() != -1) {
            PermissionInfo parentPer = softwareSysDao.selectParentPermissionByParams(childPer);
            if (parentPer == null) {
                parentPer = new PermissionInfo();
                parentPer.setUserId(childPer.getUserId());
                parentPer.setSysId(childPer.getSysId());
                parentPer.setRoleId(childPer.getRoleId());
                parentPer.setDepId(childPer.getDepId());
                parentPer.setMenuId(childPer.getMenuParentId());
                parentPer.setMenuParentId(-1);
                parentPer.setQuery(false);
                parentPer.setEdit(false);
                parentPer.setExport(false);
                parentPer.setImpower(false);
                softwareSysDao.insertPermission(parentPer);
                buildChildPermissions(parentPer, childPer, false);
                return;
            }
            List<PermissionInfo> childPerList = softwareSysDao.selectChildPermissionByParams(parentPer);
            boolean query = false, edit = true, export = true, impower = true;
            for (PermissionInfo cp : childPerList) {
                if (cp.getQuery()) {
                    query = true;
                }
                if (!cp.getEdit()) {
                    edit = false;
                }
                if (!cp.getExport()) {
                    export = false;
                }
                if (!cp.getImpower()) {
                    impower = false;
                }

            }
            parentPer.setQuery(query);
            parentPer.setEdit(edit);
            parentPer.setExport(export);
            parentPer.setImpower(impower);
            softwareSysDao.updatePermission(parentPer);
        }
    }

    private void buildChildPermissions(PermissionInfo parentPer, boolean isParent) {
        buildChildPermissions(parentPer, parentPer, isParent);
    }

    private void buildChildPermissions(PermissionInfo parentPer, PermissionInfo currentPer, boolean isParent) {
        MenuQueryParemsVo menuQueryParemsVo = new MenuQueryParemsVo();
        menuQueryParemsVo.setUserId(parentPer.getUserId());
        menuQueryParemsVo.setSysId(parentPer.getSysId());
        menuQueryParemsVo.setDepId(parentPer.getDepId());
        menuQueryParemsVo.setRoleId(parentPer.getRoleId());
        menuQueryParemsVo.setMenuParentId(parentPer.getMenuId());
        List<MenuInfo> menuInfoList = softwareSysDao.selectMenuListByParems(menuQueryParemsVo);
        for (MenuInfo menu : menuInfoList) {
            if (menu.getFlowId().equals(currentPer.getMenuId())) {
                continue;
            }
            PermissionInfo p = new PermissionInfo();
            p.setUserId(parentPer.getUserId());
            p.setSysId(parentPer.getSysId());
            p.setDepId(parentPer.getDepId());
            p.setRoleId(parentPer.getRoleId());
            p.setMenuId(menu.getFlowId());
            p.setMenuParentId(parentPer.getMenuId());
            p.setQuery(true);
            p.setEdit(isParent ? parentPer.getEdit() : false);
            p.setExport(isParent ? parentPer.getExport() : false);
            p.setImpower(isParent ? parentPer.getImpower() : false);
            softwareSysDao.insertPermission(p);
        }
    }

//    private void updatePermission(Map<String, Object> params) {
//        List<PermissionInfo> list = softwareSysDao.selectChildPermissionByParams(params);
//        Integer menuRootId = (Integer) params.get("menuId");
//        for (PermissionInfo p : list) {
//            params.put("menuId", p.getMenuId());
//            updatePermission(params);
//            softwareSysDao.deletePermissionAndChildren(params);
//        }
//        params.put("menuId", menuRootId);
//        softwareSysDao.deletePermissionAndChildren(params);
//    }

    @Override
    public Object getAllRole() {
        return softwareSysDao.selectAllRole();
    }

    @Override
    public Object removeRole(Integer roleId) {
        return result(softwareSysDao.deleteRoleById(roleId));
    }

    @Override
    public Object updateRole(RoleInfo roleInfo) {
        return result(softwareSysDao.updateRole(roleInfo));
    }

    @Override
    public Object addDepartment(DepartmentInfo departmentInfo) {
        return result(softwareSysDao.insertDepartmentInfo(departmentInfo));
    }

    @Override
    public Object updateDepartment(DepartmentInfo departmentInfo) {
        return result(softwareSysDao.updateDepartmentInfo(departmentInfo));
    }

    @Override
    public Object removeDepartment(Integer depId) {
        return result(softwareSysDao.deleteDepartmentById(depId));
    }

    @Override
    public Object getAllDepartment() {
        return softwareSysDao.selectAllDepartment();
    }

    @Override
    public Object updateSystem(SoftwareSysInfo softwareSysInfo) {
        return result(softwareSysDao.updateSoftwareSysInfo(softwareSysInfo));
    }

    @Override
    public Object removeSystem(Integer sysId) {
        return result(softwareSysDao.deleteSystemById(sysId));
    }

    @Override
    public Object getAllSystem() {
        return softwareSysDao.selectAllSystem();
    }

    @Override
    public Object updateMenu(MenuInfo menuInfo) {
        return result(softwareSysDao.updateMenu(menuInfo));
    }

    @Override
    public Object removeMenu(Integer menuId) {
        return result(softwareSysDao.deleteMenuById(menuId));
    }

    @Override
    public Object listMenu(MenuQueryParemsVo menuQueryParemsVo) {
        List<MenuInfo> rootNodeList = softwareSysDao.selectMenuRootNodeList(menuQueryParemsVo);
        buildMenuTree(rootNodeList, menuQueryParemsVo);
        return rootNodeList;
    }

    @Override
    public Object getRouters(String sysName) {
        Integer sysId = softwareSysDao.selectSystemIdBySystemName(sysName);
        List<MenuInfo> menuList;
        if (isAdmin()) {
            menuList = softwareSysDao.selectAllMenu(sysId);
        } else {
            menuList = softwareSysDao.selectMenuByUser(sysId, currentUser().getFlowId());
            int count = menuList.size();
            for (int i = 0; i < count; i++) {
                MenuInfo parentMenu = menuList.get(i);
                List<MenuInfo> childMenuList = softwareSysDao.selectMenuListByUserIdAndParentId(currentUser().getFlowId(), parentMenu.getFlowId());
                for (MenuInfo childMenu : childMenuList) {
                    if (childMenu.getQuery() == null || childMenu.getQuery() && parentMenu.getQuery()) {
                        if (!menuList.contains(childMenu)) {
                            menuList.add(childMenu);
                        }
                    }
                }
            }
        }
        List<MenuInfo> menuTreeList = buildMenuTree(menuList);
        List<RouterVo> routerVoList = buildRouters(menuTreeList);
        return routerVoList;
    }

    @Override
    public Object getAllMenu(Integer sysId) {
        List<MenuInfo> menuInfoList = softwareSysDao.selectAllMenu(sysId);
        return buildMenuTree(menuInfoList);
    }


    private List<RouterVo> buildRouters(List<MenuInfo> menuList) {
        return buildRouters(menuList, "/");
    }

    private List<RouterVo> buildRouters(List<MenuInfo> menuList, String parentPath) {
        List<RouterVo> routerVoList = new ArrayList<>();
        for (MenuInfo menu : menuList) {
            RouterVo routerVo = new RouterVo(menu);
            routerVo.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon()));
            routerVo.setName(menu.getPath());
            routerVo.setComponent(menu.getComponent());
            routerVo.setPath(parentPath + menu.getPath());
            if (menu.getMenuLevel().equals(0)) {
                routerVo.setAlwaysShow(true);
                routerVo.setRedirect("noRedirect");
            } else {
                routerVo.setAlwaysShow(false);
            }
            routerVo.setChildren(buildRouters(menu.getChildren(), ""));
            routerVoList.add(routerVo);
        }
        return routerVoList;
    }

    /**
     * 遍历根节点
     *
     * @param menuList
     * @return
     */
    private List<MenuInfo> buildMenuTree(List<MenuInfo> menuList) {
        List<MenuInfo> nodeRootList = new ArrayList<>();
        for (MenuInfo menu : menuList) {
            if (menu.getMenuLevel() == 0) {
                menu.setChildren(getChildren(menuList, menu.getFlowId()));
                nodeRootList.add(menu);
            }
        }
        return nodeRootList;
    }

    /**
     * 获取子节点
     *
     * @param menuList
     * @param parentId
     * @return
     */
    private List<MenuInfo> getChildren(List<MenuInfo> menuList, Integer parentId) {
        List<MenuInfo> childList = new ArrayList<>();
        for (MenuInfo menu : menuList) {
            if (menu.getMenuParentId().equals(parentId)) {
                menu.setChildren(getChildren(menuList, menu.getFlowId()));
                childList.add(menu);
            }
        }
        return childList;
    }

    /**
     * 权限管理系统中，授权页面树形节点构造
     *
     * @param parentNodeList
     * @param menuQueryParemsVo
     */
    private void buildMenuTree(List<MenuInfo> parentNodeList, MenuQueryParemsVo menuQueryParemsVo) {
        for (MenuInfo node : parentNodeList) {
            menuQueryParemsVo.setMenuParentId(node.getFlowId());
            List<MenuInfo> childMenuNodeInfos = softwareSysDao.selectMenuListByParems(menuQueryParemsVo);
            for (MenuInfo children : childMenuNodeInfos) {
                if (children.getQuery() == null || children.getEdit() == null || children.getExport() == null || children.getImpower() == null) {
                    children.setQuery(node.getQuery());
                    children.setEdit(node.getEdit());
                    children.setExport(node.getExport());
                    children.setImpower(node.getImpower());
                }
            }
            node.setChildren(childMenuNodeInfos);
            if (Objects.isNull(childMenuNodeInfos)) {
                return;
            } else {
                buildMenuTree(childMenuNodeInfos, menuQueryParemsVo);
            }
        }

    }
}
