#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>


	int a=0;
	int b=0;
	int c[11][11]={


	{1,1,1,1,1,1,1,1,1,1,1},
	{1,1,1,1,1,1,1,1,1,1,1},
	{1,1,1,1,1,1,1,1,1,1,1},

	{1,1,1,1,1,1,1,1,1,1,1},
	{1,1,1,1,1,1,1,1,1,1,1},
	{1,1,1,1,1,1,1,1,1,1,1},
	{1,1,1,1,1,1,1,1,1,1,1},

	{1,1,1,1,1,1,1,1,1,1,1},
	{1,1,1,1,1,1,1,1,1,1,1},
	{1,1,1,1,1,1,1,1,1,1,1},
	{1,1,1,1,1,1,1,1,1,1,1},


	};
	

void print()
{
	
		for (a = 0; a <= 10; a++)
	{
		if(a==0)
		{
				printf("%d :",a);
				printf(" ");
			for(b=1;b<11;b++)
			{
				
				printf(" %d ",b);
			}
				printf("\n");
		}
		else if(a<10)
		{
				printf("\n");
				printf("%d : ",a);
			for (b = 1; b <= a; b++)
			{
				//printf("%d*%d=%d  ", b, a, a*b);
				printf(" %d ",c[a][b]);

			}
				printf("\n");
		}
		else
		{
			printf("\n");
				printf("%d: ",a);
			for (b = 1; b <= a; b++)
			{
				//printf("%d*%d=%d  ", b, a, a*b);
				printf(" %d ",c[a][b]);

			}
				printf("\n");
		}
		
	}
}

void jisuan()
{
	for(a=2;a<11;a++)
	{
		for(b=2;b<a;b++)
		{
			c[a][b]=c[a-1][b]+c[a-1][b-1];
		}
	}
}

int main()
{	
	
	print();
	jisuan();
	printf("****\n");
	print();

	system("pause");
	return 0;
}