using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.Data;
using System.Windows.Forms;

/*加密用到的下面两个*/
using System.IO;
using System.Security.Cryptography;
using System.Threading;

using System.Data.OleDb; //使用using关键字引入命名空间N1
using System.Data;

using N1;
using N2;
using N3;
using N4;
namespace C_sharp//命名空间
{

    //private void time_tick()
    //{
    //    Thread th=new Thread()=>
    //    {
    //       Console.WriteLine("multi_thread_test");
    //        Sleep(4);
    //    }
    //    th.isbackground=true;
    //    th.Start();

    //}
    //密封类可以用来限制扩展性,如果密封了某个类,则其他类不能从该类继承,
    //如果密封了某个成员,则派生类不能重写该成员的实现
    //默认情况下，不应密封类型和成员
    //密封可以对库的类型和成员进行自定义,但也会影响某些开发人员对可用性的认识

    //对类密封的应满足的条件:
    //类是静态的
    //类包含带有安全敏感信息的继承的受保护成员
    //类继承多个虚成员,并且密封每个成员的开发和测试开销大于密封整个类
    //类是一个要求使用反射进行快速搜索的属性,密封属性可提高反射在搜索属性时的性能
    //
    //访问修饰符 sealed class 类名:基类或接口
   // {
        //类成员
   // }
    //密封类不能作为基类被继承,但它可以继承逼得类或接口
    //在密封类中不能声明受保护成员或虚成员,因为受保护成员只能从派生类进行访问,
    //而虚成员只能在派生类中重写
    //由于密封类的不可继承性,密封类不能声明为抽象的,即sealed 修饰符不能与abstract修饰符同时使用
    //并不是每个方法都可以声明为密封方法,密封方法只能用于对基类的虚方法进行重写,并提供具体的实现
    //因此声明密封方法时,sealed修饰符总是和override修饰符同时使用
    public class myclass_for_sealed
    {
        public virtual void Method1()
        {
            Console.WriteLine("基类中的虚方法");
        }
        public virtual void Show_info()
        { 
        }
    }
    public sealed class myclass2 : myclass_for_sealed
    {
        private string id_sealed = "";
        private string name_sealed = "";
        public sealed override void Method1()
        {
            base.Method1();
            Console.WriteLine("密封类中重写后的方法");
        }
        public string ID_FOR_sealed
        {
            get
            {
                return id_sealed;
            }
            set
            {
                id_sealed = value;
            }        
        }
        public string NAEM_FOR_sealed
        {
            get
            {
                return name_sealed;
            }
            set
            {
                name_sealed = value;
            }
        }
        public sealed override void Show_info()
        {
            Console.WriteLine("重写以后的show_info::"+ID_FOR_sealed+"::"+name_sealed);

        }
    }

    /*******************************/
    /***************************/
    public sealed class myclass
    {
        public int aa = 0;
        public void method()
        {
            Console.WriteLine("密封类");
        }
    }
    /// <summary>
    /// 
    /// </summary>
    public class MYClass
    {
        private string id = "";
        private string name = "";


        /***/
        private int xc;
        private int yc;
        private int zc;

        public int XC
        {
            get
            {
                return xc;
            }
            set
            {
                xc = value;
            }

        }
        public int YC
        {
            get
            {
                return yc;
            }
            set
            {
                yc = value;
            }
        }
        public int ZC
        {
            get
            {
                return zc;
            }
            set
            {
                zc = value;
            }
        }
        public virtual int add()
        {
            return XC + YC;
        }

        /// <summary>
        /// 定义用户编号属性，该属性为可读可写
        /// </summary>
        public string ID
        {
            get
            {
                return id;
            }
            set
            {
                id = value;
            }
        }
        /// <summary>
        /// 定义用户姓名属性，该属性为可读可写
        /// </summary>
        /// 
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }

    }
    public class MyClass1 : MYClass
    {
        private int zc1;
        public int ZC1
        {
            get
            {
                return zc1;
            }
            set
            {
                zc1 = value;
            }
        }
        public override int add()
        {
            //return base.add()+ZC1;
            int xc = 5;
            int yc = 6;
            return xc + yc;

        }
    }
    ////定义接口
    interface IPeople
    {
        string name
        {
            get;
            set;
        }
        int age
        {
            get;
            set;
        }
        void show_info();
        
    }
    /**************************/
    interface myinterface1
    {
        int add();
    }
    /**************************/
    interface myinterface2
    {
        int add();
    }
    /**************************/
    public abstract class my_abstract_class
    {
        private string id_ = "";
        private string name_ = "";
        public string ID
        {
            get 
            {
                return id_;

            }
            set {
                id_ = value;
            }
        }
        public string NAME
        {
            get
            {
                return name_;

            }
            set {
                name_ = value;
            }
        }
        public abstract void Showinfo();//
    }
    /**************************/
    public class Drive_class : my_abstract_class
    {
        public override void Showinfo()
        {
            Console.WriteLine(ID+":::"+NAME);
        }

    }
    /**************************/
    //class Mc
    //{
    //    public void show()
    //    {
    //        Console.WriteLine("the information of people:");
    //    }
    //}
    //类
    //public class Program:Mc,IPeople
    public class Program : IPeople,myinterface1,myinterface2
    {
        class C
        {
            public int value = 0;
        }
        /// <summary>
        /// 星期属性，该属性为可读可写
        /// </summary>
        public class date
        {
            private int Day = 7;
            public int day
            {
                get
                {
                    return day;
                }
                set
                {
                    if ((value < 8) && (value > 0))
                    {
                        Day = value;
                    }
                }
            }
        }


        public static int add(int x, int y)
        {
            return x + y;
        }
        public double add(int x, double y)
        {
            return x + y;
        }
        public int add(int x, int y, int z)
        {
            return x + y + z;
        }
        /***/
        public int xp = 3;
        public int yp = 4;
        public int zp = 0;
        public Program()
        {
            zp = xp + yp;
        }
        ~Program()
        {
            Console.WriteLine("destruct");
            Console.ReadLine();
        }
        /***/


        #region
        /// <summary>
        /// 加密字符串
        /// </summary>
        /// <param name="str">要加密的字符串</param>
        /// <returns>加密后的字符串</returns>
        static string Encrypt(string str)
        {
            DESCryptoServiceProvider descsp = new DESCryptoServiceProvider();//实例化加密解密对象
            byte[] key = Encoding.Unicode.GetBytes(enctyptKey);//字符串转化为字节数组
            byte[] data = Encoding.Unicode.GetBytes(str);

            MemoryStream Mstream = new MemoryStream();//实例化内存流对象

            //使用内存流实例化加密流对象
            CryptoStream Cstream = new CryptoStream(Mstream, descsp.CreateEncryptor(key, key), CryptoStreamMode.Write);
            Cstream.Write(data, 0, data.Length);//向加密流中写入数据
            Cstream.FlushFinalBlock();//释放加密流
            return Convert.ToBase64String(Mstream.ToArray());//返回加密后的字符串
        }
        #endregion
        static string enctyptKey = "Oyea";
        #region
        /// <summary>
        /// 解密字符串
        /// </summary>
        /// <param name="str">要解密的字符串</param>
        /// <returns>解密后的字符串</returns>
        static string Decrypt(string str)
        {
            DESCryptoServiceProvider descsp = new DESCryptoServiceProvider();//实例化加密解密对象
            byte[] key = Encoding.Unicode.GetBytes(enctyptKey);//字符串转化为字节数组
            byte[] data = Convert.FromBase64String(str);//存储要解密的字符串

            MemoryStream Mstream = new MemoryStream();//实例化内存流对象

            //使用内存流实例化加密流对象
            CryptoStream Cstream = new CryptoStream(Mstream, descsp.CreateDecryptor(key, key), CryptoStreamMode.Write);
            Cstream.Write(data, 0, data.Length);//向解密流中写入数据
            Cstream.FlushFinalBlock();//释放解密流
            return Encoding.Unicode.GetString(Mstream.ToArray());//返回解密后的字符串
        }
        #endregion
        public struct RECT
        {
            public double length;
            public double width;

            //public void Rect(double x,double y)
            // {
            //     length =x;
            //     width =y;
            // }
            public double Area()
            {
                return width * length;
            }
        }


        public void test_Access_accdb()
        {
            {
                //C# 代码

                //数据库名称可路径
                String accdb = "E:\\Visual Studio 2010\\Projects\\C_sharp_no_windows\\ConsoleApplication2\\1.accdb";
                //String accdb = "K:\\xxx.accdb";
                if (System.IO.File.Exists(accdb))
                {
                    System.IO.File.Delete(accdb);
                }
                ADOX.Catalog cat = new ADOX.Catalog();
                cat.Create("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=" + accdb);

                ADOX.Table tbl = new ADOX.Table();
                tbl.ParentCatalog = cat;
                tbl.Name = "Table1";

                //增加一个自动增长的字段
                ADOX.Column col = new ADOX.Column();
                col.ParentCatalog = cat;
                col.Type = ADOX.DataTypeEnum.adInteger; // 必须先设置字段类型
                col.Name = "id";
                col.Properties["Jet OLEDB:Allow Zero Length"].Value = false;
                col.Properties["AutoIncrement"].Value = true;
                tbl.Columns.Append(col, ADOX.DataTypeEnum.adInteger, 0);

                //增加一个文本字段
                ADOX.Column col2 = new ADOX.Column();
                col2.ParentCatalog = cat;
                col2.Name = "Description";
                col2.Properties["Jet OLEDB:Allow Zero Length"].Value = false;
                tbl.Columns.Append(col2, ADOX.DataTypeEnum.adVarChar, 25);

                //增加数字字段
                ADOX.Column col3 = new ADOX.Column();
                col3.ParentCatalog = cat;
                col3.Name = "数字";
                col3.Type = ADOX.DataTypeEnum.adDouble;
                col3.Properties["Jet OLEDB:Allow Zero Length"].Value = false;
                tbl.Columns.Append(col3, ADOX.DataTypeEnum.adDouble, 666);

                //增加Ole字段
                ADOX.Column col4 = new ADOX.Column();
                col4.ParentCatalog = cat;
                col4.Name = "Ole类型";
                col4.Type = ADOX.DataTypeEnum.adLongVarBinary;
                col4.Properties["Jet OLEDB:Allow Zero Length"].Value = false;
                tbl.Columns.Append(col4, ADOX.DataTypeEnum.adLongVarBinary, 0);
                //设置主键
                tbl.Keys.Append("PrimaryKey", ADOX.KeyTypeEnum.adKeyPrimary, "id", "", "");
                cat.Tables.Append(tbl);

                System.Runtime.InteropServices.Marshal.ReleaseComObject(tbl);
                System.Runtime.InteropServices.Marshal.ReleaseComObject(cat);
                tbl = null;
                cat = null;
                GC.WaitForPendingFinalizers();
                GC.Collect();
                Console.WriteLine("创建完成！");
                //MessageBox.Show("");
                MessageBox.Show("创建完成！");
                Console.ReadLine();


            }
        }


    //    Console.WriteLine("鹿鼎记中的{0}的妻子有{1}、{2}、{3}等7个",strName[0],strName[1],strName[2],strName[3]);
    //这种方式中包含两个参数：“格式字符串”和“变量表”。
    //“鹿鼎记中的{0}的妻子有{1}、{2}、{3}等7个”是格式字符串；
    //{0}、{1}、{2}、{3}叫做占位符，代表后面一次排列的变量表，
    //0对应变量列表的第一个变量，1对应变量列表的第二个变量，依次类推，完成输出。


        int age_for_p = 0;
        string name_for_p = "";
        public string name
        {
            get
            {
                return name_for_p;
            }
            set
            {
                name_for_p = value; 
             }            
        }
        public int age
        {
            get
            {
                return age_for_p;
            }
            set
            {
                age_for_p = value;
            }
        }
        public void show_info()
        {
            Console.WriteLine("编号\t  姓名");
            Console.WriteLine(age+"\t"+name);
        }

   

        //显示接口成员实现中不能包含访问修饰符,abstract,virtual,override,或static修饰符
        //显示接口成员是属于接口的成员,而不是类的成员,因此不能使用类对象直接访问,
        //只能通过接口对象来访问
        int myinterface1.add()
        {
            int x = 3;
            int y = 5;
            return x + y;
        }

        int myinterface2.add()
        {
            int x = 3;
            int y = 5;
            int z = 4;
            return x + y + z;
        }

        /***********************************/
        //抽象类不能直接实例化
        //抽象类中可以包含抽象成员，但非抽象类中不可以
        //抽象类不能被密封
        //抽象方法必须声明在抽象类中
        //声明抽象方法时,不能使用virtual,static 和private修饰符
        //抽象方法声明引入了一个新方法,但不提供该方法的实现,由于抽象方法,不能提供任何实际实现,
        //因此抽象芳芳的方法体只包含一个分号;
        //当从抽象类派生一个非抽象类时,需要在富抽象类中重写抽象方法,以提供具体的实现,
        //重写抽象方法使用override关键字
        //访问修饰符 abstract class 类名:基类或接口
        //{
        //    //类成员
        //}
        //现金流，利润，收益率-融资

        //抽象类和接口都包含可以由派生类继承的成员,它们都不能直接实例化,但是可以声明其变量,
        //这样就可以基于多态性,把继承这两种类型的对象指定给他们的变量,接着通过这些变量来使用
        //这些类型的成员,但是不能直接访问派生类中的其他成员
        //他们的派生来只能继承一个基类，只能直接继承一个抽象类,但是可以继承任意多个接口
        //抽象类中可以定义成员的实现,但是接口中不可以
        //抽象类中可以包含字段,构造函数,析构函数,静态成员或者变量,但是接口中不可以
        //抽象类中的成员可以是私有的，只要他们不是抽象的,受保护的，内部的，或者受保护的内容部成员
        //受保护的内部成员只能在应用程序的代码或派生类中访问,但是接口中的成员必须是公共的
        //抽象类和接口用于完全不同的目的,抽象类主要用作对象的基类,共享某些主要特性,如，共同的目的和结构
        //接口主要用于类,这些类在基础水平上有所不同,仍可以完成某些相同的任务
        /***********************************/
        public abstract class my__class
        {
            public int i;
            public void normal_method()//普通方法
            { 

            }
            public abstract void abstract_method();//抽象方法
        }
        /***********************************/
        /***********************************/
        /***********************************/
        /***********************************/
        static void Main(string[] args)//static 关键字，Main 方法
        {
            //Console.Read（）读取一个字符，返回该字符的ascII码，
            //Console.ReadLine（）是读取一行，返回值是string类型。
            //Console.WriteLine("hello world !");//Console 标识符 WriteLine 语句
            //Console.ReadLine();


            /****************************************************************/
            //A oa = new A();//实例化N1中的类A
            //oa.Myls();//调用类A中的Mysls方法；
            /****************************************************************/
            //myclass2 ddd = new myclass2();
            //ddd.ID_FOR_sealed = "BH0002";
            //ddd.NAEM_FOR_sealed = "FFF";
            //ddd.Show_info();

            //


            /*************************************************************/
            //dataset_datatable_test ooa = new dataset_datatable_test();
            //ooa.test();
            /**************************************************************/
            //测试接口
            //Program program1 = new Program();
            //IPeople ipeople1 = program1;//使用派生类对象实例化接口
            //ipeople1.age = 333;
            //ipeople1.name = "sss";
            //ipeople1.show_info();
            

            ////测试显示成员接口实现,当两个接口中具有相同的函数名的时候
            //Program program2 = new Program();
            //myinterface1 myinterface1_1 = program2;
            //myinterface2 myinterface2_2 = program2;
            //Console.WriteLine(myinterface1_1.add());
            //Console.WriteLine(myinterface2_2.add());
            /*************************/
            //Drive_class ddd = new Drive_class();
            //my_abstract_class mysss = ddd;
            ////my.id
            //mysss.ID = "BH001";
            //mysss.NAME = "TM";
            //mysss.Showinfo();






























            /***********************/
            //A oa = new A();//实例化N1中的类A
            //oa.Myls();//调用类A中的Mysls方法；
            data_structure aa = new data_structure();
            //aa.test_Queue_List();
            //aa.test_SortedList();
            aa.test_Queue_List_byte();

            //file_operation aaa = new file_operation();
            //aaa.test_stream_reader_writer();


            //int a = 256;
            //byte b = 0x00;//a=256的时候b=(byte)a;b=0
            //b = (byte)a;
            //Console.WriteLine(b);

            Console.ReadLine();
            

            /**************************************************************/

            /*************************************************************/
            //dataset_datatable_test ooa = new dataset_datatable_test();
            //  ooa.test_merge();


            //ooa.openAccess();
            //Console.WriteLine("insert");
            //ooa.insert();
            //Console.WriteLine("delete");
            //ooa.delete();
            //Console.WriteLine("update");
            //ooa.update();
            //Console.WriteLine("ReadLine");
            
           // Console.ReadLine();
            /**************************************************************/

            /*
            两着间的差异在Console.WriteLine()方法是将要输出的字符串与换行控制字符一起输出,
            当次语句执行完毕时,光标会移到目前输出字符串的下一行.
            至于Console.Write()方法,光标会停在输出字符串的最后一个字符后,不会移动到下一行。
            Console.WriteLine("a");Console.WriteLine("b")就会输出在2行的a b
            而 Console.Write("a");Console.Write("b")就在同一行输出a b.
            */
            //try
            //{
            //    Console.Write("please input something:");
            //    int i = Convert.ToInt32(Console.ReadLine());//将输入的内容转化为int
            //    Console.WriteLine(i);
            //}
            //catch(Exception ex)                     //捕获通用异常
            //{
            //    Console.WriteLine(ex.ToString());//输出异常信息
            //}
            //Console.ReadLine();
            /***/
            //private void time1_Tick(object sender, EventArgs e)
            //{
            //    label1.left
            //}
            //int intone = 200;
            //byte bytone = 11;
            //Console.WriteLine("intone ={0}",intone);
            //Console.WriteLine("bytone ={0}",bytone);
            //Console.ReadLine();
            /***/
            //int va = 0;
            //int va2 = va;
            //va2 = 99;
            //C fg = new C();
            //C dd = new C();//使用关键字new创建引用对象!!!!!注意类名后面的()

            ///*???????????????????????????????????*/
            //C ff = dd;//使dd=ff /????????????????/
            //ff.value = 22;
            //Console.WriteLine("dd:{0},{1}",va,va2);
            //Console.WriteLine("resf:{0},{1}",dd.value,ff.value);
            //Console.WriteLine("fg:{0}",fg.value);
            //Console.ReadLine();
            /***/
            //for (int i = 0; i < 10; i++)
            //{
            //    Console.WriteLine("i={0}",i.ToString());
            //}
            //Console.ReadLine();
            //int myvalue = 444;
            //const int myCvalue = 666;
            //Console.WriteLine(myvalue);
            //Console.WriteLine(myCvalue);
            //Console.WriteLine(myvalue.ToString());
            //Console.WriteLine(myCvalue.ToString());
            //myvalue = 333;
            //Console.WriteLine(myvalue);
            //Console.WriteLine(myvalue.ToString());
            //Console.ReadLine();
            /***/
            //double x = 22.225;
            ////int y = (int)x;
            //int z = Convert.ToInt16(x);
            //Console.WriteLine(z);
            //Console.ReadLine();
            /***/
            /*Decimal为SQL Server、MySql等数据库的一种数据类型，可以在定义时划定整数部份以及小数部分的位数，以保证存储的数据更精确。
            C中没有这个类型，在做数据库C语言开发时，可以将此类型数据定义为double类型数据。
        类似的变量对应还有：
            varchar 对应C中的char类型
            date 对应C中的int类型
            number对应C中的long类型*/
            //int i = 33;
            //object ob = i;
            //Console.WriteLine("1,i:{0},ob=:{1}",i,ob);
            ////i = 44;
            //int j = (int)ob;//!!!!!!!!!!!!!执行拆箱操作
            //Console.WriteLine("2,j:{0},ob=:{1}", j, ob);
            //Console.ReadLine();
            /***/
            //decimal L1 = 11.60m;
            //decimal L2 = 11.600m;
            //decimal L3 = 222.00m;
            //bool re1, ret2;
            //re1 = (L1 == L2);
            //ret2 = (L1 == L3);
            //Console.WriteLine(re1);
            //Console.WriteLine(ret2);
            //Console.ReadLine();
            /***/
            //UInt32 a =2;
            //UInt32 d = a>> 1;
            //UInt32 c = a >> 0;

            //uint b = 2;
            //uint e = b<<1;
            //uint f = b<<2;

            //Console.WriteLine(e);
            //Console.WriteLine(f);

            //Console.WriteLine(d);
            //Console.WriteLine(c);
            /***/
            //int i = 0;
            //bool result = i is int;
            //Console.WriteLine(result);
            //Console.ReadLine();
            /***/
            //while (true)
            //{
            //    Console.WriteLine("input year:");
            //    string str = Console.ReadLine();
            //    int year = Int32.Parse(str);
            //    bool isleapyear = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
            //    string yesno = isleapyear ? "是" : "不是";
            //    Console.WriteLine("{0} is {1} a leap year", year, yesno);
            //}
            //Console.ReadLine();
            /***/
            //string[] str = new string[5];//
            //str[0] = "sss";
            //str[1] = "sss1";
            //str[2] = "sss2";
            //str[3] = "sss3";
            //str[4] = "sss4";
            //Console.WriteLine(str[0]);
            //Console.WriteLine(str[1]);
            //Type mytype = typeof(int);
            //Console.WriteLine(mytype);
            //Console.WriteLine(typeof(Int16));
            //Console.WriteLine(typeof(Int32));
            //Console.WriteLine(typeof(Int64));
            //Console.WriteLine(typeof(byte));
            //Console.WriteLine(typeof(long));
            //Console.WriteLine("***");
            //Console.WriteLine(typeof(SByte));
            //Console.WriteLine(typeof(Byte));
            //Console.WriteLine(typeof(short));
            //Console.WriteLine(typeof(ushort));
            //Console.WriteLine("***");
            //Console.WriteLine(typeof(ulong));
            //Console.ReadLine();
            /***/
            //Console.WriteLine("input your name:");
            //string usrname = Console.ReadLine();
            //Console.WriteLine("input your password:");
            //string password = Console.ReadLine();
            //bool login = ((usrname == "sss") && (password == "sss"));
            //string strinfo =login?"login successed":"failed";
            //Console.WriteLine(strinfo);
            //Console.ReadLine();
            /***/
            //Console.WriteLine("input a num:");
            //int j = 0;
            //int i = 1;
            //int flag = 0;
            //int intnum = Convert.ToInt32(Console.ReadLine());
            ////int intnum = Int32.Parse(Console.ReadLine());
            //j = (int)Math.Ceiling(Math.Sqrt(Convert.ToDouble(intnum)));
            //for (i = 1; i <= j; i++)
            //{
            //    flag += Convert.ToInt32(Math.IEEERemainder(intnum, i));
            //}
            //if (flag == 0)
            //{
            //    Console.WriteLine(intnum + "不是素数");
            //}
            //else
            //{
            //    Console.WriteLine(intnum + "是素数");
            //}
            //Console.ReadLine();
            ///***/
            //Console.WriteLine("input a month:");
            //int mymonth = Int32.Parse(Console.ReadLine());
            //string myseason;
            //switch (mymonth)
            //{
            //    case 1:
            //    case 2:
            //    case 12:
            //        myseason = "you input winter";
            //        break;

            //    case 3:
            //    case 4:
            //    case 5:
            //        myseason = "you input spring";
            //        break;

            //    case 6:
            //    case 7:
            //    case 8:
            //        myseason = "you input summer";
            //        break;

            //    case 9:
            //    case 10:
            //    case 11:
            //        myseason = "you input autumn";
            //        break;
            //    default:
            //        myseason = "you input wrong";
            //        break;
            //}
            //Console.WriteLine(myseason);
            /***/
            //int[] num=new int[6]{111,222,333,444,555,666};//不习惯的new数组的方式
            //int s = 0;
            //int nu = 80;
            //while (s < 80)
            //{
            //    if (s > 40)
            //    {
            //        break;
            //    }
            //    else if(s%2==0)
            //    {
            //        Console.WriteLine("{0}", s);
            //    }                
            //    s += 1;
            //}
            /***/
            //ArrayList lists = new ArrayList();//using System.Collections; 实例化ArrayList集合
            //lists.Add("器人机");//
            //lists.Add("机器人");
            //lists.Add("人器机");
            //lists.Add("器机人");
            //Console.WriteLine("lists:");
            //foreach (string str in lists)//
            //{
            //    Console.WriteLine(str);
            //}
            /***/
            //char a = 'a';
            //char b = '9';
            //char c = ' ';
            //char d = '.';
            //char e = 'A';
            //char f = '|';
            //Console.WriteLine("char.IsLetter(a):{0}", char.IsLetter(a));
            //Console.WriteLine("char.IsDigit(b):{0}", char.IsDigit(b));
            //Console.WriteLine("char.IsLetterOrDigit(c):{0}", char.IsLetterOrDigit(c));
            //Console.WriteLine("char.IsLower(a):{0}", char.IsLower(a));
            //Console.WriteLine("char.IsUpper(e):{0}", char.IsUpper(e));
            //Console.WriteLine("IsSeparator(f):{0}", char.IsSeparator(f));//哪些是分隔符
            //Console.WriteLine("IsWhiteSpace(c):{0}", char.IsWhiteSpace(c));
            /***/
            //string str1="dddd";
            //string str3 = "ssss";
            //Console.WriteLine(string.Compare(str1,str3));//-1 dddd ssss
            //Console.WriteLine(str1.CompareTo(str3));//-1
            //Console.WriteLine(str1.Equals(str3));//false
            //Console.WriteLine(string.Equals(str1,str3));//false
            //Console.WriteLine("***");
            //Console.WriteLine(string.Compare(str1, str1));//0
            //Console.WriteLine(string.Compare(str3, str1));//1 ssss dddd 
            //Console.WriteLine("***");

            //string newstring = string.Format("{0}-->{1}",str1,str3);
            //Console.WriteLine(newstring);


            //Console.WriteLine(string.Format("{0:d}", dt));
            //Console.WriteLine(string.Format("{0:D}", dt));
            //Console.WriteLine(string.Format("{0:t}", dt));
            //Console.WriteLine(string.Format("{0:T}", dt));
            //Console.WriteLine(string.Format("{0:f}", dt));

            //string strb = string.Format("{0:G}", dt);

            //char[] separator = {'/',':',' ' };//定义了分隔符
            //string[] split_strings = new string[100];
            //split_strings = strb.Split(separator);
            //Console.WriteLine(strb);
            //for (int i = 0; i < split_strings.Length; i++)
            //{
            //   // Console.WriteLine("{0},{1}",i,split_strings[i]);
            //}
            //string stra = strb.Insert(0, "test");
            //string strab=stra.Insert(1," ");
            //Console.WriteLine(strab);
            //string smile = "*^__^*";
            // string smile = "没有初始化";
            // string strw = smile.PadLeft(7, '(');
            // string strd = strw.PadRight(8,')');

            // string test = "qwdderddtyduiopdd";

            // char[] mychar = new char[100];
            // char[] yourchar = new char[100];//没初始化的出来好多a
            // //string test_L = test.PadLeft(8, '&');
            // //string test_R = test.PadRight(8, '%');
            // //string test_L = test.Remove(9);
            // //string test_R = test.Remove(1, 2);
            // Console.WriteLine(test);
            // string test_L = string.Copy(smile);
            // string test_R = test.Replace('d','D');
            // string test_M = test.Replace("dde", "DDE");
            // //Array.Clear(mychar, 0, mychar.Length);
            // //Array.Clear(yourchar, 0, yourchar.Length);

            // //Console.WriteLine(mychar);
            // //Console.WriteLine(yourchar);

            // Console.WriteLine("       ");
            // //smile.CopyTo(0, mychar, 2, 5);
            // //smile.CopyTo(2, yourchar, 0, 3);
            // Console.WriteLine(test);
            // //Console.WriteLine(test_L);
            // Console.WriteLine(test_M);
            // Console.WriteLine(test_R);
            // //Console.WriteLine(mychar);
            //// Console.WriteLine(yourchar);
            // Console.WriteLine("       ");
            // Console.WriteLine(" "+smile);
            // Console.WriteLine("       ");
            // Console.WriteLine(strd);
            // //Console.WriteLine(strb.Substring(1,5));//substring 第二个参数是长度
            // //Console.WriteLine(string.Format("{0:g}", dt));
            // //Console.WriteLine(string.Format("{0:G}", dt));

            // //Console.WriteLine(string.Format("{0:m}", dt));
            // //Console.WriteLine(string.Format("{0:M}", dt));
            // //Console.WriteLine(string.Format("{0:y}", dt));
            // //Console.WriteLine(string.Format("{0:Y}", dt));
            /***/

            /*
             6中StringBuilder构造函数
            
             public StringBuilder();
             public StringBuilder(int capacity);
             public StringBuilder(string value);
             public StringBuilder(int capacity,int maxcapacity);
             public StringBuilder(string value,int capacity);
             public StringBuilder(string value,int startindex,int length,int capacity);
                        
             */


            //int price = 333;
            //StringBuilder myStringBuilder = new StringBuilder("C#开发d宝典",100);
            //myStringBuilder.Append(">>C#必为了凑字数备");
            //Console.WriteLine("1:"+myStringBuilder);
            //myStringBuilder.AppendFormat("{0:C}",price);
            //Console.WriteLine("2:"+myStringBuilder);
            //myStringBuilder.Insert(0, "软件：");
            //Console.WriteLine("3:"+myStringBuilder);
            //myStringBuilder.Remove(14,myStringBuilder.Length-14);
            //Console.WriteLine("4:" + myStringBuilder);
            //myStringBuilder.Replace("软件","软件开发必备");
            //Console.WriteLine("5:" + myStringBuilder);
            /***/
            //Console.WriteLine("please input something:");
            //string oldstr = Console.ReadLine();
            //string[] strnews = oldstr.Split('.');//注意string后面的[]!!!!!  www baidu com
            //for (int j = 0; j < strnews.Length; j++)
            //{
            //    Console.WriteLine(strnews[j]);
            //}
            //string newstr = "";
            //for (int i = 0; i < strnews.Length; i++)
            //{
            //    if (newstr == "")//第一次进来
            //    {
            //        newstr = "  " + strnews[i].ToString();//这一行之前newstr为""（空，初始化为空）
            //    }                                          //上面那一行结束以后就变成了“  www”(两个空格+3*w)
            //    else//从第二次循环开始都不会再进入if了
            //    {
            //        newstr += "\n  " + strnews[i].ToString();
            //    }

            //}
            //Console.WriteLine("please  something:\n"+newstr);//实际上最后的结果是一个字符串，这个字符串开始的段落带有两个空格，
            //                                                 //结束有换行符
            ////Console.WriteLine( newstr);
            /***/
            //Console.WriteLine("please input your password:");
            ////Console.WriteLine();//换行提示
            //string oldstr=Console.ReadLine();
            //string newstr = Encrypt(oldstr);
            //Console.WriteLine(newstr);
            //string reoldstr = Decrypt(newstr);
            //Console.WriteLine(reoldstr);
            /***/
            //while (true)
            //{
            //    Console.WriteLine("input Chinese:");
            //    string Chinesestr = Console.ReadLine();
            //    byte[] array = new byte[2];
            //    array = Encoding.Default.GetBytes(""+Chinesestr+"");
            //    int front = (short)(array[0] - '\0');
            //    int back = (short)(array[1] - '\0');
            //    //Console.WriteLine(Convert.ToString(front));
            //    //Console.WriteLine(back.ToString("00"));
            //    Console.WriteLine(Convert.ToString(front-160)+(back-160).ToString("00"));
            //}
            /***/
            //string[] arrstr = new string[7] { "Sun", "Fri", "Sta", "Wed", "Mon", "Tue", "Thu" };
            //int [,] arr=new int[,]{{1,2},{2,3},{4,5}};
            ////foreach (string n in arrstr)
            ////{
            ////    Console.WriteLine(n);
            ////}
            //Console.WriteLine(arr.GetLength(0));//二维数组的行数，
            //Console.WriteLine(arr.GetLength(1));//二维数组的列数
            /***/
            //int[] arr1 = new int[5] { 1, 2, 3, 4, 5 };
            //int[] arr2 = new int[5] { 6, 7, 8, 9, 10 };
            //int n = arr1.Length + arr2.Length;
            //int[] arr3 = new int[n];
            //for (int i = 0; i < n; i++)
            //{
            //    if (i < arr1.Length)//注意边界问题
            //    {
            //        arr3[i] = arr1[i];
            //    }
            //    else
            //    {
            //        arr3[i] = arr2[i - arr1.Length];
            //    }            
            //}
            //foreach (int num in arr3)
            //{
            //    Console.WriteLine("{0}",num+" ");
            //}

            //int[,] arr4 = new int[2, 5];
            //for(int j = 0; j < arr4.GetLength(0); j++)
            //{
            //    if (j == 0)
            //    {
            //        for (int k = 0; k < 5; k++)
            //        {
            //            arr4[j, k] = arr1[k];
            //        }
            //    }
            //    else
            //    {
            //        for (int k = 0; k < 5; k++)
            //        {
            //            arr4[j, k] = arr2[k];
            //        }
            //    }

            //}
            //for (int i = 0; i < arr4.GetLength(0); i++)
            //{
            //    for (int j = 0; j < arr4.GetLength(1); j++)
            //    {
            //        Console.WriteLine(arr4[i, j]);
            //        Console.WriteLine("{0},{1}", i, j);
            //    }
            //}

            /***/
            //int[,] arr5=new int [2,3]{{1,2,3},{4,5,6}};
            //int[] arr6 = new int[3];
            //int[] arr7 = new int[3];
            //for (int i = 0; i < arr5.GetLength(0);i++ )
            //{
            //    if (i == 0)
            //    {
            //        for (int j = 0; j < arr5.GetLength(1); j++)
            //        {
            //            arr6[j] = arr5[i, j];
            //        }
            //    }
            //    else 
            //    {
            //        for (int j = 0; j < arr5.GetLength(1); j++)
            //        {
            //            arr7[j] = arr5[i, j];
            //        }
            //    }                
            //}

            //foreach (int n in arr6)
            //{
            //    Console.WriteLine(n);
            //}
            //Console.WriteLine("***");
            //foreach (int n in arr7)
            //{
            //    Console.WriteLine(n);
            //}

            /***/
            /*ArrayList三种构造方式*/
            //1
            //ArrayList arr = new ArrayList();
            //for (int i = 0; i < 10; i++)
            //{
            //    arr.Add(i);
            //}
            ////3
            //int[] ab = new int[3] { 777, 77, 7777};
            //int [] a=new int [10]{11,12,13,10,14,15,16,1,17,18};
            //ArrayList arrar = new ArrayList(a);
            //arrar.Add(99);//99表示添加到集合的数值
            //arrar.InsertRange(8, ab);
            //foreach (int arrn in arrar)
            //{
            //    Console.Write(arrn);
            //    Console.Write(" ");
            //}
            //Console.WriteLine();
            ////arrar.Clear();
            //arrar.Remove(10);//
            //foreach (int arrn in arrar)
            //{
            //    Console.Write(arrn);
            //    Console.Write(" ");
            //}
            //Console.WriteLine();
            //arrar.RemoveAt(0);
            //foreach (int arrn in arrar)
            //{
            //    Console.Write(arrn);
            //    Console.Write(" ");
            //}
            //Console.WriteLine();

            //arrar.RemoveRange(1,3);
            //foreach (int arrn in arrar)
            //{
            //    Console.Write(arrn);
            //    Console.Write(" ");
            //}
            //Console.WriteLine();
            ////3
            //ArrayList arrat = new ArrayList(10);
            //for (int i = 0; i < arrat.Count; i++)
            //{
            //    arrat.Add(i);
            //}
            //arrar.Insert(5,777);
            //foreach (int arrn in arrar)
            //{
            //    Console.Write(arrn);
            //    Console.Write(" ");
            //}
            //Console.WriteLine();
            //Console.WriteLine(arrar.Contains(777));
            //Console.WriteLine(arrar.Contains(666));
            //Console.WriteLine(arrar.IndexOf(777));
            //Console.WriteLine(arrar.Count);
            //Console.WriteLine(arrar.LastIndexOf(777));//查找倒序的最后一个

            /***/
            //Hashtable hash = new Hashtable();
            //hash.Add("id", "BH0001");
            //hash.Add("name", "shshh");
            //hash.Add("age", "21");
            //Console.WriteLine(hash.Count);
            //hash.Remove("id");
            //Console.WriteLine(hash.Count);
            //hash.Clear();
            //Console.Write("\t");
            //Console.WriteLine(hash.Count);
            //foreach(DictionaryEntry dict in hash)
            //{
            //   // Console.WriteLine("\t"+dict.Key+"\t"+dict.Value);
            //}
            //Console.WriteLine(hash.Contains("id"));
            //Console.WriteLine(hash.ContainsKey("age"));
            //Console.WriteLine(hash.ContainsValue("21"));
            /***/
            //MYClass a = new MYClass();
            //a.ID = "0702";
            //a.Name = "ssddc";
            //Console.WriteLine(a.ID + "  " + a.Name);
            //MYClass b = new MYClass();
            //b.Name = "ccc";
            //b.ID = "0011";
            //Console.WriteLine(b.ID + ": " + b.Name);
            //Program p = new Program();
            //int x = 3;
            //int y = 5;
            //int z = 4;
            //double e = 5.10;
            //Console.WriteLine(Program.add(x,y));
            //Console.WriteLine(p.add(x, e));
            //Console.WriteLine(p.add(x, y, z));
            /***/
            //RECT d = new RECT();
            //RECT d;
            //d.length = 5;
            //d.width = 3;
            //Console.WriteLine(d.Area());
            //RECT dd = new RECT(4,6);
            //Program ppp = new Program();
            //int x = 22;
            //int y = 33;
            //MYClass mtc = new MYClass();
            //mtc.XC=x;
            //mtc.YC=y;
            //mtc.ZC=mtc.YC+mtc.XC;
            //int z=mtc.ZC;

            //MYClass mc1 = new MYClass();
            //MyClass1 mc2 = new MyClass1();
            //mc1.XC = 1;
            //mc1.YC = 2;
            //mc2.YC = 3;
            //mc2.XC = 4;
            //mc2.ZC1 = 5;

            //Console.WriteLine(mc1.add());
            //Console.WriteLine(mc2.add());
            //Console.WriteLine(mc2.add1());
            //Console.WriteLine(ppp.zp);
            /***/

            //接口有问题

            //Program pppp = new Program();
            //IPeople pep = pppp;
            //pep.Name = "ddd";
            //pep.Sex = "man";
            //pppp.show();
            //Console.WriteLine(pep.Name + " " + pep.Sex);
            /***/

            //MyClass1 mcv=new MyClass1();
            //MYClass mcvb = (MYClass)mcv;//使用派生类mcv的对象实例化基类MYClass的对象
            //mcvb.XC = 77;
            //mcvb.YC = 11;
            //Console.WriteLine(mcvb.add());
            //Console.WriteLine(mcv.add());
            //Console.ReadLine();

            /***/
            //A oa = new A();//实例化N1中的类A
            //oa.Myls();//调用类A中的Mysls方法；
            /***/
            //时间字符串
            //DateTime dt = DateTime.Now;
            //Console.WriteLine(dt.ToString("yyMMddHHmmdd"));//18_11_07_11_41_59_20
            //Console.WriteLine(dt.ToString("yyyyMMddHHmmdd"));//2018_11_07_11_41_59_20
            //Console.ReadLine();
            //Random ran = new Random();
            //Console.WriteLine(ran.Next(999,9999)+dt.ToString("yyyyMMddHHmmddms"));


            // int RandKey = ran.Next(100, 999);
            //Console.WriteLine("hello world!!");
            //Console.ReadLine();
            /***/
            /**************************/
            //Access acc = new Access();
            //Console.ReadLine();
            /***********************/

          
            



            //static void Main(string[] args)
            //{
            //    Program prog=new Program();

            //}
        }
    }
}

/*
　  1. List，这是我们应用最多的泛型种类，它对应ArrayList集合。

　　2. Dictionary，这也是我们平时运用比较多的泛型种类，对应Hashtable集合。

　　3. Collection对应于CollectionBase

　　4. ReadOnlyCollection 对应于ReadOnlyCollectionBase,这是一个只读的集合。

　　5. Queue,Stack和SortedList，它们分别对应于与它们同名的非泛型类。 
 
 *  var result = from pair in dic //dic是数据源，pair是具有dic类型，但是没有名称的参数(匿名函数)
    orderby pair.Key // 默认按照pair.Key 的升序排列
    select pair; //将pair选择出来
 * 
 * 
 * Clear()	从 Stack<T> 中移除所有对象。
 * Contains(T)	确定某元素是否在 Stack<T> 中。
 * CopyTo(T[], Int32)	从特定的数组索引处开始，将 Stack<T> 复制到现有一维 Array。
 * Equals(Object)	确定指定的对象是否等于当前对象。（从 Object 继承。）
 * Peek()	返回 Stack<T> 顶部的对象而无需移除它。
 * Pop()	移除并返回位于顶部的对象 Stack<T>。
 * Push(T)	将对象插入 Stack<T> 的顶部。
 * ToArray()	将 Stack<T> 复制到新数组。
 * ToString()	返回表示当前对象的字符串。（从 Object 继承。）
 * TrimExcess()	如果元素数小于当前容量的 90%，将容量设置为 Stack<T> 中的实际元素数。
*/
/*
 SortedList类代表了一系列按照键来排序的键值对，这些键值对可以通过键和索引来访问
 * 排序列表是数组和哈希表的组合，它包含一个可使用键或者索引访问各项的列表
 * 如果使用索引访问各项，则是一个动态数组(ArrayList),
 * 如果使用键访问各项，则是一个哈希表，集合中的各项总是按照键值来排序
 * count 获取SortList中的元素个数
 * Item 获取或这是与SortedList中指定的键相关的值
 * Keys获取SortedList中的键
 * Values获取SortedList获取值
 * public virtual void Add(object key,object value)向sortedList天剑一个带有指定的键值的元素
 * public virtual bool ContainsKey(object key)
 * public virtual bool ContainsKey(object value)
 * public virtual object GetByIndex(int index)
 * public virtual object GetKeyIndex(int index)
 */

namespace N4
{
    class data_structure
    {
        //测试数组队列
        public void test_Queue_List_int()
        {
            Queue<List<int>> queue = new Queue<List<int>>();
            for (int i = 0; i < 9; i++)
            {
                List<int> list = new List<int>();
                for (int j = 0; j <= 5; j++)
                {
                    list.Add(j + (i + 1) * 10);//想List中添加数据
                }
                queue.Enqueue(list);//队列入列
            }
            while (queue.Count > 0)
            {
                List<int> list_1 = queue.Dequeue();//队列出列
                foreach (var i in list_1)
                {
                    Console.Write(i + " ");
                }
                Console.WriteLine();
            }
        }
        
        public void test_Queue_List_byte()
        {
            Queue<List<byte>> queue_1 = new Queue<List<byte>>();
            byte [] by=null;
            byte[] by_1 = null;
             by_1 = new byte [20];
            for (int i = 0; i < 9; i++)
            { 
                //List<byte> list =new List<byte>();
                //ArrayList list1 = new ArrayList();
                for(int j=0;j<10;j++)
                {
                    //list.Add((byte)(j + (i + 1) * 10));//
                    by_1[j] = (byte)(j + (i + 1) * 10);
                }
                //ArrayList list1 = new ArrayList(by_1);
                List<byte> list = new List<byte>(by_1);
                queue_1.Enqueue(list);
            }
            while (queue_1.Count > 0)
            {
                List<byte> list_2 = queue_1.Dequeue();

                by = list_2.ToArray();
                Console.WriteLine(by.Length);
                Console.Write(by[0]);
                Console.Write("--");
                Console.WriteLine(by[5]);
                
                //foreach (var i in list_2)
                //{
                //    //Console.Write("%x={0}",i+"-");
                //    Console.Write("0x{0:X2}",i + "-");
                //}


                Console.WriteLine();
            }
        }


        /*
         Dictionary<string,string>是一个泛类
         它本身有集合的功能有时候可以把它看成数组
         * 它的的结构是这样的:Dictionary<[key],[value]>
         * 它的特点是:存入对象是需要与[key]值一一对应的存入该泛类
         * 通过某一个一定的[key]去找到对应的值
         * 举个例子:
         *   Comparer：           获取用于确定字典中的键是否相等的 IEqualityComparer。

  Count：                  获取包含在 Dictionary中的键/值对的数目。

  Item：                    获取或设置与指定的键相关联的值。

  Keys：                   获取包含 Dictionary中的键的集合。

  Values：                获取包含 Dictionary中的值的集合。

  Add：                    将指定的键和值添加到字典中。

  Clear：                  从 Dictionary中移除所有的键和值。

  ContainsKey：      确定 Dictionary是否包含指定的键。

  ContainsValue：   确定 Dictionary是否包含特定值。             

  GetEnumerator：  返回循环访问 Dictionary的枚举数。

  GetType：             获取当前实例的 Type。 （从 Object 继承。）

  Remove：             从 Dictionary中移除所指定的键的值。

  ToString：             返回表示当前 Object的 String。 （从 Object 继承。）

  TryGetValue：      获取与指定的键相关联的值。
         * 
         */
        public void test_Dictionary_1()
        {
            //实例化对象
            Dictionary<int, string> dic = new Dictionary<int, string>();
            //对象打点添加
            dic.Add(1,"haha");
            dic.Add(5, "hoho");
            dic.Add(3, "hehe");
            dic.Add(2,"hihi");
            dic.Add(4, "huhu");

            var result = from pair in dic orderby pair.Key select pair;

            foreach(KeyValuePair<int ,string> pair in result )
            {
                Console.WriteLine("Key:{0},Value:{1}",pair.Key,pair.Value);    
            }
            
            //string a = dic[1];//[key]
            //string b = dic[2];
            //string c = dic[3];
            //Console.WriteLine(a + "-" + b + "-" + c);
            //Console.ReadLine();

    //        //判断键存在
    //if (openWith.ContainsKey("bmp")) // True 
    //{
    //    Console.WriteLine("An element with Key = \"bmp\" exists.");
    //}
        }

        public void test_SortedList()
        {
            SortedList s1 = new SortedList();
            s1.Add("008", "nuhal");
            s1.Add("007", "xxx");
            s1.Add("006", "aa");
            s1.Add("005", "ss");
            s1.Add("004", "dd");
            s1.Add("003", "ee");
            s1.Add("002", "aaa");
            s1.Add("001", "ddd");
            ICollection key = s1.Keys;
            foreach (string k in key)
            {
                Console.WriteLine(k + "::" + s1[k]);
            }
            Console.WriteLine(s1.ContainsValue("ddd"));
        }
        public void test_Stack()
        {
            Stack st = new Stack();
            st.Push('A');
            st.Push('B');
            st.Push('C');
            st.Push('D');
            st.Push('E');
            st.Push('F');
            Console.WriteLine("Current stack:");
            foreach (char c in st)
            {
                Console.Write(c + "-");
            }

            Console.WriteLine();
            st.Push('V');
            st.Push('H');
            Console.WriteLine("the next popable value in stack:{0}",
                st.Peek());

            Console.WriteLine("Current stack:");
            foreach (char c in st)
            {
                Console.Write(c + "=");
            }
            Console.WriteLine();

            Console.WriteLine("remove values");
            Console.WriteLine("--{0}--{1}--{2}", st.Pop(), st.Pop(), st.Pop());
            //st.Pop();
            //st.Pop();
            //st.Pop();

            Console.WriteLine("Current stack:");
            foreach (char c in st)
            {
                Console.Write(c + "--");
            }
            Console.WriteLine();
        }

        public void test_Stack_T_string()
        {
            //Stack<T>泛型容器
            Stack<string> numbers = new Stack<string>();
            numbers.Push("one");
            numbers.Push("two");
            numbers.Push("three");
            numbers.Push("four");
            numbers.Push("five");
            foreach (string str in numbers)
            {
                Console.Write(str+"-");
            }
            Console.WriteLine("\npoping:{0}",numbers.Pop());
            Console.WriteLine("peek:{0}", numbers.Peek());
            Console.WriteLine("pop:{0}",numbers.Pop());


            Stack<string> stack_1 = new Stack<string>(numbers.ToArray());
            Console.WriteLine("\n contents of the first copy:");
            foreach (string num in stack_1)
            {
                Console.Write(num+"=");
            }

            string[] string_array = new string[numbers.Count * 2];
            numbers.CopyTo(string_array, numbers.Count);

            Stack<string> stack3 = new Stack<string>(string_array);
            Console.WriteLine("\n contents of the second copy ,with duplicates and nulls:");
            foreach (string nu in stack3)
            {
                Console.WriteLine(nu);
            }
            Console.WriteLine("\nstack.contains(\"four\")={0}", stack_1.Contains("four"));
            stack_1.Clear();
            Console.WriteLine("\nstatck2.count={0}",stack_1.Count);

        }
    
    }
    //读写的内容不多时
    class file_operation
    { 
        //可以使用 File.ReadAllText(FilePath) 或指定编码方式 File.ReadAllText(FilePath, Encoding)的方法。
        //使用方法File.ReadAllLines。该方法返回一个字符串数组。每一行都是一个数组元素。
        //文本的内容比较大时,采用流（Stream）的方式来读取内容。.Net为我们封装了StreamReader类。
        //

        /*
         使用File.writeAllText方法来一次将内容全部写入文件
         * 将一个字符串的内容写入文件，可以用File.WriteAllText(FilePath)
         * 或指定编码方式File.WriteAllText(FilePath,Encoding)方法
         * 如果指定的文件路径不存在，会创建一个新文件；
         * 如果文件已经存在，则会覆盖原文件。
         */
        string Strpath = @"E:\work\temp.txt";
        string str_2 = "hello world";
        string[] str_3 = { "good morning", "good afternoon" };

        public void test_file_read_write()
        {
            string str_1 = File.ReadAllText(Strpath);
            string[] strs = File.ReadAllLines(@"E:\work\temp.txt");

            //int count = 0;
            //File.WriteAllText(@"E:\work\123.txt", str_2);
            File.WriteAllLines(@"E:\work\123.txt", str_3);
            //Console.WriteLine(str_1);
            Console.WriteLine("---");
            //while
            foreach(string str_temp in strs)
            {
               // Console.WriteLine(str_temp);
            }            
        }
        /*当文件内容较大时，应该采用流(stream)方式来读取
         * 
         
         */
        public void test_stream_reader_writer()
        {
            int count = 0;
            StreamReader sr1 = new StreamReader(Strpath);

            string str11;
            //while ((str11 = sr1.ReadLine()) != null)
            //{
            //    count += 1;
            //}

            while (true)
            {
                str11 = sr1.ReadLine();
                if (str11 != null)
                {
                    count += 1;
                    Console.WriteLine(str11);
                }
                else
                {

                    break;
                }               

            }
            Console.WriteLine(count);
            //全部读完
           // string restofStream = sr1.ReadToEnd();
            //FileStream fs = new FileStream(Strpath,FileMode.Open);
            //StreamReader sr2 = new StreamReader(fs);
            //读一行
           // string str_temp_2 = sr1.ReadLine();
            //读一个字符
           // int nextchar = sr1.Read();
            //读10个字符
          //  char[] charArray = new char[20];
           // int ncharread = sr1.Read(charArray, 0, 20);
            
            //使用完streamreader之后不要忘记关闭它

            
            //Console.WriteLine(restofStream);
            //Console.WriteLine(count);
            //Console.WriteLine(str_temp_2);
            //Console.WriteLine(nextchar);

           // foreach (char ch in charArray)
           // {
                //Console.WriteLine(ch);
           // }
            sr1.Close();
        }
    
    }

}
namespace N1
{
    class A
    {
        public void Myls()
        {
            Console.WriteLine("C#开发实战宝典");//Console 标识符 WriteLine 语句
            Console.ReadLine();
        }
       
        //public
    }
    /**************************/
    //Access acc = new Access();
    //Console.ReadLine();
    /***********************/
   //操作数据库
   //  accdb(access Database)格式是Microsoft Access 2007软件使用的一种存储格式，
   //mdb是Microsoft Access 2007以前版本的数据库格式。
   //相当于word2003格式是doc；word2007格式是docx。一样一样的。
    public class  Access 
    {
        //OleDbConnection oleDb = new OleDbConnection(@"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\Users\25454\Documents\CSDN.mdb");
        //ConnectionString=Provider=Microsoft.ACE.OLEDB.12.0;Data Source=StationInfo.accdb;Persist Security Info=False
        OleDbConnection oleDb = new OleDbConnection(@"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=E:\Visual Studio 2010\Projects\C_sharp_no_windows\ConsoleApplication2\CSDN.mdb");

        public Access() //构造函数
        {
            oleDb.Open();
           // Del();
           // Change();
            //Add();
          auto_Add_value();
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
                    Console.WriteLine(item[0] + " | " + item[1]+ " | "+item[2]);
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
            public bool auto_Add_value()
            {
                //string sql = "insert into 表1 (昵称,账号) values ('str1','2545493686')";
                ////string sql = "insert into 表1 (昵称,账号) values ('LanQ','2545493686')";
                ////往表1添加一条记录，昵称是LanQ，账号是2545493686
                //OleDbCommand oleDbCommand = new OleDbCommand(sql, oleDb);
                //int i = oleDbCommand.ExecuteNonQuery(); //返回被修改的数目       
                // return i > 0;
                int ii = 0;
                int i = 0;
                string str1 = "";
                string str2 = "";
                string strtemp = "','";
                string strtemp2="')";
                string sql = "";
                string sql1 = "insert into 表1 (昵称,账号) values ('";
                DateTime dt = DateTime.Now;
                //Console.WriteLine(dt.ToString("yyyyMMddHHmmddms"));

                Random ran = new Random();
               // Console.WriteLine(ran.Next(999, 9999) + dt.ToString("yyyyMMddHHmmddms"));
                for (ii = 0; ii < 10; ii++)
                {
                    str1 = ran.Next(9999, 99999).ToString() + ran.Next(999, 9999).ToString();
                    //str1 = ran.Next(999, 9999).ToString()+dt.ToString("yyyyMMddHHmmddms");
                    str2="lan"+ii.ToString();
                    sql = sql1;
                    sql += str2;
                    sql += strtemp;
                    sql += str1;
                    sql += strtemp2;
                    Console.WriteLine(sql);
                    //sql = "insert into " + "表1(昵称, 账号) " + " values('LAN+ii.ToString'" + ran.Next(999, 9999) + dt.ToString("yyyyMMddHHmmddms") + " ',' " + ran.Next(999, 9999) + dt.ToString("yyyyMMddHHmmddms") + " ) ";
                    //sql = "insert into 表1 (昵称,账号) values ('str1','2545493686')";
                    OleDbCommand oleDbCommand = new OleDbCommand(sql, oleDb);
                    //延时有用
                    System.Threading.Thread.Sleep(1000*2); //毫秒

                    i = oleDbCommand.ExecuteNonQuery(); //返回被修改的数目
                    if (i > 0)
                    {
                        i++;
                    }
                    
                }
               
                //int i = oleDbCommand.ExecuteNonQuery(); //返回被修改的数目       
                return i > 0;
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
namespace N2
{
    /// <summary>
    /// 
    /// </summary>
    class dataset_datatable_test
    {
        DataSet ds = new DataSet();
        DataSet ds1 = new DataSet();//for_merge
        DataSet ds2 = new DataSet();//for_merge
        DataSet ds3 = new DataSet();//for_copy
        DataSet ds4 = new DataSet();//for_fill(i,j)填充部分行
        DataTable dt_for_clone = new DataTable();

        //SqlDataAdapter 是用连接SQL数据库的
        //OleDbDataAdapter 是连接Access小型数据库的


        OleDbDataAdapter da = new OleDbDataAdapter();
        OleDbDataAdapter da1 = new OleDbDataAdapter();
        OleDbDataAdapter da2 = new OleDbDataAdapter();
        string oleDBString = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=E:/Visual Studio 2010/Projects/WindowsFormsApplication2/文档/AccessTest.accdb";
        string sql = "";
        public void test()
        {
            //C# DataSet(内存中的数据集)
            //DataSet 中有多个 DataTable；DataTable 中有多个DataColumn (列名)，多个Rows (数据行)。
            {
                //创建一个内存的数据集
                DataSet ds = new DataSet("DS5");
                //DataSet的名字
                Console.WriteLine(ds.DataSetName);
                //创建一张内存表
                DataTable dt1 = new DataTable("dt1");
                //把表放到数据集里面去。
                ds.Tables.Add(dt1);

                //给表定义列
                DataColumn dcName = new DataColumn("Name", typeof(string));  //定义三个列名
                DataColumn dcAge = new DataColumn("Age", typeof(int));
                DataColumn dcId = new DataColumn("Id", typeof(int));

                //把列放到表里面去。
                dt1.Columns.AddRange(new DataColumn[] { dcId, dcName, dcAge });

                //给表添加数据
                dt1.Rows.Add(1, "老马", 18);  //添加数据行，一行三个数据 对应三个列名。次序也要对应。
                dt1.Rows.Add(1, "赵黑", 29);
                dt1.Rows.Add(1, "老王", 18);
                dt1.Rows.Add(1, "老汪", 19);

                //创建一张内存表，第二张表
                DataTable dt2 = new DataTable("dt2");

                //把表放到数据集里面去。
                ds.Tables.Add(dt2);

                //给表定义列
                DataColumn dcName2 = new DataColumn("Name", typeof(string));
                DataColumn dcAge2 = new DataColumn("Age", typeof(int));
                DataColumn dcId2 = new DataColumn("Id", typeof(int));

                //把列放到表里面去。
                dt2.Columns.AddRange(new DataColumn[] { dcId2, dcName2, dcAge2 });

                //给表添加数据
                dt2.Rows.Add(4, "dd", 33);
                dt2.Rows.Add(4, "dd", 33);
                dt2.Rows.Add(4, "dd", 33);
                dt2.Rows.Add(4, "dd", 33);

                //打印table数量
                Console.WriteLine(ds.Tables.Count);
                //打印列数量
                Console.WriteLine(ds.Tables["dt1"].Columns.Count);
                //打印列数量
                Console.WriteLine(ds.Tables["dt2"].Columns.Count);
                //打印行数量
                Console.WriteLine(ds.Tables["dt1"].Rows.Count);
                Console.WriteLine(ds.Tables["dt2"].Rows.Count);

                Console.Write("dt1:");
                //取出dt1表各列名{0,-5}间隔大小
                Console.WriteLine("{0,-5} {1,-5} {2,-5}", ds.Tables["dt1"].Columns[0],
                ds.Tables["dt1"].Columns[1], ds.Tables["dt1"].Columns[2]);
                Console.Write("dt2:");
                //取出dt1表各列名{0,-5}间隔大小
                Console.WriteLine("{0,-5} {1,-5} {2,-5}", ds.Tables["dt2"].Columns[0],
                ds.Tables["dt2"].Columns[1], ds.Tables["dt2"].Columns[2]);


                //输出dt1表中第三行
                DataRow row1 = ds.Tables["dt1"].Rows[2];
                Console.WriteLine("{0,-5} {1,-5} {2,-5}", row1[0], row1[1], row1[2]);
                //直接赋值就可以修改
                row1[0] = 99;
                row1[1] = "99";
                row1[2] = 99;
                //ds.Tables["dt1"].Remove(3);

                //①使用DataTable.Rows.Remove(DataRow)，或者DataTable.Rows.RemoveAt(index)；可以直接删除行
                //②使用datatable.Rows[i].Delete()。Delete()之后需要datatable.AccepteChanges()方法确认完全删除，
                //因为Delete()只是将相应列的状态标志为删除，还可以通过datatable.RejectChanges()回滚，使该行取消删除。
                //使用dt.Columns.Remove("ItemPrice");直接删除。

                //删除第四行
                ds.Tables["dt1"].Rows[3].Delete();
                //提交删除
                ds.Tables["dt1"].AcceptChanges();
                //删除列
                ds.Tables["dt2"].Columns.Remove("Id");
                Console.WriteLine("第二种方法");
                //下列两种方法等效都等同于row2[1]（即第五行的第二列的值）
                Console.WriteLine(" {0,-25} ", ds.Tables["dt1"].Rows[2][1]);
                Console.WriteLine(" {0,-25} ", ds.Tables["dt1"].Rows[2]["Name"]);


                //输出DataSet中的所有数据
                foreach (DataRow row in ds.Tables["dt1"].Rows)
                {
                    Console.Write("::");
                    Console.WriteLine("{0,-15} {1,-10} {2,-10}", row["Name"],
                    row["Age"], row["Id"]);
                    //取第三列的值
                    //Console.WriteLine("{0,-15} ", row[3]);
                }

                //Console.WriteLine("遍历之前");



                //遍历数据集DataSet
                foreach (DataTable tb in ds.Tables)
                {
                    if (tb.TableName.Equals("dt1"))
                    {
                        foreach (DataRow dataRow in tb.Rows)  //遍历数据表 DataTable
                        {
                            Console.WriteLine(dataRow[0] + "  " + dataRow[1] + "  " + dataRow[2]);
                        }
                    }
                    else
                    {
                        foreach (DataRow dataRow in tb.Rows)  //遍历数据表 DataTable
                        {
                            Console.WriteLine(dataRow[0] + "  " + dataRow[1] + "  ");
                        }
                    }

                }

                ////遍历一个表多行多列
                //foreach (DataRow mDr in dataSet.Tables[0].Rows)
                //{
                //    foreach (DataColumn mDc in dataSet.Tables[0].Columns)
                //    {
                //        Console.WriteLine(mDr[mDc].ToString());
                //    }
                //}

                ////一行一列
                //ds.Tables[0].Rows[0]["字段"]
                Console.WriteLine(ds.Tables[0]);
                Console.WriteLine(ds.Tables[1]);
                Console.ReadLine();
            }            
        }
        /*******************分割线*****************/
        public void insert()
        {
            sql = "insert into student(姓名,学号,班级) values('yuanl','44','四班')";
            OleDbConnection conn = new OleDbConnection(oleDBString);
            conn.Open();

            da = new OleDbDataAdapter(sql, conn);

            da.Fill(ds);//这里有个问题，如果这句话注释掉的话，貌似数据库里数据没有插入，下面openAccess（）函数再重新获取数据，得到的表是没有插入语句这条记录的
            // accessGrid.ItemsSource = ds.Tables[0].DefaultView;
            conn.Close();
            openAccess();          
        }
        /*********************************/
        public void openAccess()
        {
            //  OleDbCommand cmd;
            //数据库连接语句
            sql = "select * from student";
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
        /****************************************/
        public void delete()
        {
             sql = "delete from student where ID=" + "5";

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
        /****************************/
        public void update()
        {
            sql = "update student set 姓名=\"哈哈\"where ID=" + "2";
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
        /****************************/
        public void test_merge()
        {
            string sql1 = "select * from student";
            ds1.Clear();
            //创建连接对象
            OleDbConnection conn1 = new OleDbConnection(oleDBString);
            //da = new OleDbDataAdapter(sql,conn);
            // da.SelectCommand = new OleDbCommand(sql, conn);
            //OleDbCommandBuilder cb = new OleDbCommandBuilder(da);
            // da.UpdateCommand = cb.GetUpdateCommand();
            da1 = new OleDbDataAdapter(sql1, conn1);
            da1.Fill(ds1);

            string sql2 = "select * from teacher";
            ds2.Clear();
            //创建连接对象
            OleDbConnection conn2 = new OleDbConnection(oleDBString);
            //da = new OleDbDataAdapter(sql,conn);
            // da.SelectCommand = new OleDbCommand(sql, conn);
            //OleDbCommandBuilder cb = new OleDbCommandBuilder(da);
            // da.UpdateCommand = cb.GetUpdateCommand();
            da2 = new OleDbDataAdapter(sql2, conn2);
            da2.Fill(ds2);




            ////输出DataSet中的所有数据
            //foreach (DataRow row in ds1.Tables.Rows)
            //{
            //    Console.Write("::");
            //    Console.WriteLine("{0,-15} {1,-10} {2,-10}", row["Name"],
            //    row["Age"], row["Id"]);
            //    //取第三列的值
            //    //Console.WriteLine("{0,-15} ", row[3]);
            //}
            ////一行一列
            //ds.Tables[0].Rows[0]["字段"]

            //遍历一个表多行多列
            foreach (DataRow mDr in ds1.Tables[0].Rows)
            {
                foreach (DataColumn mDc in ds1.Tables[0].Columns)
                {
                
                    Console.Write("{0,-10}",mDr[mDc].ToString());
                }
                Console.WriteLine();
            }
            Console.WriteLine("/********/");
            foreach (DataRow mDr2 in ds2.Tables[0].Rows)
            {
                foreach (DataColumn mDc2 in ds2.Tables[0].Columns)
                {

                    Console.Write("{0,-10}", mDr2[mDc2].ToString());
                }
                Console.WriteLine();
            }

            ds2.Merge(ds1, false,MissingSchemaAction.Add);
            Console.WriteLine("/after merge********/");
            foreach (DataRow mDr2 in ds2.Tables[0].Rows)
            {
                foreach (DataColumn mDc2 in ds2.Tables[0].Columns)
                {

                    Console.Write("{0,-10}", mDr2[mDc2].ToString());
                }
                Console.WriteLine();
            }

            Console.WriteLine("/***** copy ********/");
            ds3 = ds2.Copy();

            foreach (DataRow mDr3 in ds3.Tables[0].Rows)
            {
                foreach (DataColumn mDc3 in ds3.Tables[0].Columns)
                {

                    Console.Write("{0,-10}", mDr3[mDc3].ToString());
                }
                Console.WriteLine();
            }
            Console.WriteLine("/***** clone ********/");
            dt_for_clone = ds2.Tables[0].Clone();
            //ds4.Tables[0].add
            //导入行
            dt_for_clone.ImportRow(ds2.Tables[0].Rows[0]);
            dt_for_clone.ImportRow(ds2.Tables[0].Rows[0]);
            dt_for_clone.ImportRow(ds2.Tables[0].Rows[0]);

            foreach (DataRow mDr3 in dt_for_clone.Rows)
            {
                foreach (DataColumn mDc3 in dt_for_clone.Columns)
                {

                    Console.Write("clone:{0,-10}", mDr3[mDc3].ToString());
                }
                Console.WriteLine();
            }

        }
        /****************************/

        /****************************/
        /****************************/

    }
}
//接口模板
namespace N3
{
    /// <summary>
    /// 
    /// </summary>
    /*
     interface myinterface
     {
      /// <summary>
    /// 编号(可读可写)
    /// </summary>
     string id
     * {
     *  get;
     *  set;
     * }
     * string name
     * {
     *  get;
     *  set;
     * }
     * //显示定义的编号和姓名
     * void show();
     * * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * }
     
     
     
     
     
     */


}