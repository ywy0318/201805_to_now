/*(*(a+1)+1) a[1][1]*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>
int main()
{
	int i = 0;
	int j = 0;
	int a[3][4] = { {0,1,2,3},{4,5,6,7},{8,9,10,11}};
	for (i = 0; i < 3; i++) 
	{
			for (j = 0; j < 4; j++)
		{
			printf("%d ,%d ,%d  ,0x%x\n",i,j,a[i][j], &a[i][j]);
		}
			printf("\n");
	}
	printf("%d ,%p ,%d ,%x,%x,%x", a[0][1], &a[0][1], *(a+0),*(a+1)+1, *(a + 1) + 2, a+2);










	system("pause");
	return 0;
}