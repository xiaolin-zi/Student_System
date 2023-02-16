package com.lxg.view;

import com.lxg.listener.BackListener;
import com.lxg.listener.SuerRegisterListener;

import javax.swing.*;
import java.awt.*;

public class RegisterJPanel extends JPanel {
    private JLabel lab_title,lab_user,lab_pwd;
    public static JLabel lab_u_err,lab_p_err,login_err;
    public static JTextField tex_user,tex_pwd;
    private JButton but_sureregister,but_back;
    public  JLabel jLabel;
    private ImageIcon imageIcon;
    public RegisterJPanel(){

        this.setLayout(null);
        this.setSize(1000, 600);
        lab_title = new JLabel("欢迎注册!");
        lab_user = new JLabel("用户名:");
        lab_pwd = new JLabel("密码:");
        lab_u_err = new JLabel();
        lab_p_err = new JLabel();
        tex_user = new JTextField(20);
        tex_pwd = new JPasswordField (20);

        but_sureregister = new JButton("确定注册");
        but_back = new JButton("返回");

        login_err = new JLabel();

        lab_title.setBounds(450,10,400,100);
        lab_title.setFont(new Font("宋体",Font.BOLD,30));
        lab_user.setBounds(400, 140, 150, 50);
        lab_user.setFont(new Font("宋体",Font.BOLD,15));
        lab_pwd.setBounds(400, 190, 150, 50);
        lab_pwd.setFont(new Font("宋体",Font.BOLD,15));

        tex_user.setBounds(470, 150,150, 30);
        tex_pwd.setBounds(470, 200, 150, 30);

        //用户名错误信息提示
        lab_u_err.setBounds(620, 150, 160, 30);
        lab_u_err.setForeground(Color.RED);
        //密码错误信息提示
        lab_p_err.setBounds(620, 200, 160, 30);
        lab_p_err.setForeground(Color.RED);


        but_sureregister.setBounds(520, 250, 100, 30);
        but_back.setBounds(370, 250, 100, 30);

        //登录错误信息
        login_err.setBounds(370, 300, 200, 30);
        login_err.setForeground(Color.RED);

        but_sureregister.addActionListener(new SuerRegisterListener());
        but_back.addActionListener(new BackListener());
        this.add(lab_title);
        this.add(lab_user);
        this.add(lab_pwd);
        this.add(lab_u_err);
        this.add(lab_p_err);
        this.add(tex_user);
        this.add(tex_pwd);

        this.add(but_sureregister);
        this.add(but_back);
        this.add(login_err);

        imageIcon = new ImageIcon("img/castle.png");
        jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,1000,600);
        this.add(jLabel);
        this.setOpaque(false);
    }
}
