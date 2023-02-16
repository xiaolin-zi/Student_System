package com.lxg.view;

import com.lxg.main.Main;

public class RegisterSuccessDialog extends PopDialog{

    @Override
    public void isJump() {
        TopJFrame.c.show(TopJFrame.jp, "LoginJPanel");
        Main.top.repaint();
    }
}
