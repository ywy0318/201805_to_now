package test_pro;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboBox_test extends JFrame {

	public JComboBox_test()
	{
		
	String str1[] = { "正常/取消申请/接通后挂断", "申请", "接通(控制盒)", "接通(OCC-TPA)" };

	JComboBox<String>[] ComboBox= new JComboBox[48 + 5];
	 
	for (int i = 0; i < 4; i++) {
		
		ComboBox[i] = new JComboBox<String>(str1);
		
		ComboBox[i].setSelectedIndex(0);
		//jcb.setSelectedIndex(1);
		// System.out.println("sssssss");
		// this.add(ComboBox[i]);
	}
  }

	
	
}
