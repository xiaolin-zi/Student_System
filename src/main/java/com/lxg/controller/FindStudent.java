package com.lxg.controller;

import com.lxg.mapper.StudentMapper;
import com.lxg.pojo.Student;
import com.lxg.utils.SqlSessionUtils;
import com.lxg.view.HomeJPanel;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.Arrays;
import java.util.Vector;

import static com.lxg.view.HomeJPanel.model;

public class FindStudent {

    public static boolean find(String sno){
        SqlSession sqlSession = SqlSessionUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectBySno(sno);
        if(student != null){
            /*JTextArea textArea = HomeJPanel.textArea;
            textArea.setText("");
            textArea.append("学号：" + student.toString() + "\n");*/


            DefaultTableModel defaultTableModel = model;
            while (model.getRowCount()>0){
                model.removeRow(0);
            }
            model.addRow(new Vector<>(Arrays.asList(student.getSid(),student.getSno(),student.getName(),student.getSex(),student.getAge(),student.getGrade(),student.getDorm())));

            return true;
        }else{
            return false;
        }
    }
}
