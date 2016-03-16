package com.service;

import com.request.UserRequest;
import com.response.Result;
import com.response.UserInfoResponse;

import java.util.List;

/**
 * Created by ZhenXi on 2016/1/15.
 */
public interface UserService {

    public Result getUser(UserRequest userRequest);

    public Result addUser(List<String> snos);

    public Result updateUser(UserRequest userRequest);

    public Result changePwd(UserRequest userRequest);

    public Result updateUserInfo(UserRequest userRequest);

    public Result<UserInfoResponse> getUserInfo(Long userId);
}
