package test_pro;

import java.util.regex.Pattern;

public class test_regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="Mrkj008";
		String str2="mrks009";
		String str3[]={"aaa@","aaaa","aaaas@qq.com","fff@111.com"};
		String str4[]={"12244225533","13522334455","17044009988"};
		String str5[]={"192.168.13.1","192.168.11.1"};
		String str6="java软件开发开发开发";
		String regex_for_email="\\w{0,}\\@\\w{0,}\\w{0,}\\.{1}\\w{0,}";//正则表达式 定义邮箱格式
		String regex_for_phone_num="1[3,5,8]\\d{9}$";
		String regex_for_ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
							  +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
							  +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
							  +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
//		String regex_for_ip1 ="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
//						      +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
//                              +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
//                              +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		String regex_for_chinese="^[\u4E00-\u9FA5]{0,}$";//用于检测字符串中汉字个数
		boolean bool1=str1.matches("\\p{Upper}\\p{Lower}{3}\\d{3}");
		boolean bool2=str2.matches("\\p{Upper}\\p{Lower}{3}\\d{3}");
//		boolean bool1=str1.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
//		boolean bool2=str2.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
//		System.out.println(str1+":"+bool1);
//		System.out.println(str2+":"+bool2);
		for(int i=0;i<str3.length;i++)
		{
			//System.out.println(str3[i].matches(regex));
			if(str3[i].matches(regex_for_email))
			{				
				//System.out.println(str3[i]+":"+"is a email address");
			}
			else
			{
				//System.out.println(str3[i]+":"+"is not a email address");
			}
		}
		
		for(int i=0;i<str4.length;i++)
		{
			//System.out.println(str3[i].matches(regex));
			if(str4[i].matches(regex_for_phone_num))
			{				
				//System.out.println(str4[i]+":"+"is a phone_num");
			}
			else
			{
				//System.out.println(str4[i]+":"+"is not a phone_num");
			}
		}
		for(int i=0;i<str5.length;i++)
		{
			//System.out.println(str3[i].matches(regex));
			if(str5[i].matches(regex_for_ip))
			{				
				//System.out.println(str5[i]+":"+"is a regex_for_ip");
			}
			else
			{
				//System.out.println(str5[i]+":"+"is not a regex_for_ip");
			}
		}
		for(int i=0;i<str6.length();i++)
		{
//			System.out.print(str6.charAt(i));
//			System.out.print(":");
//			System.out.println(""+str6.charAt(i));
			if(Pattern.matches(regex_for_chinese, ""+str6.charAt(i)))
			{				
				//System.out.println(str6.charAt(i)+":"+"is a regex_for_chinese");
			}
			else
			{
				//System.out.println(str6.charAt(i)+":"+"is not a regex_for_chinese");
			}
		}
		
	}

}
