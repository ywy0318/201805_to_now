/*产生10个不同的随机数函数*/
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

	}
	printf("\n");

}


int main() {
	int i = 0;
	int m = 0;
	int ret;
	int f[100] = { '0' };
	int d[10];
	int n = 0;
	int c;
	d[0] = 1024;
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

	for (i = 1; i < 10; i++)
	{
		
		d[i] = d[i-1] / 2;
	}
	printf_vector(d, 10);

	printf("after shell \n");


	printf_vector(f, 10);
	

	system("pause");
	return 0;

}
