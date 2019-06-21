package test_pro;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;

public class DrawImage extends JFrame{
	Image img;
	
	public DrawImage() {
		// TODO Auto-generated constructor stub
		URL url=DrawImage.class.getResource("1.jpg");
		img=Toolkit.getDefaultToolkit().getImage(url);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new canvaspanel());
		this.setTitle("绘制图片");
	}
	class canvaspanel extends Canvas
	{
		public void paint(Graphics g)
		{
			super.paint(g);
			Graphics2D g2=(Graphics2D) g;
			g2.drawImage(img, 0, 0, this);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawImage().setVisible(true);
	}

}
