package test_pro;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;











//import occ_tpa_tool.tcpclass.clienttask;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class test001_socket_thread_001 extends JFrame {


	
	//越站与否使用复选框8*8+广播状态有效与否标志*8=76
	//日期时间*7
	//站信息*4

	//紧急报警器6*8+报站模式*1=49 +司机室主备和激活与否2*2=53
	//越站与否使用复选框8*8+广播状态有效与否标志*8=72
	//紧急广播id+话筒音量等*46+广播优先级*12+站信息*4=63
	//日期时间*7
	
	//选中要查找的函数名 ctrl+alt+G
	//1.选中你要加注释的区域，用ctrl+shift+C或者ctrl+/会加上//注释
	//Eclipse的上一步操作快捷键为Ctrl+Z，即可将代码回退到最近一次的代码状态。
	//2.Eclipse的下一步操作快捷键为Ctrl+Y，这个快捷键与Ctrl+Z的组合是相反的。
	//如果发现撤销上一步操作代码后不如原来的代码后，则可以使用Ctrl+Y来进行恢复，也就是相当于撤销操作的取消。


		
		public void test11() {
			// 定义面板，并设置为网格布局，4行4列，组件水平、垂直间距均为3
			// 优先保证第一数字的正确性
			JPanel p = new JPanel(new GridLayout(10, 3, 3, 3));

			JTextArea t = new JTextArea();// 定义文本框

			// 定义字符串数组，为按钮的显示文本赋值

			// 注意字符元素的顺序与循环添加按钮保持一致

			String str[] = { "7", "8", "9", "/", "4", "5", "6", "1", "2", "3", "*",
					"-", "0", ".", "=", "+", "18", "19", "10", "14", "15", "16",
					"11", "12", "13", "17", "28", "29", "20", "24", "25", "26",
					"21", "22", "23", "27", "38", "39", "30", "34", "35", "36",
					"31", "32", "33", "37" };

			// super(s);//为窗体名称赋值

			//setLayout(new BorderLayout());// 定义窗体布局为边界布局

			JButton btn[];// 声明按钮数组

			btn = new JButton[str.length];// 创建按钮数组

			for (int i = 0; i < str.length; i++) {// 循环定义按钮，并添加到面板中

				btn[i] = new JButton(str[i]);

				p.add(btn[i]);
			}

			// 将文本框放置在窗体NORTH位置

			// getContentPane().add(t,BorderLayout.NORTH);

			// 将面板放置在窗体CENTER位置

			// getContentPane().add(p,BorderLayout.CENTER);

			setVisible(true);

			setSize(2000, 2000);

			// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// setLocationRelativeTo(null);//让窗体居中显示
		}

		public void Test1() {
			int size = 1 * 250;
			
			JFrame jf = new JFrame("测试窗口");
			jf.setSize(size, size);
			jf.setLocationRelativeTo(null);
			jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			JPanel jp1 = new JPanel();
			JLabel jlb1;
			JComboBox jcb; // 下拉�?
			
			jlb1 = new JLabel("报警器：：：");
			String str1[] = { "申请", "接�?�（控制盒）", "接�?�（OCC-TPA�?",
					"正常/取消申请/接�?�后挂断" };
			jcb = new JComboBox(str1);

			jp1.add(jlb1);
			jp1.add(jcb);

			jf.add(jp1);
			
			//分别设置水平和垂直滚动条总是出现
//			JScrollPane jsp =new JScrollPane();
//			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//			jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			//分别设置水平和垂直滚动条自动出现
			//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			// jf.setLayout(new GridLayout(2, 1));
			// 创建复�?�框
			JCheckBox checkBox01 = new JCheckBox("菠萝");
			JCheckBox checkBox02 = new JCheckBox("越站5");
			JCheckBox checkBox03 = new JCheckBox("雪梨");
			JCheckBox checkBox04 = new JCheckBox("荔枝");
			JCheckBox checkBox05 = new JCheckBox("橘子");
			JCheckBox checkBox06 = new JCheckBox("苹果");

			// 添加第一个复选框的状态被改变的监听（其他复�?�框如果�?要监听状态改变，则可按此方法添加监听�?
			checkBox01.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					// 获取事件源（即复选框本身�?
					JCheckBox checkBox = (JCheckBox) e.getSource();
					System.out.println(checkBox.getText() + " 是否选中: "
							+ checkBox.isSelected());
				}
			});

			// 设置默认第一个复选框选中
			checkBox01.setSelected(true);
//			panel.add(checkBox01);
//			panel.add(checkBox02);
//			panel.add(checkBox03);
//			panel.add(checkBox04);
//			panel.add(checkBox05);
//			panel.add(checkBox06);
			
			jf.setLocationRelativeTo(null);
			jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			jf.setContentPane(panel);
			jf.setVisible(true);
		}

		public void test3() {
			//Timer timer13 = new Timer();
			   
			           
			// JButton btn[];//声明按钮数组
			//
			// btn=new JButton[str.length];//创建按钮数组
			//
			// for(int i=0;i<str.length;i++){//循环定义按钮，并添加到面板中
			//
			// btn[i]=new JButton(str[i]);
			//
			// p.add(btn[i]);}
			JCheckBox[] checkbox;
			checkbox = new JCheckBox[8];

			// JPanel panel22;
			// panel22=new JPanel();

			JPanel panel[];
			panel = new JPanel[5];

			for (int i = 0; i < 8; i++) {
				checkbox[i] = new JCheckBox(String.valueOf(i + 1));
			}
			System.out.println("sssssss");
			panel[1] = new JPanel();
			//panel[i].add(checkbox[i]);
			for (int i = 0; i < 8; i++) {
				// panel22.add(checkbox[i]);
				//panel[i] = new JPanel();
				panel[1].add(checkbox[i]);
				// System.out.println("sssssss");
				//System.out.println("sssdssss");
				 this.add(panel[i]);
			}
			
//				  timer13.scheduleAtFixedRate(new TimerTask()
//				  {
//			            public void run() {	
//			            	String str2="";
//			                //for(int i=0;i<5;i++)
//			                {
//			                	
//			                	//checkbox[i].get
//			                	//String	strtmp=((String) ComboBox[i].getSelectedItem());
//			                			                	
//			                	//str2+=strtmp;	                	
//			                	//System.out.println(strtmp);
//			                	//System.out.println(i);
//			                		//str2+= strtmp;	                	
//			                }
//			            	//System.out.println(str2);
//			         }
//			        }, 500, 500);
			
			// JFrame jf=new JFrame("测试窗口");
			// this.add(panel[1]);
			// this.add(panel[2]);
			// jf.setVisible(true);
			// this.add(panel22);

			panel[1].setBounds(0, 0, 275, 40);
			this.add(panel[1]);
//			getExtendedState
			this.addWindowListener(new WindowAdapter()
			{
				public void JFClose(WindowEvent w)
				{
					System.out.println();
					System.exit(0);
				};
			});
		
		
//			panel[2].setBounds(0, 40, 275, 40);
//			panel[3].setBounds(0, 80, 275, 40);
//			panel[4].setBounds(0, 120, 275, 40);
//			panel[0].setBounds(0, 160, 275, 40);
			//this.add(panel[1]);
			// this.add(panel[2]);
			// this.add(panel[3]);
			// this.add(panel[4]);
			// this.add(panel[0]);

			setSize(400, 400);
			setVisible(true);
			
//			while(true)
//			{
//				int ii=0;
//				if(ii==100)
//				{
//				for(int i=0;i<8;i++)
//				{
//					System.out.print(checkbox[i].getText()+":现在："+checkbox[i].isSelected());
//				}
//				}
//				ii++;
//			}
			
		}

		public void test5() {
			// JButton btn[];//声明按钮数组
			//
			// btn=new JButton[str.length];//创建按钮数组
			//
			// for(int i=0;i<str.length;i++){//循环定义按钮，并添加到面板中
			//
			// btn[i]=new JButton(str[i]);
			//
			// p.add(btn[i]);}
			// JPanel
			Container con = new Container();// 获得窗体容器对象
			JPanel panel[];
			panel = new JPanel[5];
			for (int i = 0; i < 5; i++) {
				panel[i] = new JPanel();
				// System.out.println("sssssss");
			}

			// System.out.println("sssssss");
		}

		
		public void test_js()
		{
		      JFrame frame=new JFrame("ScrollPanel测试");
		        
		        JPanel panel=new JPanel();
		        System.out.println(panel.getPreferredSize().toString());
		        for(int i=0;i<6;i++){
		            panel.add(new JButton("按钮"+i));
		            System.out.println(panel.getPreferredSize().toString());
		        }
		        frame.add(new JScrollPane(panel));
		        
		        frame.setPreferredSize(new Dimension(400,400));//宽400，高400
		        frame.pack();
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);
		}
		
	
		
		
		public void test6() {
			
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
//				 panel_for_tab.add(panel1[i]);
//				con1.add(panel1[i]);
			}
//			try {
//				Thread.sleep(1000*10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("111");
//			ComboBox[0].setBackground(Color.BLUE);
			ComboBox[0].removeAllItems();
			ComboBox[0].addItem(str1[0]);
			ComboBox[0].addItem(str1[1]);
			ComboBox[0].setSelectedIndex(0);
			
//			try {
//				Thread.sleep(1000*5);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			ComboBox[1].setSelectedItem(str_enable[3]);
			System.out.println(ComboBox[1].getSelectedItem());
//			对象是jcb
//			String s;
//			jcb.removeAllItems();
//			jcb.addItem(s);
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
			setVisible(true);
		}
		public static void main(String[] args) 
		//public  void main() 
		{
			test001_socket_thread_001 u = new test001_socket_thread_001();
			//u.test3();//复选框数组//190
			// u.test2();//音量显示
			//u.Test0();//紧急报警器
			// u.test11();//布局
			//u.Test1();// 复选框//83
			// u.get_date_time();//获取日期时间
			// u.test12();//紧急报警器测试
			//u.test5();//JPanel数组 //什么都显示不出来---待续
			//u.test6();//JComboBox数组					
			 //u.test13();//界面初版
			// u.test14();//JTextField数组测试
			//	u.test15();
			//u.test16();//测试按钮
			 //u.test_js();
			//getExtendedState
			u.test_split();
			//			 Frame 是窗体，是 AWT 时代推出的窗体
//			 JFrame 也是窗体，是 Frame 的子类，是 Swing 时代推出的窗体
//			 Container 即容器，用以盛放其它的控件，是 Frame 和 JFrame 的祖先类
//			 因此，Frame 和 JFrame 都是容器，都可以盛放其它控件
//
//			 可以说 JFrame 是 Frame 的优化
//			 它可以透明，可以半透明，可以更好的呈现内部控件
			

	}
		public void  test_split(){
			String str="false,";
			String [] str_array = {};
			str_array=str.split(",");
			for(int i =0;i<str_array.length;i++)
			{
				System.out.println(str_array[i]);
			}
			
		}
		public void test_string()
		{
			String path="E:\\zz\\192.168.1.1";
			
		}
		public void test16()
		{
			JFrame f = new JFrame("Demo");
	        //final JTextField tf = new JTextField();
	        //tf.setBounds(50, 50, 150, 20);
	        JButton b = new JButton("点击");
	        JButton b2 = new JButton("22222");
//	        b.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                tf.setText("按钮事件如此简单");
//                //tf.setBackground(Color.cyan);
//            }
//        });
	        b.setBounds(20, 20, 20, 20);
	        b2.setBounds(20*5, 20*5, 20, 20);
	        Dimension preferredSize = new Dimension(400,100);
	        b.setPreferredSize(preferredSize );
	        b2.setPreferredSize(preferredSize );
	        //b.setBorderPainted(false);
	        //b.setBorder(BorderFactory.createRaisedBevelBorder());
	        b .setFont(new java.awt.Font("宋体", 1, 15)); 
	        b2 .setFont(new java.awt.Font("宋体", 1, 15)); 
	        //b.setBackground(Color.green); 
//	        b.addActionListener(new ActionListener() {
//	            public void actionPerformed(ActionEvent e) {
//	                tf.setText("按钮事件如此简单");
//	                //tf.setBackground(Color.cyan);
//	            }
//	        });
	        f.add(b);
	        f.add(b2);
//	        f.add(tf);
	        f.setSize(2000, 2000);
	        f.setBackground(Color.RED);
//	        f.setLocationRelativeTo(null);
//	    f.setLayout(null);  
	    f.setVisible(true);   

		}
	    public void test15()
	      	 {
	      		 byte byi=(2*16+1*8+0*4+0*2+1);
	      		 System.out.print(0x7e);
	      	 }
		public void  test13(){
		//public void  GridFrame() 
		
			
//			Thread t=new Thread(new clienttask());
//			t.start();
			
//			JScrollPane jsp = new JScrollPane(jp1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			JFrame jf = new JFrame("测试窗口");
			//分别设置水平和垂直滚动条总是出现
			JScrollPane jsp =new JScrollPane();
			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			//分别设置水平和垂直滚动条自动出现
			//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    Timer timer = new Timer();
		    jf.add(jsp); 	       
		    jf.setLayout(null);
			JPanel panel[];
			panel = new JPanel[48 + 5 + 63+8+8+8+4+1];// 20
			
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);

			int month = c.get(Calendar.MONTH);

			int date = c.get(Calendar.DATE);

			int hour = c.get(Calendar.HOUR_OF_DAY);

			int minute = c.get(Calendar.MINUTE);

			int second = c.get(Calendar.SECOND);
			
			JCheckBox[] checkbox;
			checkbox = new JCheckBox[72];// 76--156

			String str = "紧急报警器";
			String strtemp = "";
			String str1[] = { "正常/取消申请/接通后挂断", "申请", "接通(控制盒)", "接通(OCC-TPA)" };

			String str2 = "报站模式:  ";
			String str3 = "司机室1";
			String str4 = "主备:";
			String str5 = "司机室2";
			String str6 = "激活:";
			String str7[] = { " 主  ", " 备  " };
			String str8[] = { " 有效 ", " 无效 " };
			String str9[] = { "全自动", "半自动", "手动 ", "无效 " };
			String str10 = "功放(室内)音量";
			String str11 = "功放(室外)音量";

			String str12[] = { "控制盒话筒音量:", "控制盒监听音量: ", "控制盒对讲监听音量: ", "中心广播音量:",
					"媒体广播音量:", "紧急报警器话筒音量:", "紧急报警器对讲监听音量:", "报站广播音量:", "关门音音量:",
					"紧急广播音量:", "测试广播音量:", "未命名音量1:", "未命名音量2:", "未命名音量3:" };// 5+6+3=14

			String str13[] = { "OCC广播优先级:", "列车话筒广播优先级:", "列车紧急广播优先级:",
					"列车报站广播优先级:", "关门提示音广播优先级:", "测试广播优先级:", "媒体广播优先级:",
					"OCC-TPA话筒广播优先级:", "OCC-TPA紧急广播优先级:", "未命名优先级1:", "未命名优先级2:",
					"未命名优先级3:" };// 12

			String str14[] = { "紧急广播ID:", "起始站:", "终点站:", "当前站:", "下一站:" };// 5

			String str15 = "越站";
			String str16[] = { "OCC-TPA广播", "列车话筒广播", "关门提示广播", "OCC广播", "紧急广播",
					"离站广播", "进站广播", "媒体广播" };
			String strtmp6 = "";
			String strtmp5 = "";
			String str17="";
			
			
			String strtmp1 = str3 + str4;// 司机室1主备
			String strtmp2 = str3 + str6;// 司机室1激活
			String strtmp3 = str5 + str4;// 司机室2主备
			String strtmp4 = str5 + str6;// 司机室2激活

			JComboBox<String> ComboBox[];
			ComboBox = new JComboBox[48 + 5];

			JLabel label_arr[];
			label_arr = new JLabel[48 + 5 + 63+1];

			JTextField tf[];
			tf = new JTextField[63+1];

			int i = 0, j = 0, k = 0;

			label_arr[48] = new JLabel(strtmp1);// 司机室1主备
			label_arr[49] = new JLabel(strtmp2);// 司机室1激活
			label_arr[50] = new JLabel(strtmp3);// 司机室2主备
			label_arr[51] = new JLabel(strtmp4);// 司机室2激活
			label_arr[52] = new JLabel(str2);// 报站模式

			for (i = 0; i < 8; i++)// 48个紧急报警器
			{
				for (j = 0; j < 6; j++) {
					strtemp = str;
					strtemp += String.valueOf(i + 1);
					strtemp += "-";
					strtemp += String.valueOf(j + 1);
					strtemp += ":";
					// System.out.println(strtemp);
					// 0-47;0-6,
					label_arr[j + i * 6] = new JLabel(strtemp);
					// System.out.println(j+6*i);
				}
			}
			// String str7[]={"主","备"};
			// String str8[]={"有效","无效"};
			// String str9[]={"全自动","半自动","手动","无效"};
			ComboBox[48] = new JComboBox<String>(str7);// 司机室1主备
			ComboBox[49] = new JComboBox<String>(str8);// 司机室1激活
			ComboBox[50] = new JComboBox<String>(str7);// 司机室2主备
			ComboBox[51] = new JComboBox<String>(str8);// 司机室2激活
			ComboBox[52] = new JComboBox<String>(str9);// 报站模式
			for (i = 0; i < 24; i++) {
				panel[i] = new JPanel();
				ComboBox[i] = new JComboBox<String>(str1);

				panel[i].add(label_arr[i]);
				panel[i].add(ComboBox[i]);
				// System.out.println("sssssss");
				// this.add(ComboBox[i]);
				panel[i].setBounds(0, 0 + 35 * i, 275, 35);
				jf.add(panel[i]);
			}

			for (i = 24; i < 48; i++) {
				panel[i] = new JPanel();
				ComboBox[i] = new JComboBox<String>(str1);

				panel[i].add(label_arr[i]);
				panel[i].add(ComboBox[i]);
				// System.out.println("sssssss");
				// this.add(ComboBox[i]);
				panel[i].setBounds(280, 0 + 35 * (i - 24), 275, 35);
				jf.add(panel[i]);
			}

			// 最后修改下坐标 只剩下修改坐标就行了
			for (i = 0; i < 5; i++) {
				panel[i + 48] = new JPanel();
				panel[i + 48].add(label_arr[i + 48]);// 48---48+5-1
				panel[i + 48].add(ComboBox[i + 48]);
				// panel[i+48].setBounds(280*2,0+35*(i),275,35);
				panel[i+48].setBounds(280 * 5+10, 0 + 35 * (i+12), 280, 35);
				jf.add(panel[i + 48]);
			}

			{
				// String str10="功放(室内)音量";
				// String str11="功放(室外)音量";
				// 室内功放 48+5---48+5+16-1
				//
				for (i = 0; i < 8; i++) {
					for (j = 0; j < 2; j++) {
						strtmp5 = str10;
						strtmp5 += String.valueOf(i + 1);
						strtmp5 += "-";
						strtmp5 += String.valueOf(j + 1);
						strtmp5 += ":";
						label_arr[48 + 5 + i * 2 + j] = new JLabel(strtmp5);
					}
				}
				// 室外功放48+5+16-1---48+5+16+16-1
				for (i = 0; i < 8; i++) {
					for (j = 0; j < 2; j++) {
						strtmp5 = str11;
						strtmp5 += String.valueOf(i + 1);
						strtmp5 += "-";
						strtmp5 += String.valueOf(j + 1);
						strtmp5 += ":";
						label_arr[48 + 5 + 16 + i * 2 + j] = new JLabel(strtmp5);
					}
				}
				// 48+5+16+16---48+5+16+16+14-1 String str13[]各种音量5+6+3
				for (i = 0; i < 14; i++) {
					label_arr[48 + 5 + 16 + 16 + i] = new JLabel(str12[i]);
				}

				// 48+5+16+16+14---48+5+16+16+14+12-1 String str13[]优先级
				for (i = 0; i < 12; i++) {
					label_arr[48 + 5 + 16 + 16 + 14 + i] = new JLabel(str13[i]);
				}
				// 48+5+16+16+14+12---48+5+16+16+14+12+5-1 String str14[]
				// 紧急广播ID和站信息,第一个索引是紧急广播
				for (i = 0; i < 5; i++) {
					label_arr[48 + 5 + 16 + 16 + 14 + 12 + i] = new JLabel(str14[i]);
				}
			}

			{ // 46+12+4+1
				// 48+5---48+5+46-1
				// 0-46-1
				// 46=24+22
				for (i = 0; i < 24; i++) {
					panel[i + 48 + 5] = new JPanel();
					tf[i] = new JTextField("20", 5);// 32+14
					panel[i + 48 + 5].add(label_arr[i + 48 + 5]);// 48+5索引没有初始化
					panel[i + 48 + 5].add(tf[i]);
					panel[i + 48 + 5].setBounds(280 * 2, 0 + 35 * (i), 275, 35);
					jf.add(panel[i + 48 + 5]);
					// panel[i+48+5].setBounds(0,0+35*i,275,35);
				}
				// 48+5+24--48+5+24+22-1
				//
				//
				//
				for (i = 0; i < 22; i++) {
					panel[i + 48 + 5 + 24] = new JPanel();
					tf[i + 24] = new JTextField("20", 5);// 32+14
					panel[i + 48 + 5 + 24].add(label_arr[i + 48 + 5 + 24]);
					panel[i + 48 + 5 + 24].add(tf[i + 24]);
					panel[i + 48 + 5 + 24]
							.setBounds(280 * 3, 0 + 35 * (i), 275, 35);
					jf.add(panel[i + 48 + 5 + 24]);
					
					// panel[i+48+5].setBounds(0,0+35*i,275,35);
				}

				// 优先级
				// 48+5+16+16+14+i(0-12)label_arr
				// String
				// str13[]={"OCC广播优先级:","列车话筒广播优先级:","列车紧急广播优先级:","列车报站广播优先级:",
				// "关门提示音广播优先级:","测试广播优先级:","媒体广播优先级:",
				// "OCC-TPA话筒广播优先级:","OCC-TPA紧急广播优先级:",
				// "未命名优先级1:","未命名优先级2:","未命名优先级3:"};//12
				{// OCC广播优先级
					panel[22 + 48 + 5 + 24 + 1] = new JPanel();
					tf[22 + 24 + 1] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 1].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 0]);
					panel[22 + 48 + 5 + 24 + 1].add(tf[22 + 24 + 1]);
					panel[22 + 48 + 5 + 24 + 1].setBounds(280 * 4, 0 + 35 * (0),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 1]);
				}
				{// 列车话筒广播优先级
					panel[22 + 48 + 5 + 24 + 2] = new JPanel();
					tf[22 + 24 + 2] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 2].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 1]);
					panel[22 + 48 + 5 + 24 + 2].add(tf[22 + 24 + 2]);
					panel[22 + 48 + 5 + 24 + 2].setBounds(280 * 4, 0 + 35 * (1),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 2]);
				}
				{// 列车紧急广播优先级:
					panel[22 + 48 + 5 + 24 + 3] = new JPanel();
					tf[22 + 24 + 3] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 3].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 2]);
					panel[22 + 48 + 5 + 24 + 3].add(tf[22 + 24 + 3]);
					panel[22 + 48 + 5 + 24 + 3].setBounds(280 * 4, 0 + 35 * (2),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 3]);
				}
				{// 列车报站广播优先级:
					panel[22 + 48 + 5 + 24 + 4] = new JPanel();
					tf[22 + 24 + 4] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 4].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 3]);
					panel[22 + 48 + 5 + 24 + 4].add(tf[22 + 24 + 4]);
					panel[22 + 48 + 5 + 24 + 4].setBounds(280 * 4, 0 + 35 * (3),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 4]);
				}
				{// 关门提示音广播优先级
					panel[22 + 48 + 5 + 24 + 5] = new JPanel();
					tf[22 + 24 + 5] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 5].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 4]);
					panel[22 + 48 + 5 + 24 + 5].add(tf[22 + 24 + 5]);
					panel[22 + 48 + 5 + 24 + 5].setBounds(280 * 4, 0 + 35 * (4),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 5]);
				}
				{// 测试广播优先级
					panel[22 + 48 + 5 + 24 + 6] = new JPanel();
					tf[22 + 24 + 6] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 6].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 5]);
					panel[22 + 48 + 5 + 24 + 6].add(tf[22 + 24 + 6]);
					panel[22 + 48 + 5 + 24 + 6].setBounds(280 * 4, 0 + 35 * (5),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 6]);
				}
				{// 媒体广播优先级:
					panel[22 + 48 + 5 + 24 + 7] = new JPanel();
					tf[22 + 24 + 7] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 7].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 6]);
					panel[22 + 48 + 5 + 24 + 7].add(tf[22 + 24 + 7]);
					panel[22 + 48 + 5 + 24 + 7].setBounds(280 * 4, 0 + 35 * (6),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 7]);
				}
				{// OCC-TPA话筒广播优先级
					panel[22 + 48 + 5 + 24 + 8] = new JPanel();
					tf[22 + 24 + 8] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 8].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 7]);
					panel[22 + 48 + 5 + 24 + 8].add(tf[22 + 24 + 8]);
					panel[22 + 48 + 5 + 24 + 8].setBounds(280 * 4, 0 + 35 * (7),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 8]);
				}
				{// OCC-TPA紧急广播优先级
					panel[22 + 48 + 5 + 24 + 9] = new JPanel();
					tf[22 + 24 + 9] = new JTextField("10", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 9].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 8]);
					panel[22 + 48 + 5 + 24 + 9].add(tf[22 + 24 + 9]);
					panel[22 + 48 + 5 + 24 + 9].setBounds(280 * 4, 0 + 35 * (8),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 9]);
				}
				{// 未命名优先级1
					panel[22 + 48 + 5 + 24 + 10] = new JPanel();
					tf[22 + 24 + 10] = new JTextField("255", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 10].add(label_arr[48 + 5 + 16 + 16
							+ 14 + 9]);
					panel[22 + 48 + 5 + 24 + 10].add(tf[22 + 24 + 10]);
					panel[22 + 48 + 5 + 24 + 10].setBounds(280 * 4, 0 + 35 * (9),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 10]);
				}
				{// 未命名优先级2
					panel[22 + 48 + 5 + 24 + 11] = new JPanel();
					tf[22 + 24 + 11] = new JTextField("255", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 11].add(label_arr[48 + 5 + 16 + 16
							+ 14 + 10]);
					panel[22 + 48 + 5 + 24 + 11].add(tf[22 + 24 + 11]);
					panel[22 + 48 + 5 + 24 + 11].setBounds(280 * 4, 0 + 35 * (10),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 11]);
				}
				{// 未命名优先级3
					panel[22 + 48 + 5 + 24 + 12] = new JPanel();
					tf[22 + 24 + 12] = new JTextField("255", 5);// 32+14
					panel[22 + 48 + 5 + 24 + 12].add(label_arr[48 + 5 + 16 + 16
							+ 14 + 11]);
					panel[22 + 48 + 5 + 24 + 12].add(tf[22 + 24 + 12]);
					panel[22 + 48 + 5 + 24 + 12].setBounds(280 * 4, 0 + 35 * (11),
							280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 12]);
				}
				// 紧急广播 48+5+16+16+14+12
				{
					panel[22 + 48 + 5 + 24] = new JPanel();
					tf[22 + 24] = new JTextField("0", 5);// 32+14
					panel[22 + 48 + 5 + 24].add(label_arr[48 + 5 + 16 + 16 + 14
							+ 12]);
					panel[22 + 48 + 5 + 24].add(tf[22 + 24]);
					panel[22 + 48 + 5 + 24].setBounds(280 * 3, 0 + 35 * (22), 275,
							35);
					jf.add(panel[22 + 48 + 5 + 24]);
				}
				// String str14[]={"紧急广播ID:","起始站:","终点站:","当前站:","下一站:"};//5
				{
					tf[22 + 24 + 12 + 1 + 0] = new JTextField("1", 5);// 起始站:
					tf[22 + 24 + 12 + 1 + 1] = new JTextField("24", 5);// 终点站:
					tf[22 + 24 + 12 + 1 + 2] = new JTextField("1", 5);// 当前站:
					tf[22 + 24 + 12 + 1 + 3] = new JTextField("2", 5);// 下一站:
				}
				// 站信息
				// 48+5+16+16+14+12+i
				for (i = 0; i < 4; i++) 
				{
					panel[22 + 48 + 5 + 24 + 12 + 1 + i] = new JPanel();

					panel[22 + 48 + 5 + 24 + 12 + i + 1].add(label_arr[48 + 5 + 16
							+ 16 + 14 + 12 + i + 1]);
					panel[22 + 48 + 5 + 24 + 12 + i + 1].add(tf[22 + 24 + 12 + i
							+ 1]);// 48+5+16+16+14+12+i
					panel[22 + 48 + 5 + 24 + 12 + i + 1].setBounds(280 * 4,
							0 + 35 * (11 + i + 1), 280, 35);
					jf.add(panel[22 + 48 + 5 + 24 + 12 + i + 1]);
				}
				// String str15="越站";
				// String str16[]={"OCC-TPA广播","列车话筒广播","关门提示广播",
				// "OCC广播","紧急广播","离站广播","进站广播",
				// "媒体广播"};
				// String strtmp6="";
				// JCheckBox[] checkbox;
				// checkbox =new JCheckBox[72];//76--156
				// 复选框越站
				for (i = 0; i < 64; i++) {
					strtmp6 = str15;
					strtmp6 += String.valueOf(i + 1);
					//strtmp6 += ":";
					checkbox[i] = new JCheckBox(strtmp6);// 0--63
					
				}
				for (i = 0; i < 8; i++) {

					checkbox[i + 64] = new JCheckBox(str16[i]);// 64-71
				}
				//24
				for(i=0;i<8;i++)
				{
					panel[48+5+16+16+14+12+4+i] = new JPanel();
					for(j=0;j<4;j++)
					{
						panel[48+5+16+16+14+12+4+i].add(checkbox[j+i*4]);
					}
					panel[48+5+16+16+14+12+4+i].setBounds(280 * 4, 0 + 35 * (11 + i + 5), 280, 35);
					jf.add(panel[48+5+16+16+14+12+4+i]);
				}
				for(i=0;i<8;i++)
				{
					panel[48+5+16+16+14+12+12+i] = new JPanel();
					for(j=0;j<4;j++)
					{
						panel[48+5+16+16+14+12+12+i].add(checkbox[j+i*4+32]);
					}
					panel[48+5+16+16+14+12+12+i].setBounds(280 * 5+10, 0 + 35 * (i), 280, 35);
					jf.add(panel[48+5+16+16+14+12+12+i]);
				}
				for(i=0;i<4;i++)
				{
					panel[48+5+16+16+14+12+20+i] = new JPanel();
					for(j=0;j<2;j++)
					{
						panel[48+5+16+16+14+12+20+i].add(checkbox[j+i*2+64]);
					}
					panel[48+5+16+16+14+12+20+i].setBounds(280 * 5+10, 0 + 35 * (i+8), 280, 35);
					jf.add(panel[48+5+16+16+14+12+20+i]);
				}			
				
			}
			
//			Calendar c = Calendar.getInstance();
//			int year = c.get(Calendar.YEAR);
	//
//			int month = c.get(Calendar.MONTH);
	//
//			int date = c.get(Calendar.DATE);
	//
//			int hour = c.get(Calendar.HOUR_OF_DAY);
	//
//			int minute = c.get(Calendar.MINUTE);
	//
//			int second = c.get(Calendar.SECOND);
			
			str17+=String.valueOf(year);
			str17+="-";		
			str17+=String.valueOf(month+1);
			str17+="-";
			str17+=String.valueOf(date);
			str17+="-";
			str17+=String.valueOf(hour);
			str17+=":";
			str17+=String.valueOf(minute);
			str17+=":";
			str17+=String.valueOf(second);
			
			Font f = new Font("宋体",Font.PLAIN,18);		
			panel[48+5+16+16+14+12+20+4] = new JPanel();
			
			tf[63] = new JTextField(str17, 20);// 32+14
			tf[63].setEditable(false);
			tf[63].setFont(f);
			panel[48+5+16+16+14+12+20+4].add(tf[63]);
			panel[48+5+16+16+14+12+20+4].setBounds(280 * 1, 0 + 35 * (26), 280*4, 80*2);
			jf.add(panel[48+5+16+16+14+12+20+4]);
//			label_arr[116] = new JLabel(get_date_time());	//label_arr[116]没有用到
//			
//			label_arr[116].setFont(f);
//			tf[22 + 24 + 12 + 1 + 0] = new JTextField("1", 5);// 起始站:
//			tf[22 + 24 + 12 + 1 + 1] = new JTextField("24", 5);// 终点站:
//			tf[22 + 24 + 12 + 1 + 2] = new JTextField("1", 5);// 当前站:
//			tf[22 + 24 + 12 + 1 + 3] = new JTextField("2", 5);// 下一站:

			   timer.scheduleAtFixedRate(new TimerTask() {
		            public void run() 
		            {	                
		            	tf[63].setText(get_date_time());
//		            	{
//		            	String str_cur=tf[22 + 24 + 12 + 1 + 2].getText();
//		            	String str_next=tf[22 + 24 + 12 + 1 + 3].getText();	            	
//		            	tf[22 + 24 + 12 + 1 + 2].setText(String.valueOf(Integer.parseInt(str_cur)+1));// 当前站:
//		            	tf[22 + 24 + 12 + 1 + 3].setText(String.valueOf(Integer.parseInt(str_next)+1));// 下一站:
//		            	}
		            	//System.out.println(get_date_time());
		            }
		        }, 1000, 1000);
				jf.setLocationRelativeTo(null);
				jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			//	jf.setContentPane(panel);
				jf.setSize(2000, 2000);
				jf.setVisible(true);   
//			setSize(2000, 2000);
//			setVisible(true);
		}
		
	//************************************	

		class clienttask implements Runnable
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				try {
//					//��ȡ������
//					InputStream is = socket.getInputStream();
//					InputStreamReader isr = new InputStreamReader(is,"UTF-8");
//					BufferedReader br = new BufferedReader(isr);
//					String message = null;
//					while((message=br.readLine())!=null){
//					System.out.println(message);
//					}
//					} catch (Exception e) {
//					e.printStackTrace();
//					}		
//				
				while(true)
				{
					int ii=0;
					if(ii==100)
					{
					for(int i=0;i<8;i++)
					{
						//System.out.print(checkbox[i].getText()+":现在："+checkbox[i].isSelected());
					}
					}
					ii++;
				}
				
				
			}
					
		}
		// *************************
		// test14JTextField数组测试
		public void test14() {
			this.setLayout(null);
			JPanel panel[];
			panel = new JPanel[5];

			JLabel label_arr[];
			label_arr = new JLabel[5];

			// jlb11 = new JLabel("广播控制盒话筒音量：");

			JTextField tf[];
			tf = new JTextField[5];

			JTextField tf1, tf2, tf3;
			// 5的时候最好吧
			tf1 = new JTextField("20", 5);// 文本框大小还没写�?
			// tf1.setBounds(50, 50, 50,50);
			// tf1.setBorder(new LineBorder(Color.black));
			// jp11.add(jlb11);
			// jp11.add(tf1);
			// this.add(jp11);

			for (int i = 0; i < 5; i++) {
				panel[i] = new JPanel();
				label_arr[i] = new JLabel(String.valueOf(i));
				tf[i] = new JTextField(String.valueOf(i + 20), 5);// 文本框大小还没写�?
				// tf1.setBounds(0, 0+i*50, 50,50);
				panel[i].add(label_arr[i]);
				panel[i].add(tf[i]);
				this.add(panel[i]);
				panel[i].setBounds(0, 0 + 35 * i, 275, 35);
			}

			
			setSize(2000, 2000);
			setVisible(true);
		}

		// 紧急报警器测试
		public void test12() {
			// JPanel panel=new JPanel(new GridLayout(48,12,1,1));
			// GridLayout gridLayout = new GridLayout(36,12,2,2);
			this.setLayout(null);

			JPanel panal1, panal2, panal3, panal4, panal5;

			panal1 = new JPanel();
			panal2 = new JPanel();
			panal3 = new JPanel();
			panal4 = new JPanel();

			JLabel jlb11, jlb12;
			jlb11 = new JLabel("广播控制盒话筒音量：");

			JTextField tf1, tf2, tf3;
			// 5的时候最好吧
			tf1 = new JTextField("20", 4);// 文本框大小还没写�?
			// tf1.setBounds(0, 120, 275,40);

			JLabel label_arr[];
			label_arr = new JLabel[48];

			String str = "紧急报警器";
			String strtemp = "";
			String str1[] = { "正常/取消申请/接通后挂断", "申请", "接通(控制盒)", "接通(OCC-TPA)" };

			JComboBox jcb0, jcb1, jcb2; // 下拉列表

			// JComboBox<Object> ComboBox_arr[];//下拉列表
			// ComboBox_arr = new JComboBox [48];

			jcb2 = new JComboBox(str1);
			jcb1 = new JComboBox(str1);
			jcb0 = new JComboBox(str1);
			// ComboBox_arr[1] = new JComboBox(str1);

			int i = 0, j = 0, k = 0;
			for (i = 0; i < 8; i++) {
				for (j = 0; j < 6; j++) {
					strtemp = str;
					strtemp += String.valueOf(i + 1);
					strtemp += "-";
					strtemp += String.valueOf(j + 1);
					strtemp += ":";
					// System.out.println(strtemp);
					// 0-47;0-6,
					label_arr[j + i * 6] = new JLabel(strtemp);
					// System.out.println(j+6*i);
				}
			}
			
//			jcb2.removeAllItems();
//			jcb2.setModel(arg0);
			panal1.add(label_arr[0]);// label
			panal1.add(jcb0);// 下拉列表

			panal2.add(label_arr[1]);
			panal2.add(jcb1);

			panal3.add(label_arr[2]);
			panal3.add(jcb2);

			panal4.add(jlb11);
			panal4.add(tf1);

			panal1.setBounds(0, 0, 275, 40);
			panal2.setBounds(0, 40, 275, 40);
			panal3.setBounds(0, 80, 275, 40);
			// panal4.setBounds(0,120,275,40);

			// panal+String.valueOf(4)

			// for(k=0;k<48;k++)
			// { //0-47;0-6
			// ComboBox_arr[k] = new JComboBox<Object>(str1);
			// panal_arr[k]=new
			// ComboBox_arr[i] = new JComboBox(str1);
			// }

			// for(k=0;k<48;k++)
			// {
			// panal_arr[k].add(label_arr[k]);
			// panal_arr[k].add(ComboBox_arr[k]);//有问题
			// }
			// 将面板放置在窗体CENTER位置
			// jcb2.setSize(3, 3);
			// panel.add(label_arr[1]);
			// panel.add(jcb2);//有问题
			// panel.add(label_arr[2]);
			// panel.add(jcb1);//有问题
			// getContentPane().add(panal_arr[0],BorderLayout.CENTER);
			this.add(panal1);
			this.add(panal3);
			this.add(panal2);
			this.add(panal4);
			// 网格布局2行一�?
			setSize(800, 800);
			setVisible(true);
			// this.setLayout(gridLayout);
			// this.setLayout(new GridLayout(3, 14)); //列数�? jp1 = new JPanel(); 有关

		}

		// ***************

		// 紧急报警器
		public void Test0() {

			// JButton btn[];//声明按钮数组
			//
			// btn=new JButton[str.length];//创建按钮数组
			//
			// for(int i=0;i<str.length;i++){//循环定义按钮，并添加到面板中
			//
			// btn[i]=new JButton(str[i]);
			//
			// p.add(btn[i]);}

			JList jlist; // 列表框
			JComboBox jcb1, jcb2; // 下拉列表

			JPanel jp1, jp2; // 面板

			JLabel jlb1, jlb2;
			JScrollPane jsp; // 滚动控件

			jp1 = new JPanel();

			jp2 = new JPanel();

			jlb1 = new JLabel("紧急报警器1");

			String str1[] = { "接�?�（OCC-TPA�?", "申请", "接�?�（控制盒）",
					"正常/取消申请/接�?�后挂断" };

			jcb1 = new JComboBox(str1);
			jcb2 = new JComboBox(str1);

			jlb2 = new JLabel("紧急报警器2");

			jp1.add(jlb1);
			jp1.add(jcb1);

			jp2.add(jlb2);
			jp2.add(jcb2);

			this.add(jp1);
			this.add(jp2);

			// 网格布局2行一�?
			this.setLayout(new GridLayout(1, 4)); // 列数�? jp1 = new JPanel(); 有关

			this.setSize(2500, 2500);
			this.setTitle("组件演示");
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		private void setLayout(GridLayout gridLayout) {
			// TODO Auto-generated method stub
			
		}

		// 修改音量和优先级
		public void test2() {
			JPanel jp11, jp12; // 面板
			jp11 = new JPanel();
			JLabel jlb11, jlb12;
			jlb11 = new JLabel("广播控制盒话筒音量：");

			JTextField tf1, tf2, tf3;
			// 5的时候最好吧
			tf1 = new JTextField("20", 5);// 文本框大小还没写�?
			tf1.setBounds(50, 50, 50, 50);
			// tf1.setBorder(new LineBorder(Color.black));
			jp11.add(jlb11);
			jp11.add(tf1);
			this.add(jp11);
			// System.out.print("sss");
			this.setSize(2000, 2000);
			this.setTitle("组件演示");
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// f.setSize(300, 300);
			// f.setLocationRelativeTo(null);
			// f.setLayout(null);
			// f.setVisible(true);

		}

//		private void setDefaultCloseOperation(int exitOnClose) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		private void setVisible(boolean b) {
//			// TODO Auto-generated method stub
//			
//		}

//		private void setTitle(String string) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		private void add(JPanel jp11) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		private void setSize(int i, int j) {
//			// TODO Auto-generated method stub
//			
//		}

		public String get_date_time() {
			String str18="";
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);

			int month = c.get(Calendar.MONTH);

			int date = c.get(Calendar.DATE);

			int hour = c.get(Calendar.HOUR_OF_DAY);

			int minute = c.get(Calendar.MINUTE);

			int second = c.get(Calendar.SECOND);
			// 通过Calendar类来获取当前时间
//			System.out.println(year + "/" + month + "/" + date + " " + hour + ":"
//					+ minute + ":" + second);
			
			str18+=String.valueOf(year);
			str18+="-";		
			str18+=String.valueOf(month+1);
			str18+="-";
			str18+=String.valueOf(date);
			str18+="  ";
			str18+=String.valueOf(hour);
			str18+=":";
			str18+=String.valueOf(minute);
			str18+=":";
			str18+=String.valueOf(second);
			
			//System.out.println(month);
			
	//System.out.println(str18);
			
//			JPanel	panel116;
//			JLabel	label_arr116;
//			Font f = new Font("宋体",Font.PLAIN,24);		
//			panel116 = new JPanel();
//			label_arr116 = new JLabel(str18);
//			label_arr116.setFont(f);
//			panel116.add(label_arr116);
//			panel116.setBounds(280 * 2, 0 + 35 * (26), 280*2, 80*2);
//			this.add(panel116);
			
			return str18;
		}

	}


