package com.dao.mapper;

import com.entity.User;
import com.entity.UserInfo;
import org.apache.ibatis.annotations.*;

/**
 * Created by ZhenXi on 2016/1/12.
 */
public interface UserMapper {

    final static String COLUMN_ALL_USER = "user_id,email,nick,password,role,create_date,modified_date";
    final static String COLUMN_ALL_USER_INFO = "user_id,name,`desc`,birthday,phone,create_date,modified_date";

    @Insert("insert into user(" + COLUMN_ALL_USER +") values(#{userId},#{email},#{nick},#{password},#{role},now(),now())")
    int addUser(User user);

    @Update("update user set password = #{password},modified_date = now() where user_id = #{userId}")
    int changePwd(@Param("password")String password, @Param("userId")Long userId);

    @Update("update user set nick = #{nick},modified_date = now() where user_id = #{userId}")
    int updateUser(@Param("nick")String nick, @Param("userId")Long userId);

    @Insert("insert into user_info(" + COLUMN_ALL_USER_INFO + ") values(#{userId},#{name},#{desc},#{birthday},#{phone},now(),now())")
    int addUserInfo(UserInfo userInfo);

    int updateUserInfo(UserInfo userInfo);

    @Select("select email from user where email = #{email}")
    String getEmail(String email);

    @Select("select * from user where email = #{email}")
    @ResultMap("userMap")
    User getUserByEmail(String email);

    @Select("select * from user where user_id = #{userId}")
    @ResultMap("userMap")
    User getUserById(Long userId);

    @Select("select * from user where email = #{email} and password = #{password}")
    @ResultMap("userMap")
    User getUser(@Param("email")String email, @Param("password")String password);

    @Select("select * from user_info where user_id = #{userId}")
    @ResultMap("userInfoMap")
    UserInfo getUserInfo(Long userId);
}
