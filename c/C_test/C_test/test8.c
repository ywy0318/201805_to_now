/*产生随机数*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
static int jicheng(long m)
{
	long long re = 1;
	int i = 1, j = 1;
	if (m == 0)
	{
		return 1;
	}
	else
	{
		for (i = 1; i <= m; i++)
		{
			re = j*i*re;
		}
		return re;
	}

}
int main()
{
	int ret;
	int m = 0;
	int n = 0;
	printf("123\n");
	
	srand(time(0));//放在循环里面产生的随机数都一样
	for (m = 0; m < 20; m++)
	{
		//srand(time(0));
		n = rand()%100+1;
	   printf("%d ",n);
	}
	system("pause");
	return 0;

}