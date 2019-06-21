package test_pro;

import java.lang.reflect.Array;

public class Array_newInstance_test2 {
	
	public static void main(String args[]) {
		
		int[] dims = new int[] { 5, 10, 15 };
		//打印出来的是地址？？
		//System.out.println(dims);
		// 创建一个具有指定的组件类型和维度的新数组。
		Object array = Array.newInstance(Integer.TYPE, dims);
		//Object array =Array.newInstance(, arg1)
		// 取出三维数组的第3行，为一个数组
		Object arrayObj = Array.get(array, 3);
		Class<?> cls = arrayObj.getClass().getComponentType();
		
		System.out.println(cls);
		 
		// 取出第3行的第5列，为一个数组
		arrayObj = Array.get(arrayObj, 5);
		// 访问第3行第5列的第10个元素，为其赋值37
		Array.setInt(arrayObj, 10, 37);
		 
		// 动态数组和普通数组的转换：强行转换成对等的数组
		int arrayCast[][][] = (int[][][]) array;
		System.out.println(arrayCast[3][5][10]);
		}


}
