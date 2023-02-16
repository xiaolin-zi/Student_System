package com.lxg.controller;


import com.lxg.adapter.CipherAdapter;
import com.lxg.adapter.DataOperation;
import com.lxg.mapper.AdminMapper;
import com.lxg.mapper.UserMapper;
import com.lxg.pojo.Admin;
import com.lxg.pojo.User;
import com.lxg.utils.SqlSessionUtils;
import com.lxg.view.LoginBean;
import com.lxg.view.RegisterJPanel;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;

public class LoginJudge {

    public static boolean loginJudge(String username, String password) {
        JComboBox jComboBox1 = LoginBean.jComboBox;
        String identity = LoginBean.select;
        System.out.println(identity);
        if(identity.equals("学生模式")){
            SqlSession sqlSession = SqlSessionUtils.getSqlsession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //将密码加密再与数据库进行判断
            DataOperation dao = new CipherAdapter();
            String pe = dao.doEncrypt(6,password);
            //String ue = dao.doEncrypt(6,username);
            User user = userMapper.findUserByNameAndPwd(username, pe);
            if (user != null) {
                return true;
            } else {
                return false;
            }
        }else if(identity.equals("管理员模式")){
            SqlSession sqlSession1 = SqlSessionUtils.getSqlsession();
            AdminMapper adminMapper = sqlSession1.getMapper(AdminMapper.class);
          Admin admin = adminMapper.findAdminByNameAndPwd(username, password);
            if(admin!=null){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
