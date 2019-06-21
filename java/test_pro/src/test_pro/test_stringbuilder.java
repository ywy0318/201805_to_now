package test_pro;

import java.sql.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test_stringbuilder {

	public static void main(String[] args) 
	{
		/*******************/
//		String str1="";
//		System.out.println("main is running");
//		long startime=System.currentTimeMillis();
//		for(long i=0;i<100000*1;i++)//*5的话一直等待
//		{
//			str1+=i;
//		}
//		long endtime=System.currentTimeMillis();
//		long time0=endtime-startime;
//		System.out.println(time0);
//		StringBuilder builder=new StringBuilder("");
//		long startime1=System.currentTimeMillis();
//		for(long j=0;j<100000*1;j++)
//		{
//			builder.append(j);
//			
//		}
//		long endtime1=System.currentTimeMillis();
//		long time1=endtime1-startime1;
//		System.out.println(time1);
	/***************/
		//System.out.println("main is running");
//		String str="good";
//		//StringBuffer buffer=new StringBuffer(str);
//		StringBuilder builder=new StringBuilder();
//	//	builder.append(buffer);
//		builder.append(str);
//		builder.insert(1, "dd");
//		System.out.println(builder);
//		builder.delete(1, 1);//如果start和end的位置相同,字符串生成器的值不变，原样输出
//		System.out.println(builder);
//		builder.delete(1, 2);//如果start和end的位置不同,字符串生成器索引start的值被删掉,end的值保留，原样输出
//		System.out.println(builder);
//		builder.deleteCharAt(0);
//		System.out.println(builder);
		/***********************/
//		String text="明日科技soft";
//		char []char_array=text.toCharArray();//获取字符串的字符数组
//		StringBuilder builder=new StringBuilder();
//		for(char c:char_array)//遍历字符数组
//		{
//			System.out.println(c);
//			builder.append((int)c+" ");//转化成Unicode码并且追加到builder
//		}
//		System.out.print(text+"builder"+":");
//		System.out.println(builder);
//		System.out.print(text+"tostrin"+":");
//		System.out.println(builder.toString());
		/************************/
//		//可能有点问题删除不干净
////		String str="sssdddwwwwaaas";
//		String str="喵喵喵喵喵喵喵喵喵喵喵喵喵喵喵";//结束以后剩下4个喵
////		String str="我们一起学猫叫一起喵喵喵喵喵在你面前撒个娇哎呦喵喵喵喵喵";
//		StringBuilder builder=new StringBuilder(str);
//		System.out.println("old:"+builder);
//		System.out.println("old:"+builder.length());
//		for(int i=0;i<builder.length();i++)
//		{
//			for(int j=i+1;j<builder.length();) //每个字符跟它后面的所有字符比较
//			{
////				System.out.print(i+":");
////				System.out.print(builder.charAt(i)+":");
////				System.out.println(builder.charAt(j));
//				if(builder.charAt(i)==builder.charAt(j))
//				{
//					//删除的时候索引改变了所以有问题
//					builder.deleteCharAt(j);	//str.deleteCharAt(j);字符串没有删除函数...
//				}
//				else
//				{
//					j++;//这样就全部剔除重复的了,
//				}
//			}
////			System.out.println(i+":"+builder);
//		}
//		System.out.println("new:"+builder);
//		System.out.println("new:"+builder.length());
//		
		/**********************/
//		//中文有问题
//		String str="我爱 Java";
//		char se='祈';
//		System.out.println(str);
//		System.out.println(EAndU(str,se));
//		System.out.println(EAndU(EAndU(str,se),se));
		/************/
//		String str="这首《咏雪》";
//		StringBuilder builder=new StringBuilder(str);
//		builder.reverse();
//		System.out.println(builder);
//		int count=0;
//		for(int i=0;i<str.length();i++)
//		{
//			if(str.charAt(i)!=builder.charAt(i))
//			{
//				System.out.println(str+"is not 回文诗");
//				break;
//			}
//			if(str.charAt(i)==builder.charAt(i))
//			{
//				count++;
//			}
//			
//		}
//		if(count==str.length())
//		{
//			System.out.println(str+"is 回文诗");
//		}
		//System.out.println(builder.reverse());
		/****************/
//		String str1="  java class  ";
//		String str2 = str1.trim();
//		System.out.println(str1.length());
//		System.out.println(str2.length());
//		System.out.println(str2);
//		System.out.println(str1);
		/****************/
//		String str1=" we are student";
////		String str2=str1.replace(" ", "");
////		System.out.println(str2);
//		StringTokenizer st=new StringTokenizer(str1," ");
//		//System.out.println(st);
//		StringBuffer s=new StringBuffer();
//		int i=1;
//		while(st.hasMoreTokens())//判断字符串中是否还有空格
//		{
//			//i++;
//			s.append(st.nextToken());
//			//System.out.println(st.nextToken());
//		}
//		System.out.println(s.toString());
		/****************/
//比较运算符"=="比较的事内存位置,不适合拿来比较字符串,但是整型等可以用"=="比较运算符比较
//equals()方法比较的两个字符串的内容必须完全一样,
//equalsIgnoreCase()方法忽略大小写的情况下比较内容必须一样
//内存和对象的对应关系
//		String s1=new String("i am a student");
//		String s2=new String("i am a student");
//		String s3=new String("I AM A STUDENT");
//		String s4=s1;
//		boolean b1=(s1==s2);
//		boolean b2=(s1==s4);
//		boolean b3=s1.equals(s2);
//		boolean b4=s1.equals(s3);
//		boolean b5=s1.equalsIgnoreCase(s1);
//		boolean b6=s1.equalsIgnoreCase(s2);
//		System.out.println("s1==s2"+b1);
//		System.out.println("s1==s4"+b2);
//		System.out.println("s1.equals(s2)"+b3);
//		System.out.println("s1.equals(s3)"+b4);
//		System.out.println("s1.equalsIgnoreCase(s1)"+b5);
//		System.out.println("s1.equalsIgnoreCase(s2)"+b6);
		
		/******************/
		//Character.isDigit();
		/*******************/
//		String s=new String("abc,df!fff!ghi!gki");
//		String[] news=s.split(",|!");
//		//String[] news=s.split(",",2);
//		for(int i=0;i<news.length;i++)
//		{
//			System.out.println(news[i]);
//		}
		
//		String s="1234567890";
//		char []sd=s.toCharArray();
//		for(int i=0;i<sd.length;i++)
//		{
//			
//			System.out.println(String.valueOf(sd[i])+Character.isDigit(sd[i]));
//		}
		//Date today = new Date(0);
		 Date today = new Date(118, 10, 8);//有毒,简直不能用
//		System.out.println(String.format(Locale.US, "%tb",today));
//		System.out.println(String.format(Locale.US, "%tB",today));
//		System.out.println(String.format("%ta",today));
//		System.out.println(String.format("%tA",today));
//		System.out.println(String.format("%tY",today));
//		System.out.println(String.format("%ty",today));
//		System.out.println(String.format("%tm",today));
//		System.out.println(String.format("%td",today));
//		System.out.println(String.format("%te",today));
//		System.out.println(String.format("%tH",today));
//		System.out.println(String.format("%tI",today));
//		System.out.println(String.format("%tk",today));
//		System.out.println(String.format("%tl",today));
//		System.out.println(String.format("%tM",today));
//		System.out.println(String.format("%tm",today));
//		System.out.println(String.format("%tz",today));
//		System.out.println(String.format("%tp",today));
		 
//		 Scanner sc=new Scanner(System.in);
//		 //String convert=convert();
//		 System.out.println(sc.next());
}
	
	
	


	public static String EAndU(String strtemp,char secret)
	{
		byte[] by=strtemp.getBytes();
		for(int i=0;i<by.length;i++)
		{
			by[i]=(byte)(by[i]^(int)secret);
		}
		return new String(by,0,by.length);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
