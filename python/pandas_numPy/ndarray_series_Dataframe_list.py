#numpy的ndarray和pandas的Series和dataframe和list之间相互转化
#ndarray数组对象
'''
numpy中的ndarray是一个多为数组对象,该对象由两部分组成:
实际的数据;
描述这些数据的元数据;
大部分的数组操作仅仅修改元数据部分,而不改变底层的实际数据,
numpy数组一般是同质的(但有一种特殊的数据类型除外，它是异质的)
数组所有元素类型必须是一致的,
numpy提供的arange函数(start,stop,step,dtype=None)
步长参数为整数值
如果使用非整数的步长，可以考虑使用linspace函数,
通过reshape()函数将一维数组转化为多维数组
多维数组操作非常简单,参考list类型,对数组进行切片，访问
通过多维数组来标识异构的数据类型,
通过dtype类来定义数据类型对象stock,包括
日期，开盘价，收盘价，最高价，最低价，成交量
及股票编码信息

'''
import sys 
import numpy as np
from numpy import * 
from pandas import Series,DataFrame 

a=np.arange(10).reshape(2,5)
print(a)
print(type(a))
print(a[0,1])
print(a[0][1])
print(a[:,::2])#待续
print(a[:,:2])
print(a.shape)
print(a.dtype)
print(a.dtype.itemsize)#itemsize输出array元素的字节数


stock=dtype([
    ('date',str_,10),('open',float),('close',float),
    ('high',float),('low',float),('wolume',float),
    ('code',float)])
data=array([
    ('2019-04-16',11.53,11.69,11.70,11.51,990.0,'000001'),
    ('2019-04-17',12.01,11.23,11.54,11.22,888.0,'000001'),
    ('2019-04-16',11.55,11.66,11.77,11.58,999.0,'000001'),
    ('2019-04-17',12.05,11.26,11.57,11.27,889.0,'000001')],
    dtype=stock)
print(type(data))
print(data)

print("--\n")
#Series对象
"""
Series可以简单的被认为是一维的数组,Series和一维数组租主要的区别在
于Series类型具有索引index,Series致辞列表和字典创建，
"""
data_series=[
    ['2019-04-16',11.53,11.69,11.70,11.51,990.01,'000001'],
    ['2019-04-17',12.01,11.23,11.54,11.22,888.01,'000001'],
    ['2019-04-16',11.55,11.66,11.77,11.58,999.01,'000001'],
    ['2019-04-17',12.05,11.26,11.57,11.27,889.01,'000001']]

series=Series(data_series,index=['a','b','c','d'])
print(series)
arr=series.as_matrix()
print(arr)
print(arr.shape)

'''
DataFrame对象
DataFrame是将数个Series按列合并而成的二维数据结构，每一列单独取出来一个Series,
这和SQL数据库中取出的数据是很类似的,所以按列对一个DataFrame进行处理更为方便,
用户在编程时注意培养按列构建数据的思维;
DataFrame的优势在于可以方便的处理不同类型的列,因此，就不要考虑如何对一个
全是浮点数的DataFrame求逆之类的问题，处理这类问题还是把数据存成
Numpy的matrix类型比较便利一些

'''

data_frame=[
    [11.53,11.69,11.70,11.51,990.01,'000001'],
    [12.01,11.23,11.54,11.22,888.01,'000001'],
    [11.55,11.66,11.77,11.58,999.01,'000001'],
    [12.05,11.26,11.57,11.27,889.01,'000001']]
df=DataFrame(data_frame,index=['2019-04-16','2019-04-17','2019-04-18','2019-04-19'],
columns=['open','close','high','low','volume','code'])

print("df")
print(df)
print('-'*5)
print(df.as_matrix(['open','close']))
print('-'*5)
print(df.values)
print('-'*5)
print(array(df))
print('*'*5)
print(type(df))
#FutureWarning: Method .as_matrix will be removed in a future version. Use .values instead
print(type(df.as_matrix(['open','close'])))
print(type(df.values))
print(type(array(df)))
print('*'*5)
print(df['open'])#list做切片处理

'''
python中列表类型list
numpy中中的ndarray
'''
a=[1,2,3]
print(len(a))
#print(a.shape)list没有shape方法
print(a[1])
print(a+a)
print((a+a).__class__)
c=np.array([1,2,3])
print(len(c))
print(c.shape)
print(c[1])
print(c+c)
print((c+c).__class__)
'''
都可索引，
list加法：将后面的list数据加在前面的list上有点append的感觉
numpy可以像矩阵一样操作计算
'''

series_1=Series([11,22,33,44,55])
print(type(series_1))
print("series_1.reshape(-1,1)")
#print(series_1.reshape(-1,1))
#print(series_1.reshape(-1,1).shape)
#print(type(series_1.reshape(-1,1)))#'Series' object has no attribute 'reshape'
'''
reshape可以用于numpy库里的ndarray和array结构
以及pandas里面的dataFrame和Series结构
reshape(行,列)可以根据指定的数值将数据转化为特定的行数和列数
转换成矩阵
reshape(-1,1)和reshape(1,-1)
'''
print("\n")
print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
print("numpy.ndarray")
print("\n")
array_1=np.random.randn(12)
print(array_1)
print(array_1.shape)
print(type(array_1))

print("array_1.reshape(-1,1)")
print(array_1.reshape(-1,1))
print(array_1.reshape(-1,1).shape)
print(type(array_1.reshape(-1,1)))

print("array_1.reshape(1,-1)")
print(array_1.reshape(1,-1))
print(array_1.reshape(1,-1).shape)
print(type(array_1.reshape(1,-1)))

print("\n")
print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
print("numpy.array")

array_2=np.array([1,2,3,4,5,6,7,8])
print(array_2)
print(type(array_2))
print(array_2.shape)

print("np.array.reshape(-1,1)")
print(array_2.reshape(-1,1))
print(array_2.reshape(-1,1).shape)
print(type(array_2.reshape(-1,1)))

print("np.array.reshape(1,-1)")
print(array_2.reshape(1,-1))
print(array_2.reshape(1,-1).shape)
print(type(array_2.reshape(1,-1)))


print("\n")
print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
print("pandas.DataFrame")

#这样还是list[[],[],[]]
#DataFrame({'':[],'':[]})

data_frame_1=DataFrame({
    'A':[11.53,11.69,11.70,11.51,990.01,22],
    'B':[12.01,11.23,11.54,11.22,888.01,33],
    'C':[11.55,11.66,11.77,11.58,999.01,44],
    'D':[12.05,11.26,11.57,11.27,889.01,55]})

print(data_frame_1)
print(type(data_frame_1))
print(data_frame_1.shape)

print("pandas.DataFrame.reshape(-1,1)")
#print(data_frame_1.reshape(-1,1))
#print(data_frame_1.reshape(-1,1).shape)
#print(type(data_frame_1.reshape(-1,1)))

print("pandas.DataFrame.reshape(1,-1)")
#print(data_frame_1.reshape(1,-1))
#print(data_frame_1.reshape(1,-1).shape)
#print(type(data_frame_1.reshape(1,-1)))
print(data_frame_1.T)#转置

#---------------------------#
