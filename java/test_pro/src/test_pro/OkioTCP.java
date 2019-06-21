package test_pro;
//import com.aast.model.Massage;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import okio.*;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Timer;
 
import static java.lang.Thread.sleep;
 
public class OkioTCP extends Thread {
    private volatile Socket socket = null;
    private BufferedSource source = null;
    private BufferedSink sink = null;
    private volatile boolean isExit = false;
    private volatile boolean isConnect = false;
    private Read read = null;
    private Send send = null;
    volatile Timer timer = null;    //计时器
    private OkioTCP tcp=null;
 
    public OkioTCP(){
        tcp=this;
    }
 
    public static void main(String[] args) {
        OkioTCP tcp= new OkioTCP();
        tcp.start();
    }
    public synchronized boolean exit(){
        this.notify();
        isExit=true;
        try {
            if(socket!=null){
                socket.close();
                socket=null;
            }
        } catch (IOException e) {
//			e.printStackTrace();
        }
        return isExit;
    }
 
    @Override
    public  void run() {
        super.run();
        //		EventBus.getDefault().register(this);//注册订阅
        while(!isExit){
            try {
                synchronized (tcp) {
                    if(socket!=null &&!socket.isClosed()){
                        this.wait();
                        continue;
                    }
                }
                String ip="192.168.10.111";
                int port=8554;
//                int port=Integer.parseInt(MyProperUtil.getKey("PORT"));
                socket = new Socket(ip, port);
//				socket.setSoTimeout(6000);
                isConnect=true;
 
                source = Okio.buffer(Okio.source(socket));
                sink = Okio.buffer(Okio.sink(socket));
                read=new Read(source);
                send=new Send(sink);
                read.start();
                send.start();
                timer = new Timer();
                timer.schedule(new java.util.TimerTask() {
                    @Override
                    public void run() {
                        isConnected();
                    }
                }, 0, 6000);
            } catch (IOException |InterruptedException e) {
                closeSocket(e);
            }
        }
//        		EventBus.getDefault().unregister(this);//取消订阅
    }
 
    class Read extends Thread{
        BufferedSource source = null;
        public Read(BufferedSource source){
            this.source=source;
        }
        @Override
        public void run() {
            super.run();
            read();
        }
        private void read(){
            try {
                while (isConnect) {
                    int jsonLen = source.readIntLe();
                    System.out.println(jsonLen);
                    byte[] jsonData = new byte[jsonLen];
//                    byte[] data = source.readByteArray(len);
                    int size=0;//本次接收的长度
                    int curlen = 0;//已经接收的长度
                    while((size = source.read(jsonData,curlen,jsonLen-curlen)) !=-1){
                        curlen += size;
                        if(curlen >= jsonLen)break;
                    }
                    String strJson = new String(jsonData,"GB2312");
//                  System.out.println(strJson);
 
                    JSONObject obj = JSONObject.fromObject(strJson);
                    System.out.println("收到长度："+jsonLen+"收到信息：");
                    System.out.println(obj.toString());
                    JSONArray arr=obj.getJSONArray("hisSelect");
                    System.out.println(arr.toArray().length);
                    int msgType=obj.getInt("msgType");
//                    if(msgType==0){
//                        System.out.println();
//                    }else{
//
//                    }
                sleep(4000);
            }
            } catch (IOException | InterruptedException e) {
//				closeSocket(e);
            }
 
 
        }
    }
 
    class Send extends Thread{
        BufferedSink sink = null;
        public Send(BufferedSink sink){
            this.sink=sink;
        }
 
        @Override
        public void run() {
            super.run();
            while (isConnect){
                send(null);
            }
        }
        private void send(String msg){
            try {
                JSONObject obj = new JSONObject();
                byte[] arr=new byte[10];
                obj.put("msgType",3);
                obj.put("fThreshold",0.5);
//                obj.put("boot",Arrays.toString(arr));
                obj.put("boot",1);//数据类型：0-无效1-重启服务 2-关闭服务；msgType为2时有效
                obj.put("startT","2017-06-05");
                obj.put("endT","2020-06-08");
                String ss=obj.toString();
                int msgLen = ss.getBytes(Charset.forName("utf-8")).length;
                sink.writeIntLe(msgLen);
                sink.write(ss.getBytes(Charset.forName("utf-8")));
                sink.flush();
                sleep(1000);
            } catch (Exception e) {
                closeSocket(e);
            }
        }
    }
 
    public boolean isConnected(){
        try{
            if(socket!=null){
                socket.sendUrgentData(0xFF);
//				EventBus.getDefault().post(new MessageEvent("发送心跳"));
//				Log.e("TAG", "发送心跳");
            }
            isConnect=true;
            return true;
        }catch(Exception e){
            closeSocket(e);
            return false;
        }
    }
 
    public synchronized boolean closeSocket(Exception e){
        try {
            send.interrupt();
            read.interrupt();
            sleep(2000);
        } catch (Exception e2) {
//			e2.printStackTrace();
        }
        isConnect=false;
        if(socket!=null){
            try {
                socket.close();
                socket=null;
            } catch (IOException e1) {
            }
            timer.cancel();
            socket=null;
            tcp.notify();
        }
//		e.printStackTrace();
        return isExit;
    }
}
