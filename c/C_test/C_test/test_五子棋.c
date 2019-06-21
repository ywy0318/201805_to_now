/*
	写人机下棋的时候，由于人机下棋只有放置的棋子不同
	可是自己还要复制大部分代码，我就想到了是不是可以用
	C++写，对象不同，输出结果不同，中间过程类似，
	C++中好像有实现这个过程的方法，
	多态？？？还是封装成类的成员以及对象


*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>

char chess[15][15] = {'\0'};
int win_location[5][2]={0};
int flag = 0;
int checkisempty(int x,int y);
void printwin();
void usrplace();
void cpuplace();

void winjudge(int a,int b, char c);
void hengjudge(int a,int b, char c);
void shujudge(int a,int b, char c);
void duijiaojudge(int a,int b, char c);
void fanduijiaojudge(int a,int b, char c);

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

int empty=0;
	//flag=1;
int m = 0;//usrplace 纵坐标在前
int n = 0;

int x = 0;//cpuplace 纵坐标在前
int y = 0;
//横竖有问题
void hengjudge(int a, int b, char c)//(横坐标，纵坐标,棋子)[0,14]
{
	/*int k = 0;
	int p = 0;
	int time=0;*/
	int ki=0;
	//int count = 0;
	//int fdi=0;
	for(ki=0;ki<5;ki++)
	{	
		//printf("%d\n",ki);
		if((((a-ki)>=0)&&(b>=0))&&(((a+4-ki)<15)&&(b<15)))
		{
				/*if((chess[a-ki][b+ki]==c)&&
				(chess[a-ki+1][b+ki-1]==c)&&
				(chess[a][b]==c)&&
				(chess[3+a-ki][ki-4+b+1]==c)&&
				(chess[4+a-ki][-4+ki+b]==c))*/

			if((chess[a-ki][b]==c)&&
				(chess[a-ki+1][b]==c)&&
				(chess[a-ki+2][b]==c)&&
				(chess[3+a-ki][b]==c)&&
				(chess[4+a-ki][b]==c))

				
				{
					printf("you heng win!!:%d\n",ki);

					win_location[0][0]=a-ki;
					win_location[1][0]=a-ki+1;
					win_location[2][0]=a-ki+2;
					win_location[3][0]=a-ki+3;
					win_location[4][0]=a-ki+4;
					/***/
					win_location[0][1]=b;
					win_location[1][1]=b;
					win_location[2][1]=b;
					win_location[3][1]=b;
					win_location[4][1]=b;

					flag=1;
					printf("you heng win!!:\n");
					break;
				}
			//printf("%c %c %c",chess[a-ki][b],chess[a-ki+1][b],chess[a-ki+2][b]);
			//printf("%c %c %c\n",chess[a-ki+3][b],chess[a-ki+4][b]);
		}	
	}
	//for (k = 0; k < 15; k++)
	//{
	//	if (chess[k][b] == c)
	//	{
	//		count++;
	//	}
	//}
	////统计落子的那一行的刚落下的棋子的个数，
	//小于5返回
	//if (count < 5)
	//{
	//	return ;//if(chess[i][b] == c)||()
	//}
	//else 
	//{
	//	/*for (k = b; k < b + 5; k++)
	//	{
	//		for (p = 0; p < 5; p++)
	//		{
	//			(k-p)
	//		}
	//	}*/

	//	if(a<4)
	//	{
	//		for(time=0;time<(a-0+1);time++)
	//		{
	//			/*for(ki=0;ki<5;ki++)
	//			{
	//				chess[time+ki][b]==c;
	//			}*/
	//			if((chess[time+0][b]==c)&&
	//				(chess[time+1][b]==c)&&
	//				(chess[time+2][b]==c)&&
	//				(chess[time+3][b]==c)&&
	//				(chess[time+4][b]==c))					
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}			
	//	}
	//	else if(a>10)
	//	{
	//		for(time=14;time>(a-1);time--)
	//		{
	//			/*for(ki=0;ki<5;ki++)
	//			{
	//				chess[time+ki][b]==c;
	//			}*/
	//			if((chess[time-0][b]==c)&&
	//				(chess[time-1][b]==c)&&
	//				(chess[time-2][b]==c)&&
	//				(chess[time-3][b]==c)&&
	//				(chess[time-4][b]==c))					
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}
	//	}
	//	else
	//	{
	//		for(time=0;time<5;time++)
	//		{
	//			if((chess[time-0+a][b]==c)&&
	//				(chess[time-1+a][b]==c)&&
	//				(chess[time-2+a][b]==c)&&
	//				(chess[time-3+a][b]==c)&&
	//				(chess[time-4+a][b]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}
	//	}
	//}
}
void shujudge(int a,int b, char c)
{
	int si=0;
	for(si=0;si<5;si++)
	{	
		if((((a)>=0)&&((b-si)>=0))&&(((a)<15)&&((b+4-si)<15)))
		//if((((a-si)>=0)&&(b>=0))&&(((a+4-si)<15)&&(b<15)))
		{
				/*if((chess[a-ki][b+ki]==c)&&
				(chess[a-ki+1][b+ki-1]==c)&&
				(chess[a][b]==c)&&
				(chess[3+a-ki][ki-4+b+1]==c)&&
				(chess[4+a-ki][-4+ki+b]==c))*/

			if((chess[a][b-si]==c)&&
				(chess[a][b-si+1]==c)&&
				(chess[a][b-si+2]==c)&&
				(chess[a][b-si+3]==c)&&
				(chess[a][b-si+4]==c))

			/*	if((chess[a-si][b]==c)&&
				(chess[a-si+1][b]==c)&&
				(chess[a-si+2][b]==c)&&
				(chess[3+a-si][b]==c)&&
				(chess[4+a-si][b]==c))*/
				
				{
					printf("you shu win!!:%d\n",si);

					win_location[0][0]=a;
					win_location[1][0]=a;
					win_location[2][0]=a;
					win_location[3][0]=a;
					win_location[4][0]=a;
					/***/
					win_location[0][1]=b-si;
					win_location[1][1]=b-si+1;
					win_location[2][1]=b-si+2;
					win_location[3][1]=b-si+3;
					win_location[4][1]=b-si+4;

					flag=1;
					printf("you shu win!!:\n");
					break;
				}
		}	
	}
	//if(b<4)
	//	{
	//		for(si=0;si<(b-0+1);si++)
	//		{
	//			/*for(ki=0;ki<5;ki++)
	//			{
	//				chess[time+ki][b]==c;
	//				chess[a][si+0]
	//			}*/
	//			if((chess[a][si+0]==c)&&
	//				(chess[a][si+1]==c)&&
	//				(chess[a][si+2]==c)&&
	//				(chess[a][si+3]==c)&&
	//				(chess[a][si+4]==c))					
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}			
	//	}
	//	else if(b>10)
	//	{
	//		for(si=14;si>(a-1);si--)
	//		{
	//			/*for(ki=0;ki<5;ki++)
	//			{
	//				chess[time+ki][b]==c;
	//				chess[a][si-0]
	//			}*/
	//			if((chess[a][si-0]==c)&&
	//				(chess[a][si-1]==c)&&
	//				(chess[a][si-2]==c)&&
	//				(chess[a][si-3]==c)&&
	//				(chess[a][si-4]==c))					
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}
	//	}
	//	else
	//	{
	//		for(si=0;si<5;si++)
	//		{
	//			//chess[a][si-0+b]
	//			if((chess[a][si-0+b]==c)&&
	//				(chess[a][si-1+b]==c)&&
	//				(chess[a][si-2+b]==c)&&
	//				(chess[a][si-3+b]==c)&&
	//				(chess[a][si-4+b]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}
	//	}
}

void duijiaojudge(int a,int b, char c)
{
	/*if(((a<4)&&(b>10))||((a>10)&&(b<4)))
	{
		return;
	}
	else if(((a>=7)&&(a<=10))||(()&&()))
	{
		
	}*/
	int di=0;
	//int ba=0;
	//int ab=0;
	//int dc=b-a;
	
	for(di=0;di<5;di++)
	{		
		if(
			((a-di)>=0)&&((b-di)>=0)
			&&
			((a+4-di)<15)&&((b-di+4)<15)
			)
		{
				if((chess[a-di][b-di]==c)&&
				(chess[a-di+1][b-di+1]==c)&&
				(chess[a-di+2][b-di+2]==c)&&
				(chess[3+a-di][3-di+b]==c)&&
				(chess[4+a-di][4-di+b]==c))
			{
				printf("you duijiao win!!:%d\n",di);
				flag=1;
					win_location[0][0]=a-di;
					win_location[1][0]=a-di+1;
					win_location[2][0]=a-di+2;
					win_location[3][0]=a-di+3;
					win_location[4][0]=a-di+4;
					/***/
					win_location[0][1]=b-di;
					win_location[1][1]=b-di+1;
					win_location[2][1]=b-di+2;
					win_location[3][1]=b-di+3;
					win_location[4][1]=b-di+4;
					printf("you duijiao win!!:\n");
					break;
			}
		}	
	}



	//if((a<4)&&(b>10)&&(b>=(a+11)))
	//{
	//	return;
	//}
	//else if((a>10)&&(b<4)&&(b<=(a-11)))
	//{
	//	return;
	//}
	//else if((b<(a+11))&&(b>=(a+7)))
	//{
	//	//1~4次可能
	//	/*for(di=0;di<(10-b+1);di++)
	//	{
			//if((chess[0+di][0+di+b]==c)&&
			//	(chess[1+di][1+di+b]==c)&&
			//	(chess[2+di][2+di+b]==c)&&
			//	(chess[3+di][3+di+b]==c)&&
			//	(chess[4+di][4+di+b]==c))
			//{
			//	printf("you win!!");
			//		break;
			//}
	//	}*/
	//	/*for(di=0;di<(11-(b-a));di++)
	//	{
	//		
	//	}*/
	//	ba=b-a-10+1;
	//	switch(ba)
	//	{
	//	case 1:
	//		{
	//		   if((chess[0][10]==c)&&(chess[1][11]==c)&&(chess[2][12]==c)&&(chess[3][13]==c)&&(chess[4][14]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}
	//			
	//	case 2:
	//		{
	//			if((chess[0][9]==c)&&(chess[1][10]==c)&&(chess[2][11]==c)&&(chess[3][12]==c)&&(chess[4][13]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[1][10]==c)&&(chess[2][11]==c)&&(chess[3][12]==c)&&(chess[4][13]==c)&&(chess[5][14]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}

	//		}
	//	case 3:
	//		{
	//			if((chess[0][8]==c)&&(chess[1][9]==c)&&(chess[2][10]==c)&&(chess[3][11]==c)&&(chess[4][12]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[1][9]==c)&&(chess[2][10]==c)&&(chess[3][11]==c)&&(chess[4][12]==c)&&(chess[5][13]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[6][14]==c)&&(chess[2][10]==c)&&(chess[3][11]==c)&&(chess[4][12]==c)&&(chess[5][13]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		
	//		}
	//	case 4:
	//		{
	//			if((chess[0][7]==c)&&(chess[1][8]==c)&&(chess[2][9]==c)&&(chess[3][10]==c)&&(chess[4][11]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[5][12]==c)&&(chess[1][8]==c)&&(chess[2][9]==c)&&(chess[3][10]==c)&&(chess[4][11]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[5][12]==c)&&(chess[6][13]==c)&&(chess[2][9]==c)&&(chess[3][10]==c)&&(chess[4][11]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[5][12]==c)&&(chess[6][13]==c)&&(chess[7][14]==c)&&(chess[3][10]==c)&&(chess[4][11]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}		
	//	}
	//	

	//}
	//else if((b>(a-11))&&(b<=(a-7)))
	//{
	//	//1~4次可能
	///*	for(di=0;di<(10-a+1);di++)
	//	{
	//		if((chess[0+di][0+di+b]==c)&&
	//			(chess[1+di][1+di+b]==c)&&
	//			(chess[2+di][2+di+b]==c)&&
	//			(chess[3+di][3+di+b]==c)&&
	//			(chess[4+di][4+di+b]==c))
	//		{
	//			printf("you win!!");
	//				break;
	//		}
	//	}*/

	//	ab=a-b-10+1;
	//	switch(ab)
	//	{
	//	case 1:
	//		{
	//		   if((chess[10][0]==c)&&(chess[11][1]==c)&&(chess[12][2]==c)&&(chess[13][3]==c)&&(chess[14][4]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}
	//			
	//	case 2:
	//		{
	//			if((chess[9][0]==c)&&(chess[10][1]==c)&&(chess[11][2]==c)&&(chess[12][3]==c)&&(chess[13][4]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[10][1]==c)&&(chess[11][2]==c)&&(chess[12][3]==c)&&(chess[13][4]==c)&&(chess[14][5]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}

	//		}
	//	case 3:
	//		{
	//			if((chess[8][0]==c)&&(chess[9][1]==c)&&(chess[10][2]==c)&&(chess[11][3]==c)&&(chess[12][4]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[9][1]==c)&&(chess[10][2]==c)&&(chess[11][3]==c)&&(chess[12][4]==c)&&(chess[13][5]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[14][6]==c)&&(chess[10][2]==c)&&(chess[11][3]==c)&&(chess[12][4]==c)&&(chess[13][5]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		
	//		}
	//	case 4:
	//		{
	//			if((chess[7][0]==c)&&(chess[8][1]==c)&&(chess[9][2]==c)&&(chess[10][3]==c)&&(chess[11][4]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[12][5]==c)&&(chess[8][1]==c)&&(chess[9][2]==c)&&(chess[10][3]==c)&&(chess[11][4]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[12][5]==c)&&(chess[13][6]==c)&&(chess[9][2]==c)&&(chess[10][3]==c)&&(chess[11][4]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//			if((chess[12][5]==c)&&(chess[13][6]==c)&&(chess[14][7]==c)&&(chess[10][3]==c)&&(chess[11][4]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}
	//		}		
	//	}
	//}
	//else
	//{
	//	//5次可能
	//	for(di=0;di<5;di++)
	//	{
	//		/*if((chess[a+0+di][b+0+di]==c)&&(chess[a][b]==c)&&(chess[a][b]==c)&&(chess[a][b]==c)&&(chess[a][b]==c))
	//			{
	//				printf("you win!!");
	//				flag=1;
	//				break;
	//			}*/
	//		if((a-5>0)&&(b-5>0))
	//		{
	//			if
	//		}else 
	//		{
	//			
	//			}
	//	}


	//}
}
void fanduijiaojudge(int a,int b, char c)
{
	int fdi=0;
	for(fdi=0;fdi<5;fdi++)
	{		
		if(
			(
			((a-fdi)>=0)&&
			(((b+fdi)>=0)&&((b+fdi)<15))
			)
			&&(
			((a+4-fdi)<15)&&
			((b-(4-fdi)<15)&&(b-(4-fdi)>=0))
			)
			)
		{
				/*if((chess[a-fdi][b+fdi]==c)&&
				(chess[a-fdi+1][b+fdi-1]==c)&&
				(chess[a][b]==c)&&
				(chess[3+a-fdi][fdi-4+b+1]==c)&&
				(chess[4+a-fdi][-4+fdi+b]==c))*/

				if((chess[a-fdi][b+fdi]==c)&&
				(chess[a-fdi+1][b+fdi-1]==c)&&
				(chess[a-fdi+2][b+fdi-2]==c)&&
				(chess[3+a-fdi][fdi-4+b+1]==c)&&
				(chess[4+a-fdi][-4+fdi+b]==c))
			{
				printf("you fanduijiao win !!:%d\n",fdi);
				flag=1;
					win_location[0][0]=a-fdi;
					win_location[1][0]=a-fdi+1;
					win_location[2][0]=a-fdi+2;
					win_location[3][0]=a-fdi+3;
					win_location[4][0]=a-fdi+4;
					/***/
					win_location[0][1]=b+fdi;
					win_location[1][1]=b+fdi-1;
					win_location[2][1]=b+fdi-2;
					win_location[3][1]=b+fdi-3;
					win_location[4][1]=b+fdi-4;
				printf("you fanduijiao win !!:\n");
					break;
			}
		}	
	}
}


//初始化棋子
void initchess()
{
	int a = 0;
	int b= 0;
	for (a = 0; a < 15; a++)
	{
		for (b = 0; b < 15; b++)
		{
			chess[a][b] = 43;//+
			//chess[m][n] = 3;//心形
			//chess[m][n] = 6;//黑桃
		}
	}
	//printwin();
}
//打印棋盘
void printwin()
{
	int i = 0;
	int j = 0;
	printf("   00 01 02 03 04 05 06 07 08 09 10  11 12 13 14\n");
	for (i = 0; i < 15; i++)
	{
		setColor(15,9);
		printf("%2d  ", i);
		for (j = 0; j < 15; j++)
		{
			//setColor(15,9);
				if(((i==win_location[0][0])&&(j==win_location[0][1]))
			||((i==win_location[1][0])&&(j==win_location[1][1]))
			||((i==win_location[2][0])&&(j==win_location[2][1]))
			||((i==win_location[3][0])&&(j==win_location[3][1]))
			||((i==win_location[4][0])&&(j==win_location[4][1])))
			
				{
				setColor(15,12);
				}
			printf("%c  ", chess[i][j]);
			setColor(15,9);
		}
		printf("\n");
	}
}
//有问题？？
int checkisempty(int x,int y)
{
	/*int i = 0;
	int j = 0;*/
	if ((chess[x][y] == 3) || (chess[x][y] == 6))
	{
		
		empty=1;
	}
	else
	{
		empty=0;
	}
	/*for (i = 0; i < 15; i++)
	{
		if (i == x)
		{
			for (j = 0; j < 15; j++)
			{
				if (y == j)
				{
					return 1;
				}
			}
		}
	}*/
	//
	return ;
}

void winjudge(int a,int b,char c)

{
	//printf("winjudge: %c\n",c);
	hengjudge(a, b, c);
	shujudge( a, b, c);
	duijiaojudge( a,b, c);
	fanduijiaojudge(a, b, c);
}



void cpuplace(char c)
{
	
menu:
	/*printf("usr please place:");
	scanf("%d %d",&x,&y);
	printf("%d %d\n",x,y);*/

	//srand(time(0));
	
	  x = rand() % 15;
	 Sleep(1*1*1000);
	  y = rand() % 15;
	  printf("%d %d\n",x,y);
	  //if ((x >= 15) || (y >= 15))
	  //{
	  //	printf("please input again:\n");
	  //	sleep(1*2*1000);
	  //	goto menu;
	  //}
		  checkisempty(x, y);
	   if( empty== 1)
	  {
		  empty=0;
		  printf("%d %d %c:\n",x,y,chess[x][y]);
		  //printf("there is already have:\n");
		  goto menu;
	  }
	  else
	  {
		  chess[x][y]= c;//心形
	  }
	
}
void cpuplace1(char c)
{
	
menu:
	/*printf("usr please place:");
	scanf("%d %d",&x,&y);
	printf("%d %d\n",x,y);*/

	//srand(time(0));
	m = rand() % 15;
	Sleep(1*1*1000);
	n = rand() % 15;
	printf("%d %d\n",m,n);
	checkisempty(m, n);
	 if(empty== 1)
	{
		empty=0;
		printf("%d %d %c:\n",m,n,chess[m][n]);
		//printf("there is already have:\n");
		goto menu;
	}
	else
	{
		chess[m][n]= c;//心形
	}
}

void usrplace()
{
	
menu:
	printf("usr please place:");
	scanf("%d %d", &m, &n);
	printf("%d %d\n", m, n);
	checkisempty(m, n);
	if ( empty== 1)
	{
		empty=0;
		printf("%d %d %c:\n",m,n,chess[m][n]);
		printf("there is already have:\n");
		goto menu;
	}
	else
	{
		chess[m][n] = 3;//黑桃
	}
}


int main()
{
	int i = 0;
	system("color f0");
	srand(time(0));
	initchess();
	printwin();
	//usrplace();
	//system("cls");
	//
	Sleep(2*2*1000);
	//cpuplace();
	//printwin();
	while(1)
	{
		//usrplace();
		cpuplace1(3);
		
		winjudge(m,n,3);
		printwin();	
		Sleep(1*1*100);
		if(flag==0)
		{
			system("cls");
			//Sleep(1*1*100);
			
		}
		else
		{
			printf("\n");
			system("pause");
			break;
			
		}
		Sleep(2*1000);
		/****/

		cpuplace(6);
		winjudge(x,y,6);
		printwin();		
		Sleep(1*1*100);
		if(flag==0)
		{
			system("cls");
			//Sleep(1*1*100);
		}
		else
		{
			printf("\n");
			system("pause");
			break;
			
		}
		//Sleep(10*1000);
	}
	
	
	system("pause");
	return 0;
}