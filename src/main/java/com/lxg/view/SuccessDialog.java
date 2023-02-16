package com.lxg.view;

import com.lxg.main.Main;

public class SuccessDialog extends PopDialog{

    @Override
    public void isJump() {
        TopJFrame.c.show(TopJFrame.jp,"HomeJPanel");
        Main.top.repaint();
    }
}
