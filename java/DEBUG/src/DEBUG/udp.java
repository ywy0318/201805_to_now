package DEBUG;
import java.io.IOException;  
import java.io.OutputStream;
import java.net.*;  

public class udp extends Thread{

	 static  DatagramSocket ds_for_send = null;  //建立套间字udpsocket服务 
	 static InetAddress destination = null ;
	 static DatagramSocket ds_for_recv = null;
//	 static  DatagramPacket dp_for_recv = null;//定义一个接收的包
	 static public byte[] buf = new byte[43];
	 //String ip_for_send="192.168.106.148";//目的ip
	 String ip_for_send="172.16.1.1";//目的ip
	 //String ip_for_send="225.1.1.13";//目的ip
	 int port_for_send=59152;//发送目的端口
	 int port_for_recv=47788;//接收的端口
	 int length_for_send=48;//发送的字长
	 
	 
	 
//	 String ip_for_send="225.1.1.13";
//	 int port_for_send=50152;
	 //DatagramPacket DatagramSocket byte[] buf = new byte[1024];
	 /***********/
//	 
//		
//		byte[] buf = new byte[1024];//接受内容的大小，注意不要溢出
//		
		
//		DatagramPacket dp_for_recv = new DatagramPacket(buf,0,buf.length);//定义一个接收的包
//		ds_for_recv.receive(dp_for_recv);//将接受内容封装到包中
//		
//		String data = new String(dp_for_recv.getData(), 0, dp_for_recv.getLength());//利用getData()方法取出内容
//		
//		//System.out.println(data);//打印内容
//		
//		ds_for_recv.close();//关闭资源	

	 /***********/
	 
	 
	public udp() {
		// TODO Auto-generated constructor stub
		
		 try {  
			 ds_for_send = new DatagramSocket(0);  //实例化套间字，指定自己的port
			 ds_for_recv = new DatagramSocket(port_for_recv);
	        } catch (SocketException e) {  
	            System.out.println("ds_for_send--Cannot open port!");  
	            System.exit(1);   
	        }  
		 	
			try {
				destination = InetAddress.getByName(ip_for_send);  //需要发送的地址
			} catch (UnknownHostException e) {
				System.out.println("Cannot open findhost!");
				System.exit(1);	
			}
			//by_for_send_to_MVB
//			DatagramPacket dp_for_send = 
//					new DatagramPacket(ui.by_for_send,length_for_send, destination , port_for_send); 
			DatagramPacket dp_for_send = 
					new DatagramPacket(ui.by_for_send_to_MVB,length_for_send, destination , port_for_send); 
		//new DatagramPacket(ui.by_for_send, ui.by_for_send.length, destination , 50152);  
			//打包到DatagramPacket类型中
			//（DatagramSocket的send()方法接受此类，注意10000是接受地址的端口，不同于自己的端口！）
			
	
			//ds.close();
				
			
			
			
			//发送线程
			new Thread(new Runnable() {				
				@Override
				public void run() 
				{								
					   while(true)
					      {  

						   try {
							   ds_for_send.send(dp_for_send);  //发送数据
							} catch (IOException e) {
							}
					   	     
					   	     try {
								Thread.sleep(100*3);
							
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}
					      }					
				}
			}).start();
		   
			//接收线程
	new Thread(new Runnable() {				
		@Override
		public void run() 
		{	
			int i=0;
			
			while(true)
			{  
				//定义服务，监视端口上面的发送端口，注意不是send本身端口
//					DatagramSocket ds_for_recv = new DatagramSocket(port_for_recv);
				 DatagramPacket dp_for_recv = new DatagramPacket(buf,43);
				 try {
					 	
						ds_for_recv.receive(dp_for_recv);
						ui.refresh_table_value_for_mvb_to_pis(udp.buf);
						
						if(ui.jinj_num!=udp.buf[22])
						{
							ui.jinj_num=udp.buf[22];
							//ui.s
							ui.set_jinji_num(ui.jinj_num);
//							//System.out.println(udp.buf[15]);
						}
						//System.out.println(udp.buf[22]);	
						i+=1;
						if(i%3==0)
						{	
							i=0;							
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//将接受内容封装到包中
				 //ui.by_for_recv
					 //ui.sec=ui.by_for_recv[6];
					 //ui.sec=buf[6];

//			//String info = new String(dp.getData(),0, dp.getLength());
//				System.out.println("dp_for_recv.getLength()="+dp_for_recv.getLength());
			//ui.min=buf[6];
			
			//ui.refresh_table_value_for_mvb_to_pis(buf);
				 
//				for(int i=0;i<(43+43);i++)
//				{
//					//ui.by_for_recv[i]=buf[i+1];
//					if((i-1)%8==0)
//					{
//						System.out.println();
//					}
//					System.out.print(Integer.toHexString((int)(buf[i]&0xFF)));
//					//System.out.print(Integer.toHexString((int)buf[i]));
//					System.out.print("\t");
//					//System.out.println("memcpy");					
//				}
//				System.out.println();
//				
//				System.out.println(buf[3]&0x02);
//				System.out.println("memcpy");
//				System.out.print(Integer.toHexString(ui.by_for_recv[6]));
//				System.out.print("--");
//				System.out.println(Integer.toHexString(ui.sec));
				//System.out.println("dp_for_recv.getLength()="+dp_for_recv.getLength());
				//ui.refresh_table_value_for_mvb_to_pis(buf);
				
					try {
					Thread.sleep(1*1);
							
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}					
				}
		}).start();			
//	
}
	
//	static void udp_des()
//	{
//		ds_for_send.close();
//		ds_for_recv.close();
//	}
}
