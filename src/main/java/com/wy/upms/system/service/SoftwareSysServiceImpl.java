package com.wy.upms.system.service;

import com.wy.upms.framework.AbstractService;
import com.wy.upms.system.domain.*;
import com.wy.upms.system.mapper.SoftwareSysDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
        deletePermission(permissionInfo.getSysId(),permissionInfo.getRoleId(),permissionInfo.getMenuId());
        return result(softwareSysDao.insertPermissionInfo(permissionInfo));
    }

    private void deletePermission(Integer sysId,Integer roleId,Integer menuId) {
        List<PermissionInfo> list = softwareSysDao.selectPermissionInfoByMenuId(menuId);
        for (PermissionInfo p : list) {
            deletePermission(sysId,roleId,p.getMenuId());
            softwareSysDao.deletePermissionAndChildren(sysId,roleId,p.getMenuId());
        }
        softwareSysDao.deletePermissionAndChildren(sysId,roleId,menuId);
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
    public Object listMenu(MenuQueryParems menuQueryParems) {
        List<MenuInfo> rootNodeList = softwareSysDao.selectMenuRootNodeList(menuQueryParems);
        setChildren(rootNodeList, menuQueryParems);
        return rootNodeList;
    }

    private void setChildren(List<MenuInfo> parentNodeList, MenuQueryParems menuQueryParems) {
        for (MenuInfo node : parentNodeList) {
            menuQueryParems.setMenuParentId(node.getFlowId());
            List<MenuInfo> menuNodeInfos = softwareSysDao.selectMenuListByParentId(menuQueryParems);
            for (MenuInfo children : menuNodeInfos) {
                if (children.getQuery() == null || children.getEdit() == null || children.getExport() == null || children.getImpower() == null) {
                    children.setQuery(node.getQuery());
                    children.setEdit(node.getEdit());
                    children.setExport(node.getExport());
                    children.setImpower(node.getImpower());
                }
            }
            node.setChildren(menuNodeInfos);
            if (Objects.isNull(menuNodeInfos)) {
                return;
            } else {
                setChildren(menuNodeInfos, menuQueryParems);
            }
        }

    }
}
