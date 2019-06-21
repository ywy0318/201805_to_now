/**/
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
	char l[100];
	char *p[5];
	int i = 0;
	p[0] = "asd";
	p[1] = "qwe";
	p[2] = "zxc";
	p[3] = "fgh";
	p[4] = "vbn";

	scanf("%s",l);
	for (i = 0; i < 5; i++)
	{
		printf("%s\n",p[i]);
	}
	printf("%s\n", l);



	system("pause");
	return 0;
}