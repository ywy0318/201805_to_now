/* ºï×Ó³ÔÌÒ*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main()
{
	int n = 1, m[10] = {0,0,0,0,0,0,0,0,0,1};
	int i = 10;
	
	for (i = 9; i > 0; i--)
	{
		m[i - 1] = (m[i] + 1) * 2;
	}
	while (n!=11) 
	{
		printf("%d,%d\n",n,m[n-1]);
		n++;
	}
	
	system("pause");
	return 0;
}