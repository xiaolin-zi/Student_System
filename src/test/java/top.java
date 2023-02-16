import com.lxg.view.LoginJPanel1;
import org.apache.log4j.Layout;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarFile;

public class top extends JFrame {
    public static JPanel jp;
    public top(String name){
        super(name);

        jp = new JPanel();
jp.setLayout(null);
        jp.add(new a());

        //设置窗口可关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置主页面的大小
        this.setSize(1000,600);

        //设置主页面的位置
        this.setLocation(250, 100);

        //jp.add(new a());

        this.add(jp);
        this.setLocationRelativeTo(null);
        //设置窗口大小不可改变
        this.setResizable(false);

        //设置窗口可见
        this.setVisible(true);
    }

    public static void main(String[] args) {
       top top = new top("学生管理系统");
    }
}
