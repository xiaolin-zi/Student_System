package com.lxg.controller;

import com.lxg.mapper.StudentMapper;
import com.lxg.pojo.Student;
import com.lxg.utils.SqlSessionUtils;
import com.lxg.view.HomeJPanel;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static com.lxg.view.HomeJPanel.model;

public class FindAllStudents {
    public static List<Student> findAll(){
       // JTextArea textArea = HomeJPanel.textArea;
        SqlSession sqlSession = SqlSessionUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        return students;

    }
}
