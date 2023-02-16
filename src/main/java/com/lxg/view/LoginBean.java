package com.lxg.view;

import com.lxg.main.Main;
import com.lxg.listener.LoginEventListener;
import com.lxg.pojo.LoginEvent;
import com.lxg.view.TopJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LoginBean extends JPanel implements ActionListener {

    //定义换衣标签和定义用户名和密码提示标签
    private JLabel lab_welcome,lab_user,lab_pwd;

    public  JLabel jLabel;
    private ImageIcon imageIcon;

    //定义用户名和密码输入框
    public  JTextField tex_user,tex_pwd;

    //定义登录和注册按钮
    private JButton but_login,but_register;

    LoginEventListener lel;
    LoginEvent le;

    //定义登录模式下拉选择框（管理员和学生）
    private JLabel modellabel;
    public static JComboBox jComboBox;
    public static String select;
    //初始化登录面板
    public LoginBean(){


        //设置没有布局管理器
        this.setLayout(null);

        //设置容器大小与顶层容器大小一致
        this.setSize(1000, 600);

        //创建下拉选择框并添加元素
        modellabel = new JLabel("登录模式：");
        jComboBox = new JComboBox<String>();
        String studentmodel = "管理员模式";
        String adminmodel="学生模式";
        jComboBox.addItem(studentmodel);
        jComboBox.addItem(adminmodel);
        jComboBox.setSelectedItem(studentmodel);
        jComboBox.setMaximumRowCount(2);
        select="管理员模式";
        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED) {
                    select=(String) e.getItem();
                }
            }
        });

        //创建标签并设置标签名字
        lab_user = new JLabel("用户名:");
        lab_pwd = new JLabel("密码:");


        //创建用户名和密码输入框
        tex_user = new JTextField(20);
        tex_pwd = new JPasswordField (20);

        //创建登录和注册按钮
        but_login = new JButton("登录");
        but_register = new JButton("注册");

        //设置下拉选择框的位置和大小
        modellabel.setBounds(400,100,150,30);
        modellabel.setFont(new Font("宋体",Font.BOLD,15));
        jComboBox.setBounds(470,100,150,30);
        jComboBox.setFont(new Font("宋体",Font.BOLD,15));

        //设置欢迎标签和用户名和密码标签位置
        lab_user.setBounds(400, 140, 150, 50);
        lab_user.setFont(new Font("宋体",Font.BOLD,15));
        lab_pwd.setBounds(400, 190, 150, 50);
        lab_pwd.setFont(new Font("宋体",Font.BOLD,15));

        //设置用户名和密码输入框位置
        tex_user.setBounds(470, 150,150, 30);
        tex_pwd.setBounds(470, 200, 150, 30);



        //设置登录和注册按钮位置
        but_login.setBounds(400, 250, 80, 30);
        but_register.setBounds(550, 250, 80, 30);




        //创建标签并设置标签名字
        lab_welcome = new JLabel("欢迎使用学生管理系统!");
        //设置欢迎标签位置
        lab_welcome.setBounds(350,10,400,100);
        lab_welcome.setFont(new Font("宋体",Font.BOLD,30));



        //添加组件到容器
        this.add(modellabel);
        this.add(jComboBox);
        this.add(lab_user);
        this.add(lab_pwd);

        this.add(tex_user);
        this.add(tex_pwd);
        this.add(but_login);
        this.add(but_register);

        this.add(lab_welcome);


        imageIcon = new ImageIcon("img/雪山.png");
        jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,1000,600);
        this.add(jLabel);
        this.setOpaque(false);

        but_login.addActionListener(this);
        but_register.addActionListener(this);
    }

    public void addLoginEventListener(LoginEventListener lel){
        this.lel = lel;
    }

    public void fireLoginEvent(Object object,String username,String password){
        le=new LoginEvent(but_login,username,password);
        lel.validateLogin(le);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(but_login==event.getSource()){
            String username = this.tex_user.getText();
            String password = this.tex_pwd.getText();
            fireLoginEvent(but_login,username,password);
        }
        if(but_register==event.getSource()){
            //跳转到注册界面
            TopJFrame.c.show(TopJFrame.jp, "RegisterJPanel");
            Main.top.repaint();
        }
    }
}
