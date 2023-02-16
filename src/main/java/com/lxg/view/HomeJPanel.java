package com.lxg.view;

import com.lxg.controller.FindAllStudents;
import com.lxg.listener.RefurbishListener;
import com.lxg.listener.RegisterListener;
import com.lxg.listener.TableListener;
import com.lxg.pojo.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class HomeJPanel extends JPanel {
    //声明增删改查按钮
    private JButton jb_del, jb_find, jb_update, jb_insert,jb_out,jb_cancel,jb_refurbish;

    //创建文本框
    public JTextField tex_id;

    private JLabel lab_check, lab_id;

    //声明一个文本域
    //public static JTextArea textArea;

    //创建滚动条窗口
    //private JScrollPane js;

    public  JLabel jLabel;
    private ImageIcon imageIcon;

    JScrollPane jp;
    public static JTable  table;
    public static DefaultTableModel model;

    public HomeJPanel() {
        this.repaint();
        this.setLayout(null);
        //创建按钮
        jb_del = new JButton("删除");
        jb_find = new JButton("查找");
        jb_update = new JButton("修改");
        jb_insert = new JButton("添加");
        jb_refurbish = new JButton("刷新");
        jb_cancel = new JButton("撤销修改");
        jb_out = new JButton("退出");

        tex_id = new JTextField();//文本框
        lab_check = new JLabel("查找");//展示文本，数字或图片
        lab_id = new JLabel("学号:");

        /*新建表格*/
        model = new DefaultTableModel();
        model.addColumn("编号", new Vector<Integer>());
        model.addColumn("学号",new Vector<String>());
        model.addColumn("姓名",new Vector<String>());
        model.addColumn("性别",new Vector<String>());
        model.addColumn("年龄", new Vector<String>());
        model.addColumn("班级", new Vector<String>());
        model.addColumn("宿舍", new Vector<String>());
        table = new JTable(model);
        jp = new JScrollPane(table);
        jp.setBounds(220, 30, 700, 450);

        /*textArea = new JTextArea();//文本域
        textArea.setEditable(false);//设置文本域不可编辑
        textArea.setFont(new Font("宋体", Font.BOLD, 20));//设置字体*/
        /*js = new JScrollPane();
        js.setBounds(220, 30, 700, 450);*/
        //js.setViewportView(textArea);

        //初始化信息
        List<Student> students = FindAllStudents.findAll();
        for (int i = 0; i < students.size(); i++) {
            model.addRow(new Vector<>(Arrays.asList(students.get(i).getSid(),students.get(i).getSno(),students.get(i).getName(),students.get(i).getSex(),students.get(i).getAge(),students.get(i).getGrade(),students.get(i).getDorm())));
        }
        JTableHeader head = table.getTableHeader();//创建表格表头对象
        head.setPreferredSize(new Dimension(head.getWidth(),35));//设置表头框框大小
        head.setFont(new Font("宋体",Font.BOLD,15));//设置表格字体
        table.setRowHeight(30);//设置表格行宽
        table.setFont(new Font("宋体",Font.ROMAN_BASELINE,13));//设置表格行中字体大小

        /*使单元格中的内容居中*/
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, renderer);


       /* for (Student student : students) {
            textArea.append(student.toString() + "\n");
        }*/
        //为每个按钮分配位置
        jb_del.setBounds(20, 50, 100, 30);
        jb_del.setName("del");
        jb_find.setBounds(20, 100, 100, 30);
        jb_find.setName("find");
        jb_update.setBounds(20, 150, 100, 30);
        jb_update.setName("update");
        jb_insert.setBounds(20, 200, 100, 30);
        jb_insert.setName("insert");
        jb_refurbish.setBounds(20, 250, 100, 30);
        jb_refurbish.setName("refurbish");
        jb_cancel.setBounds(20, 300, 100, 30);
        jb_cancel.setName("cancel");
        jb_out.setBounds(20, 350, 100, 30);
        jb_out.setName("out");


        //为每个按钮构造一个对象，并将这些对象设置为按钮监听器。
        TableListener t = new TableListener();
        jb_del.addMouseListener(t);
        jb_find.addMouseListener(t);
        jb_insert.addMouseListener(t);
        jb_update.addMouseListener(t);
        jb_out.addMouseListener(t);
        jb_refurbish.addActionListener( new RefurbishListener());;
        jb_cancel.addMouseListener(t);
        //将按钮添加到面板中需要调用add方法
        this.add(jb_del);
        this.add(jb_find);
        this.add(jb_update);
        this.add(jb_insert);
        this.add(jb_refurbish);
        this.add(jb_cancel);
        this.add(jb_out);
        //this.add(js);
        this.add(jp);
        this.setSize(1000, 600);

        imageIcon = new ImageIcon("img/雪山.png");
        jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,1000,600);
        this.add(jLabel);
        this.setOpaque(false);

    }

//    protected void paintComponent(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(Color.black);
//        g2d.drawLine(150, 0, 150, 600);
//
//    }
}
