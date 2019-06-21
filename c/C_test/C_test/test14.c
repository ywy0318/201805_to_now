/*ÅĞ¶ÏÊÇ·ñÎªËØÊı*/
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
				printf("%d,NO!",i);
				//break;
				return 0;
			}
		
			
		}
	
}
int main()
{
	int m, n;
	int ret;
	int min;
	int i = 2;
	srand(time(0));
	m = rand();
	//srand(time(0));
	n = rand();
	printf("%d\n",m);
	isprime_self(m);
	//ret = isprime(m);

	if (n)
	{
		printf("YES!");
	}
	else
	{
		printf("NO!");
	}
	printf("%lf\n",sqrt(4.0));
	printf("%lf\n", sqrt(5));
	system("pause");
	return 0;

}