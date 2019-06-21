/**/


#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<malloc.h>
#include<conio.h>

struct Lnode
{
	int data;
	struct Lnode *next;
};
/*用于创建链表，返回值指向struc Lnode类型数据，实际返回链表的头指针*/
struct Lnode *Create(int n)
{
	int i = 0;
	struct Lnode *head, *p, *q;
	int a;

	//head= (struct Lnode*)malloc(sizeof(struct Lnode));
	q = (struct Lnode*)malloc(sizeof(struct Lnode));
	srand(time(0));
	head = q;
	head->next=NULL;
	printf("%p,%d\n",head,*(head));
	for (i = n; i > 0; --i)
	{
		p = (struct Lnode*)malloc(sizeof(struct Lnode));
		//q = (struct Lnode*)malloc(sizeof(struct Lnode));
		Sleep(1000);
		a=rand() % 30;
		
		p->data = a;

		q->next = p;
		p->next = NULL;
		q = p;
		printf("%d create %d  ,%p , %p \n",a,i, &(p->data),p->next);

		//if (head == NULL)//链表中的第一个
		//{
		//	head = p;
		//	q = p;
		//}
		//else
		//{
		//	q->next = p;
		//	q = p;
		//}
	}
		//q->next = NULL;
		return head;
	
	
}

int main()
{

	int length;
	length = sizeof(struct Lnode);
	int n;
	struct Lnode *pq;
	pq = Create(3);
	//printf("%d\n",length);
	while (pq->next!=NULL)
	{
		
		printf("while1 %d ,%p---", *(pq->next), &(pq->next));
		//printf("%d--",*(&(pq->next)));
		printf("while %d ,%p\n",pq->next->data, &(pq->next->data));
		pq = pq->next;
	}
	printf("\n");







	system("pause");
	return 0;
}