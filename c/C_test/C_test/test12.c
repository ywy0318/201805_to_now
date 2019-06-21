/*µÆËþµÆÊý*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>


int main()
{
	int n = 1, m, sum, i;
	printf("123\n");
	//printf("%d\n", jicheng(16));
	while (1)
	{
		m = n;
	    sum = 0;
		for (i = 1; i < 8; i++)
		{
			m = m * 2;
			sum += m;
		}
		sum += n;
		if (sum == 765)
		{
			printf("%d\n",n);
			printf("%d\n",m);
			break;
		}
		n++;


	}
	//printf("%d\n", m);
	system("pause");
	return 0;

}