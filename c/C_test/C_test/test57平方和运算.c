#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>


int i=0;
void test(int c)
{
	switch(c)
		{
		case 0:
			{
				printf("%d ,%d\n",c,i);
				return;
			}
		case 1:
			{
				printf("%d ,%d\n",c,i);
				break;
			}
		case 2:
			{
				printf("%d ,%d\n",c,i);
				break;
			}
		case 3:
			{
				printf("%d ,%d\n",c,i);
				break;
			}
		}
}
void setColor(unsigned short ForeColor,unsigned short BackGroundColor)
{
HANDLE handle=GetStdHandle(STD_OUTPUT_HANDLE);//获取当前窗口句柄
SetConsoleTextAttribute(handle,ForeColor+BackGroundColor*0x10);//设置颜色
}
//设置光标位置
void SetPos(int x,int y)
{
    COORD pos;
HANDLE handle;
    pos.X=x;
    pos.Y=y;
    handle=GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(handle,pos);
}


int d[10]={'0'};
long long num=1234567809;
void jisuan()
{
	int i=0;
	int j=0;
	long long temp=0;
	for(i=0;i<10;i++)
	{
		temp=(long long)pow(10.00,i);
		d[i]=num/temp%10;
		if(d[i]==0)
		{
			continue;
		}
		printf("%d %d\n",d[i],temp);
	}
}
void jisuan2()
{
	
	int ki=0;
	double te=0;
	double tem=0;
	printf("\n");
	for(ki=0;ki<10;ki++)
	{
		if(d[ki]==0)
		{
			continue;
		}
		te=d[ki]*1.00;		
		tem+=pow(te,2);
		printf("%d %d %lf %d\n",ki,d[ki],te,tem);
	}
	num=(long long) tem;
}

int main()
{	
	time_t tmd;
	struct tm *t,*dt;
	
	 
	// int d=0;
	// int e=0;
	//while(1)
	//{	
	//	//for(;i<19;)
	//	//{
	//	//	++i;
	//	//	if(i==9)
	//	//	{
	//	//		printf("%d\n",i);
	//	//		Sleep(10);
	//	//		break;
	//	//	//exit(0);
	//	//	}
	//	//}
	//	//i+=1;
	//	i=4;

	//	d=i%4;
	//	e=1;
	//	//test(d);
	//	test(e);
	//	//printf("%d\n",i);
	//	printf("112222\n");
	//	Sleep(2000);
	//}
	//int ret=0;
	//int i=0;
	//int j=0;
	////srand(time(0));
	////for(i=0;i<=20;i++)
	////{
	////	
	////	printf("%d\n",rand() % 20);
	////}
	////
	//////
	//SetPos(0,0);
	//system("color f0");
	//for(i=0;i<15;i++)
	//{
	//	for(j=0;j<15;j++)
	//	{
	//		
	//			setColor(15,9);
	//			if(i==10)
	//			{
	//			setColor(15,12);
	//			}
	//			printf("+");
	//		
	//	}
	//	printf("\n");
	//	//printf("\n");
	//	printf("\n");
	//}
	
	int di=0;
	tmd=time(NULL);
	t=localtime(&tmd);
	tmd=time(NULL);
	dt=gmtime(&tmd);

	while(1)
	{
		printf("\n");
		if((num!=1)&&(num!=145))
		{
			jisuan();
			jisuan2();
		}
		else
		{
			printf("%d %d\n",num,di);
			break;
		}
		di++;
		printf("\n");
		printf("%d\n",num);
		printf("\n");
	}
	printf("localtime is %s\n",asctime(t));
	printf("gmtime is %s\n",asctime(dt));
	//gettime();

	/*system("color f8");
	printf("112222\n");
	system("color fc"); 
	printf("%c\n",3);*/
	system("pause");
	return 0;
}