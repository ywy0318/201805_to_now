package test_pro;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
//网格组布局管理器管理组件的类
//gridBagLayout 和 GridBagConstraints
public class GridBagConstraints_test extends JFrame {

	public GridBagConstraints_test() {
		Container container = getContentPane();
		GridBagLayout gridBagLayout = new GridBagLayout();
		// TODO Auto-generated constructor stub
		
		final JButton bt_a=new JButton("A");
		final GridBagConstraints gridbagcontrains_a =new GridBagConstraints();
		
		//container.setLayout(gridbagcontrains_a);
		container.setLayout(gridBagLayout);
		gridbagcontrains_a.gridy=0;//起始点为第一行
		gridbagcontrains_a.gridx=0;//起始点为第一列
		gridbagcontrains_a.weightx=10;//第一列的分布方式为10%
		gridbagcontrains_a.fill=GridBagConstraints.HORIZONTAL;
		
		container.add(bt_a,gridbagcontrains_a);
//		getContentPane().add(bt_a,gridbagcontrains_a);
		//getContentPane().add
		//
		final JButton bt_b=new JButton("B");
		final GridBagConstraints gridbagcontrains_b =new GridBagConstraints();
		gridbagcontrains_b.gridy=0;//起始点为第一行
		gridbagcontrains_b.gridx=1;//起始点为第一列
		gridbagcontrains_b.insets=new Insets(0,5,0,0);//设置组件左侧的最小距离
		gridbagcontrains_b.weightx=20;//第一列的分布方式为10%
		gridbagcontrains_b.fill=GridBagConstraints.HORIZONTAL;
//		this.getContentPane().add(bt_b,gridbagcontrains_b);
		container.add(bt_b,gridbagcontrains_b);
		//		
		final JButton bt_c=new JButton("C");
		final GridBagConstraints gridbagcontrains_c =new GridBagConstraints();
		gridbagcontrains_c.gridy=0;//起始点为第一行
		gridbagcontrains_c.gridx=2;//起始点为第一列
		gridbagcontrains_c.gridheight=2;//组件占用两行
		gridbagcontrains_c.insets=new Insets(0,5,0,0);//设置组件左侧的最小距离
		gridbagcontrains_c.weightx=30;//第一列的分布方式为10%
		gridbagcontrains_c.fill=GridBagConstraints.HORIZONTAL;
		container.add(bt_c,gridbagcontrains_c);
//		this.getContentPane().add(bt_c,gridbagcontrains_c);
		//
		final JButton bt_d=new JButton("D");
		final GridBagConstraints gridbagcontrains_d =new GridBagConstraints();
		gridbagcontrains_d.gridy=0;//起始点为第一行
		gridbagcontrains_d.gridx=3;//起始点为第一列
		gridbagcontrains_d.gridheight=4;//组件占用两行
		gridbagcontrains_d.insets=new Insets(0,5,0,5);//设置组件左侧和右侧的最小距离
		gridbagcontrains_d.weightx=40;//第一列的分布方式为10%
		gridbagcontrains_d.fill=GridBagConstraints.BOTH;
		container.add(bt_d,gridbagcontrains_d);
//		this.getContentPane().add(bt_d,gridbagcontrains_d);
		//
		final JButton bt_e=new JButton("E");
		final GridBagConstraints gridbagcontrains_e =new GridBagConstraints();
		gridbagcontrains_e.gridy=1;//起始点为第一行
		gridbagcontrains_e.gridx=0;//起始点为第一列
		gridbagcontrains_e.gridheight=2;//组件占用两行
		gridbagcontrains_e.insets=new Insets(5,0,0,0);//设置组件左侧和右侧的最小距离
		//gridbagcontrains_e.weightx=40;//第一列的分布方式为10%
		gridbagcontrains_e.fill=GridBagConstraints.HORIZONTAL;
		container.add(bt_e,gridbagcontrains_e);
		//this.getContentPane().add(bt_e,gridbagcontrains_e);
		//
		final JButton bt_f=new JButton("F");
		final GridBagConstraints gridbagcontrains_f =new GridBagConstraints();
		gridbagcontrains_f.gridy=2;//起始点为第一行
		gridbagcontrains_f.gridx=0;//起始点为第一列
		//gridbagcontrains_f.gridheight=2;//组件占用两行
		gridbagcontrains_f.insets=new Insets(5,0,0,0);//设置组件左侧和右侧的最小距离
		//gridbagcontrains_e.weightx=40;//第一列的分布方式为10%
		gridbagcontrains_f.fill=GridBagConstraints.HORIZONTAL;
		container.add(bt_f,gridbagcontrains_f);
//		this.getContentPane().add(bt_f,gridbagcontrains_f);
		//
		final JButton bt_g=new JButton("G");
		final GridBagConstraints gridbagcontrains_g =new GridBagConstraints();
		gridbagcontrains_g.gridy=2;//起始点为第一行
		gridbagcontrains_g.gridx=1;//起始点为第一列
		gridbagcontrains_g.gridheight=2;//组件占用两行
		gridbagcontrains_g.gridwidth=2;//组件占用两列
		{
			gridbagcontrains_g.fill=GridBagConstraints.VERTICAL;//只调整组件的高度
			gridbagcontrains_g.ipadx=30;//增加组件的首选宽度
			gridbagcontrains_g.anchor=GridBagConstraints.EAST;//显示在东方
		}
		gridbagcontrains_g.insets=new Insets(5,5,0,0);//设置组件左侧和右侧的最小距离
		//gridbagcontrains_e.weightx=40;//第一列的分布方式为10%
		//gridbagcontrains_g.fill=GridBagConstraints.BOTH;
		container.add(bt_g,gridbagcontrains_g);
		
//		this.getContentPane().add(bt_g,gridbagcontrains_g);
		//
		final JButton bt_h=new JButton("H");
		final GridBagConstraints gridbagcontrains_h =new GridBagConstraints();
		gridbagcontrains_h.gridy=3;//起始点为第一行
		gridbagcontrains_h.gridx=0;//起始点为第一列
//		gridbagcontrains_h.gridheight=2;//组件占用两行
//		gridbagcontrains_h.gridwidth=2;//组件占用两列
		gridbagcontrains_h.insets=new Insets(5,0,0,0);//设置组件左侧和右侧的最小距离
		//gridbagcontrains_e.weightx=40;//第一列的分布方式为10%
		gridbagcontrains_h.fill=GridBagConstraints.BOTH;
		container.add(bt_h,gridbagcontrains_h);
		//this.getContentPane().add(bt_h,gridbagcontrains_h);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridBagConstraints_test e =new GridBagConstraints_test();
		e.setVisible(true);
		e.setBounds(400, 400, 400, 300);

	}

}
