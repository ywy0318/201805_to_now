#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#include<conio.h>
struct student
{
	int num;
	char name[20];
	int score;

};
int main()
{
	int i = 0;
	int m = 0;
	int maxscore;
	struct student st[5] = 
	{
		{70710,"asd",90},
		{70711,"asx",89},
		{70712,"sddd",77},
		{70713,"sss",55},
		{70714,"ssd",66}
	};
	maxscore = st[0].score;
	for (i = 0; i < 5; i++)
	{
		if (maxscore < st[i].score)
		{
			maxscore = st[i].score;
			m = i;
		}
		
	}
	printf("%d %s %d\n",st[m].num,st[m].name,st[m].score);









	system("pause");
	return 0;
}