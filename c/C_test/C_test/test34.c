/*产生10个不同的随机数函数*/
/*特殊的完全平方数*/
/*一数三平方*/
/*穷举法，设定好条件，用循环找出满足条件的值,找到满足条件的值以后，保存到变量中*/
/*自守数*/
/*亲密数*/
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


int main() {
	int i = 0;
	int m = 0;
	int ret;
	int f[100] = { '0' };
	int n = 0,j=0;
	int c;
	int power;
	int a,b,d;
	int A,B,C,D;
	int num;
	int p[40] = {'0'};
	float h[11] ;
	float high = 0;
	int sum[10000] = {'0'};
	int k=0;

	for (i = 1; i < 10001; i++)
	{
		for (j = 1; j < i; j++)
		{
			if ((i%j) == 0)
			{
				sum[i] += j;
			}
		}
		if ((i == 220) || (i == 284))
		{
			//printf("%d?? ", sum[i]);
		}
	}
	printf("\n");
	for (i = 0; i < 10000; i++)
	{
		for (k= i; k < 10001; k++)
		{
			if (i == sum[k])
			{
				if (k == sum[i])
				{
					if (i != k) {
					printf("%d  %d",i,k);
					printf("\n");

					}
					
				}
			}
		}
	}
	printf("\n");

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
	for (i = 0; i < 10001; i++)
	{
		num = i*i;
		a = num % 10000;//四个,a==i;
		b = num % 1000;//san个；b==i||b==i%1000
		c = num % 100;//2;c==i||c==i%100
		d = num % 10;//1;d==i||d==i%10;
		if ((d == i) || (c == i) || (b == i) || (a == i))
		{
			//printf("%d ",i);
		}

	}

	h[0] = 100.00;
	for (i = 0; i < 11; i++)
	{
		h[i + 1] = h[i] / 2;
		high += h[i];
		//printf("%d %2f  .",i,h[i] );
		
	}
	for (a = 1; a < 7; a++)
	{
		for (b = 1; b < 5; b++)
		{
			if ((a * 4 + b * 6) == 26)
			{
				if (a*(a + b)*(a + b + b)*(a + b + b + b) == 880)
				{
					A = a;
					B = b;
					//printf("%d %d\n",a, b);

				}
			}
		}
	}
	
	p[0] = A;
	//printf("%d %d\n", p[0], B);
	printf("after shell \n");

	for (i = 1; i < 20; i++)
	{
		p[i] = p[i-1] + B;
		//printf("%d %d\n ",i,p[i]);
	}




	for (i = 1; i < 32; i++)
	{
		p[i - 1] = i*i;
		power = i*i;
		a = power / 100;
		b = power / 10 % 10;
		c = power % 10;
		//printf("%d  ", p[i-1]);
		if ((a == b) || (b == c) || (a == c))
		{
			//printf("%d ", power);
		}
		if (i % 3 == 2)
		{
			//
		}
	}
	printf("\n");
	//printf("%2f \n",high*2-100);
	printf("after shell \n");
	
	for (i = 317; i < 1000; i++)
	{
		num = i*i;
		for (m = 0; m < 31; m++)
		{
			for (n = 0; n < 31; n++)
			{
				if (num == (p[m] * 1000 + p[n]))
				{
					//printf("%d\n",num);
					A += 1;
				}
			}
		}
		
	}
	 
	//printf_vector(f, 10);
	printf("%d\n", A);

	system("pause");
	return 0;

}
