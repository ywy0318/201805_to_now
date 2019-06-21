package test_pro;
import java.awt.Container;
import java.awt.Image;
import java.net.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//很自然地认为当前类文件和图片在同一路径下即可。
//
//其实所谓的相对路径起点是工程的根目录，即project。
//
//这行代码执行时在project目录下查找名为a.gif的文件，结果当然是找不到。
//
//要得到工程的相对路径可通过System.getProperty(“user.dir”)得到。
//
//对图片和对文件的查找应该是一致的，如new File()。
//
//1、假如你的工程根目录为：Project1
//
//你的图片文件放在：Project1/src/images/1.jpg
//
//所以正确的调用是（不要加Project1）：
//
//ImageIcon icon = new ImageIcon(“src/images/1.jpg”);
//
//2、假如你的工程根目录为：Project1
//
//你的图片文件在：Project1/src/com.liuyanzhao/1.jpg
//
//所以正确的调用是(com.liuyanzhao是包名)
//
//ImageIcon icon = new ImageIcon(“src/com/liuyanzhao/1.jpg”);
//
//这行代码执行时在project/test目录下查找到了文件
//
//总结起来就是一句话：所谓相对路径就是相对于工程根目录的位置^_^

public class Swing_thread extends JFrame{
	private int count=0;
	private JLabel jl=new JLabel();
	private static Thread t;
	private Container c= getContentPane();//声明容器

	public Swing_thread() {
		// TODO Auto-generated constructor stub
		setBounds(300,200,250,100);
		c.setLayout(null);
		URL url=Swing_thread.class.getResource("1.jpg");
		
		Icon icon=new ImageIcon(url);
		
		ImageIcon ii = new ImageIcon("src/test_pro/1.jpg");
		//只是对图片进行缩放
		Image temp =ii.getImage().getScaledInstance(ii.getIconWidth(), ii.getIconHeight(), ii.getImage().SCALE_DEFAULT);
		Icon ic = new ImageIcon(temp);
		
//		ImageIcon ii = new ImageIcon("images/xxx.png");
//		Image temp = ii.getImage().getScaledInstance(jb1.getWidth(), jb1.getHeight(), ii.getImage().SCALE_DEFAULT);  
//		ii = new ImageIcon(temp);
//		jb1.setIcon(ii);
//		img=new ImageIcon("1.png");
//		img.setImage(img.getImage().getScaledInstance(test.WIDTH,test.HEIGHT,Image.SCALE_DEFAULT));
		
//		ImageIcon icon = new ImageIcon(“1.jpg”);
//
		//jl.setIcon(icon);
		//jl.setIcon(icon);
		jl.setIcon(ic);
		
		jl.setHorizontalAlignment(SwingConstants.LEFT);//SwingConstant
		jl.setBounds(10, 10, 200, 50);
		t=new Thread(new Runnable(){//定义内部匿名类,该类实现了Runnable接口
			public void run()
			{
				while(count<200)
				{
					jl.setBounds(count, 10, 200, 50);
					try {
						t.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count+=4;
					if(count==200)
					{
						count=10;
					}
					System.out.println(count);
				}
			}
		});
		t.start();
		c.add(jl);
		setVisible(true);
		//this.setDefaultCloseOperation(arg0);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//WindowConstants
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Swing_thread();
	}

}
