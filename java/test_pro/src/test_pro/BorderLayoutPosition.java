package test_pro;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BorderLayoutPosition extends JFrame {
	
	String [] bd={BorderLayout.CENTER,BorderLayout.NORTH,BorderLayout.SOUTH,
			BorderLayout.WEST,BorderLayout.EAST	};
	String [] button_name={"center button","NORTH button","SOUTH button","WEST button","EAST button"};
	public BorderLayoutPosition()
	{
		setTitle("使用边界布局管理器");
		Container c=new Container();
		c.setLayout(new BorderLayout());
		for(int i=0;i<bd.length;i++)
		{
			c.add(bd[i],new JButton(button_name[i]));
		}
		this.add(c);
		this.setSize(400,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLayoutPosition();
	}

}
