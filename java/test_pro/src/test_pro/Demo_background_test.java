package test_pro;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class Demo_background_test extends JFrame  {
	
		 public Demo_background_test() {
		  super("Title");
		  NewPanel p = new NewPanel();
		  p.setSize(200, 200);
		  this.getContentPane().add(p); // 将面板添加到JFrame上
		  this.setSize(596, 298); // 初始窗口的大小
		  this.setLocationRelativeTo(null); // 设置窗口居中
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setVisible(true);
		 }

		 public static void main(String[] args) {
		  new Demo_background_test();
		 }

		 class NewPanel extends JPanel {
		  public NewPanel() {

		  }
		  //这个函数在哪里起作用
		  public void paintComponent(Graphics g) {
		   int x = 0, y = 0;
//		   URL url=MyImageIcon.class.getResource("1.jpg");
//			Icon icon=new ImageIcon(url);
		   //URL url=MyImageIcon.class.getResource("1.jpg");
		   /***************/
		   ImageIcon icon = new ImageIcon(MyImageIcon.class.getResource("1.jpg"));// 003.jpg是测试图片在项目的根目录下
		   //ImageIcon icon = new ImageIcon("1.jpg");// 003.jpg是测试图片在项目的根目录下
		   g.drawImage(icon.getImage(), x, y, getSize().width,
		     getSize().height, this);// 图片会自动缩放
//		    g.drawImage(icon.getImage(), x, y,this);//图片不会自动缩放
		  }
		 }

		}


