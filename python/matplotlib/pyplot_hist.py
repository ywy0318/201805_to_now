import pandas as pd
import numpy as np
import random
import matplotlib.pyplot as plt 
"""
matplotlib.pyplot.hist(x, bins=None, range=None, normed=False, weights=None, cumulative=False, bottom=None, histtype='bar', align='mid', orientation='vertical', rwidth=None, log=False, color=None, label=None, stacked=False, hold=None, data=None, **kwargs)¶
Plot a histogram.

Compute and draw the histogram of x. The return value is a tuple (n, bins, patches) or ([n0, n1, ...], bins, [patches0, patches1,...]) if the input contains multiple data.

Multiple data can be provided via x as a list of datasets of potentially different length ([x0, x1, ...]), or as a 2-D ndarray in which each column is a dataset. Note that the ndarray form is transposed relative to the list form.

#DataFrame是Python中Pandas库中的一种数据结构，它类似excel，是一种二维表
#DataFrame的单元格可以存放数值、字符串等，这和excel表很像
#同时DataFrame可以设置列名columns与行名index
#首先构造数据，这里注意构造的是一维数组可以使用pandas中的Series，如果是二维数组使用DataFrame。

"""



print("---")
data=np.zeros((20,20),dtype=int)
#print()
#print (np.zeros((2,1),dtype=np.int))
print("---")
for i in range(len(data)):
    pass
    for j in range(len(data[0])):
        pass
        data[i][j]=random.randint(1,20)
        #print(data[i][j],end=" ")
        '''
        if i==1:
            pass
            print(data[i][j],end=" ")
        '''
    #print("\n")    

#print(range(3))
data_m = pd.DataFrame(data)
#print(data_m[1])
print("---")
#data_m[1]--->是第2列的值(是第"1"列(0,1,))
data_m_1 = data_m[1].value_counts()#注意value_counts函数统计一个series上的数据情况
data_m_1 = data_m_1.sort_index()#给统计后的数据排序
print(data_m_1)
print(type(data_m_1))#<class 'pandas.core.series.Series'>
'''
while True:
    pass
'''
plt.hist(data_m[1],bins=20)#画直方图,默认情况下分为10段，bins=20指定划分段数
plt.show()
'''

print(len(data))
print (len(data[0]))

for i in range(len(data)):#这里速度比较慢，因为随机给1000*1000的数组赋值
    for j in range(len(data[0])):
        data[i][j] = random.randint(1,20)#赋值的范围是1-20中的任意一个
        print(data[i][j])
print("---")
data_m = pd.DataFrame(data)
data_m = data_m[1].value_counts()#注意value_counts函数统计一个series上的数据情况
data_m = data_m.sort_index()#给统计后的数据排序
print data_m
'''
