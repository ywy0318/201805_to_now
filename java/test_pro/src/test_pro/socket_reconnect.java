package test_pro;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;
 
//import org.springframework.stereotype.Component;
// 
//import com.pam.enums.Constants;
//import com.pam.utils.PropertiesUtil;

public class socket_reconnect {
 
	//@Component(value="pushClient")

	 
		Logger logger = Logger.getLogger("Client");
	 
		private String host;
	 
		private Integer port;
	 
		private Socket client;
	 
		private OutputStream os;
	 
		private LinkedList<Object> msgList = new LinkedList<Object>();
	 
		private Thread sendMessageThread;
		
		public socket_reconnect(){
			super();
//		public PushClient() {
//			super();
			logger.info("\n\n#############加载PushClient\n");
			sendMessageThread = new Thread(new Runnable() {
	 
				@Override
				public void run() {
					Properties properties = null;
					while (true) {
						try {
							if (null != client) {
								try {//发送检测是否断开
									client.sendUrgentData(0xFF);
								} catch (Exception e) {//断开产生异常，关闭对象
									os.close();
									client.close();
									os = null;
									client = null;
									e.printStackTrace();
								}
								
								if (msgList.size() == 0) {
									Thread.sleep(3000);
									logger.info("\n\n待发送的消息条数为0\n");
									continue;
								}
								logger.info("\n\n待发送的消息条数："+msgList.size()+"\n");
								for (int i = 0; i < msgList.size(); i++) {
									Thread.sleep(500);
									logger.info("\n\n发送第"+(i+1)+"条消息:"+msgList.get(i).toString()+"\n");
									os.write(msgList.get(i).toString().getBytes());
									os.flush();
								}
								msgList.clear();
							} else {
								logger.info("\n\n重新连接中...\n");
								properties = PropertiesUtil.getProperties(Constants.PROPERTIES_PATH);
								String push_ip = PropertiesUtil.getAttribute(properties, Constants.PUSH_IP);
								Integer push_port = Integer.valueOf(PropertiesUtil.getAttribute(properties, Constants.PUSH_PORT));
								logger.info("\n\n连接IP:"+push_ip+"\n连接PORT:"+push_port);
								client = new Socket(push_ip, push_port);
								os = client.getOutputStream();
							}
						} catch (Exception e) {
							try {
								logger.info("\n\n连接失败，继续连接\n");
								Thread.sleep(10*1000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
			sendMessageThread.start();
		}
	 
		
		/**
		 * 出
		 * @return
		 */
		public Object getMsg() {
			synchronized (this) {
				if (msgList != null && msgList.size() > 0) {
					return msgList.removeFirst();
				}
				return null;
			}
		}
		
		/**
		 * 入
		 * @param obj
		 * @return
		 */
		public Object addMsg(Object obj) {
			synchronized (this) {
				msgList.addLast(obj);
			}
			return obj;
		}
		
		/**
		 * 发送消息
		 * @param data
		 */
		public void sendMessage(String data) {
			addMsg(data);
		}
		
		/**
		 * 将一个字符串转化为输入流
		 * @param sInputString
		 * @return
		 */
		public static InputStream getStringStream(String sInputString){
			if(null != sInputString && !sInputString.trim().equals("")){
				try {
					ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sInputString.getBytes());
					return byteArrayInputStream;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		
		public Logger getLogger() {
			return logger;
		}
	 
		public void setLogger(Logger logger) {
			this.logger = logger;
		}
	 
		public String getHost() {
			return host;
		}
	 
		public void setHost(String host) {
			this.host = host;
		}
	 
		public Integer getPort() {
			return port;
		}
	 
		public void setPort(Integer port) {
			this.port = port;
		}
	 
		public Socket getClient() {
			return client;
		}
	 
		public void setClient(Socket client) {
			this.client = client;
		}
	 
		public OutputStream getOs() {
			return os;
		}
	 
		public void setOs(OutputStream os) {
			this.os = os;
		}
	 
		public LinkedList<Object> getMsgList() {
			return msgList;
		}
	 
		public void setMsgList(LinkedList<Object> msgList) {
			this.msgList = msgList;
		}
	 
		public Thread getSendMessageThread() {
			return sendMessageThread;
		}
	 
		public void setSendMessageThread(Thread sendMessageThread) {
			this.sendMessageThread = sendMessageThread;
		}
		
	}

	
}
