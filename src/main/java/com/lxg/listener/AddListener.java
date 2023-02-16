package com.lxg.listener;

import com.lxg.controller.FindStudent;
import com.lxg.controller.SaveStudent;
import com.lxg.mapper.StudentMapper;
import com.lxg.pojo.Student;
import com.lxg.utils.SqlSessionUtils;
import com.lxg.view.*;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import static com.lxg.view.HomeJPanel.model;

public class AddListener implements ActionListener {
   // private JDialog err,masg;
    @Override
    public void actionPerformed(ActionEvent e) {

        String idText =  AddDialog.t_id.getText();
        String nameText = AddDialog.t_name.getText();
        String sexText = AddDialog.cb_sex.getSelectedItem().toString();
        String ageText = AddDialog.t_age.getText();
        String gradeText = AddDialog.t_grade.getText();
        String dormText = AddDialog.t_dorm.getText();


        if(idText.equals("")||nameText.equals("")||sexText.equals("")||ageText.equals("")||dormText.equals("")||gradeText.equals("")){
            AddDialog.err.setText("各项信息都不能为空！");
        }else {
            AddDialog.err.setText("");
            /*masg = new JDialog();
            masg.setAlwaysOnTop(true);
            masg.setLayout(null);*/

            //查询数据库中是否存在该学号的学生
            boolean b = FindStudent.find(idText);
            int result=0;
            if(b){
                /*AddDialog.err.setText("该学号已存在！");*/
                PopDialog pop = new DefeatDialog();
                pop.showDialog("该学号已存在！");
            }else{
                //调用数据库添加学生信息
                try{
                    result = SaveStudent.save(idText, nameText, Integer.parseInt(ageText), sexText, gradeText, dormText);
                }catch (Exception e1){
               /* JLabel jl = new JLabel("添加失败，你的输入有误！");
                jl.setBounds(110, 20, 150, 30);
                masg.add(jl);
                masg.setSize(300, 130);
                masg.setLocationRelativeTo(null);
                masg.setVisible(true);
                masg.repaint();
                Thread tr = new Thread() {
                    public void run() {
                        try {
                            this.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        masg.dispose();
                        TableListener.jd_i.dispose();
                    }

                    ;
                };
                tr.start();*/
                    PopDialog pop = new DefeatDialog();
                    pop.showDialog("添加失败，你的输入有误！");
                }
            }
            if (result == 1) {
                //将新加的学生显示到文本域
                SqlSession sqlSession = SqlSessionUtils.getSqlsession();
                StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
                Student student = mapper.selectBySno(idText);

                /*JTextArea textArea = HomeJPanel.textArea;
                textArea.append(student1.toString()+"\n");*/
                DefaultTableModel defaultTableModel = model;

                model.addRow(new Vector<>(Arrays.asList(student.getSid(),student.getSno(),student.getName(),student.getSex(),student.getAge(),student.getGrade(),student.getDorm())));

                /*JLabel jl = new JLabel("添加成功！");
                jl.setBounds(110, 20, 150, 30);
                masg.add(jl);
                masg.setSize(300, 130);
                masg.setLocationRelativeTo(null);
                masg.setVisible(true);
                masg.repaint();
                Thread tr = new Thread() {
                    public void run() {
                        try {
                            this.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        masg.dispose();
                        TableListener.jd_i.dispose();
                    }

                    ;
                };
                tr.start();*/
                PopDialog pop = new SuccessDialog();
                pop.showDialog("添加成功！");
                //TableListener.jd_i.dispose();
            }
        }
    }
}
