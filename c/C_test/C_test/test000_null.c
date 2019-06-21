#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>



#define	TMS_HALF_AUTO_INIT			0
#define	TMS_HALF_AUTO_PRI			1
#define	TMS_HALF_AUTO_ARR			2
#define	TMS_HALF_AUTO_OPENDOOR		3

#define	TMS_HALF_AUTO_CLOSEDOOR		4
#define	TMS_HALF_AUTO_OVER			5
#define	TMS_HALF_AUTO_START			6


int dd[50]={0};
int i=0;
int ddd=0;
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

int search(int num)
{
	int is=0;
	for(is=0;is<50;is++)
	{
		//printf("%d\n",dd[is]);
		if(dd[is]==num)
		{
			return is;
		}
		//只遍历了第一个
		//else
		//{
		//	return 99;
		//	//printf("no\n");
		//}
	}
	printf("no\n");

}
//居然是12个字节 有点问题
typedef struct
{
	int a;
	int b;
	//unsigned char a;
	//unsigned char b;
	int c;
	int d;
}signal1;

void pri(signal1 *dat)
{
	/*dat->a=0x01;
	dat->b=0x02;
	dat->c=0x04;
	dat->d=0x08;*/

	printf("a:0x%x\n",dat->a);
	printf("b:0x%x\n",dat->b);
	printf("c:0x%x\n",dat->c);
	printf("d:0x%x\n",dat->d);

	//printf("\n");
}
int main()
{	
	//char *des_station_code[15] = {0};

	//des_station_code[0] = "AA";
	//des_station_code[1] = "AB";
	//des_station_code[2] = "BA";
	//des_station_code[3] ="BB";
	//des_station_code[4] = "BC";
	//des_station_code[5] = "BD";
	//des_station_code[6] = "BE";
	//des_station_code[7] = "SA";
	//des_station_code[8] ="CA";
	//des_station_code[9] = "CB";
	//des_station_code[10] ="CC";
	//des_station_code[11] = "CD";
	//des_station_code[12] = "CE";
	//des_station_code[13] ="SC";
	//des_station_code[14] = "SD";
	
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
	int iff=0;
	int j=0;
	int d=0;
	int a=0;
	int c=16;
	double dd=15.6;
	int i=0;
	int data[20]={'0'};
	//char *st="BB";
	/*int s='SD';
	c=s&0x0f;*/
	//data[0]=0x11;
	//for(i=0;i<16;i++)
	//{
	//	//data[i]=0x00;
	//	data[i]=0x01+i;
	//	printf("0x%x\n",data[i]);
	//}
	//
	////data[1]=0x11;
	////printf("%x\n",signal1*data);
	//printf("\n");

	//pri((signal1*)data);

	//printf("sizeof:%d\n",sizeof(signal1));

	if(c>dd)
	{
		//printf("111\n");
	}
	else
	{
		//printf("sss\n");
	}
	//for(i=0;i<900;i++)
	//{
	//	printf("钱");
	//	if((i>0)&&(i%90==0))
	//	{
	//		//printf("\n");
	//	}
	//	
	//}

	//printf("\n");
	

	//for(i=0;i<129;i++)
	//{
	//	printf("%d  ",i+127);
	//	if(i%8==7)
	//	{
	//		printf("\n");
	//	}
	//}
	//printf("%d,%d\n",s,c);
	//for(i=0;i<15;i++)
	//{
	//	/*if(des_station_code[i]==*st)
	//	if(i<=1)
	//	{
	//		
	//	}*/
	//}
	//printf("%d\n",d);
	//for(iff=0;iff<50;iff++)
	//{
	//	dd[iff]=iff+30;
	//}
	//printf("122\n");
	//printf("%d\n",dd[3]);
	//ddd=search(35);
	//c=search(100);
	//printf("%d,%d\n",ddd,c);
	////printf("%d\n",dd[45]);
	//while(1)
	//{
	//switch(d)
	//{
	//	case TMS_HALF_AUTO_INIT:
	//		d=1;
	//		a+=5;
	//		if((a>10)&&(c<-5))
	//		{
	//			printf("%d\n",a);
	//			a=0;
	//			
	//		}
	//		else
	//		{
	//			a++;
	//			c--;
	//		}
	//		break;
	//	case TMS_HALF_AUTO_PRI:
	//		printf("b=1;%d,%d\n",a,c);
	//		d=3;
	//		break;
	//	case TMS_HALF_AUTO_ARR:
	//		d=0;
	//		break;
	//	case TMS_HALF_AUTO_OPENDOOR:
	//		d=2;
	//		c=c-3;
	//		a=a+1;
	//		break;
	//	default:
	//		break;
	//}
	//}
	//printf("124\n");
	//while(1)
	//{
	//	if(i>10)
	//	{
	//		printf("%d\n",i);
	//		break;
	//	}
	//	i++;
	//}
	//srand(time(0));
	//for(i=0;i<=20;i++)
	//{
	//	
	//	printf("%d\n",rand() % 20);
	//}
	//
	////
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
	//struct data *a;
	//struct time *d;
	//getdate(&a);



	/*system("color f8");
	printf("112222\n");
	system("color fc"); 
	printf("%c\n",3);*/
	//while(1);
	system("pause");
	return 0;
}