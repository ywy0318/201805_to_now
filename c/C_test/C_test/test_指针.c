#include<stdio.h>
#include"string.h"
#include"stdlib.h"
int main()
{
	char *s = "sda";
	char *p = s;
	char st[5] = "wer";
	char *pt = st;
	int i = 0;
	//while ((*p) != '0')
	for(i=0;i<4;i++)
	{
		//printf("s=%p,p=%p *s=%c,,s+1=%c,s+2=%c,*p=%c\n",s,p,*s,*(s+1),*(s+2),*p);
		printf("st=%p,pt=%p *s=%c,,s+1=%c,s+2=%c,*pt=%c\n", st, pt, *st, *(st + 1), *(st + 2), *pt);
		pt += 1;
		//p += 1;
		//s += 1;
	}
	
	system("pause");
	return 0;
}