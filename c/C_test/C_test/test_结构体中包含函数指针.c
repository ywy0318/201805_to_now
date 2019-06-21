/**/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>




typedef  int(*handler)(int num);
typedef	struct 
{
	int shu1;
	int shu2;
	char cmd;
	handler fun;
}jsq;
int fun1()
int main()
{
	jsq s[] = 
	{
		{3,6,s,fun1},
		{9,5,p,fun2},
		{8,4,c,fun3},
		{15,6,j,fun4}
	};











	system("pause");
	return 0;
}