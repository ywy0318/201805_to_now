package test_pro;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class join_method_JProcessBar extends JFrame {
	
	private Thread threadA;
	private Thread threadB;
//	jProgressBar.setBackground(new Color(255, 255, 255)); // 背景
//	jProgressBar.setForeground(new Color(255, 0, 0)); // 进度颜色
	final JProgressBar processbar=new JProgressBar();//JProcessBar
	final JProgressBar processbar2=new JProgressBar();//JProcessBar
	
	int count=0;
	public join_method_JProcessBar() {
		super();
		processbar.setForeground(Color.BLUE);
		processbar2.setForeground(Color.RED);
		getContentPane().add(processbar,BorderLayout.NORTH);
		getContentPane().add(processbar2,BorderLayout.SOUTH);
		// TODO Auto-generated constructor stub
		//使用匿名内部类形式初始化Thread实例
		threadA = new Thread( new Runnable(){
			int count=0;
		public void run()
		{
			while(true)
			{
				count++;
				processbar.setValue(count);
				
				try {
					threadA.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//线程A使用了线程B的join()方法,
				//join方法是使当前线程暂停,直到调用join方法的线程执行完毕以后再执行
				try {
					threadB.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count==100)
				{
					count=0;
				}
			}
			//869139020226177
		}
		});
		threadA.start();
		threadB = new Thread( new Runnable(){
			int count=0;
		public void run()
		{
			while(true)
			{
				count++;
				processbar2.setValue(count);
				
				try {
					threadB.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count==100)
				{
					break;
				}
			}
			
		}
		});
		threadB.start();
}
	public static void init(JFrame f,int w,int h)
	{
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setSize(w, h);
		f.setBounds(400, 400, w, h);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(new join_method_JProcessBar(),400,400);
	}
}
