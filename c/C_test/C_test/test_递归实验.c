#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
#include<windows.h>

int  n=0;


static int DG(int i)
{
	n+=1;
	if(i<=0)
	{
		return 0;
	}	
	else if (i>=1&&i<=2)
	{
		return 1;	
	}
	else
	{
		return (DG(i-1) + DG(i-2));
	}	
}
int main()
{
	time_t start;
	time_t end;
	int m =0;
	start=time(NULL);
	Sleep(10000);
	m = DG(40);//50µÄÊ±ºò¹ÒµôÁË
	end=time(NULL);
	printf("%d,%d,%f\n",m,n,difftime(end,start));

	//printf("hello it is me!!\n");
	system("pause");
	return 0;
}