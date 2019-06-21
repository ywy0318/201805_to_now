package test_pro;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;
//利用弹簧控制组件大小,按钮的宽度由弹簧控制,高度由支柱控制
public class springLayout_test2 extends JFrame{

	public springLayout_test2() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("利用弹簧控制组件大小");
		this.setBounds(400, 400, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SpringLayout sp = new SpringLayout();
		getContentPane().setLayout(sp);
		Spring vst = Spring.constant(20);// 创建一个支柱
		Spring hsp = Spring.constant(20,100,500);// 创建一个弹簧
		JButton lbt = new JButton("按钮L");
		getContentPane().add(lbt);
		// “按钮L”北侧——>容器北侧
		sp.putConstraint(SpringLayout.NORTH, lbt, vst, SpringLayout.NORTH,getContentPane());
		// “按钮L”西侧——>容器西侧
		sp.putConstraint(SpringLayout.WEST, lbt, hsp, SpringLayout.WEST,getContentPane());
		
		JButton rbt = new JButton("按钮R");
		getContentPane().add(rbt);
		// “按钮R”北侧——>“按钮R”北侧
		sp.putConstraint(SpringLayout.NORTH, rbt, 0, SpringLayout.NORTH,lbt);
		// “按钮R”西侧——>“按钮L”东侧
		sp.putConstraint(SpringLayout.WEST, rbt, Spring.scale(hsp, 2), SpringLayout.EAST,lbt);
		// “按钮R”东侧——>“按钮R”东侧
		sp.putConstraint(SpringLayout.EAST, getContentPane(), hsp, SpringLayout.EAST,rbt);
		// 创建一个弹簧
		Spring widthsp = Spring.constant(60,300,600);
		//创建一个支柱
		Spring heightst = Spring.constant(60);
		
		Constraints lbt_con=sp.getConstraints(lbt);//获得“按钮L”的Constraints对象
		lbt_con.setWidth(widthsp);				   //设置控制组件宽度的弹簧
		lbt_con.setHeight(heightst);				//设置控制组件高度的的支柱
		Constraints rbt_con=sp.getConstraints(rbt);//获得“按钮R”的Constraints对象
		rbt_con.setWidth(widthsp);					//设置控制组件宽度的弹簧
		rbt_con.setHeight(heightst);				//设置控制组件高度的的支柱
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		springLayout_test2 e = new    springLayout_test2();
		e.setVisible(true);
	}	

}
