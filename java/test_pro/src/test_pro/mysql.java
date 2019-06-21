package test_pro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;
public class mysql {	

	    public static void main(String[] args) {
	        //声明Connection对象
	        Connection con;
	        //驱动程序名
	        String driver = "com.mysql.jdbc.Driver";
	        //URL指向要访问的数据库名mydata
	        String url = "jdbc:mysql://localhost:3306/bhdb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	        //MySQL配置时的用户名
	        String user = "root";
	        //MySQL配置时的密码
	        String password = "";
	        //String password = "123456";
	        //遍历查询结果集
	        try {
	            //加载驱动程序
	            Class.forName(driver);
	            //1.getConnection()方法，连接MySQL数据库！！
	            con = DriverManager.getConnection(url,user,password);
	            if(!con.isClosed())
	                System.out.println("Succeeded connecting to the Database!");
	            //2.创建statement类对象，用来执行SQL语句！！
	            Statement statement = con.createStatement();
	            //要执行的SQL语句
	        
	        {//插入一条语句 
	            String sql_for_insert="insert into loginlog(usename,logintime)values(?,?)";
	            PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql_for_insert);
	            ps.setString(1, "vvvb");
	            ps.setString(2, "2018-11-15-13-08-11");
	            int count=ps.executeUpdate();
	            System.out.println(count);
	        }
	        {
	        	for(int i=0;i<10;i++)
	        	{
	        		String sql_for_insert_f="insert into loginlog(usename,logintime)values(?,?)";
	   	            PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql_for_insert_f);
	   	            ps.setString(1, String.valueOf(i)+"a"+String.valueOf(i));
	   	            ps.setString(2, "2018-11-15-13-08-"+String.valueOf(i));
	   	            ps.executeUpdate();
//	   	            System.out.println(count);
	        	}
	        }
	        {	//aaa外面需要加上单引号''像字符那样        	
	        	String sql_for_delet="delete from loginlog where usename like '%a%'";
	        	//String sql_for_delet="delete from loginlog where usename='1'";
	        	statement.executeUpdate(sql_for_delet);
	        	System.out.println("sql_for_delet");
	        }
	            String sql = "select * from loginlog";//tettb是表一级表的名字
	            //String sql = "select * from tettb";//tettb是表一级表的名字
	            //String sql = "select * from emp";
	            //3.ResultSet类，用来存放获取的结果集！！
	            ResultSet rs = statement.executeQuery(sql);
	            System.out.println("-----------------");
	            System.out.println("执行结果如下所示:");  
	            System.out.println("-----------------");  
	            System.out.println("姓名" + "\t" + "职称");  
	            System.out.println("-----------------");  
	             
	            String job = null;
	            String id = null;
	            
	            
//	            ResultSet rs = statement.executeQuery(sql);
	            
	            while(rs.next()){
	                //获取stuname这列数据
//	                job = rs.getString("name");
//	                //获取stuid这列数据
//	                id = rs.getString("degree");
	                
	                job = rs.getString("usename");
	                //获取stuid这列数据
	                id = rs.getString("logintime");
	                //输出结果
	                System.out.println(id + "\t" + job);
	            }
	            rs.close();
	            con.close();
	        } catch(ClassNotFoundException e) {   
	            //数据库驱动类异常处理
	            System.out.println("Sorry,can`t find the Driver!");   
	            e.printStackTrace();   
	            } catch(SQLException e) {
	            //数据库连接失败异常处理
	            e.printStackTrace();  
	            }catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }finally{
	            System.out.println("数据库数据成功获取！！");
	        }
	    }

	

}
