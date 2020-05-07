package com.wy.upms.system.mapper;

import com.wy.sso.user.domain.RoleInfo;
import com.wy.sso.user.domain.UserPermissionInfo;
import com.wy.upms.system.domain.*;

import java.util.List;

/**
 * @author wangyu
 * @title: SystemDao
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/21 13:58
 */
public interface SoftwareSysDao {

    int insertSystemInfo(SoftwareSysInfo softwareSysInfo);

    int insertRoleInfo(RoleInfo roleInfo);

    int insertMenuInfo(MenuInfo menuInfo);

    int insertPermissionInfo(PermissionInfo permissionInfo);

    List<RoleInfo> selectAllRole();

    int deleteRoleById(Integer roleId);

    int updateRole(RoleInfo roleInfo);

    int insertDepartmentInfo(DepartmentInfo departmentInfo);

    int updateDepartmentInfo(DepartmentInfo departmentInfo);

    int deleteDepartmentById(Integer depId);

    List<DepartmentInfo> selectAllDepartment();

    int updateSoftwareSysInfo(SoftwareSysInfo softwareSysInfo);

    int deleteSystemById(Integer sysId);

    List<SoftwareSysInfo> selectAllSystem();

    int updateMenu(MenuInfo menuInfo);

    int deleteMenuById(Integer menuId);

    List<MenuInfo> selectMenuListByParentId(Integer menuParentId);

    List<MenuInfo> selectMenuRootNodeList(MenuQueryParems menuQueryParems);

    int deletePermissionAndChildren(Integer sysId, Integer roleId, Integer menuId);

    List<PermissionInfo> selectPermissionInfoByMenuId(Integer menuId);

    List<MenuInfo> selectAllMenu();

    List<RoleInfo> selectRoleByUser(Integer flowId);

    List<UserPermissionInfo> selectPermissionInfoByUser(Integer flowId);

    List<MenuInfo> selectMenuByUser(Integer flowId);
}
