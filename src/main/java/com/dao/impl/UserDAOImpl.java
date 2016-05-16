package com.dao.impl;

import com.dao.UserDAO;
import com.dao.mapper.UserMapper;
import com.entity.User;
import com.entity.UserInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by ZhenXi on 2016/1/13.
 */
@Component("userDAO")
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Resource
    private UserMapper userMapper;

    @Override
    String getTableName() {
        return "user";
    }

    @Override
    public Long addUser(User user) {
        user.setUserId(getSequence());
        return userMapper.addUser(user) == 0 ? 0l : user.getUserId();
    }

    @Override
    public Long changePwd(String password, Long userId) {
        return userMapper.changePwd(password, userId) == 0 ? 0l : userId;
    }

    @Override
    public Long updateUser(String nick, Long userId) {
        return userMapper.updateUser(nick, userId) == 0 ? 0l : userId;
    }

    @Override
    public Long addUserInfo(UserInfo userInfo) {
        return userMapper.addUserInfo(userInfo) == 0 ? 0l : userInfo.getUserId();
    }

    @Override
    public Long updateUserInfo(UserInfo userInfo) {
        return userMapper.updateUserInfo(userInfo) == 0 ? 0l : userInfo.getUserId();
    }

    @Override
    public String getUserByEmail(String email) {
        return userMapper.getEmail(email);
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User getUser(String email, String password) {
        //return userMapper.getUser(email, password);
        return userMapper.getUserByEmail(email);
    }

    @Override
    public UserInfo getUserInfo(Long userId) {
        return userMapper.getUserInfo(userId);
    }
}
