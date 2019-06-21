package test_pro;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPserver {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        ds = new DatagramSocket(5555);//发送端自己的端口号
        // 构建发送对象
      
        // 将数据打包-->打成数据报
        String info = "hello world!";
       while(true)
       {
        dp = new DatagramPacket(info.getBytes(), info.length(), 
        		InetAddress.getByName("192.168.106.148"),3333);//接收端接收端口号
        // 发出数据报
        ds.send(dp);
        Thread.sleep(5000);
       }
     
       
       //好用的
        
    }

}
