/*产生10个不同的随机数函数*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>

#define NUM 5
struct order
{
	int num;
	int con;

}a[20];



int main() {
	int i = 0;
	int m = 0;
	int ret;
	int f[10];
	int n = 0;
	srand(time(0));
	for (i = 0; i < NUM;)
	{
		ret = rand() % 100 + 1;
		for (m = 0; m < i; m++)
		{
			if (a[m].num == ret)
			{
				break;
			}
		}
		if (m == i)
		{
			a[i].con = 0;
			a[i].num = ret;
			i += 1;
		}
	}
	printf("size of is strcut order:%d\n",sizeof(struct order));
	printf("size of is a[20]:%d\n", sizeof(a));

	for (i = 0; i < NUM; i++)
	{
		for (m = i+1; m < NUM; m++)
		{
			if (a[i].num>a[m].num)
			{
				a[i].con++;
			}
			else
			{
				a[m].con++;
			}
		}
		
	}
	//printf("%d\");























	printf("min\n");
	for (n = 0; n < NUM; n++)
	{
		//printf("%d  ,%d \n",a[n].num ,a[n].con);
		printf("addr:%d ,%d ,%p ,%p\n", a[n].num, a[n].con, &a[n].num, &a[n].con);
	}
	printf("%p \n",a);

	for (i = 5; i >=0; i--)
	{
		for (m = 0; m < 5; m++)
		{
			if (a[m].con == i)
			{
				printf("%d\n", a[m].num);
			}
		}
	}


	system("pause");
	return 0;

}
