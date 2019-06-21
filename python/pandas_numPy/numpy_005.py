import numpy as np 
"""
numpy迭代数组,numpy迭代器对象numpy.nditer提供了一种灵活访问一个或者
多个数组元素的方式;
迭代器最基本的任务是可以完成对数组元素的访问

a_nditer和a_nditer.T的遍历顺序是一样的,
他们在内存中的存储顺序是一样的
但是a.T.copy(order='C')的遍历结果是不同的,
那是因为他和前两种存储方式不一样，默认是按照行存储的

"""
print("----")
a_nditer=np.arange(6).reshape(2,3)
print(a_nditer)
print(a_nditer.T)
for x in np.nditer(a_nditer):
    pass
    print(x,end=",")
print("\n")
for x in np.nditer(a_nditer.T):
    pass
    print(x,end=",")
print("\n")
b=a_nditer.copy(order='C')
c=a_nditer.copy(order='F')
for bd in np.nditer(b):
    pass    
    print(bd,end=',')
print("\n")
for bff in np.nditer(c):
    pass
    print(bff,end='.')
print('\n')
for aa in np.nditer(a_nditer,op_flags=['readwrite']):
    pass
    aa[...]=2*aa
print(a_nditer)
'''
使用外部循环
c_index 可以跟踪C顺序的索引
f_index 可以跟踪Fortran顺序的索引
multi_index 每次迭代可以跟踪一种索引类型
external_loop   给出的值是具有多个值的一维数组 ,而不是零维数组

'''
#输出一个一维数组
for ddd in np.nditer(a_nditer,flags=['external_loop'],order='F'):
    pass
    print(ddd,end=',')

print("\n--\n")
for dddd in np.nditer(a_nditer,flags=['multi_index'],order='F'):
    pass
    print(dddd,end=',')

'''
广播迭代
如果两个数组是可广播的，那么nditer组合对象能够同时迭代他们,
假设数组a的维度为3x4,数组b的维度是1x4，则使用以下迭代器
数组b被广播到数组a的大小

'''
print('\n')
a=np.arange(0,60,5)
a=a.reshape(3,4)
print(a)
print('\n')
b=np.array([1,2,3,4],dtype=int)
print(b)
print('\n')
for x,y in np.nditer([a,b]):
    pass
    print("%d-%d"%(x,y),end=",")
