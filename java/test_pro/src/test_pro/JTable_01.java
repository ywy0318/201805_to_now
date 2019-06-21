package test_pro;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class JTable_01 extends JFrame{

	public JTable_01() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("可以滚动的表格");
		this.setBounds(400, 400, 240, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
		Vector column_name=new Vector();
		column_name.add("A");
		column_name.add("B");
		
		Vector table_value = new Vector();
		for(int i=0;i<6;i++)
		{
			Vector rowv = new Vector();
			rowv.add("a"+(i*2+0));
			rowv.add("b"+(i*2+1));
			table_value.add(rowv);
		}
		
			JTable table1=new JTable(table_value,column_name);
			getContentPane().add(table1,BorderLayout.CENTER);
			JTableHeader tableheader = table1.getTableHeader();
			getContentPane().add(tableheader,BorderLayout.NORTH);
		
		}
		{
//		String column_name[]={"A","B"};
//		String table_values[][]={{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}};
//		JTable table =new JTable(table_values,column_name);
//		JScrollPane js=new JScrollPane(table);
//		getContentPane().add(js,BorderLayout.CENTER);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTable_01 jt=new JTable_01();
		jt.setVisible(true);
	}

}
