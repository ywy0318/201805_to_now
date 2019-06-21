using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

using System.Windows.Forms;

/*加密用到的下面两个*/
using System.IO;
using System.Security.Cryptography;
using System.Threading;

using System.Data.OleDb; //使用using关键字引入命名空间N1
using System.Data;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
        }

        DataSet ds = new DataSet();
        DataSet ds1 = new DataSet();
        OleDbDataAdapter da = new OleDbDataAdapter();
        private void openAccess()
        {
            //  OleDbCommand cmd;
            //数据库连接语句
            string oleDBString = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:/Users/muma/Documents/AccessTest.accdb";
            string sql = "select * from student";
            ds.Clear();
            //创建连接对象
            OleDbConnection conn = new OleDbConnection(oleDBString);
            //da = new OleDbDataAdapter(sql,conn);
            // da.SelectCommand = new OleDbCommand(sql, conn);
            //OleDbCommandBuilder cb = new OleDbCommandBuilder(da);
            // da.UpdateCommand = cb.GetUpdateCommand();
            da = new OleDbDataAdapter(sql, conn);
            da.Fill(ds);
            //accessGrid.ItemsSource = ds.Tables[0].DefaultView;
            conn.Close();
        }
        private void addRow_Click_1()
        {
            //更新一条记录
            //openAccess();
            if (ds.Tables.Count > 0)
            {
                //DataRow drx = ds.Tables[0].NewRow();
                //// drx["ID"] = 4;
                //drx["姓名"] = "yuanl";
                //drx["学号"] = 4;
                //drx["班级"] = "四班";
                //ds.Tables[0].Rows.Add(drx);
                //da.Update(ds.Tables[0]);
                //accessGrid.DataContext = ds;
                string oleDBString = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:/Users/muma/Documents/AccessTest.accdb";
                string sql = "insert into student(姓名,学号,班级) values('yuanl','4','四班')";
                OleDbConnection conn = new OleDbConnection(oleDBString);
                conn.Open();

                da = new OleDbDataAdapter(sql, conn);

                da.Fill(ds);//这里有个问题，如果这句话注释掉的话，貌似数据库里数据没有插入，下面openAccess（）函数再重新获取数据，得到的表是没有插入语句这条记录的
                // accessGrid.ItemsSource = ds.Tables[0].DefaultView;
                conn.Close();
                openAccess();
            }
            else
            {
                MessageBox.Show("请先显示数据表");
            }
        }

        private void showTable_Click_1()
        {
            //ds.Clear();
            // DataTable table1 = new DataTable();
            //  da.Fill(ds, "ss");
            openAccess();


        }

        private void dltRow_Click_1()
        {

            // int count = accessGrid.SelectedItems.Count;

            //  DataRow []drv=new DataRow[count];
            //for (int i = 0; i < count;i++ )
            //{
            //    drv[i] = accessGrid.SelectedItems[i] as DataRow;
            //    ds.Tables[0].Rows.Remove(drv[i]);
            //}
            if (ds.Tables.Count > 0)
            {
                if (accessGrid.SelectedItem != null)
                {
                    int index = accessGrid.SelectedIndex;
                    string strIndex = (ds.Tables[0].Rows[index]["ID"]).ToString();

                    string oleDBString = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=E:/Visual Studio 2010/Projects/WindowsFormsApplication2/文档/AccessTest.accdb";
                    string sql = "delete from student where ID=" + strIndex;

                    //创建连接对象
                    OleDbConnection conn = new OleDbConnection(oleDBString);
                    conn.Open();
                    da = new OleDbDataAdapter(sql, conn);
                    // OleDbCommandBuilder cb = new OleDbCommandBuilder(da);

                    //da.Fill(ds, "ss");

                    //ds.Tables[0].Rows.RemoveAt(index);
                    // da.Update(ds.Tables[0]);
                    //accessGrid.DataContext = ds;

                    da.Fill(ds);
                    // accessGrid.ItemsSource = ds.Tables[0].DefaultView;

                    conn.Close();
                    openAccess();
                }
                else
                {
                    MessageBox.Show("请选择要删除的数据");
                }
            }
            else
            {
                MessageBox.Show("请先显示数据表");
            }
        }

        private void Button_Click_1()
        {
            string oleDBString = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:/Users/muma/Documents/Database1.accdb";
            OleDbConnection conn = new OleDbConnection(oleDBString);
            conn.Open();
            DataTable dt = conn.GetOleDbSchemaTable(OleDbSchemaGuid.Tables, new object[] { null, null, null, "Table" });
            //ds.Tables.Add(dt);
            //accessGrid.DataContext = ds;
            int h = 0;
            int n = dt.Rows.Count;
            List<string> strTable = new List<string>();
            string[] strColumns = new string[n];
            int m = dt.Columns.IndexOf("TABLE_NAME");
            foreach (DataRow item in dt.Rows)
            {
                h++;
                string schemaTableName = h.ToString();
                strTable.Add(item["TABLE_NAME"].ToString());
                getExcelTableColumn(conn, item["table_name"].ToString(), schemaTableName);//可以在这获取下表的列
                //GetTableFieldNameList(conn, item["table_name"].ToString());
            }
            //for (int i = 0; i < n;i++ )
            //{
            //    //strTable.Add(item["TABLE_NAME"].ToString());
            //    DataRow m_DataRow = dt.Rows[i];
            //    strTable[i] = m_DataRow.ItemArray.GetValue(m).ToString();    
            //}
            for (int i = 0; i < strTable.Count; i++)
            {
                tables.Text = tables.Text + strTable[i] + "";
            }

        }
        private List<string> getExcelTableColumn(OleDbConnection conn, string tableName, string schemaTableName)
        {
            //获取表名
            string tblName = tableName.Trim();
            List<string> list = new List<string>();
            if (string.IsNullOrEmpty(tblName))
            {
                return list;
            }
            //
            //try
            //{
            OleDbConnection oconn = new OleDbConnection();
            oconn = conn;

            //获取表中的所有列信息
            DataTable schemaTable = oconn.GetOleDbSchemaTable(OleDbSchemaGuid.Columns, new object[] { null, null, tblName, null });
            //DataTable schemaTable1 = oconn.GetOleDbSchemaTable(OleDbSchemaGuid.Column_Privileges, new object[] { null, null, tblName, null });

            // 获取到列名称
            if (schemaTable.TableName == "Columns")
            {
                schemaTable.TableName = schemaTableName;
                ds.Tables.Add(schemaTable);
                // ds.Tables.Add(schemaTable1);
                accessGrid.DataContext = ds;
            }

            //判断ds里是否含有存在名字的table
            //if (ds.Tables.Count == 0)
            //{
            //    ds.Tables.Add(schemaTable);
            //    // ds.Tables.Add(schemaTable1);
            //    accessGrid.DataContext = ds;
            //}
            //for (int i = 0; i < ds.Tables.Count; i++)
            //{
            //    if (ds.Tables[i] != ds.Tables["Columns"])
            //    {
            //        ds.Tables.Add(schemaTable);
            //        // ds.Tables.Add(schemaTable1);
            //        accessGrid.DataContext = ds;
            //    }

            //}
            DataTable dt = new DataTable(schemaTableName);

            dt.Columns.Add("column_name", System.Type.GetType("System.String"));
            dt.Columns.Add("data_type", System.Type.GetType("System.String"));
            dt.Columns.Add("length", System.Type.GetType("System.String"));
            dt.Columns.Add("typesta", System.Type.GetType("System.String"));

            foreach (DataRow row in schemaTable.Rows)
            {

                DataRow dr = dt.NewRow();
                dr["column_name"] = row["column_name"].ToString();
                dr["data_type"] = row["data_type"].ToString();
                list.Add(row["column_name"].ToString());
                list.Add(row["data_type"].ToString());
                // list.Add(row["CHARACTER_MAXIMUM_LENGTH"].ToString());
                string maxLength = row["CHARACTER_MAXIMUM_LENGTH"].ToString();
                string numPre = row["NUMERIC_PRECISION"].ToString();
                string numSca = row["NUMERIC_SCALE"].ToString();
                string datePre = row["DATETIME_PRECISION"].ToString();
                if (!string.IsNullOrEmpty(maxLength))
                {
                    int length = Convert.ToInt32(maxLength);

                    string s = length.ToString();

                    list.Add(s);
                    dr["length"] = s;
                }
                if (!string.IsNullOrEmpty(numPre))
                {
                    string s;
                    string ss;
                    int length = Convert.ToInt32(numPre);
                    s = length.ToString();
                    if (!string.IsNullOrEmpty(numSca))
                    {
                        int typesta = Convert.ToInt32(numSca);
                        length = length - typesta;
                        ss = typesta.ToString();
                        s = length.ToString();
                        list.Add(ss);
                        dr["typesta"] = ss;

                    }
                    list.Add(s);
                    dr["length"] = s;
                }
                if (!string.IsNullOrEmpty(datePre))
                {
                    int a = Convert.ToInt32(datePre);

                    string s = a.ToString();

                    list.Add(s);
                    dr["length"] = s;
                }
                dt.Rows.Add(dr);

            }

            ds1.Tables.Add(dt);
            // ds.Tables.Add(schemaTable1);
            dtTest.DataContext = ds1;
            //dtTest.ItemsSource = dt.DefaultView;


            for (int i = 0; i < list.Count; i++)
            {
                columns.Text = columns.Text + list[i] + "";
            }
            //}
            //catch (Exception exc)
            //{
            //    //PublicMethod.MessageError("加载Access文件过程发生异常，请重试！");
            //}

            return list;
        }
        public List<string> GetTableFieldNameList(OleDbConnection conn, string TableName)
        {
            List<string> list = new List<string>();

            try
            {
                if (conn.State == ConnectionState.Closed)
                    conn.Open();
                using (OleDbCommand cmd = new OleDbCommand())
                {
                    cmd.CommandText = "SELECT TOP 1 * FROM [" + TableName + "]";
                    cmd.Connection = conn;
                    OleDbDataReader dr = cmd.ExecuteReader();
                    //string s1 = dr[0].ToString();
                    //string s2 = dr[1].ToString();
                    //string s3 = dr[2].ToString();
                    //txtBox.Text = s1 + s2 + s3;
                    for (int i = 0; i < dr.FieldCount; i++)
                    {
                        list.Add(dr.GetName(i));
                    }
                }
                return list;
            }
            catch (Exception e)
            { throw e; }
            //finally
            //{
            //    if (conn.State == ConnectionState.Open)
            //        conn.Close();
            //    conn.Dispose();
            //}
        }

        private void updateRow_Click_1()
        {
            if (ds.Tables.Count > 0)
            {
                if (accessGrid.SelectedItem != null)
                {
                    int index = accessGrid.SelectedIndex;
                    string strIndex = (ds.Tables[0].Rows[index]["ID"]).ToString();

                    string oleDBString = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:/Users/muma/Documents/AccessTest.accdb";
                    string sql = "update student set 姓名=\"哈哈\"where ID=" + strIndex;

                    //创建连接对象  学号=5 班级=你猜啊
                    OleDbConnection conn = new OleDbConnection(oleDBString);
                    conn.Open();
                    da = new OleDbDataAdapter(sql, conn);
                    // da.UpdateCommand = new OleDbCommand(sql,conn);
                    // OleDbCommandBuilder cb = new OleDbCommandBuilder(da);

                    //da.Fill(ds, "ss");

                    //ds.Tables[0].Rows.RemoveAt(index);
                    // da.Update(ds.Tables[0]);
                    // accessGrid.DataContext = ds;


                    da.Fill(ds);
                    // accessGrid.ItemsSource = ds.Tables[0].DefaultView;

                    conn.Close();
                    openAccess();
                }
                else
                {
                    MessageBox.Show("请选择要更新的数据");
                }
            }
            else
            {
                MessageBox.Show("请先显示数据表");
            }
        }
     //分割线
    
    
    
    
    }
}
