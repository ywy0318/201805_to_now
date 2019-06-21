/*difftime(time_t time2,time_t time1)计算从time到time2的运行时间(second)*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
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
	time_t Time,end;//定义Time为time_t类型
	struct tm *t, *gt;//定义指针t为tm结构类型
	Time = time(NULL);//获取当前时间信息
	Sleep(1000);
	end = time(NULL);
	printf("run time is :%f(s)\n",difftime(end,Time));
	//调用difftime函数，输出从Time到end所经过的时间
	t = localtime(&Time);//调用localtime函数将时间分解
	printf("local time is:%s\n", asctime(t));//调用asctime()函数，以固定格式显示时间

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