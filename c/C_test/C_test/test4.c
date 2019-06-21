/* ÂòÆ»¹ûÎÊÌâ£¬i++/++i*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main()
{
	int n = 0;
	int i = 0;
	int m[20] ;
	int sum = 0;
	double ave, price;
	m[0] = 2;
	printf("123\n");
	while (m[n] <= 100)
	{
		
		m[n + 1] = m[n] * 2;
        //printf("%d,%d\n",n,m[n]);
		n += 1;
		
	}
	for (i = 0; i < n; i++)
	{
		sum += m[i];
		printf("%d,%d\n",i+1,m[i]);
	}
	price = sum*0.8;
	ave = price / n;
	printf("%lf",ave);
	system("pause");
	return 0;
}