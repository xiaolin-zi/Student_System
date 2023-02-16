package com.lxg.controller;

import com.lxg.mapper.StudentMapper;
import com.lxg.utils.SqlSessionUtils;
import com.lxg.view.HomeJPanel;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.util.jar.JarEntry;

public class DeleteStudent {
    public static int delete(String sno){
        SqlSession sqlSession = SqlSessionUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.deleteBySno(sno);
        return i;
    }
}
