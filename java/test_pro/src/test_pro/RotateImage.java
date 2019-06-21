package test_pro;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

import test_pro.DrawImage.canvaspanel;

public class RotateImage extends JFrame{
	
	Image img;
	//private MyCanvas canvas1=null;
	public RotateImage() {
		// TODO Auto-generated constructor stub
		URL url=DrawImage.class.getResource("1.jpg");
		img=Toolkit.getDefaultToolkit().getImage(url);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyCanvas());
		this.setTitle("绘制图片");
	}
	class MyCanvas extends JPanel
	{
		public void paint(Graphics g)
		{
			super.paint(g);
			Graphics2D g2=(Graphics2D) g;
			//每次旋转5度
//			g2.rotate(Math.toRadians(5));
//			g2.drawImage(img, 70, 10, 300, 200, this);
//			g2.rotate(Math.toRadians(5));
//			g2.drawImage(img, 70, 10, 300, 200, this);
//			g2.rotate(Math.toRadians(5));
//			g2.drawImage(img, 70, 10, 300, 200, this);
			
			g2.shear(0.3, 2);
			g2.drawImage(img, 0, 0, 300, 200, this);
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RotateImage().setVisible(true);
	}

}
