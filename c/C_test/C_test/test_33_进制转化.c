/*isalpha*/
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
void h_c(int num, int N)//10进制转化成其他进制
{
	int i = 0;
	int d[16] = {0};
	//int shang, yu;
	for (i = 0; i < 16; i++)
	{
		d[i] = num%N;
		num = num / N;
		if (num == 0)
		{
			break;
		}		
	}
	for (i = 0; i < 16; i++)
	{
		printf("%d", d[15 - i]);
		if ((i % 4)==3)
		{
			printf("\40");
		}
	}
	printf("\n");
}
/*将8进制数字或者16进制数组转化为十进制数字*/
/*num  */
void c_h(int num, int N)
{
	int sh=0;
	int i = 0;
	int temp=num;
	int d[16] = { 0 };
	for (i = 0; i < 16; i++)
	{
		d[i] = temp% 10;
		temp = temp / 10;
		//printf("%d ,%d\n",d[i],num);
		sh+=pow(N, i)*d[i];
	}
	printf("%d is %d is %d\n", num, N, sh);
}


int main() {
	int i = 0;
	int m = 0;
	int ret;
	int f[100] = { '0' };
	int d[10];
	int n = 0;
	int  z[2] = { 'F','E' };
	int c;
	//int hex = 0666;
	//int Hex = 0x666;
	int num;
	d[0] = 1024;
	for (i = 0; i < 10;)
	{
		ret = rand() % 10 + 1;
		for (m = 0; m < i; m++)
		{
			if (f[m] == ret)
			{
				break;
			}
		}
		if (m == i)
		{
			f[i] = ret;
			i += 1;
		}
	}

	for (i = 1; i < 10; i++)
	{

		d[i] = d[i - 1] / 2;
	}
	printf("%d\n",z[0]);
	//printf("after shell \n");
	printf_vector(d, 10);
	//system("cls");
	printf("after shell \n");
	h_c(12, 2);
	h_c(100, 8);
	h_c(100, 16);
	h_c(100,2);

	c_h(567, 8);
	c_h(567, 16);
	//num = 1;
	//printf("%d\n",num);
	//printf_vector(f, 10);


	system("pause");
	return 0;

}
