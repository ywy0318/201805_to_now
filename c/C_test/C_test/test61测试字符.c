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
		printf("%d %c;", data[i],data[i]);
		printf("  ");
		if (i%10==9) 
		{
			printf("\n");
		}
		
	}
}



int main()
{	
	int i=0;
	int data[100]={'0'};
	for(i=0;i<100;i++)
	{
		data[i]=i;
	}
	
	printf_vector(data,100);
	printf("\n");
	printf("\n");
	printf("%d %c;", 11,11);
	printf("%d %c;", 12,12);
	printf("%d %c;", 13,13);
	printf("\n");
	printf("\n");
	printf("%d %c;", 0,0);
	printf("%d %c;", 8,8);
	printf("%d %c;", 9,9);

	printf("\n");
	system("pause");
	return 0;
}