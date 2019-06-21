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
	int c;
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



	printf("after shell \n");


	printf_vector(f, 10);
	printf("%d\n", 5 / 2);

	system("pause");
	return 0;

}
