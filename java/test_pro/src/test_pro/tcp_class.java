package test_pro;
import java.net.InetAddress; 

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.OutputStream;
//import org.omg.CORBA.portable.OutputStream;

import java.net.UnknownHostException;

import javax.swing.JTextArea;
import javax.swing.JFrame;

import java.io.IOException;
import java.io.PrintWriter;
//public class tcpclass extends JFrame
public class tcp_class extends Thread
{
	//private Socket socket=null;
//	  InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
//	    String hostAddress = address.getHostAddress();//192.168.0.121
	String ip="192.168.106.148";
	int port =8080;
	OutputStream outS = null;
	int i=0;
	boolean isConnect = true;
	public byte[] byt=new byte[10];
	Socket socket = null;
	Timer timer = new Timer();
	static public boolean iscontinue=true;
	public  tcp_class () 
	{	

		 byt[0]=0x7e;
		 byt[1]=0x7e;
		 byt[2]=0x7e;
		 byt[3]=0x7e;
		 byt[4]=0x7e;
		 
		 byt[5]=0x7e;
		 byt[6]=0x7e;
		 byt[7]=0x7e;
		 byt[8]=0x7e;
		 byt[9]=0x7e;
		try {
			//socket = new Socket(InetAddress.getLocalHost(),port);
			socket = new Socket(ip,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Socket socket = new Socket(InetAddress.getByName(ip), port);
//		try {//连接服务器
//			socket.connect(new InetSocketAddress(InetAddress.getByName(ip), port));
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
			  
		   
		try {
			outS = socket.getOutputStream();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}	
	public void client_send_data(byte bytes[])
	{
		 try {
					outS.write(bytes);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
	public void run()
	   {
		

		while(true&&iscontinue)
	      {  
	   	     client_send_data(byt);
	   	     try {
				Thread.sleep(1000*1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	   }

	static Thread t=null;
	public static void main(String[] args) 
	 {
		  t=new tcp_class();
		 
		 t.start();		 
		 Timer timer = new Timer();		 
		   timer.scheduleAtFixedRate(new TimerTask() {
	            public void run() 
	            {	    
	       		 Calendar c = Calendar.getInstance();
	 			int hour = c.get(Calendar.HOUR_OF_DAY);
	 			int minute = c.get(Calendar.MINUTE);
	 			int second = c.get(Calendar.SECOND);

	 				System.out.print("I am main:");
	            	System.out.println(String.valueOf(hour)+":"
	            						+String.valueOf(minute)+":"+
	            						String.valueOf(second));
	            }
	        }, 1000, 1000);
		   
		   
		   try {
				Thread.sleep(1000*5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     t=null;
		     tcp_class.iscontinue=false;
		    
			 System.out.println("t=new tcp_class();"+":"+tcp_class.iscontinue);
			 try {
					Thread.sleep(1000*5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 tcp_class.iscontinue=true;
			 t=new tcp_class();			 
			 t.start();
			 System.out.println("t=new tcp_class();"+"::"+tcp_class.iscontinue);

	 }//end public static void main()   
	
	
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

