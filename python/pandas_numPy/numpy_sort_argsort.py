"""
Numpy排序，条件刷选函数
numpy提供了多种排序的方法,这种排序函数实现不同的排序算法,
每个排序算法的特征在于执行速度,最坏情况性能，所需的工作空间
和算法的稳定性,

quicksort(快速排序)--速度(1)--最坏情况(O(n^2))---工作空间(0)---稳定性(否)
mergesort(归并排序)--速度(2)--(O(n*log(n)))---~n/2--是
heapsort(堆排序)---3--(O(n*log(n)))---0--否

numpy.sort()函数返回输入数组的排序副本,
numpy.sort(a,axis,kind,order)
a:要排序的数组
axis:沿着它排序数组的轴
kind:默认为'quicksort'
order:如果数组包含字段,则是要排序的字段

"""
import numpy as np 
a=np.array([[3,7],[9,1]])
print(a)
print(np.sort(a))
print(np.sort(a,axis=0))
print(np.sort(a,axis=1))

dt=np.dtype([('name','S10'),('age',int)])
b=np.array([('raju',21),('anli',23),('bavi',22),('dmar',24)],dtype=dt)
print(b)

print(np.sort(b,order='name'))
print(type(b))


#numpy.argsort()函数返回的是数组值从小到大的索引值

c=np.array([3,1,2])
print(c)
d=np.argsort(c)
print(d)

#以排序后的顺序重构原数组
print(c[d])
print('\n')
for i in d:
    pass
    print(c[i],end=" ")

print('\n---')

"""
numpy.lexsort()
用于对多个序列进行排序,把它想象成对电子表格进行排序,每一列代表一个序列,排序时优先照顾靠后的列
应用场景:小升初,重点班录取学生按照总成绩录取，在总成绩相同的时候,
"""

e_lessort=('raju','anili','bilibili','cilicli')
f_dv=('f.y.','s.y.','s.y.','f.y.')
#上面传入np.lexsort的是tuple,排序时,先排序e_lessort,
index=np.lexsort((f_dv,e_lessort))
print(index)
#使用这个索引来获取排序后的数据:
print([e_lessort[i]+","+f_dv[i] for i in index])

print('----')
'''
msort,sort_complex,partion,argpartition
msort(a)---数组按第一个轴排序,返回排序后的数组副本,np.msort(a)相当于np.sort(a,axis=0)
sort_complex(a)---对复数按照先实部后虚部的顺序进行排序
partition(a,kth[,axis,kind,order])---制定一个数,对数组进行区分
argpartition(a,kth[,axis,kind,order])---可以通过关键字指定算法沿着指定轴对数组进行分区

'''

print(np.sort_complex([5,3,6,2,1]))
print(np.sort_complex([1+2j,2-1j,3-2j,3-3j,3+5j]))

print('----')

#partition()分区排序,更像是分区筛选,
g=np.array([3,4,2,1,5,6,7,8,9,0])
#将数组a中所有元素(包含重复元素),从小到大排列,比第三小的放在前面,大的放在后面
print(np.partition(g,3))
#小于1的在前面，大于3的在后面,1和3之间的在中间
print(np.partition(g,(3,6)))

#找到数组的第3小(index=2)的值和第2大的值(index=-2)
print(np.argpartition(g,2)[2])
print(np.argpartition(g,-2)[-2])

#同时找到第3小和第4小的值,用[2,3]同时将第3和第4小的排序好,然后通过下标[2][3]取到
print(g[np.argpartition(g,[2,3])[2]])
print(g[np.argpartition(g,[2,3])[3]])

#numpy.argmax()和numpy.argmin()
#两个函数分别沿给定轴返回最大和最小元素的索引
h=np.array([[30,40,70],[80,20,10],[50,90,60]])
print("\n")
print(h)
print(np.argmax(h))
print('h.flatten()')
print(h.flatten())
print(h.flatten().shape)
print(h.shape)

print('---np.argmax')
print(np.argmax(h,axis=0))
print(np.argmax(h,axis=1))

print("no.argmin")
print(np.argmin(h,axis=0))
print(np.argmin(h,axis=1))
print(np.argmin(h))
print(h.flatten()[np.argmin(h)])

#numpy.nonzero()函数返回输入数组中非零元素的索引
print('numpy.nonzero')
g=np.array([[30,40,0],[0,20,10,],[50,0,60]])
print(g)

print(np.nonzero(g))
print('\n')
print(np.nonzero(np.array([10,20,30,0,4])))

print('np.where()')
#numpy.where()函数返回值输入数组中满足给定条件的元素的索引
i=np.arange(9.).reshape(3,3)
print(i)
j=np.where(i>3)
print(j)
print(i[j])

print('numpy.extract()')
#numpy.extract()函数根据某个条件从数组中抽取元素,返回满足条件的元素
k=np.arange(9.).reshape(3,3)
print(k)

#定义条件,选择偶数
condition=np.mod(k,2)==0
print(condition)

print(np.extract(condition,k))

