/*下标 0  1  2  3  4  5  6  7  8  9
数组 49 38 65 97 26 13 27 50 55 4 (原数组)
 
增量=5, [0]=49与[5]=13为一组,互换为 13 49 (排序是从小到大)
        [1]=38与[6]=27为一组,互换为 27 38 
        [2]=65与[7]=50为一组,互换为 50 65
        [3]=97与[8]=55为一组,互换为 55 97
        [4]=26与[9]=4 为一组,互换为 4 26
 
增量=5的排序结果是: 13 27 50 55 4 49 38 65 97 26
 
 
下标  0  1  2  3  4  5  6  7  8  9
数组  13 27 50 55 4  49 38 65 97 26 (第一趟之后)
 
增量=2, [0]=13,[2]=50,[4]=4,[6]=38,[8]=97为一组,
        互换之后,[0]=4,[2]=13,[4]=38,[6]=50,[8]=97
 
        [1]=27,[3]=55,[5]=49,[7]=65,[9]=26为一组,
        互换之后,[1]=26,[3]=27,[5]=49,[7]=55,[9]=65
 
增量=2的排序结果是: 4 26 13 27 38 49 50 55 97 65
 
 
下标  0  1  2  3  4  5  6  7  8  9
数组  4  26 13 27 38 49 50 55 97 65 (第二趟之后)
 
增量=1, 数组里的10个数据作为一组,其中,
        [1]=26有[2]=13互换为 13 26
        [8]=97与[9]=65互换为 65 97
 
增量=1的排序结果是: 4 13 26 27 38 49 50 55 65 97
 
 */
// C语言测试代码
// 希尔排序法 (自定增量)
#include <stdio.h>
#include <stdlib.h>
 
void printData(int data[],int n) //打印数组
{
    int i;
    for(i=0;i<n;i++)
    {
        printf("%d ",data[i]);
    }
    printf("\n");
}
 
//希尔排序(从小到大)
void shell(int data[],int count)
{
    int offset_a[3]={5,2,1}; //每一趟的增量
    int len;
    int pos;
    int offset;
    int i,j;
    int temp;
    len=sizeof(offset_a)/sizeof(int);
    for(i=0;i<len;i++)
    {
        offset=offset_a[i];
        for(j=offset;j<count;j++)
        {
            temp=data[j];
            pos=j-offset;
            while(temp<data[pos] && pos>=0 && j<=count)
            {
                data[pos+offset]=data[pos];
                pos=pos-offset;
            }
            data[pos+offset]=temp;
        }
        printf("增量=%d,排序结果: ",offset);
        printData(data,count);
    }
}
 
int main(void)
{
    int data[]={49,38,65,97,26,13,27,50,55,4};
    int count;
    count=sizeof(data)/sizeof(int);
    printf("原数组: ");
    printData(data,count);
 
    shell(data,count);
 
    printf("\n最后的排序结果: ");
    printData(data,count);
    return 0;
}