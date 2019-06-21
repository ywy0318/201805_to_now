package test_pro;

import java.awt.BorderLayout;
import java.awt.CardLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cardLayout extends JFrame {
	private JPanel jp1;		//采用卡片管理器的面板对象
	private CardLayout cardLayout;//卡片管理器对象

	public cardLayout() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("使用卡片布局管理器");
		this.setBounds(400, 400, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardLayout=new CardLayout();
		jp1=new JPanel(cardLayout);//创建一个卡片布局管理器对象
		this.getContentPane().add(jp1,BorderLayout.CENTER);//添加到窗体中间
		String [] label_names={"卡片A","卡片B","卡片C"};
		for(int i=0;i<label_names.length;i++)
		{
			final JLabel label=new JLabel(label_names[i]);
			jp1.add(label,label_names[i]);
		}
		final JPanel bt_panel=new JPanel();//创建一个按钮面板
		this.getContentPane().add(bt_panel,BorderLayout.SOUTH);//窗体下方
		String[] bt_names={"第一个","前一个","卡片A","卡片B","卡片C","后一个","最后一个"};
		for(int i=0;i<bt_names.length;i++)
		{
			final JButton bt=new JButton(bt_names[i]);
			bt.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)//actionPerformed
				{
					String bt_text= bt.getText();
					if(bt_text.equals(bt_names[0]))
					{
						cardLayout.first(jp1);//显示第一个
					}
					else if(bt_text.equals(bt_names[1]))
					{
						cardLayout.previous(jp1);//显示前一个
					}
					else if(bt_text.equals(bt_names[2]))
					{
						cardLayout.show(jp1, "卡片A");//卡片A 
					}
					else if(bt_text.equals(bt_names[3]))
					{
						cardLayout.show(jp1, "卡片B");//卡片B
					}
					else if(bt_text.equals(bt_names[4]))
					{
						cardLayout.show(jp1, "卡片C");//卡片C
					}
					else if(bt_text.equals(bt_names[5]))
					{
						cardLayout.next(jp1);//下一个
					}
					else if(bt_text.equals(bt_names[6]))
					{
						cardLayout.last(jp1);//最后一个
					}
					
				}		
			});
			bt_panel.add(bt);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cardLayout cl=new cardLayout();
		cl.setVisible(true);
	}

}
