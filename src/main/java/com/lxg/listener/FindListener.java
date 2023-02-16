package com.lxg.listener;

import com.lxg.controller.FindStudent;
import com.lxg.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindListener implements ActionListener {
    private JDialog  masg;
    @Override
    public void actionPerformed(ActionEvent e) {

        String errMsg = FindDialog.err.getText();
        String idText = FindDialog.t_id.getText();

        if (idText.trim().equals("")) {
            FindDialog.err.setText("学号不能为空！");
        } else {
            FindDialog.err.setText("");


            //调用数据库查找学生并显示在TextArea
            boolean b = FindStudent.find(idText);
            if (b) {
                /*masg = new JDialog();
                masg.setAlwaysOnTop(true);
                masg.setLayout(null);
                JLabel jl = new JLabel("查找成功！");
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
                        TableListener.jd_f.dispose();
                    }
                };
                tr.start();*/
                PopDialog pop = new SuccessDialog();
                pop.showDialog("查找成功！");
                //TableListener.jd_f.dispose();
            }else{
                PopDialog popDialog = new DefeatDialog();
                popDialog.showDialog("查找失败，你输入的学号不存在！");
            }
        }
    }
}
