package test_pro;

import java.util.*;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
//import javax.swing.text.html.HTMLDocument.Iterator;有毒不是ArrayList的Iterator

//1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。 
//2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。 
//3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
//ArrayList插入、删除效率明显低于LinkedList
//ArrayList查询效率远远高于LinkedList
//通过上面的结构是不是就可以认为插入删除频繁选择LinkedList，追求查询效率就选择ArrayList呢，
//我们先来分析一下效率差别的原因，这个就跟数据结构有关系了，可以参考一些数据结构中链表的知识，
//arraylist 顺序表，用数组的方式实现。想想数组要查询那个元素只给出其下标即可，
//所以才说arraylist随机访问多的场景比较合适。但是如果删除某个元素比如第 i 个元素，
//则要将 i 之后的元素都向前移一位以保证顺序表的正确，增加也是一样，要移动多个元素。
//要多次删除增加的话是很低效的。而LinkedList是双向链表，注意是链表。要查询只能头结点开始逐步查询，
//没有什么给出下标即可直接查询的便利，需要遍历。但是，如果要增加后删除一个元素的话，
//只需要改变其前后元素的指向即可，不需要像arraylist那样整体移动，所以才说多用于增删多的场合。
//
//很感谢博友的建议与帮助，由于LinkedList查询只能从头结点开始逐步查询的，
//可以使用 iterator 的方式，就不用每次都从头结点开始访问，
//因为它会缓存当前结点的前后结点。实测查询效率与ArrayList没有太大差别
//Vector 是矢量队列，和ArrayList一样，它也是一个动态数组，由数组实现。
//但是ArrayList是非线程安全的，而Vector是线程安全的。
//Stack 是栈，它继承于Vector。它的特性是：先进后出(FILO, First In Last Out)。
//
//总结：
//   通过运行结果和查阅资料基本上验证了ArrayList和LinkedList效率问题，
//   有助于在以后的开发中根据实际场景选择合适的技术方案。

//ArrayXxx:底层数据结构是数组，查询快，增删慢
//LinkedXxx:底层数据结构是链表，查询慢，增删快
//HashXxx:底层数据结构是哈希表。依赖两个方法：hashCode()和equals()
//TreeXxx:底层数据结构是二叉树。两种方式排序：自然排序和比较器排序

//1、TreeSet 是二差树实现的,Treeset中的数据是自动排好序的，不允许放入null值。 
//自然排序
//自然排序使用要排序元素的CompareTo（Object obj）方法来比较元素之间大小关系，然后将元素按照升序排列。
//Java提供了一个Comparable接口，该接口里定义了一个compareTo(Object obj)方法，该方法返回一个整数值，实现了该接口的对象就可以比较大小。
//obj1.compareTo(obj2)方法如果返回0，则说明被比较的两个对象相等，如果返回一个正数，则表明obj1大于obj2，如果是 负数，则表明obj1小于obj2。
//如果我们将两个对象的equals方法总是返回true，则这两个对象的compareTo方法返回应该返回0
//定制排序
//自然排序是根据集合元素的大小，以升序排列，如果要定制排序，应该使用Comparator接口，实现 int compare(T o1,T o2)方法。
//
//2、HashSet 是哈希表实现的,HashSet中的数据是无序的，可以放入null，但只能放入一个null，
//两者中的值都不能重复，就如数据库中唯一约束。 
//
//3、HashSet要求放入的对象必须实现HashCode()方法，放入的对象，是以hashcode码作为标识的，
//而具有相同内容的 String对象，hashcode是一样，所以放入的内容不能重复。但是同一个类的对象可以放入不同的实例 

public class test_map_list_set {
	
	static ArrayList<String> Arraylist_0 = new ArrayList<String>();
	static LinkedList<String> LinkedList_0=new LinkedList<String>();
	static TreeSet<String> set_0=new TreeSet<String>();
	static TreeSet<Integer> set_1=new TreeSet<Integer>();
	static Map<String,String> map_1=new HashMap<String,String>();
	//static Set<String> set_0=new TreeSet<String>();
	//HashSet--TreeSet
	//static Set<String> set_0=new HashSet<String>();
	
	static final long N=50000*5*10;
	
	public static long Array_list_add()
	{
		long start=System.currentTimeMillis();
		for(int i=0;i<N;i++)
		{
			Arraylist_0.add(i,String.valueOf(i));
		}
		return (System.currentTimeMillis()-start);
	}
	
	public static long Linked_list_add()
	{
		long start1=System.currentTimeMillis();
		for(int ii=0;ii<N;ii++)
		{
			LinkedList_0.add(ii,String.valueOf(ii));
		}
		return (System.currentTimeMillis()-start1);
	}
	
	public static long Array_list_sreach()
	{
		long start2=System.currentTimeMillis();
		for(int i=0;i<N;i++)
		{
			Arraylist_0.get(i);
		}
		return (System.currentTimeMillis()-start2);
	}
	
	public static long Linked_list_sreach()
	{
		long start3=System.currentTimeMillis();
		for(int i=0;i<N;i++)
		{
			LinkedList_0.get(i);
		}
		return (System.currentTimeMillis()-start3);
	}
	
	public static long Array_list_remove()
	{
		long start2=System.currentTimeMillis();
		for(long i=N-1;i>=100;i--)
		{
			Arraylist_0.remove(i);
		}
		
		return (System.currentTimeMillis()-start2);
	}
	
	public static long Linked_list_remove()
	{
		long start3=System.currentTimeMillis();
		for(long i=N-1;i>=100;i--)
		{
			LinkedList_0.remove(i);
		}
		return (System.currentTimeMillis()-start3);
	}
	
//	
//	1.增强for循环
////其内部实质上还是调用了迭代器遍历方式，这种循环方式还有其他限制，不建议使用。
//	for(String str : list) {
//	    System.out.println(str);
//	}
//	2.普通for循环
//
//	for( int i = 0 ; i < list.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
//	    System.out.println(list.get(i));
//	}
//	3.迭代器遍历
////执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
//	Iterator<String> iter = list.iterator();
//	while(iter.hasNext()){  
//	    System.out.println(iter.next());
//	}
//	
	public static void Array_list_2()
	{
		for(int i=0;i<20;i++)
		{
			if(i>=10)
			{
			Arraylist_0.add(i,String.valueOf(10-(i-10)));
			}
			else{
			Arraylist_0.add(i,String.valueOf(10-i));
			}
		}
		System.out.println(Arraylist_0.size()+":Arraylist_0.size");
		for(int i=0;i<Arraylist_0.size();i++)
		{
			System.out.println(Arraylist_0.get(i));
		}
	}
	//使用迭代器Iterator遍历list中的元素 迭代器有毒
	public static void Array_list_It_1()
	{
		for(int i=0;i<10;i++)
		{
			Arraylist_0.add("string"+String.valueOf(i));
		}
		Iterator<String> it= Arraylist_0.iterator();
//		while(it.hasNext())
//		{
//			System.out.println((String)it.next());			
//		}
//		System.out.println("sss");
		
		while(it.hasNext())
		{
			System.out.print("sss:");
			System.out.println((String)it.next());
			if(it.next().equals("string3"))
			{
				it.remove();
			}
		}
		
		it=Arraylist_0.iterator();//***删除后要重新定义迭代器
		System.out.println("after remove");
		while(it.hasNext())
		{
			
			System.out.println((String)it.next());			
		}
		return;
	}
	
	public static void set_init()
	{
		set_0.addAll(Arraylist_0);
		Iterator<String> it1=set_0.iterator();
		while(it1.hasNext())
		{
			System.out.println(it1.next());
		}
		return;
	}
	public static void set1_init()
	{
		for(int i=0;i<10;i++)
		{
			set_1.add(i);
		}
		return;
	}
	
	public static void map_1_init()
	{
		String[] str1={"tianjin","beijing","shanghai","chongqing"};
		String[] str2={"apple","orange","orange","pear"};
//		map_1.put("1", "apple");
//		map_1.put("2", "apple");
//		map_1.put("3", "orange");
//		map_1.put("2", "orange");
//		for(int i=1;i<4;i++)
//		{
//			System.out.println(String.valueOf(i)+":"+map_1.get(String.valueOf(i)));
//		}
		for(int i=0;i<str2.length;i++)
		{
			map_1.put(str1[i], str2[i]);
		}
		//map_1.put
		System.out.println(map_1);
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String a="A";
//		String b="B";
//		String c="C";
//		String d="D";
//		String e="E";
//		LinkedList<String> list=new LinkedList<String>();
//		list.add(a);
//		list.add(e);
//		list.add(d);
//		Iterator firstIt=(Iterator) list.iterator();//创建集合的迭代器
//		while(firstIt.hasN)
//		System.err.println("sssssss");
//		Array_list_2();
		//可以直接打印list
//		System.out.println("Arraylist_0");
//		System.out.println(Arraylist_0);
//		System.out.println("set_init");
//		set_init();
//		set_0.add("11");
//		set1_init();
//		System.out.println(set_1.size());
//		System.out.println(set_1);
//		
//        System.out.println(set_1.first()); // 输出第一个元素TreeSet的函数
//        System.out.println(set_1.lower(4)); //小于3333的最大元素
//        System.out.println(set_1.higher(7)); //大于2222的最大元素
//        System.out.println(set_1.floor(4)); //不大于3333的最大元素
//        System.out.println(set_1.ceiling(5)); //不小于3333的最大元素
//        System.out.println("set_1.pollFirst()"+"set_1.pollLast()");
//        System.out.println(set_1.pollFirst()); //删除第一个元素 TreeSet的函数
//        System.out.println(set_1.pollLast()); //删除最后一个元素TreeSet的函数
//        
//        System.out.println(set_1.size());
//		//HashSet--TreeSet都可以直接打印出来
//		System.out.println(set_1);
	//	Array_list_It_1();
//		System.out.println("Array_list_add:"+Array_list_add());
//		System.out.println("Linked_list_add:"+Linked_list_add());
//		System.out.println("Array_list_sreach:"+Array_list_sreach());
//		System.out.println("Linked_list_sreach:"+Linked_list_sreach());
//		System.out.println("Array_list_remove:"+Array_list_remove());
//		System.out.println("Linked_list_remove:"+Linked_list_remove());
		
		map_1_init();
		Set<String> set_0=map_1.keySet();//该方法返回map中所有key值的列表。
//		System.out.println(set_0);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
