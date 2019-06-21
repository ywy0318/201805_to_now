package test_pro;

	
	
	import java.awt.*;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
	public class JScrollPaneTest extends JFrame{
	public JScrollPaneTest()
{
	this.setLayout(null);	
	
	
	JLabel label_arr1[];
	label_arr1 = new JLabel[4];	
	JLabel label_arr2[];
	label_arr2 = new JLabel[2];
	String str1[] = {"正常/取消申请/接通后挂断", "申请", "接通(控制盒)", "接通(OCC-TPA)" };
	JComboBox<String>[] ComboBox= new JComboBox[4];
	
	JPanel jp1=new JPanel();	
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel();
	
	JPanel[] jp_array=new JPanel[2];
	
	JPanel jp5=new JPanel();	
	JPanel jp6=new JPanel();
	JPanel jp7=new JPanel();
	JPanel jp8=new JPanel();
	
	jp1.setPreferredSize(new Dimension(1000,1000));
	JScrollPane sp1=new JScrollPane(jp1);
	jp1.setLocation(0, 0);	
	jp2.setPreferredSize(new Dimension(1000,1000));
	JScrollPane sp2=new JScrollPane(jp2);
	jp2.setLocation(0, 1000);	
	jp5.setPreferredSize(new Dimension(1000,1000));
	JScrollPane sp3=new JScrollPane(jp5);
	jp5.setLocation(1000, 1000);	
	jp6.setPreferredSize(new Dimension(1000,1000));
	JScrollPane sp4=new JScrollPane(jp6);
	jp6.setLocation(1000, 0);
	
	ComboBox[0] = new JComboBox<String>(str1);
	ComboBox[1] = new JComboBox<String>(str1);
	ComboBox[2] = new JComboBox<String>(str1);
	ComboBox[3] = new JComboBox<String>(str1);
	
	label_arr1[0] = new JLabel("紧急报警器");
	label_arr1[1] = new JLabel("紧急报警器");
	label_arr1[2] = new JLabel("紧急报警器");
	label_arr1[3] = new JLabel("紧急报警器");
	
	jp_array[0]=new JPanel();
	jp_array[1]=new JPanel();
	
	jp_array[0].add(label_arr1[0]);
	jp_array[0].add(ComboBox[0]);
	
	jp_array[1].add(label_arr1[0]);
	jp_array[1].add(ComboBox[0]);
	
	jp3.add(label_arr1[0]);
	jp3.add(ComboBox[0]);	
	jp4.add(label_arr1[1]);
	jp4.add(ComboBox[1]);
	
	jp7.add(label_arr1[2]);
	jp7.add(ComboBox[2]);	
	jp8.add(label_arr1[3]);
	jp8.add(ComboBox[3]);
	
	jp3.setBounds(0, 0,200,200);
	jp4.setBounds(0,200,200,200);
	jp7.setBounds(200, 0,200,200);
	jp8.setBounds(200,200,200,200);
	
    jp1.add(jp3);
    jp1.add(jp4);
    jp1.add(jp7);
    jp1.add(jp8);
    
    jp2.add(jp_array[0]);
	
	sp1.setBounds(10,10,500,500);
	sp2.setBounds(10,510,500,500);
	sp3.setBounds(510,10,500,500);
	sp4.setBounds(510,510,500,500);
	
	//this.getContentPane().add(sp1);
	this.getContentPane().add(sp2);
	this.getContentPane().add(sp3);
	this.getContentPane().add(sp4);
	
	this.setVisible(true);
	this.setBounds(400,-10,1050,1150);//JFrame的尺寸
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);	
	this.addWindowListener(new WindowAdapter()
	{
		public void JFClose(WindowEvent w)
		{
			System.exit(0);
		};
	});
	//this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	new JScrollPaneTest();
	}

	

}
