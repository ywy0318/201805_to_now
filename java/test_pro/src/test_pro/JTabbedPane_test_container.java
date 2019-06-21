package test_pro;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JTabbedPane_test_container extends JFrame {

	public JTabbedPane_test_container() {
		// TODO Auto-generated constructor stub
	
		JTabbedPane jTabbedpane = new JTabbedPane();// 存放选项卡的组件
		String[] tabNames = { "过程数据1", "过程数据2", "LED屏显示内容", "功放状态数据", "广播系统设备状态1" , "广播系统设备状态2", "媒体监控系统设备状态1"
				,"媒体监控系统设备状态2","广播音频-对讲音频"};
		Font f = new Font("宋体",Font.PLAIN,18);	
		JFrame[] jf = new JFrame[tabNames.length];
		Container[] con = new Container[tabNames.length];// 获得窗体容器对象
//		JPanel[] panel_for_tab = new JPanel[tabNames.length];// 20
		for(int i=0;i<tabNames.length;i++)
		{
//			jf[i] = new JFrame();
			con[i] = new Container();
//			jf[i].setBackground(Color.WHITE);
//			jf[i].setVisible(true);
//			jf[i].setSize(800, 1000);
			//panel_for_tab[i].setSize(800, 1000);
			 //jTabbedpane.addTab(tabNames[i],panel[i], "second");// 加入第一个页面			
			 jTabbedpane.addTab(tabNames[i], con[i]);
			 jTabbedpane.setFont(f);
			 jTabbedpane.setBackground(Color.green);
		}
		this.setVisible(true);
		this.setSize(800, 1000);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTabbedPane_test_container();
	}

}
