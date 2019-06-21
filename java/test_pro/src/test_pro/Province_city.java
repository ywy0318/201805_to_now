package test_pro;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Province_city {

	String[] province={"北京","上海","天津","重庆","辽宁","吉林","黑龙江"};
	String[] city_fot_b={"北京"};
	String[] city_fot_s={"上海"};
	String[] city_fot_t={"天津"};
	String[] city_fot_c={"重庆"};
	String[] city_for_h={"哈尔滨","齐齐哈尔","牡丹江","大庆","伊春","双鸭山"
			,"鹤岗","鸡西","佳木斯","七台河","黑河","绥化","大兴安岭"};
	String[] city_for_j={"长春","吉林","延边","白山","白城","四平","松原","辽源"
			,"大安","通化"};
	String[] city_for_l={"沈阳","大连","葫芦岛","旅顺","本溪","抚顺","铁岭","辽阳"
			,"营口","阜新","朝阳","锦州","丹东","鞍山"};
	
	static Map<String,String[]> model=new HashMap<String,String[]>();
	
	String[] p_array=new String[7];
	String[] c_array={};
	//String[] c_array={};
	//String p_select="北京";
	String p_select="";
	String ComboBox0_backup="";	
	
	JFrame jf = new JFrame("测试窗口");
	JPanel panel = new JPanel();// 20	
	JComboBox<String>[]  ComboBox = new JComboBox[2];
	JLabel[] label_arr= new JLabel[2];
	
	public Province_city(){
		
		
		Timer timer = new Timer();		
		model.put(province[0], city_fot_b);
		model.put(province[1], city_fot_s);
		model.put(province[2], city_fot_t);
		model.put(province[3], city_fot_c);
		model.put(province[4], city_for_l);
		model.put(province[5], city_for_j);
		model.put(province[6], city_for_h);
		label_arr[0]=new JLabel("省/直辖市");	
		label_arr[1]=new JLabel("市/县");
		Set<String> set_0=model.keySet();
		System.out.println(set_0);
		set_0.toArray(p_array);
		ComboBox[0]=new JComboBox<String>(p_array);	
		p_select=(String) ComboBox[0].getSelectedItem();
		c_array=model.get(p_select);
			
		ComboBox[1]=new JComboBox<String>(c_array);
		ComboBox[0].setSelectedIndex(0);
		
//		ComboBox[0].addItemListener(new ItemListener()
//		{
//			public void itemStateChanged(ItemEvent event){
//            	p_select=(String) ComboBox[0].getSelectedItem();
//            	if(p_select.equals(ComboBox0_backup))
//            	{
//            		
//            	}
//            	else
//            	{
//            		reload();
//            	}
//			}
//		});
		
		   timer.scheduleAtFixedRate(new TimerTask() {
	            public void run() 
	            {	 
	            	p_select=(String) ComboBox[0].getSelectedItem();
	            	if(p_select.equals(ComboBox0_backup))
	            	{
	            		
	            	}
	            	else
	            	{
	            		reload();
	            	}
	            }
	        }, 1000, 1000);
		   label_arr[0].setSize(200, 200);
		   //label_arr[0].setForeground(Color.BLUE);
		   label_arr[1].setSize(200, 200);
		   //label_arr[1].setForeground(Color.RED);
		   ComboBox[0].setSize(200, 200);
		  // ComboBox[0].setForeground(Color.BLUE);
		   ComboBox[1].setSize(200, 200);
		   //ComboBox[1].setForeground(Color.RED);
		   //panel.setSize(100, 100);
		   panel.add(label_arr[0]);
		   panel.add(ComboBox[0]);
		   panel.add(label_arr[1]);
		   panel.add(ComboBox[1]);
		   jf.add(panel);
		   jf.setSize(500, 500);
			jf.setVisible(true);
		   jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
			
		   jf.addWindowListener(new WindowAdapter()
			{
				public void JFClose(WindowEvent w)
				{
					System.exit(0);
				};
			});
		   

	}
	
	public void reload()
	{
		ComboBox0_backup=p_select;
		ComboBox[1].removeAllItems();
		c_array=model.get(p_select);
		ComboBox[1].setModel(new DefaultComboBoxModel(c_array));
	}
	
	public static void main(String[] args) 
	{
		Province_city c=new Province_city();
	}
	
}
