#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>


void printf_vector(int data[], int n)
{
	int i = 0;
	for (i = 0; i < n; i++)
	{
		printf("%d ", data[i]);
		
		if (i%10==9) 
		{
			//printf("\n");
		}
	}
}
void shell_sort()
{
	int k=10/2;//每次的增量;相当于分几组
	int i=0;
	int temp=0;
	for(i=0;;i++)
	{
		
	}

}
void quick_sort()//递归与非递归
{

}
void merge_sort()
{

}
int main()
{	
	

	system("pause");
	return 0;
}