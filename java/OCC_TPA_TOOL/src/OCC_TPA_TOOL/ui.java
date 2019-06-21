package OCC_TPA_TOOL;
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
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

//import test_pro.test_open_dir.FileFilterTest;
public class ui extends JPanel
{	

	private JTabbedPane jTabbedpane = new JTabbedPane();// 存放选项卡的组件
	private String[] tabNames = { "过程数据-报警器", "过程数据-功放音量-广播标志", "过程数据-站信息-激活主备-越站-报站模式", "LED屏显示内容", 
			"功放状态数据-室内", "功放状态数据-室外","广播系统设备状态-司机室-客室(1-3)" 
			, "广播系统设备状态-客室(5-8)","媒体监控系统设备状态-司机室-客室(1-3)",
			"媒体监控系统设备状态-客室(5-8)","广播音频-对讲音频"};
	//ImageIcon icon = createImageIcon("1.jpg");
	JPanel panel_for_time=new JPanel();
	JTextField tf_for_time=new JTextField();
	
	static String str_choose[]={"ENABLE","DISABLE"};
	String str_enable[]={"过程数据:","功放状态数据:","广播设备状态:","媒体设备状态:"};
	//数据使能
		JPanel[] panel_for_en = new JPanel[4];
	static JComboBox<String>[]  ComboBox_for_en = new JComboBox [4];
		JLabel[] label_for_en = new JLabel[4];
	
	static public byte[] by =new byte[97+5];//过程数据
	static public byte[] by_for_gf=new byte[5+32];//功放状态数据
	static public byte[] by_for_broadcast=new byte[5+50];//广播设备状态数据
	static public byte[] by_for_media=new byte[5+20];//媒体监控状态数据	
	static String str18="预录制广播中...";
	static String str19="预录制广播停止";
	static String str34="对讲中...";
	static String str35="对讲停止";
	static String str45="";//ip地址
	static String str46="服务器连接";//ip地址
	static String str47="服务器断开";//ip地址
	static public JTextField tf_for_braodcast = new JTextField(str19, 20);
	static public JTextField tf_for_talk = new JTextField(str35, 20);
	
	static public JTextField tf_for_server_ip= new JTextField(str45, 20);
	static public JTextField tf_for_server_connect_boolean= new JTextField(str47, 20);
	
	JPanel panel_for_server_ip=new JPanel();
	JPanel panel_for_server_connect_boolean=new JPanel();
	JPanel panel_for_server_true_bt=new JPanel();
	JPanel panel_for_server_false_bt=new JPanel();
	
	JLabel label_for_server_ip = new JLabel("要连接的tcp服务器ip: ");
	JLabel label_for_server_connect_boolean = new JLabel("tcp服务器连接状态  : ");
	
	JButton button_for_server_true= new JButton("连接tcp服务器");
	JButton button_for_server_false= new JButton("断开tcp服务器");
	
	
	
	public int start_sta_num=1;
	public int end_sta_num=24;
	public int cur_sta_num=1;
	public int next_sta_num=2;
	
	Font f = new Font("宋体",Font.PLAIN,18);	
	Font f1 = new Font("宋体",Font.PLAIN,36);
	Font f3 = new Font("宋体",Font.PLAIN,24);
	Font f2 = new Font("Times New Roman",Font.PLAIN,40);
	//Font f3 = new Font("Times New Roman",Font.PLAIN,40);
	String str1[] = { "正常/取消申请/接通后挂断", "申请", "接通(控制盒)", "接通(OCC-TPA)"};
	String str5[] = { "无效", "手动", "半自动", "全自动" };
	String str9[]={"司机室1主备","司机室1激活","司机室2主备","司机室2激活"};
	String str10[] = { " 备  ", " 主  " };//主备
	String str11[] = { " 无效 ", " 有效 " };//激活
	//14
	String str6[] = { "控制盒话筒音量:", "控制盒监听音量: ", "控制盒对讲监听音量: ", "中心广播音量:",
			"媒体广播音量:", "紧急报警器话筒音量:", "紧急报警器对讲监听音量:", "报站广播音量:", "关门音音量:",
			"紧急广播音量:", "测试广播音量:", "未命名音量1:", "未命名音量2:", "未命名音量3:" };
	//13
	String str7[] = { "OCC广播优先级:", "列车话筒广播优先级:", "列车紧急广播优先级:",
			"列车报站广播优先级:", "关门提示音广播优先级:", "测试广播优先级:", "媒体广播优先级:",
			"OCC-TPA话筒广播优先级:", "OCC-TPA紧急广播优先级:", "未命名优先级1:", "未命名优先级2:",
			"未命名优先级3:","紧急广播ID" };
	String str8[] = { "无效", "手动", "半自动", "全自动" };
	String str = "紧急报警器";
	String str2="功放音量(室内)";
	String str3="功放音量(室外)";	
	String str4[] = { "起始站:", "终点站:", "当前站:", "下一站:" };// 5	
	String str12="越站";
	String str13[]={"否","是"};//是否越站
	String str14[] = { "OCC-TPA广播:", "列车话筒广播:", "关门提示广播:", "OCC广播:", "紧急广播:",
			"离站广播:", "进站广播:", "媒体广播:" };
	String str15[]={"无效","有效"};//str14广播是否有效
	String str16[]={"预录制广播","停止广播"};
	String str17[]={"对讲音频开始","对讲音频停止"};
	String str36="设置站信息";
	//str18 19被静态 占用了
	String str20[]={"开路","短路","功放板故障","播音状态"};
	String str21[]={ "正常", "开路"};
	String str22[]={ "正常", "短路"};
	String str23[]={ "正常", "故障"};
	String str24[]={ "无播音", "播音"};
	String str25="功放(室内)";//状态数据
	String str26="功放(室外)";
	
	String str27="司机室";//for 广播系统设备状态数据
	String str28="客室";//for 广播系统设备状态数据
	String str29[]={"重连接口","录音单元","终点站屏","广播控制盒","中央控制器"};//5
	String str30[]={"紧急报警器6","紧急报警器5","紧急报警器4","紧急报警器3","紧急报警器2" //6+10+4+4=24
			,"紧急报警器1","Led动态8","Led动态7","Led动态6","Led动态5"					
			,"Led动态4","Led动态3","Led动态2","Led动态1","Led动态10","Led动态9",		
			"室外功放2","室外功放1","室内功放2","室内功放1",
			"车外侧led屏2","车外侧led屏1","贯通道led屏2","贯通道led屏1"};
	
	String str31[]={"正常","故障"};//广播系统设备状态数据字符串
	//for 媒体监控系统设备状态数据司机室 16
	String str32[]={"NVR2","NVR1","触摸屏","备用","摄像头4","摄像头3","摄像头2","摄像头1",
			"NVR2硬盘4","NVR2硬盘3","NVR2硬盘2","NVR2硬盘1","NVR1硬盘4","NVR1硬盘3","NVR1硬盘2","NVR1硬盘1"};
	//for 媒体监控系统设备状态数据客室 16
	String str33[]={"NVR2","NVR1","摄像头6","摄像头5","摄像头4","摄像头3","摄像头2","摄像头1",
			"NVR2硬盘4","NVR2硬盘3","NVR2硬盘2","NVR2硬盘1","NVR1硬盘4","NVR1硬盘3","NVR1硬盘2","NVR1硬盘1"};
	
	String str37[]={"1","2","3","4","5","6"};//id
	String str38[]={"1","2","3","4","5","6","7","8"};//车厢号
	String str39="报警器车厢号: ";
	String str40="报警器ID: ";
	String str41="预录制广播选择";
	String str42="对讲音频选择";
	
	 public  String str43="";
	 public   String str44="";
//	static public File str43=null;//广播
//	static public File str44=null;//对讲的
	//报站模式选择1
	JPanel panel_for_mode = new JPanel();
	JComboBox<String>  ComboBox_for_mode = new JComboBox(str8);
	JLabel label_for_mode = new JLabel("报站模式:");
	
//	Container container=new Container();//创建一个容器
//	JScrollPane sp=new JScrollPane();
	
	//对讲报警器车厢号和ID 
	JPanel[] panel_for_talk_choose = new JPanel[2];
	static public JComboBox<String>[]  ComboBox_for_talk_choose = new JComboBox [2];
	JLabel[] label_for_talk_choose = new JLabel[2];
	
	
	//紧急报警器
	JPanel[] panel_for_bjq = new JPanel[48];
	JComboBox<String>[]  ComboBox_for_bjq = new JComboBox [48];
	JLabel[] label_for_bjq = new JLabel[48];
	//室内
	JPanel[] panel_for_gf_i = new JPanel[16];
	JTextField[] tf_for_gf_i = new JTextField[16];
	JLabel[] label_for_gf_i = new JLabel[16];
	//室外
	JPanel[] panel_for_gf_o = new JPanel[16];
	JTextField[] tf_for_gf_o = new JTextField[16];
	JLabel[] label_for_gf_o = new JLabel[16];
	
	//站信息4
	JPanel[] panel_for_station = new JPanel[str4.length];
	JTextField[] tf_for_station = new JTextField[str4.length];
	JLabel[] label_for_station = new JLabel[str4.length];
	//其他音量
	JPanel[] panel_for_yinliang = new JPanel[str6.length];
	JTextField[] tf_for_yinliang = new JTextField[str6.length];
	JLabel[] label_for_yinliang = new JLabel[str6.length];
	//优先级和紧急广播ID 
	JPanel[] panel_for_youxianji = new JPanel[str7.length];
	JTextField[] tf_for_youxianji = new JTextField[str7.length];
	JLabel[] label_for_youxianji = new JLabel[str7.length];

	//司机室4
	JPanel[] panel_for_drv = new JPanel[4];
	JComboBox<String>[]  ComboBox_for_drv = new JComboBox [4];
	JLabel[] label_for_drv = new JLabel[4];
	//越站
	JPanel[] panel_for_yuezhan = new JPanel[64];
	JComboBox<String>[]  ComboBox_for_yuezhan = new JComboBox [64];
	JLabel[] label_for_yuezhan = new JLabel[64];
	//有效标志8
	JPanel[] panel_for_active = new JPanel[str14.length];
	JComboBox<String>[]  ComboBox_for_active = new JComboBox [str14.length];
	//JPanel panel_for_talk_tf=new JPanel();
	JLabel[] label_for_active = new JLabel[str14.length];
	//广播音频
	JPanel panel_for_broadcast_tf=new JPanel();
	
	JButton[] button_for_broadcast= new JButton[str16.length];
	JPanel[] panel_for_broadcast = new JPanel[str16.length];
	JPanel panel_for_broadcast_choose=new JPanel();
	JButton button_for_broadcast__choose= new JButton(str41);
	SimpleListener ourListener = new SimpleListener();
	//对讲音频
	JPanel panel_for_talk_tf=new JPanel(); 
	JPanel panel_for_talk__choose_dir=new JPanel();
	JButton button_for_talk__choose_dir= new JButton(str42);
	JButton[] button_for_talk= new JButton[str17.length];
	JPanel[] panel_for_talk = new JPanel[str17.length];
	//设置站信息
	JButton button_for_set_sta= new JButton(str36);
	//JLabel label_for_set_sta = new JLabel(str36);
	JPanel panel_for_set_sta = new JPanel();
	//室内功放状态
	JPanel[] panel_for_gf_i_s = new JPanel[64];
	JComboBox<String>[]  ComboBox_for_gf_i_s = new JComboBox [64];
	JLabel[] label_for_gf_i_s = new JLabel[64];
	
	//室外功放状态
	JPanel[] panel_for_gf_o_s = new JPanel[64];
	JComboBox<String>[]  ComboBox_for_gf_o_s = new JComboBox [64];
	JLabel[] label_for_gf_o_s = new JLabel[64];
	//
	//分割线
	JPanel panel_for_fengexian = new JPanel();
	//JComboBox<String>  ComboBox_for_mode = new JComboBox(str8);
	JLabel label_for_fengexian = new JLabel("-----------------------------"
			+ "----------------------------------------------");
	
	//广播设备状态数据--司机室
	JPanel[] panel_for_broadcast_device_drv_s = new JPanel[10];
	JComboBox<String>[]  ComboBox_for_broadcast_device_drv_s = new JComboBox [10];
	JLabel[] label_for_broadcast_device_drv_s = new JLabel[10];
	//广播设备状态数据--客室
	JPanel[] panel_for_broadcast_device_pas_s = new JPanel[192];
	JComboBox<String>[]  ComboBox_for_broadcast_device_pas_s = new JComboBox [192];
	JLabel[] label_for_broadcast_device_pas_s = new JLabel[192];
	
	
	//媒体监控系统设备状态数据--司机室
	JPanel[] panel_for_media_device_drv_s = new JPanel[32];
	JComboBox<String>[]  ComboBox_for_media_device_drv_s = new JComboBox [32];
	JLabel[] label_for_media_device_drv_s = new JLabel[32];
	//媒体监控系统设备状态数据--客室
	JPanel[] panel_for_media_device_pas_s = new JPanel[128];
	JComboBox<String>[]  ComboBox_for_media_device_pas_s = new JComboBox [128];
	JLabel[] label_for_media_device_pas_s = new JLabel[128];
	
	public ui() {
		layoutComponents();
	}
	
 
	public void layoutComponents() {
		this.setLayout(null);
		int i = 0;
		int j = 0;
		int k = 0;

		Timer timer_for_time = new Timer();
		Timer timer_refresh_data = new Timer();
		Timer timer1_refresh_data = new Timer();
		Timer timer2_refresh_data = new Timer();
		Timer timer3_refresh_data = new Timer();
		Timer timer_change_station = new Timer();
		JPanel[] panel_for_tab = new JPanel[tabNames.length];// 20

			for(i=0;i<tabNames.length;i++)
		{
			panel_for_tab[i] = new JPanel();
			panel_for_tab[i].setLayout(null);
			panel_for_tab[i].setBackground(Color.WHITE);

			 jTabbedpane.addTab(tabNames[i], panel_for_tab[i]);
			 jTabbedpane.setFont(f);
			 jTabbedpane.setBackground(Color.green);
		}

		String strtemp = "";
		String strtemp2 = "";
		
		for(i=0;i<8;i++)
		{
			for(j=0;j<6;j++)
			{
				strtemp = str;
				strtemp += ":";
				strtemp += String.valueOf(i + 1);
				strtemp+="车";
				strtemp += "--";
				strtemp += String.valueOf(j + 1);
				//strtemp+="号";
				strtemp += ":";
				
				label_for_bjq[j + i * 6] = new JLabel(strtemp);
				label_for_bjq[j + i * 6].setForeground(Color.BLUE);
			//	label_for_bjq[j + i * 6].setSize(10, 40);
			}
		}
//		JPanel panel_for_tmp = new JPanel();
//		panel_for_tmp.setLayout(null);
		for(i=0;i<48;i++)
		{
			panel_for_bjq[i] = new JPanel();
		//	panel_for_bjq[i].setSize(100, 40);
			ComboBox_for_bjq[i] = new JComboBox<String>(str1);
			//ComboBox_for_bjq[i].setBackground(Color.BLACK);
		//	ComboBox_for_bjq[i].setSize(20, 40);
//			panel_for_tab[0].add(label_for_bjq[i]);
//			panel_for_tab[0].add(ComboBox_for_bjq[i]);
			panel_for_bjq[i].add(label_for_bjq[i]);
			panel_for_bjq[i].add(ComboBox_for_bjq[i]);
			
			panel_for_tab[0].add(panel_for_bjq[i]);

		}
		{
//			int ii=0;
//			int iij=0;
			int ii=-1;
			int iij=-1;
			for(i=0;i<48;i++)
			{
				if(i%6==0)
				{
					 ii+=1;			

				}
				if(i%3==0)
				{
					iij+=1;
				}
				
				//panel_for_bjq[i].setBounds(0+300*(i%3), 0+ 40 * (i)+10*(ii), 300, 40);
				panel_for_bjq[i].setBounds(300+320*(i%3), 0+40 * (iij)+10*(ii), 300, 40);
				
			}
			
		}

		{
			
		//室内功放
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 2; j++) {
				strtemp = str2;
				strtemp += String.valueOf(i + 1);
				strtemp+="车";
				strtemp += "--";
				strtemp+= String.valueOf(j + 1);
				strtemp+= ":";
				label_for_gf_i[i * 2 + j] = new JLabel(strtemp);
				label_for_gf_i[i * 2 + j].setForeground(Color.RED);
			}
		}
		//室外功放
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 2; j++) {
				strtemp = str3;
				strtemp += String.valueOf(i + 1);
				strtemp+="车";
				strtemp += "--";
				strtemp += String.valueOf(j + 1);
				strtemp += ":";
				label_for_gf_o[i * 2 + j] = new JLabel(strtemp);
				label_for_gf_o[i * 2 + j].setForeground(Color.BLUE);
			}
		}
		int gf_i=-1;
		for (i = 0; i < 16; i++) {
			panel_for_gf_i[i] = new JPanel();
			tf_for_gf_i[i] = new JTextField("20", 5);
			panel_for_gf_i[i].add(label_for_gf_i[i]);
			panel_for_gf_i[i].add(tf_for_gf_i[i]);
			if(i%2==0)
			{
				gf_i+=1;
			}
			panel_for_gf_i[i].setBounds(100+300*(i%2), 80 + 40 * (gf_i), 300, 40);
			//panel_for_tab[0].add(panel_for_gf_i[i]);
			panel_for_tab[1].add(panel_for_gf_i[i]);
			// panel[i+48+5].setBounds(0,0+35*i,275,35);
		}
		int gf_o=-1;
		for (i = 0; i < 16; i++) {
			panel_for_gf_o[i] = new JPanel();
			tf_for_gf_o[i] = new JTextField("20", 5);
			panel_for_gf_o[i].add(label_for_gf_o[i]);
			panel_for_gf_o[i].add(tf_for_gf_o[i]);
			if(i%2==0)
			{
				gf_o+=1;
			}
			panel_for_gf_o[i].setBounds(100+630+300*(i%2), 80 + 40 * (gf_o), 300, 40);
			//panel_for_tab[0].add(panel_for_gf_o[i]);
			panel_for_tab[1].add(panel_for_gf_o[i]);
			// panel[i+48+5].setBounds(0,0+35*i,275,35);
		}
		}
		//站信息
		for (i = 0; i < str4.length; i++) 
		{
			panel_for_station[i] = new JPanel();
			label_for_station[i] = new JLabel(str4[i]);
			label_for_station[i].setForeground(Color.BLUE);
			label_for_station[i].setFont(f1);
			tf_for_station[i] = new JTextField("20", 10);
			panel_for_station[i].add(label_for_station[i]);
			panel_for_station[i].add(tf_for_station[i]);
			panel_for_station[i].setBounds(0+305*i,10, 300, 80);
			panel_for_tab[2].add(panel_for_station[i]);
		}
		{
//			label_for_set_sta.setForeground(Color.BLUE);
//			label_for_set_sta.setFont(f3);
			button_for_set_sta.setSize(200, 40);
			button_for_set_sta.setForeground(Color.blue);
			button_for_set_sta.setFont(f1);
			button_for_set_sta.addActionListener(ourListener);
			//panel_for_set_sta.add(label_for_set_sta);
			panel_for_set_sta.add(button_for_set_sta);
			panel_for_set_sta.setBounds(305*4, 10, 300, 80);
			panel_for_tab[2].add(panel_for_set_sta);
		
		tf_for_station[0].setText(String.valueOf(start_sta_num));
		tf_for_station[1].setText(String.valueOf(end_sta_num));
		tf_for_station[2].setText(String.valueOf(cur_sta_num));
		tf_for_station[3].setText(String.valueOf(next_sta_num));
//		tf_for_station[0].setText("1");
//		tf_for_station[1].setText("24");
//		tf_for_station[2].setText("1");
//		tf_for_station[3].setText("2");
		}
		//90
		int for_yinliang_1=-1;
		for(i=0;i<str6.length;i++)
		{
			panel_for_yinliang[i] = new JPanel();
			label_for_yinliang[i] = new JLabel(str6[i]);
			label_for_yinliang[i].setForeground(Color.BLUE);
			tf_for_yinliang[i] = new JTextField("20", 5);
			panel_for_yinliang[i].add(label_for_yinliang[i]);
			panel_for_yinliang[i].add(tf_for_yinliang[i]);
			if(i%5==0)
			{
				for_yinliang_1+=1;
			}
			panel_for_yinliang[i].setBounds(0+305*(i%5), 101+for_yinliang_1*43, 300, 40);
			panel_for_tab[2].add(panel_for_yinliang[i]);
		}
		//101+129=230
		int for_youxianji_i=-1;
		for(i=0;i<str7.length;i++)
		{
			panel_for_youxianji[i] = new JPanel();
			label_for_youxianji[i] = new JLabel(str7[i]);
			label_for_youxianji[i].setForeground(Color.blue);
			tf_for_youxianji[i] = new JTextField("20", 5);
			panel_for_youxianji[i].add(label_for_youxianji[i]);
			panel_for_youxianji[i].add(tf_for_youxianji[i]);
			if(i%5==0)
			{
				for_youxianji_i+=1;
			}
			//101+129=230+129+11=370
			panel_for_youxianji[i].setBounds(0+305*(i%5), 241+for_youxianji_i*43, 300, 40);
			panel_for_tab[2].add(panel_for_youxianji[i]);
		}
		{
		//紧急广播id
		label_for_youxianji[str7.length-1].setForeground(Color.red);
		tf_for_youxianji[str7.length-1].setText("0");
		
		}
		{//报站模式
			panel_for_mode.add(label_for_mode);
			label_for_mode.setForeground(Color.blue);
			panel_for_mode.add(ComboBox_for_mode);
			ComboBox_for_mode.setSelectedIndex(3);//报站模式默认值
			panel_for_mode.setBounds(0 , 380, 300, 40);
			panel_for_tab[2].add(panel_for_mode);
		}
		{//司机室
			ComboBox_for_drv[0] = new JComboBox<String>(str10);// 司机室1主备
			ComboBox_for_drv[1] = new JComboBox<String>(str11);// 司机室1激活
			ComboBox_for_drv[2] = new JComboBox<String>(str10);// 司机室2主备
			ComboBox_for_drv[3] = new JComboBox<String>(str11);// 司机室2激活
			for(i=0;i<str9.length;i++)
			{
				panel_for_drv[i] = new JPanel();
				label_for_drv[i] = new JLabel(str9[i]);
				label_for_drv[i].setForeground(Color.blue);
				panel_for_drv[i].add(label_for_drv[i]);
				panel_for_drv[i].add(ComboBox_for_drv[i]);
				ComboBox_for_drv[i].setSelectedIndex(1);
				//panel_for_mode.setBounds(0 , 380, 300, 40);
				panel_for_drv[i].setBounds(305+305*i , 380, 300, 40);
				panel_for_tab[2].add(panel_for_drv[i]);
			}
			ComboBox_for_drv[2].setSelectedIndex(0);
			ComboBox_for_drv[3].setSelectedIndex(0);
		}		
		{
			int for_yuezhan_i=-1;
			//是否越站
			for(i=0;i<64;i++)
			{
				panel_for_yuezhan[i] = new JPanel();
				label_for_yuezhan[i] = new JLabel(str12+String.valueOf(i+1));
				ComboBox_for_yuezhan[i] = new JComboBox<String>(str13);
				ComboBox_for_yuezhan[i].setSelectedIndex(0);
				panel_for_yuezhan[i].add(label_for_yuezhan[i]);
				panel_for_yuezhan[i].add(ComboBox_for_yuezhan[i]);
				if(i%8==0)
				{
					for_yuezhan_i+=1;
				}
				//panel_for_drv[i].setBounds(305+305*i , 380, 300, 40);
				panel_for_yuezhan[i].setBounds(0+150+155*(i%8) , 440+ 40 * (for_yuezhan_i), 150, 40);
				panel_for_tab[2].add(panel_for_yuezhan[i]);
			}
		}
		{//广播有效标志
			int for_active_i=-1;
			for(i=0;i<str14.length;i++)
			{
				panel_for_active[i] = new JPanel();
				label_for_active[i] = new JLabel(str14[i]);
				label_for_active[i].setForeground(Color.blue);
				ComboBox_for_active[i] = new JComboBox<String>(str15);
				ComboBox_for_active[i].setSelectedIndex(0);
				panel_for_active[i].add(label_for_active[i]);
				panel_for_active[i].add(ComboBox_for_active[i]);
				if(i%4==0)
				{
					for_active_i+=1;
				}
				//panel_for_gf_o[i].setBounds(100+630+300*(i%2), 200 + 40 * (gf_o), 300, 40);
				
				panel_for_active[i].setBounds(100+300*(i%4) , 440+ 40 * (for_active_i), 300, 40);
				panel_for_tab[1].add(panel_for_active[i]);
			}
		}
		{
			//广播按钮
			for(i=0;i<str16.length;i++)
			{
				panel_for_broadcast[i]=new JPanel();				
				button_for_broadcast[i]=new JButton(str16[i]);
				
				button_for_broadcast[i].setForeground(Color.blue);
				button_for_broadcast[i].setFont(f);
				button_for_broadcast[i].setSize(300, 100);
				button_for_broadcast[i].addActionListener(ourListener);
				
				panel_for_broadcast[i].add(button_for_broadcast[i]);
				panel_for_broadcast[i].setBackground(Color.WHITE);
				panel_for_broadcast[i].setBounds(100+300*i, 50, 300, 100);
				panel_for_tab[tabNames.length-1].add(panel_for_broadcast[i]);
				//button[i].setEnabled(true); 设置不能点击
		       // button2.addActionListener(ourListener);				
				//panel_for_button[i].setBounds(280*4+140,(35*16+(i+1)*50),280*2,30*2);
				//this.add(panel_for_button[i]);
			}
			panel_for_broadcast_tf.add(tf_for_braodcast);
			panel_for_broadcast_tf.setBounds(100+300*2, 50, 300, 100);
			tf_for_braodcast.setFont(f);
			panel_for_broadcast_tf.setBackground(Color.WHITE);
			
			panel_for_broadcast_choose.add(button_for_broadcast__choose);
			panel_for_broadcast_choose.setBounds(100+300*2+300, 50, 300, 100);
			button_for_broadcast__choose.setFont(f);
			button_for_broadcast__choose.addActionListener(ourListener);
			panel_for_broadcast_choose.setBackground(Color.WHITE);
			panel_for_tab[tabNames.length-1].add(panel_for_broadcast_choose);
			
			panel_for_tab[tabNames.length-1].add(panel_for_broadcast_tf);
			
		}
		{//对讲
			
			for(i=0;i<str17.length;i++)
			{
				panel_for_talk[i]=new JPanel();				
				button_for_talk[i]=new JButton(str17[i]);
				button_for_talk[i].setForeground(Color.blue);
				button_for_talk[i].setFont(f);
				button_for_talk[i].setSize(300, 100);
				
				button_for_talk[i].addActionListener(ourListener);
				
				panel_for_talk[i].add(button_for_talk[i]);
				
				panel_for_talk[i].setBounds(100+300*i, 50+100, 300, 100);
				panel_for_talk[i].setBackground(Color.WHITE);
				panel_for_tab[tabNames.length-1].add(panel_for_talk[i]);
				//button[i].setEnabled(true); 设置不能点击
		       // button2.addActionListener(ourListener);				
				//panel_for_button[i].setBounds(280*4+140,(35*16+(i+1)*50),280*2,30*2);
				//this.add(panel_for_button[i]);
			}
			panel_for_talk_tf.add(tf_for_talk);
			panel_for_talk_tf.setBounds(100+300*2, 50+100, 300, 100);
			tf_for_talk.setFont(f);
			panel_for_talk_tf.setBackground(Color.WHITE);
			
			panel_for_talk__choose_dir.add(button_for_talk__choose_dir);
			panel_for_talk__choose_dir.setBounds(100+300*2+300, 50+100, 300, 100);
			button_for_talk__choose_dir.setFont(f);
			//按钮被按下的监听事件
			button_for_talk__choose_dir.addActionListener(ourListener);
			
			panel_for_talk__choose_dir.setBackground(Color.WHITE);
			panel_for_tab[tabNames.length-1].add(panel_for_talk__choose_dir);
			
			
			panel_for_tab[tabNames.length-1].add(panel_for_talk_tf);
			
		}
		{

			for(i=0;i<2;i++)
			{
				panel_for_talk_choose[i] = new JPanel();

				if(i==0)
				{
					label_for_talk_choose[i] = new JLabel(str39);
					ComboBox_for_talk_choose[i] = new JComboBox<String>(str38);
					panel_for_talk_choose[i].add(label_for_talk_choose[i]);
					panel_for_talk_choose[i].add(ComboBox_for_talk_choose[i]);
				}
				else
				{
					label_for_talk_choose[i] = new JLabel(str40);
					ComboBox_for_talk_choose[i] = new JComboBox<String>(str37);
					panel_for_talk_choose[i].add(label_for_talk_choose[i]);
					panel_for_talk_choose[i].add(ComboBox_for_talk_choose[i]);
				}
				label_for_talk_choose[i].setFont(f3);
				ComboBox_for_talk_choose[i].setFont(f3);
				label_for_talk_choose[i].setForeground(Color.blue);
				panel_for_talk_choose[i].setBounds(100+300*i, 250, 300, 300);
				panel_for_talk_choose[i].setBackground(Color.WHITE);
				panel_for_tab[tabNames.length-1].add(panel_for_talk_choose[i]);
			}
			
			
		}
		{
			//室内功放状态
			for(i=0;i<8;i++)
			{
				for(j=0;j<2;j++)
				{
					for(k=0;k<4;k++)
					{
						strtemp=str25;
						strtemp+=String.valueOf(i+1);
						strtemp+="车";
						strtemp+="-";
						strtemp+=String.valueOf(j+1);
						strtemp+= ": ";
						strtemp+= str20[k];
						panel_for_gf_i_s[i*8+j*4+k] = new JPanel();
						label_for_gf_i_s[i*8+j*4+k] = new JLabel(strtemp);
						
						//System.out.println(i*8+j*4+k);
						
						if(k==0)
						{
							label_for_gf_i_s[i*8+j*4+k].setForeground(Color.blue);
							ComboBox_for_gf_i_s[i*8+j*4+k] = new JComboBox<String>(str21);
						}
						else if(k==1)
						{
							label_for_gf_i_s[i*8+j*4+k].setForeground(Color.red);
							ComboBox_for_gf_i_s[i*8+j*4+k] = new JComboBox<String>(str22);
						}
						else if(k==2)
						{
							label_for_gf_i_s[i*8+j*4+k].setForeground(Color.blue);
							ComboBox_for_gf_i_s[i*8+j*4+k] = new JComboBox<String>(str23);
						}
						else if(k==3)
						{
							label_for_gf_i_s[i*8+j*4+k].setForeground(Color.RED);
							ComboBox_for_gf_i_s[i*8+j*4+k] = new JComboBox<String>(str24);
						}

						panel_for_gf_i_s[i*8+j*4+k].add(label_for_gf_i_s[i*8+j*4+k]);
						panel_for_gf_i_s[i*8+j*4+k].add(ComboBox_for_gf_i_s[i*8+j*4+k]);
						//panel_for_gf_i_s[i*8+j*4+k].setBounds(100+, arg1, arg2, arg3);
						panel_for_tab[4].add(panel_for_gf_i_s[i*8+j*4+k]);
						
					}
				}
			}
		}

		{//广播系统设备状态数据
			
			
			
		}
		
//		//分割线
//		JPanel panel_for_fengexian = new JPanel();
//		//JComboBox<String>  ComboBox_for_mode = new JComboBox(str8);
//		JLabel label_for_fengexian = new JLabel("-----------------");
		//label_for_fengexian.setSize(1000, 1000);
		label_for_fengexian.setFont(f2);
		panel_for_fengexian.add(label_for_fengexian);
		//panel_for_fengexian.setSize(2000, 2000);
		//panel_for_tab[3].add(panel_for_fengexian);
		
		{
			//室外功放状态
			for(i=0;i<8;i++)
			{
				for(j=0;j<2;j++)
				{
					for(k=0;k<4;k++)
					{
						strtemp=str26;
						strtemp+=String.valueOf(i+1);
						strtemp+="车";
						strtemp+="-";
						strtemp+=String.valueOf(j+1);
						strtemp+= ": ";
						strtemp+= str20[k];
						panel_for_gf_o_s[i*8+j*4+k] = new JPanel();
						label_for_gf_o_s[i*8+j*4+k] = new JLabel(strtemp);
						if(k==0)
						{
							label_for_gf_o_s[i*8+j*4+k].setForeground(Color.blue);
							ComboBox_for_gf_o_s[i*8+j*4+k] = new JComboBox<String>(str21);
						}
						else if(k==1)
						{
							label_for_gf_o_s[i*8+j*4+k].setForeground(Color.red);
							ComboBox_for_gf_o_s[i*8+j*4+k] = new JComboBox<String>(str22);
						}
						else if(k==2)
						{
							label_for_gf_o_s[i*8+j*4+k].setForeground(Color.blue);
							ComboBox_for_gf_o_s[i*8+j*4+k] = new JComboBox<String>(str23);
						}
						else if(k==3)
						{
							label_for_gf_o_s[i*8+j*4+k].setForeground(Color.RED);
							ComboBox_for_gf_o_s[i*8+j*4+k] = new JComboBox<String>(str24);
						}

						panel_for_gf_o_s[i*8+j*4+k].add(label_for_gf_o_s[i*8+j*4+k]);
						panel_for_gf_o_s[i*8+j*4+k].add(ComboBox_for_gf_o_s[i*8+j*4+k]);
						panel_for_tab[5].add(panel_for_gf_o_s[i*8+j*4+k]);
						
					}
				}
			}
		}
		{
			int gf_i_s_ij=-1;
			int gf_i_s_iij=-1;
			for(i=0;i<64;i++)
			{
				if(i%8==0)
				{
					gf_i_s_ij+=1;
				}
				if(i%4==0)
				{
					gf_i_s_iij+=1;
				}
				//panel_for_bjq[i].setBounds(300+320*(i%3), 0+40 * (iij)+10*(ii), 300, 40);
				panel_for_gf_i_s[i].setBounds(100+320*(i%4), 0+40 * (gf_i_s_iij)+10*(gf_i_s_ij), 300, 40);
				panel_for_gf_o_s[i].setBounds(100+320*(i%4), 0+40 * (gf_i_s_iij)+10*(gf_i_s_ij), 300, 40);
			}
		}
		{//广播系统设备状态数据
		 //司机室
			for(i=0;i<2;i++)
			{
				for(j=0;j<str29.length;j++)
				{
					
						strtemp=str27;
						strtemp+=String.valueOf(i+1);
						strtemp+="-";
						strtemp+=str29[j];
						strtemp+=String.valueOf(i+1);
						strtemp+=":";
						panel_for_broadcast_device_drv_s[(i)*5+j] = new JPanel();
						label_for_broadcast_device_drv_s[(i)*5+j] = new JLabel(strtemp);
						label_for_broadcast_device_drv_s[(i)*5+j].setForeground(Color.blue);
						ComboBox_for_broadcast_device_drv_s[(i)*5+j] = new JComboBox<String>(str31);
						panel_for_broadcast_device_drv_s[(i)*5+j].add(label_for_broadcast_device_drv_s[(i)*5+j]);
						panel_for_broadcast_device_drv_s[(i)*5+j].add(ComboBox_for_broadcast_device_drv_s[(i)*5+j]);
						//
						panel_for_tab[6].add(panel_for_broadcast_device_drv_s[(i)*5+j]);
				}
			}
		}
		{//客室
			for(i=0;i<8;i++)
			{
				for(j=0;j<str30.length;j++)
				{
					strtemp=str28;
					strtemp+=String.valueOf(i+1);
					strtemp+="-";
					strtemp+=str30[j];
					strtemp+=":";
					
				//	System.out.println((i)*(str30.length)+j);
					
					panel_for_broadcast_device_pas_s[(i)*(str30.length)+j] = new JPanel();
					label_for_broadcast_device_pas_s[(i)*(str30.length)+j] = new JLabel(strtemp);
					ComboBox_for_broadcast_device_pas_s[(i)*(str30.length)+j] = new JComboBox<String>(str31);
					panel_for_broadcast_device_pas_s[(i)*(str30.length)+j].add(label_for_broadcast_device_pas_s[(i)*(str30.length)+j]);
					panel_for_broadcast_device_pas_s[(i)*(str30.length)+j].add(ComboBox_for_broadcast_device_pas_s[(i)*(str30.length)+j]);
					if(i<3)
					{
						if(((i)*(str30.length)+j)%2==0)
						{
							label_for_broadcast_device_pas_s[(i)*(str30.length)+j].setForeground(Color.RED);
						}
						else
						{
							label_for_broadcast_device_pas_s[(i)*(str30.length)+j].setForeground(Color.blue);
						}
						panel_for_tab[6].add(panel_for_broadcast_device_pas_s[(i)*(str30.length)+j]);
					
					}
					else
					{
						if(((i)*(str30.length)+j)%2==0)
						{
							label_for_broadcast_device_pas_s[(i)*(str30.length)+j].setForeground(Color.RED);
						}
						else
						{
							label_for_broadcast_device_pas_s[(i)*(str30.length)+j].setForeground(Color.blue);
						}
						panel_for_tab[7].add(panel_for_broadcast_device_pas_s[(i)*(str30.length)+j]);
					}
				}
			}
			
		}
		{
			int gf_i_s_ij=-1;
			int gf_i_s_iij=-1;
			for(i=0;i<64;i++)
			{
				if(i%8==0)
				{
					gf_i_s_ij+=1;
				}
				if(i%4==0)
				{
					gf_i_s_iij+=1;
				}
				//panel_for_bjq[i].setBounds(300+320*(i%3), 0+40 * (iij)+10*(ii), 300, 40);
				panel_for_gf_i_s[i].setBounds(100+320*(i%4), 0+40 * (gf_i_s_iij)+10*(gf_i_s_ij), 300, 40);
				panel_for_gf_o_s[i].setBounds(100+320*(i%4), 0+40 * (gf_i_s_iij)+10*(gf_i_s_ij), 300, 40);
			}
		}
		{//广播系统设备状态数据坐标
			//panel_for_broadcast_device_drv_s[(i)*5+j]
			//panel_for_broadcast_device_pas_s[(i)*(str30.length)+j]
			int for_drv_si=-1;
			int for_drv_sij=-1;
			for(i=0;i<10;i++)
			{
				if(i%5==0)
				{
					for_drv_si+=1;
				}
				panel_for_broadcast_device_drv_s[i].setBounds(20+305*(i%5), 0+45 * (for_drv_si), 300, 40);
			}
			for_drv_si=-1;
			for_drv_sij=-1;
			for(i=0;i<72;i++)
			{
				if(i%24==0)
				{
					for_drv_sij+=1;
				}
				if(i%6==0)
				{
					for_drv_si+=1;
				}
				
				panel_for_broadcast_device_pas_s[i].setBounds(25+255*(i%6), 100+45 * (for_drv_si)+20*(for_drv_sij), 250, 40);
			}
			for_drv_si=-1;
			for_drv_sij=-1;
			for(i=0;i<192-72;i++)
			{
				if(i%24==0)
				{
					for_drv_sij+=1;
				}
				if(i%6==0)
				{
					for_drv_si+=1;
				}
				
				panel_for_broadcast_device_pas_s[i+72].setBounds(25+255*(i%6), 10+38 * (for_drv_si)+8*(for_drv_sij), 250, 35);
			}
			
			
		}
		{////媒体监控系统设备状态数据--司机室
			for(i=0;i<2;i++)
			{
				for(j=0;j<str32.length;j++)
				{
					
						strtemp=str27;
						strtemp+=String.valueOf(i+1);
						strtemp+="-";
						strtemp+=str32[j];
						//strtemp+=String.valueOf(i+1);
						strtemp+=":";
						panel_for_media_device_drv_s[(i)*(str32.length)+j] = new JPanel();
						label_for_media_device_drv_s[(i)*(str32.length)+j] = new JLabel(strtemp);
						ComboBox_for_media_device_drv_s[(i)*(str32.length)+j] = new JComboBox<String>(str31);
						panel_for_media_device_drv_s[(i)*(str32.length)+j].add(label_for_media_device_drv_s[(i)*(str32.length)+j]);
						panel_for_media_device_drv_s[(i)*(str32.length)+j].add(ComboBox_for_media_device_drv_s[(i)*(str32.length)+j]);
						panel_for_tab[8].add(panel_for_media_device_drv_s[(i)*(str32.length)+j]);
				}
			}
		}
		{//媒体监控系统设备状态数据--客室
			for(i=0;i<8;i++)
			{
				for(j=0;j<str33.length;j++)
				{
					strtemp=str28;
					strtemp+=String.valueOf(i+1);
					strtemp+="-";
					strtemp+=str33[j];
					strtemp+=":";
					panel_for_media_device_pas_s[(i)*(16)+j] = new JPanel();
					label_for_media_device_pas_s[(i)*(16)+j] = new JLabel(strtemp);
					ComboBox_for_media_device_pas_s[(i)*(16)+j] = new JComboBox<String>(str31);
					panel_for_media_device_pas_s[(i)*(16)+j].add(label_for_media_device_pas_s[(i)*(16)+j]);
					panel_for_media_device_pas_s[(i)*(16)+j].add(ComboBox_for_media_device_pas_s[(i)*(16)+j]);
					if(i<3)
					{
						if(((i)*(16)+j)%2==0)
						{
							label_for_media_device_pas_s[(i)*(16)+j].setForeground(Color.RED);
						}
						else
						{
							label_for_media_device_pas_s[(i)*(16)+j].setForeground(Color.blue);
						}
						panel_for_tab[8].add(panel_for_media_device_pas_s[(i)*(16)+j]);
					
					}
					else
					{
						if(((i)*(16)+j)%2==0)
						{
							label_for_media_device_pas_s[(i)*(16)+j].setForeground(Color.RED);
						}
						else
						{
							label_for_media_device_pas_s[(i)*(16)+j].setForeground(Color.blue);
						}
						panel_for_tab[9].add(panel_for_media_device_pas_s[(i)*(16)+j]);
					}
				}
			}
		}
		{//媒体监控系统设备状态数据-坐标
			//panel_for_media_device_drv_s[(i)*(str32.length)+j]
			//panel_for_media_device_pas_s[(i)*(16)+j]
			int for_media_si=-1;
			int for_media_sij=-1;
			for(i=0;i<32;i++)
			{
				if(i%8==0)
				{
					for_media_si+=1;
				}
				if(i%16==0)
				{
					for_media_sij+=1;
				}
				panel_for_media_device_drv_s[i].setBounds(20+205*(i%8), 0+45*(for_media_si)+for_media_sij*10, 200, 40);
			}
			for_media_si=-1;
			for_media_sij=-1;
			for(i=0;i<16*3;i++)
			{
				if(i%8==0)
				{
					for_media_si+=1;
				}
				if(i%16==0)
				{
					for_media_sij+=1;
				}				
				panel_for_media_device_pas_s[i].setBounds(20+180*(i%8), 200+45*(for_media_si)+for_media_sij*10,175, 40);
			}
			for_media_si=-1;
			for_media_sij=-1;
			for(i=0;i<16*8-16*3;i++)
			{
				if(i%8==0)
				{
					for_media_si+=1;
				}
				if(i%16==0)
				{
					for_media_sij+=1;
				}				
				panel_for_media_device_pas_s[i+48].setBounds(20+180*(i%8), 0+45*(for_media_si)+for_media_sij*10,175, 40);
			}
		}
		{
			//数据使能
			for(i=0;i<str_enable.length;i++)
			{
				panel_for_en[i] = new JPanel();
				label_for_en[i] = new JLabel(str_enable[i]);
				ComboBox_for_en[i] = new JComboBox<String>(str_choose);
				if(i==0)
				{
					ComboBox_for_en[i].setSelectedIndex(0);
				}
				else
				{
					ComboBox_for_en[i].setSelectedIndex(1);
				}
				label_for_en[i].setForeground(Color.blue);
				panel_for_en[i].add(label_for_en[i]);
				panel_for_en[i].add(ComboBox_for_en[i]);		
			}
			
		}
			
		tf_for_time= new JTextField(get_date_time(), 20);
		tf_for_time.setEditable(false);
		tf_for_time.setFont(f);
		panel_for_time.add(tf_for_time);
		tf_for_time.setBackground(Color.green);
		
//		panel_for_time.setBounds(0, 0,1600,100-75);		
//		panel_for_en[0].setBounds(0,25,400,25);
//		panel_for_en[1].setBounds(0,25+25,400,25);
//		panel_for_en[2].setBounds(425,25,400,25);
//		panel_for_en[3].setBounds(425,25+25,400,25);
		
		panel_for_time.setBounds(0, 0,1600,100-70);		
		panel_for_en[0].setBounds(0,30,300,30);
		panel_for_en[1].setBounds(0,30+30,300,30);
		panel_for_en[2].setBounds(300,30,300,30);
		panel_for_en[3].setBounds(300,30+30,300,30);
		
		{
		  //手动连接tcp服务器,断开服务器,文本框
			panel_for_server_ip.add(label_for_server_ip);
			panel_for_server_ip.add(tf_for_server_ip);
			label_for_server_ip.setForeground(Color.RED);
			
			panel_for_server_connect_boolean.add(label_for_server_connect_boolean);
			panel_for_server_connect_boolean.add(tf_for_server_connect_boolean);
			label_for_server_connect_boolean.setForeground(Color.BLUE);
			
			panel_for_server_true_bt.add(button_for_server_true);
			panel_for_server_false_bt.add(button_for_server_false);
			button_for_server_true.setForeground(Color.BLUE);
			button_for_server_false.setForeground(Color.RED);
			//按钮被按下的监听事件
			button_for_server_true.addActionListener(ourListener);
			button_for_server_false.addActionListener(ourListener);
			
			panel_for_server_ip.setBounds(600, 30, 400, 30);
			panel_for_server_connect_boolean.setBounds(600, 30+30, 400, 30);
			panel_for_server_true_bt.setBounds(600+400, 30, 150, 30);
			panel_for_server_false_bt.setBounds(600+400+150, 30, 150, 30);
		}
		add(panel_for_server_ip);
		add(panel_for_server_connect_boolean);
		add(panel_for_server_true_bt);
		add(panel_for_server_false_bt);
		for(i=0;i<str_enable.length;i++)
		{
		add(panel_for_en[i]);
		}
		
		jTabbedpane.setBounds(0, 100,1600,1200);
		
		add(panel_for_time);
		add(jTabbedpane);
		
//		//开个 新线程
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() 
//			{
//				//开始解码，直至到达流的结尾或被用户终止。
//				//mp3BroadcastData.mp3Player.run();
//				//isfinish_encode=true;
//				while(true)
//				{
//					{
//					String str_cur=tf_for_station[2].getText();
//	            	String str_next=tf_for_station[3].getText();	            	
//	            	tf_for_station[2].setText(String.valueOf(Integer.parseInt(str_cur)+1));// 当前站:
//	            	tf_for_station[3].setText(String.valueOf(Integer.parseInt(str_next)+1));// 下一站:
//					}
//					try {
//						Thread.sleep(1000*4*60);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
		
//		//开个 新线程
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() 
//			{
//				while(true)
//				{
//				//开始解码，直至到达流的结尾或被用户终止。
//				//mp3BroadcastData.mp3Player.run();
//				//isfinish_encode=true;
//            	build_process_data();
//            	build_gf_status_data();
//            	build_broadcast_data();
//            	build_media_data();
//				try {
//					Thread.sleep(1000*1*1);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				}
//			}
//		}).start();
		
		   timer_change_station.scheduleAtFixedRate(new TimerTask() {
	            public void run() 
	            {	
	            	
//	            	String str_cur=tf_for_station[2].getText().trim();
//	            	String str_next=tf_for_station[3].getText().trim();	 
	            	cur_sta_num+=1;
	            	next_sta_num+=1;
	            	tf_for_station[2].setText(String.valueOf(cur_sta_num));// 当前站:
	            	tf_for_station[3].setText(String.valueOf(next_sta_num));// 下一站:

	            }
	        }, 1000*4*60, 1000*4*60);//3分钟切一次站点
		  
		   timer_refresh_data.scheduleAtFixedRate(new TimerTask() {
	            public void run() 
	            {                
	            	build_process_data();
	   //         	build_gf_status_data();
//	            	build_broadcast_data();
	  //          	build_media_data();
	            }
	        }, 1000, 1000);//3分钟切一次站点
		   timer1_refresh_data.scheduleAtFixedRate(new TimerTask() {
	            public void run() 
	            {                
	        //    	build_process_data();
	          	build_gf_status_data();
//	            	build_broadcast_data();
	  //          	build_media_data();
	            }
	        }, 1000, 1000);//3分钟切一次站点   
		   timer2_refresh_data.scheduleAtFixedRate(new TimerTask() {
	            public void run() 
	            {                
//	            	build_process_data();
//	            	build_gf_status_data();
	            	build_broadcast_data();
  //          	build_media_data();
	            }
	        }, 1000, 1000);//3分钟切一次站点		   
		   timer3_refresh_data.scheduleAtFixedRate(new TimerTask() {
	            public void run() 
	            {                
//	            	build_process_data();
//	            	build_gf_status_data();
//	            	build_broadcast_data();
	            	build_media_data();
	            }
	        }, 1000, 1000);//3分钟切一次站点		   
		   timer_for_time.scheduleAtFixedRate(new TimerTask() {
            public void run() 
            {	                
            	tf_for_time.setText(get_date_time());
            }
        }, 1000, 1000);	
}
		//str1[]报警器
		public int get_bjq_SelectedItem(JComboBox ComboBoxtemp)
		{
			int ig=0;
			while(true)
			{
				if((String)ComboBoxtemp.getSelectedItem()==str1[ig])
				{
					break;
				}
				ig++;
			}
			return  ig;
		}
		//str9[]报站模式 
		public int get_bdmsh_SelectedItem(JComboBox ComboBoxtemp)
		{
			int ibg=0;
			while(true)
			{
				if((String)ComboBoxtemp.getSelectedItem()==str8[ibg])
				{
					break;
				}
					ibg++;
			}
			return  ibg;
		}
		//str9[]司机室激活
		public int get_dr_active_SelectedItem(JComboBox ComboBoxtemp)
		{
			if((String)ComboBoxtemp.getSelectedItem()==str11[0])
					{
						return  0;
						
					}
					else
					{
						return  1;
					}
		}
		//str14[]广播有效标志
		public int get_active_SelectedItem(JComboBox ComboBoxtemp)
		{
				if((String)ComboBoxtemp.getSelectedItem()==str15[0])
					{
						return  0;
						
					}
					else
					{
						return  1;
					}
		}
		//str14[]越站
		public int get_yuezhan_SelectedItem(JComboBox ComboBoxtemp)
				{
						if((String)ComboBoxtemp.getSelectedItem()==str13[0])
							{
								return  0;
								
							}
							else
							{
								return  1;
							}
		}
		//str9[]司机室主备
		public int get_dr_zhb_SelectedItem(JComboBox ComboBoxtemp)
		{
			
				if((String)ComboBoxtemp.getSelectedItem()==str10[0])
				{
					return  0;
					
				}
				else
				{
					return  1;
				}

		
		}
		public int get_gf_status(JComboBox ComboBoxtemp)
		{
			//int i=0;

//			String str21[]={"正常","开路"};
//			String str22[]={"正常","短路"};
//			String str23[]={"正常","故障"};
//			String str24[]={"无播音","播音"};
			//if(((String)ComboBoxtemp.getSelectedItem())=="无播音")
				if(((String)ComboBoxtemp.getSelectedItem()==str24[0]))
				{
			//	 System.out.println(str24[0]+ComboBoxtemp.getName());
//					System.out.println(ComboBoxtemp.getSelectedItem());
				
					return 0;
				}
				else if((String)ComboBoxtemp.getSelectedItem()==str21[0])
				{
			//		System.out.println(str21[0]+ComboBoxtemp.getName());
					return 0;
				}
				else if((String)ComboBoxtemp.getSelectedItem()==str22[0])
				{
			//		System.out.println(str22[0]+ComboBoxtemp.getName());
					return 0;
				}
				else if((String)ComboBoxtemp.getSelectedItem()==str23[0])
				{
				//	System.out.println(str23[0]+ComboBoxtemp.getName());
					return 0;
				}
				else{
					return 1;
				}
			
		}
		public int get_bm_status(JComboBox ComboBoxtemp)
		{
			
		
			if((String)ComboBoxtemp.getSelectedItem()==str31[0])
			{
				//System.out.println((String)ComboBoxtemp.getSelectedItem()==str31[0]);
				return 0;
			}
			else
			{
				return 1;
			}

		}
		//媒体一个字节8位
		public int get_BYTE_drv(int num)
		{
			int i=0;
			int ret=0;
			if(num<4)//0-3(0-7 8-15)
			{
				for(i=0;i<8;i++)
				{
					ret+=((get_bm_status(ComboBox_for_media_device_drv_s[8*num+i]))<<(7-i));
//					System.out.print(8*(num-1)+i);
//					System.out.print(":");
//					System.out.println(get_bm_status(ComboBox_for_media_device_drv_s[8*(num-1)+i]));
					
				}			
			}
			else//4-19
			{
				for(i=0;i<8;i++)
				{
					ret+=(get_bm_status(ComboBox_for_media_device_pas_s[8*(num-4)+i])<<(7-i));
//					System.out.print(8*(num-5)+i);
//					System.out.print(":");
//					System.out.println(get_bm_status(ComboBox_for_media_device_drv_s[8*(num-5)+i]));
				}
			}
		//System.out.println(num);
			return ret;			
		}		
		public void build_process_data()
		{
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);

			int month = c.get(Calendar.MONTH);

			int date = c.get(Calendar.DATE);

			int hour = c.get(Calendar.HOUR_OF_DAY);

			int minute = c.get(Calendar.MINUTE);

			int second = c.get(Calendar.SECOND);
			//97+5;
			by[0]=0x7e;//566
			by[1]=0x01;
			by[2]=0x00;
			
			by[3]=0x61;
			by[4]=0x00;//97
			//1
			by[5]=(byte)(((get_bdmsh_SelectedItem(ComboBox_for_mode)*16)+(get_dr_zhb_SelectedItem(ComboBox_for_drv[2])*8)
					+(get_dr_zhb_SelectedItem(ComboBox_for_drv[0])*4)+(get_dr_active_SelectedItem(ComboBox_for_drv[3])*2)
					+(get_dr_active_SelectedItem(ComboBox_for_drv[1])))&0xff);//ComboBox[52]
			//
			//// checkbox[]64-71
			by[6]=(byte)(get_active_SelectedItem(ComboBox_for_active[0])*128+get_active_SelectedItem(ComboBox_for_active[1])*64+
					get_active_SelectedItem(ComboBox_for_active[2])*32+get_active_SelectedItem(ComboBox_for_active[3])*16+
					get_active_SelectedItem(ComboBox_for_active[4])*8+get_active_SelectedItem(ComboBox_for_active[5])*4+
					get_active_SelectedItem(ComboBox_for_active[6])*2+get_active_SelectedItem(ComboBox_for_active[7])*1);
			//空
			by[7]=0x00;
			//紧急广播ID 
			by[8]=(byte)(Integer.parseInt(tf_for_youxianji[str7.length-1].getText()));;
			
			//客室1
			by[9]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[0])+get_bjq_SelectedItem(ComboBox_for_bjq[1])*4+
					get_bjq_SelectedItem(ComboBox_for_bjq[2])*16+get_bjq_SelectedItem(ComboBox_for_bjq[3])*64);
			
			//System.out.println(by[5+1+3]);
			
			by[10]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[4])+get_bjq_SelectedItem(ComboBox_for_bjq[5])*4);
			//客室2
			by[11]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[6])+get_bjq_SelectedItem(ComboBox_for_bjq[7])*4+
					get_bjq_SelectedItem(ComboBox_for_bjq[8])*16+get_bjq_SelectedItem(ComboBox_for_bjq[9])*64);
			by[12]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[10])+get_bjq_SelectedItem(ComboBox_for_bjq[11])*4);
			//客室3
			by[13]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[12])+get_bjq_SelectedItem(ComboBox_for_bjq[13])*4+
					get_bjq_SelectedItem(ComboBox_for_bjq[14])*16+get_bjq_SelectedItem(ComboBox_for_bjq[15])*64);
			by[14]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[16])+get_bjq_SelectedItem(ComboBox_for_bjq[17])*4);
			//客室4
			by[15]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[18])+get_bjq_SelectedItem(ComboBox_for_bjq[19])*4+
					get_bjq_SelectedItem(ComboBox_for_bjq[20])*16+get_bjq_SelectedItem(ComboBox_for_bjq[21])*64);
			by[16]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[22])+get_bjq_SelectedItem(ComboBox_for_bjq[23])*4);
			//客室5
			by[17]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[24])+get_bjq_SelectedItem(ComboBox_for_bjq[25])*4+
					get_bjq_SelectedItem(ComboBox_for_bjq[26])*16+get_bjq_SelectedItem(ComboBox_for_bjq[27])*64);
			//2
			by[18]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[28])+get_bjq_SelectedItem(ComboBox_for_bjq[29])*4);
			//客室6
			by[19]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[30])+get_bjq_SelectedItem(ComboBox_for_bjq[31])*4+
					get_bjq_SelectedItem(ComboBox_for_bjq[32])*16+get_bjq_SelectedItem(ComboBox_for_bjq[33])*64);
			by[20]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[34])+get_bjq_SelectedItem(ComboBox_for_bjq[35])*4);
			//客室7
			by[21]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[36])+get_bjq_SelectedItem(ComboBox_for_bjq[37])*4+
					get_bjq_SelectedItem(ComboBox_for_bjq[38])*16+get_bjq_SelectedItem(ComboBox_for_bjq[39])*64);
			by[22]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[40])+get_bjq_SelectedItem(ComboBox_for_bjq[41])*4);
			//客室8
			by[23]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[42])+get_bjq_SelectedItem(ComboBox_for_bjq[43])*4+
					get_bjq_SelectedItem(ComboBox_for_bjq[44])*16+get_bjq_SelectedItem(ComboBox_for_bjq[45])*64);
			by[24]=(byte)(get_bjq_SelectedItem(ComboBox_for_bjq[46])+get_bjq_SelectedItem(ComboBox_for_bjq[47])*4);
			
			//广播控制盒话筒音量
			by[25]=(byte)(Integer.parseInt(tf_for_yinliang[0].getText()));
			//控制盒监听音量
			by[26]=(byte)(Integer.parseInt(tf_for_yinliang[1].getText()));
			//控制盒对讲监听音量
			by[27]=(byte)(Integer.parseInt(tf_for_yinliang[2].getText()));
			//3
			//中心广播音量
			by[28]=(byte)(Integer.parseInt(tf_for_yinliang[3].getText()));
			//媒体广播音量
			by[29]=(byte)(Integer.parseInt(tf_for_yinliang[4].getText()));
			
			
			//16个室内功放音量
			{
			by[30]=(byte)(Integer.parseInt(tf_for_gf_i[0].getText()));
			by[31]=(byte)(Integer.parseInt(tf_for_gf_i[1].getText()));
			by[32]=(byte)(Integer.parseInt(tf_for_gf_i[2].getText()));
			by[33]=(byte)(Integer.parseInt(tf_for_gf_i[3].getText()));
			
			by[34]=(byte)(Integer.parseInt(tf_for_gf_i[4].getText()));
			by[35]=(byte)(Integer.parseInt(tf_for_gf_i[5].getText()));
			by[36]=(byte)(Integer.parseInt(tf_for_gf_i[6].getText()));
			by[37]=(byte)(Integer.parseInt(tf_for_gf_i[7].getText()));
			//4
			by[38]=(byte)(Integer.parseInt(tf_for_gf_i[8].getText()));
			by[39]=(byte)(Integer.parseInt(tf_for_gf_i[9].getText()));
			by[40]=(byte)(Integer.parseInt(tf_for_gf_i[10].getText()));
			by[41]=(byte)(Integer.parseInt(tf_for_gf_i[11].getText()));
			
			by[42]=(byte)(Integer.parseInt(tf_for_gf_i[12].getText()));
			by[43]=(byte)(Integer.parseInt(tf_for_gf_i[13].getText()));
			by[44]=(byte)(Integer.parseInt(tf_for_gf_i[14].getText()));
			by[45]=(byte)(Integer.parseInt(tf_for_gf_i[15].getText()));
			}
			//紧急报警器话筒音量
			by[46]=(byte)(Integer.parseInt(tf_for_yinliang[5].getText()));
			//紧急报警器对讲监听音量
			by[47]=(byte)(Integer.parseInt(tf_for_yinliang[6].getText()));
			//5
			//报站广播音量
			by[48]=(byte)(Integer.parseInt(tf_for_yinliang[7].getText()));
			//关门音音量
			by[49]=(byte)(Integer.parseInt(tf_for_yinliang[8].getText()));
			//紧急广播音量
			by[50]=(byte)(Integer.parseInt(tf_for_yinliang[9].getText()));
			//测试广播音量
			by[51]=(byte)(Integer.parseInt(tf_for_yinliang[10].getText()));
			//未命名音量1
			by[52]=(byte)(Integer.parseInt(tf_for_yinliang[11].getText()));
			//16个室外功放音量
			{
			by[53]=(byte)(Integer.parseInt(tf_for_gf_o[0].getText()));
			by[54]=(byte)(Integer.parseInt(tf_for_gf_o[1].getText()));
			by[55]=(byte)(Integer.parseInt(tf_for_gf_o[2].getText()));
			by[56]=(byte)(Integer.parseInt(tf_for_gf_o[3].getText()));
			by[57]=(byte)(Integer.parseInt(tf_for_gf_o[4].getText()));
			//6
			by[58]=(byte)(Integer.parseInt(tf_for_gf_o[5].getText()));
			by[59]=(byte)(Integer.parseInt(tf_for_gf_o[6].getText()));
			by[60]=(byte)(Integer.parseInt(tf_for_gf_o[7].getText()));
			by[61]=(byte)(Integer.parseInt(tf_for_gf_o[8].getText()));
			by[62]=(byte)(Integer.parseInt(tf_for_gf_o[9].getText()));
			by[63]=(byte)(Integer.parseInt(tf_for_gf_o[10].getText()));
			by[64]=(byte)(Integer.parseInt(tf_for_gf_o[11].getText()));
			by[65]=(byte)(Integer.parseInt(tf_for_gf_o[12].getText()));
			by[66]=(byte)(Integer.parseInt(tf_for_gf_o[13].getText()));
			by[67]=(byte)(Integer.parseInt(tf_for_gf_o[14].getText()));
			//7
			by[68]=(byte)(Integer.parseInt(tf_for_gf_o[15].getText()));
			}
			//未命名音量2
			by[69]=(byte)(Integer.parseInt(tf_for_yinliang[12].getText()));
			//未命名音量3
			by[70]=(byte)(Integer.parseInt(tf_for_yinliang[13].getText()));
		{	
			//OCC广播优先级
			by[71]=(byte)(Integer.parseInt(tf_for_youxianji[0].getText()));
			//列车话筒广播优先级
			by[72]=(byte)(Integer.parseInt(tf_for_youxianji[1].getText()));
			//列车紧急广播优先级
			by[73]=(byte)(Integer.parseInt(tf_for_youxianji[2].getText()));
			//列车报站广播优先级
			by[74]=(byte)(Integer.parseInt(tf_for_youxianji[3].getText()));
			//关门提示音广播优先级
			by[75]=(byte)(Integer.parseInt(tf_for_youxianji[4].getText()));
			//测试广播优先级
			by[76]=(byte)(Integer.parseInt(tf_for_youxianji[5].getText()));
			//媒体广播优先级
			by[77]=(byte)(Integer.parseInt(tf_for_youxianji[6].getText()));
			//8
			//OCC-TPA话筒广播优先级
			by[78]=(byte)(Integer.parseInt(tf_for_youxianji[7].getText()));
			//OCC-TPA紧急广播优先级
			by[79]=(byte)(Integer.parseInt(tf_for_youxianji[8].getText()));
			//未命名优先级1
			by[80]=(byte)(Integer.parseInt(tf_for_youxianji[9].getText()));
			//未命名优先级2
			by[81]=(byte)(Integer.parseInt(tf_for_youxianji[10].getText()));
			//未命名优先级3
			by[82]=(byte)(Integer.parseInt(tf_for_youxianji[11].getText()));
		}
			//站信息	
//			by[83]=(byte)(Integer.parseInt(tf_for_station[0].getText().trim()));
//			by[84]=(byte)(Integer.parseInt(tf_for_station[1].getText().trim()));
//			by[85]=(byte)(Integer.parseInt(tf_for_station[2].getText().trim()));
//			by[86]=(byte)(Integer.parseInt(tf_for_station[3].getText().trim()));
			
			by[83]=(byte)(start_sta_num);
			by[84]=(byte)(end_sta_num);
			by[85]=(byte)(cur_sta_num);
			by[86]=(byte)(next_sta_num);
			
			{
			//越站与否
			by[87]=(byte)(get_yuezhan_SelectedItem(ComboBox_for_yuezhan[7])*128+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[6])*64+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[5])*32+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[4])*16+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[3])*8+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[2])*4+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[1])*2+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[0])*1);
			
			//9
			by[88]=(byte)(get_yuezhan_SelectedItem(ComboBox_for_yuezhan[15])*128+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[14])*64+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[13])*32+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[12])*16+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[11])*8+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[10])*4+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[9])*2+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[8])*1);
			
			by[89]=(byte)(get_yuezhan_SelectedItem(ComboBox_for_yuezhan[23])*128+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[22])*64+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[21])*32+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[20])*16+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[19])*8+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[18])*4+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[17])*2+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[16])*1);
			
			by[90]=(byte)(get_yuezhan_SelectedItem(ComboBox_for_yuezhan[31])*128+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[30])*64+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[29])*32+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[28])*16+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[27])*8+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[26])*4+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[25])*2+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[24])*1);
			
			by[91]=(byte)(get_yuezhan_SelectedItem(ComboBox_for_yuezhan[39])*128+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[38])*64+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[37])*32+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[36])*16+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[35])*8+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[34])*4+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[33])*2+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[32])*1);
			
			by[92]=(byte)(get_yuezhan_SelectedItem(ComboBox_for_yuezhan[47])*128+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[46])*64+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[45])*32+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[44])*16+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[43])*8+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[42])*4+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[41])*2+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[40])*1);
			
			by[93]=(byte)(get_yuezhan_SelectedItem(ComboBox_for_yuezhan[55])*128+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[54])*64+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[53])*32+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[52])*16+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[51])*8+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[50])*4+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[49])*2+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[48])*1);
			
			by[94]=(byte)(get_yuezhan_SelectedItem(ComboBox_for_yuezhan[63])*128+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[62])*64+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[61])*32+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[60])*16+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[59])*8+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[58])*4+
					get_yuezhan_SelectedItem(ComboBox_for_yuezhan[57])*2+get_yuezhan_SelectedItem(ComboBox_for_yuezhan[56])*1);
			}
						
			//日期时间
			//10
			//年（低字节）
			by[95]=(byte)(year%100);
			//年（高字节）
			by[96]=(byte)(year/100);
			
			by[97]=(byte)(month+1);
			
			by[98]=(byte)(date);
			
			by[99]=(byte)(hour);
			
			by[100]=(byte)(minute);
			
			by[101]=(byte)(second);

		}	
	public void build_gf_status_data()
	{
//		2的2次方 4
//		2的3次方 8	
//		2的4次方 16
//		2的5次方 32
//		2的6次方 64
//		2的7次方 128
		int i=0;
		//by_for_gf
		by_for_gf[0]=0x7e;//566
		by_for_gf[1]=0x05;
		by_for_gf[2]=0x00;
		
		by_for_gf[3]=0x20;
		by_for_gf[4]=0x00;//97
		
		for(i=0;i<16;i++)
		{
			//System.out.println(String.valueOf(i)+"::1");
			by_for_gf[5+i]=(byte)((get_gf_status(ComboBox_for_gf_i_s[i*4+0])*8)+
					(get_gf_status(ComboBox_for_gf_i_s[i*4+1])*4)+
					(get_gf_status(ComboBox_for_gf_i_s[i*4+2])*2)+
					(get_gf_status(ComboBox_for_gf_i_s[i*4+3])*1));
			

		}

		for(i=0;i<16;i++)
		{
			by_for_gf[5+i+16]=(byte)((get_gf_status(ComboBox_for_gf_o_s[i*4+0])*8)+
					(get_gf_status(ComboBox_for_gf_o_s[i*4+1])*4)+
					(get_gf_status(ComboBox_for_gf_o_s[i*4+2])*2)+
					(get_gf_status(ComboBox_for_gf_o_s[i*4+3])*1));
		}
		
	}
	public void build_broadcast_data()
	{
		int ib=0;
		int k=0;
		int j=0;
		int temp=0;
		int tem=0;
//		int tem_off1=0;
//		int tem_off2=0;
//		int tem_off3=0;
//		int tem_off4=0;
//		int tem_off5=0;
//		int tem_off6=0;
		for(ib=0;ib<5;ib++)
		{
			temp+=((get_bm_status(ComboBox_for_broadcast_device_drv_s[ib]))<<(4-ib));
		}
		for(ib=0;ib<5;ib++)
		{
			tem+=((get_bm_status(ComboBox_for_broadcast_device_drv_s[ib+5]))<<(4-ib));
		}
//		for(ib=0;ib<6;ib++)
//		{
//			tem_off1+=((get_bm_status(ComboBox_for_broadcast_device_pas_s[ib]))<<(5-ib));
//		}
		
		//by_for_gf
		by_for_broadcast[0]=0x7e;//566
		by_for_broadcast[1]=0x06;
		by_for_broadcast[2]=0x00;
		
		by_for_broadcast[3]=0x32;
		by_for_broadcast[4]=0x00;//97
		//司机室
		by_for_broadcast[5+0]=(byte)(temp);//get_broadcast_media_status
		by_for_broadcast[5+1]=(byte)(tem);//97
		//客室

		by_for_broadcast[5+2]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[0])<<5)
				+(get_bm_status(ComboBox_for_broadcast_device_pas_s[1])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[2])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[3])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[4])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[5])));		
		by_for_broadcast[5+3]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[6])<<7)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[7])<<6)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[8])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[9])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[10])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[11])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[12])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[13])));
		by_for_broadcast[5+4]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[14])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[15])));
		by_for_broadcast[5+5]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[16])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[17])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[18])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[19])));
		
		by_for_broadcast[5+6]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[20])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[21])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[22])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[23])));
		by_for_broadcast[5+7]=0x00;
		
		by_for_broadcast[5+2+6]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[0+24])<<5)
				+(get_bm_status(ComboBox_for_broadcast_device_pas_s[1+24])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[2+24])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[3+24])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[4+24])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[5+24])));		
		by_for_broadcast[5+3+6]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[6+24])<<7)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[7+24])<<6)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[8+24])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[9+24])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[10+24])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[11+24])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[12+24])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[13+24])));
		by_for_broadcast[5+4+6]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[14+24])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[15+24])));
		by_for_broadcast[5+5+6]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[16+24])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[17+24])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[18+24])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[19+24])));
		
		by_for_broadcast[5+6+6]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[20+24])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[21+24])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[22+24])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[23+24])));
		by_for_broadcast[5+7+6]=0x00;
		
		by_for_broadcast[5+2+12]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[0+48])<<5)
				+(get_bm_status(ComboBox_for_broadcast_device_pas_s[1+48])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[2+48])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[3+48])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[4+48])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[5+48])));		
		by_for_broadcast[5+3+12]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[6+48])<<7)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[7+48])<<6)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[8+48])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[9+48])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[10+48])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[11+48])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[12+48])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[13+48])));
		by_for_broadcast[5+4+12]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[14+48])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[15+48])));
		by_for_broadcast[5+5+12]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[16+48])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[17+48])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[18+48])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[19+48])));
		
		by_for_broadcast[5+6+12]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[20+48])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[21+48])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[22+48])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[23+48])));
		by_for_broadcast[5+7+12]=0x00;
		
		by_for_broadcast[5+2+18]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[0+72])<<5)
				+(get_bm_status(ComboBox_for_broadcast_device_pas_s[1+72])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[2+72])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[3+72])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[4+72])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[5+72])));		
		by_for_broadcast[5+3+18]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[6+72])<<7)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[7+72])<<6)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[8+72])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[9+72])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[10+72])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[11+72])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[12+72])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[13+72])));
		by_for_broadcast[5+4+18]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[14+72])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[15+72])));
		by_for_broadcast[5+5+18]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[16+72])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[17+72])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[18+72])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[19+72])));
		
		by_for_broadcast[5+6+18]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[20+72])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[21+72])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[22+72])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[23+72])));
		by_for_broadcast[5+7+18]=0x00;
		
		by_for_broadcast[5+2+24]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[0+96])<<5)
				+(get_bm_status(ComboBox_for_broadcast_device_pas_s[1+96])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[2+96])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[3+96])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[4+96])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[5+96])));		
		by_for_broadcast[5+3+24]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[6+96])<<7)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[7+96])<<6)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[8+96])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[9+96])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[10+96])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[11+96])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[12+96])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[13+96])));
		by_for_broadcast[5+4+24]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[14+96])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[15+96])));
		by_for_broadcast[5+5+24]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[16+96])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[17+96])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[18+96])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[19+96])));
		
		by_for_broadcast[5+6+24]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[20+96])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[21+96])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[22+96])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[23+96])));
		by_for_broadcast[5+7+24]=0x00;
		
		by_for_broadcast[5+2+30]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[0+120])<<5)
				+(get_bm_status(ComboBox_for_broadcast_device_pas_s[1+120])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[2+120])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[3+120])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[4+120])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[5+120])));		
		by_for_broadcast[5+3+30]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[6+120])<<7)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[7+120])<<6)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[8+120])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[9+120])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[10+120])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[11+120])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[12+120])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[13+120])));
		by_for_broadcast[5+4+30]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[14+120])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[15+120])));
		by_for_broadcast[5+5+30]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[16+120])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[17+120])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[18+120])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[19+120])));
		
		by_for_broadcast[5+6+30]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[20+120])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[21+120])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[22+120])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[23+120])));
		by_for_broadcast[5+7+30]=0x00;
		
		by_for_broadcast[5+2+36]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[0+144])<<5)
				+(get_bm_status(ComboBox_for_broadcast_device_pas_s[1+144])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[2+144])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[3+144])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[4+144])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[5+144])));		
		by_for_broadcast[5+3+36]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[6+144])<<7)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[7+144])<<6)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[8+144])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[9+144])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[10+144])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[11+144])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[12+144])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[13+144])));
		by_for_broadcast[5+4+36]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[14+144])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[15+144])));
		by_for_broadcast[5+5+36]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[16+144])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[17+144])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[18+144])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[19+144])));
		
		by_for_broadcast[5+6+36]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[20+144])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[21+144])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[22+144])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[23+144])));
		by_for_broadcast[5+7+36]=0x00;
		
		by_for_broadcast[5+2+42]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[0+168])<<5)
				+(get_bm_status(ComboBox_for_broadcast_device_pas_s[1+168])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[2+168])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[3+168])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[4+168])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[5+168])));		
		by_for_broadcast[5+3+42]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[6+168])<<7)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[7+168])<<6)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[8+168])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[9+168])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[10+168])<<3)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[11+168])<<2)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[12+168])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[13+168])));
		by_for_broadcast[5+4+42]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[14+168])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[15+168])));
		by_for_broadcast[5+5+42]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[16+168])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[17+168])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[18+168])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[19+168])));
		
		by_for_broadcast[5+6+42]=(byte)((get_bm_status(ComboBox_for_broadcast_device_pas_s[20+168])<<5)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[21+168])<<4)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[22+168])<<1)+
				(get_bm_status(ComboBox_for_broadcast_device_pas_s[23+168])));
		by_for_broadcast[5+7+42]=0x00;
	}
	public void build_media_data()
	{
		int im=0;
		//by_for_gf
		by_for_media[0]=0x7e;//566
		by_for_media[1]=0x07;
		by_for_media[2]=0x00;
		
		by_for_media[3]=0x14;
		by_for_media[4]=0x00;//97
		
//		by_for_media[4+1]=0x00;
//		by_for_media[6]=0x14;//97
//		by_for_media[7]=0x00;
//		by_for_media[8]=0x14;//97
		for(im=0;im<20;im++) //0-3//4-19
		{
			by_for_media[5+im]=(byte)(get_BYTE_drv(im));
		}
		
	}	

	public String get_date_time() {
		String str18="";
		Calendar cd = Calendar.getInstance();
		int yeard = cd.get(Calendar.YEAR);

		int monthd = cd.get(Calendar.MONTH);

		int dated = cd.get(Calendar.DATE);

		int hourd = cd.get(Calendar.HOUR_OF_DAY);

		int minuted = cd.get(Calendar.MINUTE);

		int secondd = cd.get(Calendar.SECOND);
		// 通过Calendar类来获取当前时间
//		System.out.println(year + "/" + month + "/" + date + " " + hour + ":"
//				+ minute + ":" + second);
		
		str18+=String.valueOf(yeard);
		str18+="-";		
		str18+=String.valueOf(monthd+1);
		str18+="-";
		str18+=String.valueOf(dated);
		str18+="  ";
		str18+=String.valueOf(hourd);
		str18+=":";
		str18+=String.valueOf(minuted);
		str18+=":";
		str18+=String.valueOf(secondd);
		//System.out.println(month);
		//System.out.println(str18);

		return str18;
	}
	
	public static  void setText_for_tf_for_braodcast()
	{
		tf_for_braodcast.setText(str19);
	}
	public static  void setText_for_tf_for_talk()
	{
		tf_for_talk.setText(str35);
	}
//	public static void set_dir_path(String str)
//	{
//		
//	}
	
	public void choose_dir(int num)
	{
		FileFilterTest fileFilter=new FileFilterTest ();  //创建过滤器对象
		JFileChooser jf=new JFileChooser(new File("d:\\"));
		//JFileChooser jf=new JFileChooser(new File("e:\\zzz"));
		jf.addChoosableFileFilter(fileFilter);
		jf.setFileFilter(fileFilter);   //对JFileChooser设置过滤器
		String path=null;
		File f=null;
		System.out.println(str43=="");
		System.out.println(str44=="");
		System.out.println("str43_before_choose:"+str43);
		System.out.println("str44_before_choose:"+str44);
		if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			f=jf.getSelectedFile();
	    	path=f.getPath();
	    	if(num==0)
	    	{
	    		str43=path;
	    	}
	    	else if(num==1)
	    	{
	    		str44=path;
	    	}
	    	System.out.println("str43_after_choose:"+str43);
			System.out.println("str44_after_choose:"+str44);
		}
	}
	public class FileFilterTest extends javax.swing.filechooser.FileFilter{
	
		public boolean accept(java.io.File f) {
			String name = f.getName();
			if (f.isDirectory())return true;
			return f.getName().endsWith(".mp3");  //设置为选择以.class为后缀的文件
			//return f.getName().endsWith(".class");  //设置为选择以.class为后缀的文件
			//return f.isDirectory() || name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".mp3");
		}
		public String getDescription(){
			return ".mp3";
			//return ".class";
		}		
	}	
	public class SimpleListener implements ActionListener
	{
		     /**
		  　　 * 利用该内部类来监听所有事件源产生的事件
		   　 * 便于处理事件代码模块化
		   　 */
			public void actionPerformed(ActionEvent e){

//		  　　 // 利用getActionCommand获得按钮名称
//		  　　 // 也可以利用getSource()来实现
//		  　　 // if (e.getSource() ==button1)

		String buttonName = e.getActionCommand();
		if (buttonName.equals("对讲音频开始"))
		{
			tf_for_talk.setText(str34);	
//			if(str44!=null)
//			{
//				System.out.println(str43.getName());
//			}
			System.out.println(str44);
			ServletBroadcast02.startBroadcastMp3(str44,1);
			System.out.println(buttonName);
		}
		else if (buttonName.equals("预录制广播"))
		{
			tf_for_braodcast.setText(str18);
//			if(str43!=null)
//			{
//				System.out.println(str43.getName());
//			}
			//System.out.println(ui);
			ServletBroadcast01.startBroadcastMp3(str43,0);
			System.out.println(buttonName);
		}
		
		else if (buttonName.equals("对讲音频停止"))
		{
			tf_for_talk.setText(str35);
		ServletBroadcast02.stopBroadcastMp3(1);
			System.out.println(buttonName);
		}
		else if (buttonName.equals("停止广播"))
		{
			tf_for_braodcast.setText(str19);
		ServletBroadcast01.stopBroadcastMp3(0);
			 System.out.println(buttonName);
		}
		else if (buttonName.equals("设置站信息"))
		{
			start_sta_num=Integer.parseInt(tf_for_station[0].getText().trim());
			end_sta_num=Integer.parseInt(tf_for_station[1].getText().trim());
			cur_sta_num=Integer.parseInt(tf_for_station[2].getText().trim());
			next_sta_num=Integer.parseInt(tf_for_station[3].getText().trim());
			System.out.println(buttonName);
		}
		else if (buttonName.equals("预录制广播选择"))
		{
			System.out.println(buttonName);
			choose_dir(0);
		
		}
		else if (buttonName.equals("对讲音频选择"))
		{
			System.out.println(buttonName);
			choose_dir(1);
		}
		else if (buttonName.equals("连接tcp服务器"))
		{
			System.out.println(buttonName+"::");
			tf_for_server_ip.getText();
			System.out.println(":"+tf_for_server_ip.getText()+":");
			if (t!= null)
			{
				tcpclass.iscontinue=false;
			}
			else
			{
				tcpclass.iscontinue=true;
			}
			System.out.println(tcpclass.iscontinue+":::");
			if(tf_for_server_ip.getText().equals(""))
			{

				tf_for_server_connect_boolean.setText("没有ip地址");
			}
			else
			{
				t=new tcpclass(tf_for_server_ip.getText());
				t.start();
				tf_for_server_connect_boolean.setText(str46);
			}
			
			//choose_dir(1);
		}
		else if (buttonName.equals("断开tcp服务器"))
		{
			System.out.println(buttonName+"::");
			if (t!= null)
			{
				tcpclass.iscontinue=false;
			}
//			else
//			{
//				tcpclass.iscontinue=true;
//			}
			t = null;
			tf_for_server_connect_boolean.setText(str47);
//			choose_dir(1);
		}
		else
		{			
//			System.out.println(buttonName);
			System.out.println("Unknown event");
		}
		
	}
	
}
	
	/**
	 * @param args
	 */
	static ServletBroadcast ServletBroadcast01 = null;
	static ServletBroadcast ServletBroadcast02 = null;	
	static tcpclass t=null;
	public static void main(String[] args) {
		
		try {
			ServletBroadcast01 = new ServletBroadcast();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ServletBroadcast02 = new ServletBroadcast();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
 
		public void run() {
				//JFrame.setDefaultLookAndFeelDecorated(true);// 将组建外观设置为Java外观
				JFrame frame = new JFrame();
//				BufferedImage image = null;
				frame.setLayout(null);
				frame.setContentPane(new ui());
				frame.setBounds(100, 20,1600,1000);
				//frame.setBounds(200, -10,1600,1000);
				//frame.setBounds(400, -10,800,800);
				//frame.setSize(1500, 1500);
				frame.setVisible(true);
				frame.setTitle("1.0.0.8");
//				try {
//					image = ImageIO.read(frame.getClass()
//							.getResource("bitbug_favico.ico"));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				frame.setIconImage(image);

////				this.setBackground(Color.blue);
//				frame.getContentPane().setBackground(Color.BLUE);
//				frame.getContentPane().setVisible(true);				
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);				
				frame.addWindowListener(new WindowAdapter()
				{
					public void JFClose(WindowEvent w)
					{
						System.exit(0);
					};
				});
				
				
				
				
			}
			});
		
		  
		 //Thread t=new tcpclass(); 
		 //t.start();//
		
		
	}


	
 

	

}
