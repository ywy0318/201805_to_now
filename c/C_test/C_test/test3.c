/*不填充的正方形*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main()
{
	int n = 0, m = 0;
	for (m = 0; m < 5; m++)
	{
		for (n = 0; n < 5; n++)
		{
			if (m == 0 || m == 4 || n == 0 || n == 4)
			{
				printf("* ");
			}
			else
			{
				printf("  ");
			}
			
		}
		printf("\n");
	}
	
	system("pause");
	return 0;
}