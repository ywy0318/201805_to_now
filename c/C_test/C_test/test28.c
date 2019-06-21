/*产生10个不同随机数，相邻元素求和,逆序存放,查找最大值最小值及其下标*/
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
	int temp;
	int temp1 = 20, temp2 = 11;
	int T1 = 0;
	int T2 = 0;
	int min = 0;
	int M = 0;
	int N = 0;
	double s, x, y;
	int f[30],g[20];
	/*int a[3][3];*/
	srand(time(0));
	//for (i = 0; i < 20; )
	//{
	//	ret=rand() % 20 + 1;
	//	g[i] = ret;
	//	for (m = 0; m < i; m++)
	//	{
	//		if (f[m] == ret)
	//		{
	//			//flag = 1;
	//			//continue;
	//			break;
	//		}
	//	}
	//	if (m==i) 
	//	{
	//		f[i++] = ret;
	//	}
	//
	//}
/*产生10个不同的随机数函数*/
	for (i = 0; i < 10;)
	{
		ret = rand() % 10 + 10;
		for (m = 0; m < i; m++)
		{
			if (f[m] == ret)
			{				
				break;
			}
		}
		   if (m==i)
		   {
			  f[i] = ret;
			  i += 1;
		   }
	}

	printf("min\n" );

	for (i = 0; i < 10; i++)
	{
		if (f[i] == temp1)
		{
			//printf("temp1 yes\n ");
			T1 = 1;
		}
		
		if (f[i] == temp2)
		{
			//printf("temp2 yes\n ");
			T2 = 1;
		}
		
	}
	if (T1 == 1)
	{
		//printf("temp1 yes\n ");
	}
	else
	{
		//printf("temp1 no\n ");
	}
	if (T2 == 1)
	{
		//printf("temp2 yes\n ");
	}
	else
	{
		//printf("temp2 no\n ");
	}


	for (n = 0; n < 10; n++)
	{
		printf("%d ",f[n]);
		if ((n+1) % 5 == 0)
		{
			printf("\n");
		}
	}




	printf("\n");
	for (i = 0; i < 10; i++)
	{
		if (f[i] < f[N])
		{
			N = i;//最小
		}

		if (f[i] > f[M])
		{
			M = i;//最大
		}
	}
	//printf("%d ,%d ,%d ,%d\n", M, f[M], N, f[N]);

	for (i = 0; i < 5; i++)
	{
		g[i] = f[i*2] + f[i*2 + 1];
	}
	//printf("mi\n");
	
	for (n = 0; n < 5; n++)
	{
		//printf("%d ", g[n]);
		if ((n + 1) % 3 == 0)
		{
			//printf("\n");
		}
	}


	//printf("nim\n");
	for (i = 0; i < 5; i++)
	{
		temp = f[i];
		f[i] = f[9 - i];
		f[9 - i] = temp;
	}

	for (n = 0; n < 10; n++)
	{
		//printf("%d ",f[n]);
		if ((n+1) % 5 == 0)
		{
			//printf("\n");
		}
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