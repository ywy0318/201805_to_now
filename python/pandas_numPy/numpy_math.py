
import numpy as np 
#numpy算术函数
#numpy算术函数包含简单的加减乘除:add(),subtract(),multiply(),divide()
a=np.arange(9,dtype=np.float).reshape(3,3)
print(a)
b=np.array([10,100,1000])
print(b)

print(np.add(a,b))
print(np.subtract(a,b))
print(np.multiply(a,b))
print(np.divide(a,b))

#numpy.reciprocal()函数返回参数逐个元素的倒数
c=np.array([0.25,0.2,0.5,1.0,2.0])
print(np.reciprocal(c))

#numpy.power()函数将第一个输入数组中的元素作为底数,
#
d=np.array([2,10,100])
print(d)
print(np.power(d,2))
e=np.array([1,2,3,])
print(np.power(d,e))
#numpy.mod()计算输入数组中相应元素的相除后的余数,函数numpy.remainder()也产生相同的结果
f=np.array([10,20,30])
g=np.array([3,5,7])
print(f)
print(g)
print(np.mod(f,g))
print(np.remainder(f,g))