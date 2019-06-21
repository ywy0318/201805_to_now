package test_pro;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class keyevent extends JFrame {

	public keyevent() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("键盘事件示例");
		this.setBounds(400, 400, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JLabel jl = new JLabel("备注：");
		this.getContentPane().add(jl,BorderLayout.WEST);
		final JScrollPane sc = new JScrollPane();
		this.getContentPane().add(sc,BorderLayout.CENTER);
		JTextArea jt = new JTextArea();
		jt.addKeyListener(new KeyListener()
		{
			// 按键被按下时被触发
			public void keyPressed( KeyEvent e )
			{
				String keytext = KeyEvent.getKeyText(e.getKeyCode());
				if(e.isActionKey())// 判断按下的是否为动作键
				{
					System.out.println(":"+keytext);
				}
				else{
					System.out.print("您按下的是非动作键“" + keytext + "”");
					int keycode = e.getKeyCode();
					switch(keycode)
					{
					case KeyEvent.VK_CONTROL: // 判断按下的是否为Ctrl键
					{
						System.out.print("，Ctrl键被按下");
						break;
					}
					case KeyEvent.VK_ALT: // 判断按下的是否为Alt键
						System.out.print("，Alt键被按下");
						break;
					case KeyEvent.VK_SHIFT: // 判断按下的是否为Shift键
						System.out.print("，Shift键被按下");
						break;
					
					}
					System.out.println();
				}
			}
			
			public void keyTyped(KeyEvent e) { // 发生击键事件时被触发
				// 获得输入的字符
				System.out.println("此次输入的是“" + e.getKeyChar() + "”");
			}
			public void keyReleased(KeyEvent e) { // 按键被释放时被触发
				// 获得描述keyCode的标签
				String keyText = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("您释放的是“" + keyText + "”键");
				System.out.println();
			}
//			@Override
//			public void keyReleased(KeyEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}

		});
		jt.setLineWrap(true);
		jt.setRows(3);
		jt.setColumns(15);
		sc.setViewportView(jt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keyevent frame = new keyevent();
		frame.setVisible(true); // 设置窗体可见，默认为不可见
	}

}
