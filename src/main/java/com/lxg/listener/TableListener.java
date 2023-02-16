package com.lxg.listener;

import com.lxg.view.*;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableListener implements MouseListener{

	public static JDialog jd_u,jd_i,jd_o,jd_d,jd_f,jd_c;
	JTable table = HomeJPanel.table;
	TableModel tableModel = HomeJPanel.model;


	public void mouseClicked(MouseEvent e) {
		JButton j = (JButton)e.getSource();
		String select = LoginBean.select;
		if(select=="管理员模式"){
			if(j.getName().equals("del")){

				jd_d =DeleteDialog.getDeleteDialog();
				jd_d.setVisible(true);
				int selectedRow = table.getSelectedRow();
				int columnCount = table.getColumnCount();
				String value = table.getValueAt(selectedRow, 1).toString();
				//System.out.println(value);
				DeleteDialog.t_id.setText(value);
			}else if(j.getName().equals("update")){
				//jd_u = new UpdateDialog();
				jd_u=UpdateDialog.getUpdateDialog();
				jd_u.setVisible(true);

				int selectedRow = table.getSelectedRow();
				int columnCount = table.getColumnCount();
				String[] values = new String[10];
				for (int i = 1 ; i <columnCount ; i++) {
					String value = table.getValueAt(selectedRow, i).toString();
					values[i-1] = value;
				}
				UpdateDialog.t_id.setText(values[0]);
				UpdateDialog.t_name.setText(values[1]);
				UpdateDialog.cb_sex.setSelectedItem(values[2]);
				UpdateDialog.t_age.setText(values[3]);
				UpdateDialog.t_grade.setText(values[4]);
				UpdateDialog.t_dorm.setText(values[5]);
			}else if(j.getName().equals("insert")){
				//jd_i = new AddDialog();
				jd_i=AddDialog.getAddDialog();
				jd_i.setVisible(true);
			} else if(j.getName().equals("find")){
				//jd_f= new FindDialog();
				jd_f=FindDialog.getFindDialog();
				jd_f.setVisible(true);
			} else if(j.getName().equals("out")){
				//jd_o = new OutDialog();
				jd_o=OutDialog.getOutDialog();
				jd_o.setVisible(true);
			}
			else if(j.getName().equals("cancel")){
				jd_c=CancelDialog.getCancelDialog();
				jd_c.setVisible(true);
			}
		}else{
			if(j.getName().equals("del")||j.getName().equals("update")||j.getName().equals("insert")||j.getName().equals("insert")||j.getName().equals("cancel")) {
				PopDialog popDialog = new DefeatDialog();
				popDialog.showDialog("你没有权限！");
			}else if(j.getName().equals("find")){
				//jd_f= new FindDialog();
				jd_f=FindDialog.getFindDialog();
				jd_f.setVisible(true);
			} else if(j.getName().equals("out")){
				//jd_o = new OutDialog();
				jd_o=OutDialog.getOutDialog();
				jd_o.setVisible(true);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}


}
