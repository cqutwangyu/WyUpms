package com.wy.upms.user.service;

import com.wy.upms.user.domain.UserInfo;

/**
 * @author wangyu
 * @title: UserService
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/20 18:46
 */
public interface UserService {
    /**
     * 用户登录
     * @param userInfo
     * @return
     */
    Object login(UserInfo userInfo);

    /**
     * 用户注册
     * @param userInfo
     * @return
     * @throws Exception
     */
    Object register(UserInfo userInfo) throws Exception;

    /**
     * 获取用户信息
     * @return
     */
    Object findUserInfo(String userName);

    /**
     * 获取所有用户信息
     * @return
     */
    Object findAllUserInfo();

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Object removeUserById(String userId);

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    Object updateUserInfo(UserInfo userInfo);
}
