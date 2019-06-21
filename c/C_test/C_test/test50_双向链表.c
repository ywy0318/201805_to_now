/*随机字符那里有bug,有时候会出现空格*/

#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>
//全局变量，每次随机从这里获取一个字符；
//const unsigned char allchar[63] = "0123456789ASDFGHJKLQWERTYUIOPZXCVBNMasdfghjklqwertyuiopzxcvbnm";
const unsigned char allchar[53] = "ASDFGHJKLQWERTYUIOPZXCVBNMasdfghjklqwertyuiopzxcvbnm";
void generate_string(unsigned char *string, unsigned int n)
{
	int i = 0;
	int ret;
	srand(time(0));
	for (i = 0; i < n; i++)
	{
		ret = rand() % 53;
		*string = allchar[ret];
		printf("%c", allchar[ret]);
		string++;
		Sleep(1000);
	}
	*string = '\0';
	printf("\n");
}


/*产生长度为n的随机字符串*/
char *generate_random_string(int n)
{
	int i = 0;
	int flag;
	char *string;
	srand(time(0));
	if ((string = (char*)malloc(n + 1)) == NULL)
	{
		printf("malloc faild\n");
		return NULL;
	}
	for (i = 0; i < n; i++)
	{
		flag = rand() % 2;
		switch (flag)
		{
		case 0:
			string[i] = 'A' + rand() % 25;
			break;
		case 1:
			string[i] = 'a' + rand() % 25;
			break;
		case 2:
			string[i] = '0' + rand() % 10;
			break;
		default:
			string[i] = 'X';
			break;
		}
	}
	string[n] = '\0';
	return string;
}
typedef struct node
{
	char name[20];
	struct node *next, *perior;

}stud;//双向链表的定义
stud * create(int n)
{
	stud *p, *q, *pq;
	int i = 0;
	char studname[20] = {'0'};
	p = (stud*)malloc(sizeof(stud));
	p->next = NULL;
	p->perior = NULL;
	p->name[0] = '\0';
	q = p;
	for (i = 0; i < n; i++)
	{
		//generate_string(studname, 5);
		//studname= generate_random_string(5);
		pq = (stud*)malloc(sizeof(stud));
		q->next = pq;
		generate_string(pq->name, 2);
		printf("%s\n", pq->name);
		pq->next = NULL;
		pq->perior = NULL;
		q = pq;
		//scanf("%s",pq->name);
		//memcpy()
		//pq->name = "assd";//C语言字符串不能拷贝？
	}
	q->next = NULL;
	return(p);
}
stud *srearch(stud*h, char*x)
{
	stud *p;
	char *y;
	p = h->next;
	while (p)
	{
		y = p->name;
		if (strcmp(x, y) == 0)
		{
			return(p);
		}
		else
			p = p->next;
	}
	printf("NO");
}
void del(stud *p)
{
	p->next->perior = p->perior;
	p->perior->next = p->next;
	free(p);
}


int main()
{
	int member;
	char sname[20];
	stud *head, *sp;
	int i = 0;
	//head = create(10);
	//sp = head->next;
	//while (sp)
	//{
	//	printf("1: %s\n",&*(sp->name));
	//	printf("2: %s\n",sp->name);
	//	sp = sp->next;
	//}


	while (1)
	{
		i++;
		generate_string(sname, 2);
		printf("%d--%s\n",i,sname);
		if (i == 20)
		{
			break;
		}
	}






	system("pause");
	return 0;
}