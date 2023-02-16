package com.lxg.listener;

import com.lxg.controller.UpdateStudent;
import com.lxg.memento.Caretaker;
import com.lxg.memento.StudentInfo;
import com.lxg.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {
    JLabel label= CancelDialog.label;
    public void actionPerformed(ActionEvent e) {
        String j = e.getActionCommand();
        System.out.println(j);
        if (j.equals("确定")) {
            //撤销数据修改
            try {
                StudentInfo studentInfo = StudentInfo.getInstance();
                Caretaker caretaker = Caretaker.getInstance();
                studentInfo.restoreMemento(caretaker.getMemento());
                UpdateStudent.update(studentInfo.getSno(), studentInfo.getName(), studentInfo.getAge(), studentInfo.getSex(), studentInfo.getGrade(), studentInfo.getDorm());
                PopDialog popDialog = new SuccessDialog();
                TableListener.jd_c.setVisible(false);
                popDialog.showDialog("撤销成功");
                //不需要销毁对象
                /*studentInfo=null;
                caretaker=null;*/
            } catch (Exception e1) {
                label.setText("撤销失败！你未进行任何修改！");
            }

        } else {
            label.setText("");
            TableListener.jd_c.dispose();
        }
    }
}
