package test_pro;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Timer;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrame2_JFrame1 extends JFrame {
	
	public JFrame2_JFrame1()
	{
	
	  Timer timer3 = new Timer();		      
		 Container con = new Container();// 获得窗体容器对象
		 Container con1 = new Container();// 获得窗体容器对象
		 GridBagLayout gridBagLayout = new GridBagLayout();
		 JPanel panel_for_tab = new JPanel();// 20
		 JPanel panel_for_tab1 = new JPanel();// 20
		 JPanel panel_for_tabs = new JPanel();// 20
			JPanel panel[];
			panel = new JPanel[5];
			JPanel panel1[];
			panel1 = new JPanel[5];
			String str = "紧急报警器";
			String strtemp = "";
			String str_enable[]={"过程数据:","功放状态数据:","广播设备状态:","媒体设备状态:"};
			String str1[] = { "正常/取消申请/接通后挂断", "申请", "接通(控制盒)", "接通(OCC-TPA)" };
			JComboBox<String> ComboBox[];
			ComboBox = new JComboBox[5];
			JComboBox<String> ComboBox1[];
			ComboBox1 = new JComboBox[4];
			int i=0;
			String str2="";
			String strtmp="";
			// JPanel p=new JPanel(new GridLayout(10,3,3,3));
			for (i = 0; i < 5; i++) {
				panel[i] = new JPanel();
				ComboBox[i] = new JComboBox<String>(str_enable);
				panel[i].add(ComboBox[i]);
				ComboBox[i].setSelectedIndex(0);
				//panel[i].setForeground(Color.red);
				//jcb.setSelectedIndex(1);
//				 System.out.println("sssssss");
				// panel_for_tab.add(panel[i]);
				panel_for_tab.add(panel[i]);
				
//				 con.add(panel[i]);
			}
			
			for (i = 0; i <4; i++) {
				panel1[i] = new JPanel();
				ComboBox1[i] = new JComboBox<String>(str1);
				panel1[i].add(ComboBox1[i]);
				//panel1[i].setForeground(Color.BLUE);
				//ComboBox1[i].setSelectedIndex(0);
				//jcb.setSelectedIndex(1);
//				 System.out.println("sssssss");
//				 panel_for_tab1.add(panel1[i]);
				 panel_for_tab.add(panel1[i]);
//				con1.add(panel1[i]);
			}
			//panel_for_tabs
//			panel_for_tab1.setBackground(Color.RED);
//			panel_for_tab.setBackground(Color.RED);
//			panel_for_tabs.add(new JScrollPane(panel_for_tab1));
//			panel_for_tabs.add(new JScrollPane(panel_for_tab));
//			panel_for_tabs.add(panel_for_tab);
//			panel_for_tabs.add(panel_for_tab1);
			
			//this.add(panel_for_tabs);
			//this.add(new JScrollPane(panel_for_tab));
//			new JScrollPane
//			panel_for_tab.add(con1);
//			panel_for_tab.add(con);
			//new GridLayout(10, 3, 3, 3)
//			con.setLayout(new GridBagLayout());
//			con1.setLayout(gridBagLayout);
//			panel_for_tab.add(new JScrollPane(con1));
//			panel_for_tab.add(new JScrollPane(con));
			panel_for_tab.setLayout(new GridLayout(3, 3, 1, 1));
//			panel_for_tab.setLayout(gridBagLayout);
//			this.add(new JScrollPane(panel_for_tab));
			this.add(panel_for_tab);
			
//			panel[1].setBounds(0, 0, 275, 40);
//			panel[2].setBounds(0, 40, 275, 40);
//			panel[3].setBounds(0, 80, 275, 40);
//			panel[4].setBounds(0, 120, 275, 40);
//			panel[0].setBounds(0, 160, 275, 40);
//
//			this.add(panel[1]);
//			this.add(panel[2]);
//			this.add(panel[3]);
//			this.add(panel[4]);
//			this.add(panel[0]);
//			this.setLayout(gridBagLayout);
			
			//String text=(String) comboBox_4.getSelectedItem();
//			  timer3.scheduleAtFixedRate(new TimerTask()
//			  {
//		            public void run() {	            	
//		                for(int i=0;i<5;i++)
//		                {
//		                	String	strtmp=((String) ComboBox[i].getSelectedItem());
//		                	//String str2+=strtmp;	                	
//		                	System.out.println(strtmp+":"+String.valueOf(i));
//		                	System.out.println("sssssss");
////		                	System.out.println(i);
//		                	//jcb.setSelectedIndex(1);
//		                		//str2+= strtmp;	                	
//		                }	            	
//		         }
//		        }, 500, 500);
			
			// System.out.println("sssssss");
		//setSize(800, 800);
			//setSize(400, 400);
			this.setBounds(400, 400, 800, 500);
//			setVisible(true);
	}
}
