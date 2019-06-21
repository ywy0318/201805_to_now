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
	union wo
	{
		char ch[4];
		int num;
	};
	union wo word;
	int length;
	int i = 0;
	word.num = 0x12345678;

	printf("%x\n",word.num);
	printf("sizeof is %d\n",sizeof(word));

	for (i = 0; i < 4; i++)
	{
		printf("%x ",word.ch[i]);
	}
	printf("\n");
	word.ch[0] = 'a';
	//word.ch[1] = 'b';
	//word.ch[2] = 'c';
	//word.ch[3] = 'd';
	printf("%x\n", word.num);







	system("pause");
	return 0;
}