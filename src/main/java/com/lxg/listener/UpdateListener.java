package com.lxg.listener;


import com.lxg.controller.UpdateStudent;
import com.lxg.mapper.StudentMapper;
import com.lxg.pojo.Student;
import com.lxg.memento.Caretaker;
import com.lxg.memento.StudentInfo;
import com.lxg.utils.SqlSessionUtils;
import com.lxg.view.*;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateListener implements ActionListener {
    //private JDialog err,masg;
    @Override
    public void actionPerformed(ActionEvent e) {


        String idText = UpdateDialog.t_id.getText();
        String nameText = UpdateDialog.t_name.getText();
        String sexText = UpdateDialog.cb_sex.getSelectedItem().toString();
        String ageText = UpdateDialog.t_age.getText();
        String gradeText = UpdateDialog.t_grade.getText();
        String dormText = UpdateDialog.t_dorm.getText();

        if(idText.equals("")||nameText.equals("")||sexText.equals("")||ageText.equals("")||dormText.equals("")||gradeText.equals("")){
            UpdateDialog.err.setText("各项信息都不能为空！");
        }else {
            UpdateDialog.err.setText("");
           /* masg = new JDialog();
            masg.setAlwaysOnTop(true);
            masg.setLayout(null);*/

            //将修改前的信息保存到备忘录中
            SqlSession session = SqlSessionUtils.getSqlsession();
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.selectBySno(idText);
            StudentInfo student1 = StudentInfo.getInstance();
            Caretaker c = Caretaker.getInstance();
            student1.setSid(null);
            student1.setSno(student.getSno());
            student1.setName(student.getName());
            student1.setSex(student.getSex());
            student1.setAge(student.getAge());
            student1.setGrade(student.getGrade());
            student1.setDorm(student.getDorm());
            c.setMemento(student1.saveMemento());

            //调用数据库修改学生信息
            int update = UpdateStudent.update(idText, nameText, Integer.parseInt(ageText), sexText, gradeText, dormText);

            if (update == 1) {
                /*JLabel jl = new JLabel("修改成功！");
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
                        TableListener.jd_u.dispose();
                    }

                    ;
                };
                tr.start();*/
                PopDialog pop = new SuccessDialog();
                pop.showDialog("修改成功！");
            } else {
                /*JLabel jl = new JLabel("修改失败，你的输入有误！");
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
                        TableListener.jd_u.dispose();
                    }

                    ;
                };
                tr.start();*/
                PopDialog  popDialog = new DefeatDialog();
                popDialog.showDialog("修改失败，你的输入有误！");
            }
        }
    }
}
