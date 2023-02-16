package com.lxg.controller;

import com.lxg.mapper.StudentMapper;
import com.lxg.pojo.Student;
import com.lxg.utils.SqlSessionUtils;
import com.lxg.view.HomeJPanel;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;

public class SaveStudent {
    public static int save( String sno, String name, int age, String sex, String grade, String dorm) {
        SqlSession sqlSession = SqlSessionUtils.getSqlsession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student =new Student(null, sno, name, sex, age, grade, dorm);
        int result = studentMapper.insert(student);
        return result;
    }
}
