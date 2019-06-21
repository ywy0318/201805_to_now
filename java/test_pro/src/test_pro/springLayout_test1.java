package test_pro;

import javax.swing.*;
//使用弹簧和支柱动态调整按钮间的距离,按钮间距为按钮与窗体之间间距的两倍
public class springLayout_test1 extends JFrame{

	public springLayout_test1() {
		super();
		this.setTitle("使用弹簧和支柱");
		this.setBounds(100, 100, 500, 375);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SpringLayout sp = new SpringLayout();
		getContentPane().setLayout(sp);
		
		// TODO Auto-generated constructor stub
		Spring vst = Spring.constant(20);//创建一个支柱
		Spring hsp = Spring.constant(20, 100, 500);//创建一个弹簧
		JButton ibt = new JButton("按钮L");
		getContentPane().add(ibt);
		//"按钮L"北侧--->容器北侧
		sp.putConstraint(SpringLayout.NORTH, ibt, vst, SpringLayout.NORTH, getContentPane());
		//"按钮L"西侧--->容器西侧
		sp.putConstraint(SpringLayout.WEST, ibt, hsp, SpringLayout.WEST, getContentPane());
		
		JButton rbt = new JButton("按钮R");
		getContentPane().add(rbt);
		//"按钮R"北侧--->"按钮R"北侧
		sp.putConstraint(SpringLayout.NORTH, rbt, 0, SpringLayout.NORTH, ibt);
		//"按钮R"西侧--->"按钮R"西侧
		sp.putConstraint(SpringLayout.WEST, rbt, Spring.scale(hsp, 2), SpringLayout.EAST, ibt);
		//"按钮R"北侧--->"按钮R"北侧
		sp.putConstraint(SpringLayout.EAST, getContentPane(), hsp, SpringLayout.EAST, rbt);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		springLayout_test1 e = new springLayout_test1();
		e.setVisible(true);
	}

}
