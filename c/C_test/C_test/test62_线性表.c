#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>

//顺序存储结构和链式存储结构(线性表存储数据可以分为两种:数据类型必须一致)
//将数据一次存储在连续的整块物理内存中，这种存储结构成为顺序存储结构(简称顺序表)
//数据分散的存储在物理空间中(内存地址不连续),通过一根线保存着他们之间的逻辑关系,这种存储结构成为链式存储结构(链表)

//指针名=（数据类型*）realloc（要改变内存大小的指针名，新的大小）。
//新的大小可大可小（如果新的大小大于原内存大小，则新分配部分不会被初始化；如果新的大小小于原内存大小，可能会导致数据丢失 [1-2]  ）


#define SIZE 5
typedef struct Table
{
	int *head;//生命了一个名为head的长度不定的数组，也叫动态数组
	int length;//记录当前顺序表的长度
	int size;//记录顺序表分配的存储容量
}table;

//初始化
table init_table()
{
	table t;
	t.head=(int*)malloc(SIZE*sizeof(int));//构造一个空的顺序表,动态申请存储空间
	if(!t.head)
	{
		printf("init table failed!\n");
		exit(0);
	}
	t.length=0;//空表的初始化长度为0
	t.size=SIZE;//空表的初始化空间为SIZE
	return t;
}
void display_table(table t)
{
	int i=0;
	//printf("start\n");
	for( i<0;i<t.length;i++)
	{		
		printf("%d  ,0x%x\n",t.head[i],&t.head[i]);
	}
	//printf("end\n");
}
//插入函数,要插入的table,元素，位置index是数组中第几个元素而非索引值
table insert_table(table t_for_insert,int element,int index_for_insert)
{
	int i=0;
	//判断插入本身是否存在问题,(如果插入元素位置比整张表的长度+1还大(相等，是尾随的情况)),
	//或者插入的位置本身不存在，程序提示并自动退出
	if((index_for_insert>t_for_insert.size+1)||(index_for_insert<1))
	{
		printf("插入位置有问题");
		return t_for_insert;
	}
	//插入操作时,首先需要看看顺序表中是否还有多余的控件提供插入，如果没有多余的，重新申请
	if(t_for_insert.length==t_for_insert.size)
	{
		t_for_insert.head=(int *)realloc(t_for_insert.head,sizeof(int)*(t_for_insert.size+1));
		if(!t_for_insert.head)
		{
			printf("realloc failed\n");
			return t_for_insert;
		}
		t_for_insert.size+=1;
	}
	////插入操作,需要把要插入的位置后面的元素，往后移动
	//for(i=t_for_insert.length-1;i>=index_for_insert-1;i--)
	//{
	//	t_for_insert.head[i+1]=t_for_insert.head[i];
	//}

	//后移操作,计算出需要后移元素的个数index_for_insert想成为第几个元素,
	//之前有length个元素,需要移动几个元素length-(index_for_insert-1)
	//实际移动index_for_insert-1元素有问题	
	for(i=0;i<t_for_insert.length-index_for_insert+1;i++)
	{
		t_for_insert.head[t_for_insert.length-i]=t_for_insert.head[t_for_insert.length-1-i];
	}

	//display_table(t_for_insert);
	//
	t_for_insert.head[index_for_insert-1]=element;
	
	t_for_insert.length+=1;
	//display_table(t_for_insert);
	return t_for_insert;
}
//index_for_del是删除第几个元素不是索引
table delete_table(table t_for_del,int index_for_del)
{
	int i=0;
	if((index_for_del>t_for_del.length)||(index_for_del<1))
	{
		printf("被删除的元素有误");
		exit(0);
	}
	//直接把后面的往前移动，直接覆盖
	for(i=index_for_del-1;i<(t_for_del.length-1);i++){
		t_for_del.head[i]=t_for_del.head[i+1];
	}
	t_for_del.length-=1;

	return t_for_del;
}

//修改，找不到退出
table update_table(table t_for_up,int old_element,int new_element)
{
	int ret=-1;
	ret=search_table(t_for_up,old_element);
	if(ret<0)
	{
		printf("元素不存在");
		exit(0);
	}
	else
	{
		t_for_up.head[ret-1]=new_element;
	}
	return t_for_up;
}
//查找 不存在返回-1,存在返回第几个数字
int search_table(table t_for_table,int element_for_search)
{
	int i=0;
	for(i=0;i<t_for_table.length;i++)
	{
		if(t_for_table.head[i]==element_for_search)
		{
				return i+1;
		}
	}
	return -1;
}

int main()
{	
	int j=0;
	int ret=-1;
	table t=init_table();
	//向顺序表中添加元素
	for(j=0;j<t.size;j++)
	{
		t.head[j]=j;
		t.length++;
	}
	printf("%d\n",t.length);
	printf("display_table:\n");
	display_table(t);
	printf("insert\n");
	ret=search_table(t,22);
	if(ret>0)
	{
		printf("serach::%d\n",ret);
	}
	else
	{
		printf("search failed\n");
	}
	t=update_table(t,1,102);
	//t = delete_table(t,1);
	//t=insert_table(t,444,6);
	printf("after insert:\n");
	display_table(t);

	system("pause");
	return 0;
}