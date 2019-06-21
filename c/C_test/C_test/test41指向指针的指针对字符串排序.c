/*使用指针找出最大值，相当于临时变量的那个指针，
不能用数组的首地址，会修改数组首地址的数据*/
/*字符拼接编译不过去*/
/*数组逆序，使用while循环的时候注意循环结束的条件*/
/*延时Sleep(1000)的时候产生的随机数就会不相同*/
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

		if (i % 10 == 9)
		{
			printf("\n");
		}
	}
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
		ret = rand() % num + 1;
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

//全局变量，每次随机从这里获取一个字符；
const unsigned char allchar[63] = "0123456789ASDFGHJKLQWERTYUIOPZXCVBNMasdfghjklqwertyuiopzxcvbnm";
void generate_string(unsigned char *string, unsigned int n)
{
	int i = 0;
	int ret;
	//srand(time(0));
	for (i = 0; i < n; i++)
	{
		ret = rand() % 63;
		*string = allchar[ret];
		//printf("%c\n", allchar[ret]);
		string++;
	}
	*string = '\0';
}
void sort(char str[],int n)
{
	int i = 0;
	char *p = (char*)malloc(sizeof(char));
	for (p = str; p < str + 8; p++)
	{


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
void find_same(int d[], int d1[], int length)
{
	int i;
	int j;
	//p = d;
	//q = d1;
	//int num;
	//int fi, ei;
	for (i=0; i<length; i++)
	{
		for (j=0; j<length; j++)
		{
			if(d[i] ==d1[j])
			{				
		        printf("%d %d %d\n",i,j,d[i]);
				return;
			}			
		}
	}
	printf("NO\n");
	
}
static swap(int n, int m)
{
	printf("%x  before %x\n", n, m);
	int temp;
	temp = n;
	n = m;
	m=temp;
	printf("%x after %x\n", n, m);

}
void printf_vector_in_addr(int d[],int n)
{
	int *p;
	p = d;
	for (p = d; p < d + n; p++)
	{
		printf("%d ", *p);
	}
	printf("\n");
}


static find_max(const int d[], int num, int *n)
{
	int *p = (int*)(malloc(sizeof(int)));
	int *q = (int*)(malloc(sizeof(int)));

	int i = 0;
	//*p = 0;//临时变量
	p = d;
	//int *q;
	q = d + num - 1;
	//printf("%d  :1: %d %p %p\n", *p, *q ,p ,q);
	//printf("while %p\n", p);
	while (num--)
	//while (p<q)
	{
		if (*p < *q)
		{
			p = q;
			//printf("%d :2:  %d %p %p\n", *p, *q, p, q);
		}
		q--;
		//printf("%d :while:  %d %p %p\n", *p, *q, p, q);
		//printf("%p\n",p);
		//q++;
	}
	*n = p;
	printf(" # %d # %x\n", *p, n);
	//printf(" # %d %p %p\n",*p,p,d);
	/*for (i = 0; i < num; i++)
	{
		printf("");
	}*/

	//for (i = 0; i < num;i++)
	//{
	//	if((*p)<(*(d+i)))
	//	{
	//		*p = *(d + i);
	//		n = i;
	//	}
	//}


	

	//int c = d[0];
	//for (i = 0; i < num; i++)
	//{
	//	if (c< d[i])
	//	{
	//		c = d[i];
	//		n = i;			
	//	}
	//}	
	//printf("a[%d] %d\n", n,c);
}

/*有问题编译不过去*/
// connect(unsigned char *str0, unsigned char *str1, unsigned char *p)
////{
//{
//	 while ((*str0) != '\0')
//	{
//		*p = *str0;
//		p++;
//		str0++;
//	}
//	while ((*str1 )!= '\0')
//	{
//		*p = *str1;
//		p++;
//		str1++;
//	}
//	*p = '\0';
//}

 void inverse(int d[], int length)
 {
	 int *p;
	 int *q;
	 int i = 0;
	 p = d;
	 q = d + length-1;
	// printf("%p %p\n",p,q);
	 int temp;
	 //while (i<(length/2))
	 while(p<q)
	 {

		 temp = *p;
		 *p = *q;
	    //printf("%d\n",*p);
		 *q = temp;
		 p+=1;
		 q-=1;
		 i++;
		 //printf_vector(d, 10);
	 }

 }

int main() {
	int i = 0;
	int mn = 0;
	int ret;
	int f[100] = { '0' };
	int e[100] = { '0' };
	int n = 0;
	int c;
	int num = 0;
	int fi = 0;
	int ei = 0;
	int nm = 0;
	//int mn = 0;
	int *pq = (int*)(malloc(sizeof(int)));
	int *qq = (int*)(malloc(sizeof(int)));
	unsigned char *str2 = { 0 };
	unsigned char *str1= { 0 };
	unsigned char *str = { 0 };
	
	//char *str2 = (char*)malloc(sizeof(char) * 5);
	//char *str1 = (char*)malloc(sizeof(char) * 5);
	//char *str=(char*)malloc(sizeof(char)*5);//字符数组要初始化，generate_string不支持直接使用指针
	//char str[62] = "ASDFGHJK";//	
	//generate_string(str, 5);
	//str = generate_random_string(5);
	//str1 = generate_random_string(5);

	//connect(str,str1,str2);

	//printf("%s--%s\n", str,str1);
	//printf("%s\n", str2);

	//printf("after shell \n");
	//sort(str,8);
	//printf("%s\n", str);
	
	generate_random_vector(f, 10, 100);
	Sleep(1000);
	generate_random_vector(e, 10, 100);
	printf_vector(f, 10);
	printf_vector(e, 10);

	//find_same(f,e,10);
	printf("\n-----------------\n");
	find_max(f, 10, pq);
	find_max(e, 10, qq);
	swap(pq, qq);
	//printf("%d %d\n",n,num);
	printf("\n-----------------\n");

	printf_vector_in_addr(f,10);
	printf_vector_in_addr(e,10);
	//printf_vector(f, 10);
	//printf_vector(e, 10);
	//printf("\n-----------------\n");
	//inverse(f,9);
	//printf_vector(e,10);
	//printf("%d\n", 5/2);	
	system("pause");
	return 0;

}
