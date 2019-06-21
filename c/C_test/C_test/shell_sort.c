/*产生10个不同的随机数函数*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
int main() {
	int i = 0;
	int m = 0;
	int ret;
	int f[100];
	int n = 0;
	for (i = 0; i < 20;)
	{
		ret = rand() % 50 + 1;
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

	printf("before shell_sort \n");
	for (n = 0; n < 20; n++)
	{
		printf("%d ",f[n]);

	}
	printf("\n");
	//shell_sort();
	printf("after shell_sort \n");
	for (n = 0; n < 20; n++)
	{
		printf("%d ", f[n]);

	}
	printf("\n");
	printf("%d,%d\n",sizeof(f),sizeof(int));
	i = 0;
	while (f[i] > 0)
	{
		//printf("%d ", f[i]);
		i++;
	}
	system("pause");
	return 0;

}
