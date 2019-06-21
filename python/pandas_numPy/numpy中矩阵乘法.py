#numpy中矩阵乘法,点乘(.dot)和星乘(*)
'''
星乘表示矩阵内各种对应位置相乘,矩阵a*b下标(0,0)=矩阵a下标(0,0)x矩阵b下标(0,0)

点乘表示求矩阵内积,二维数组成为矩阵积(mastrix product)
用文字表述:
所得到的数组中的每个元素为，第一个元素中与该元素行号相同的元素与第二个矩阵与该元素列号相同的元素,
两两相乘后再求和
二维矩阵a.dot(b)下标(0,1)=矩阵a下标(0,n)x矩阵b下标(n,1)

'''

import numpy as np 

a=np.array([[1,2],[3,4]])
b=np.array([[5,6],[7,8]])

print(a*b)#[[5,12],[21,32]]
print('\n')
print(a.dot(b))#[[19,22],[43,50]]
print('\n')
print(np.dot(a,b))#[[19,22],[43,50]]
print('\n')
print(np.dot(b,a))#[[23,34],[31,46]]
print(type(a))
print(type(b))