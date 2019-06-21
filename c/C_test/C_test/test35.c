/*产生10个不同的随机数函数*/
/*最大公约数最小公倍数*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>

void printf_vector(int data[], int n)
{
	int i = 0;
	for (i = 0; i < n; i++)
	{
		printf("%d ", data[i]);
		if (i % 10 == 9)
		{
			printf("\n");
		}
	}
}


int main() {
	int i = 0;
	int m = 0;
	int ret;
	int f[100] = { '0' };
	int n = 0;
	int c=65;
	int d = 15;
	int a ,b;
	int max = 0;
	int min = 0;
	for (i = 0; i < 30;)
	{
		ret = rand() % 30 + 1;
		for (m = 0; m < i; m++)
		{
			if (f[m] == ret)
			{
				break;
			}
		}
		if (m == i)
		{
			f[i] = ret;
			i += 1;
		}
	}
	max = (c > d)? c : d;
	min = (c < d) ? c : d;
	printf("%d %d\n", max, min);
	for (i = min; i >1; i--)
	{
		if ((c%i == 0) && (d%i) == 0)
		{
			printf("zuidagongyue %d  \n",i);
			break;
		}
	}
	for (i = max;; i++)
	{
		if ((i%c == 0) && (i%d == 0))
		{
			printf("zuixiao %d \n",i);
			break;
		}
	}
	printf("after   shell \n");
	for (i = 1000; i < 10000; i++)
	{
		a = i / 100;
		b = i % 100;
		if ((a + b)*(a + b) == i)
		{
			
			printf("%d  ",i);
		}
	}



	printf("\n");
	printf("after shell \n");



	printf("after shell \n");

	printf_vector(f, 20);
	//printf("%d\n", 5 / 2);

	system("pause");
	return 0;

}
