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
	enum week
	{
		Sunday,
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday
	};
	//int day;
	for (size_t i = 8; i >0; i--)
	{
		printf("%d\n",i);
		switch (i)
		{
		case Monday:
			printf(" 1:Monday");
			break;
		case Tuesday:
			printf("2: Tuesday");
			break;
		case Wednesday:
			printf("3:Wednesday");
			break;
		case Thursday:
			printf("4:Thursday");
			break;
		case Friday:
			printf("5:Friday");
			break;
		case Saturday:
			printf("6 :Saturday");
			break;
		case Sunday:
			printf("7:Sunday");
			break;
		/*default:
			printf("fault");*/
		}
		printf("\n--\n");
	}
	








	system("pause");
	return 0;
}