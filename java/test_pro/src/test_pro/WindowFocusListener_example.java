package test_pro;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
//最小化就会失去焦点
//恢复到屏幕中央就会获得焦点
public class WindowFocusListener_example extends JFrame {
	
	public WindowFocusListener_example()
	{
		super();
		addWindowFocusListener(new MyWindowFocusListener());
		setTitle("捕获窗体焦点事件");
		setBounds(100,100,500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private  class MyWindowFocusListener implements WindowFocusListener
	{
		public void windowGainedFocus(WindowEvent e)//窗口获得焦点是触发
		{
			System.out.println("窗口获得了焦点");
		}
		public void windowLostFocus(WindowEvent e)//窗口失去焦点是触发
		{
			System.out.println("窗口失去了焦点");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowFocusListener_example f=new WindowFocusListener_example();
		f.setVisible(true);
	}

}
