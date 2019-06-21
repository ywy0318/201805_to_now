/*ÂôÎ÷¹Ï*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>


int main()
{
	int ret;
	int m = 1020;
	int i = 0;
	printf("123\n");
	//printf("%d\n", jicheng(16));
	while (m >0)
	{
		//i++;
		m -= (m / 2 + 2);
		i += 1;
		
	}
	printf("%d\n",i);
	system("pause");
	return 0;

}