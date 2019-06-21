/*求最大数的函数*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>


int main()
{
	int m, n;
	int ret;
	int min;
	srand(time(0));
	m = rand();
	//srand(time(0));
	n = rand();
	printf("%d,%d\n",m,n);
	ret = m > n ? m : n;
	min = m > n ? n : m;
	printf("%d,%d\n", ret, min);
	system("pause");
	return 0;

}