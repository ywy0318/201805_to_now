package DEBUG;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;





public class ui extends JFrame{
	private JTabbedPane jTabbedpane = new JTabbedPane();
	private String[] tabNames = { "紧急报警器报警与否","紧急报警器-无线PIS故障",
			"动态地图故障","功放-司机室设备故障","TRDP发送的实时数据","PISTOMVB实时数据"
			,"MVBTOPIS实时数据"};
	
	Font f = new Font("宋体",Font.PLAIN,24);
	String strtemp = "";
	String strtemp2 = "";
	String str = "紧急报警器";
	String str_bit="Bit";
	static short life=0;
	static int iij=0;
	static int sec=0;
	static int min=0;
	static int hex[]={0x80,0x40,0x20,0x10,0x08,0x04,0x02,0x01};
	String str_open_door_1="下一站开 A 侧门:";
	String str_open_door_2="下一站开 B 侧门:";
	String ooc_state="OCC_广播状态:";
	String str1[] = {"非报警", "报警"};
	String str31[] = {"正常", "故障"};	
	String str32[] = {"广播控制盒", "中控","录音"};
	String str33[] = {"无效","有效"};//开门侧
	String str34[] = {"无效","故障"};//车内主机故障
	String str35[] = {"正常无故障","存在故障"};//内部故障
	String str36[] = {"车内无复位","发生了复位"};//车内发生了复位
	String str37[] = {"非occ广播","正在进行广播"};//occ广播状态
	
	String str30[] = {"组编无效","连挂有效"};//连挂标志
	String str29[] = {"解编模式","无效"};//解编标志
	
	String str38[] = {"无效","主模式","从模式"};//pis工作模式
	String str39[] = {"空闲","occ广播","人工广播","紧急广播"
			,"关门提示音","自动广播","媒体伴音"};//当前广播状态 
	String str40[] = {"空闲","通话"};//司机间通话-司乘通话
	static String[] str41 = new String[41];//与紧急报警器通话的序号
	
	static String[] column_name_for_all=new String[19];
	
	static public JPanel panel_for_jinji_num = new JPanel();
	static public JTextField tf_for_jinji_num = new JTextField();
	static public JLabel label_for_jinji_num = new JLabel("紧急广播序号::");
	static int jinj_num=0;
	
	
	//	JTable table_for_PIS_TO_MVB = new JTable();
	//JTable table_for_MVB_TO_PIS = new JTable();
//	static String[] column_name_for_PIS_TO_MVB=new String[19];
//	static String[] column_name_for_MVB_TO_PIS=new String[19];
	
	static public byte[] by_for_send =new byte[97+5];//过程数据--Trdp
	static public byte[] by_for_send_to_MVB =new byte[97+5];//PIS_TO_MVB--
	
	static public byte[] by_for_recv =new byte[40];//过程数据
	
	Timer timer_refresh_data = new Timer();
	Timer timer_refresh_table_data_for_trdp = new Timer();
	//紧急报警器ComboBox_for_bjq = new JComboBox [40];str1
	JPanel[] panel_for_bjq = new JPanel[40];
	JComboBox<String>[]  ComboBox_for_bjq = new JComboBox [40];
	JLabel[] label_for_bjq = new JLabel[40];
	
	//动态地图故障--客室ComboBox_for_map = new JComboBox [80];
	JPanel[] panel_for_map = new JPanel[80];
	JComboBox<String>[]  ComboBox_for_map = new JComboBox [80];
	JLabel[] label_for_map = new JLabel[80];
	
	//报警器故障--客室ComboBox_for_bjq_fault = new JComboBox [40];
	JPanel[] panel_for_bjq_fault = new JPanel[40];
	JComboBox<String>[]  ComboBox_for_bjq_fault = new JComboBox [40];
	JLabel[] label_for_bjq_fault = new JLabel[40];
	
	//功放故障--客室ComboBox_for_gf_fault = new JComboBox [16];
	JPanel[] panel_for_gf_fault = new JPanel[16];
	JComboBox<String>[]  ComboBox_for_gf_fault = new JComboBox [16];
	JLabel[] label_for_gf_fault = new JLabel[16];	
	
	//无线pis故障--客室ComboBox_for_wireless_fault = new JComboBox [16];
	JPanel[] panel_for_wireless_fault = new JPanel[16];
	JComboBox<String>[]  ComboBox_for_wireless_fault = new JComboBox [16];
	JLabel[] label_for_wireless_fault = new JLabel[16];
	
	//司机室设备故障ComboBox_for_drv_fault = new JComboBox [6];
	JPanel[] panel_for_drv_fault = new JPanel[6];
	JComboBox<String>[]  ComboBox_for_drv_fault = new JComboBox [6];
	JLabel[] label_for_drv_fault = new JLabel[6];	

	//连挂-解编String str30[] = {"组编无效","连挂有效"};//连挂标志
	//String str29[] = {"解编模式","无效"};//解编标志
	//ComboBox_for_liangua_jiebian = new JComboBox [2];
	JPanel[] panel_for_liangua_jiebian = new JPanel[2];
	JComboBox<String>[]  ComboBox_for_liangua_jiebian = new JComboBox [2];
	JLabel[] label_for_liangua_jiebian = new JLabel[2];
	
	//下一站开门侧ComboBox_for_open_door = new JComboBox [2];
	JPanel[] panel_for_open_door = new JPanel[2];
	JComboBox<String>[]  ComboBox_for_open_door = new JComboBox [2];
	JLabel[] label_for_open_door = new JLabel[2];
	
	//站点ComboBox_for_station = new JComboBox [3];
	JPanel[] panel_for_station = new JPanel[3];
	JComboBox<String>[]  ComboBox_for_station = new JComboBox [3];
	JLabel[] label_for_station = new JLabel[3];	
	
	//occ广播状态ComboBox_for_occ = new JComboBox [1];
	JPanel[] panel_for_occ = new JPanel[1];
	JComboBox<String>[]  ComboBox_for_occ = new JComboBox [1];
	JLabel[] label_for_occ = new JLabel[1];

	
	//pis工作模式ComboBox_for_pis_work = new JComboBox [1];
	JPanel[] panel_for_pis_work = new JPanel[1];
	JComboBox<String>[]  ComboBox_for_pis_work = new JComboBox [1];
	JLabel[] label_for_pis_work = new JLabel[1];	

	//与紧急报警器通话的序号ComboBox_for_bjq_num = new JComboBox [1];
	JPanel[] panel_for_bjq_num = new JPanel[1];
	JComboBox<String>[]  ComboBox_for_bjq_num = new JComboBox [1];
	JLabel[] label_for_bjq_num = new JLabel[1];	
	
	//当前广播状态ComboBox_for_cur_state = new JComboBox [1];
	JPanel[] panel_for_cur_state = new JPanel[1];
	JComboBox<String>[]  ComboBox_for_cur_state = new JComboBox [1];
	JLabel[] label_for_cur_state = new JLabel[1];
	
	//司机间通话-司乘通话ComboBox_for_commu = new JComboBox [2];
	JPanel[] panel_for_commu = new JPanel[2];
	JComboBox<String>[]  ComboBox_for_commu = new JComboBox [2];
	JLabel[] label_for_commu = new JLabel[2];
	
	//车内发生了复位
	JPanel[] panel_for_fuwei = new JPanel[8];
	JComboBox<String>[]  ComboBox_for_fuwei = new JComboBox [8];
	JLabel[] label_for_fuwei = new JLabel[8];
	
	//1车PIS内部存在故障ComboBox_for_guzhang = new JComboBox [8];
	JPanel[] panel_for_guzhang = new JPanel[8];
	JComboBox<String>[]  ComboBox_for_guzhang = new JComboBox [8];
	JLabel[] label_for_guzhang = new JLabel[8];	
	
	//车内主机发生了故障ComboBox_for_zhuji_guzhang = new JComboBox [8];
	JPanel[] panel_for_zhuji_guzhang = new JPanel[8];
	JComboBox<String>[]  ComboBox_for_zhuji_guzhang = new JComboBox [8];
	JLabel[] label_for_zhuji_guzhang = new JLabel[8];
	
	//tc1_tc2_guzhang发生了故障ComboBox_for_tc1_tc2_guzhang = new JComboBox [2];
	JPanel[] panel_for_tc1_tc2_guzhang = new JPanel[2];
	JComboBox<String>[]  ComboBox_for_tc1_tc2_guzhang = new JComboBox [2];
	JLabel[] label_for_tc1_tc2_guzhang = new JLabel[2];	
	
	JTable table_for_trdp = new JTable();
	static  public  JTable table_for_PIS_TO_MVB = new JTable();
	
	static JTable table_for_MVB_TO_PIS = new JTable();
	static public DefaultTableModel dd_for_MVB_TO_PIS=null;
	
	/****************/
	// TODO Auto-generated constructor stub
	public ui() {
		this.setLayout(null);
		int i=0;
		int j=0;
		JPanel[] panel_for_tab = new JPanel[tabNames.length];
		for(i=0;i<tabNames.length;i++)
		{
			panel_for_tab[i] = new JPanel();
			panel_for_tab[i].setLayout(null);
			panel_for_tab[i].setBackground(Color.WHITE);
			jTabbedpane.addTab(tabNames[i], panel_for_tab[i]);
			jTabbedpane.setFont(f);
			jTabbedpane.setBackground(Color.green);	 
		}
		for(i=0;i<41;i++)
		{
			str41[i]=String.valueOf(i);
			if(i<40)
			{
				by_for_recv[i]=0;
			}
		}
		
		
		{
		column_name_for_all[0]="字节序号";
//		for(i=0;i<16;i++)
//		{
//			column_name_for_all[i+1]=str_bit+String.valueOf((15-i));
//		}
		for(i=0;i<8;i++)
		{
			column_name_for_all[i+1]=str_bit+String.valueOf((7-i));
		}
		for(i=8;i<16;i++)
		{
			column_name_for_all[i+1]=str_bit+String.valueOf((23-i));
		}
		column_name_for_all[18]="高字节";
		column_name_for_all[17]="低字节";
		}
		
		
		
//...加载table_for_trdp
{	
		Vector cv = new Vector();
		Vector tablevalue_v = new Vector();
		{
			for(i=0;i<column_name_for_all.length;i++)
			{
				//System.out.print(column_name[i]);
				cv.add(column_name_for_all[i]);				
			}			
			for(int ii=0;ii<15;ii++)
			{
				Vector row_v = new Vector();
				for(int k=0;k<column_name_for_all.length;k++)
				{
					if(k==0)
					{
						row_v.add(ii);
					}
					else
					{
						//row_v.add(99);
					}
					
				}
				tablevalue_v.add(row_v);
			}
		}
		DefaultTableModel dd=new DefaultTableModel(tablevalue_v, cv)
		{
			public boolean isCellEditable(int row,int column){  
			    if(column ==0){  
			       return false;  
			    }else{  
			       //return true; 
			       return false; 
			    }  
			}
		};	
		JScrollPane scrollpane_for_trdp=new JScrollPane(table_for_trdp);
		table_for_trdp.setModel(dd);
		table_for_trdp.setRowHeight(40);
		table_for_trdp.setForeground(Color.BLUE);
		table_for_trdp.setFont(new Font("宋体",Font.PLAIN,24));
		scrollpane_for_trdp.setBounds(10, 10, 1600, 800);
		panel_for_tab[4].add(scrollpane_for_trdp);
}//end...加载table_for_trdp

//...加载table_for_PIS_TO_MVB
//column_name_for_all
//column_name_for_PIS_TO_MVB
{
	Vector cv_for_PIS_TO_MVB = new Vector();
	Vector tablevalue_v_for_PIS_TO_MVB = new Vector();
	{
		for(i=0;i<column_name_for_all.length;i++)
		{
			//System.out.print(column_name[i]);
			cv_for_PIS_TO_MVB.add(column_name_for_all[i]);				
		}
		//3.6.1	端口（0x910、0x960）
		for(int ii=0;ii<24;ii++)
		{
			Vector row_v_for_PIS_TO_MVB = new Vector();
			for(int k=0;k<column_name_for_all.length;k++)
			{
				if(k==0)
				{
					if(ii<=15)
					{
						row_v_for_PIS_TO_MVB.add(ii);
					}
					else
					{
						row_v_for_PIS_TO_MVB.add((ii-16));
					}
				}
				else
				{
					//row_v_for_PIS_TO_MVB.add(99);
				}
				
			}
			tablevalue_v_for_PIS_TO_MVB.add(row_v_for_PIS_TO_MVB);
		}

	}
	DefaultTableModel dd_for_PIS_TO_MVB=new DefaultTableModel(tablevalue_v_for_PIS_TO_MVB, cv_for_PIS_TO_MVB)
	{
		public boolean isCellEditable(int row,int column){  
		    if(column ==0){  
		       return false;  
		    }else{  
		    	//return true; 
			       return false;   
		    }  
		}
	};	
	JScrollPane scrollpane_for_PIS_TO_MVB=new JScrollPane(table_for_PIS_TO_MVB);
	table_for_PIS_TO_MVB.setModel(dd_for_PIS_TO_MVB);
	table_for_PIS_TO_MVB.setRowHeight(30);
	table_for_PIS_TO_MVB.setForeground(Color.BLUE);
	table_for_PIS_TO_MVB.setFont(new Font("宋体",Font.PLAIN,24));
	scrollpane_for_PIS_TO_MVB.setBounds(10, 10, 1600, 800);
	panel_for_tab[5].add(scrollpane_for_PIS_TO_MVB);	
}//end...加载table_for_PIS_TO_MVB

//...加载table_for_PIS_TO_MVB

//column_name_for_MVB_TO_PIS
{
	Vector cv_for_MVB_TO_PIS = new Vector();
	Vector tablevalue_v_for_MVB_TO_PIS = new Vector();
	{
		for(i=0;i<column_name_for_all.length;i++)
		{
			//System.out.print(column_name[i]);
			cv_for_MVB_TO_PIS.add(column_name_for_all[i]);				
		}			
		for(int ii=0;ii<20;ii++)
		{
			Vector row_v_for_MVB_TO_PIS = new Vector();
			for(int k=0;k<column_name_for_all.length;k++)
			{
				if(k==0)
				{
					row_v_for_MVB_TO_PIS.add(ii);
				}
				else
				{
					//row_v_for_MVB_TO_PIS.add(99);
				}
				
			}
			tablevalue_v_for_MVB_TO_PIS.add(row_v_for_MVB_TO_PIS);
		}
	}
	//
	dd_for_MVB_TO_PIS=new DefaultTableModel(tablevalue_v_for_MVB_TO_PIS, cv_for_MVB_TO_PIS)
	{
		public boolean isCellEditable(int row,int column){  
		    if(column ==0){  
		       return false;  
		    }else{  
		    	//return true; 
			       return false;   
		    }  
		}
	};
	//dd_for_MVB_TO_PIS.set
	//dd_for_MVB_TO_PIS.setDataVector(arg0, arg1);
	JScrollPane scrollpane_for_MVB_TO_PIS=new JScrollPane(table_for_MVB_TO_PIS);
	table_for_MVB_TO_PIS.setModel(dd_for_MVB_TO_PIS);
	table_for_MVB_TO_PIS.setRowHeight(35);
	table_for_MVB_TO_PIS.setForeground(Color.BLUE);
	//if(table_for_MVB_TO_PIS.col)
	table_for_MVB_TO_PIS.setFont(new Font("宋体",Font.PLAIN,24));
	scrollpane_for_MVB_TO_PIS.setBounds(10, 10, 1600, 800);
	panel_for_tab[6].add(scrollpane_for_MVB_TO_PIS);	
}//end...加载table_for_PIS_TO_MVB

		{//紧急报警器报警与否
		for(i=0;i<8;i++)
		{
			for(j=0;j<5;j++)
			{
				strtemp = str;
				strtemp += ":";
				strtemp += String.valueOf(i + 1);
				strtemp+="车";
				strtemp += "-";
				strtemp += String.valueOf(j + 1);
				strtemp += "--(";
				strtemp += String.valueOf(j + 1+i*5);
				strtemp += ")";
				strtemp += ":";				
				label_for_bjq[j + i * 5] = new JLabel(strtemp);
				if(i%2==0)
				{
					label_for_bjq[j + i * 5].setForeground(Color.BLUE); 
				}
				else
				{
					label_for_bjq[j + i * 5].setForeground(Color.BLUE); 
					//label_for_bjq[j + i * 5].setForeground(Color.red);
				}
			}
		}
		for(i=0;i<40;i++)
		{
			panel_for_bjq[i] = new JPanel();
		//	panel_for_bjq[i].setSize(100, 40);ComboBox_for_bjqstr1
			ComboBox_for_bjq[i] = new JComboBox<String>(str1);
			panel_for_bjq[i].add(label_for_bjq[i]);
			panel_for_bjq[i].add(ComboBox_for_bjq[i]);			
			panel_for_tab[0].add(panel_for_bjq[i]);

		}
		  {
			int ii=-1;
			for(i=0;i<40;i++)
			{
				if(i%5==0)
				{
					 ii+=1;	
				}
				panel_for_bjq[i].setBounds(50+300*(i%5), 0+40 * (i/5)+10*(ii), 270, 40);
			}			
		  }
		}

		{
		 //动态地图故障
			for(i=0;i<8;i++)
			{
				for(j=0;j<10;j++)
				{
					strtemp="动态地图故障";
					strtemp+=String.valueOf(i+1);
					strtemp+="车";
					strtemp+="-";
					strtemp+=String.valueOf(j+1);
					strtemp+=":";
					
					panel_for_map[i*10+j] = new JPanel();
					label_for_map[i*10+j] = new JLabel(strtemp);
					ComboBox_for_map[i*10+j] = new JComboBox<String>(str31);
					panel_for_map[i*10+j].add(label_for_map[i*10+j]);
					panel_for_map[i*10+j].add(ComboBox_for_map[i*10+j]);
					
					if(j/5==0)
					{
						label_for_map[i*10+j].setForeground(Color.BLUE);
					}
					else
					{
						label_for_map[i*10+j].setForeground(Color.BLUE);
						//label_for_map[i*10+j].setForeground(Color.red);
					}
					panel_for_map[i*10+j].setBounds(25+255*(j%5), 20+45 * (j/5)+100*(i), 250, 40);
					panel_for_tab[2].add(panel_for_map[i*10+j]);
				}
			}
			
		}
		{//报警器故障panel_for_bjq_fault
		 
			for(i=0;i<8;i++)
			{
				for(j=0;j<5;j++)
				{
					strtemp="报警器故障";
					strtemp+=String.valueOf(i+1);
					strtemp+="车";
					strtemp+="-";
					strtemp+=String.valueOf(j+1);
					strtemp += "--(";
					strtemp += String.valueOf(j + 1+i*5);
					strtemp += ")";
					strtemp += ":";	
					
					
					
					panel_for_bjq_fault[i*5+j] = new JPanel();
					label_for_bjq_fault[i*5+j] = new JLabel(strtemp);
					ComboBox_for_bjq_fault[i*5+j] = new JComboBox<String>(str31);
					panel_for_bjq_fault[i*5+j].add(label_for_bjq_fault[i*5+j]);
					panel_for_bjq_fault[i*5+j].add(ComboBox_for_bjq_fault[i*5+j]);
					if(i%2==0)
					{
						label_for_bjq_fault[i*5+j].setForeground(Color.BLUE);
					}
					else
					{
						//label_for_bjq_fault[i*5+j].setForeground(Color.red);
						label_for_bjq_fault[i*5+j].setForeground(Color.BLUE);
					}
					
					panel_for_bjq_fault[i*5+j].setBounds(25+285*(j%5), 20+45 * (j/5)+50*(i), 250, 40);
					panel_for_tab[1].add(panel_for_bjq_fault[i*5+j]);
				}
			}
			//无线pis故障panel_for_wireless_fault
			for(i=0;i<8;i++)
			{
				for(j=0;j<2;j++)
				{
					strtemp="无线pis故障";
					strtemp+=String.valueOf(i+1);
					strtemp+="车";
					strtemp+="-";
					strtemp+=String.valueOf(j+1);
					strtemp+=":";
					
					panel_for_wireless_fault[i*2+j] = new JPanel();
					label_for_wireless_fault[i*2+j] = new JLabel(strtemp);
					ComboBox_for_wireless_fault[i*2+j] = new JComboBox<String>(str31);
					panel_for_wireless_fault[i*2+j].add(label_for_wireless_fault[i*2+j]);
					panel_for_wireless_fault[i*2+j].add(ComboBox_for_wireless_fault[i*2+j]);
					if(i%2==0)
					{
						label_for_wireless_fault[i*2+j].setForeground(Color.BLUE);
					}
					else
					{
						label_for_wireless_fault[i*2+j].setForeground(Color.BLUE);
						//label_for_wireless_fault[i*2+j].setForeground(Color.red);
					}
					panel_for_wireless_fault[i*2+j].setBounds(25+285*((i*2+j)%4), 440+45 * (j/2)+50*((i*2+j)/4), 250, 40);
					//panel_for_wireless_fault[i*2+j].setBounds(25+285*(j%2), 470+45 * (j/2)+50*(i), 250, 40);
					panel_for_tab[1].add(panel_for_wireless_fault[i*2+j]);
				}
			}			
		}
		{			
			//功放故障panel_for_gf_fault
			for(i=0;i<8;i++)
			{
				for(j=0;j<2;j++)
				{
					strtemp="功放故障";
					strtemp+=String.valueOf(i+1);
					strtemp+="车";
					strtemp+="-";
					strtemp+=String.valueOf(j+1);
					strtemp+=":";					
					panel_for_gf_fault[i*2+j] = new JPanel();
					label_for_gf_fault[i*2+j] = new JLabel(strtemp);
					ComboBox_for_gf_fault[i*2+j] = new JComboBox<String>(str31);
					panel_for_gf_fault[i*2+j].add(label_for_gf_fault[i*2+j]);
					panel_for_gf_fault[i*2+j].add(ComboBox_for_gf_fault[i*2+j]);
					if(i%2==0)
					{
						label_for_gf_fault[i*2+j].setForeground(Color.BLUE);
					}
					else
					{
						label_for_gf_fault[i*2+j].setForeground(Color.BLUE);
						//label_for_gf_fault[i*2+j].setForeground(Color.red);
					}
					panel_for_gf_fault[i*2+j].setBounds(25+285*((i*2+j)%4), 20+45 * (j/2)+50*((i*2+j)/4), 250, 40);
					//panel_for_wireless_fault[i*2+j].setBounds(25+285*(j%2), 470+45 * (j/2)+50*(i), 250, 40);
					panel_for_tab[3].add(panel_for_gf_fault[i*2+j]);
				}
			}	
		}
		{
			//司机室故障panel_for_drv_fault
			//ComboBox_for_drv_faultString str32[] = {"广播控制盒", "中控","录音"};str31
			for(i=0;i<2;i++)
			{
				for(j=0;j<str32.length;j++)
				{
					//System.out.println(i*3+j);
					strtemp="TC";
					strtemp+=String.valueOf(i+1);
					strtemp+="车";
					strtemp+="-";
					strtemp+=str32[j];
					strtemp+=":";					
					panel_for_drv_fault[i*3+j] = new JPanel();
					label_for_drv_fault[i*3+j] = new JLabel(strtemp);
					ComboBox_for_drv_fault[i*3+j] = new JComboBox<String>(str31);
					panel_for_drv_fault[i*3+j].add(label_for_drv_fault[i*3+j]);
					panel_for_drv_fault[i*3+j].add(ComboBox_for_drv_fault[i*3+j]);
					if(i%3==0)
					{
						label_for_drv_fault[i*3+j].setForeground(Color.BLUE);
					}
					else
					{
						label_for_drv_fault[i*3+j].setForeground(Color.red);
					}
					panel_for_drv_fault[i*3+j].setBounds(25+285*(j%3), 240+45 * (j/3)+50*(i), 250, 40);
					
					panel_for_tab[3].add(panel_for_drv_fault[i*3+j]);
				}
			}
			
			//站点
//			JPanel[] panel_for_station = new JPanel[3];
//			JComboBox<String>[]  ComboBox_for_station = new JComboBox [3];
//			JLabel[] label_for_station = new JLabel[3];
			
			//站点
			panel_for_station[0] = new JPanel();
			label_for_station[0] = new JLabel("当前站:---");
			ComboBox_for_station[0] = new JComboBox<String>(str41);
			panel_for_station[0].add(label_for_station[0]);
			panel_for_station[0].add(ComboBox_for_station[0]);
			label_for_station[0].setForeground(Color.BLUE);
			panel_for_station[0].setBounds(25+285*(4), 20+20 * (0)+40*(0), 270, 40);
			panel_for_tab[3].add(panel_for_station[0]);
			
			panel_for_station[1] = new JPanel();
			label_for_station[1] = new JLabel("下一站:---");
			ComboBox_for_station[1] = new JComboBox<String>(str41);
			panel_for_station[1].add(label_for_station[1]);
			panel_for_station[1].add(ComboBox_for_station[1]);
			label_for_station[1].setForeground(Color.BLUE);
			panel_for_station[1].setBounds(25+285*(4), 20+20 * (0)+40*(1), 270, 40);
			panel_for_tab[3].add(panel_for_station[1]);
			
			panel_for_station[2] = new JPanel();
			label_for_station[2] = new JLabel("目的站:---");
			ComboBox_for_station[2] = new JComboBox<String>(str41);
			panel_for_station[2].add(label_for_station[2]);
			panel_for_station[2].add(ComboBox_for_station[2]);
			label_for_station[2].setForeground(Color.BLUE);
			panel_for_station[2].setBounds(25+285*(4), 20+20 * (0)+40*(2), 270, 40);
			panel_for_tab[3].add(panel_for_station[2]);
			
			ComboBox_for_station[0].setSelectedIndex(1);//当前站:---str41
			ComboBox_for_station[1].setSelectedIndex(1);//下一站:---
			ComboBox_for_station[2].setSelectedIndex(1);//目的站:---
			/***************************/
	//下一站开门侧
			panel_for_open_door[0] = new JPanel();
			label_for_open_door[0] = new JLabel(str_open_door_1);
			ComboBox_for_open_door[0] = new JComboBox<String>(str33);
			panel_for_open_door[0].add(label_for_open_door[0]);
			panel_for_open_door[0].add(ComboBox_for_open_door[0]);
			label_for_open_door[0].setForeground(Color.BLUE);
			panel_for_open_door[0].setBounds(25+285*(3), 240+45 * (0)+50*(0), 250, 40);
			panel_for_tab[3].add(panel_for_open_door[0]);
			
			panel_for_open_door[1] = new JPanel();
			label_for_open_door[1] = new JLabel(str_open_door_2);
			ComboBox_for_open_door[1] = new JComboBox<String>(str33);
			panel_for_open_door[1].add(label_for_open_door[1]);
			panel_for_open_door[1].add(ComboBox_for_open_door[1]);
			label_for_open_door[1].setForeground(Color.BLUE);
			panel_for_open_door[1].setBounds(25+285*(3), 240+45 * (0)+50*(1), 250, 40);
			panel_for_tab[3].add(panel_for_open_door[1]);
			
//			JPanel[] panel_for_tc1_tc2_guzhang = new JPanel[2];
//			JComboBox<String>[]  ComboBox_for_tc1_tc2_guzhang = new JComboBox [2];
//			JLabel[] label_for_tc1_tc2_guzhang = new JLabel[2];	
			
			panel_for_tc1_tc2_guzhang[0] = new JPanel();
			label_for_tc1_tc2_guzhang[0] = new JLabel("TC1司机室主机故障");
			ComboBox_for_tc1_tc2_guzhang[0] = new JComboBox<String>(str31);
			panel_for_tc1_tc2_guzhang[0].add(label_for_tc1_tc2_guzhang[0]);
			panel_for_tc1_tc2_guzhang[0].add(ComboBox_for_tc1_tc2_guzhang[0]);
			label_for_tc1_tc2_guzhang[0].setForeground(Color.BLUE);
			//panel_for_station[2].setBounds(25+285*(4), 20+20 * (0)+40*(2), 270, 40);
			panel_for_tc1_tc2_guzhang[0].setBounds(25+285*(4), 20+45 * (3)+50*(0), 250, 40);
			panel_for_tab[3].add(panel_for_tc1_tc2_guzhang[0]);
			
			panel_for_tc1_tc2_guzhang[1] = new JPanel();
			label_for_tc1_tc2_guzhang[1] = new JLabel("TC2司机室主机故障");
			ComboBox_for_tc1_tc2_guzhang[1] = new JComboBox<String>(str31);
			panel_for_tc1_tc2_guzhang[1].add(label_for_tc1_tc2_guzhang[1]);
			panel_for_tc1_tc2_guzhang[1].add(ComboBox_for_tc1_tc2_guzhang[1]);
			label_for_tc1_tc2_guzhang[1].setForeground(Color.BLUE);
			panel_for_tc1_tc2_guzhang[1].setBounds(25+285*(4), 20+45 * (4)+50*(0), 250, 40);
			panel_for_tab[3].add(panel_for_tc1_tc2_guzhang[1]);			
			
			
			
			/*********/
			//连挂解编
			panel_for_liangua_jiebian[0] = new JPanel();
			label_for_liangua_jiebian[0] = new JLabel("连挂标志");
			ComboBox_for_liangua_jiebian[0] = new JComboBox<String>(str30);
			panel_for_liangua_jiebian[0].add(label_for_liangua_jiebian[0]);
			panel_for_liangua_jiebian[0].add(ComboBox_for_liangua_jiebian[0]);
			label_for_liangua_jiebian[0].setForeground(Color.BLUE);	
			panel_for_liangua_jiebian[0].setBounds(25+285*(4), 550+50 * (0)+50*(0), 250, 40);
			panel_for_tab[3].add(panel_for_liangua_jiebian[0]);
			//panel_for_guzhang[i].setBounds(25+285*((i)%4), 550+50 * (i/4)+50*(0), 250, 40);
			//解编
			panel_for_liangua_jiebian[1] = new JPanel();
			label_for_liangua_jiebian[1] = new JLabel("解编标志");
			ComboBox_for_liangua_jiebian[1] = new JComboBox<String>(str29);
			panel_for_liangua_jiebian[1].add(label_for_liangua_jiebian[1]);
			panel_for_liangua_jiebian[1].add(ComboBox_for_liangua_jiebian[1]);
			label_for_liangua_jiebian[1].setForeground(Color.BLUE);
			panel_for_liangua_jiebian[1].setBounds(25+285*(4), 550+50 * (1)+50*(0), 250, 40);
			
			panel_for_jinji_num.add(label_for_jinji_num);
			panel_for_jinji_num.add(tf_for_jinji_num);
			
			tf_for_jinji_num.setText(String.valueOf(0));
			
			tf_for_jinji_num.setSize(100, 40);
			tf_for_jinji_num.setFont(new Font("宋体",Font.PLAIN,24));
			label_for_jinji_num.setForeground(Color.RED);
			panel_for_jinji_num.setBounds(25+285*(2), 550+50 * (1)+50*(2), 250, 40);
			
			panel_for_tab[3].add(panel_for_jinji_num);
			panel_for_tab[3].add(panel_for_liangua_jiebian[1]);
			
			//ComboBox_for_liangua_jiebian[0]-连挂标志-str30
			//ComboBox_for_liangua_jiebian[1]-解编标志-str29			
//			JPanel panel_for_jinji_num = new JPanel();
//			JTextField tf_for_jinji_num = new JTextField();
//			JLabel label_for_jinji_num = new JLabel("紧急广播序号");
			
			//occ广播状态
			panel_for_occ[0] = new JPanel();
			label_for_occ[0] = new JLabel(ooc_state);
			ComboBox_for_occ[0] = new JComboBox<String>(str37);
			panel_for_occ[0].add(label_for_occ[0]);
			panel_for_occ[0].add(ComboBox_for_occ[0]);
			label_for_occ[0].setForeground(Color.BLUE);
			panel_for_occ[0].setBounds(25+285*(4), 240+45 * (0)+50*(0), 250, 40);
			panel_for_tab[3].add(panel_for_occ[0]);
			
			
			//pis工作模式
			panel_for_pis_work[0] = new JPanel();
			label_for_pis_work[0] = new JLabel("PIS-工作模式:");
			ComboBox_for_pis_work[0] = new JComboBox<String>(str38);
			panel_for_pis_work[0].add(label_for_pis_work[0]);
			panel_for_pis_work[0].add(ComboBox_for_pis_work[0]);
			label_for_pis_work[0].setForeground(Color.BLUE);
			panel_for_pis_work[0].setBounds(25+285*(4), 240+45 * (0)+50*(1), 250, 40);
			panel_for_tab[3].add(panel_for_pis_work[0]);
			
			
			//与紧急报警器通话的序号
			panel_for_bjq_num[0] = new JPanel();
			label_for_bjq_num[0] = new JLabel("与紧急报警器通话的序号:");
			ComboBox_for_bjq_num[0] = new JComboBox<String>(str41);
			panel_for_bjq_num[0].add(label_for_bjq_num[0]);
			panel_for_bjq_num[0].add(ComboBox_for_bjq_num[0]);
			label_for_bjq_num[0].setForeground(Color.BLUE);
			panel_for_bjq_num[0].setBounds(25+285*(4), 340+45 * (0)+50*(0), 250, 40);
			panel_for_tab[3].add(panel_for_bjq_num[0]);
		
			//当前广播状态 
			panel_for_cur_state[0] = new JPanel();
			label_for_cur_state[0] = new JLabel("当前广播状态:");
			ComboBox_for_cur_state[0] = new JComboBox<String>(str39);
			panel_for_cur_state[0].add(label_for_cur_state[0]);
			panel_for_cur_state[0].add(ComboBox_for_cur_state[0]);
			label_for_cur_state[0].setForeground(Color.BLUE);
			panel_for_cur_state[0].setBounds(25+285*(4), 340+45 * (0)+50*(1), 250, 40);
			panel_for_tab[3].add(panel_for_cur_state[0]);
			
			//司机对讲-司乘对讲
			panel_for_commu[0] = new JPanel();
			label_for_commu[0] = new JLabel("司乘对讲");
			ComboBox_for_commu[0] = new JComboBox<String>(str40);
			panel_for_commu[0].add(label_for_commu[0]);
			panel_for_commu[0].add(ComboBox_for_commu[0]);
			label_for_commu[0].setForeground(Color.BLUE);
			panel_for_commu[0].setBounds(25+285*(4), 450+45 * (0)+50*(0), 250, 40);
			panel_for_tab[3].add(panel_for_commu[0]);
			
			panel_for_open_door[1] = new JPanel();
			label_for_commu[1] = new JLabel("司机对讲");
			ComboBox_for_commu[1] = new JComboBox<String>(str40);
			panel_for_open_door[1].add(label_for_commu[1]);
			panel_for_open_door[1].add(ComboBox_for_commu[1]);
			label_for_commu[1].setForeground(Color.BLUE);
			panel_for_open_door[1].setBounds(25+285*(4), 450+45 * (0)+50*(1), 250, 40);
			panel_for_tab[3].add(panel_for_open_door[1]);

		}
		
		{
			//车内发生了复位
			for(i=0;i<8;i++)
			{
				strtemp="";
				strtemp+=String.valueOf(i+1);
				strtemp+="-";
				strtemp+="车";
				strtemp+="PIS发生了复位";			
				strtemp+=":";				
				panel_for_fuwei[i] = new JPanel();
				label_for_fuwei[i] = new JLabel(strtemp);
				ComboBox_for_fuwei[i] = new JComboBox<String>(str36);
				panel_for_fuwei[i].add(label_for_fuwei[i]);
				panel_for_fuwei[i].add(ComboBox_for_fuwei[i]);
				if(i%2==0)
				{
					label_for_fuwei[i].setForeground(Color.black);//Color.BLUE
				}
				else
				{
					label_for_fuwei[i].setForeground(Color.black);//Color.red
				}
				panel_for_fuwei[i].setBounds(25+285*((i)%4), 340+50 * (i/4)+50*(0), 250, 40);
				panel_for_tab[3].add(panel_for_fuwei[i]);				
			}		
		}
		{
			//车内主机发生了故障
			for(i=0;i<8;i++)
			{
				strtemp="";
				strtemp+=String.valueOf(i+1);
				strtemp+="-";
				strtemp+="车";
				strtemp+="车内主机发生了故障";			
				strtemp+=":";				
				panel_for_zhuji_guzhang[i] = new JPanel();
				label_for_zhuji_guzhang[i] = new JLabel(strtemp);
				ComboBox_for_zhuji_guzhang[i] = new JComboBox<String>(str34);
				panel_for_zhuji_guzhang[i].add(label_for_zhuji_guzhang[i]);
				panel_for_zhuji_guzhang[i].add(ComboBox_for_zhuji_guzhang[i]);
				if(i%2==0)
				{
					label_for_zhuji_guzhang[i].setForeground(Color.BLUE);//Color.BLUE
				}
				else
				{
					label_for_zhuji_guzhang[i].setForeground(Color.BLUE);//Color.red
				}
				panel_for_zhuji_guzhang[i].setBounds(25+285*((i)%4), 450+50 * (i/4)+50*(0), 250, 40);
				panel_for_tab[3].add(panel_for_zhuji_guzhang[i]);				
			}			
		}
		{
			//车内发生了故障String str35[] = {"正常无故障","存在故障"};//内部故障
			for(i=0;i<8;i++)
			{
				strtemp="";
				strtemp+=String.valueOf(i+1);
				strtemp+="-";
				strtemp+="车";
				strtemp+="车内发生了故障";			
				strtemp+=":";				
				panel_for_guzhang[i] = new JPanel();
				label_for_guzhang[i] = new JLabel(strtemp);
				ComboBox_for_guzhang[i] = new JComboBox<String>(str35);
				panel_for_guzhang[i].add(label_for_guzhang[i]);
				panel_for_guzhang[i].add(ComboBox_for_guzhang[i]);
				if(i%2==0)
				{
					label_for_guzhang[i].setForeground(Color.black);//Color.BLUE
				}
				else
				{
					label_for_guzhang[i].setForeground(Color.black);//Color.red
				}
				panel_for_guzhang[i].setBounds(25+285*((i)%4), 550+50 * (i/4)+50*(0), 250, 40);
				panel_for_tab[3].add(panel_for_guzhang[i]);				
			}	
		}
		{		//更新发送到网络上的数据
			   timer_refresh_data.scheduleAtFixedRate(new TimerTask() {
		            public void run() 
		            {                
//		            	build_process_data_for_trdp();
		            	build_process_data_for_send_to_MVB();
		            	//dd_for_MVB_TO_PIS.fireTableDataChanged();
		            	//table_for_MVB_TO_PIS.fire
		            	//System.out.print(ComboBox_for_drv_fault[5].getSelectedIndex());
		            }
		        }, 300, 300);//3分钟切一次站点
			   
			   //更新刷给table的数据
			   timer_refresh_table_data_for_trdp.scheduleAtFixedRate(new TimerTask() {
		            public void run() 
		            {    
//		            	System.out.println("start");
//		            	for(int i=4;i<30;i++)
//		            	{
//		            		if(i%2==0)
//		            		{
//		            			System.out.println();
//		            		}
//		            		System.out.print("\t");
//		            		System.out.print(by_for_send[i]);
//		            	}
//		            	System.out.println();
//		            	System.out.println("end");
		            	
//		            	refresh_table_value_1_for_trdp();
//		            	refresh_table_value_2_for_trdp();
		            	
		            	
		            	refresh_table_value_for_pis_to_mvb_1();
		            	refresh_table_value_for_pis_to_mvb_2();
		            	
		            	//refresh_table_value_for_mvb_to_pis(udp.buf);
		            	
//		            	table_for_MVB_TO_PIS.validate();
//		            	table_for_MVB_TO_PIS.updateUI();
		            	//by_for_recv.
		            	//System.out.print(ComboBox_for_drv_fault[5].getSelectedIndex());
		            }
		        }, 100, 100*1);//3分钟切一次站点
			//table.setValueAt(999, 0, 0);
			   //refresh_table_value_1();
			   //refresh_table_value_2();
		}
		
	jTabbedpane.setBounds(0, 20,1600,1200);
	add(jTabbedpane);
	}
	public int get_SelectedItem(JComboBox ComboBoxtemp,String[] str_for_search)
	{
		for(int i=0;i<str_for_search.length;i++)
		{
			if((String)ComboBoxtemp.getSelectedItem()==str_for_search[i])
			{
				return i;
			}
		}
		return 0;

	}
	 
	public void refresh_table_value_1_for_trdp()
	{
		//1-16-17-18
		//2-14
		//setValueAt(Object aValue,int rowIndex,int columnIndex)
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[4]&0xff)), 2, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[5]&0xff)), 2, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[6]&0xff)), 3, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[7]&0xff)), 3, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[8]&0xff)), 4, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[9]&0xff)), 4, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[10]&0xff)), 5, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[11]&0xff)), 5, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[12]&0xff)), 6, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[13]&0xff)), 6, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[14]&0xff)), 7, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[15]&0xff)), 7, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[16]&0xff)), 8, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[17]&0xff)), 8, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[18]&0xff)), 9, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[19]&0xff)), 9, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[20]&0xff)), 10, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[21]&0xff)), 10, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[22]&0xff)), 11, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[23]&0xff)), 11, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[24]&0xff)), 12, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[25]&0xff)), 12, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[26]&0xff)), 13, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[27]&0xff)), 13, 18);
		
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[28]&0xff)), 14, 17);
		table_for_trdp.setValueAt(Integer.toHexString((int)(by_for_send[29]&0xff)), 14, 18);
	}
	
	public void refresh_table_value_2_for_trdp()
	{
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[0],str31), 2, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[1],str31), 2, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[2],str31), 2, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[3],str31), 2, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[4],str31), 2, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[5],str31), 2, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[6],str31), 2, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[7],str31), 2, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[8],str31), 2, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[9],str31), 2, 10);
		
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[10],str31), 3, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[11],str31), 3, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[12],str31), 3, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[13],str31), 3, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[14],str31), 3, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[15],str31), 3, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[16],str31), 3, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[17],str31), 3, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[18],str31), 3, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[19],str31), 3, 10);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[20],str31), 4, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[21],str31), 4, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[22],str31), 4, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[23],str31), 4, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[24],str31), 4, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[25],str31), 4, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[26],str31), 4, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[27],str31), 4, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[28],str31), 4, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[29],str31), 4, 10);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[30],str31), 5, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[31],str31), 5, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[32],str31), 5, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[33],str31), 5, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[34],str31), 5, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[35],str31), 5, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[36],str31), 5, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[37],str31), 5, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[38],str31), 5, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[39],str31), 5, 10);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[40],str31), 6, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[41],str31), 6, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[42],str31), 6, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[43],str31), 6, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[44],str31), 6, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[45],str31), 6, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[46],str31), 6, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[47],str31), 6, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[48],str31), 6, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[49],str31), 6, 10);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[50],str31), 7, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[51],str31), 7, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[52],str31), 7, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[53],str31), 7, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[54],str31), 7, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[55],str31), 7, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[56],str31), 7, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[57],str31), 7, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[58],str31), 7, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[59],str31), 7, 10);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[68],str31), 7, 11);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[69],str31), 7, 12);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[78],str31), 7, 13);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[79],str31), 7, 14);
		
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[0],str31), 8, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[1],str31), 8, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[2],str31), 8, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[3],str31), 8, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[4],str31), 8, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[5],str31), 8, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[6],str31), 8, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[7],str31), 8, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[8],str31), 8, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[9],str31), 8, 10);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[10],str31), 8, 11);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[11],str31), 8, 12);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[12],str31), 8, 13);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[13],str31), 8, 14);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[14],str31), 8, 15);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_wireless_fault[15],str31), 8, 16);
		
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[60],str31), 9, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[61],str31), 9, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[62],str31), 9, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[63],str31), 9, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[64],str31), 9, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[65],str31), 9, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[66],str31), 9, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[67],str31), 9, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[70],str31), 9, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[71],str31), 9, 10);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[72],str31), 9, 11);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[73],str31), 9, 12);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[74],str31), 9, 13);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[75],str31), 9, 14);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[76],str31), 9, 15);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_map[77],str31), 9, 16);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[0],str31), 10, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[3],str31), 10, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[1],str31), 10, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[2],str31), 10, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[4],str31), 10, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[5],str31), 10, 6);
//		table.setValueAt(by_for_send[4], 10, 7);
//		table.setValueAt(by_for_send[4], 10, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[0],str31), 10, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[1],str31), 10, 10);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[2],str31), 10, 11);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[3],str31), 10, 12);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[4],str31), 10, 13);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[5],str31), 10, 14);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[12],str31), 10, 15);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[13],str31), 10, 16);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[11],str31), 11, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[10],str31), 11, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[9],str31), 11, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[8],str31), 11, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[6],str31), 11, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[7],str31), 11, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[14],str31), 11, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[15],str31), 11, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[0],str31), 11, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[1],str31), 11, 10);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[2],str31), 11, 11);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[3],str31), 11, 12);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[4],str31), 11, 13);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[5],str31), 11, 14);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[6],str31), 11, 15);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[7],str31), 11, 16);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[8],str31), 12, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[9],str31), 12, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[10],str31), 12, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[11],str31), 12, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[12],str31), 12, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[13],str31), 12, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[14],str31), 12, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[15],str31), 12, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[16],str31), 12, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[17],str31), 12, 10);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[18],str31), 12, 11);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[19],str31), 12, 12);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[20],str31), 12, 13);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[21],str31), 12, 14);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[22],str31), 12, 15);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[23],str31), 12, 16);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[24],str31), 13, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[25],str31), 13, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[26],str31), 13, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[27],str31), 13, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[28],str31), 13, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[29],str31), 13, 6);
//		table.setValueAt(by_for_send[4], 13, 7);
//		table.setValueAt(by_for_send[4], 13, 8);
//		table.setValueAt(by_for_send[4], 13, 9);
//		table.setValueAt(by_for_send[4], 13, 10);
//		table.setValueAt(by_for_send[4], 13, 11);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[30],str31), 13, 12);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[31],str31), 13, 13);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[32],str31), 13, 14);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[33],str31), 13, 15);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[34],str31), 13, 16);
		
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[35],str31), 14, 1);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[36],str31), 14, 2);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[37],str31), 14, 3);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[38],str31), 14, 4);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[39],str31), 14, 5);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[0],str31), 14, 6);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[1],str31), 14, 7);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[2],str31), 14, 8);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[3],str31), 14, 9);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[4],str31), 14, 10);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[5],str31), 14, 11);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[6],str31), 14, 12);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[7],str31), 14, 13);
//		table.setValueAt(by_for_send[4], 14, 14);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_tc1_tc2_guzhang[0],str31), 14, 15);
		table_for_trdp.setValueAt(get_SelectedItem(ComboBox_for_tc1_tc2_guzhang[1],str31), 14, 16);
	}
	
	 public void refresh_table_value_for_pis_to_mvb_1()
	{
		//table_for_MVB_TO_PIS
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[0]&0xff)), 0, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[1]&0xff)), 0, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[2]&0xff)), 1, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[3]&0xff)), 1, 18);			
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[4]&0xff)), 2, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[5]&0xff)), 2, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[6]&0xff)), 3, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[7]&0xff)), 3, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[8]&0xff)), 4, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[9]&0xff)), 4, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[10]&0xff)), 5, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[11]&0xff)), 5, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[12]&0xff)), 6, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[13]&0xff)), 6, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[14]&0xff)), 7, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[15]&0xff)), 7, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[16]&0xff)), 8, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[17]&0xff)), 8, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[18]&0xff)), 9, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[19]&0xff)), 9, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[20]&0xff)), 10, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[21]&0xff)), 10, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[22]&0xff)), 11, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[23]&0xff)), 11, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[24]&0xff)), 12, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[25]&0xff)), 12, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[26]&0xff)), 13, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[27]&0xff)), 13, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[28]&0xff)), 14, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[29]&0xff)), 14, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[30]&0xff)), 15, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[31]&0xff)), 15, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[32]&0xff)), 16, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[33]&0xff)), 16, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[34]&0xff)), 17, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[35]&0xff)), 17, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[36]&0xff)), 18, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[37]&0xff)), 18, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[38]&0xff)), 19, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[39]&0xff)), 19, 18);
	
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[40]&0xff)), 20, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[41]&0xff)), 20, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[42]&0xff)), 21, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[43]&0xff)), 21, 18);		
		
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[44]&0xff)), 22, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[45]&0xff)), 22, 18);
		
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[46]&0xff)), 23, 17);
		table_for_PIS_TO_MVB.setValueAt(Integer.toHexString((int)(by_for_send_to_MVB[47]&0xff)), 23, 18);
	}
	
	 public void refresh_table_value_for_pis_to_mvb_2()
	{
		//第一行生命信号不处理
		//table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[0],str1), 2, 16);
		//1-->bit15--[8-->bit7]--16-->bit0
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[0],str1), 2-1, 9);//bit0-1-1报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[1],str1), 2-1, 10);//bit1
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[2],str1), 2-1, 11);//bit2
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[3],str1), 2-1, 12);//bit3
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[4],str1), 2-1, 13);//bit4		
		//table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_map[5],str31), 2, 14);//bit5
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_open_door[0],str33), 2-1, 15);//bit6
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_open_door[1],str33), 2-1, 16);//bit7
		
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[5],str1), 2-1, 8);//bit8-2-1报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[6],str1), 2-1, 7);//bit9
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[7],str1), 2-1, 6);//bit10
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[8],str1), 2-1, 5);//bit11
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[9],str1), 2-1, 4);//bit12
		
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_occ[0],str37), 2-1, 3);//bit13
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[6],str35), 2-1, 2);//bit14
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[7],str35), 2-1, 1);//bit15
		
		//----
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[10],str1), 3-1, 9);//bit0-3-1报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[11],str1), 3-1, 10);//bit1
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[12],str1), 3-1, 11);//bit2
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[13],str1), 3-1, 12);//bit3
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[14],str1), 3-1, 13);//bit4
		
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[30],str1), 3-1, 14);//bit5
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[31],str1), 3-1, 15);//bit6
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[32],str1), 3-1, 16);//bit7
		
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[15],str1), 3-1, 8);//bit8-4-1报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[16],str1), 3-1, 7);//bit9
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[17],str1), 3-1, 6);//bit10
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[18],str1), 3-1, 5);//bit11
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[19],str1), 3-1, 4);//bit12
		
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[33],str1), 3-1, 3);//bit13-7-4报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[34],str1), 3-1, 2);//bit14
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[6],str35), 3-1, 1);//bit15
		
		//----
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[20],str1), 4-1, 9);//bit0-5-1报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[21],str1), 4-1, 10);//bit1
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[22],str1), 4-1, 11);//bit2
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[23],str1), 4-1, 12);//bit3
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[24],str1), 4-1, 13);//bit4
				
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[35],str1), 4-1, 14);//bit5-8-1报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[36],str1), 4-1, 15);//bit6
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[37],str1), 4-1, 16);//bit7
				
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[25],str1), 4-1, 8);//bit8-6-1报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[26],str1), 4-1, 7);//bit9
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[27],str1), 4-1, 6);//bit10
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[28],str1), 4-1, 5);//bit11
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[29],str1), 4-1, 4);//bit12
				
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[35],str37), 4-1, 3);//bit13-8-4报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq[36],str35), 4-1, 2);//bit14
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[7],str35), 4-1, 1);//bit15	
		//第五行软件版本不处理
		//第六行--PIS的工作模式--当前广播状态不处理
		//第七行
		//----
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[0],str34), 7-1, 9);//bit0-1车PIS车客室主机故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[1],str34), 7-1, 10);//bit1
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[2],str34), 7-1, 11);//bit2
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[3],str34), 7-1, 12);//bit3
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[4],str34), 7-1, 13);//bit4
						
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_zhuji_guzhang[5],str34), 7-1, 14);//bit5-8-1报警器
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_tc1_tc2_guzhang[0],str31), 7-1, 15);//bit6-Tc1车司机室主机故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_tc1_tc2_guzhang[1],str31), 7-1, 16);//bit7
						
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[0],str35), 7-1, 8);//bit8-1车PIS内部存在故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[1],str35), 7-1, 7);//bit9
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[2],str35), 7-1, 6);//bit10
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[3],str35), 7-1, 5);//bit11
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[4],str35), 7-1, 4);//bit12
						
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_guzhang[5],str35), 7-1, 3);//bit13-6车PIS内部存在故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_commu[1],str40), 7-1, 2);//bit14-司机间通话
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_commu[0],str40), 7-1, 1);//bit15-司机与乘客通话	
		
		//
		//----
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_fuwei[0],str36), 8-1, 9);//bit0-1车PIS内发生了复位
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_fuwei[1],str36), 8-1, 10);//bit1
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_fuwei[2],str36), 8-1, 11);//bit2
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_fuwei[3],str36), 8-1, 12);//bit3
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_fuwei[4],str36), 8-1, 13);//bit4
								
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_fuwei[5],str36), 8-1, 14);//bit5-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_fuwei[6],str36), 8-1, 15);//bit6-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_fuwei[7],str36), 8-1, 16);//bit7-8车PIS内发生了复位		
		
		
		//----
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[0],str31), 9-1, 9);//bit0-乘客紧急报警单元1故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[1],str31), 9-1, 10);//bit1
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[2],str31), 9-1, 11);//bit2
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[3],str31), 9-1, 12);//bit3
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[4],str31), 9-1, 13);//bit4
								
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[5],str31), 9-1, 14);//bit5-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[6],str31), 9-1, 15);//bit6-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[7],str31), 9-1, 16);//bit7-乘客紧急报警单元8故障
								
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[8],str31), 9-1, 8);//bit8-乘客紧急报警单元9故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[9],str31), 9-1, 7);//bit9
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[10],str31), 9-1, 6);//bit10
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[11],str31), 9-1, 5);//bit11
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[12],str31), 9-1, 4);//bit12
								
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[13],str31), 9-1, 3);//bit13-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[14],str31), 9-1, 2);//bit14-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[15],str31), 9-1, 1);//bit15-乘客紧急报警单元16故障			
		
		//----
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[16],str31), 10-1, 9);//bit0-乘客紧急报警单元17故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[17],str31), 10-1, 10);//bit1
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[18],str31), 10-1, 11);//bit2
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[19],str31), 10-1, 12);//bit3
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[20],str31), 10-1, 13);//bit4
										
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[21],str31), 10-1, 14);//bit5-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[22],str31), 10-1, 15);//bit6-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[23],str31), 10-1, 16);//bit7-乘客紧急报警单元24故障
										
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[24],str31), 10-1, 8);//bit8-乘客紧急报警单元25故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[25],str31), 10-1, 7);//bit9
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[26],str31), 10-1, 6);//bit10
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[27],str31), 10-1, 5);//bit11
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[28],str31), 10-1, 4);//bit12-乘客紧急报警单元29故障
										
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[29],str31), 10-1, 3);//bit13--乘客紧急报警单元30故障
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[30],str31), 10, 2);//bit14-
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[31],str31), 10, 1);//bit15-乘客紧急报警单元16故障		
		
		//----
		//table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[15],str31), 11-1, 9);//
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_liangua_jiebian[0],str30), 11-1, 10);//bit0-连挂标志
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_liangua_jiebian[1],str29), 11-1, 11);//bit1-解编模式
		
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[30],str31), 11-1, 12);//bit2-乘客紧急报警单元31故障	
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[31],str31), 11-1, 13);//bit3
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[32],str31), 11-1, 14);//bit4
										
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[33],str31), 11-1, 15);//bit5-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[34],str31), 11-1, 16);//bit6-乘客紧急报警单元35故障
		
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[35],str31), 11-1, 8);//bit7-乘客紧急报警单元36故障										
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[36],str31), 11-1, 7);//bit8-
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[37],str31), 11-1, 6);//bit9
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[38],str31), 11-1, 5);//bit10
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[39],str31), 11-1, 4);//bit11-乘客紧急报警单元40故障
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[12],str31), 11, 3);//bit12
//										
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[13],str31), 11, 2);//bit13-
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[14],str31), 11, 1);//bit14-
		
		//第十二行当前站编码
		//第十三行下一站编码
		//第十四行目的站编码
		
		//----
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[0],str31), 15-1, 9);//bit0-Tc1车司机室广播控制面板故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[3],str31), 15-1, 10);//bit1-Tc2车司机室广播控制面板故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[1],str31), 15-1, 11);//bit2-Tc1车中央控制模块故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[2],str31), 15-1, 12);//bit3-Tc1车录音模块故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[4],str31), 15-1, 13);//bit4-Tc2车中央控制模块故障
										
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_drv_fault[5],str31), 15-1, 14);//bit5-Tc2车录音模块故障
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[6],str31), 15, 15);//bit6-
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[7],str31), 15, 16);//bit7-乘客紧急报警单元8故障
										
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[0],str31), 15-1, 8);//bit8-1车功率放大模块1故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[1],str31), 15-1, 7);//bit9
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[2],str31), 15-1, 6);//bit10
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[3],str31), 15-1, 5);//bit11
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[4],str31), 15-1, 4);//bit12
										
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[5],str31), 15-1, 3);//bit13-3车功率放大模块2故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[12],str31), 15-1, 2);//bit14-7车功率放大模块1故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[13],str31), 15-1, 1);//bit15-7车功率放大模块2故障			
						
		//----
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[10],str31), 16-1, 9);//bit0-6车功率放大模块1故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[11],str31), 16-1, 10);//bit1-6车功率放大模块2故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[8],str31), 16-1, 11);//bit2-5车功率放大模块1故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[9],str31), 16-1, 12);//bit3-5车功率放大模块2故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[6],str31), 16-1, 13);//bit4-4车功率放大模块1故障
												
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[7],str31), 16-1, 14);//bit5-4车功率放大模块2故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[14],str31), 16-1, 15);//bit6-8车功率放大模块1故障
		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_gf_fault[15],str31), 16-1, 16);//bit7-8车功率放大模块2故障
												
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[8],str31), 15, 8);//bit8-乘客紧急报警单元9故障
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[9],str31), 15, 7);//bit9
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[10],str31), 15, 6);//bit10
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[11],str31), 15, 5);//bit11
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[12],str31), 15, 4);//bit12
//												
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[13],str31), 15, 3);//bit13-
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[14],str31), 15, 2);//bit14-
//		table_for_PIS_TO_MVB.setValueAt(get_SelectedItem(ComboBox_for_bjq_fault[15],str31), 15, 1);//bit15-乘客紧急报警单元16故障		
		
		
		
	}
	
	static public void set_table_bit_value_for_mvb_to_pis(byte byte_L,byte byte_H,int index_for_table)
	{
		//int hex[]={0x80,0x40,0x20,0x10,0x08,0x04,0x02,0x01};
		for(int i=0;i<8;i++)
		{
			if((hex[i]&byte_H)>0)
			{
				//System.out.print(1);
				//table_for_MVB_TO_PIS.setValueAt(1, index_for_table, 16-i);
				table_for_MVB_TO_PIS.setValueAt(1, index_for_table, 9+i);
				
				//System.out.print("\t");
			}
			else
			{
				//System.out.print(0);
				//table_for_MVB_TO_PIS.setValueAt(0, index_for_table, 16-i);
				table_for_MVB_TO_PIS.setValueAt(0, index_for_table, 9+i);
				
				//System.out.print("\t");
			}
			/******/
			if((hex[i]&byte_L)>0)
			{
//				System.out.print(1);
//				System.out.print("\t");
				//table_for_MVB_TO_PIS.setValueAt(0, index_for_table, 8-i);
				table_for_MVB_TO_PIS.setValueAt(1, index_for_table, i+1);
				//table_for_MVB_TO_PIS.setForeground(Color.RED);
			}
			else
			{
//				System.out.print(0);
//				System.out.print("\t");
				//table_for_MVB_TO_PIS.setValueAt(0, index_for_table, 8-i);
				table_for_MVB_TO_PIS.setValueAt(0, index_for_table, i+1);
				//table_for_MVB_TO_PIS.setForeground(Color.RED);
			}
			
		}
	}
	static public void refresh_table_value_for_mvb_to_pis(byte[] buf_for_param)
	{
		 iij+=1;
		if(buf_for_param.length<40)
		{
			return;
		}
		else
		{
			//System.out.println("process");
			//table_for_MVB_TO_PIS			
//			table_for_MVB_TO_PIS.setValueAt(Integer.toHexString((int)(buf_for_param[0]&0xff)), 0, 18);
//			table_for_MVB_TO_PIS.setValueAt(Integer.toHexString((int)(buf_for_param[1]&0xff)), 0, 17);
			for(int i=0;i<20;i++)
			{
//				System.out.println();
//				System.out.print(i);
				for(int j=0;j<2;j++)
				{
					
					if(j==0)
					{
						table_for_MVB_TO_PIS.setValueAt(Integer.toHexString((int)(buf_for_param[i*2+j+1]&0xff)), (i), 17);
						//table_for_MVB_TO_PIS.setValueAt(Integer.toHexString((int)(buf_for_param[i*2+j+1]&0xff)), (i), 18);
//						System.out.print("--");
//						System.out.print(buf_for_param[i*2+j]);
					}
					else if(j==1)
					{
						table_for_MVB_TO_PIS.setValueAt(Integer.toHexString((int)(buf_for_param[i*2+j+1]&0xff)), (i), 18);
						//table_for_MVB_TO_PIS.setValueAt(Integer.toHexString((int)(buf_for_param[i*2+j+1]&0xff)), (i), 17);	
//						System.out.print("--");
//						System.out.print(buf_for_param[i*2+j]);
					}
//					if((i*2+j+1)%4==0)
//					{
//						System.out.println();
//					}
//					System.out.print(i*2+j+1);					
//					System.out.print("\t");
				}
				if(i>=3)
				{
					set_table_bit_value_for_mvb_to_pis(buf_for_param[i*2+1],buf_for_param[i*2+2],i);
					//set_table_bit_value_for_mvb_to_pis(buf_for_param[i*2+2],buf_for_param[i*2+1],i);
				}
				//set_table_bit_value_for_mvb_to_pis(buf_for_param[i*2+1],buf_for_param[i*2+2],i);
				
//				System.out.print(i*2+1);
//				System.out.print("-");
//				System.out.print(i*2+2);
//				System.out.print("--");
//				System.out.print(i);
//				System.out.println();
			}//end...for(int i=0;i<20;i++)
			//System.out.println("endl");
			//第一行年月不处理
			//第二行日时不处理
			//第三行分秒不处理
			//第四行生命信号--时间有效-时间校准-延时断电--buf_for_param[8]
//			table_for_MVB_TO_PIS.setValueAt(Integer.toHexString((int)(sec)), 0, 17);
			//----
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[7]&0x80), 4-1, 16);//bit0-//时间有效
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[7]&0x40), 4-1, 15);//bit1--//时间校准
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[7]&0x20), 4-1, 14);//bit2--//延时断电
			//第五行VCU生命信号不处理
			//第6行当前站编码不处理
			//第7行下一站编码不处理
			//第8行目的站编码不处理
			//第9行列车速度不处理
			//第10行起始站编码不处理
			//第11行--对乘客的紧急广播信息编号--列车门关闭并锁到位（作为硬线备份）--ATO模式--检查扬声器的音量（循环广播测试）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+13]&0x80), 11-1, 16);//bit0-//列车门关闭并锁到位（作为硬线备份）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+13]&0x40), 11-1, 15);//bit1--//列车门开到位
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+13]&0x20), 11-1, 14);//bit2--//ATO模式		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+13]&0x10), 11-1, 13);//bit3-通知PIS测试内部的动态地图
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+13]&0x08), 11-1, 12);//bit4-检查扬声器的音量（循环广播测试）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+13]&0x04), 11-1, 11);//bit5-起始站有效位
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+13]&0x02), 11-1, 10);//bit6-关门催促音
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_bjq[32],str1), 3, 9);//bit7-
			
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_bjq[15],str1), 3, 8);//bit8-4-1报警器
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_bjq[16],str1), 3, 7);//bit9-
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_bjq[17],str1), 3, 6);//bit10-
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_bjq[18],str1), 3, 5);//bit11-
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_bjq[19],str1), 3, 4);//bit12-
//			
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_bjq[33],str1), 3, 3);//bit13-7-4报警器
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_bjq[34],str1), 3, 2);//bit14-
//			table_for_MVB_TO_PIS.setValueAt(get_SelectedItem(ComboBox_for_guzhang[6],str35), 3, 1);//bit15-
		
			//第12行[]--15--[]--14--
			//第12行--14--到达信号（自动报站模式下有效）--离开信号（自动报站模式下有效）--当前站编码信息有效标志
			//--下一站编码信息有效标志--终点站（目的）编码信息有效标志--HMI进行的PIS主从切换功能change master
			//--连挂标志（救援模式）--解编标志（6车拆成3+3车）
			//--15--PIS主机复位--关左门按钮按下--关右门按钮按下
			//--TC1司机室激活--TC2司机室激活--手动--自动--手动设置站点信息确认
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x80), 12-1, 16);//bit0-//到达信号（自动报站模式下有效）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x40), 12-1, 15);//bit1--//离开信号（自动报站模式下有效）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x20), 12-1, 14);//bit2--//当前站编码信息有效标志		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x10), 12-1, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x08), 12-1, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x04), 12-1, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x02), 12-1, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x01), 12-1, 9);//bit7-解编标志（6车拆成3+3车）
//			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+15]&0x80), 12-1, 8);//bit0-//PIS主机复位
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+15]&0x40), 12-1, 7);//bit1--关左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+15]&0x20), 12-1, 6);//bit2--关右门按钮按下		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+15]&0x10), 12-1, 5);//bit3-TC1司机室激活
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+15]&0x08), 12-1, 4);//bit4-TC2司机室激活
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+15]&0x04), 12-1, 3);//bit5-手动
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+15]&0x02), 12-1, 2);//bit6-自动
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+15]&0x01), 12-1, 1);//bit7-手动设置站点信息确认			
//			
			//第13行[]--17--[]--16--
			//第13行--16--开左门按钮按下--开右门按钮按下--试灯按钮
			//--下一站编码信息有效标志--终点站（目的）编码信息有效标志--HMI进行的PIS主从切换功能change master
			//--连挂标志（救援模式）--解编标志（6车拆成3+3车）
			//--17--1车车重超过AW3--2车车重超过AW3--3车车重超过AW3
			//--4车车重超过AW3--5车车重超过AW3--6车车重超过AW3-7车车重超过AW3--8车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+16]&0x80), 13-1, 16);//bit0-开左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+16]&0x40), 13-1, 15);//bit1--开右门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+16]&0x20), 13-1, 14);//bit2--试灯按钮		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x10), 13, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x08), 13, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x04), 13, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x02), 13, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+14]&0x01), 13, 9);//bit7-解编标志（6车拆成3+3车）
			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+17]&0x80), 13-1, 8);//bit0-1车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+17]&0x40), 13-1, 7);//bit1--2车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+17]&0x20), 13-1, 6);//bit2--3车车重超过AW3		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+17]&0x10), 13-1, 5);//bit3-4车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+17]&0x08), 13-1, 4);//bit4-5车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+17]&0x04), 13-1, 3);//bit5-6车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+17]&0x02), 13-1, 2);//bit6-7车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+17]&0x01), 13-1, 1);//bit7-8车车重超过AW3	
			
			//第14行[]--19--[]--18--
			//第14行--18--重大故障提示1--重大故障提示2--重大故障提示3
			//--重大故障提示4--重大故障提示5--重大故障提示6
			//--重大故障提示7--重大故障提示8
			//--19--重大故障提示9--重大故障提示10--重大故障提示11
			//--重大故障提示12--重大故障提示13--重大故障提示14-重大故障提示15--重大故障提示16
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+18]&0x80), 14-1, 16);//bit0-开左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+18]&0x40), 14-1, 15);//bit1--开右门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+18]&0x20), 14-1, 14);//bit2--试灯按钮		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+18]&0x10), 14-1, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+18]&0x08), 14-1, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+18]&0x04), 14-1, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+18]&0x02), 14-1, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+18]&0x01), 14-1, 9);//bit7-解编标志（6车拆成3+3车）
//			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+19]&0x80), 14-1, 8);//bit0-1车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+19]&0x40), 14-1, 7);//bit1--2车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+19]&0x20), 14-1, 6);//bit2--3车车重超过AW3		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+19]&0x10), 14-1, 5);//bit3-4车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+19]&0x08), 14-1, 4);//bit4-5车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+19]&0x04), 14-1, 3);//bit5-6车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+19]&0x02), 14-1, 2);//bit6-7车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+19]&0x01), 14-1, 1);//bit7-8车车重超过AW3	
			
			//第15行[]--21--[]--20--
			//第15行--20--重大故障提示1--重大故障提示2--重大故障提示3--+16
			//--重大故障提示4--重大故障提示5--重大故障提示6--+16
			//--重大故障提示7--重大故障提示8--+16
			//--21--7车1门切除--7车2门切除--7车3门切除
			//--7车4门切除--7车5门切除--7车6门切除-7车7门切除--7车8门切除
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+20]&0x80), 15-1, 16);//bit0-开左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+20]&0x40), 15-1, 15);//bit1--开右门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+20]&0x20), 15-1, 14);//bit2--试灯按钮		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+20]&0x10), 15-1, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+20]&0x08), 15-1, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+20]&0x04), 15-1, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+20]&0x02), 15-1, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+20]&0x01), 15-1, 9);//bit7-解编标志（6车拆成3+3车）
//			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x80), 15-1, 8);//bit0-1车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x40), 15-1, 7);//bit1--2车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x20), 15-1, 6);//bit2--3车车重超过AW3		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x10), 15-1, 5);//bit3-4车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x08), 15-1, 4);//bit4-5车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x04), 15-1, 3);//bit5-6车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x02), 15-1, 2);//bit6-7车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x01), 15-1, 1);//bit7-8车车重超过AW3				

			
			//第16行[]--23--[]--22--
			//第16行--22--7车9门切除--7车10门切除--8车1门切除--+16
			//--8车2门切除--8车3门切除--8车4门切除--+16
			//--8车5门切除--8车6门切除--+16
			//--23--8车7门切除--8车8门切除--8车9门切除
			//--8车10门切除--7车5门切除--7车6门切除-7车7门切除--7车8门切除
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+22]&0x80), 16-1, 16);//bit0-开左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+22]&0x40), 16-1, 15);//bit1--开右门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+22]&0x20), 16-1, 14);//bit2--试灯按钮		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+22]&0x10), 16-1, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+22]&0x08), 16-1, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+22]&0x04), 16-1, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+22]&0x02), 16-1, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+22]&0x01), 16-1, 9);//bit7-解编标志（6车拆成3+3车）
//			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+23]&0x80), 16-1, 8);//bit0-1车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+23]&0x40), 16-1, 7);//bit1--2车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+23]&0x20), 16-1, 6);//bit2--3车车重超过AW3		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+23]&0x10), 16-1, 5);//bit3-4车车重超过AW3
////			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x08), 15, 4);//bit4-5车车重超过AW3
////			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x04), 15, 3);//bit5-6车车重超过AW3
////			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x02), 15, 2);//bit6-7车车重超过AW3
////			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+21]&0x01), 15, 1);//bit7-8车车重超过AW3	
			

			//第17行[]--25--[]--24--
			//第17行--24--1车1门切除--1车2门切除--1车3门切除--+16
			//--1车4门切除--1车5门切除--1车6门切除--+16
			//--1车7门切除--1车8门切除--+16
			//--25--1车9门切除--1车10门切除--2车1门切除
			//--2车2门切除--2车3门切除--2车4门切除-2车5门切除--2车6门切除
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+24]&0x80), 17-1, 16);//bit0-开左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+24]&0x40), 17-1, 15);//bit1--开右门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+24]&0x20), 17-1, 14);//bit2--试灯按钮		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+24]&0x10), 17-1, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+24]&0x08), 17-1, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+24]&0x04), 17-1, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+24]&0x02), 17-1, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+24]&0x01), 17-1, 9);//bit7-解编标志（6车拆成3+3车）
//			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+25]&0x80), 17-1, 8);//bit0-1车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+25]&0x40), 17-1, 7);//bit1--2车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+25]&0x20), 17-1, 6);//bit2--3车车重超过AW3		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+25]&0x10), 17-1, 5);//bit3-4车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+25]&0x08), 17-1, 4);//bit4-5车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+25]&0x04), 17-1, 3);//bit5-6车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+25]&0x02), 17-1, 2);//bit6-7车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+25]&0x01), 17-1, 1);//bit7-8车车重超过AW3				

			//第18行[]--27--[]--26--
			//第18行--26--2车7门切除--2车8门切除--2车9门切除--+16
			//--2车10门切除--3车1门切除--3车2门切除--+16
			//--3车3门切除--3车4门切除--+16
			//--27--3车5门切除--3车6门切除--3车7门切除
			//--3车8门切除--3车9门切除--3车10门切除-4车1门切除--4车2门切除
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+26]&0x80), 18-1, 16);//bit0-开左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+26]&0x40), 18-1, 15);//bit1--开右门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+26]&0x20), 18-1, 14);//bit2--试灯按钮		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+26]&0x10), 18-1, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+26]&0x08), 18-1, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+26]&0x04), 18-1, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+26]&0x02), 18-1, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+26]&0x01), 18-1, 9);//bit7-解编标志（6车拆成3+3车）
//			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+27]&0x80), 18-1, 8);//bit0-1车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+27]&0x40), 18-1, 7);//bit1--2车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+27]&0x20), 18-1, 6);//bit2--3车车重超过AW3		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+27]&0x10), 18-1, 5);//bit3-4车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+27]&0x08), 18-1, 4);//bit4-5车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+27]&0x04), 18-1, 3);//bit5-6车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+27]&0x02), 18-1, 2);//bit6-7车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+27]&0x01), 18-1, 1);//bit7-8车车重超过AW3				

			//第19行[]--29--[]--28--
			//第19行--28--4车3门切除--4车4门切除--4车5门切除--+16
			//--4车6门切除--4车7门切除--4车8门切除--+16
			//--4车9门切除--4车10门切除--+16
			//--29--5车1门切除--5车2门切除--5车3门切除
			//--5车4门切除--5车5门切除--5车6门切除-5车7门切除--5车8门切除
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+28]&0x80), 19-1, 16);//bit0-开左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+28]&0x40), 19-1, 15);//bit1--开右门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+28]&0x20), 19-1, 14);//bit2--试灯按钮		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+28]&0x10), 19-1, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+28]&0x08), 19-1, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+28]&0x04), 19-1, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+28]&0x02), 19-1, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+28]&0x01), 19-1, 9);//bit7-解编标志（6车拆成3+3车）
//			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+29]&0x80), 19-1, 8);//bit0-1车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+29]&0x40), 19-1, 7);//bit1--2车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+29]&0x20), 19-1, 6);//bit2--3车车重超过AW3		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+29]&0x10), 19-1, 5);//bit3-4车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+29]&0x08), 19-1, 4);//bit4-5车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+29]&0x04), 19-1, 3);//bit5-6车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+29]&0x02), 19-1, 2);//bit6-7车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+29]&0x01), 19-1, 1);//bit7-8车车重超过AW3			

			//第20行[]--31--[]--30--
			//第20行--30--5车9门切除--5车10门切除--6车1门切除--+16
			//--6车2门切除--6车3门切除--6车4门切除--+16
			//--6车5门切除--6车6门切除--+16
			//--31--6车7门切除--6车8门切除--6车9门切除
			//--6车10门切除--5车5门切除--5车6门切除-5车7门切除--5车8门切除
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+30]&0x80), 20-1, 16);//bit0-开左门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+30]&0x40), 20-1, 15);//bit1--开右门按钮按下
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+30]&0x20), 20-1, 14);//bit2--试灯按钮		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+30]&0x10), 20-1, 13);//bit3-下一站编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+30]&0x08), 20-1, 12);//bit4-终点站（目的）编码信息有效标志
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+30]&0x04), 20-1, 11);//bit5-HMI进行的PIS主从切换功能change master
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+30]&0x02), 20-1, 10);//bit6-连挂标志（救援模式）
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+30]&0x01), 20-1, 9);//bit7-解编标志（6车拆成3+3车）
//			
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+31]&0x80), 20-1, 8);//bit0-1车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+31]&0x40), 20-1, 7);//bit1--2车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+31]&0x20), 20-1, 6);//bit2--3车车重超过AW3		
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+31]&0x10), 20-1, 5);//bit3-4车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+31]&0x08), 20, 4);//bit4-5车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+31]&0x04), 20, 3);//bit5-6车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+31]&0x02), 20, 2);//bit6-7车车重超过AW3
//			table_for_MVB_TO_PIS.setValueAt((buf_for_param[8+31]&0x01), 20, 1);//bit7-8车车重超过AW3		
			
			
//			for(int ij=0;ij<20;ij++)
//			{
//				for(int ji=1;ji<column_name_for_all.length;ji++)
//				{
//					table_for_MVB_TO_PIS.setValueAt((iij), ij, ji);//bit3-4车车重超过AW3
//				}
//			}
			
			
		}
	}
	//ComboBox_for_map
	//ComboBox_for_wireless_fault
	//ComboBox_for_drv_faultString str32[] = {"广播控制盒", "中控","录音"};
	
	static public void set_jinji_num(int a)
	{
		tf_for_jinji_num.setText(String.valueOf(a));
	}
	
	
	public void build_process_data_for_send_to_MVB()
	{
		life+=1;
		if(life>=65535)
		{
			life=0;
		}
		//ComboBox_for_bjq str1
		by_for_send_to_MVB[1]=(byte)((life>>8)&0xff);
		//System.out.println(life);
		by_for_send_to_MVB[0]=(byte)(life&0xff);
		by_for_send_to_MVB[3]=(byte)((
				(get_SelectedItem(ComboBox_for_open_door[1],str33)*1)
				+(get_SelectedItem(ComboBox_for_open_door[0],str33)*2)
				//+(get_SelectedItem(ComboBox_for_bjq[2],str1)*4)
				+(get_SelectedItem(ComboBox_for_bjq[4],str1)*8)
				+(get_SelectedItem(ComboBox_for_bjq[3],str1)*16)
				+(get_SelectedItem(ComboBox_for_bjq[2],str1)*32)
				+(get_SelectedItem(ComboBox_for_bjq[1],str1)*64)
				+(get_SelectedItem(ComboBox_for_bjq[0],str1)*128)
						)&0xff);
		
		by_for_send_to_MVB[2]=(byte)((
				(get_SelectedItem(ComboBox_for_zhuji_guzhang[7],str34)*1)//8车PIS车客室主机故障
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[6],str34)*2)//7车PIS车客室主机故障
				+(get_SelectedItem(ComboBox_for_occ[0],str37)*4)//occ广播状态
				+(get_SelectedItem(ComboBox_for_bjq[9],str1)*8)
				+(get_SelectedItem(ComboBox_for_bjq[8],str1)*16)
				+(get_SelectedItem(ComboBox_for_bjq[7],str1)*32)
				+(get_SelectedItem(ComboBox_for_bjq[6],str1)*64)
				+(get_SelectedItem(ComboBox_for_bjq[5],str1)*128)
						)&0xff);
		
		by_for_send_to_MVB[5]=(byte)((
				(get_SelectedItem(ComboBox_for_bjq[32],str1)*1)//7-3
				+(get_SelectedItem(ComboBox_for_bjq[31],str1)*2)
				+(get_SelectedItem(ComboBox_for_bjq[30],str1)*4)//7-1
				
				+(get_SelectedItem(ComboBox_for_bjq[14],str1)*8)//3-5
				+(get_SelectedItem(ComboBox_for_bjq[13],str1)*16)
				+(get_SelectedItem(ComboBox_for_bjq[12],str1)*32)
				+(get_SelectedItem(ComboBox_for_bjq[11],str1)*64)
				+(get_SelectedItem(ComboBox_for_bjq[10],str1)*128)//3-1
						)&0xff);
		
		by_for_send_to_MVB[4]=(byte)((
				(get_SelectedItem(ComboBox_for_guzhang[6],str35)*1)//7车内部存在故障
				+(get_SelectedItem(ComboBox_for_bjq[34],str1)*2)//7-5
				+(get_SelectedItem(ComboBox_for_bjq[33],str1)*4)//7-4
				
				+(get_SelectedItem(ComboBox_for_bjq[19],str1)*8)//4-5
				+(get_SelectedItem(ComboBox_for_bjq[18],str1)*16)
				+(get_SelectedItem(ComboBox_for_bjq[17],str1)*32)
				+(get_SelectedItem(ComboBox_for_bjq[16],str1)*64)
				+(get_SelectedItem(ComboBox_for_bjq[15],str1)*128)//4-1
						)&0xff);
		
		by_for_send_to_MVB[7]=(byte)((
				(get_SelectedItem(ComboBox_for_bjq[37],str35)*1)//8-3
				+(get_SelectedItem(ComboBox_for_bjq[36],str1)*2)//8-2
				+(get_SelectedItem(ComboBox_for_bjq[35],str1)*4)//8-1
				
				+(get_SelectedItem(ComboBox_for_bjq[24],str1)*8)//5-5
				+(get_SelectedItem(ComboBox_for_bjq[23],str1)*16)
				+(get_SelectedItem(ComboBox_for_bjq[22],str1)*32)
				+(get_SelectedItem(ComboBox_for_bjq[21],str1)*64)
				+(get_SelectedItem(ComboBox_for_bjq[20],str1)*128)//5-1
						)&0xff);
		
		by_for_send_to_MVB[6]=(byte)((
				(get_SelectedItem(ComboBox_for_guzhang[7],str35)*1)//8车内部存在故障
				+(get_SelectedItem(ComboBox_for_bjq[39],str1)*2)//8-5
				+(get_SelectedItem(ComboBox_for_bjq[38],str1)*4)//8-4
				
				+(get_SelectedItem(ComboBox_for_bjq[29],str1)*8)//6-5
				+(get_SelectedItem(ComboBox_for_bjq[28],str1)*16)
				+(get_SelectedItem(ComboBox_for_bjq[27],str1)*32)
				+(get_SelectedItem(ComboBox_for_bjq[26],str1)*64)
				+(get_SelectedItem(ComboBox_for_bjq[25],str1)*128)//6-1
						)&0xff);
		by_for_send_to_MVB[9]=(byte)(0x10);//PIS软件版本号X--X．Y（X）
		by_for_send_to_MVB[8]=(byte)(0x01);//PIS软件版本号Y--X．Y（y）
		//工作模式
		by_for_send_to_MVB[11]=(byte)(get_SelectedItem(ComboBox_for_pis_work[0],str38));
		//当前广播状态
		by_for_send_to_MVB[10]=(byte)(get_SelectedItem(ComboBox_for_cur_state[0],str39));
		
		by_for_send_to_MVB[13]=(byte)((
				(get_SelectedItem(ComboBox_for_tc1_tc2_guzhang[1],str31)*1)//
				+(get_SelectedItem(ComboBox_for_tc1_tc2_guzhang[0],str31)*2)//
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[5],str34)*4)//
				
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[4],str34)*8)//
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[3],str34)*16)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[2],str34)*32)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[1],str34)*64)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[0],str34)*128)//
						)&0xff);
		
		by_for_send_to_MVB[12]=(byte)((
				(get_SelectedItem(ComboBox_for_commu[0],str40)*1)//司乘对讲
				+(get_SelectedItem(ComboBox_for_commu[1],str40)*2)//司机对讲
				+(get_SelectedItem(ComboBox_for_guzhang[5],str35)*4)///6车PIS内部存在故障
				
				+(get_SelectedItem(ComboBox_for_guzhang[4],str35)*8)//5车PIS内部存在故障
				+(get_SelectedItem(ComboBox_for_guzhang[3],str35)*16)//4车PIS内部存在故障
				+(get_SelectedItem(ComboBox_for_guzhang[2],str35)*32)//3车PIS内部存在故障
				+(get_SelectedItem(ComboBox_for_guzhang[1],str35)*64)//2车PIS内部存在故障
				+(get_SelectedItem(ComboBox_for_guzhang[0],str35)*128)//1车PIS内部存在故障
						)&0xff);
		
		
		//ComboBox_for_commu[1]-->司机对象-str40
		by_for_send_to_MVB[15]=(byte)((
				(get_SelectedItem(ComboBox_for_fuwei[7],str36)*1)//8车PIS内发生了复位
				+(get_SelectedItem(ComboBox_for_fuwei[6],str36)*2)//7车PIS内发生了复位
				+(get_SelectedItem(ComboBox_for_fuwei[5],str36)*4)///6车PIS内发生了复位
				
				+(get_SelectedItem(ComboBox_for_fuwei[4],str36)*8)//5车PIS内发生了复位
				+(get_SelectedItem(ComboBox_for_fuwei[3],str36)*16)//4车PIS内发生了复位
				+(get_SelectedItem(ComboBox_for_fuwei[2],str36)*32)//3车PIS内发生了复位
				+(get_SelectedItem(ComboBox_for_fuwei[1],str36)*64)//2车PIS内发生了复位
				+(get_SelectedItem(ComboBox_for_fuwei[0],str36)*128)//1车PIS内发生了复位
						)&0xff);
		//司机当前紧急通话的乘客紧急报警的单元号
		by_for_send_to_MVB[14]=(byte)((get_SelectedItem(ComboBox_for_bjq_num[0],str41))&0xff);
		
		by_for_send_to_MVB[17]=(byte)((
				(get_SelectedItem(ComboBox_for_bjq_fault[7],str31)*1)
				+(get_SelectedItem(ComboBox_for_bjq_fault[6],str31)*2)
				+(get_SelectedItem(ComboBox_for_bjq_fault[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[3],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[2],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[1],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[0],str31)*128)
						)&0xff);
		by_for_send_to_MVB[16]=(byte)((
				(get_SelectedItem(ComboBox_for_bjq_fault[15],str31)*1)
				+(get_SelectedItem(ComboBox_for_bjq_fault[14],str31)*2)
				+(get_SelectedItem(ComboBox_for_bjq_fault[13],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[12],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[11],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[10],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[9],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[8],str31)*128)
						)&0xff);
		by_for_send_to_MVB[19]=(byte)((
				(get_SelectedItem(ComboBox_for_bjq_fault[23],str31)*1)
				+(get_SelectedItem(ComboBox_for_bjq_fault[22],str31)*2)
				+(get_SelectedItem(ComboBox_for_bjq_fault[21],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[20],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[19],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[18],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[17],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[16],str31)*128)
						)&0xff);
		
		by_for_send_to_MVB[18]=(byte)((
//				(get_SelectedItem(ComboBox_for_bjq_fault[23],str31)*1)
//				+(get_SelectedItem(ComboBox_for_bjq_fault[22],str31)*2)
				//+
				(get_SelectedItem(ComboBox_for_bjq_fault[29],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[28],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[27],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[26],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[25],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[24],str31)*128)
						)&0xff);
		
		
		//ComboBox_for_liangua_jiebian[0]-连挂标志-str30
		//ComboBox_for_liangua_jiebian[1]-解编标志-str29
		by_for_send_to_MVB[21]=(byte)((
				(get_SelectedItem(ComboBox_for_bjq_fault[34],str31)*1)
				+(get_SelectedItem(ComboBox_for_bjq_fault[33],str31)*2)
				+(get_SelectedItem(ComboBox_for_bjq_fault[32],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[31],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[30],str31)*16)
				+(get_SelectedItem(ComboBox_for_liangua_jiebian[1],str29)*32)
				+(get_SelectedItem(ComboBox_for_liangua_jiebian[0],str30)*64)
				//+(get_SelectedItem(ComboBox_for_bjq_fault[16],str31)*128)
						)&0xff);
		
		by_for_send_to_MVB[20]=(byte)((
//				(get_SelectedItem(ComboBox_for_bjq_fault[23],str31)*1)
//				+(get_SelectedItem(ComboBox_for_bjq_fault[22],str31)*2)
//				+(get_SelectedItem(ComboBox_for_bjq_fault[21],str31)*4)
				//+
				(get_SelectedItem(ComboBox_for_bjq_fault[39],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[38],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[37],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[36],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[35],str31)*128)
						)&0xff);
		
//		ComboBox_for_station[0].setSelectedIndex(1);//当前站:---str41
//		ComboBox_for_station[1].setSelectedIndex(1);//下一站:---
//		ComboBox_for_station[2].setSelectedIndex(1);//目的站:---
		//当前站
		by_for_send_to_MVB[23]=(byte)(get_SelectedItem(ComboBox_for_station[0],str41)&0xff);
		by_for_send_to_MVB[22]=(byte)(0);
		//下一站
		by_for_send_to_MVB[25]=(byte)(get_SelectedItem(ComboBox_for_station[1],str41)&0xff);
		by_for_send_to_MVB[24]=(byte)(0);
		//目的站
		by_for_send_to_MVB[27]=(byte)(get_SelectedItem(ComboBox_for_station[2],str41)&0xff);
		by_for_send_to_MVB[26]=(byte)(0);
		
		//ComboBox_for_drv_fault String str32[] = {"广播控制盒", "中控","录音"};str31
		by_for_send_to_MVB[29]=(byte)((
//				(get_SelectedItem(ComboBox_for_bjq_fault[23],str31)*1)
//				+(get_SelectedItem(ComboBox_for_bjq_fault[22],str31)*2)
				//+
				(get_SelectedItem(ComboBox_for_drv_fault[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_drv_fault[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_drv_fault[2],str31)*16)
				+(get_SelectedItem(ComboBox_for_drv_fault[1],str31)*32)
				+(get_SelectedItem(ComboBox_for_drv_fault[3],str31)*64)
				+(get_SelectedItem(ComboBox_for_drv_fault[0],str31)*128)
						)&0xff);
		
		by_for_send_to_MVB[28]=(byte)((
				(get_SelectedItem(ComboBox_for_gf_fault[13],str31)*1)
				+(get_SelectedItem(ComboBox_for_gf_fault[12],str31)*2)
				+(get_SelectedItem(ComboBox_for_gf_fault[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_gf_fault[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_gf_fault[3],str31)*16)
				+(get_SelectedItem(ComboBox_for_gf_fault[2],str31)*32)
				+(get_SelectedItem(ComboBox_for_gf_fault[1],str31)*64)
				+(get_SelectedItem(ComboBox_for_gf_fault[0],str31)*128)
						)&0xff);
		
		by_for_send_to_MVB[31]=(byte)((
				(get_SelectedItem(ComboBox_for_gf_fault[15],str31)*1)
				+(get_SelectedItem(ComboBox_for_gf_fault[14],str31)*2)
				+(get_SelectedItem(ComboBox_for_gf_fault[7],str31)*4)
				+(get_SelectedItem(ComboBox_for_gf_fault[6],str31)*8)
				+(get_SelectedItem(ComboBox_for_gf_fault[9],str31)*16)
				+(get_SelectedItem(ComboBox_for_gf_fault[8],str31)*32)
				+(get_SelectedItem(ComboBox_for_gf_fault[11],str31)*64)
				+(get_SelectedItem(ComboBox_for_gf_fault[10],str31)*128)
						)&0xff);
		
		by_for_send_to_MVB[30]=(byte)(0xff);
		
		
		//0x911、0x961
		by_for_send_to_MVB[32+1]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[7],str31)*1)
				+(get_SelectedItem(ComboBox_for_map[6],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[3],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[2],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[1],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[0],str31)*128)
						)&0xff);//
		by_for_send_to_MVB[32+0]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[8],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[9],str31)*64)
						)&0xff);
		by_for_send_to_MVB[32+3]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[10],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[11],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[12],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[13],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[14],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[15],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[16],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[17],str31)*1)
						)&0xff);
		
		by_for_send_to_MVB[32+2]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[18],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[19],str31)*64)
						)&0xff);
		
		by_for_send_to_MVB[32+5]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[20],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[21],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[22],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[23],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[24],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[25],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[26],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[27],str31)*1)
						)&0xff);
		
		by_for_send_to_MVB[32+4]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[28],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[29],str31)*64)
						)&0xff);
		by_for_send_to_MVB[32+7]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[30],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[31],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[32],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[33],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[34],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[35],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[36],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[37],str31)*1)
						)&0xff);
		
		by_for_send_to_MVB[32+6]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[38],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[39],str31)*64)
						)&0xff);
		by_for_send_to_MVB[32+9]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[40],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[41],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[42],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[43],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[44],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[45],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[46],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[47],str31)*1)
						)&0xff);
		
		by_for_send_to_MVB[32+8]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[48],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[49],str31)*64)
						)&0xff);
		
		by_for_send_to_MVB[32+11]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[50],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[51],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[52],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[53],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[54],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[55],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[56],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[57],str31)*1)
						)&0xff);
		
		by_for_send_to_MVB[32+10]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[58],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[59],str31)*64)				
				+(get_SelectedItem(ComboBox_for_map[68],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[69],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[78],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[79],str31)*4)
						)&0xff);
		
		by_for_send_to_MVB[32+13]=(byte) ((
				(get_SelectedItem(ComboBox_for_wireless_fault[0],str31)*128)
				+(get_SelectedItem(ComboBox_for_wireless_fault[1],str31)*64)
				+(get_SelectedItem(ComboBox_for_wireless_fault[2],str31)*32)
				+(get_SelectedItem(ComboBox_for_wireless_fault[3],str31)*16)
				+(get_SelectedItem(ComboBox_for_wireless_fault[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_wireless_fault[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_wireless_fault[6],str31)*2)
				+(get_SelectedItem(ComboBox_for_wireless_fault[7],str31)*1)
						)&0xff);
		
		by_for_send_to_MVB[32+12]=(byte) ((
				(get_SelectedItem(ComboBox_for_wireless_fault[8],str31)*128)
				+(get_SelectedItem(ComboBox_for_wireless_fault[9],str31)*64)
				+(get_SelectedItem(ComboBox_for_wireless_fault[10],str31)*32)
				+(get_SelectedItem(ComboBox_for_wireless_fault[11],str31)*16)
				+(get_SelectedItem(ComboBox_for_wireless_fault[12],str31)*8)
				+(get_SelectedItem(ComboBox_for_wireless_fault[13],str31)*4)
				+(get_SelectedItem(ComboBox_for_wireless_fault[14],str31)*2)
				+(get_SelectedItem(ComboBox_for_wireless_fault[15],str31)*1)
						)&0xff);
		
		by_for_send_to_MVB[32+15]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[60],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[61],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[62],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[63],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[64],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[65],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[66],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[67],str31)*1)
						)&0xff);
		
		by_for_send_to_MVB[32+14]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[70],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[71],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[72],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[73],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[74],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[75],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[76],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[77],str31)*1)
						)&0xff);
		
	}
	public void build_process_data_for_trdp()
	{
		//97+5;by_for_send
		//26
		life+=1;
		if(life>=65535)
		{
			life=0;
		}
		by_for_send[0]=(byte)((life>>8)&0xff);
		by_for_send[1]=(byte)(life&0xff);
		
//		System.out.print(life+"---");
//		System.out.print(by_for_send[0]+"---");
//		System.out.println(by_for_send[1]);
		
		by_for_send[2]=(byte)(0x10);
		by_for_send[3]=(byte)(0x01);
		
		by_for_send[4]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[0],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[1],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[2],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[3],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[6],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[7],str31)*1)
						)&0xff);//
		by_for_send[5]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[8],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[9],str31)*64)
						)&0xff);
		by_for_send[6]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[10],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[11],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[12],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[13],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[14],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[15],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[16],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[17],str31)*1)
						)&0xff);
		
		by_for_send[7]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[18],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[19],str31)*64)
						)&0xff);
		
		by_for_send[8]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[20],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[21],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[22],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[23],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[24],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[25],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[26],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[27],str31)*1)
						)&0xff);
		
		by_for_send[9]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[28],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[29],str31)*64)
						)&0xff);
		by_for_send[10]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[30],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[31],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[32],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[33],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[34],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[35],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[36],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[37],str31)*1)
						)&0xff);
		
		by_for_send[11]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[38],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[39],str31)*64)
						)&0xff);
		by_for_send[12]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[40],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[41],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[42],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[43],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[44],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[45],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[46],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[47],str31)*1)
						)&0xff);
		
		by_for_send[13]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[48],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[49],str31)*64)
						)&0xff);
		
		by_for_send[14]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[50],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[51],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[52],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[53],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[54],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[55],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[56],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[57],str31)*1)
						)&0xff);
		
		by_for_send[15]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[58],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[59],str31)*64)
				
				+(get_SelectedItem(ComboBox_for_map[68],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[69],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[78],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[79],str31)*4)
						)&0xff);
		
		by_for_send[16]=(byte) ((
				(get_SelectedItem(ComboBox_for_wireless_fault[0],str31)*128)
				+(get_SelectedItem(ComboBox_for_wireless_fault[1],str31)*64)
				+(get_SelectedItem(ComboBox_for_wireless_fault[2],str31)*32)
				+(get_SelectedItem(ComboBox_for_wireless_fault[3],str31)*16)
				+(get_SelectedItem(ComboBox_for_wireless_fault[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_wireless_fault[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_wireless_fault[6],str31)*2)
				+(get_SelectedItem(ComboBox_for_wireless_fault[7],str31)*1)
						)&0xff);
		
		by_for_send[17]=(byte) ((
				(get_SelectedItem(ComboBox_for_wireless_fault[8],str31)*128)
				+(get_SelectedItem(ComboBox_for_wireless_fault[9],str31)*64)
				+(get_SelectedItem(ComboBox_for_wireless_fault[10],str31)*32)
				+(get_SelectedItem(ComboBox_for_wireless_fault[11],str31)*16)
				+(get_SelectedItem(ComboBox_for_wireless_fault[12],str31)*8)
				+(get_SelectedItem(ComboBox_for_wireless_fault[13],str31)*4)
				+(get_SelectedItem(ComboBox_for_wireless_fault[14],str31)*2)
				+(get_SelectedItem(ComboBox_for_wireless_fault[15],str31)*1)
						)&0xff);
		
		by_for_send[18]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[60],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[61],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[62],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[63],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[64],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[65],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[66],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[67],str31)*1)
						)&0xff);
		
		by_for_send[19]=(byte) ((
				(get_SelectedItem(ComboBox_for_map[70],str31)*128)
				+(get_SelectedItem(ComboBox_for_map[71],str31)*64)
				+(get_SelectedItem(ComboBox_for_map[72],str31)*32)
				+(get_SelectedItem(ComboBox_for_map[73],str31)*16)
				+(get_SelectedItem(ComboBox_for_map[74],str31)*8)
				+(get_SelectedItem(ComboBox_for_map[75],str31)*4)
				+(get_SelectedItem(ComboBox_for_map[76],str31)*2)
				+(get_SelectedItem(ComboBox_for_map[77],str31)*1)
						)&0xff);
		//TC1
		//ComboBox_for_drv_fault String str32[] = {"广播控制盒", "中控","录音"};
		by_for_send[20]=(byte) ((
				(get_SelectedItem(ComboBox_for_drv_fault[0],str31)*128)
				+(get_SelectedItem(ComboBox_for_drv_fault[3],str31)*64)
				+(get_SelectedItem(ComboBox_for_drv_fault[1],str31)*32)
				+(get_SelectedItem(ComboBox_for_drv_fault[2],str31)*16)
				+(get_SelectedItem(ComboBox_for_drv_fault[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_drv_fault[5],str31)*4)				
						)&0xff);
		//ComboBox_for_gf_fault
		by_for_send[21]=(byte) ((
				(get_SelectedItem(ComboBox_for_gf_fault[0],str31)*128)
				+(get_SelectedItem(ComboBox_for_gf_fault[1],str31)*64)
				+(get_SelectedItem(ComboBox_for_gf_fault[2],str31)*32)
				+(get_SelectedItem(ComboBox_for_gf_fault[3],str31)*16)
				+(get_SelectedItem(ComboBox_for_gf_fault[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_gf_fault[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_gf_fault[12],str31)*2)
				+(get_SelectedItem(ComboBox_for_gf_fault[13],str31)*1)
						)&0xff);
		
		by_for_send[22]=(byte) ((
				(get_SelectedItem(ComboBox_for_gf_fault[11],str31)*128)
				+(get_SelectedItem(ComboBox_for_gf_fault[10],str31)*64)
				+(get_SelectedItem(ComboBox_for_gf_fault[9],str31)*32)
				+(get_SelectedItem(ComboBox_for_gf_fault[8],str31)*16)
				+(get_SelectedItem(ComboBox_for_gf_fault[6],str31)*8)
				+(get_SelectedItem(ComboBox_for_gf_fault[7],str31)*4)
				+(get_SelectedItem(ComboBox_for_gf_fault[14],str31)*2)
				+(get_SelectedItem(ComboBox_for_gf_fault[15],str31)*1)
						)&0xff);
		//ComboBox_for_bjq_fault
		by_for_send[23]=(byte) ((
				(get_SelectedItem(ComboBox_for_bjq_fault[0],str31)*128)
				+(get_SelectedItem(ComboBox_for_bjq_fault[1],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[2],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[3],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[4],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[5],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[6],str31)*2)
				+(get_SelectedItem(ComboBox_for_bjq_fault[7],str31)*1)
						)&0xff);
		
		by_for_send[24]=(byte) ((
				(get_SelectedItem(ComboBox_for_bjq_fault[8],str31)*128)
				+(get_SelectedItem(ComboBox_for_bjq_fault[9],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[10],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[11],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[12],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[13],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[14],str31)*2)
				+(get_SelectedItem(ComboBox_for_bjq_fault[15],str31)*1)
						)&0xff);
		
		by_for_send[25]=(byte) ((
				(get_SelectedItem(ComboBox_for_bjq_fault[16],str31)*128)
				+(get_SelectedItem(ComboBox_for_bjq_fault[17],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[18],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[19],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[20],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[21],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[22],str31)*2)
				+(get_SelectedItem(ComboBox_for_bjq_fault[23],str31)*1)
						)&0xff);
		
		by_for_send[26]=(byte) ((
				(get_SelectedItem(ComboBox_for_bjq_fault[24],str31)*128)
				+(get_SelectedItem(ComboBox_for_bjq_fault[25],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[26],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[27],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[28],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[29],str31)*4)				
						)&0xff);
				
		by_for_send[27]=(byte) ((			
				(get_SelectedItem(ComboBox_for_bjq_fault[30],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[31],str31)*8)
				+(get_SelectedItem(ComboBox_for_bjq_fault[32],str31)*4)
				+(get_SelectedItem(ComboBox_for_bjq_fault[33],str31)*2)
				+(get_SelectedItem(ComboBox_for_bjq_fault[34],str31)*1)
						)&0xff);
		//ComboBox_for_zhuji_guzhang
		by_for_send[28]=(byte) ((
				(get_SelectedItem(ComboBox_for_bjq_fault[35],str31)*128)
				+(get_SelectedItem(ComboBox_for_bjq_fault[36],str31)*64)
				+(get_SelectedItem(ComboBox_for_bjq_fault[37],str31)*32)
				+(get_SelectedItem(ComboBox_for_bjq_fault[38],str31)*16)
				+(get_SelectedItem(ComboBox_for_bjq_fault[39],str31)*8)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[0],str31)*4)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[1],str31)*2)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[2],str31)*1)
						)&0xff);
		
		by_for_send[29]=(byte) ((
				(get_SelectedItem(ComboBox_for_zhuji_guzhang[3],str31)*128)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[4],str31)*64)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[5],str31)*32)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[6],str31)*16)
				+(get_SelectedItem(ComboBox_for_zhuji_guzhang[7],str31)*8)
				
				+(get_SelectedItem(ComboBox_for_tc1_tc2_guzhang[0],str31)*2)
				+(get_SelectedItem(ComboBox_for_tc1_tc2_guzhang[1],str31)*1)
						)&0xff);
		by_for_send[30]=(byte)0xff;
		by_for_send[31]=(byte)0xff;
		by_for_send[32]=(byte)0xff;
		by_for_send[33]=(byte)0xff;
		by_for_send[34]=(byte)0xff;
		by_for_send[35]=(byte)0xff;
		
	}
	
	
	
	static udp ServletBroadcast01 = null;
	 
	
	
	
	//main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServletBroadcast01 = new udp();
		
		JFrame frame = new ui();
		frame.setLayout(null);
		frame.setBounds(100, 20,1700,1000);
		frame.setVisible(true);
		frame.setTitle("1.0.0.8");
		frame.addWindowListener(new WindowAdapter()
		{
			public void JFClose(WindowEvent w)
			{
				//ServletBroadcast01.udp_des();
//				udp.ds_for_recv=null;
//				System.exit(0);
			};
		});
		
		
		 
	}

}


