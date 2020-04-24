package com.wy.upms.user.service;

import com.wy.upms.framework.AbstractService;
import com.wy.upms.user.domain.UserInfo;
import com.wy.upms.user.mapper.UserDao;
import com.wy.upms.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author wangyu
 * @title: UserServiceImpl
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/20 18:47
 */
@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Object login(UserInfo user) {
        UserInfo db_user = userDao.selectUserByName(user.getUserName());
        if (Objects.isNull(db_user)) {
            return "用户名错误";
        }
        String token = TokenUtil.sign(user.getUserName(), user.getPassword());
        return db_user.getPassword().equals(user.getPassword()) ? token : "密码错误";
    }

    @Override
    public Object register(UserInfo userInfo) throws Exception {
        userDao.insertUser(userInfo);
        return "注册成功";
    }

    @Override
    public Object findUserInfo(String userName) {
        return userDao.selectUserByName(userName);
    }

    @Override
    public Object findAllUserInfo() {
        return userDao.selectAllUser();
    }

    @Override
    public Object removeUserById(String userId) {
        return userDao.deleteUserById(userId) == 1 ? "删除成功" : "删除失败";
    }

    @Override
    public Object updateUserInfo(UserInfo userInfo) {
        return userDao.updateUser(userInfo) == 1 ? "更新成功" : "更新失败";
    }
}
