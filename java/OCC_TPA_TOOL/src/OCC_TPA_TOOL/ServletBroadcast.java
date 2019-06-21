package OCC_TPA_TOOL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;//udp
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

//import net.sf.json.JSONObject;










import OCC_TPA_TOOL.AudioFrequencyProducer;
import OCC_TPA_TOOL.SleepClass;
import OCC_TPA_TOOL.Audio;
import OCC_TPA_TOOL.MiniPlayer;
import OCC_TPA_TOOL.Mp3ToWav;

//import com.beihai.occtpa.tables.UserInfoTable;


class Mp3BroadcastDataClass
{
	public boolean stop = false;
	public MiniPlayer mp3Player = null;
	public Mp3ToWav mp3ToWav = null;
}
/**
 * Servlet implementation class ServletBroadcast
 */
//@WebServlet("/ServletBroadcast")
public class ServletBroadcast extends DatagramSocket {

	//public class ServletBroadcast extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	static public byte[] audio_by=new byte[1024+2+5];
	static public byte[] audio_by_talk=new byte[1024+2+5];
	
	public static Map<String, Mp3BroadcastDataClass> mp3PlayerMap = new HashMap<String, Mp3BroadcastDataClass>();

	Mp3BroadcastDataClass mp3BroadcastData = new Mp3BroadcastDataClass();
	 DatagramSocket ds = null;
	 DatagramSocket ds_talk = null;
	 //DatagramSocket ds = new DatagramSocket(5555);
     DatagramPacket dp = null;
     DatagramPacket dp_talk = null;
     File file=null;
	/**
     * @see HttpServlet#HttpServlet()
     */
     public ServletBroadcast() throws SocketException {
 		super();
 		
	    try {
			ds = new DatagramSocket();//发送端自己的端口号
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	    	ds_talk = new DatagramSocket();//发送端自己的端口号
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		// TODO Auto-generated constructor stub
 	}

    public void udp_send()
    {


				audio_by[0]=(byte)0x7e;
		    	audio_by[1]=(byte)0x01;//0x0101
		    	audio_by[2]=(byte)0x01;
		    	audio_by[3]=(byte)0x02;
		    	audio_by[4]=(byte)0x04;
		    	
		    	audio_by[5]=(byte)0x10;
		    	audio_by[6]=(byte)0x01;		    	
		    	//InetAddress.getLocalHost()
		            try {
						dp = new DatagramPacket(audio_by, audio_by.length,
								InetAddress.getLocalHost(),51000);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//接收端接收端口号
		            // 发出数据报
		            try {
		            	
						ds.send(dp);
						
//						   try {
//								System.out.println(InetAddress.getLocalHost()+"udp");
//							} catch (UnknownHostException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         
    }
    public void udp_send_talk()
    {
    		//0x0102
				audio_by_talk[0]=(byte)0x7e;
		    	audio_by_talk[1]=(byte)0x02;//0x0101
		    	audio_by_talk[2]=(byte)0x01;
		    	
		    	audio_by_talk[3]=(byte)0x02;
		    	audio_by_talk[4]=(byte)0x04;
		    	
		    	audio_by_talk[5]=(byte)(Integer.parseInt((String)ui.ComboBox_for_talk_choose[0].getSelectedItem()));
		    	audio_by_talk[6]=(byte)(Integer.parseInt((String)ui.ComboBox_for_talk_choose[1].getSelectedItem()));		    	
		    	//InetAddress.getLocalHost()
		            try {
						dp_talk = new DatagramPacket(audio_by_talk, audio_by_talk.length,
								InetAddress.getLocalHost(),52000);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//接收端接收端口号
		            // 发出数据报
		            try {
		            	
						ds_talk.send(dp_talk);
						
//						   try {
//								System.out.println(InetAddress.getLocalHost()+"udp");
//							} catch (UnknownHostException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
    }
    
    
    public void udp_close()
    {
    	//ds.close();
    	System.out.println("----udp_close---");
    }


	public void startBroadcastMp3(String strtemp,int num)  {
		String username =String.valueOf(num);
		String mp3 = "d:\\test.mp3";
//		System.out.println(strte+"!??!!!!!");
//		//String username =String.valueOf(num);		
//		String strtmp=strte.trim();
//		//String strtemp=strtmp.toLowerCase();
//		String strtemp=strtmp;
//		System.out.println(num+"??!!!!!");
//		System.out.println(strtemp+"!??!!!!!");
		if(strtemp!="")
		{	
			//System.out.println(strtemp.getPath());
			//mp3=strtemp;
			// file = new File(strtemp); 
			System.out.println(strtemp);
		}
		else
		{
			System.out.println((strtemp==""));
		}
		//System.out.println(mp3);

		
		
		String wav = null; //"c:\\test.wav";
			

		mp3BroadcastData = mp3PlayerMap.get(username);
		//看当前是不是正在进行紧急广播???,如果是就停了???
		if (mp3BroadcastData != null)
		{
			mp3BroadcastData.stop = true;
			if (mp3BroadcastData.mp3Player != null)
				mp3BroadcastData.mp3Player.stop();
			if (mp3BroadcastData.mp3ToWav != null && mp3BroadcastData.mp3ToWav.audioList != null)
			{
				mp3BroadcastData.mp3ToWav.audioList.clear();
				//System.out.println("???");
			}
			mp3BroadcastData.mp3ToWav = null;
			mp3BroadcastData.mp3Player = null;
			mp3BroadcastData = null;
			mp3PlayerMap.remove(username);
		}	

		//mp3BroadcastData.mp3ToWav.audioList.size()

		
		mp3BroadcastData = new Mp3BroadcastDataClass();
		mp3BroadcastData.mp3ToWav = new Mp3ToWav(wav); 
		mp3BroadcastData.mp3Player = new MiniPlayer(null, mp3BroadcastData.mp3ToWav);
		
		// 打开输入流并初始化解码器。
		try {
			
			if((strtemp!=""))
			{
				System.out.println(strtemp);
				mp3BroadcastData.mp3Player.open(strtemp);
				
			}
			else
			{
				mp3BroadcastData.mp3Player.open(mp3);
				System.out.println(mp3);
			}		
			
			//String ss = mp3BroadcastData.mp3Player.open(mp3);
			
			//System.out.println(ss);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//开个 新线程
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				//开始解码，直至到达流的结尾或被用户终止。
				mp3BroadcastData.mp3Player.run();
				//isfinish_encode=true;
			}
		}).start();
		
		new Thread(new Runnable()
		{
			public void run()
			{
				AudioFrequencyProduceThreadClass ap=new AudioFrequencyProduceThreadClass();
				ap.run();
			}
		}).start();
		
		
		//再开个线程
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				//延时1秒
				SleepClass.sleep_ms(2000); //等待解码出一定数据
				try {
					//打开文件，在文件的尾部追加写入数据
					FileOutputStream writer = new FileOutputStream("d:\\sssaa.wav", true);
					//从指定的字节数组开始到该文件输出流关闭写入len字节。
					//写一个字节数组
					writer.write(new byte[44]);
					
					//pcm开始处理
					Calendar calendar = Calendar.getInstance();
					System.out.println(calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + "." + calendar.get(Calendar.MILLISECOND) + "---pcm 处理开始!");
					
					int number_record = 0;
					
//					System.out.print("1:");
//					System.out.println(mp3BroadcastData != null);
//					System.out.print("2:");
//					System.out.println(mp3BroadcastData.stop == false);
					
					while (mp3BroadcastData != null && mp3BroadcastData.stop == false)
					{
//						System.out.print("3:");
//						System.out.println(mp3BroadcastData.mp3ToWav != null);
						
						if (mp3BroadcastData.mp3ToWav != null)
						{
							int count = 0;
							int number = AudioFrequencyProducer.SerialNumber;
							if (number > number_record)
							{
								count = (number - number_record > 5 ? 1 : number - number_record);
							}
							else if (number < number_record)
							{
								count = (number + AudioFrequencyProducer.SerialNumber - number_record > 5 ? 1 : number + AudioFrequencyProducer.SerialNumber - number_record);
							}
							else 
							{
								SleepClass.sleep_ms(1);
							}
							number_record = number;
							
//							System.out.print("4:");
//							System.out.println(count);
							
							while (count > 0)
							{
//								System.out.print("5:");
//								System.out.println(mp3BroadcastData.mp3ToWav.audioList.size());
								
								if (mp3BroadcastData.mp3ToWav.audioList.size() > 0)
								{
									byte[] data = mp3BroadcastData.mp3ToWav.audioList.remove(0);
									//writer.write(data);
									
									if(num==0)
									{
										//System.out.println(num+"udp_send");
										
										//发送广播
										System.arraycopy(data, 0, audio_by, 7, data.length);									
										udp_send();
									}
									else if(num==1)
									{
										//发送对讲
										//System.out.println(num+"udp_send_talk");
										
										System.arraycopy(data, 0, audio_by_talk, 7, data.length);									
										udp_send_talk();
									}
									else
									{
										System.out.println(num);
									}
										
									
						            
								}
								count--;
								//System.out.println(count);
							}
							
							if (mp3BroadcastData.mp3ToWav.audioList.size() == 0)
							{
								//System.out.println("mp3BroadcastData.mp3ToWav.audioList.size() == 0");
								break;
							}
						}
						//System.out.println("---pcming---");
					}
					//pcm处理完成
					writer.close();
					mp3BroadcastData.mp3Player.layer = null; //等待pcm数据处理完成后，再释放！
					
					calendar = Calendar.getInstance();
					System.out.println(calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + "." + calendar.get(Calendar.MILLISECOND) + "---pcm 处理完成!");
					//ui.
					if(num==0)
					{
						 ui.setText_for_tf_for_braodcast();
						  System.out.println("udp_send");
				            
					}
					else if(num==1)
					{
						ui.setText_for_tf_for_talk();
						 System.out.println("udp_send_talk");
					}
					else
					{
						
					}
//					udp_close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		//播放完了设置按钮可以点击
		
		//hashmap.put();放到哈希表里
		mp3PlayerMap.put(username, mp3BroadcastData);
		System.out.println("---end---");
		

	}
	public void stopBroadcastMp3(int num) {

		String username = String.valueOf(num);
		
		mp3BroadcastData = mp3PlayerMap.get(username);
		if(mp3BroadcastData != null)
		{
			mp3BroadcastData.stop = true;
			if (mp3BroadcastData.mp3Player != null)
				mp3BroadcastData.mp3Player.stop();
			if (mp3BroadcastData.mp3ToWav != null && mp3BroadcastData.mp3ToWav.audioList != null)
				mp3BroadcastData.mp3ToWav.audioList.clear();
			mp3BroadcastData.mp3ToWav = null;
			mp3BroadcastData.mp3Player = null;
			mp3BroadcastData = null;
			mp3PlayerMap.remove(username);
			//udp_close();
			System.out.println("stopBroadcastMp3--end--");
			//udp_close();
		}	
		

	}
	
//		public static void main(String[] args) throws Exception {
//			
//			ServletBroadcast ServletBroadcast01 =new ServletBroadcast();
//			
//			ServletBroadcast01.startBroadcastMp3();
//			//ServletBroadcast01.udp_send();
//		}
	
	
	
}
