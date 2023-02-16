package com.lxg.mapper;

import com.lxg.pojo.Admin;
import com.lxg.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    //根据名字和密码查询
    Admin findAdminByNameAndPwd(@Param("name") String name, @Param("password") String password);
}
