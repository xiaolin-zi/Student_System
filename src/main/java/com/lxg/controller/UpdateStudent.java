package com.lxg.controller;

import com.lxg.mapper.StudentMapper;
import com.lxg.pojo.Student;
import com.lxg.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class UpdateStudent {
    public static int update(String sno, String name, int age, String sex, String grade, String dorm){
        SqlSession sqlSession = SqlSessionUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student =new Student(null, sno, name, sex, age, grade, dorm);
        int i = mapper.updateBySno(student);
        return i;
    }
}
