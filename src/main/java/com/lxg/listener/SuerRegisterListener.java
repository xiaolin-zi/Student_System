package com.lxg.listener;

//import com.lxg.judgment.RegisterJudge;
import com.lxg.controller.RegisterJudge;
import com.lxg.controller.RegisterJudge;
import com.lxg.main.Main;
import com.lxg.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuerRegisterListener implements ActionListener {

    private JDialog tip;

    @Override
    public void actionPerformed(ActionEvent e) {


        String username = RegisterJPanel.tex_user.getText();
        String password = RegisterJPanel.tex_pwd.getText();
        //去除前后空格后若为空，则提示错误
        if (username.trim().equals("")) {
            RegisterJPanel.lab_u_err.setText("用户名不能为空");
        } else {
            //若不为空则清空错误提示
            RegisterJPanel.lab_u_err.setText("");
        }
        if (password.trim().equals("")) {
            RegisterJPanel.lab_p_err.setText("密码不能为空");
        } else {
            RegisterJPanel.lab_p_err.setText("");
        }

        if (!username.equals("") && !password.equals("")) {
            //判断用户名和密码长度是否符合要求
            if (username.length() < 6 || username.length() > 12) {
                RegisterJPanel.lab_u_err.setText("用户名长度应为6-12位");
            } else if (password.length() < 6 || password.length() > 12) {
                RegisterJPanel.lab_p_err.setText("密码长度应为6-12位");
            } else {
                RegisterJPanel.lab_p_err.setText("");
            }

            //如果长度符合要求，则判断用户名是否已存在
            if (username.length() >= 6 && username.length() <= 12 && password.length() >= 6 && password.length() <= 12) {
                boolean b1 = RegisterJudge.registerJudge(username, password);
                if (b1) {
                    RegisterJPanel.login_err.setText("");
                    /*tip = new JDialog();
                    tip.setLayout(null);
                    JLabel jl_tip = new JLabel("注册成功！");
                    jl_tip.setBounds(100, 20, 200, 30);
                    tip.add(jl_tip);
                    tip.setSize(300, 130);
                    //设置窗口居中
                    tip.setLocationRelativeTo(null);
                    //设置窗口可见
                    tip.setVisible(true);
                    //创建线程，设置线程休眠时间
                    Thread tr_err = new Thread() {
                        public void run() {
                            try {
                                this.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            tip.dispose();
                            TopJFrame.c.show(TopJFrame.jp, "LoginJPanel");
                            Main.top.repaint();
                        }
                    };
                    tr_err.start();*/

                    PopDialog popDialog = new RegisterSuccessDialog();
                    popDialog.showDialog("注册成功！");

                } else {
                    /*tip = new JDialog();
                    tip.setLayout(null);
                    JLabel jl_err = new JLabel("用户名已存在！");
                    jl_err.setBounds(100, 20, 200, 30);
                    tip.add(jl_err);
                    tip.setSize(300, 130);
                    tip.setLocationRelativeTo(null);
                    tip.setVisible(true);*/
                    PopDialog popDialog = new DefeatDialog();
                    popDialog.showDialog("用户名已存在");
                }
            }
        }
    }
}
