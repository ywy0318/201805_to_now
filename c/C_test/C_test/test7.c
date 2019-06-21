/*计算阶乘后面几个零*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
static int jicheng(long m)
{
	long  re = 1;
	int i = 1, j = 1;
	int count = 0;
	if (m == 0)
	{
		//return 1;
		return 0;
	}
	else
	{
		for (i = 1; i <= m; i++)
		{
			re = j*i*re;
			if ((re % 10) == 0)
			{
				re = re / 10;
				count++;
			}

		}
		return count;
	}

}

int main()
{
	int ret;
	int m = 0;
	printf("123\n");
	printf("%d\n", jicheng(1000));
	//printf("%d\n", jicheng(16));
	//while (m != 11)
	//{

		//ret = jicheng(m);
		//printf("%d,%d\n", m, ret);
		//m++;
	//}

	system("pause");
	return 0;

}