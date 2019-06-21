#这三个函数有些相似性，都是堆叠数组，

#stack()函数
#函数原型:stack(array,axis=0),arrays可以传数组和list;
'''
stack()函数,对array里面的每个元素(可能是个列表,元祖,或者numpy的数组)
变成numpy的数组后,再对每个元素增加一维(至于维度加载哪里,是靠axis控制的),
然后再把这些元素串起来

array里面的每个元素必须形状是一样的,才能使用stack()函数

'''
import numpy as np 

print('\n')
a=[[1,2,3],[4,5,6]]
print(a)
#print(a.shape)
print('\n')
c=np.stack(a,axis=0)#增加一维，新维度的下标为0
print(c)
#print(c.shape)
print('\n')
b=np.stack(a,axis=1)#增加一维，新维度的下标为1
print(b)
#print(b.shape)

a_1=[1,2,3,4]
b_1=[5,6,7,8]
c_1=[9,10,11,12]

print('\n')
#增加一维,新维度的下标为0
d_1=np.stack((a_1,b_1,c_1),axis=0)
print(d_1)
print('\n')

#增加一维,新维度的下标为1
d_2=np.stack((a_1,b_1,c_1),axis=1)
print(d_2)


print('- -'*5)

