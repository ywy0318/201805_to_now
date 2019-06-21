package test_pro;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class socket_address {

	public socket_address() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress ip = null;
		try {
			ip=InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
	}

}
