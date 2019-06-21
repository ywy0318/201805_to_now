package test_pro;

import java.util.TreeSet;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
//extends JFrame
public class SortedListModel extends AbstractListModel  {
	
	private static final long serialVersionUID=-8908769624938773296L;
	private TreeSet<Object> model=new TreeSet<Object>();
	public SortedListModel() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object getElementAt(int index) {	//获得模型中指定索引的值
		// TODO Auto-generated method stub
		return model.toArray()[index];
	}
	@Override
	public int getSize() { //获得模型中指定元素的个数
		// TODO Auto-generated method stub
		return model.size();
	}
	
	public void add(Object element)//向treeset中增加元素
	{
		if(model.add(element))
		{
			
//protected void firecontentschanged(object source,int index0,int index1)
//abstractlistmodel 子类必须在列表的一个或多个元素发生更改之后调用此方法。更改的元素由 index0 和 index1 封闭的区间（包括端点）指定。注意，index0 不必小于或等于 index1。
//参数：
//source - 更改的 listmodel，通常为 "this"
//index0 - 新区间的一端
//index1 - 新区间的另一端
			fireContentsChanged(this,0,getSize());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
