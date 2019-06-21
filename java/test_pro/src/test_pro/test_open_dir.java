package test_pro;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

public class test_open_dir
{
public static void main(String args[])
{
	//new test_open_dir().init();
	//new test_open_dir().test();
	//new test_open_dir().test2();
	new test_open_dir().test4();
}
public void init(){
	final JFileChooser j = new JFileChooser(new File("d:\\"));
	final JFrame jf=new JFrame();
	JButton jbtn=new JButton("我点");
	jf.add(jbtn);
	jbtn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
	j.showOpenDialog(jf);
		}
	});
	jf.setVisible(true);
	jf.setSize(300,300);
	jf.setBounds(400, 400, 400, 400);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void test(){
				int flag=0;
				JFileChooser fc=new JFileChooser(new File("e:\\zz"));
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择目录
				String path=null;
				File f=null;
				try{
					flag=fc.showOpenDialog(null);
				}
				catch(HeadlessException head){
					System.out.println("Open File Dialog ERROR!");
				}
				//JFileChooser.APPROVE_OPTION获得选中的文件对象
				if(flag==JFileChooser.APPROVE_OPTION){
					//获得该文件
					f=fc.getSelectedFile();
					path=f.getPath();
					System.out.println("path:"+path);
				}
				//以上获得选择的文件夹
				//若要判断其中是否还有其他目录，可以这样做
				boolean hasSubDir=false;
				File dir=new File(path);
				//获得改目录下的文件的文件名，如果没有的话，filesName.length()=0
				String[] filesName=dir.list();
				for(int i=0;i<filesName.length;i++)
				{
					System.out.println(filesName[i]);
				}
				for(int i=0;i<filesName.length;i++){
					File temp=new File(path+"/"+filesName[i]);
					//System.out.println(path+"/"+filesName[i]);
					if(temp.isDirectory()){
						hasSubDir=true;
						//break;
					}
				}

				}

		public void test2()
		{
			//new File("e:\\zz")
//		    JFileChooser fc = new JFileChooser("."); //在当前目录下，创建文件选择器
			JFileChooser fc = new JFileChooser(new File("e:\\zzzz")); //在当前目录下，创建文件选择器
		    ExcelFileFilter excelFilter = new ExcelFileFilter(); //excel过滤器  
		    fc.addChoosableFileFilter(excelFilter);
		    fc.setFileFilter(excelFilter);
		    String path=null;
			File f=null;
			FileInputStream fis=null;
		    if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		       //// TODO Auto-generated method stub
		    	//选中文件以后干嘛
		    	f=fc.getSelectedFile();
		    	path=f.getPath();
		    	System.out.println("path:"+path);
		    	try {
					 fis= new FileInputStream(f);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 int b;
		    	
		         try {
					while ((b = fis.read()) != -1) {
					     System.out.print((char)b);
					 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         // 4.关闭相应的流
		         try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
//	    	if(flag==JFileChooser.APPROVE_OPTION){
//				//获得该文件
//				f=fc.getSelectedFile();
//				path=f.getPath();
//				System.out.println("path:"+path);
//			}
		}
		
		class ExcelFileFilter extends FileFilter {  
		    public String getDescription() {  
		        return "*.xls;*.xlsx";  
		    }  
		  
		    public boolean accept(File file) {  
		        String name = file.getName();  
		     // 仅显示目录和xls、xlsx文件
		        return file.isDirectory() || name.toLowerCase().endsWith(".xls") || name.toLowerCase().endsWith(".xlsx");  
		    }  
		}  

		public void test4()
		{
			FileFilterTest fileFilter=new FileFilterTest ();  //创建过滤器对象
			JFileChooser jf=new JFileChooser(new File("e:\\zzz"));
			
			jf.addChoosableFileFilter(fileFilter);
			jf.setFileFilter(fileFilter);   //对JFileChooser设置过滤器
			String path=null;
			File f=null;
			if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
			{
				f=jf.getSelectedFile();
		    	path=f.getPath();
		    	System.out.println("path:"+path);
			}
		}
		public class FileFilterTest extends javax.swing.filechooser.FileFilter{
		
			public boolean accept(java.io.File f) {
				String name = f.getName();
				if (f.isDirectory())return true;
				return f.getName().endsWith(".mp3");  //设置为选择以.class为后缀的文件
				//return f.getName().endsWith(".class");  //设置为选择以.class为后缀的文件
				//return f.isDirectory() || name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".mp3");
			}
			public String getDescription(){
				return ".mp3";
				//return ".class";
			}
			
		}
//
//	实现JFileChooser的文件类型限制(设置过滤器) (2011-05-14 23:08:06)转载▼
//	标签： jfilechooser filefilter 文件类型 杂谈	分类： JAVA
//	//很简单，就如下面这样一个小样例程序，根据自己的需要改就可以了：
//	import javax.swing.JFileChooser;
//	public class FileFilterTest extends javax.swing.filechooser.FileFilter{
//	  public boolean accept(java.io.File f) {
//	    if (f.isDirectory())return true;
//	    return f.getName().endsWith(".class");  //设置为选择以.class为后缀的文件
//	  } 
//	  public String getDescription(){
//	    return ".class";
//	  }
//	public static void main(String args[]) {
//	  FileFilterTest fileFilter=new FileFilterTest ();  //创建过滤器对象
//	  JFileChooser jf=new JFileChooser();
//	  jf.setFileFilter(fileFilter);   //对JFileChooser设置过滤器 
//	  jf.showOpenDialog(null);
//	  }
//	}
//
//
//	       用FileFilter来实现JFileChooser文件类型的过滤，如上边的代码。
//	这样，当JFileChooser启动的时候，就能默认只显示以.class为后缀名的文件。
//




//		JFileChooser dlg = new JFileChooser();
//		dlg.setDialogTitle("Open JPEG file");
//		int result = dlg.showOpenDialog(this);  // 打开"打开文件"对话框
//		// int result = dlg.showSaveDialog(this);  // 打"开保存文件"对话框
//		if (result == JFileChooser.APPROVE_OPTION) {
//		File file = dlg.getSelectedFile();
//		...
//		}























}
	

