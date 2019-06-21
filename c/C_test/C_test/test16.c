/*任意数据的任意次方*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>

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
	int m, n;
	int ret;
	int min;
	double s, x, y;
	int i = 0;
	srand(time(0));
	m = rand()%5+2;
	n = rand()%5+2;
	printf("%d\n", m);
	printf("%d\n", n);
	//isprime_self(m);
	//s = sqrt(5);
	//printf("%lf\n", sqrt(4.0));
	//printf("%lf\n", sqrt(5));
	//y = modf(s, &x);
	//printf("%lf\n", x);
	//printf("%lf\n", y);
	for (i = 0; i < 5; i++)
	{
		ret=cifang(m, n+i);
		printf("%d\n", ret);
	}
	

	system("pause");
	return 0;

}