package com.lxg.controller;


import com.lxg.adapter.CipherAdapter;
import com.lxg.adapter.DataOperation;
import com.lxg.mapper.UserMapper;
import com.lxg.pojo.User;
import com.lxg.utils.SqlSessionUtils;
import com.lxg.view.RegisterJPanel;
import org.apache.ibatis.session.SqlSession;

public class RegisterJudge {

    public static boolean registerJudge(String username, String password) {
        SqlSession session = SqlSessionUtils.getSqlsession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findUserByName(username);
        if (user == null) {
            //将用户信息存入数据库
            //将用户名和密码加密后存入数据库
            DataOperation dao = new CipherAdapter();
            //dao.setPassword(password);
            String pe = dao.doEncrypt(6,password);
           // String ue = dao.doEncrypt(6,username);
            User user1 = new User(null, username, pe);
            mapper.addUser(user1);
            return true;
        } else {
            return false;
        }
    }
}
