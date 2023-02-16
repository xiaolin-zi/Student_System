package com.lxg.view;

import com.lxg.controller.LoginJudge;
import com.lxg.listener.LoginEventListener;
import com.lxg.view.LoginBean;
import com.lxg.pojo.LoginEvent;
import com.lxg.view.DefeatDialog;
import com.lxg.view.PopDialog;
import com.lxg.view.SuccessDialog;

import javax.swing.*;

//具体观察者类
public class LoginJPanel1 extends JPanel implements LoginEventListener {


    private LoginBean lb;
    ImageIcon imageIcon;
    //错误提示标签
    public LoginJPanel1(){
        lb=new LoginBean();
        lb.addLoginEventListener(this);
        //设置没有布局管理器
        this.setLayout(null);
        this.add(lb);
        this.setSize(1000,600);
        this.setVisible(true);
        new LoginBean().setVisible(true);
    }


    @Override
    public void validateLogin(LoginEvent event) {
        //获取用户输入的用户名和密码
        String username = event.getUsername();
        String pwd =event.getPassword();
        //去除前后空格后若为空，则提示错误
        if (username.trim().equals("")) {
           PopDialog pop = new DefeatDialog();
           pop.showDialog("用户名不能为空！");
        } else if (pwd.trim().equals("")) {
            PopDialog pop = new DefeatDialog();
            pop.showDialog("密码不能为空！");
        } else {
            System.out.println("空实现");
        }

        //若用户名和密码都不为空，则进行登录判断
        if (!username.equals("") && !pwd.equals("")) {
            boolean b = LoginJudge.loginJudge(username, pwd);
            if (b) {
                PopDialog pop = new SuccessDialog();
                pop.showDialog("登录成功！");

            } else {
                PopDialog pop = new DefeatDialog();
                pop.showDialog("账号或密码错误！");
            }
        }
    }
}
