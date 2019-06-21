#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>

//顺序表存储数据,需要先申请一整块足够大的存储空间,然后将数据按照次序逐一存储,
//数据之间紧密贴合 ,不留一丝空隙

//链表的存储方式与顺序表截然相反,什么时候存储数据，什么时候申请存储空间,
//数据之间的逻辑关系依靠每个数据元素所携带的指针位置;


//顺序表和链表中的几种不同之处:
//顺序表存储数据实行"一次开辟，永久使用",即存储数据之前先开辟好足够的存储空间，空间一旦开辟
//后期无法改变大小(使用动态数组除外)

//链表则不同，链表存储数据时，一次只开辟存储一个节点的物理空间，如果后期需要还可以申请
//因为若只从开辟空间的角度考虑，当存储数据的个数无法以前确定，又或者是物理空间紧张
//以至于无法一次性申请到足够大小的空间时,使用链表更有助于问题的解决

//空间利用率
//从空间利用率的角度上看，顺序表的空间利用率显然要比链表高
//链表存储数据时，每次只申请一个节点的空间，而且空间的位置是随机的
//这种申请存储空间的方式会产生很多空间碎片，一定程度上造成了空间浪费，
//不仅如此，由于链表中每个数据元素都必须携带至少一个指针，因此，链表
//对所申请空间的利用率也没有顺序表高
//空间碎片:是指某些容量很小(1KB甚至更小)以至于无法得到有效利用的物理空间
//时间复杂度:
//解决了不同类型的问题,顺序表和链表对应的时间复杂度也不同
//根据顺序表和链表在存储结构上的差异，问题类型主要分为一下2类
//1:问题中主要涉及访问元素的操作,元素的插入，删除和移动操作极少
//2:问题中主要涉及元素的插入，删除和移动,而访问元素的需求很少

//第一类问题适合使用顺序表,这种因为，顺序表中存储的元素可以使用数组下标直接访问，
//无序遍历整个表,因此使用顺序表访问元素的时间复杂度为O(1);而在链表中访问数据元素,
//需要从表头一次遍历,知道找到指定的节点,花费的时间复杂度为O(n);

//第二类问题则适合使用链表;链表中数据元素之间的逻辑关系靠的是节点之间的指针,
//当需要在链表中某处插入或删除节点时，只需改变相当节点的指针指向即可;
//无需大量移动元素,因此链表中插入，删除，移动数据所耗费的时间复杂度为O(1),
//而顺序表中,插入，删除和移动数据可能会牵涉到大量元素的整体移动，因此时间复杂度
//至少为O(n)

//链表不限制数据的物理存储状态,链表存储的元素，其物理存储位置是随机的
typedef struct Link
{
	int elem;//代表数据域
	struct Link*next;//代表指针域,指向直接后继元素
}link;//link为节点名,每个节点都是一个link结构体;

//链表初始化()

//声明一个头指针,
//头指针是首元节点那里赋值
//无头节点是首元节点那里不赋值
link * init_link()
{
	int i=2;
	link *p=NULL;//创建头指针
	link *temp=(link*)malloc(sizeof(link));//创建首元节点
	temp->elem=1;
	temp->next=NULL;
	p=temp;//头指针指向首元节点,
	for(i=2;i<5;i++)
	{
		link *a=(link*)malloc(sizeof(link));//创建一个新节点并初始化
		a->elem=i;
		a->next=NULL;
		//将temp节点与新建立的a节点建立逻辑关系
		temp->next=a;
		//针指temp每次都指向新链表的最后一个节点,起始就是a节点，temp=a;也对
	}
	//返回建立的节点,只返回指针p即可，通过头指针即可找到整个链表
	return p;
}
//创建一个无头的链表初始化
link * init_link_2()
{
	link * p=(link*)malloc(sizeof(link));//创建一个头节点
	link * temp=p;//声明一个指针指向头节点
	int i=0;
	for(i=0;i<5;i++)
	{
		link *a=(link*)malloc(sizeof(link));
		a->elem=i;
		a->next=NULL;
		temp->next=a;
		temp=temp->next;
	}
	return p;
}
link *init_link_3()
{
	int i=0;
	link * p=NULL;
	link * temp=(link*)malloc(sizeof(link));//创建首元节点
	//首元节点先初始化
	temp->elem=1;
	temp->next=NULL;
	p=temp;//头指针指向首元节点
	for(i=2;i<5;i++)
	{
		link *a=(link*)malloc(sizeof(link));
		a->elem=i;
		a->next=NULL;
		temp->next=a;
		temp=temp->next;
		printf("循环次数:%d\n",i);
	}
	return p;
}
void display_link(link *p)
{
	link *tmp=p;//将tmp指针重新指向头节点
	//只要tmp指针指向的节点不是null,就执行输出语句
	//while(tmp->next)打印带有头结点创建链表的方式
	while(tmp)
	{
		printf("%d,%x,0x%x,0x%x\n",tmp->elem,tmp->next,&tmp->elem,&tmp->next);
		tmp=tmp->next;
	}
	//printf("%d,%x,0x%x,0x%x\n",tmp->elem,tmp->next,&tmp->elem,&tmp->next);

	printf("\n");
}
int main()
{	link *pp=NULL;
	//link 是一个自己定义的链表结构
	printf("链表初始化:%d\n",sizeof(link));
	pp=init_link_3();
	display_link(pp);
	//pp只是一个四字节的指针
	printf("sizeof(pp):%d\n",sizeof(pp));

	//system("pause");
	while(2);
	return 0;
}