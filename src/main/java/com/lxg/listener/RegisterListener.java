package com.lxg.listener;

import com.lxg.main.Main;
import com.lxg.view.TopJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        //跳转到注册界面
        TopJFrame.c.show(TopJFrame.jp, "RegisterJPanel");
        Main.top.repaint();
    }
}
