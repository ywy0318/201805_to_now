/*计算100-200之间的素数*/
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
	int m = 0, n = 0, i = 0;
	int ret;
	int min = 0;
	double s, x, y;
	int f[50], g[20];
	int flag = 0;
	int a ,b,c;
	/*int a[3][3];*/
	srand(time(0));
	for (i = 0; i < 50; i++)
	{
		f[i] = rand() % 3 + 1;
	}

	c = 1;
	for (a = 100; a <= 200; a++)
	{
		for (b = 2; b <= a / 2;b++ )
		{
			if ((a%b) == 0)
			{
				flag = 0;
				break;
			}
			flag = 1;
		}
		if (flag == 1)
		{
			    printf("%d ", a);
				if ((c % 5) == 0)
				{
					printf("\n");
				}
				c++;
			
		}
	}
	//printf("%d ,%d ,%d \n", a, b, c);



	//printf("min\n");
	for (n = 0; n < 10; n++)
	{
		//printf("%d,%d\n", n, f[n]);

	}
	//printf("miin\n");
	for (n = 0; n < 20; n++)
	{
		//printf("%d,%d\n", n, g[n]);

	}

	/*for (m = 0; m <= 2; m++)
	{
	for (n = 0; n < 3; n++)
	{
	a[m][n] = rand() % 9 + 1;
	printf("a[%d][%d]is %d\n", m, n, a[m][n]);
	}
	}
	for (m = 0; m <= 2; m++)
	{
	for (n = 0; n < 3; n++)
	{
	min += a[m][n];
	}
	}*/


	//printf("%d\n", min);

	//time_t Time, end;//定义Time为time_t类型
	//struct tm *t, *gt;//定义指针t为tm结构类型
	//Time = time(NULL);//获取当前时间信息
	//time(&Time);
	//printf("\n time is :%s\n",ctime(&Time));//把时间和日期转化为字符串
	//Sleep(1000);
	//end = time(NULL);


	//min = biosmemory();
	//printf("\n:%d KB\n",min);
	//printf("run time is :%f(s)\n", difftime(end, Time));
	//调用difftime函数，输出从Time到end所经过的时间

	//int i = 0;
	//
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