package test_pro;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;



public class Window_Listener extends JFrame {

	public Window_Listener() {
		// TODO Auto-generated constructor stub
		super();
		addWindowListener(new MyWindow_Listener());
		setTitle("捕获窗体焦点事件");
		setBounds(100,100,500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private  class MyWindow_Listener implements WindowListener
	{
		public void windowActivated(WindowEvent e)//窗口获得焦点是触发
		{
			System.out.println("窗口被激活");//跟获得焦点差不多
		}
		public void windowOpened(WindowEvent e)//窗口失去焦点是触发
		{
			System.out.println("窗口被打开");
		}
		public void windowIconified(WindowEvent e)//窗口失去焦点是触发
		{
			System.out.println("窗口被图表化");
		}
		public void windowDeiconified(WindowEvent e)//窗口失去焦点是触发
		{
			System.out.println("窗口被非图表化");
		}
		public void windowClosing(WindowEvent e)//窗口失去焦点是触发
		{
			System.out.println("窗口将要被关闭");
		}
		public void windowDeactivated(WindowEvent e)//窗口失去焦点是触发
		{
			System.out.println("窗口将要被关闭");
		}
		public void windowClosed(WindowEvent e)//窗口失去焦点是触发
		{
			System.out.println("窗口已经被关闭");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window_Listener f=new Window_Listener();
		f.setVisible(true);

	}

}
