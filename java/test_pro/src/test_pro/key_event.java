package test_pro;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
//有问题
public class key_event extends JFrame{

	public key_event()
	{
		//(new BorderLayout());
		final JLabel label =new JLabel();
		label.setText("备注:");
		final JScrollPane sc=new JScrollPane();
		Container c= new Container();
		c.setLayout(new BorderLayout());
		c.add(label,BorderLayout.WEST);
		c.add(sc,BorderLayout.CENTER);
		c.setVisible(true);
		JTextArea jt=new JTextArea();
		jt.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)//按键被按下时触发
			{
				String keytext= KeyEvent.getKeyText(e.getKeyCode());//获得藐视keyCode的标签
				if(e.isActionKey())
				{
					System.out.println("按下的是动作键:“"+keytext+"” ");
				}
				else{
					System.out.println("按下的是非动作键:“"+keytext+"” ");
					int keycode=e.getKeyCode();//获得与此事件中的键相关联的字符
					switch(keycode)
					{
					case KeyEvent.VK_CONTROL:
						System.out.println("Ctrl被按下");
						break;
					case KeyEvent.VK_ALT:
						System.out.println("ALt被按下");
						break;
					case KeyEvent.VK_SHIFT:
						System.out.println("SHIFT被按下");
						break;
					}
					System.out.println();
				}
			}
			public void keyTyped(KeyEvent e)//发生击键事件时触发
			{
				System.out.println("此次输入的是:“"+e.getKeyChar()+"”");
			}
			public void keyReleased(KeyEvent e)//按键被释放时触发
			{
				String keytest1=KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("释放的是:“"+keytest1+"” ");
			}
		});
		jt.setLineWrap(true);
		jt.setRows(3);
		jt.setColumns(15);
		sc.setViewportView(jt);
//		Container c=this.getContentPane();//初始化一个容器
//		c.add(label,BorderLayout.WEST);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new key_event();
	}

}















