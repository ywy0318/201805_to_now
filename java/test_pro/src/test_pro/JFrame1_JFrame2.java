package test_pro;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Timer;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrame1_JFrame2 extends JFrame{

	public JFrame1_JFrame2() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);

		JPanel panal1, panal2, panal3, panal4, panal5;

		panal1 = new JPanel();
		panal2 = new JPanel();
		panal3 = new JPanel();
		panal4 = new JPanel();

		JLabel jlb11, jlb12;
		jlb11 = new JLabel("广播控制盒话筒音量：");

		JTextField tf1, tf2, tf3;
		// 5的时候最好吧
		tf1 = new JTextField("20", 4);// 文本框大小还没写�?
		// tf1.setBounds(0, 120, 275,40);

		JLabel label_arr[];
		label_arr = new JLabel[48];

		String str = "紧急报警器";
		String strtemp = "";
		String str1[] = { "正常/取消申请/接通后挂断", "申请", "接通(控制盒)", "接通(OCC-TPA)" };

		JComboBox jcb0, jcb1, jcb2; // 下拉列表

		// JComboBox<Object> ComboBox_arr[];//下拉列表
		// ComboBox_arr = new JComboBox [48];

		jcb2 = new JComboBox(str1);
		jcb1 = new JComboBox(str1);
		jcb0 = new JComboBox(str1);
		// ComboBox_arr[1] = new JComboBox(str1);

		int i = 0, j = 0, k = 0;
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 6; j++) {
				strtemp = str;
				strtemp += String.valueOf(i + 1);
				strtemp += "-";
				strtemp += String.valueOf(j + 1);
				strtemp += ":";
				// System.out.println(strtemp);
				// 0-47;0-6,
				label_arr[j + i * 6] = new JLabel(strtemp);
				// System.out.println(j+6*i);
			}
		}
		
//		jcb2.removeAllItems();
//		jcb2.setModel(arg0);
		panal1.add(label_arr[0]);// label
		panal1.add(jcb0);// 下拉列表

		panal2.add(label_arr[1]);
		panal2.add(jcb1);

		panal3.add(label_arr[2]);
		panal3.add(jcb2);

		panal4.add(jlb11);
		panal4.add(tf1);

		panal1.setBounds(0, 0, 275, 40);
		panal2.setBounds(0, 40, 275, 40);
		panal3.setBounds(0, 80, 275, 40);
		// panal4.setBounds(0,120,275,40);

		// panal+String.valueOf(4)

		// for(k=0;k<48;k++)
		// { //0-47;0-6
		// ComboBox_arr[k] = new JComboBox<Object>(str1);
		// panal_arr[k]=new
		// ComboBox_arr[i] = new JComboBox(str1);
		// }

		// for(k=0;k<48;k++)
		// {
		// panal_arr[k].add(label_arr[k]);
		// panal_arr[k].add(ComboBox_arr[k]);//有问题
		// }
		// 将面板放置在窗体CENTER位置
		// jcb2.setSize(3, 3);
		// panel.add(label_arr[1]);
		// panel.add(jcb2);//有问题
		// panel.add(label_arr[2]);
		// panel.add(jcb1);//有问题
		// getContentPane().add(panal_arr[0],BorderLayout.CENTER);
		this.add(panal1);
		this.add(panal3);
		this.add(panal2);
		this.add(panal4);
		// 网格布局2行一�?
		
		setSize(800, 800);
//		setVisible(true);
		
		// this.setLayout(gridLayout);
		// this.setLayout(new GridLayout(3, 14)); //列数�? jp1 = new JPanel(); 有关

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame1_JFrame2 u = new JFrame1_JFrame2();
		u.setVisible(true);
		System.out.println("Thread.sleep(1000*5)");
		 try {
				Thread.sleep(1000*5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		//u.setVisible(false);
		JFrame2_JFrame1 u2 = new JFrame2_JFrame1();
		u2.setVisible(true);
		
	}

}

