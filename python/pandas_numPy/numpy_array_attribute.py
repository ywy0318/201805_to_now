#Numpy array信息获取

import numpy as np 
import sys 
a=np.array([[1,2,3],[4,5,6]])

print(a)
#
print(a.shape)
#a.shape=(3,2)和a.reshape(3,2)效果一样
#print(a)

#ndarray对象元素的个数,
print(a.size)

#ndarray.ndim轴的数量
print(a.ndim)

#itemsize 每个元素的大小,以字节为单位
print(a.itemsize)

#dtype ndarray对象的元素类型
print(a.dtype)

#ndarray对象的内存信息
print(a.flags)
'''
  C_CONTIGUOUS : True #数组位于单一的 C风格的连续区段内
  F_CONTIGUOUS : False  #数组位于单一的Fortran风格的连续区段内
  OWNDATA : True    #数组的内存从其他对象处借用
  WRITEABLE : True  #数组的区域可写入，设置为False,会锁定数据，使其只读
  ALIGNED : True    #数据和任何元素会为硬件适当对齐
  WRITEBACKIFCOPY : False   
  UPDATEIFCOPY : False  #这个数组是另外一个数组的副本，当这个数组释放时，源数组会由这个数组中的元素更新
'''
#最大最小值
#获取矩阵中元素最大最小值的函数分别是max和min，可以获得整个矩阵，行，或列的最大最小值
print(a.max())#最大值
print(a.min())#最小值

#axis=0行方向最大值，即获得每列的最大值;若axis=1,则获得列方向最大值,即获得每行的最大值
print(a.max(axis=0))

#获得每行的最小值
print(a.min(axis=1))

#最大值元素所在的位置
print(a.argmax(axis=1))

#获得矩阵中元素的平均值可以通过函数mean().同样的，可以获得整个矩阵，行或列的平均值
#获得所有元素的平均值
print(a.mean())

#行方向的平均值,每列的平均值
print(a.mean(axis=0))

#加权平均值numpy.average()
#是由每个分量乘以反应其重要性的因子得到的平均值，numpy.average()函数根据在另一个数组
#中给出的各自的权重计算数组中元素的加权平均值，该函数可以接受一个轴参数
#如果没有指定轴，则数组会被展开,

#如果不指定权值，则和平均值mean()效果一样
print(np.average(a))

#返回加权平均值
print(np.average(a,weights=[[1,2,3],[3,2,1]]))

#返回加权平均值和权重的和
print(np.average(a,weights=[[1,2,3],[3,2,1]],returned=True))

#中值numpy.median()
#中值定义为将数据样本由小到大排序，取最中间的那一个,如果中间的数字有两个,取他们的平均值

print(np.median(a))

#方差和标准差
#方差是偏差的平方的平均值,即mean((x-x.mean)**2),标准差是方差的平方根
#a中所有元素的方差
print(a.var())

#a.所有元素的标准差
print(a.std())

#a行方向,每列的方差
print(a.var(axis=0))

#a列方向,每行的标准差
print(a.std(axis=1))


#求和与个数统计
#sum()对行,列或整个矩阵求和
print(a.sum())

print(a.sum(axis=0))

print(a.sum(axis=1))

#numpy.sum()可用于求和，下面的方法是个数统计
#计算a中等于1的元素个数
print(np.sum(a==1))

#计算a中大于4的元素个数
print(np.sum(a>4))


