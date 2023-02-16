package com.lxg.view;



import javax.swing.*;
import java.awt.*;

public class TopJFrame extends JFrame {

    public static CardLayout c;

    //面板组件，非顶层容器，一个界面只可以有一个JFrame窗体组件，但是可以有多个JPanel面板组件
    public static JPanel jp;

   /* private ImageIcon imageIcon;
    public  JLabel jLabel;*/

    //传入“学生管理系统”几个字
    public TopJFrame(String name) {



        super(name);

        //改变窗口图标
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage("img\\sign.jpg");
        this.setIconImage(img);






        // 定义卡片对象：CardLayout，实现页面切换
        c = new CardLayout();
        jp = new JPanel(c);



        /*imageIcon = new ImageIcon("img/雪山.png");
        jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,1000,600);
        jp.add(jLabel);
        jp.setOpaque(false);*/

        //设置窗口可关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置主页面的大小
        this.setSize(1000,600);

        //设置主页面的位置
        this.setLocation(250, 100);

        //将LoginJpanel加入到该界面上
        jp.add(new LoginJPanel1(), "LoginJPanel");

        //将HomeJPanel加入到该界面上
        jp.add(new HomeJPanel(), "HomeJPanel");

        //将RegisterJPanel加入到该界面上
        jp.add(new RegisterJPanel(), "RegisterJPanel");

        //将jp加入到顶层容器中
        this.add(jp);

        this.setLocationRelativeTo(null);
        //设置窗口大小不可改变
        this.setResizable(false);

        //设置窗口可见
        this.setVisible(true);
    }
}
