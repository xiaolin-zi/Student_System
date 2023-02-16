package com.lxg.view;
import javax.swing.*;

public  abstract class PopDialog extends JDialog {



    //使用模板方法模式，这是模板类
    public void init(String lnaem) {
        setName("提示窗口");
        setLayout(null);
        JLabel label = new JLabel(lnaem);
        label.setBounds(100, 20, 200, 30);
        add(label);
        setSize(300, 130);
        setLocationRelativeTo(null);
        setVisible(true);
        //showDialog("提示窗口");
        setAlwaysOnTop(true);
    }

    public void sleep() {
        Thread thread = new Thread() {
            public void run() {
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dispose();
//                TopJFrame.c.next(TopJFrame.jp);
//                Main.top.repaint();
                isJump();
            }
        };
        thread.start();
    }

    //是否跳转页面
    public abstract void isJump();


    public void showDialog(String name) {
        init(name);
        sleep();
    }
}
