package com.dao;

import com.entity.User;
import com.entity.UserInfo;

/**
 * Created by ZhenXi on 2016/1/13.
 */
public interface UserDAO {

    public Long addUser(User user);

    public Long changePwd(String password, Long userId);

    public Long addUserInfo(UserInfo userInfo);

    public Long updateUserInfo(UserInfo userInfo);

    public String getUserByEmail(String email);

    public User getUser(String email, String password);

    public UserInfo getUserInfo(Long userId);
}
