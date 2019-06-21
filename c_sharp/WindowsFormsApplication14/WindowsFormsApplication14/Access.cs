using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb; //使用using关键字引入命名空间N1
using System.Data;


//DELETE * FROM仅仅适用于MDB存储格式【如：ACCESS】
//DELETE FROM大众格式

namespace WindowsFormsApplication14
{
    class Access
    {
        //OleDbConnection oleDb = new OleDbConnection(@"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\Users\25454\Documents\CSDN.mdb");
        //ConnectionString=Provider=Microsoft.ACE.OLEDB.12.0;Data Source=StationInfo.accdb;Persist Security Info=False
        OleDbConnection oleDb = new OleDbConnection(@"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=E:\Visual Studio 2010\Projects\WindowsFormsApplication14\WindowsFormsApplication14\CSDN.mdb");

        public Access() //构造函数
        {
            oleDb.Open();
            // Del();
            // Change();
           // auto_Add_value();
            Add();
            Get();
            // Add();
            // Find();
            //  Console.WriteLine("111");
            Console.ReadLine();
        }
        ~Access()
        {

        }
        public void Get()
        {
            string sql = "select * from 表1";
            //获取表1的内容
            OleDbDataAdapter dbDataAdapter = new OleDbDataAdapter(sql, oleDb); //创建适配对象
            DataTable dt = new DataTable(); //新建表对象
            dbDataAdapter.Fill(dt); //用适配对象填充表对象
            foreach (DataRow item in dt.Rows)
            {
                Console.WriteLine(item[0] + " | " + item[1] + " | " + item[2]);
            }
        }
        //遍历所有的有几个算几个
        public void Find()
        {
            string sql = "select * from 表1 WHERE 昵称='LanQ'";
            //获取表1中昵称为LanQ的内容
            OleDbDataAdapter dbDataAdapter = new OleDbDataAdapter(sql, oleDb); //创建适配对象
            DataTable dt = new DataTable(); //新建表对象
            dbDataAdapter.Fill(dt); //用适配对象填充表对象
            foreach (DataRow item in dt.Rows)
            {
                Console.WriteLine(item[0] + " | " + item[1]);
            }
        }
        public bool Add()
        {
            string sql = "insert into 表1 (昵称,账号) values ('LanQ','2545493686')";
            //往表1添加一条记录，昵称是LanQ，账号是2545493686
            OleDbCommand oleDbCommand = new OleDbCommand(sql, oleDb);
            int i = oleDbCommand.ExecuteNonQuery(); //返回被修改的数目
            //Console.WriteLine("add");

            return i > 0;
        }

        ////待续
        public bool auto_Add_value()
        {
            //string sql = "insert into 表1 (昵称,账号) values ('str1','2545493686')";
            ////string sql = "insert into 表1 (昵称,账号) values ('LanQ','2545493686')";
            ////往表1添加一条记录，昵称是LanQ，账号是2545493686
            //OleDbCommand oleDbCommand = new OleDbCommand(sql, oleDb);
            //int i = oleDbCommand.ExecuteNonQuery(); //返回被修改的数目       
            // return i > 0;
            int ii = 0;
            string sql = "";
             DateTime dt = DateTime.Now;
            //Console.WriteLine(dt.ToString("yyyyMMddHHmmddms"));

            Random ran = new Random();
            Console.WriteLine(ran.Next(999,9999)+dt.ToString("yyyyMMddHHmmddms"));
            for (ii = 0; ii < 10; ii++)
            {
                sql = "insert into " + "表1(昵称, 账号) "+ " values(' " + ran.Next(999, 9999) + dt.ToString("yyyyMMddHHmmddms") + " ',' " + ran.Next(999, 9999) + dt.ToString("yyyyMMddHHmmddms") + " ) ";
                //sql = "insert into 表1 (昵称,账号) values ('str1','2545493686')";
                OleDbCommand oleDbCommand = new OleDbCommand(sql, oleDb);
                Console.WriteLine(sql);
            }
            
            //int i = oleDbCommand.ExecuteNonQuery(); //返回被修改的数目       
            return ii > 0;
        }

         //sQueryString = "insert into " + sDataTableName + " values('" + (i + 1).ToString() + "','" + dgvShowData.Rows[i].Cells[0].Value.ToString() + "','" + dgvShowData.Rows[i].Cells[1].Value.ToString() + "','" +
         //                   dgvShowData.Rows[i].Cells[2].Value.ToString() + "','" + dgvShowData.Rows[i].Cells[3].Value.ToString() + "','" + dgvShowData.Rows[i].Cells[4].Value.ToString() + "','" + dgvShowData.Rows[i].Cells[5].Value.ToString() + "','" +
         //                   dataConversion.OpenDoorSideID(dgvShowData.Rows[i].Cells[6].Value.ToString()) + "','" + dataConversion.OpenDoorSideID(dgvShowData.Rows[i].Cells[7].Value.ToString()) + "','" +
         //                   dgvShowData.Rows[i].Cells[8].Value.ToString() + "','" + dgvShowData.Rows[i].Cells[9].Value.ToString() + "','" + dgvShowData.Rows[i].Cells[10].Value.ToString() + "','" + dgvShowData.Rows[i].Cells[11].Value.ToString() + "'," +
         //                   iSkipStation[0] + "," + iSkipStation[1] + ")";
        ////待续
        //public bool Add_value(string str1,string str2)
        //{
        //    string sql = "insert into 表1 (昵称,账号) values ('str1','2545493686')";
        //    //string sql = "insert into 表1 (昵称,账号) values ('LanQ','2545493686')";
        //    //往表1添加一条记录，昵称是LanQ，账号是2545493686
        //    OleDbCommand oleDbCommand = new OleDbCommand(sql, oleDb);
        //    int i = oleDbCommand.ExecuteNonQuery(); //返回被修改的数目
        //    //Console.WriteLine("add");

        //    return i > 0;
        //}
        //有几个删几个
        public bool Del()
        {
            string sql = "delete from 表1 where 昵称='LANQ'";
            //删除昵称为LanQ的记录
            OleDbCommand oleDbCommand = new OleDbCommand(sql, oleDb);
            int i = oleDbCommand.ExecuteNonQuery();
            return i > 0;
        }
        public bool Change()
        {
            string sql = "update 表1 set 账号='233333' where 昵称='LANQ'";
            //将表1中昵称为东熊的账号修改成233333
            OleDbCommand oleDbCommand = new OleDbCommand(sql, oleDb);
            int i = oleDbCommand.ExecuteNonQuery();
            return i > 0;
        }

    }
}
