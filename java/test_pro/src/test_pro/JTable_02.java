package test_pro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class JTable_02 extends JFrame {

	public JTable_02() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("定义表格");
		this.setBounds(400, 400, 500, 375);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane sc = new JScrollPane();
		JPanel buttonpanel = new JPanel();
		JButton selectAllbt=new JButton("全部选择");
		JButton clearAllbt=new JButton("取消选择");
		this.getContentPane().add(sc,BorderLayout.CENTER);
		this.getContentPane().add(buttonpanel,BorderLayout.SOUTH);
		buttonpanel.add(selectAllbt);
		buttonpanel.add(clearAllbt);
		
		String column_name[]={"A","B","C","D","E","F","G"};
		Vector cv = new Vector();
		for(int i=0;i<column_name.length;i++)
		{
			cv.add(column_name[i]);
		}
		Vector tablevalue_v = new Vector();
		for(int i=0;i<21;i++)
		{
			Vector row_v = new Vector();
			for(int j=0;j<column_name.length;j++)
			{
				row_v.add(column_name[j]+i);
			}
			tablevalue_v.add(row_v);
		}
		JTable table = new MTable(tablevalue_v,cv);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭表格列的自动调整工程
		table.setRowSelectionInterval(1, 3);//设置选中行
		table.addRowSelectionInterval(5, 5);//添加选中行行
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//选择模式为单选
		//table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);//允许连续选择多个
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//可以随意选择多个
		table.setSelectionBackground(Color.YELLOW);
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30);
		sc.setViewportView(table);
		
		selectAllbt.addActionListener(new ActionListener()//addActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				table.selectAll();
			}
		});
		clearAllbt.addActionListener(new ActionListener()//addActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				table.clearSelection();
			}
		});
		System.out.println("表格共有"+table.getRowCount()+"行"+table.getColumnCount()+"列");
		System.out.println("共有"+table.getSelectedRowCount()+"行被选中行");
		System.out.println("第三行的选择状态为:"+table.isRowSelected(2));
		System.out.println("第5行的选择状态为:"+table.isRowSelected(4));
		System.out.println("第1行的选择的索引是:"+table.getSelectedRow());
		int []selectedRows=table.getSelectedRows();
		for(int i=0;i<selectedRows.length;i++)
		{
			System.out.println(selectedRows[i]+" ");
		}
		System.out.println();
		System.out.println("移动前第二列的名称："+table.getColumnName(1));
		System.out.println("移动前第2行二列的值："+table.getValueAt(1, 1));
		table.moveColumn(1, 5);//将索引1的列移动到索引5处
		System.out.println("移动前第二列的名称::："+table.getColumnName(1));
		System.out.println("移动前第2行二列的值::："+table.getValueAt(1, 1));
		//setValueAt(Object aValue,int rowIndex,int columnIndex)
		table.setValueAt(999, 0, 0);
	}
	public class MTable extends JTable
	{
		public MTable(Vector rowdata,Vector columndata)
		{
			super(rowdata,columndata);
		}
		@Override
		public JTableHeader getTableHeader()
		{
			JTableHeader tableheader = super.getTableHeader();
			tableheader.setReorderingAllowed(false);//设置表格列不可重排
			//获得表格头的单元格对象
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableheader.getDefaultRenderer();
			return tableheader;
		}
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass)
		{
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass);
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return cr;
		}
		@Override
		public boolean isCellEditable( int row ,int column)
		{
			return true;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTable_02 jt=new JTable_02();
		jt.setVisible(true);
	}
	
	
}
