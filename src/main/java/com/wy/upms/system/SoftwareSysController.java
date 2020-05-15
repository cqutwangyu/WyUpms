package com.wy.upms.system;

import com.wy.sso.user.domain.RoleInfo;
import com.wy.upms.framework.AbstractController;
import com.wy.upms.system.domain.*;
import com.wy.upms.system.domain.vo.MenuQueryParemsVo;
import com.wy.upms.system.service.SoftwareSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangyu
 * @title: SystemContoller
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/20 18:31
 */
@Controller
@RequestMapping("/system")
public class SoftwareSysController extends AbstractController {

    @Autowired
    private SoftwareSystemService softwareSystemService;

    /**
     * 新增系统
     *
     * @param softwareSysInfo
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object addSystem(SoftwareSysInfo softwareSysInfo) {
        try {
            return succeed(softwareSystemService.addSystem(softwareSysInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 修改系统
     *
     * @param softwareSysInfo
     * @return
     */
    @PutMapping("/update")
    @ResponseBody
    public Object updateSystem(SoftwareSysInfo softwareSysInfo) {
        try {
            return succeed(softwareSystemService.updateSystem(softwareSysInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 删除系统
     *
     * @param sysId
     * @return
     */
    @DeleteMapping("/remove")
    @ResponseBody
    public Object removeSystem(Integer sysId) {
        try {
            return succeed(softwareSystemService.removeSystem(sysId));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 获取所有系统信息
     *
     * @return
     */
    @GetMapping("/getAll")
    @ResponseBody
    public Object getAllSystem() {
        try {
            return succeed(softwareSystemService.getAllSystem());
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 新增菜单
     *
     * @param menuInfo
     * @return
     */
    @PostMapping("/menu/add")
    @ResponseBody
    public Object addMenu(MenuInfo menuInfo) {
        try {
            return succeed(softwareSystemService.addMenu(menuInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 更新菜单
     *
     * @param menuInfo
     * @return
     */
    @PutMapping("/menu/update")
    @ResponseBody
    public Object updateMenu(MenuInfo menuInfo) {
        try {
            return succeed(softwareSystemService.updateMenu(menuInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @return
     */
    @DeleteMapping("/menu/remove")
    @ResponseBody
    public Object removeMenu(Integer menuId) {
        try {
            return succeed(softwareSystemService.removeMenu(menuId));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    @GetMapping("/menu/getAll")
    @ResponseBody
    public Object getAll(Integer sysId) {
        try {
            return succeed(softwareSystemService.getAllMenu(sysId));
        } catch (Exception e) {
            return failure(e);
        }
    }
    /**
     * 根据条件查询菜单及权限
     *
     * @param menuQueryParemsVo
     * @return
     */
    @PostMapping("/menu/list")
    @ResponseBody
    public Object listMenu(MenuQueryParemsVo menuQueryParemsVo) {
        try {
            return succeed(softwareSystemService.listMenu(menuQueryParemsVo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 获取路由信息
     *
     * @return
     */
    @GetMapping("/getRouters")
    @ResponseBody
    public Object getRouters(String sysName) throws Exception {
        if(sysName==null){
            throw new Exception("获取路由时系统名称不能为空");
        }
        try {
            return succeed(softwareSystemService.getRouters(sysName));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 新增角色
     *
     * @param roleInfo
     * @return
     */
    @PostMapping("/role/add")
    @ResponseBody
    public Object addRole(RoleInfo roleInfo) {
        try {
            return succeed(softwareSystemService.addRole(roleInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 更新角色
     *
     * @param roleInfo
     * @return
     */
    @PutMapping("/role/update")
    @ResponseBody
    public Object updateRole(RoleInfo roleInfo) {
        try {
            return succeed(softwareSystemService.updateRole(roleInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @DeleteMapping("/role/remove")
    @ResponseBody
    public Object removeRole(Integer roleId) {
        try {
            return succeed(softwareSystemService.removeRole(roleId));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping("/role/getAll")
    @ResponseBody
    public Object getAllRole() {
        try {
            return succeed(softwareSystemService.getAllRole());
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 新增部门
     *
     * @param departmentInfo
     * @return
     */
    @PostMapping("/dep/add")
    @ResponseBody
    public Object add(DepartmentInfo departmentInfo) {
        try {
            return succeed(softwareSystemService.addDepartment(departmentInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 更新部门
     *
     * @param departmentInfo
     * @return
     */
    @PutMapping("/dep/update")
    @ResponseBody
    public Object updatedep(DepartmentInfo departmentInfo) {
        try {
            return succeed(softwareSystemService.updateDepartment(departmentInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 删除部门
     *
     * @param depId
     * @return
     */
    @DeleteMapping("/dep/remove")
    @ResponseBody
    public Object removeDepartment(Integer depId) {
        try {
            return succeed(softwareSystemService.removeDepartment(depId));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping("/dep/getAll")
    @ResponseBody
    public Object getAllDepartment() {
        try {
            return succeed(softwareSystemService.getAllDepartment());
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 更新权限
     *
     * @param permissionInfo
     * @return
     */
    @PutMapping("/permission/update")
    @ResponseBody
    public Object UpdatePermission(PermissionInfo permissionInfo) {
        try {
            if (permissionInfo.getSysId() == null || permissionInfo.getMenuId() == null) {
                return failure("请选择系统和菜单");
            }
            if (permissionInfo.getDepId() == null && permissionInfo.getRoleId() == null && permissionInfo.getUserId() == null) {
                return failure("请选择部门或角色、用户");
            }
            return succeed(softwareSystemService.putPermission(permissionInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }
}
