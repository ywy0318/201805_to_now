package test_pro;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawCircle extends JFrame{
	
	private final int oval_width=80;
	private final int oval_height=80;
	private final int beishu=100;
	public DrawCircle() {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}
	public void initialize()
	{
		this.setBounds(500, 500, 800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new DrawPanel());//设置窗体面板为绘图面板对象
		this.setTitle("绘图实例");
	}
	class DrawPanel extends JPanel
	{
		public void paint(Graphics g)
		{
			super.paint(g);
//			第一个参数是所要画的椭圆的左上角的x坐标
//			第二个参数是对应的y坐标
//			第三个参数是椭圆的宽
//			最后一个是椭圆的高
			BasicStroke stroke=new BasicStroke(1*beishu);
			g.setColor(Color.red);
			g.drawOval(10, 10, oval_width, oval_height);
			stroke=new BasicStroke(2*beishu);
			g.drawOval(80, 10, oval_width, oval_height);
			stroke=new BasicStroke(300);
			g.drawOval(150, 10, oval_width, oval_height);
			stroke=new BasicStroke(400);
			g.drawOval(50, 70, oval_width, oval_height);
			stroke=new BasicStroke(500);
			g.drawOval(120, 70, oval_width, oval_height);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawCircle().setVisible(true);

	}

}
