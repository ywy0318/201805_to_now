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


//产生n个不同的随机数，随机数范围从1-num;保存在d[]中;
void generate_random_vector(int d[], int n, int num)
{
	int i = 0;
	int ret;
	int m = 0;
	if (num < n)
	{
		printf("CAN not generate %d numbers\n", num);
		return -1;
	}
	srand(time(0));
	for (i = 0; i < n;)
	{
		ret = rand() % num ;
		//ret = rand() % num + 1;
		for (m = 0; m < i; m++)
		{
			if (d[m] == ret)
			{
				break;
			}
		}
		if (m == i)
		{
			d[i] = ret;
			i += 1;
		}
	}
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
	//char name[20];
	int num;
	struct node *next;

}stud, *linklist;//双向链表的定义


linklist create(void)
{
	linklist head;
	stud *p, *q;
	char a;
	head = NULL;
	int i = 0;
	int f[100];

	generate_random_vector(f, 10, 10);

	while (f[i] !=0)
  {
	   
	    p = (stud*)malloc(sizeof(stud));
		p->num = f[i];
		printf("%d:%d\n",i,f[i]);
		p->next = head;
		head = p;
		i++;
	}
	return(head);
}
		

//stud *srearch(stud*h, char*x)
//{
//	stud *p;
//	char *y;
//	p = h->next;
//	while (p)
//	{
//		y = p->name;
//		if (strcmp(x, y) == 0)
//		{
//			return(p);
//		}
//		else
//			p = p->next;
//	}
//	printf("NO");
//}


void del(stud *p)
{
	//p->next->perior = p->perior;
	//p->perior->next = p->next;
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
	sp = create();
    //head = sp;
	//printf("%d\n", sp->num);
	//sp = sp->next;
	while (sp)
	{
		printf("%d\n", sp->num);
		sp = sp->next;
	}
	/*while (1)
	{
	i++;
	generate_string(sname, 2);
	printf("%d--%s\n", i, sname);
	if (i == 20)
	{
	break;
	}
	}*/




	printf("\n");

	system("pause");
	return 0;
}