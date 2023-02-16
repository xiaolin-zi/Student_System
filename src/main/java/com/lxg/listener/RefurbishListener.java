package com.lxg.listener;

import com.lxg.controller.FindAllStudents;
import com.lxg.pojo.Student;
import com.lxg.view.HomeJPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static com.lxg.view.HomeJPanel.model;

public class RefurbishListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        /*//重新显示全部学生信息
        JTextArea textArea = HomeJPanel.textArea;
        textArea.setText("");
        List<Student> students = FindAllStudents.findAll();
        for (Student student : students) {
            textArea.append(student.toString() + "\n");
        }*/
        DefaultTableModel defaultTableModel = model;
        JTable table = HomeJPanel.table;
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
        //初始化信息
        List<Student> students = FindAllStudents.findAll();
        for (int i = 0; i < students.size(); i++) {
            model.addRow(new Vector<>(Arrays.asList(students.get(i).getSid(),students.get(i).getSno(),students.get(i).getName(),students.get(i).getSex(),students.get(i).getAge(),students.get(i).getGrade(),students.get(i).getDorm())));
        }
    }
}
