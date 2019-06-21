package test_pro;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

//客户端发送心跳包而服务器端需要设置接收
//可以设置socket.setOOBInline(true);，接收心跳数据
//
//但是心跳数据会合并到正常数据中，如客户端传送“1”，服务器端接收"���1"
//
//前面的是传送三个心跳包的结果。
//
//其实心跳包，可以是自定义来实现，通过服务器端接收，又向客户端发送确认信息即可。这样可以解决问题。
//--------------------- 
//作者：jazwoo 
//来源：CSDN 
//原文：https://blog.csdn.net/jazywoo123/article/details/8698357 
//版权声明：本文为博主原创文章，转载请附上博文链接！
public class tcp_socket_reconnect extends Thread{

	String ip="192.168.106.148";
	int port =8080;
	OutputStream outS = null;
	int i=0;
	boolean isConnect = true;
	public byte[] byt=new byte[10];
	String str="高德地图持续为您导航";
	Socket socket = null;
	Timer timer = new Timer();
	public void reconnect()
	{
		try {
			socket = new Socket(InetAddress.getLocalHost(),port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		try {
			outS = socket.getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("reconnect");
		
	}
	public tcp_socket_reconnect() {
		// TODO Auto-generated constructor stub
		try {
			socket = new Socket(InetAddress.getLocalHost(),port);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("UnknownHostException");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("IOException");
		}
		for(int i=0;i<byt.length;i++)
		{
			byt[i]=(byte)(0x00+i);
		}		
		try {
			outS = socket.getOutputStream();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("getOutputStream-IOException");
		}
		
		   timer.scheduleAtFixedRate(new TimerTask() {
	            public void run() 
	            {	  
	            	client_send_data(byt);
	            	System.out.println("高德地图持续为您导航");
//	            	if(isConnect)
//	            	{
//	            		client_send_data(byt);
//	            		
//	            	}
//	            	else
//	            	{
//	            		System.out.println(isConnect);
//	            	}
	            	//System.out.println(get_date_time());
	            }
	        }, 1000, 1000);
		   
//			//开个 新线程
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() 
//				{
//					try {
//						Thread.sleep(1000*3);
//					} catch (InterruptedException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}//1s
//					while(true)
//				  {
//					try {
//						Thread.sleep(1000*1);//1s
//						
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					//System.out.println(socket);
//					System.out.println("高德地图持续为您导航");
//					
////					while(true)
////					{
////						if (null != socket) {
////							try {//发送检测是否断开
////								socket.sendUrgentData(0xFF);
////							} catch (Exception e) {//断开产生异常，关闭对象
////								System.out.println("socket.sendUrgentData(0xFF)");
////								isConnect=false;
////								try {
////									outS.close();
////								} catch (IOException e1) {
////									// TODO Auto-generated catch block
////									e1.printStackTrace();
////								}
////								try {
////									socket.close();
////								} catch (IOException e1) {
////									// TODO Auto-generated catch block
////									e1.printStackTrace();
////								}
////								outS = null;
////								socket = null;
////								e.printStackTrace();
////								reconnect();
////								
////							}
////					}
////				
////				}
//				//end while(true)
//				}
//			  }
//			}).start();
		   
	}
	public void client_send_data(byte bytes[])
	{
		 try {
			 	//System.out.println();
				outS.write(bytes);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("client_send_data_IOException");
			}
	}
//	public void client_send_str(String strtemp)
//	{
//		 try {
//			 	//System.out.println();
//				outS.write(strtemp);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//				System.out.println("client_send_data_IOException");
//			}
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new tcp_socket_reconnect();
		Thread t=new tcp_socket_reconnect();
		t.start();
	}

}
