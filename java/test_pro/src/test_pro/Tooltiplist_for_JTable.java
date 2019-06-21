package test_pro;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JList;

public class Tooltiplist_for_JTable extends JList {
	private static final long serialVersionUID=-5334116242803068391L;//随机的序列化标识
	private Object[][] data;
	public Tooltiplist_for_JTable(Object[][] dat) {
		// TODO Auto-generated constructor stub
		this.data=dat;
		Object[] listData = new Object[dat.length];
		
		for(int i=0;i<listData.length;i++)
		{
			listData[i]=dat[i][0];
		}
		setListData(listData);//设置列表项
	}
	@Override
	public String getToolTipText(MouseEvent event)
	{
		int index=locationToIndex(event.getPoint());//获得鼠标所在的位置的列表项的索引
		if(index>-1)
		{
			//返回提示信息
			return "<html><font face=微软雅黑 size=16 color=red>"+dat[index][1]+"</font></html>";
		}
		else
		{
			return super.getToolTipText(event);
		}
	}
	
	protected void do_this_windowsActived(WindowEvent e)
	{
		String [][] dt=new String[4][2];
		dt[0][0]="《java1》";
		dt[0][1]="《java2》";
		dt[1][0]="《java3》";
		dt[1][1]="《java4》";
		dt[2][0]="《java5》";
		dt[2][1]="《java6》";
		dt[3][0]="《java7》";
		dt[3][1]="《java8》";
		JList list = new ToolTipList(dt);
		list.setFont(new Font("微软雅黑",Font.PLAIN,16));
		J
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
