#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>
#define SIZE 24
/*
静态链表和动态链表的区别
静态链表和动态链表的共同点是，数据之间"一对一"的逻辑关系都是依靠指针
(静态链表中称为"游标")来维持，仅此而已;


静态链表:
使用静态链表存储数据，需要预先申请足够大的一整块内存空间，也就是说，静态链表存储数据元素的
个数，从其创建的那一刻就已经确定，后期无法更改;
比如，如果创建静态链表时只申请存储10个数据元素的空间，那么在使用静态链表时,
数据的存储个数就不能超过10个，否则程序就会发生错误;
不仅如此，静态链表在固定大小的存储空间内随机存储各个数据元素，这就造成了静态链表中需要使用
另一条链表(备用链表),来记录空间存储空间的位置，以便后期分配给新添加元素使用，
这意味着，如果使用静态链表存储数据，需要通过操控两条链表，一条存储数据,
另一条是记录空间的位置;

动态链表
使用动态链表存储数据，不需要预先申请内存空间，而是在需要的时候才向内存申请;
也就是说，动态链表存储数据元素的个数是不限的，想存多少就存多少;
同时，使用动态链表的整个过程，你也只需要操控一条存储数据的链表，
当表中添加或者删除数据元素时，只需要使用malloc或者free来申请或者释放空间即可;

*/

//static linked list
typedef struct
{
	int data;
	int cur;
}sll;

void reserved_sll(sll* array_2){
	int i=0;
	for(i=0;i<SIZE;i++)
	{
		array_2[i].cur=i+1;
	//	printf("reserved_sll:%d\n",array_2[i].cur);
	}
	array_2[SIZE-1].cur=0;
	//printf("reserved_sll:%d\n",array_2[SIZE-1].cur);

}
int get_null_sll(sll* array_3)
{
	int i=0;
	i=array_3[0].cur;
	if(i>0)
	{
		array_3[0].cur=array_3[i].cur;
	}
	return i;
}
int get_index_sll(sll* array_6,int tm)
{
	int i=0;
	int tmp=0;
	int ret=-1;
	for(i=0;i<SIZE;i++)
	{
		tmp=array_6[i].cur;
		//printf("%d==%d\n",tm,tmp);
		if(tm==tmp)
		{
			ret=i;
			break;
		}
	}
	return ret;
}
void init_sll(sll *array_1){
	int i=0;
	int j=0;
	int temp=1;
	int temp_backup=0;
	reserved_sll(array_1);
	//
	
	for(i=0;i<5;i++)
	{	
		temp=get_null_sll(array_1);
		temp_backup=temp;
		array_1[temp].data=i+10;
		array_1[0].cur=array_1[temp].cur;
		//temp=get_null_sll(array_1);
		//temp=array_1[temp_backup].cur;		
	}
	array_1[temp_backup].cur=0;
	array_1[SIZE].cur=0;
}
void dispaly_all(sll *array_4)
{	
	int i=0;
	printf("---\n");
	for(i=0;i<SIZE;i++)
	{
		printf("i:data:cur:%d,%d,%d\n",i,array_4[i].data,array_4[i].cur);
	}
}

//向链表中插入数据，body表示链表的头结点在数组中的位置，add表示插入元素的位置，a表示要插入的数据
//void insertArr(component * array,int body,int add,char a)
//void insert(sll* array_5,int body,int add,char a)
//cur--游标的索引不一定是顺序排列的可能是4-3-5
void insert(sll* array_5,int add,int a)
{
	//需要改动三个地方，第一个之前的数据链表的最后一个值,第二个0那里的游标值，还有要加入的索引的游标值
	//body做遍历结构体数组使用，可能静态链表不是从a[1]开始的？
	//
	//找到之前的包含有效数据的数组的索引，然后准备修改其索引，
	//找到当前数组索引为0的时候对应的游标值，其对应的是下一个可用的备用链表
	int i=0;
	int index=0;
	int tmp=0;
	int tmp_for_add=-1;
	int tem_for_0=-1;
	int tmp_cur=0;
	int tmp_cur2=0;
	int cur_for_add=0;
	//获取数据链表的最后一个值
	
	tmp=get_index_sll(array_5,0);//从这个索引跳转到0的
	if(tmp==-1)
	{
		printf("insert failed\n");
		exit(-1);
	}
	//printf("add\n");
	tmp_for_add=get_index_sll(array_5,add);//要加入的索引的游标值
	if(tmp==-1)
	{
		printf("insert failed\n");
		exit(-1);
	}
	//tem_for_0=get_index_sll(array_5,0);//0的游标值
	tem_for_0=array_5[0].cur;
	//获取加入之前要加入的坐标的游标值

	array_5[tmp].cur=add;
	array_5[tmp_for_add].cur=array_5[add].cur;
	array_5[add].cur=0;
	array_5[add].data=a;

	//tmp_cur=array_5[0].cur;//获取当前0索引对应的备份链表的索引值
	//tmp_cur2=array_5[tmp_cur].cur;//获得之前，0指向的
	//printf("%d-%d--%d--%d--%d--%d\n",tmp_for_add,tmp,tmp_cur,add,a,tem_for_0);	
	//array_5[0].cur=tmp_cur;
	////printf("%d=%d\n",array_5[tmp].cur,add);
	////array_5[tmp].cur=add;
	//array_5[tem_for_0].cur=add;
	////printf("%d=%d\n",array_5[tmp].cur,add);
	//array_5[add].data=a;
	//array_5[add].cur=0;
	return;

}
//增加的逆操作
void delete_sll(sll* array_6,int b)
{
	int num=0;
	int before_cur=0;
	int after_cur=0;
	int cur_for_0=0;
	num=search_sll(array_6,b);
	if(num>=0)
	{
		before_cur=get_index_sll(array_6,num);
		after_cur=array_6[num].cur;
		array_6[num].data=0;
		array_6[before_cur].cur=after_cur;
		
		//备用链表中执行插入操作
		//偷懒，直接把删除之后的备用链表的数据放到第一个
		cur_for_0=array_6[0].cur;
		array_6[0].cur=num;
		array_6[num].cur=cur_for_0;
		printf("del success\n");
	}
	else
	{
		printf("not find \n");
		return;
	}
}
//返回的是索引值,数组的索引值
int search_sll(sll* array_7,int c)
{
	//int i=1;
	int tmp=1;
	//tmp=array_7[1].cur;
	while((array_7[tmp].data)!=c)
	{
		//i++;
		tmp=array_7[tmp].cur;
		if(tmp==0)
		{
			//printf("search failed\n");
			return -1;
		}
	}
	//printf("search:%d\n",tmp);
	return tmp;
}

void update(sll* array_8,int old_c,int new_c)
{
	int num=-1;
	num=search_sll(array_8,old_c);
	if(num>=0)
	{
		array_8[num].data=new_c;
		return ;
	}
	else
	{
		printf("update failed for char is not found\n");
	}
}
static sll sl_list[SIZE];
int main()
{	
	//int i=1;
	//int temp=0;
	//sl_list[0].cur=1;
	////sl_list[1].data=10;
	//for(i=1;i<12;)
	//{
	//	temp=i;
	//	sl_list[i].data=10+i;
	//	sl_list[i].cur=temp+2;
	//	i+=2;
	//}

	init_sll(sl_list);
	dispaly_all(sl_list);
	//
	printf("---\n");
	insert(sl_list,10,333);
	dispaly_all(sl_list);


	printf("--ss-\n");
	insert(sl_list,11,222);
	dispaly_all(sl_list);

	if(search_sll(sl_list,11)>0)
	{
		printf("%d\n",search_sll(sl_list,11));
	}
	else
	{
		printf("search failed\n");
	}

	update(sl_list,11,11111);
	update(sl_list,10,333333);
	//char与int之间转换
	//printf("del---");
	//delete_sll(sl_list,11);
	//delete_sll(sl_list,12);
	dispaly_all(sl_list);

	system("pause");
	return 0;
}