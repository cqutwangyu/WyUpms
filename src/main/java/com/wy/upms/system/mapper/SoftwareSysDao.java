package com.wy.upms.system.mapper;

import com.wy.sso.user.domain.RoleInfo;
import com.wy.sso.user.domain.UserPermissionInfo;
import com.wy.upms.system.domain.*;
import com.wy.upms.system.domain.vo.MenuQueryParemsVo;

import java.util.List;
import java.util.Map;

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

    int insertPermission(PermissionInfo permissionInfo);

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

    List<MenuInfo> selectMenuListByParems(MenuQueryParemsVo menuQueryParemsVo);

    List<MenuInfo> selectMenuListByUserIdAndParentId(Integer userId,Integer menuParentId);

    List<MenuInfo> selectMenuRootNodeList(MenuQueryParemsVo menuQueryParemsVo);

    int deletePermissionAndChildren(Map<String, Object> params);

    List<PermissionInfo> selectChildPermissionByParams(Map<String, Object> params);

    List<PermissionInfo> selectChildPermissionByParams(PermissionInfo permissionInfo);

    List<MenuInfo> selectAllMenu();

    List<RoleInfo> selectRoleByUser(Integer userId);

    List<UserPermissionInfo> selectPermissionInfoByUser(Integer userId);

    List<MenuInfo> selectMenuByUser(Integer userId);

    int updatePermissionByParams(Map<String, Object> params);

    PermissionInfo selectParentPermissionByParams(PermissionInfo permissionInfo);

    int updatePermission(PermissionInfo parentPer);

    int insertUserRoleInfo(UserRoleInfo userRoleInfo);

    int deleteUserRoleInfo(Integer flowId);
}
