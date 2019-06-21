/*函数指针有问题*/

#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>

min(int a, int b){
	if (a > b)
		return b;
	else
		return a;
}
int main()
{
	int(*pmin)();
	int a = 5, b = 3, m = 0;
	pmin = min;
	m = (*pmin)(a, b);
	printf("%d\n",m);

	system("pause");
	return 0;
}