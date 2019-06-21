/*产生随机字符串函数*/
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
		
		if (i%10==9) 
		{
			printf("\n");
		}
	}
}

//产生n个不同的随机数，随机数范围从1-num;保存在d[]中;
int generate_random_vector(int d[],int n,int num)
{
	int i = 0;
	int ret;
	int m = 0;
	if (num < n)
	{
		printf("CAN not generate %d numbers\n",num);
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
void generate_string(unsigned char *string,unsigned int n)
{
	int i = 0;
	int ret;
	srand(time(0));
	for (i = 0; i < n; i++)
	{
		ret = rand() % 63;
		*string = allchar[ret];
		//printf("%c\n", allchar[ret]);
		string++;
	}
	*string='\0';
}

/*产生长度为n的随机字符串*/
char *generate_random_string(int n)
{
	int i = 0;
	int flag;
	char *string;
	srand(time(0));
	if ((string = (char*)malloc(n+1)) == NULL)
	{
		printf("malloc faild\n");
		return NULL;
	}
	for (i = 0; i < n ; i++)
	{
		flag = rand() % 3;
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

int main() {
	int i = 0;
	int m = 0;
	int ret;
	int f[100] = {'0'};
	int n = 0;
	int c;
	//char *str;//字符数组要初始化，generate_string不支持直接使用指针
	unsigned char str[62] = {'0'};//	
	generate_string(str,5);
	//str = generate_random_string(3);	
	//printf("%s\n",str);
	//printf("after shell \n");
	generate_random_vector(f,10,10);

	printf_vector(f, 10);
	//printf("%d\n", 5/2);	
	system("pause");
	return 0;

}
