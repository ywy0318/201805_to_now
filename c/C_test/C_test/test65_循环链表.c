#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>

//循环链表只能从一个方向上遍历，

/*
无论静态链表还是动态链表,有时在解决具体问题时，需要我们对其结构进行稍微地调整;
比如,可以把链表的两头连接，使其成为了一个环状链表，通常成为循环链表;
和它的名字的表意一样，只需要将表中最后一个节点的指针指向头结点，链表就能成环;
需要注意的是:虽然循环链表成环状，但本质上还是链表，依然能够找到头指针，和首元节点等;
循环链表和普通链表相比，唯一的不同就是循环链表首位相连，其他都完全一样;
*/
/*
循环链表实现约瑟夫环
约瑟夫环问题,是一个经典的循环链表问题,题意是:已知n个人(分别用编号1,2,3,...n表示)围坐在一张圆桌周围,
从编号为k的人开始顺序针报数;数到m的那个人出列；他的下一个又从1开始，还是顺时针开始报数，数到m的
那个人出列,依次重复下去，知道圆桌上剩余一个人；
假设此时圆周围有5个人，要求从编号为3开始顺时针数数，数到2的那个人出列;
编号为3的人开始数1，然后4开始数2，所以4出列;
4出列以后，从5开始数1，1数2，所以1出列;
1出列以后，从2开始数1，然后3数2，所以3出列
3出列以后，从5开始数1，然后2数2，所以2出列
最后只剩下5，所以5胜出;
约瑟夫环问题，有多种变形,比如顺时针改为逆时针，虽然问题的细节有多种变数，
但解决问题的中心思想是一样的，使用循环链表;

循环链表和动态链表唯一不同在于它的首位连接，这也注定了再使用循环链表时，
附带最多的操作就是遍历链表,
在遍历的过程中，尤其要注意循环链表虽然首尾相连，但并不代表
该链表没有第一个节点和最后一个节点，所以不要随意改变头指针的指向;

*/


/***************待续*******************/
#define N 5
typedef struct node
{
	int number;
	struct node *next;
}person;

//带有头链表的head指针
person *init_Link(int n)
{
	int i=0;
	
	person *cyclic=NULL;
	person *body=NULL;
	person *head =(person*)malloc(sizeof(person));
	head->number=1;
	head->next=NULL;
	//printf("%d\n",head->number);
	cyclic=head;
	printf("--init_start--\n");
	printf("%x,%x,%d\n",&cyclic,&head,cyclic->number);
	for(i=2;i<=n;i++)
	{
		body=(person*)malloc(sizeof(person));
		body->number=i;
		body->next=NULL;
		//
		cyclic->next=body;		
		cyclic=cyclic->next;
		printf("%x,%x,%d\n",&cyclic,&cyclic->next,cyclic->number);
		//printf("%d\n",cyclic->number);
	}
	//最后一个的时候把指针切换到head那里,
	cyclic->next=head;
	printf("\n");
	printf("%x,%x %d\n",&cyclic,&cyclic->next,cyclic->number);
	printf("--init_end--\n");
	return cyclic;
	//return head;
}
void show_list(person *head_1)
{
	person *temp=head_1;
	int length=0;
	if(head_1==NULL)
	{
		printf("head is null\n");
		exit(-1);
	}
	printf("%d\n",temp->number);
	for(temp=head_1->next;temp!=head_1;temp=temp->next)
	{
		printf("%d\n",temp->number);
		length++;
	}
	printf("length=%d\n",length);
	printf("---\n");
}
void find_kill(person *head,int m,int k)
{
	person *tail=head;
	person *p=head;
	int i=1;
	//找到链表第一个节点的上一个节点，为删除操作做准备
	//while(1)
	//{
	//	if(tail->next==head)
	//	{
	//		break;
	//	}
	//	tail=tail->next;
	//}

	while(tail->next!=head)
	{
		tail=tail->next;
	}
	printf("tail->number:%d\n",tail->number);
	//while(1)
	//{
	//	printf("%p,%p\n",head,tail->next);
	//	if(tail->next!=head)
	//	{
	//		tail=tail->next;
	//	}
	//	else
	//	{
	//		break;
	//	}
	//}

	//找到编号为k的人
	while(p->number!=k)
	{
		tail=p;
		p=p->next;
	}
	printf("K:%d-%d\n",tail->number,p->number);
	
	//从编号为k的人开始，只有符合p->next==p时,
	//说明链表中除了p节点意外，所有编号都出列了;
	while(p->next!=p)
	{
		//找到从p报数1开始，报m的人，并且还要知道数m-1的人的位置tail,
		//方便做删除操作
		for(i=1;i<m;i++)
		{
			tail=p;
			p=p->next;
		}
		tail->next=p->next;//从链表上将p节点摘下来
		printf("出列的人的编号:%d\n",p->number);
		free(p);
		p=tail->next;//继续使用p指针指向列出编号的下一个编号，游戏继续
	}
	printf("最后出列的人的编号:",p->number);
	free(p);
}

int main()
{	
	person *headp=init_Link(N);
	show_list(headp);
	find_kill(headp,N,3);
	
	system("pause");
	return 0;
}