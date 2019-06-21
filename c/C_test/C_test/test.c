/*¼ÆËã²¢´òÓ¡½×³Ë*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
static int jicheng(long m)
{
	long long re=1;
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
	int m=0;
	printf("123\n");
	printf("%d\n",jicheng(16));
	while (m != 11) 
	{

	  ret = jicheng(m);
	  printf("%d,%d\n",m,ret);
	  m++;
	}
	
	system("pause");
	return 0;
  
}