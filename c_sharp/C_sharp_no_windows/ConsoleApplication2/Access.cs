using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;
using ADOX;
using System.IO;
using System.Diagnostics;
using System.Data;
using System.Drawing;
using System.IO;
using System.Drawing.Imaging;

//由于在程序中使用了ADOX，所以先要在解决方案中引用之，方法如下：
//解决方案资源管理器-->引用-->(右键)添加引用-->COM-->Microsoft ADO Ext. 2.8 for DDL and Security

namespace ConsoleApplication2
{
   

//C#的Microsoft Access操作类
    public class AccessOperate
    {
     private string OleDbConnectionString;    //数据库连接

    /// <summary>
    /// 构造函数
    /// 初始化连接数据库参数
    /// </summary>
    public AccessOperate()
    {
        //Microsoft Access2003的连接语句
    //OleDbConnectionString = "Provider = Microsoft.ACE.OLEDB.4.0;Data Source=.\\Data\\DataBaseName.mdb;Jet OLEDB:Database Password=123456";
    //Microsoft Access2007及以上的连接语句
   // OleDbConnectionString = "Provider = Microsoft.ACE.OLEDB.12.0;Data Source=.\\Data\\DataBaseName.accdb;Jet OLEDB:Database Password=123456";
  //  OleDbConnectionString = "Provider = Microsoft.ACE.OLEDB.12.0;Data Source=E:\Visual Studio 2010\Projects\C_sharp_no_windows\ConsoleApplication2\CSDN.mdb:Database Password=123456";
    }

    /// <summary>
    /// 构造函数
    /// 初始化连接数据库参数
    /// </summary>
    /// <param name="ConSqlServer">连接对象</param>
    public AccessOperate(string ConSqlServer)
    {
        OleDbConnectionString = ConSqlServer;
    }

    /// <summary>
    /// 打开数据库连接
    /// </summary>
    /// <param name="cnn">连接</param>
    public void Open(OleDbConnection cnn)
    {
        if (cnn.State == ConnectionState.Closed)
        {
            cnn.Open();
        }
    }

    /// <summary>
    /// 关闭数据库连接
    /// </summary>
    /// <param name="cnn">连接</param>
    public void Close(OleDbConnection cnn)
    {
        if (cnn != null)
        {
            if (cnn.State == ConnectionState.Open)
            {
                cnn.Close();
            }
            cnn.Dispose();
        }
    }

    /// <summary>
    /// 查询
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <returns>是否存在</returns>
    public bool ChaXun(string strSql)
    {
        OleDbConnection cnn = new OleDbConnection(OleDbConnectionString);
        OleDbCommand cmd = new OleDbCommand();
        try
        {
            Open(cnn);
            cmd = new OleDbCommand(strSql, cnn);
            return cmd.ExecuteReader().Read();
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
        finally
        {
            cmd.Dispose();
            Close(cnn);
        }
    }

    /// <summary>
    /// 查询
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <returns>第一行第一列结果</returns>
    public string ChaXun2(string strSql)
    {
        OleDbConnection cnn = new OleDbConnection(OleDbConnectionString);
        OleDbCommand cmd = new OleDbCommand();
        try
        {
            Open(cnn);
            cmd = new OleDbCommand(strSql, cnn);
            return cmd.ExecuteScalar().ToString().Trim();
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
        finally
        {
            cmd.Dispose();
            Close(cnn);
        }
    }

    /// <summary>
    /// 查询（OleDbDataReader）
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <returns>查询结果</returns>
    public OleDbDataReader GetDR(string strSql)
    {
        OleDbConnection cnn = new OleDbConnection(OleDbConnectionString);
        OleDbCommand cmd = new OleDbCommand();
        try
        {
            Open(cnn);
            cmd = new OleDbCommand(strSql, cnn);
            return cmd.ExecuteReader(CommandBehavior.CloseConnection);
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
        finally
        {
            cmd.Dispose();
        }
    }

    /// <summary>
    /// 查询（DataSet）
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <returns>查询结果</returns>
    public DataSet GetDS(string strSql)
    {
        OleDbConnection cnn = new OleDbConnection(OleDbConnectionString);
        OleDbDataAdapter sda = new OleDbDataAdapter();
        try
        {
            Open(cnn);
            sda = new OleDbDataAdapter(strSql, cnn);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            return ds;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
        finally
        {
            sda.Dispose();
            Close(cnn);
        }
    }

    /// <summary>
    /// 查询（DataSet）
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <param name="tableName">指定DataSet["tableName"]表</param>
    /// <returns>查询结果</returns>
    public DataSet GetDS(string strSql, string tableName)
    {
        OleDbConnection cnn = new OleDbConnection(OleDbConnectionString);
        OleDbDataAdapter sda = new OleDbDataAdapter();
        try
        {
            Open(cnn);
            sda = new OleDbDataAdapter(strSql, cnn);
            DataSet ds = new DataSet();
            sda.Fill(ds, tableName);
            return ds;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
        finally
        {
            sda.Dispose();
            Close(cnn);
        }
    }

    /// <summary>
    /// 查询（DataTable）
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <returns>查询结果</returns>
    public DataTable GetDT(string strSql)
    {
        return GetDS(strSql).Tables[0];
    }

    /// <summary>
    /// 查询（DataView）
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <returns>查询结果</returns>
    public DataView GetDV(string strSql)
    {
        return GetDS(strSql).Tables[0].DefaultView;
    }

    /// <summary>
    /// 增删改，无图片
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <returns>影响的行数</returns>
    public int RunSql(string strSql)
    {
        OleDbConnection cnn = new OleDbConnection(OleDbConnectionString);
        OleDbCommand cmd = new OleDbCommand();
        try
        {
            Open(cnn);
            cmd = new OleDbCommand(strSql, cnn);
            return cmd.ExecuteNonQuery();
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
        finally
        {
            cmd.Dispose();
            Close(cnn);
        }
    }

    /// <summary>
    /// 增改，有图片
    /// </summary>
    /// <param name="strSql">SQL语句</param>
    /// <param name="picbyte">图片的二进制数据</param>
    /// <returns>影响的行数</returns>
    public int RunSql(string strSql, byte[] picbyte)
    {
        OleDbConnection cnn = new OleDbConnection(OleDbConnectionString);
        OleDbCommand cmd = new OleDbCommand();
        try
        {
            Open(cnn);
            cmd = new OleDbCommand(strSql, cnn);
            cmd.Parameters.AddWithValue("@Image", SqlDbType.Image);
            cmd.Parameters["@Image"].Value = picbyte;
            return cmd.ExecuteNonQuery();
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
        finally
        {
            cmd.Dispose();
            Close(cnn);
        }
    }
   // 将Image转换为二进制序列
public static byte[] ImageToBytes(Image image)
{
    MemoryStream ms = new MemoryStream();
    image.Save(ms, ImageFormat.Jpeg);
    byte[] bytes = new Byte[ms.Length];
    ms.Position = 0;
    ms.Read(bytes, 0, bytes.Length);
    ms.Close();
    return bytes;
}


}
//// 将二进制序列转换为Image
//public static Image BytesToImage(byte[] bytes)
//{
//    try
//    {
//        using (Stream fStream = new MemoryStream(bytes.Length))
//        {
//            BinaryWriter bw = new BinaryWriter(fStream);
//            bw.Write(bytes);
//            bw.Flush();
//            Bitmap bitMap = new Bitmap(fStream);
//            bw.Close(); 
//            fStream.Close();
//            Image image = Image.FromHbitmap(bitMap.GetHbitmap());
//            return image;
//        }
//    }
//    catch (IOException ex)
//    {
//        throw new Exception("读取图片失败：" + ex.Message);
//    }
//}

}




