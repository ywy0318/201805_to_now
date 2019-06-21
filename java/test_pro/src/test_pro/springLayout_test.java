package test_pro;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.SpringLayout;

public class springLayout_test extends JFrame{
	
	public springLayout_test() {
		super();
		setBounds(100, 100, 500, 375);
		// TODO Auto-generated constructor stub
		SpringLayout sp=new SpringLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Container con = new Container();
		Container con = getContentPane();// 获得窗体容器对象
		//con.setVisible(true);
		con.setLayout(sp);
		JLabel topiclabel = new JLabel("主题：");
		con.add(topiclabel);
		//主题标签北侧-->容器北侧
		sp.putConstraint(SpringLayout.NORTH, topiclabel, 5, SpringLayout.NORTH, con);
		//主题标签西侧-->容器西侧
		sp.putConstraint(SpringLayout.WEST, topiclabel, 5, SpringLayout.WEST, con);
		
		JTextField topicjt = new JTextField();
		con.add(topicjt);
		//主题文本框北侧-->容器北侧
		sp.putConstraint(SpringLayout.NORTH, topicjt, 5, SpringLayout.NORTH, con);
		//主题文本框西侧-->主题标签东侧
		sp.putConstraint(SpringLayout.WEST, topicjt, 5, SpringLayout.EAST, topiclabel);
		//主题文本框东侧-->容器北侧
		sp.putConstraint(SpringLayout.EAST, topicjt, -5, SpringLayout.EAST, con);
		
		
		JLabel content_label = new JLabel("内容：");
		con.add(content_label);
		//内容标签北侧-->主题文本框南侧
		sp.putConstraint(SpringLayout.NORTH, content_label, 5, SpringLayout.SOUTH, topicjt);
		//内容标签西侧-->容器西侧
		sp.putConstraint(SpringLayout.WEST, content_label, 5, SpringLayout.WEST, con);
		
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(new JTextArea());
		con.add(sc);
		//主题文本框北侧-->容器北侧
		sp.putConstraint(SpringLayout.NORTH, sc, 5, SpringLayout.SOUTH, topicjt);
		//主题文本框西侧-->主题标签东侧
		sp.putConstraint(SpringLayout.WEST, sc, 5, SpringLayout.EAST, content_label);
		//主题文本框东侧-->容器东侧
		sp.putConstraint(SpringLayout.EAST, sc, -5, SpringLayout.EAST, con);
		
		JButton reasetbt = new JButton("清空");
		con.add(reasetbt);
		//"清空"按钮南侧-->容器南侧
		sp.putConstraint(SpringLayout.SOUTH, reasetbt, -5, SpringLayout.SOUTH, con);
		//主题文本框西侧-->主题标签东侧
//		sp.putConstraint(SpringLayout.WEST, sc, 5, SpringLayout.EAST, content_label);
//		//主题文本框东侧-->容器东侧
//		sp.putConstraint(SpringLayout.EAST, sc, -5, SpringLayout.EAST, con);
		
		JButton submitbt = new JButton("确定");
		con.add(submitbt);
		//"确定"按钮南侧-->容器南侧
		sp.putConstraint(SpringLayout.SOUTH, submitbt, -5, SpringLayout.SOUTH, con);
		//"确定"按钮东侧-->容器东侧
		sp.putConstraint(SpringLayout.EAST, submitbt, -5, SpringLayout.EAST, con);
		//滚动面板南侧-->"确定"按钮北侧
		sp.putConstraint(SpringLayout.SOUTH, sc, -5, SpringLayout.NORTH, submitbt);
		//"清空"按钮东侧-->"确定"按钮西侧
		sp.putConstraint(SpringLayout.EAST, reasetbt, -5, SpringLayout.WEST, submitbt);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		springLayout_test s = new springLayout_test();
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
