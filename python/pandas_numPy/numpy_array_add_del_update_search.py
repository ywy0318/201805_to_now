
import numpy as np 
import sys 
a=np.array([[1,2],[3,4],[5,6]])
print(a)
print(type(a))
print(a.shape)

#创建长度为6的,元素都是0的一维数组
b=np.zeros(6)
print(b)
print(type(b))
print(b.shape)
#创建2行3列的，元素都是0的二维数组
print(np.zeros((2,3)))
#创建2行3列的，元素都是1的二维数组
print(np.ones((2,3)))
print('np.empty')
#创建2行3列的，未初始化的二维数组
print(np.empty((2,3)))
#创建长度为6的,元素都是0的一维数组array([0,1,2,3,4,5])
print(np.arange(7))
print(np.arange(0,7,1))
#生成首位都是0,末尾是7,包含7个数的等差数列
print(np.linspace(0,7,7))
#生成首位为10**0,末尾为10**4，包含5个数的等比数列
print(np.logspace(0,4,5))


a_add=np.array([[1,2],[3,4],[5,6]])
b_add=np.array([[10,20],[30,40],[50,60]])
print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
print(np.vstack((a_add,b_add)))#堆叠数组
print(np.hstack((a_add,b_add)))
print(a_add.shape)
print(b_add.shape)
print(np.vstack((a_add,b_add)).shape)
print(np.hstack((a_add,b_add)).shape)

c_add=np.array([[11,22],[33,44]])
c=([[10,20,30,40],[11,22,33,44],[99,88,77,66]])
d_add=np.array([[1],[2]])
e_add=np.array([[1,2]])
#Exception has occurred: ValueError-operands could not be broadcast together with shapes (3,2) (2,2) 
#print(a_add+c_add)

#print(c.shape)
#print(a_add+c)
#print((a_add+c).shape)
print(d_add.shape)
#print((c+d_add).shape)
#print((c+d_add))
print('\n')
print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
#Exception has occurred: ValueError
#operands could not be broadcast together with shapes (1,4) (1,2) 
#print(c+e_add)
#print((c+e_add).shape)

#切片--c
print(c[0])
print(c[0][0])
#print(c[0,1])
print(c[1:3])
print(c[:3])
print(c[2:])
e=np.arange(12)
print(e)
print(e[0:8:2])#下标递增
#print(c[])

















