using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using N1; //使用using关键字引入命名空间N1

namespace C_sharp//命名空间
{
    class Program//类
    {
        class C
        {
            public int value = 0;
        }
        static void Main(string[] args)//static 关键字，Main 方法
        {
            //Console.Read（）读取一个字符，返回该字符的ascII码，
            //Console.ReadLine（）是读取一行，返回值是string类型。
            //Console.WriteLine("hello world !");//Console 标识符 WriteLine 语句
            //Console.ReadLine();
            /***/
            //A oa = new A();//实例化N1中的类A
            //oa.Myls();//调用类A中的Mysls方法；
            /***/
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
            Console.WriteLine("input a num:");
            int j = 0;
            int i = 1;
            int flag = 0;
            int intnum = Convert.ToInt32(Console.ReadLine());
            //int intnum = Int32.Parse(Console.ReadLine());
            j = (int)Math.Ceiling(Math.Sqrt(Convert.ToDouble(intnum)));
            for (i = 1; i <= j; i++)
            {
                flag += Convert.ToInt32(Math.IEEERemainder(intnum, i));
            }
            if (flag == 0)
            {
                Console.WriteLine(intnum + "不是素数");
            }
            else
            {
                Console.WriteLine(intnum + "是素数");
            }
            Console.ReadLine();
            /***/
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



}