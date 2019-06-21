/*µÆËþµÆÊý*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>


int f(int n)
{
	//int sum=0;
	int i = 1;
	int j = 1;
	if (n == 0)
	{
		return 1;
	}
	else
	{
		for (i = 1; i < n; i++)
		{
			j = j * 2;
		}
		return j;
	}

}

int main()
{
	int ret;
	int n;
	int sum=0,k;
	int m = 756;
	int l = 0;
	printf("123\n");
	//printf("%d\n", jicheng(16));
	//ret = f(8);
	for (l = 1; l <=8; l++)
	{
		sum += f(l);
		printf("%d,%d\n",f(l),sum);
		

	}
	//sum += 1;
	
	n = 765/sum;
	printf("%d\n", n);
	system("pause");
	return 0;

}