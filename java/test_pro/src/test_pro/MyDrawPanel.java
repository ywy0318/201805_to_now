package test_pro;


	 
	import java.awt.Color;
	import java.awt.Graphics;
	 
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	 
	public class MyDrawPanel extends JPanel {//JPanel是普通容器
	 
		public static void main(String[] args) {
			new MyDrawPanel();
		}
		
		public MyDrawPanel(){
			//创建组件 
			JFrame frame = new JFrame();//JFrame是顶级容器,包含Swing组件的程序必须包含一个顶级容器
			JLabel label = new JLabel("aaa");
			
			 //把JPanel添加组件 。因为Swing组件不可以直接加入到顶级容器中,通常是 JFrame, JDialog, and JApplet三个顶层容器类。
			this.add(label);
			
			//把JPanel及JPanel上的其他组件都加入顶层容器JFrame  
			frame.getContentPane().add(this);
			
			//设置面板和框架的基本属性
			this.setBackground(Color.blue);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300, 300);
			frame.setVisible(true);
		}
		
		public void paint(Graphics g) {
			super.paint(g);//如果注释掉super.paint(g)，那么就不显示父类JPanel容器中的原本组件，只能显示出方块了。
			g.setColor(Color.orange);
			g.fillRect(20, 50, 100, 100);
		}
	}



