package OCC_TPA_TOOL;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.OutputStream;
import java.net.InetAddress; 
//import org.omg.CORBA.portable.OutputStream;

import java.net.UnknownHostException;

import javax.swing.JTextArea;
import javax.swing.JFrame;

import java.io.IOException;
import java.io.PrintWriter;

public class tcpclass extends Thread
{
	//private Socket socket=null;
	 
		//String ip="192.168.106.148";
		int port =50000;		
		int i=0;
		//Socket socket = new Socket();
		Socket socket5 = new Socket();
		OutputStream outS5 = null;
		static public boolean iscontinue=true;
		public  tcpclass(String ip) 
		{
//			当多个线程同时进行Socket通信时,如果只为他们开了一个Socket且公用,
//			势必造成资源冲突,因此最好为每一个线程都开一个Socket,
//			避免相互之间产生冲突.这样做有效提高了发送效率,也不会再报异常.
			{
				
				try {//连接服务器
					socket5 = new Socket(ip,port);
//					socket5.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
					//socket5.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				   
				try {
					outS5 = socket5.getOutputStream();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
			
			{			
//			//开个 新线程1
//			new Thread(new Runnable() {				
//				@Override
//				public void run() 
//				{
//					
//					Socket socket1 = new Socket();
//					OutputStream outS1 = null;
//					try {//连接服务器
//						socket1.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
//					} 
//					catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} 
//					   
//					try {
//						outS1 = socket1.getOutputStream();
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//
//					   while(true)
//					      {  
//					   	     client_send_data(ui.by,outS1);
////					   	     client_send_data(ui.by_for_gf);
////					   	     client_send_data(ui.by_for_broadcast);
////					   	     client_send_data(ui.by_for_media);
//					   	     
//					   	     try {
//								Thread.sleep(1000*1);
//								//System.out.println("by");
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					      }					
//				}
//			}).start();
////	
//			//开个 新线程2
//			new Thread(new Runnable() {				
//				@Override
//				public void run() 
//				{
//					
//					Socket socket2 = new Socket();
//					OutputStream outS2 = null;
//					try {//连接服务器
//						socket2.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
//					} 
//					catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} 
//					   
//					try {
//						outS2 = socket2.getOutputStream();
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//
//					   while(true)
//					      {  
//					   	     //client_send_data(ui.by,outS1);
//						     client_send_data(ui.by_for_gf,outS2);
////					   	     client_send_data(ui.by_for_broadcast);
////					   	     client_send_data(ui.by_for_media);
//					   	     
//					   	     try {
//								Thread.sleep(1000*1);
//								//System.out.println("by");
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					      }					
//				}
//			}).start();
//			
//			//开个 新线程3
//			new Thread(new Runnable() {				
//				@Override
//				public void run() 
//				{
//					
//					Socket socket3 = new Socket();
//					OutputStream outS3 = null;
//					try {//连接服务器
//						socket3.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
//					} 
//					catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} 
//					   
//					try {
//						outS3 = socket3.getOutputStream();
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//
//					   while(true)
//					      {  
//		//			   	     client_send_data(ui.by,outS1);
////					   	     client_send_data(ui.by_for_gf);
//					   	     client_send_data(ui.by_for_broadcast,outS3);
////					   	     client_send_data(ui.by_for_media);
//					   	     
//					   	     try {
//								Thread.sleep(1000*1);
//								//System.out.println("by");
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					      }					
//				}
//			}).start();
//			
//			
//			//开个 新线程4
//			new Thread(new Runnable() {				
//				@Override
//				public void run() 
//				{
//					
//					Socket socket4 = new Socket();
//					OutputStream outS4 = null;
//					try {//连接服务器
//						socket4.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
//					} 
//					catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} 
//					   
//					try {
//						outS4 = socket4.getOutputStream();
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//
//					   while(true)
//					      {  
//					   	    // client_send_data(ui.by,outS1);
////					   	     client_send_data(ui.by_for_gf);
////					   	     client_send_data(ui.by_for_broadcast);
//					   	     client_send_data(ui.by_for_media,outS4);
//					   	     
//					   	     try {
//								Thread.sleep(1000*1);
//								//System.out.println("by");
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					      }					
//				}
//			}).start();
			
			}			
/****************************************************************/			
//			//开个 新线程1
//			new Thread(new Runnable() {				
//				@Override
//				public void run() 
//				{
////					//开始解码，直至到达流的结尾或被用户终止。
////					mp3BroadcastData.mp3Player.run();
////					//isfinish_encode=true;
//					   while(true)
//					      {  
//					   	     client_send_data(ui.by);
////					   	     client_send_data(ui.by_for_gf);
////					   	     client_send_data(ui.by_for_broadcast);
////					   	     client_send_data(ui.by_for_media);
//					   	     
//					   	     try {
//								Thread.sleep(1000*1);
//								System.out.println("by");
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					      }					
//				}
//			}).start();
//			
//			//开个 新线程2
//			new Thread(new Runnable() {				
//				@Override
//				public void run() 
//				{
////					//开始解码，直至到达流的结尾或被用户终止。
////					mp3BroadcastData.mp3Player.run();
////					//isfinish_encode=true;
//					   while(true)
//					      {  
////					   	     client_send_data(ui.by);
//					   	     client_send_data(ui.by_for_gf);
////					   	     client_send_data(ui.by_for_broadcast);
////					   	     client_send_data(ui.by_for_media);
//					   	     
//					   	     try {
//								Thread.sleep(1000*1);
//								System.out.println("by_for_gf");
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					      }					
//				}
//			}).start();
//			//开个 新线程3
//			new Thread(new Runnable() {				
//				@Override
//				public void run() 
//				{
////					//开始解码，直至到达流的结尾或被用户终止。
////					mp3BroadcastData.mp3Player.run();
////					//isfinish_encode=true;
//					   while(true)
//					      {  
////					   	     client_send_data(ui.by);
////					   	     client_send_data(ui.by_for_gf);
//					   	     client_send_data(ui.by_for_broadcast);
////					   	     client_send_data(ui.by_for_media);
//					   	     
//					   	     try {
//								Thread.sleep(1000*1);
//								System.out.println("by_for_broadcast");
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					      }					
//				}
//			}).start();
//			//开个 新线程4
//			new Thread(new Runnable() {				
//				@Override
//				public void run() 
//				{
////					//开始解码，直至到达流的结尾或被用户终止。
////					mp3BroadcastData.mp3Player.run();
////					//isfinish_encode=true;
//					   while(true)
//					      {  
////					   	     client_send_data(ui.by);
////					   	     client_send_data(ui.by_for_gf);
////					   	     client_send_data(ui.by_for_broadcast);
//					   	     client_send_data(ui.by_for_media);
//					   	     
//					   	     try {
//								Thread.sleep(1000*1);
//								System.out.println("by_for_media");
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					      }					
//				}
//			}).start();
}			
			
	

		public void client_send_data(byte bytes[],OutputStream OutputStreamtemp)
		{
				 try {
					 OutputStreamtemp.write(bytes);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
		}
		
		
		public void run()
		   {
			 try {
					Thread.sleep(250*4*1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      while(true&&iscontinue)
		      {  
		    	  //if((String)(ui.ComboBox_for_en[0].getSelectedItem())=="ENABLE")
		    	 if((String)(ui.ComboBox_for_en[0].getSelectedItem())==ui.str_choose[0])
		    	 {
		    		 //System.out.println(ui.ComboBox_for_en[0].getSelectedItem());
		    		 client_send_data(ui.by,outS5);
		    		 
		    		// System.out.println(ui.by[5+1+3]);
		    		 
		    	 }    	 
    	 
		 	     try {
						Thread.sleep(250*1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 	    if((String)(ui.ComboBox_for_en[1].getSelectedItem()) ==ui.str_choose[0])
		    	 {     
		 	    	client_send_data(ui.by_for_gf,outS5);
		 	    	//System.out.println(ui.by_for_gf[5]);
		    	 }
		 	     try {
						Thread.sleep(250*1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 	    if((String)(ui.ComboBox_for_en[2].getSelectedItem()) ==ui.str_choose[0])
		    	 {
		   	     client_send_data(ui.by_for_broadcast,outS5);
		    	 }
		 	     try {
						Thread.sleep(250*1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 	    if((String)(ui.ComboBox_for_en[3].getSelectedItem()) ==ui.str_choose[0])
		    	 {
		 	    	client_send_data(ui.by_for_media,outS5); 
		    	 }
   	          try {
					Thread.sleep(250*1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   	          
   	          
		      }
		   }
	
}
