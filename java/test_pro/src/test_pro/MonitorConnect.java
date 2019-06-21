package test_pro;

import java.net.Socket;
import java.io.IOException;  
import java.net.InetSocketAddress;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.ScheduledThreadPoolExecutor;  
import java.util.concurrent.TimeUnit;  
//import java.net.Socket;

class MonitorConnect extends Thread{
		private SocketStatus ss=null;
		private String	address = null;
    	private int Port = 0;
		public MonitorConnect(SocketStatus ss,String address,int Port)
		{
		this.ss = ss;
    	this.address = address;
        this.Port = Port;
        }

		public void run(){
			while(true){
						if(ss.getSocket() == null)
				{
					SocketAddress socketaddress = new InetSocketAddress(address,Port);
					try{
					Socket socket = new Socket();
					socket.connect(socketaddress,5000);
					boolean status = true;
					while(status){
						try{
							socket.sendUrgentData(0xFF);
							ss.setSocket(socket);
							Thread.sleep(1000);
						}catch(Exception e1){
							System.out.println("服务器断开！！");
							ss.setSocket(null);
							status = false;
						}
					}
			}catch(Exception e){
				System.out.println("连接失败，3秒后重新连接"+e.getMessage());
			}
 			}
 			try{
			Thread.sleep(3000);
				}
 			catch(Exception e){
//					System.out.println(e.getMessage());
					System.out.println(e.getMessage());
            }
        }
    }
}

