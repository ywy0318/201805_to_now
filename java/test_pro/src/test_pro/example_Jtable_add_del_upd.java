package test_pro;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class example_Jtable_add_del_upd extends JFrame{
	private DefaultTableModel tbmd;
	private JTable tb;
	private JTextField ajt;
	private JTextField bjt;
	public example_Jtable_add_del_upd() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("维护表格模型");
		this.setBounds(400, 400, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane sc=new JScrollPane();
		this.getContentPane().add(sc,BorderLayout.CENTER);
		String [] column_name={"A","B"};
		String [][] tb_value={{"A1","B1"},{"A2","B2"},{"A3","B3"}};
		tbmd = new DefaultTableModel(tb_value,column_name);
		tb = new JTable(tbmd);
		tb.setRowSorter(new TableRowSorter(tbmd));
		tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//ListSelectModel
		tb.addMouseListener(new MouseAdapter()//addMouseListener
		{
			public void mouseClicked(MouseEvent e)
			{
				int selectedRow = tb.getSelectedRow();
				Object oa = tbmd.getValueAt(selectedRow, 0);
				Object ob = tbmd.getValueAt(selectedRow, 1);
				ajt.setText(oa.toString());
				bjt.setText(ob.toString());
			}
			
		});
		sc.setViewportView(tb);
		final JPanel p = new JPanel();
		this.getContentPane().add(p,BorderLayout.SOUTH);
		p.add(new JLabel("A: "));
		ajt=new JTextField("A4",10);
		p.add(ajt);
		p.add(new JLabel("B: "));
		bjt=new JTextField("B4",10);
		p.add(bjt);
		final JButton abt=new JButton("add");
		p.add(abt);
		final JButton updbt = new JButton("update");
		abt.addActionListener(new ActionListener()//addActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				//
				String[] rowValues={ajt.getText(),bjt.getText()};
				tbmd.addRow(rowValues);
				int rowCount = tb.getRowCount()+1;
				ajt.setText("A"+rowCount);
				bjt.setText("B"+rowCount);
			}
		});
		updbt.addActionListener(new ActionListener()//addActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedRow = tb.getSelectedRow();
				if(selectedRow!=-1)
				{
					tbmd.setValueAt(ajt.getText(), selectedRow, 0);
					tbmd.setValueAt(bjt.getText(), selectedRow, 1);
				}
				

//				//
//				String[] rowValues={ajt.getText(),bjt.getText()};
//				tbmd.addRow(rowValues);
//				int rowCount = tb.getRowCount()+1;
//				ajt.setText("A"+rowCount);
//				bjt.setText("B"+rowCount);
			}
		});
		p.add(updbt);
		final JButton delbt = new JButton("delete");
		delbt.addActionListener(new ActionListener()//addActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedRows = tb.getSelectedRow();
				if(selectedRows!=-1)
				{
					tbmd.removeRow( selectedRows);					
				}
				if(selectedRows==0)//删除第一行
				{
				tb.setRowSelectionInterval(0, 0);
				}
				else if(selectedRows==tb.getRowCount())
				{
					//使用JTable的getRowCount()方法可以获得全部的行数
					tb.setRowSelectionInterval(tb.getRowCount()-2, tb.getRowCount()-1);
				}
				else//删除中间行
				{
					tb.setRowSelectionInterval(selectedRows-1, selectedRows);
				}
//				table.setRowSelectionInterval(int index0,int index1)//选择从 index0 到 index1 之间（包含两端）的行。
//				table.setRowSelectionInterval(0,0);//表示选中第一行
				//tb.sets
//				//
//				String[] rowValues={ajt.getText(),bjt.getText()};
//				tbmd.addRow(rowValues);
//				int rowCount = tb.getRowCount()+1;
//				ajt.setText("A"+rowCount);
//				bjt.setText("B"+rowCount);
			}
		});
		p.add(delbt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		example_Jtable_add_del_upd f=new example_Jtable_add_del_upd();
		f.setVisible(true);
	}

}
