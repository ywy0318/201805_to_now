package test_pro;

import java.lang.reflect.Array;



public class Array_newInstance_test {
	
	public static void main(String args[]) throws Exception {
		
		Class<?> classType = Class.forName("java.lang.String");
		// 创建一个长度为10的字符串数组
		Object array = Array.newInstance(classType, 10);
		// 把索引位置为5的元素设为"hello"
		Array.set(array, 5, "hello");
		// 获得索引位置为5的元素的值
		String s = (String) Array.get(array, 5);
		//String s = (String) Array.get(array, 0);
		System.out.println(s);
		}


}
