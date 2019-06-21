/*1块换零钱*/
/*特殊等式穷举法*/
/*乘法口诀表*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>

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
	int a,b,c;
	for (i = 0; i < 10;)
	{
		ret = rand() % 10 + 1;
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
	for (a = 0; a <= 10; a++)
	{
		for (b = 0; b <= 5; b++)
		{
			for (c = 0; c <= 2; c++)
			{
				if ((a + b * 2 + c * 5) == 10)
				{
					//printf("%d %d %d\n",a,b,c);
					n += 1;
				}
			}
		}
	}


	for (a = 0; a <= 9; a++)
	{
		for (b = 0; b <= 9; b++)
		{
			for (c = 0; c <= 9; c++)
			{
				if ((a*100 + b * 110 + c * 12) == 532)
				{
					//printf("%d %d %d\n", a, b, c);
					//n += 1;
				}
			}
		}
	}
	for (a = 1; a <= 9; a++)
	{
		for (b = 1; b <= a; b++)
		{
			printf("%d*%d=%d ", b, a, a*b);

		}
		printf("\n");
	}
	//printf("%d\n",n);
	//printf("after shell \n");

	for (c = 1; c <= 6; c++)
	{

	}
	//printf_vector(f, 10);
	//printf("%d\n", 5 / 2);

	system("pause");
	return 0;

}
