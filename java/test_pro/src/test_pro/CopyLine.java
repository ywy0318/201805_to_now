package test_pro;
	

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLine {
		static String path1 = "E:\\zz\\192.168.1.1";
		static String str_for_file[]={"FromMvbLogFile.txt","FromPiscLogFile.txt","ToMvbLogFile.txt","ToPiscLogFile.txt"};
		
	    public static void main(String[] args) {
	    	
	    	File file=new File(path1,str_for_file[0]);//读取文件
			File file1=new File(path1,str_for_file[1]);//写入文件
			if(file.exists())
			{
				System.out.println("文件存在");
			}
			else
			{
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("创建成功!");
			}
			if(file1.exists())
			{
				System.out.println("file1 文件存在");
				//read_write(file1,file);
			}
			else
			{
				System.out.println("file1不存在");
			}
			
	        try {
	        	//源文件
	            BufferedReader br = new BufferedReader(new FileReader(file1));
	            //目的文件
	            PrintWriter out = new PrintWriter(new BufferedWriter(
	                    new FileWriter(file, true)));	         
	            String line = null;
	            while ((line = br.readLine()) != null) {               
	                out.println(line);        //向t.txt写入一行
	            }
	            System.out.println("3");
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


