package test_pro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class write_to_file {
	
	static String path1 = "E:\\zz\\192.168.1.1";
	static String str_for_file[]={"FromMvbLogFile.txt","FromPiscLogFile.txt","ToMvbLogFile.txt","ToPiscLogFile.txt"};
	
	//read_write(源文件,目的文件)
	public static void read_write(File ff,File ff2)
	 {
		 byte[] buf = new byte[1024];
		 int length = 0;
		 long lengbackup=0;
		
			FileInputStream fileInputStream;
			FileOutputStream out = null;
			try {
				out=new FileOutputStream(ff2);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fileInputStream = new FileInputStream(ff);
				try {
					while((length = fileInputStream.read(buf)) != -1){
						//out.write(buf);
						out.write(buf, 0+lengbackup, length);//偏移量第二个
						lengbackup=length;
						System.out.print(new String(buf,0,length));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fileInputStream.close();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }	
	
	public static void main(String[] args) {
		
		File file=new File(path1,str_for_file[0]);
		File file1=new File(path1,str_for_file[1]);
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
			read_write(file1,file);
		}
		else
		{
//			try {
//				//file1.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("file1不存在");
		}
		
	}
	
//	public static void main(String[] args) {
//		String path = "D:\\xyl\\temp\\temp.txt";
//		File file = new File(path);
//		/*
//		 * 判断父目录是否存在
//		 * 	不存在：先创建父目录文件夹，再创建指定的文件。
//		 */
//		if(!file.getParentFile().exists()){
//			try {
//				file.getParentFile().mkdirs();
//				file.createNewFile();
//				System.out.println("创建成功!");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}


	
	
	
	
}
