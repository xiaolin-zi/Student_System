package com.lxg.view;

import com.lxg.listener.CancelListener;

import javax.swing.*;
import java.awt.*;

public class CancelDialog extends JDialog {
    private static CancelDialog cancelDialog = new CancelDialog();
    public static JLabel label;
    private CancelDialog(){
        this.setLayout(null);
        this.setSize(380, 180);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        label = new JLabel();
        label.setForeground(Color.RED);
        label.setBounds(100, 50, 200, 30);
        CancelListener c = new CancelListener();
        JLabel msg = new JLabel("确定撤销修改？");
        msg.setBounds(130,20,100,30);
        JButton ok = new JButton("确定");
        ok.setBounds(50, 80, 100, 30);
        ok.addActionListener(c);
        JButton cancle = new JButton("取消");
        cancle.setBounds(200, 80, 100, 30);
        cancle.addActionListener(c);
        add(msg);
        add(ok);
        add(cancle);
        add(label);
    }
    public static CancelDialog getCancelDialog(){
        return cancelDialog;
    }
}
