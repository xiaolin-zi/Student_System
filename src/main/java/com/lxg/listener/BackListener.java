package com.lxg.listener;

import com.lxg.main.Main;
import com.lxg.view.TopJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //跳回登录界面
        TopJFrame.c.show(TopJFrame.jp, "LoginJPanel");
        Main.top.repaint();
    }
}
