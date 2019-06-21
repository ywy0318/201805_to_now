#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>
void fun1(int a)
{
	if (a > 5)
	{
		printf("%d >5\n",a);
	}
	else
	{
		return 0;
	}
}
int main()
{

	int min = 0;
	int max = 10;
	fun1(min);
	printf("\n---\n");

	fun1(max);
	printf("\n-----\n");
	//exit(0);




	system("pause");
	return 0;
}