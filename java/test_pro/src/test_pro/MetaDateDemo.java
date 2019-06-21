package test_pro;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//import org.junit.Test;

//import cn.hncu.pool.ConnUtils3;
//import cn.hncu.pool.ConnUtils4;

	
//待续

	/*
	* 要点:
	操纵: 数据库驱动的信息、数据库名、数据表信息(名字、个数) ---java.sql.DatabaseMetaData <---通过con.getMetaData()获得
	操纵: 表结构信息,如字段名、列数 ---java.sql.ResultSetMetaData <--- 通过rs.getMetaData()获得

	*数据库的其它称呼: Catlog,Schema , Database
	*/

	public class MetaDateDemo {
	Connection con = ConnUtils3.getConn();

	//@Test
	public void DatabaseMetaDataDemo() throws Exception{
	DatabaseMetaData dm = con.getMetaData();
	System.out.println(dm.getDriverName());
	System.out.println(dm.getDatabaseMajorVersion()+"."+dm.getDatabaseMinorVersion());
	System.out.println(dm.getMaxStatements());
	System.out.println(dm.getJDBCMajorVersion());//jdbc4.0
	System.out.println("--------------------------");

	//返回所有数据库的名字
	ResultSet rs = dm.getCatalogs();
	while(rs.next()){
	String name = rs.getString("TABLE_CAT");
	String name2 = rs.getString(1);
	System.out.println(name+","+name2);
	}
	System.out.println("--------------------------");

	//返回某个数据库的表名
	//参数解析: 第1和第2个都是数据库的名字(2个，是为兼容不同数据库), 第3个参数是查询表名的过滤模式(null为不过滤即查所有，"%a%"为表名中包含字母'a'),最后一个参数是表类型如"TABLE"、"VIEW"等(这些值可查看API中getTableTypes()方法)
	rs = dm.getTables("hncu", "hncu", null, new String[]{"TABLE","VIEW"} );
	while(rs.next()){
	String name = rs.getString("TABLE_NAME"); //字符串参数的具体取值参看API中getTables()
	String name2 = rs.getString("TABLE_TYPE");
	System.out.println(name+","+name2);
	}
	System.out.println("--------------------------");

	//如果已知数据库的名字，打开该数据库。如果还知道某个表的名字，那么可以操纵这个表
	String s1 = "hncu";
	con.createStatement().execute("use "+s1);//该方法能够执行所有SQL语句，包括: use hncu; drop database hncu
	String s2 = "stud";
	ResultSet rs2 = con.createStatement().executeQuery("select * from "+ s2);
	while(rs2.next()){
	//如果已经列数n，就可输出表格的所有数据
	int n = 2;
	for(int i=1;i<=n;i++){
	Object obj = rs2.getObject(i);
	System.out.print(obj+" ");
	}
	System.out.println();
	}

	}


	//@Test //表结构信息
	public void ResultSetMetaDataDemo() throws Exception{
	//跨库查询
	Connection con = ConnUtils4.getConn(); //该版本的配置文件的url中是没有数据库名字的
	String dbName = "abc"; //数据库名
	String tableName = "stud"; //表名
	String sql = "select * from " + dbName+"."+tableName;

	ResultSet rs = con.createStatement().executeQuery(sql);
	ResultSetMetaData rsmd = rs.getMetaData();

	//获取当前表格的列数
	int columns = rsmd.getColumnCount();
	System.out.println("列数:"+columns);

	//输出当前表格的表头
	System.out.println("------------------");
	for(int i=0; i<columns;i++){
	System.out.print(rsmd.getColumnName(i+1)+"\t");
	}
	System.out.println();
	System.out.println("------------------");
	//输出表数据
	while (rs.next()) {
	//输出一行
	for (int i = 0; i < columns; i++) {
	System.out.print(rs.getObject(i + 1) + "\t");
	}
	System.out.println();
	}
	}

	}


