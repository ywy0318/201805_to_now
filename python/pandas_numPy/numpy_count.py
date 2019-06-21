#numpy统计函数
#numpy提供了很多统计函数,用于从数组中查找最小元素，最大元素，百分位标准差和方差
#numpy.amin和numpy.amax()
#numpy.amin()用于计算数组中的元素沿着指定轴的最小值
#numpy.amax()用于计算数组中的元素沿着指定轴的最大值
import numpy as np 
a=np.array([[3,7,5],[8,4,3],[2,4,9]])
print(a)
print(np.amin(a,1))
print(np.amin(a,0))#axis=0表示纵向
print(np.amax(a))
print(np.amax(a,axis=0))

#numpy.ptp()计算数组中元素最大值与最小值的差(最大值-最小值)
print(np.ptp(a))
print(np.ptp(a,axis=1))#axis=1直接看[],[],axis=1的时候,直接一个[],一个[]的考虑
print(np.ptp(a,axis=0))
'''
numpy.percentile()
百分位数是统计中使用的度量,表示小于这个值的观察值的百分比,
函数numpy.percentile(a,q,axis)
a:输入数组
q:要计算的百分位数,在0-100之间
axis:表示沿着它计算百分位数的轴

首先明确百分位数:


'''
b=np.array([[10,7,4],[3,2,1]])

print('\nb')
print(b)
#50%的分数位，就是b里排序之后的中位数--比较迷看不懂
print(np.percentile(b,50))
#axis=0,在纵列上求
print(np.percentile(b,50,axis=0))
#axis=1,在横轴上求
print(np.percentile(b,50,axis=1))
#保持维度不变
print(np.percentile(b,50,axis=1,keepdims=True))

#numpy.median()计算数组a元素的中位数
c=np.array([[30,65,70],[80,95,10],[50,90,60]])
print(c)
print(np.median(c))
print(np.median(c,axis=0))
print(np.median(c,axis=1))

#numpy.mean()函数返回数组中元素的算术平均值,如果提供了轴，沿轴计算
#算术平均值是沿轴的元素的综合除以元素的数量
d=np.array([[1,2,3],[3,4,5],[4,5,6]])
print(np.mean(d))
print(np.mean(d,axis=0))
print(np.mean(d,axis=1))

#numpy.average()函数根据在另一个数组给出的各自权重计算数组中元素的加权平均值
#该函数可以接受一个轴参数,如果没有指定轴,则数组会被展开
#加权平均值即将个数组乘以相应的权数,然后加总求和得到总体值,再除以总的单位数
#考虑数组[1,2,3,4]和相应的权重[4,3,2,1],通过将相应元素的乘机相加
#并将和除以权重的和,来计算加权平均值
#多维数组中，可以指定用于计算的轴

e=np.array([1,2,3,4])
print(e)
print(np.average(e))
weights_1=np.array([4,3,2,1])
print(np.average(e,weights=weights_1))
#如果 returned 参数设为 true，则返回权重的和  
print(np.average([1,2,3,4],weights=[4,3,2,1],returned=True))
#标准差
'''
标准差是一组数据平均值分散程度的一种度量
标准差是方差的算术平方根
标准差公式如下:std=sqrt(sum((x-x.mean())**2)
'''
print(np.std([1,2,3,4]))
'''
方差
统计中的方差(样本方差)是每个样本值与全体样本值的平均数之差
的平方值的平均数,即mean((x-x.mean())**2)
'''
print(np.var([1,2,3,4]))