package com.service.impl;

import com.dao.UserDAO;
import com.entity.User;
import com.entity.UserInfo;
import com.request.UserRequest;
import com.response.Result;
import com.response.UserInfoResponse;
import com.service.UserService;
import com.utils.ConvertUtils;
import com.utils.ErrorCodeEnum;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhenXi on 2016/1/15.
 */
@Component("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public Result getUser(UserRequest userRequest) {
        User user = userDAO.getUser(userRequest.getEmail(), userRequest.getPassword());
        if (user == null) {
            return new Result(ErrorCodeEnum.NO_USER);
        }
        if (!user.getPassword().equals(userRequest.getPassword())) {
            return new Result(ErrorCodeEnum.ERROR_USER);
        }
        return new Result(ConvertUtils.convert(user));
    }

    @Override
    @Transactional
    public Result addUser(List<UserRequest> userRequests) {
        /*if (userDAO.getUser(userRequest.getEmail(), userRequest.getPassword()) != null) {
            return new Result(ErrorCodeEnum.EXIST_USER);
        }
        userRequest.setUserId(userDAO.addUser(convertToUser(userRequest)));
        UserInfo userInfo = convertToUserInfo(userRequest);
        if (userRequest.getUserId() == 0 || userDAO.addUserInfo(userInfo) == 0) {
            return new Result(ErrorCodeEnum.ADD_ERROR);
        }
        return new Result(userRequest.getUserId());*/
        int num = 0;
        for (UserRequest userRequest : userRequests) {
            if (userDAO.getUserByEmail(userRequest.getEmail()) == null) {
                User user = new User();
                user.setEmail(userRequest.getEmail());
                user.setPassword(userRequest.getEmail());
                user.setNick(userRequest.getEmail());
                user.setRole(userRequest.getRole());
                Long userId = userDAO.addUser(user);
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(userId);
                userInfo.setPhone(userRequest.getPhone());
                userInfo.setQuestion("我的学号是？");
                userInfo.setAnswer(userRequest.getEmail());
                if (userId == 0 || userDAO.addUserInfo(userInfo) == 0) {
                    return new Result(ErrorCodeEnum.ADD_ERROR);
                }
                num ++;
            }
        }
        return new Result(num);
    }

    @Override
    public Result updateUser(UserRequest userRequest) {
        if (userDAO.updateUser(userRequest.getNick(), userRequest.getUserId()) == 0) {
            return new Result(ErrorCodeEnum.UPDATE_ERROR);
        }
        return new Result(userRequest.getUserId());
    }

    @Override
    public Result changePwd(UserRequest userRequest) {
        if (!userDAO.getUserById(userRequest.getUserId()).getPassword().equals(userRequest.getPassword())) {
            return new Result(ErrorCodeEnum.EROOR_PASSWORD);
        }
        if (userDAO.changePwd(userRequest.getNewPassword(), userRequest.getUserId()) == 0) {
            return new Result(ErrorCodeEnum.UPDATE_ERROR);
        }
        return new Result(userRequest.getUserId());
    }

    @Override
    public Result updateUserInfo(UserRequest userRequest) {
        if (userDAO.updateUserInfo(convertToUserInfo(userRequest)) == 0) {
            return new Result(ErrorCodeEnum.UPDATE_ERROR);
        }
        return new Result(userRequest.getUserId());
    }

    @Override
    public Result<UserInfoResponse> getUserInfo(Long userId) {
        UserInfo userInfo = userDAO.getUserInfo(userId);
        if(userInfo == null) {
            return new Result<>(ErrorCodeEnum.NO_USER);
        }
        return new Result<>(ConvertUtils.convert(userInfo));
    }

    @Override
    public Result<UserInfoResponse> getUserInfoByEmail(String email) {
        User user = userDAO.getUser(email, null);
        if(user == null){
            return new Result<>(ErrorCodeEnum.NO_USER);
        }
        return new Result<>(ConvertUtils.convert(userDAO.getUserInfo(user.getUserId())));
    }

    @Override
    public Result getPwd(String email) {
        User user = userDAO.getUser(email, null);
        return new Result(user.getPassword());
    }

    private User convertToUser(UserRequest userRequest) {
        User user = new User();
        user.setNick(userRequest.getNick());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return user;
    }

    private UserInfo convertToUserInfo(UserRequest userRequest) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userRequest.getUserId());
        userInfo.setName(userRequest.getName());
        userInfo.setDesc(userRequest.getDesc());
        userInfo.setBirthday(userRequest.getBirthday());
        userInfo.setPhone(userRequest.getPhone());
        userInfo.setQuestion(userRequest.getQuestion());
        userInfo.setAnswer(userRequest.getAnswer());
        return userInfo;
    }
}
