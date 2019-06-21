package test_pro;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFrame extends JFrame{
	private final int beishu=100;
	public DrawFrame() {
		super();
		init();
		// TODO Auto-generated constructor stub
	}
	public void init()
	{
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new canvasPanel());
		this.setTitle("绘图实例2");		
	}
	class canvasPanel extends JPanel
	{
		public void paint(Graphics g)
		{
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			Shape[] shapes=new Shape[4];
			shapes[0]=new Ellipse2D.Double(5,5,100,100);//声明图形数组
			shapes[1]=new Rectangle2D.Double(110,5,100,100);//创建圆形对象
			shapes[2]=new Rectangle2D.Double(15,15,80,80);
			shapes[3]=new Ellipse2D.Double(120,15,80,80);
			BasicStroke stroke=new BasicStroke(1*beishu);
			GradientPaint paint =new GradientPaint(20,20,Color.BLUE,100,80,Color.RED,true);
			for(Shape shape:shapes)
			{
				Rectangle2D bounds=shape.getBounds2D();
				if(bounds.getWidth()==80)
				{
					g2.draw(shape);
					//g2.fill(shape);
					g2.setPaint(paint);
					//g2.setColor(Color.red);
				}
				else
				{
					stroke=new BasicStroke(3*beishu);
					g2.setPaint(paint);
					//g2.fill(shape);
					g2.draw(shape);
					//g2.setColor(Color.blue);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawFrame().setVisible(true);

	}

}
