'''
numpy矩阵库(Matrix)

numpy 中包含了一个矩阵库numpy.matlib,该模块中的函数返回的事一个矩阵,
而不是ndarray对象
一个M*N的矩阵是一个由m行(row)n列(column)元素排列成的矩形阵列
矩阵里的元素可以是数字，符号或数学式,以下是一个由6个元素构成的2行3列的矩阵;
[1 9 -13]
[20 5 -6]

matlib.empty()函数返回一个新的矩阵,语法格式
numpy.matlib.empty(shape,dtype,order)
shape:定义新矩形形状的整数或整数元祖
Dtype:可选，数据类型
order:C(行序优先)或者F(序列优先)

'''
import numpy as np 
import numpy.matlib 
#填充为随机数据
print(np.matlib.empty((2,2)))
print(np.matlib.zeros((2,2)))
print(np.matlib.ones((2,2)))

#numpy.matlib.eye()函数返回一个矩阵,对角元素为1,其他位置为0
#numpy.matlib.eye(n,M,K,dtype)
#n:返回矩阵的行数;M:返回矩阵的列数,默认为n;K:对角线的索引;dtype:数据类型
print(np.matlib.eye(n=3,M=3,k=0,dtype=float))


'''
numpy.matlib.identity()函数返回给定大小的单位矩阵
单位矩阵是个方阵,
'''
print(np.matlib.identity(5,dtype=float))


'''
numpy.matlib.rand()函数创建一个给定大小的矩阵,数据是随机填充的
'''
print(np.matlib.rand(3,3))
#矩阵总是二维的,ndarray是一个n维数组,两个对象都是可互换的
a=np.matrix('1,2;3,4')
print(a)

print(np.asarray(a))
print(np.asmatrix(a))