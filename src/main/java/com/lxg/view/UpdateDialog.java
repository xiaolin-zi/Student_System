package com.lxg.view;

import com.lxg.listener.TableListener;
import com.lxg.listener.UpdateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDialog extends JDialog {
    private JLabel id,name,sex,age,dorm,grade;
    public static JLabel err;
    public static JTextField t_id,t_name,t_age,t_dorm,t_grade;
    private JButton ok,cancle;
    public static JComboBox cb_sex;
    private static UpdateDialog updateDialog = new UpdateDialog();
    private UpdateDialog(){
        this.setAlwaysOnTop(true);
        this.setTitle("修改学生信息");
        this.setLayout(null);
        this.setSize(580, 320);
        this.setLocationRelativeTo(null);
        this.setLocation(470,160);


        id = new JLabel("学号:");
        name = new JLabel("姓名:");
        sex = new JLabel("性别:");
        age = new JLabel("年龄:");
        dorm = new JLabel("宿舍:");
        grade = new JLabel("班级");

        err = new JLabel();
        t_dorm = new JTextField();
        t_age = new JTextField();
        t_id = new JTextField();
        t_name = new JTextField();
        t_grade = new JTextField();
        cb_sex = new JComboBox();

        ok = new JButton("确定");
        cancle = new JButton("取消");

        id.setBounds(30, 50, 30, 30);
        t_id.setBounds(80, 50, 100, 30);

        name.setBounds(200, 50, 30, 30);
        t_name.setBounds(250, 50, 100, 30);

        sex.setBounds(370, 50, 30, 30);
        cb_sex.setBounds(420, 50, 100, 30);
        cb_sex.addItem("男");
        cb_sex.addItem("女");

        age.setBounds(30, 100, 30, 30);
        t_age.setBounds(80, 100, 100, 30);

        dorm.setBounds(370, 100, 30, 30);
        t_dorm.setBounds(420, 100, 100, 30);

        grade.setBounds(200, 100, 30, 30);
        t_grade.setBounds(250, 100, 100, 30);


        err.setBounds(30, 150, 120, 30);
        err.setForeground(Color.RED);

        ok.setBounds(130, 200, 100, 30);
        cancle.setBounds(350, 200, 100, 30);

        ok.addActionListener(new UpdateListener());

        cancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableListener.jd_u.setVisible(false);
            }
        });

        add(id);
        add(t_id);

        add(name);
        add(t_name);

        add(sex);
        add(cb_sex);

        add(age);
        add(t_age);

        add(dorm);
        add(t_dorm);

        add(grade);
        add(t_grade);

        add(err);

        add(ok);
        add(cancle);

        setVisible(true);

    }
    public static UpdateDialog getUpdateDialog(){
        return updateDialog;
    }
}
