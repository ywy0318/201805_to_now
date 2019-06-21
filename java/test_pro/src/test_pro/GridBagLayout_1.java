package test_pro;


	

	 
	import java.awt.Container;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
	 
	import javax.swing.JButton;
	import javax.swing.JFrame;
	 
	/**
	 * 使用网格组布局管理器
	 * @author HAN
	 *
	 */
	public class GridBagLayout_1 extends JFrame {
	 
		/**
		 * 
		 */
		private static final long serialVersionUID = 5558640733909970067L;
	 
		public GridBagLayout_1() {
			// TODO Auto-generated constructor stub
			Container container = getContentPane();
//			container.setLayout(new GridBagLayout());
			GridBagLayout gridBagLayout = new GridBagLayout();
			
			container.setLayout(gridBagLayout);
			JButton button = new JButton("A");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 10;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			container.add(button, gridBagConstraints);
			//
			JButton button_1 = new JButton("B");
			GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
			gridBagConstraints_1.gridx = 1;
			gridBagConstraints_1.gridy = 0;
			gridBagConstraints_1.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints_1.weightx = 20;
			gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
			container.add(button_1, gridBagConstraints_1);
			//
			JButton button_2 = new JButton("C");
			GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
			gridBagConstraints_2.gridx = 2;
			gridBagConstraints_2.gridy = 0;
			gridBagConstraints_2.gridheight = 2;
			gridBagConstraints_2.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints_2.weightx = 30;
			gridBagConstraints_2.fill = GridBagConstraints.BOTH;
			container.add(button_2, gridBagConstraints_2);
			JButton button_3 = new JButton("D");
			GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
			gridBagConstraints_3.gridx = 3;
			gridBagConstraints_3.gridy = 0;
			gridBagConstraints_3.gridheight = 4;
//			gridBagConstraints_3.insets = new Insets(0, 5, 0, 5);
			gridBagConstraints_3.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints_3.weightx = 40;
//			gridBagConstraints_3.fill = GridBagConstraints.BOTH;
			gridBagConstraints_3.fill = GridBagConstraints.VERTICAL;
			container.add(button_3, gridBagConstraints_3);
			JButton button_4 = new JButton("E");
			GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
			gridBagConstraints_4.gridx = 0;
			gridBagConstraints_4.gridy = 1;
			gridBagConstraints_4.gridwidth = 2;
			gridBagConstraints_4.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
			container.add(button_4, gridBagConstraints_4);
			JButton button_5 = new JButton("F");
			GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
			gridBagConstraints_5.gridx = 0;
			gridBagConstraints_5.gridy = 2;
			gridBagConstraints_5.gridwidth = 1;
			gridBagConstraints_5.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
			container.add(button_5, gridBagConstraints_5);
			JButton button_6 = new JButton("G");
			GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
			gridBagConstraints_6.gridx = 1;
			gridBagConstraints_6.gridy = 2;
			gridBagConstraints_6.gridwidth = 2;
			gridBagConstraints_6.gridheight = 2;
			gridBagConstraints_6.insets = new Insets(5, 5, 0, 0);
			gridBagConstraints_6.fill = GridBagConstraints.NONE;
//			gridBagConstraints_6.anchor = GridBagConstraints.EAST;
			gridBagConstraints_6.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints_6.ipadx = 30;
			container.add(button_6, gridBagConstraints_6);
			
			JButton button_7 = new JButton("H");
			GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
			gridBagConstraints_7.gridx = 0;
			gridBagConstraints_7.gridy = 3;
			gridBagConstraints_7.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints_7.fill = GridBagConstraints.BOTH;
			container.add(button_7, gridBagConstraints_7);
		}
	 
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			GridBagLayout_1 frame = new GridBagLayout_1();
			frame.setTitle("使用网格组布局管理器");
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			//frame.setBounds(400, 400, 500, 400);
		}
	 
	}


