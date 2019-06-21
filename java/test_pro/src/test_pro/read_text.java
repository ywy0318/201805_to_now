package test_pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class read_text {
	
	static File file=new File("E:\\work\\h5s-r6.3.0831.18-win64-release\\conf","h5ss.conf");
	static File file_des=new File("E:\\work\\h5s-r6.3.0831.18-win64-release\\conf","ddd.conf");
	
	
//	public int ArrayList_foreach(String str)
//	{
//		for(int i=0;i<arraylist_for_user.size();i++)
//		{
//			if(arraylist_for_user.get(i).contains(str))
//			{
//				System.out.println(arraylist_for_user.get(i));
//				System.out.println(i);
//				return i;
//			}			
//		}
//		return -1;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
        	//源文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            //目的文件
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter(file_des, true)));
            ArrayList<String> arraylist_for_user = new ArrayList<String>();
//     	   把文件清空
          FileWriter fileWriter =new FileWriter(file_des);
          fileWriter.write("");
          fileWriter.flush();
          fileWriter.close();
            String line = null;
            
            int count=0;
            int count_sum=0;
            int count_back_up=0;
            int count_back_up_2=0;
            int count_back_up_for_del=0;
            int count_i=0;
            String strtemp="";
            String str_temp_t="";
            String [] str_array={};
            String [] str_array_2={};
            int i=0;
            String a="strName";
            String b = "\""+a+"\""+":";
            
            {
         	   //把文件清空
            FileWriter fileWriter2 =new FileWriter(file_des);
            fileWriter2.write("");
            fileWriter2.flush();
            fileWriter2.close();
            }
            while ((line = br.readLine()) != null) { 
            	
            	arraylist_for_user.add(line);
            	if(count==405)
            	{
            		arraylist_for_user.set(count, "sssssss0");
            	}
            	out.println(arraylist_for_user.get(count));        //向t.txt写入一行
            	//out.println(arraylist_for_user.get(i));        //向t.txt写入一行 
            	count++;
            }
            
            
          for(i=120;i<arraylist_for_user.size();i++)
          {
        	      str_array=arraylist_for_user.get(i).split("\"");
        	      if((str_array.length>=4)&&(!str_array[3].equals("")))
        	      {
        	    	//  System.out.println(str_array[3]); 
        	      }     		  
        	  if(arraylist_for_user.get(i).contains("Comment"))
        	  {
        		 // System.out.println(i);
        		  continue;
        	  }
        	  else
        	  {
        		  str_array=arraylist_for_user.get(i).split(":");
        		  
        		  for(int j=0;j<str_array.length;j++)
        		  {
        			  //System.out.println(str_array[j]);     		  
            		  
        		  }
        		  
        		 System.out.println();
        	  }
        	  
          	//System.out.println(arraylist_for_user.get(i));
        	  //out.println(arraylist_for_user.get(i));
          }
//          for(i=0;i<str_array.length;i++)
//          {
//        	  System.out.println(str_array[i]);
//          }
            count_sum=count;
//            System.out.println(count_sum);
            
            //count=0;
//          for(i=0;i<arraylist_for_user.size();i++)
//          {
//        	  str_temp_t=arraylist_for_user.get(i);
//       	   		//System.out.println(arraylist_for_user.get(i));&&(!(str_temp_t.contains("strNameComment")))
//        	  
//       	   	if(str_temp_t.contains("alarm_1_1_1_Stream_1"))
//       	   	{
//       	   	   System.out.println(i);
////       		   System.out.print(i+":");
////      		   System.out.println(str_temp_t);
//       		   count_back_up=i;
//       		   break;
//       	   	}
//       	   //out.println(arraylist_for_user.get(i));        //向t.txt写入一行
//          }
            	
            
            
            count_back_up_2=count_back_up+37;
            
//            for(i=count_back_up;i<=count_back_up_2;i++)
//            {
//            	strtemp=arraylist_for_user.get(i);
//            	if(strtemp.contains("},"))
//            	{
//            		System.out.println(i);
//            		count_back_up_for_del=i;
//            		System.out.println(strtemp);
//            		break;
//            	}
//            	if(i==37)
//            	{
//            		System.out.println(strtemp);
//            		System.out.println("no");
//            	}
//            }
//            System.out.println(count_back_up);
//            System.out.println(count_back_up_for_del);
            
//            for(i=count_back_up;i<=count_back_up_for_del;i++)
//            {
//            	arraylist_for_user.remove(i);
//            }
//          for(i=count_back_up;i<=count_back_up_for_del;i++)
//          {
//          	arraylist_for_user.add(i);count_back_up
//          }
//            count_back_up=(count_back_up-4);
//            System.out.println(arraylist_for_user.size());
//            //arraylist_for_user.add(arraylist_for_user.size()-1, "aaa");
//            //arraylist_for_user.set(arraylist_for_user.size()-1, "aaa");
//            //arraylist_for_user.add("aad");//count_back_up
//            //arraylist_for_user.set(arg0, arg1)
//            System.out.println("finish add");
//           // for(i=0;i<count_sum;i++)
//           for(i=0;i<arraylist_for_user.size();i++)
//            {
//            	//System.out.println(arraylist_for_user.get(i));
//        	   out.println(arraylist_for_user.get(i));
//            }
//            	else
//            	{
//            		//System.out.println(strtemp);
//            	}
            
            
//            	if(count==410)
//            	{
//            		out.println("aaa");        //向t.txt写入一行
//            	}
//            	else
//            	{
//            		out.println(line);        //向t.txt写入一行
//            		
//            	}
                
//            	if(count>=0)
//            	{
//            		//System.out.println(line);"strName":
////            		String a="123456";
////            		String b = "\""+a+"\"";
////            		引号需要转义下
//            		//pre 前缀
//            		//pos 后缀
//            		if(line.contains(b))
//            		//if(line.contains("strName":))
//            		//if(line.contains("},"))b
//            		{
//            			count_i++;
//            			System.out.println(line);
////            			System.out.print(line+"::");
////            			System.out.print(count+"::");
////            			System.out.println(true);
//            		}
////            		else{
////            			System.out.println(false);
////            		}
//            	}
            	
                
           
//           System.out.println(count_i);
//           System.out.println(count);
           System.out.println();
           
//        // 清空已有的文件内容，以便下次重新写入新的内容
//           public static void clearInfoForFile(String fileName) {
//               File file =new File(fileName);
//               try {
//                   if(!file.exists()) {
//                       file.createNewFile();
//                   }
//                   FileWriter fileWriter =new FileWriter(file);
//                   fileWriter.write("");
//                   fileWriter.flush();
//                   fileWriter.close();
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//           }

//           for( i=0;i<arraylist_for_user.size();i++)
//           {
//        	   System.out.println(arraylist_for_user.get(i));
//        	   //out.println(arraylist_for_user.get(i));        //向t.txt写入一行
//           }
           
           
           
            if (br != null) {
                br.close();
            }
            if (out != null) {
                out.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
