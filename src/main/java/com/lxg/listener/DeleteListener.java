package com.lxg.listener;

import com.lxg.controller.DeleteStudent;
import com.lxg.controller.FindAllStudents;
import com.lxg.pojo.Student;
import com.lxg.view.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static com.lxg.view.HomeJPanel.model;
import static com.lxg.view.HomeJPanel.table;

public class DeleteListener implements ActionListener {
    private JDialog err, masg;

    @Override
    public void actionPerformed(ActionEvent e) {

      //  String errMsg = DeleteDialog.err.getText();
        String idText = DeleteDialog.t_id.getText();

        if (idText.trim().equals("")) {
            DeleteDialog.err.setText("学号不能为空！");
        } else {
            DeleteDialog.err.setText("");
            masg = new JDialog();
            masg.setAlwaysOnTop(true);
            masg.setLayout(null);

            //调用数据库删除学生
            int delete = DeleteStudent.delete(idText);
            if (delete == 1) {
                //将文本域对应的数据删除
                /*//先将全部置为空白，再重新查询查到的数据显示上去
                JTextArea textArea = HomeJPanel.textArea;
                textArea.setText("");
                //调用查询所有学生的方法
                List<Student> students = FindAllStudents.findAll();
                for (Student student : students) {
                    textArea.append(student.toString() + "\n");
                }*/

                DefaultTableModel defaultTableModel = model;

                while (model.getRowCount()>0){
                    model.removeRow(0);
                }

                //初始化信息
                List<Student> students = FindAllStudents.findAll();
                for (int i = 0; i < students.size(); i++) {
                    model.addRow(new Vector<>(Arrays.asList(students.get(i).getSid(),students.get(i).getSno(),students.get(i).getName(),students.get(i).getSex(),students.get(i).getAge(),students.get(i).getGrade(),students.get(i).getDorm())));
                }


                JLabel jl = new JLabel("删除成功！");
                /*jl.setBounds(110, 20, 200, 30);
                masg.add(jl);
                masg.setSize(350, 130);
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
                        TableListener.jd_d.dispose();
                    }
                };
                tr.start();*/
                PopDialog pop = new SuccessDialog();
                pop.showDialog("删除成功！");
            } else {
                /*JLabel jl = new JLabel("删除失败，你输入的学号不存在！");
                jl.setBounds(110, 20, 200, 30);
                masg.add(jl);
                masg.setSize(350, 130);
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
                        TableListener.jd_d.dispose();
                    }
                };
                tr.start();*/
                PopDialog pop = new DefeatDialog();
                pop.showDialog("删除失败，你输入的学号不存在！");
            }
        }
    }
}
