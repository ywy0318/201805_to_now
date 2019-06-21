'''
numpy副本和视图
副本是一个数据的完整的拷贝,如果我们队副本进行修改，它不会影响到原始数据,物理内存不在同一位置
视图是数据的一个别称或者引用,通过该别称或引用亦可访问操作,操作原有数据，但原有数据不会产生拷贝,
我们对视图进行修改,会影响到原始数据,物理内存在同一位置

视图一般发生在:
1.numpy的切片操作返回原始数据的视图
2.调用ndarray的view()函数产生一个视图

副本一般产生在:
1.python序列的切片操作,调用deepCopy()函数
2.调用ndarray的copy()函数产生一个副本

无复制
简单的赋值不会创建数组对象的副本,相反，它使用原始数据的相同的id()来访问它,
id()返回python对象的通识标识符,类似于C中的指针,此外,一个数组的任何变化都反映在
另一个数组上,例如，一个数组的形状改变也会改变零一个数组的形状

'''

import numpy as np 
a=np.arange(6)
print(a)
print(id(a))
b=a
print(b)
print(id(b))
b.shape=3,2
print(a)
#视图或浅拷贝
#ndarray.view()函数会创建一个新的数组对象，该方法创建新的数组的维数不会更改原始数据的维数
print('---')
c=np.arange(6).reshape(3,2)
print(c)
d=c.view()
print(d)
print(id(c))
print(id(d))
d.shape=2,3
print(d)
print(c)
print(id(d))
#使用切片创建视图修改数据会影响到原始数组
print('---')
arr=np.arange(12)
print(arr)
e=arr[3:]
f=arr[3:]
e[1]=123
print(arr)
f[1]=234
print(arr)
print(id(e),id(f),id(arr[3:]))
'''
变量a,b都是arr的一部分视图,对视图的修改会直接反映到原始数据中，e,f的id不同，
也就是说，视图虽然指向原始数据，但是他们和赋值引用还是有区别的
'''
#副本或者深拷贝
#ndarray.copy()函数创建一个副本，对副本数据进行修改，不会影响到原始数据，物理内存不在同一位置

print("----")
g=np.array([[10,10],[2,3],[4,5]])
print(g)
h=g.copy()
print(h)
# h与g不共享任何内容
print(h is g)
h[0,0]=100
print(h)
print(g)