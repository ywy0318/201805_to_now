//package test;
package test_pro;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTcpSend_for_picture {

    public static void main(String[] args) {
        int length = 0;
        byte[] sendBytes = null;
        Socket socket = null;
        DataOutputStream dos = null;
        FileInputStream fis = null;
        try {
            try {
                socket = new Socket(InetAddress.getLocalHost(),33456);
                //socket.connect(new InetSocketAddress("127.0.0.1", 33456),1* 1000);
                dos = new DataOutputStream(socket.getOutputStream());
                File file = new File("E:\\JSP\\test_pro\\bin\\test_pro\\1.jpg");
                //File file = new File("C:\\Users\\JP\\Pictures\\head.jpg");
                fis = new FileInputStream(file);
                sendBytes = new byte[1024];
                while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
                    dos.write(sendBytes, 0, length);
                    dos.flush();
                }
            } finally {
                if (dos != null)
                    dos.close();
                if (fis != null)
                    fis.close();
                if (socket != null)
                    socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}