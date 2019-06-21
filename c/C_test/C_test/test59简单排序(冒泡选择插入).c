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
int data[10]={66,32,23,45,25,5,15,69,46,37};
int data1[10]={66,32,23,45,25,5,15,69,46,37};
//int data[11]={0,66,32,23,45,25,5,15,69,46,37};

/*
0 1 0
1 2 1
2 3 2
3 4 3
4 5 4
5 6 5
6 7 6
7 8 7
8 9 8

*/


//从第一个开始，挨个跟后面一个比较，如果大于后面那个交换，否则就继续选后面两个重复
//相当于每一波的时候把最大的挪到了最后，所以不用每次都比较后面的了
void maopao_sort()
{
	int i=0;
	int j=0;
	int temp=0;
	for(i=0;i<10-1;i++)
	{
		printf("%d:",i);
		for(j=0;j<10-1-i;j++)
		{
			if(data[j]>data[j+1])
			{
				temp=data[j];
				data[j]=data[j+1];
				data[j+1]=temp;				
			}
			printf("%d %d",j,j+1);
			printf(";");
		}
		printf("\n");
	}
}

//每一波都是跟后面的比较，把小的跟当前这次要确定的那个小的数交换
//相当于每次把剩下的最小的往前挪所以前面的就不比较了
void choose_sort()
{
	int ci=0;
	int cj=0;
	int ctemp=0;
	for(ci=0;ci<10;ci++)
	{
		printf("%d :",ci);
		for(cj=ci+1;cj<10;cj++)
		{
			if(data[cj]<data[ci])
			{
				ctemp=data[cj];
				data[cj]=data[ci];
				data[ci]=ctemp;
			}
			printf("%d ",cj);
			printf(";");
		}
		printf("\n");
	}
}

//相当于每次都把后面的数往前面的“数组”中插入，
//插入的时候进行比较
//数组移位向后,将最后一个数组拷贝到临时变量里面然后循环a[j+1]=a[j];

//插入排序好事多磨啊
//首先，找到要插入的数值前面的所有的数值比要插入的大的数值,把这些数值往后移动
//然后不大的那个索引赋值
void insert_sort()
{
	int si=0;
	int sj=0;
	int stemp=0;
	int sindex=0;
	for(si=1;si<10;si++)
	{
		stemp=data[si];//把要插入的数值拷贝到临时变量
		sj=si-1;
		//从后往前遍历;挨个比较,要插入的数值比后面向前遍历的时候的数字小的话,就一直循环移位;
		//如果不小的话就可以确定位置了
		//printf("%d ::",si);
		while((sj>=0)&&(data[sj]>stemp))
		{
		//printf("  %d  %d %d %d;  ",data[sj+1],data[sj],sj,stemp);
			data[sj+1]=data[sj];
			sj--;
			
		}
		data[sj+1]=stemp;
	/*	printf("\n");
		printf_vector(data,10);
	printf("\n");*/
		//for(sj=si-1;sj>=0;)
		//{

		//	/*if(data[sj]<stemp)
		//	{
		//		data[sj+1]=stemp;
		//		break;
		//	}
		//	else
		//	{
		//		data[sj+1]=data[sj];
		//	}*/
		//	if(data[sj]>stemp)
		//	{	
		//		data[sj+1]=data[sj];
		//		sj--;
		//	}
		//	else
		//	{
		//		data[sj+1]=stemp;
		//		break;
		//	}
		//}
	}
}


void insert_sort1()
{
	int si=0;
	int sj=0;
	int stemp=0;
	int sindex=0;
	for(si=1;si<10;si++)
	{
		stemp=data1[si];//把要插入的数值拷贝到临时变量
		sj=si-1;
		//从后往前遍历;挨个比较,要插入的数值比后面向前遍历的时候的数字小的话,就一直循环移位;
		//如果不小的话就可以确定位置了
		//printf("%d ::",si);
		/*while((sj>=0)&&(data[sj]>stemp))
		{
		printf("  %d %d %d;  ",data[sj+1],data[sj],sj);
			data[sj+1]=data[sj];
			sj--;
			
		}
		data[sj+1]=stemp;*/
		
		for(sj=si-1;sj>=0;)
		{
			//printf("exe for：%d\n",sj);
			/*if(data[sj]<stemp)
			{
				data[sj+1]=stemp;
				break;
			}
			else
			{
				data[sj+1]=data[sj];
			}*/
			//printf("  %d %d %d %d ;  ",data1[sj+1],data1[sj],sj,stemp);
			if(data1[sj]>stemp)
			{	
				data1[sj+1]=data1[sj];
				sj--;
			}
			else
			{
				break;
			}
			/*else
			{
				printf("exe：%d\n",sj);
				data1[sj+1]=stemp;
				break;
			}*/

		}
		//printf("exe：%d\n",sj);
		data1[sj+1]=stemp;

		/*printf("\n");
		printf_vector(data1,10);
		printf("\n");*/
	}
}


int main()
{	
	
	printf("befor : ");
	printf_vector(data,10);
	printf("\n");
	printf("\n");
	//maopao_sort();
	//choose_sort();
	insert_sort();
	printf("\nafter : ");
	//printf("\n");
	//printf("\n");
	//insert_sort1();
	//printf("\nafter : ");
	printf_vector(data,10);
	//printf("\n");
	//printf("\n");
	//printf_vector(data1,10);
	printf("\n");
	system("pause");
	return 0;
}