package test_pro;
import java.net.URL;

import javax.swing.*;

import java.awt.*;
public class MyImageIcon extends JFrame{
	public MyImageIcon()
	{
		Container con=getContentPane();
		JLabel j1=new JLabel("这是一个JFrame窗体",JLabel.CENTER);
		
//		package testpackage;
//		public class TestMain {
//		    public static void main(String[] args) {
//		        System.out.println(TestMain.class.getResource(""));
//		        System.out.println(TestMain.class.getResource("/"));
//		file:/E:/workspace/Test/bin/testpackage/
//		file:/E:/workspace/Test/bin/
//		    }
//		}
		URL url=MyImageIcon.class.getResource("1.jpg");
		Icon icon=new ImageIcon(url);
		j1.setIcon(icon);//为标签设置图片
		j1.setHorizontalAlignment(SwingConstants.CENTER);//设置文字放置在标签中间
		j1.setOpaque(true);//设置标签为不透明
		con.add(j1);
		setSize(2000,1000);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyImageIcon();

	}

}























