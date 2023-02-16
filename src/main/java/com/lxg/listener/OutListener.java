package com.lxg.listener;

import com.lxg.main.Main;
import com.lxg.view.TopJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		String j = e.getActionCommand();
		System.out.println(j);
		if(j.equals("确定")){
			TableListener.jd_o.setVisible(false);
			TopJFrame.c.first(TopJFrame.jp);
			Main.top.repaint();
		
		}else{
			TableListener.jd_o.dispose();
		}
	} 
	
}
