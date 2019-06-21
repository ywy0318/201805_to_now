package test_pro;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;



public class WindowstatusListener_example extends JFrame {

	public WindowstatusListener_example() {
		// TODO Auto-generated constructor stub
		super();
		addWindowStateListener(new MyWindowstatusListener());
		setTitle("捕获窗体焦点事件");
		setBounds(100,100,500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private   class MyWindowstatusListener implements WindowStateListener
	{
		
//		@Override是伪代码,表示重写(当然不写也可以)
//		建议写上,有如下好处:
//		1、可以当注释用,方便阅读；
//		2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的,如果没有则报错，
//		比如你如果没写@Override而你下面的方法名又写错了,
//		这时你的编译器是可以通过的(它以为这个方法是你的子类中自己增加的方法)。

		//@Override
		public void windowStateChanged(WindowEvent e) {
			// TODO Auto-generated method stub
			int oldstatus=e.getOldState();
			int newstatus=e.getNewState();
			String from="";
			String to="";
			switch(oldstatus)
			{
			case Frame.NORMAL:
			 from="正常化";
			 break;
			case Frame.MAXIMIZED_BOTH:
				 from="最大化";
				 break;
			default:
				 from="图标化";				
			}
			switch(newstatus)
			{
			case Frame.NORMAL:
				to="正常化";
			 break;
			case Frame.MAXIMIZED_BOTH:
				to="最大化";
				 break;
			default:
				to="图标化";				
			}
			System.out.println(from+"-->"+to);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowstatusListener_example f=new WindowstatusListener_example();
		f.setVisible(true);
	}

}
