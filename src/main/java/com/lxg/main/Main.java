package com.lxg.main;



import com.lxg.view.TopJFrame;

import java.io.IOException;

//启动系统
public class Main {

    //定义顶层窗口的名字
    public static TopJFrame top;

    //top = new TopJFrame("学生信息管理系统");
    public static void main(String[] args) throws IOException {
        top = new TopJFrame("学生信息管理系统");
//        new Main();

    }
}
