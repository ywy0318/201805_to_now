//注意数组名就是首地址，所以不用取地址了；
/* int *M=(int)malloc(sizeof(int));      */
/*  int *N = (int)malloc(sizeof(int));   */	
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>

struct student
{
	int number;
	char name[20];
	char sex;
	int age;
	float score;
};

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
//产生n个不同的随机数，随机数范围从1-num;保存在d[]中;
void generate_random_vector(int d[], int n, int num)
{
	int i = 0;
	int ret;
	int m = 0;
	if (num < n)
	{
		printf("CAN not generate %d numbers\n", num);
		return -1;
	}
	srand(time(0));
	for (i = 0; i < n;)
	{
		ret = rand() % num + 1;
		for (m = 0; m < i; m++)
		{
			if (d[m] == ret)
			{
				break;
			}
		}
		if (m == i)
		{
			d[i] = ret;
			i += 1;
		}
	}
}


static void M_N(int a[],int n,int *max,int *min)
{
	int i = 0;
	int *p;
	*min = a[0];
	*max = a[0];
	//printf("%d %d %d\n",*max,*min,a[]);
	p = a + 1;//注意数组名就是首地址，所以不用取地址了；
	//printf("%p %p %p %p %p\n", max, min, &a,p, (a + 10));
	
	for (p = a + 1; p < a + n; p++)
	{
		if ((*max) < (*p))
		{
			(*max) = (*p);
		}
		else if (*min > *p)
		{
			*min = *p;
		}
	}
	printf("%d %d\n",*max,*min);

	for (i=1; i<n; i++)
	{
		if ((*max)< *(a+i))
		{
			(*max)=*(a+i);
		}
		else if(*(a+i)<*min)
		{
			*min = *(a+i);
		}
	}
	//printf("%d %d\n",*max,*min);
}

int main()
{

	int f[100] = { 0 };
	int a[10] = { 0 };
	int *pd;
	int *M=(int)malloc(sizeof(int));
	int *N = (int)malloc(sizeof(int));
	//int M = 0;
	//int N = 0;
	struct student stu = {70720,"hanleilei",'b',20,89.00};
	struct student *p;
	p = &stu;
	/*printf("->%d .%d\n",p->number,stu.number);
	printf("->%d .%d\n", p->age, stu.age);
	printf("->%s .%s\n", p->name, stu.name);
	printf("->%c .%c\n", p->sex, stu.sex);
	printf("->%f .%f\n", p->score, stu.score);*/

	generate_random_vector(a, 10, 30);
	
	printf_vector(a, 10);

	pd = &a;
	//小心pd<(a+10)这里
	for (pd = &a; pd < (a + 10); pd++)
	{
		printf("%d ",*pd);
	}
	printf("\n");

	M_N(a,10, M, N);
	printf("main:%d  %d \n",*M,*N);








	system("pause");
	return 0;
}