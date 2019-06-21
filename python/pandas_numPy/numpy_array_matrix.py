import numpy as np 
'''
numpy matrics 必须是2维的,但是numpy arrays(ndarrays)可以是多维的(1D,2D,3D...ND),
Matrix是Array的一个小的分支,包含于Array,所以matrix拥有array的所有特性
在numpy 中matrix的主要优势是:相对简单的乘法运算符号,
例如 a和b是两个matrics,那么a*b,就是矩阵积,而不用np.dot()
matrix和array都可以通过objects后面加.T得到其转置;
但是matrix objects还可以在后面加.H,f得到共轭矩阵,
加.I得到逆矩阵;
相反的是在numpy里面arrays遵从逐个元素的运算,
所以对于array:c和d的c*d运算相当于matlab里面的c.*d运算;

'''

a_1=np.array([[1,2],[3,4]])
b_1=np.array([[5,6],[7,8]])

a=np.mat('4 3 ;2 1 ')
b=np.mat('1 2 ; 3 4')
print(a)
print(a_1)
print('\n')
print(b)
print(b_1)
print('\n')
print(a.shape)
print(b.shape)
print(a_1.shape)
print(b_1.shape)
print('\n')
print(type(a))#<class 'numpy.matrix'>
print(type(b))
print(type(a_1))#<class 'numpy.ndarray'>
print(type(b_1))
print('\na*b')
print(a*b)#相当于.dot()
print(a_1*b_1)#相当于*
print('\na.dot(b)')
print(a.dot(b))#和a*b的效果一样


print('\n')


c=np.array([[4,3],[2,1]])
d=np.array([[1,2],[3,4]])
print('--')
print(c*d)
#矩阵相乘,则需要numpy里面的dot命令
print(np.dot(c,d))

#但是python中矩阵没有MATLAB中的.*这个性质,
#对于matrix对应乘法得用np.multiply()
print(np.multiply(a,b))

print('**')
#当然**运算符的作用也不一样:
print(a**2)
#对应乘法
print(c**2)

'''
array实现了matrxi所有的功能,
通过下面两条命令实现了两者之间的转化np.asmatrxi和np.asarray
numpy中array和numpy中matrxi,最大的不同就是:
在做归约运算时,array的维数会发生变换,但是matrxi总是会保持2维,
例如下面的求平均值的运算
'''
print("*"*5)
m=np.mat([[1,2],[2,3]])
print(m)
mm=m.mean(0)#mean([axis, dtype, out]) :沿给定轴方向，返回其均值
print(mm)
print(mm.shape)
print(m-mm)
print((m-mm).shape)
print("-"*5)
a=np.array([[1,2],[2,3]])
print(type(a))
print(a.mean(1))
print(a.mean(1).shape)
print(a-(a.mean(1)))
print(a.mean(0))
print(a.mean(0).shape)
print(a-(a.mean(0)))

print(a-(a.mean(1))[:,np.newaxis])


