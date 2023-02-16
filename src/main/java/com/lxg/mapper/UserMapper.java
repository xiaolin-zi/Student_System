package com.lxg.mapper;

import com.lxg.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {



    //根据用户名和密码查询用户是否存在
     User findUserByNameAndPwd(@Param("username") String username,@Param("password") String password);

     //根据用户名查询用户是否存在
     User findUserByName(@Param("username") String username);

     //添加用户
     void addUser(User user);
}
