/*产生10个不同的随机数函数*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>

void printf_vector(int data[], int n)
{
	int i = 0;
	for (i = 0; i < n; i++)
	{
		printf("%d ", data[i]);

	}
	printf("\n");

}
typedef struct 
{
	int a;
	int b;
	double c;
} stu;

typedef void(*call_back)(stu *data);
typedef	struct
{
	int p;
	int q;
	call_back handler;
}fun;
typedef struct 
{
	int age;
	char name[20];
	int num;
	int height;
}person;
static person p[5] = { 
	{25,"asd",123,188} ,
	{23,"sss",124,187} ,
	{24,"ss",125,186},
	{22,"aa",126,186},
};
void printf_age()
{
	printf("p1 is %d\n",
		p[1].age);
}
static fun init[]=
{
	{ 25 ,999,printf_age },
	//{p[1].age ,999,printf_age},
	{},
	{NULL,-1,NULL},

};

static fun *point[] =
{
	init,
	start,
	go,
	end,
	NULL
};


int main() {


	system("pause");
	return 0;

}
