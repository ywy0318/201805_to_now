#列表切片操作60行
import numpy as np 
import sys 
#列表推导式
print('\n')
f=[x for x in range(10)]
print(f)
print(f[-1])
print(f[:])#从左往右
print(f[::])#从左往右
print(f[::-1])#从右往左

#3.>#start_index和end_index全为正（+）索引的情况

#step=1,决定了从左往右取值，start_index=1,和end_index=6同样表示从左往右取值
print(f[1:6])#[1,2,3,4,5,6]

#step=-1,决定了从右往左取值，而start_index=1到end_index=6决定了从左往右取值，两者矛盾，所以为空
print(f[1:6:-1])#[]

#step=1,决定了从左往右取值，而start_index=6而end_index=1决定了从右往左取值，两者矛盾，所以为空
print(f[6:1])#[]

#step=1,从左往右取值，从'起点'开始一直取到end_index=6
print(f[:6])#[0,1,2,3,4,5]

#step=-1,从右往左取值，从'终点'开始一直取到end_index=6
print(f[:6:-1])#[9,8,7]

#step=1,从左往右取值，从start_index=6开始一直取到终点
print(f[6:])#[6,7,8,9]

#step=-1,从右往左取值，start_index=6开始，一直取到起点
print(f[6::-1])#[6,5,4,3,2,1,0]

#4.> start_index和end_index全为负（-）索引的情况

#step=1,从左往右取值，而start_index=-1到end_index=-6决定了从右往左取值，两者矛盾
#索引-1在-6的右边
print(f[-1:-6])#[]

#step=-1,从左往右取值，而start_index=-1到end_index=-6决定了从右往左取值，两者矛盾
#索引-1在-6的右边
print(f[-1:-6:-1])#[9,8,7,6,5]

#step=1,从左往右取值，而start_index=-6到end_index=-1同样是从左往右取值
print(f[-6:-1])#[4,5,6,7,8]

#从step=1,从左往右取值，从'起点'开始一直取到end_index=-6
print(f[:-6])#[0,1,2,3]

#step=-1,从右往左取值，从终点开始一直取到end_index=-6
print(f[:-6:-1])#[9,8,7,6,5]

#step=1,从左往右取值，从start_index=-6开始，一直取到'终点'
print(f[-6:])#[4,5,6,7,8,9]

#step=-1,从右往左取值，从start_index=-6开始，一直取到'起点'
print(f[-6::-1])#[4,3,2,1,0]

#5.> start_index和end_index正(+)负(-)混合索引的情况

#start_index=1在end_index=-6的左边,因此从左往右取值，
#而step=1同样决定了从左往右取值,
print(f[1:-6])#[1,2,3]

#start_index=1在end_index=-6的左边，因此从左往右取值，
#但是step=-1则决定了从右往左取值，
print(f[1:-6:-1])#[]


#start_index=-1在end_index=6的右边,因此从右往左取值,
#但是step=1,决定了从左往右取值,矛盾
print(f[-1:6])#[]

#start_index=-1在end_index=6的右边,因此从右往左取值，
#step=-1同样决定了从右往左取值，
print(f[-1:6:-1])#[9,8,7]


#6.>连续切片操作
print(f[:8][2:5][-1:])#[4]
#f[:8]=[0,1,2,3,4,5,6,7]
#f[:8][2:5]=[2,3,4]
#f[:8][2:5][1:]=4
#理论上可以无限次连续切片操作，只要上一次返回的依然是非空可切片对象

#7.>切片操作的三个参数可以用表达式
print(f[2+1:3*2:7%3])#相当于f[3:6:1]=[3,4,5]

#8.>其他对象的切片操作
#元祖的切片操作
print((0,1,2,3,4,5)[:3])#(0,1,2)
#字符串的切片操作
print('ABCDEFG'[::2])#'ACEG'

#利用range函数生成1-99的整数,然后取3的倍数，再去最后10个
for i in range(1,100)[2::3][-10:]:
    print(i)


print("\n")

#取偶数位置
print(f[::2])#[0,2,4,6,8]
#取奇数位置
print(f[1::2])#[1,3,5,7,9]

#3.>拷贝整个对象
#需要注意的是:[:]和.copy()都属于'浅拷贝',
#只拷贝最外层元素,内层嵌套元素则通过引用，而不是独立分配内存
print('copy')
a=f[:]
b=f.copy()
print(a)
print(b)
print(id(f))
print(id(a))
print(id(b))


b[:]=sorted(b[:],reverse=True)#reverse=True降序,reverse = False 升序(默认)
print('\n')
print(b)
#替换偶数位置上的元素为3(两个元素个数必须一样多)
#b[::2]=[3]*4

#偶数下标的元素升序，奇数下标的元素保持不动
b[::2]=sorted(b[::2])

print(b)
print('\n')

c=[1,2,['A','B']]
print('c={}'.format(c))
d=c[:]
d[0]=9#修改d的最外层元素，将1变成9
d[2][0]='D'#修改d的内嵌层元素,修改内部元素以后，c中的A也变成了D,说明共享内部嵌套元素,但是外部元素没有变
print('c={}'.format(c))
print('d={}'.format(d))
print('id(c)={}'.format(id(c)))
print('id(d)={}'.format(id(d)))


#4.>修改单个元素
f[1]=['a','b']#将index=1的那个值替换掉了
print(f)

#5.>在某个位置插入元素
f[3:3]=['D','F','G']#[0, ['a', 'b'], 2, 'D', 'F', 'G', 3, 4, 5, 6, 7, 8, 9]
print(f)

f[0:0]=['R','T']#['R', 'T', 0, ['a', 'b'], 2, 'D', 'F', 'G', 3, 4, 5, 6, 7, 8, 9]
print(f)