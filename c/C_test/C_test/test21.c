/*BIOS编译不通过！！！！！！！！！！！*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
//#include<bios.h>
void isprime_self(int m)
{
	int i = 2;
	for (i = 2; i < m / 2; m++)
	{
		if (m%i == 0)
		{
			printf("%d,NO!", i);
			//break;
			return 0;
		}


	}

}
int cifang(int m, int n)
{
	int i = 1;
	int sum = 1;
	for (i = 1; i <= n; i++)
	{
		sum = sum*m;
	}
	return sum;
}
int main()
{
	int m, n;
	int ret;
	int min;
	double s, x, y;

	long origin, ne;
	origin = biostime(0,0);//调用biostime(int cmd,long newtime)函数来读取时钟的当前值；
	printf("\n当前时间:%ld\n",origin);
	ne = biostime(1,500);//当cmd为1把时间设置为newtime值，当cmd为0,读取当前时钟值
	printf("\n当前时间:%ld\n", ne);
	//bios的时钟以每秒18.2的脉冲速率运行，午夜十二点变成0，然后不断增长
	//struct date d;//定义date结构体变量
	//struct time *T；//定义time结构体变量
	//	getdate(&d);//获取系统当前日期；
	//gettime(&T);//获取系统当前时间
	//printf("day is :%d--%d--%d\n", d.da_year, d.da_mon, d.da_day);
	//printf("time is :%d--%d--%d\n", T.ti_hour, T.ti_min, T.ti_sec);
	time_t Time, end;//定义Time为time_t类型
	struct tm *t, *gt;//定义指针t为tm结构类型
	Time = time(NULL);//获取当前时间信息
	Sleep(1000);
	end = time(NULL);
	//printf("run time is :%f(s)\n", difftime(end, Time));
	//调用difftime函数，输出从Time到end所经过的时间
	t = localtime(&Time);//调用localtime函数将时间分解
						 //printf("local time is:%s\n", asctime(t));//调用asctime()函数，以固定格式显示时间

	gt = gmtime(&Time);//将当前时间转化为格林尼治时间
	printf("gelin time is:%s\n", asctime(gt));
	//int i = 0;
	//srand(time(0));
	//m = rand() % 5 + 2;
	//n = rand() % 5 + 2;
	//printf("%d\n", m);
	//printf("%d\n", n);
	//isprime_self(m);
	//s = sqrt(5);
	//printf("%lf\n", sqrt(4.0));
	//printf("%lf\n", sqrt(5));
	//y = modf(s, &x);
	//printf("%lf\n", x);
	//printf("%lf\n", y);
	//for (i = 0; i < 5; i++)
	//{
	//	ret = cifang(m, n + i);
	//	printf("%d\n", ret);
	//}
	system("pause");
	return 0;

}