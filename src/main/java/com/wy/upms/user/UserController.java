package com.wy.upms.user;

import com.wy.sso.user.domain.UserInfo;
import com.wy.upms.framework.AbstractController;
import com.wy.upms.redis.RedisCache;
import com.wy.upms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangyu
 * @title: UserContoller
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/20 18:22
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 用户登录
     *
     * @param userInfo
     * @return token
     */
    @PostMapping("/login")
    @ResponseBody
    public Object login(UserInfo userInfo) {
        try {
            return succeed(userService.login(userInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Object logout() {
        return succeed("退出成功");
    }
    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/getInfo")
    @ResponseBody
    public Object getInfo() {
        try {
//            return succeed(userService.findUserInfo(getUserName()));
            return succeed(currentUser());
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 用户注册
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public Object register(UserInfo userInfo) {
        try {
            return succeed(userService.register(userInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping("/getAll")
    @ResponseBody
    public Object getAllUser() {
        try {
            return succeed(userService.findAllUserInfo());
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @DeleteMapping("/remove")
    @ResponseBody
    public Object deleteUser(String userId) {
        try {
            return succeed(userService.removeUserById(userId));
        } catch (Exception e) {
            return failure(e);
        }
    }

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    @PutMapping("/update")
    @ResponseBody
    public Object updateUser(UserInfo userInfo) {
        try {
            return succeed(userService.updateUserInfo(userInfo));
        } catch (Exception e) {
            return failure(e);
        }
    }
}
