package com.lxg.view;

import com.lxg.listener.FindListener;
import com.lxg.listener.TableListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindDialog extends JDialog {
    private JLabel id;
    public static JLabel err;
    private JLabel tip;
    public static JTextField t_id;
    private JButton ok,cancle;
    private static FindDialog findDialog = new FindDialog();

    private FindDialog(){
        this.setAlwaysOnTop(true);
        this.setTitle("查找学生信息");
        this.setLayout(null);
        this.setSize(580, 320);
        this.setLocationRelativeTo(null);
        this.setLocation(470,160);
        id = new JLabel("学号:");
        err = new JLabel();
        tip = new JLabel("请输入学号进行查找！");
        tip.setFont(new Font("宋体",Font.BOLD,15));
        t_id = new JTextField();
        ok = new JButton("确定");
        cancle = new JButton("取消");

        tip.setBounds(200,20,200,30);

        id.setBounds(150, 100, 30, 30);
        t_id.setBounds(200, 100, 150, 30);

        err.setBounds(350, 100, 120, 30);
        err.setForeground(Color.RED);

        ok.setBounds(130, 200, 100, 30);
        cancle.setBounds(350, 200, 100, 30);

        ok.addActionListener(new FindListener());

        cancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableListener.jd_f.setVisible(false);
            }
        });

        add(id);
        add(t_id);

        add(err);
        add(tip);
        add(ok);
        add(cancle);

        setVisible(true);

    }
    public static FindDialog getFindDialog(){
        return findDialog;
    }

}
