/*判断输入是否为大小写，还有数字。
isalpha,isupper,islower,isalnum*/
/*while循环注意下标增加的位置！！！！！！！！！！！！！！！*/
/*strdup函数指针测试！！！！！！！！！！！！！！！*/
/*(*p显示的时候使用%c就可以显示了)*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>
//#include<bios.h>
void isprime_self(int m)
{
	int i = 2;
	for (i = 2; i < m / 2; m++)
	{
		if (m%i == 0)
		{
			printf("%d,NO!", i);
			//break;
			return 0;
		}


	}

}
int cifang(int m, int n)
{
	int i = 1;
	int sum = 1;
	for (i = 1; i <= n; i++)
	{
		sum = sum*m;
	}
	return sum;
}
int main()
{
	int m = 0, n;
	int ret;
	int min;
	char st[30] = "ABCDABCDFGGGFGFGG";// ;
	char a[10] = "ABCD";
	char b[10] = "FGG";
	char *p, *s;
	//gets(st);
	//a = st[2];
	char c, d;
	while (1)
	{

		c = getchar();//接收字符
		d = getchar();//接收回车
		if (isalpha(c)==2)//isalpha 小写字母返回2 ，大写字母返回1，其他为0，
		{
			printf("xiaoxie\n");
		}
		else if(isalpha(c) == 1)
		{
			printf("daxie\n");
		}
		else 
		{
			printf("fei zimu ");
		}
		Sleep(1000);
		if (isupper(c))
		{
			printf("daxie\n");
		}
		if (islower(c))
		{
			printf("xiaoxie\n");
		}

	}

	p = strspn(st, a);/*在st中找到第一个不属于a字符串中的字符位置,
					  返回第一个不匹配的下标*/
	s = strstr(st, b);/*在st中寻找b字符串的位置，返回该位置的指针*/

					  //printf("2:%d,%p,%c\n", p, s, *s);

					  //printf("0：%c,%p\n", a, &a);
					  //printf("1:%s\n", st);

					  //p = _strdup(st);//char *strdup(char *st) 先按照字符串长度在内存中分配空间。
					  //将字符串st的内容复制到该空间中
					  //_strlwr(st);//大写变小写
					  //printf("2:%s\n", p);
					  //printf("3:%p,%p,%c\n", p, st, *p);
					  //printf("4:%p,%p,%c,%c\n", p, st, *p, *st);
					  //printf("5:%p,%p,%c,%c\n", p + 1, st + 1, *(p + 1), *(st + 1));
	while (st[m] != '\0')
	{

		st[m] -= 32;
		m++;
		//m += 1;
	}
	//printf("3:%s\n", st);
	m = 0;
	while (st[m] != '\0')
	{

		st[m] += 32;
		m += 1;
	}
	//printf("4:%s\n", st);

	//int i = 0;
	//srand(time(0));
	//m = rand() % 5 + 2;
	//n = rand() % 5 + 2;
	//printf("%d\n", m);
	//printf("%d\n", n);
	//isprime_self(m);
	//s = sqrt(5);
	//printf("%lf\n", sqrt(4.0));
	//printf("%lf\n", sqrt(5));
	//y = modf(s, &x);
	//printf("%lf\n", x);
	//printf("%lf\n", y);
	//for (i = 0; i < 5; i++)
	//{
	//	ret = cifang(m, n + i);
	//	printf("%d\n", ret);
	//}
	system("pause");
	return 0;

}