package com.wy.upms.system.service;

import com.wy.sso.user.domain.RoleInfo;
import com.wy.upms.framework.AbstractService;
import com.wy.upms.system.domain.DepartmentInfo;
import com.wy.upms.system.domain.MenuInfo;
import com.wy.upms.system.domain.PermissionInfo;
import com.wy.upms.system.domain.SoftwareSysInfo;
import com.wy.upms.system.domain.vo.MenuQueryParemsVo;
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
    public Object putPermission(PermissionInfo permissionInfo) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", permissionInfo.getSysId());
        params.put("userId", permissionInfo.getUserId());
        params.put("roleId", permissionInfo.getRoleId());
        params.put("depId", permissionInfo.getDepId());
        params.put("menuId", permissionInfo.getMenuId());
        deletePermission(params);
        return result(softwareSysDao.insertPermissionInfo(permissionInfo));
    }

    private void deletePermission(Map<String, Object> params) {
        List<PermissionInfo> list = softwareSysDao.selectPermissionInfoByMenuId(params);
        Integer menuRootId = (Integer) params.get("menuId");
        for (PermissionInfo p : list) {
            params.put("menuId", p.getMenuId());
            deletePermission(params);
            softwareSysDao.deletePermissionAndChildren(params);
        }
        params.put("menuId", menuRootId);
        softwareSysDao.deletePermissionAndChildren(params);
    }

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
    public Object getRouters() {
        List<MenuInfo> menuList;
        if (isAdmin()) {
            menuList = softwareSysDao.selectAllMenu();
        } else {
            menuList = softwareSysDao.selectMenuByUser(currentUser().getFlowId());
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
    public Object getAllMenu() {
        List<MenuInfo> menuInfoList = softwareSysDao.selectAllMenu();
        return buildMenuTree(menuInfoList);
    }


    private List<RouterVo> buildRouters(List<MenuInfo> menuList) {
        List<RouterVo> routerVoList = new ArrayList<>();
        for (MenuInfo menu : menuList) {
            RouterVo routerVo = new RouterVo(menu);
            if (menu.getMenuLevel().equals(0)) {
                routerVo.setAlwaysShow(true);
                routerVo.setRedirect("noRedirect");
            } else {
                routerVo.setAlwaysShow(false);
            }
            routerVo.setChildren(buildRouters(menu.getChildren()));
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
