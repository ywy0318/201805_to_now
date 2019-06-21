#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>




//将数据格式化输出到字符串。sprintf_s
int main()
{	
	char filename[200]={'\0'};
	char windows_name[200]={'\0'};
	int i=0;
	for(i=0;i<10;i++)
	{
		sprintf(filename,"E:\\sample\\neg\\n_s_%d.png",i);
		sprintf(windows_name,"NO.%d",i);
		printf("%s--%s\n",filename,windows_name);
		//memset(filename,'\0',sizeof(filename));
		//memset(windows_name,'\0',sizeof(windows_name));
		//filename="";
		//windows_name="";
	}
	sprintf(windows_name,"%s%d%c","test",1,'2');
	printf("%s\n",windows_name);
	system("pause");
	return 0;
}