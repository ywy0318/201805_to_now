#define _CRT_SECURE_NO_WARNINGS
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
#include<windows.h>
#include<conio.h>

//构建动态数组
//遵循原则
//申请的时候从外层往里层,逐层申请;
//释放的时候从内层往外层,逐层释放
//构建所需指针
//构建一维动态数组,需要一维数组
//构建二维，则需要一维二维指针
//三维需要一二三维指针
//构建所需函数
/*
void *malloc(unsigned int size)
成功：返回所开辟的首地址,失败返回空指针
想内存申请size个字节的堆空间

规定为void*类型，这并不是说该函数调用后无返回值,
而是返回一个节点的地址，该地址的类型为void(无类型或者类型不确定),
即一段存储区的首地址，其具体类型无法确定，只有使用时根据各个阈值数值在确定
可以用强制转换的方法将其转换为别的类型；
例如:double *pd=NULL;pd=(double *)calloc(10,sizeof(double));
表示将向系统申请10个连续的double类型的存储空间,
并用指针pd,指向这个连续的空间首地址,
并且用(double)对calloc()的返回类型进行转换,以便把double类型
数据的地址赋值给指针pd

使用sizeof的目的是用来计算一种类型的占有的字节数，以便适合不同的编译器
由于动态分配不一定成功,为此要附加一段异常处理程序,不致程序运行失败，
使用户不知所措,通常采用这样的异常处理程序段
if(p==NULL)
//if(!p)
{
	printf("动态申请内存失败\n");
	exit(1);
}
这4个函数头文件均包含在中
分配的堆空间没有名字，只能通过返回的指针找到它;
绝不能对得动态分配存储块使用free,也不能对
同意内存区同时用free释放两次;例如:free(p);free(p)
调用free()时,传入指针指向的内存被释放,但调用函数的指针值可能
保持不变,因为p是作为形参而传递给函数,严格的讲,被释放的指针值是无效的,
因为它已不再指向所申请的内存区,这时对它的任何使用便可能会带来问题


malloc与calloc的区别
对于用malloc分配的内存区间,如果原来没有被使用过,则其中的每一位可能都是0,
反之,如果这部分内存空间曾经被分配,释放和重新分配,则其中可能遗留各种各样的数据;
也就是说,使用malloc()函数的程序开始时(内存空间还没有被重新分配)能正常运行,
但是过一段时间后(内存空间已经被重新分配)可能会出现问题;因此在使用前必须先进性初始化
(memset函数对其初始化为0),但调用calloc函数分配到的空间分配时就已经被初始化为0;
当你在calloc()函数之间做选择时,你需要考虑是否要初始化所分配的内存空间,
从而选择相应的函数

void *calloc(unsigned int num,unsigned int size)
成功:返回所开辟空间首地址,失败：返回空指针
按照类型申请size个字节的堆空间

void free(void *p)
无返回值，释放p指向的堆空间

void *realloc(void *p,unsigned int size)
成功:返回新开辟空间首地址,失败:返回空指针;
将p指向的堆空间变为size


具体构建方法:
以三维整型数组array[n1][n2][n3]为例
先遵循从外层到里层,逐层申请的原则
最外层指针是array,它是个三维指针,所指向的是array[],
其为二维指针,所以给array
申请内存应:
array=(int**)calloc(n1,sizeof(int**))
次层指针是array[],它是个二维数组,所指向的事array[][],其为一维数组
所以给array[]
申请内存应:
for(i=0;i<n1;i++)
{
	for(j=0;j<n2;j++)
	{
		array[i][j]=(int*)calloc(n3,sizeof(int));
	}
}

*/

void array_1()
{
	int i=0;
	int n1=10;
	int *array_1=(int *)calloc(n1,sizeof(int));
	printf("before:");
	for(i=0;i<n1;i++)
	{		
		printf("%d\n",array_1[i]);
	}
	printf("after\n");
	for(i=0;i<n1;i++)
	{
		array_1[i]=i+1;
		printf("%d\n",array_1[i]);
	}
	free(array_1);//释放一维数组
	return ;
}


void array_2()
{
	int n2=4;
	int n3=5;
	int i=0,j=0;
	int **array_2;
	//array_2=(int **)calloc();
	array_2=(int **)malloc(n2*sizeof(int*));//第一维

	for(i=0;i<n2;i++)
	{
		array_2[i]=(int *)malloc(n3*sizeof(int));//第二维
	}

	for(i=0;i<n2;i++)
	{
		for(j=0;j<n3;j++)
		{
			array_2[i][j]=i*n2+j+1;
			printf("%d\t",array_2[i][j]);
	    }
		printf("\n");
	}
	for(i=0;i<n2;i++)
	{
		free(array_2[i]);//释放第二维指针
	}
	free(array_2);
	return ;
}

void array_3()
{
	int n1=5,n2=4,n3=3;
	int ***array_3;
	int i=0,j=0,k=0;
	printf("%d\n",sizeof(int**));
	array_3=(int ***)malloc(n1*sizeof(int **));//第一维
	for(i=0;i<n1;i++)
	{
		array_3[i]=(int**)malloc(n2*sizeof(int *));//第二维
		for(j=0;j<n2;j++)
		{
			array_3[i][j]=(int *)malloc(n3*sizeof(int));//第三维
		}
	}
	printf("::\n");
	for(i=0;i<n1;i++)
	{
		for(j=0;j<n2;j++)
		{
			for(k=0;k<n3;k++)
			{
				array_3[i][j][k]=i+j+k+1;
				printf("%d\t",array_3[i][j][k]);
			}
			printf("\n");
		}
		printf("\n");
	}
	printf("free\n");
	for(i=0;i<n1;i++)
	{
		for(j=0;j<n2;j++)
		{
			free(array_3[i][j]);//释放第三维指针
		}
	}
	for(i=0;i<n1;i++)
	{
		free(array_3[i]);//释放第二维数组
	}
	free(array_3);//释放第一维数组
	return;

}

int main()
{	
	/*int i,j,k;
	int n1=3;
	int n2=3;
	int n3=3;
	int *array_auto;
	array_auto=(int *)calloc(n1,sizeof(int));*/


	//array_1();
	//array_2();
	array_3();

	system("pause");
	return 0;
}