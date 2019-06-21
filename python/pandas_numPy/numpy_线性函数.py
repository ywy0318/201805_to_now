'''
Numpy线性代数
numpy 提供了线性代数函数库linalg,该库包含了线性代数所需的所有功能
dot---两个数组的点积，即元素对应相乘
vdot---两个向量的点积
inner----两个数组的内积
matmul---两个数组的矩阵积
determinant---数组的行列式
solve---求解线性矩阵方程
inv----计算矩阵的乘法逆矩阵


numpy.dot()对于两个一维的数组，计算的事这两个数组对应下标元素的乘积和(数学上称之为内积),
对于二维数组,计算的是两个数组的矩阵乘积,对于多维数组，它的通用计算公式如下:
数组a的最后一维上的所有元素与数组b的倒数第二维上的所有元素的乘积和:
dot(a,b)[i,j,k,m]=sum(a[i,j,:]*b[k,:,m])
numpy.dot(a,b,out=None)
out:ndarray可选,用来保存dot()的计算结果
'''
import numpy as np 
import numpy.matlib
a=np.array([[1,2],[3,4]])
b=np.array([[11,12],[13,14]])
#[[1*11+2*13,1*12+2*14],[3*11+4*13,3*12+4*14]]
print(np.dot(a,b))

#numpy.vdot()函数是两个向量的点积,如果第一个参数是复数,那么它的共轭复数会用于计算
#如果参数是多维数组，他会被展开
c=np.array([[1,2],[3,4]])
d=np.array([[11,12],[13,14]])
#vdot将数组展开计算内积
#计算公式1*11+2*12+3*13+4*14
print(np.vdot(a,b))

#numpy.inner()函数返回一维数组的向量内积,对于更高的维度,它返回最后一个轴上的和的乘积
#等价于1*0+2*1+3*0
print(np.inner(np.array([1,2,3]),np.array([0,1,0])))

#多维数组--的内积
#[[1*11+2*12,1*13+2*14],[3*11+4*12,3*13+4*14]]
print(np.inner(np.array([[1,2],[3,4]]),np.array([[11,12],[13,14]])))

'''
numpy.matmul()函数返回两个数组的矩阵乘积,虽然它返回二维数组的正常乘积,
如果任一参数的维度大于2,则将其视为存在于最后两个索引的矩阵的栈,并进行广播;
另一方面，如果任一参数的一维数组，则通过其维度上附加1来将其提升为矩阵，并在乘法之后
被去除;
对于二维数组，它就是矩阵乘法
'''
#[[4 1],[2 2]]
print(np.matmul([[1,0],[0,1]],[[4,1],[2,2]]))
#二维和一维运算:
#[1,2]
print(np.matmul([[1,0],[0,1]],[1,2]))
#[1,2]
print(np.matmul([1,2],[[1,0],[0,1]]))
#维度大于二的数组:
#[[[2 3][6 11]][[10 19][14 27]]]
print(np.matmul(np.arange(8).reshape(2,2,2),np.arange(4).reshape(2,2)))

'''
numpy.linalg.det()函数计算输入矩阵的行列式
行列式在线性代数中是非常有用的值,它从方阵的对角元素计算,对于2*2方阵,
它是左上和右下元素的乘积与其他两个的乘积的差
换句话,对于矩阵[[a,b],[c,d]], 行列式计算为ad-bc,较大的方阵被认为是2*2矩阵的组合
'''
#-2.0
print(np.linalg.det(np.array([[1,2],[3,4]])))

print(np.linalg.det(np.array([[6,1,1],[4,-2,5],[2,8,7]])))
print(6*(-2*7-5*8)-1*(4*7-5*2)+1*(4*8-(-2)*2))

'''
numpy.linalg.solve()函数给出了矩阵形式的线性方程的解
numpy.linalg.inv()函数计算矩阵的乘法逆矩阵;
逆矩阵(inverse matrix):设A是数域上的一个n阶矩阵，若在相同的数域上存在另一个n阶矩阵b，
使得AB=BA=E,则我们称B是A的逆矩阵，A则成为可逆矩阵，E为单位矩阵
'''
x=np.array([[1,2],[3,4]])
y=np.linalg.inv(x)
print(x)
print(y)
print(np.dot(x,y))

#创建一个可逆矩阵
aa=np.array([[1,1,1],[0,2,5],[2,5,-1]])
aa_inv=np.linalg.inv(aa)
print(aa_inv)
bb=np.array([[6],[-4],[27]])
print(bb)
print("aa^(-1)bb")
#结果可以使用一下函数获取:
#x=np.dot(aa_inv,bb)
x=np.linalg.solve(aa,bb)
print(x)
