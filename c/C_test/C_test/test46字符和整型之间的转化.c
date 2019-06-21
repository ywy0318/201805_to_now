/*产生10个不同的随机数函数*/
/*2147483647*/
/*printf("%d")
%d:有符号，32位
*/
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<dos.h>
#define NUM 10
#define RANG 100

void HexToStr(unsigned char val, unsigned char *str)
{
	//str[0]=_crol_(val,4) & 0xf;
	str[0] = (val & 0xf0) >> 4;
	str[1] = val & 0xf;
	if (str[0]>9) str[0] += 55; else str[0] += 48;
	if (str[1]>9) str[1] += 55; else str[1] += 48;
	//str[2]=0;
}//*/

 //high in str[0];
unsigned char StrToHex(unsigned char val, unsigned char *str)
{
	unsigned int i = 0;
	//str[0]=_crol_(val,4) & 0xf;
	if (str[0] >= '0'&&str[0] <= '9') str[0] = str[0] - '0';
	if (str[1] >= '0'&&str[1] <= '9') str[1] = str[1] - '0';
	if (str[0] >= 'a'&&str[0] <= 'f') str[0] = str[0] - 'a' + 10;
	if (str[1] >= 'a'&&str[1] <= 'f') str[1] = str[1] - 'a' + 10;
	if (str[0] >= 'A'&&str[0] <= 'F') str[0] = str[0] - 'A' + 10;
	if (str[1] >= 'A'&&str[1] <= 'F') str[1] = str[1] - 'A' + 10;
	i = str[0];
	i = (i << 4) + str[1];
	return (i);
}//*/

void chartoint(const char *st)
{
	int len;
	int num;
	len = strlen(st);
	printf("%s\n",st);
	int i = 0;
	for (i = 0; i < len; i++)
	{
		num = *(st+i)- '0';
		printf("%d",num);
	}
	//printf("st is %d\n", atoi(st));
}
void inttochar()
{


}


int main() {
	int i = 0;
	int m = 0;
	int ret;
	int f[1000];
	char e = 'f';
	int ee = 0xc;
	int ef = 0;
	char d[20] = "13821664252";

	char tel[15];
	char stel[15];
	int b=0xff;
	int  a=2147483647;
	int n = 0;
	srand(time(0));
	for (i = 0; i < NUM;)
	{
		ret = rand() % RANG + 1;
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

	//atoi(b);
	//ef = e - 55;


	_itoa(a, tel, 10);
	sprintf(stel,"%d",a);
    printf("tel:%s \n",tel);
    printf("stel :%s\n",stel);



	chartoint(d);

	//printf(" \n");
	//printf("");
	//printf("%d ,%d\n",e,ef);
	//printf("%c");
	//printf("sizeof %d\n",sizeof(long long));
	
	//printf("%d\n",a);
	//
	//printf("atoi:%d\n",atoi(d));
	//printf("min\n");
	for (n = 0; n < NUM; n++)
	{
		//printf("%d,%d\n", n, f[n]);
		//printf("%c:%c\n",tel[n],stel[n]);

	}
	system("pause");
	return 0;

}
