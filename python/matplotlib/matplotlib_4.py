#bar()
#pyplot子模块提供bar()函数来生成条形图
'''
numpy.histogram()函数是数据的频率分布的图形表示;水平尺寸相等的矩形对应于类间隔,
成为bin,变量height对应于频率
numpy.histogram()函数是将输入数组和bin作为两个参数,bin数组中的连续元素用作每个bin的边界

'''


from matplotlib import pyplot as plt 
import numpy as np 
x=[5,8,10]
y=[12,16,6]
x_2=[6,9,11]
y_2=[6,15,7]

a=np.array([22,87,5,43,56,73,55,54,11,20,51,5,79,31,27])
a_bins=[0,20,40,60,80,100]
hist,bins=np.histogram(a,bins=a_bins)

print(hist)
print(bins)

plt.hist(a,bins=a_bins)
plt.show()
#plt.bar(x,y,align='center')
#plt.bar(x_2,y_2,color='m',align='center')
plt.title('bar graph')
plt.xlabel('x axis')
plt.ylabel('y axis')
#plt.show()