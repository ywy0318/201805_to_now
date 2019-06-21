'''
numpy数组的维数称为秩(rank),一维数组的秩为1，二维数组的秩为2
numpy中，每一个线性的数组称为一个轴(axis),也就是为维度，
二维数组相当于两个一维数组，其中第一个一维数组中每个元素又是一个一维数组，
所以一维数组就是numpy中的轴axis,第一个轴相当于是底层数组，
第二个轴是底层数组里的数组
轴的数量--秩，就是维度，
axis,axis=0,表示沿着第0轴进行操作，即对每一列进行操作，
axis=1,表示沿着第一轴进行操作，即对每一行进行操作，
----
numpy的数组中比较重要的ndarray对象属性有:
ndarray.ndim---秩,即轴的数量或维度的数量
ndarray.shape---数组的维度，对于矩阵，n行m列
ndarray.size---数组元素的总个数，相当于shape中n*m的值
ndarray.dtype---ndarray对象的元素类型
ndarray.itemsize---ndarray度想着每个元素的大小，以字节为单位
ndarray.flag---ndarray对象的内存信息
ndarray.real--ndarray元素的实部
ndarray.img---ndarray元素的虚部
mdarray.data---包含实际元素的缓冲区,由于一般通过数组的索引获取元素，所以通常不需要使用这个属性

----

ndarray.flags
返回ndarray对象的内存信息,包含以下属性
C_CONTIGUOUS(C)---数据是在一个单一的C风格的连续段中
F_CONTIGUOUS(C)---数据是在一个单一的Fortran风格的连续段中
OWNDATA(O)---数据拥有它所使用的内存或从另一个对象中借用它
WRITEABLE(W)---数据区域可以被写入，将该值设置为False,则数据为只读
ALIGNED(A)---数据和所有元素都适当的对齐到硬件上
UPDATEIFCOPY(U)---这个数组是其他数组的一个副本，当这个数组被释放时，原数组的内容将被更新
'''

import numpy as np 
a=np.arange(24)
print(a)
print(a.ndim)#a现在只有一个维度
b=a.reshape(1,3,8)#b现在拥有三个维度reshape(,,)第一个元素表示拆成几个数组，第二个元素表示每个数组几行，第三个元素表示每行几个元素
print(b)
print(b.ndim)
print(b.shape)

c=np.array([[1,2,3],[4,5,6]])
print(c.shape)
print(c)
print("---")
c.shape= (3,2)
print(c)
print("--")
d=c.reshape(1,6)
print(d)
print('-'*3)

e=np.array([1,2,3,4,5],dtype=np.int8)
print(e.itemsize)
f=np.array([11,22,33,44,55],dtype=float)
print(f.itemsize)

print('-'*3)
g=np.array([1,2,3,4])
print(g.flags)

"""
numpy创建数组
ndarray数组除了可以使用底层ndarray构造器来创建外，还可以使用一下几种方式创建
numpy.empty
numpy.empty方法用来创建一个指定形状(shape)，数据类型(dtype)且未初始化的数据
numpy.empty(shape,dtype=float,order='C')
order表示有“C”和“F”两个选项,分别代表行优先和列优先,在计算机内存中的存储元素的顺序
数组元素为随机值,是未初始化的
"""
print('-'*3)
h=np.empty([3,2],dtype=int)
print(h)
"""
numpy.zeros创建指定大小的数组，数组元素以0来填充
numpy.zeros(shape,dtype=float,order='C')
order 'C'用于C的行数组,'F'用于FORTRAN的列数组


"""
i=np.zeros(5)
print(i)
j=np.zeros((5,),dtype=np.int)
print(j)
k=np.zeros((2,2),dtype=[('x','i4'),('y','i4')])
print(k)
print('-'*3)
'''
numpy.ones创建指定形状的数组，数组元素以1来填充
numpy.ones(shape,dtype,order)
'''
#默认为浮点数
l=np.ones(5)
print(l)
m=np.ones([2,2],dtype=int)
print(m)
print(m.itemsize)
'''
从已有的数组创建数组
numpy.asarray(a,dtype=None,ordr=None)
a 任意形式的输入参数，可以是列表，列表的元祖，元祖，元祖的元祖，元祖的列表，多维数组

'''
print('-'*3)
n=[1,2,3]
#列表转化为ndarray
nn=np.asarray(n)
print(nn)
print(type(n))
print(type(nn))
print(nn.shape)
print(nn.dtype)
print('-'*3)
#将元祖转化为ndarray
o=(1,2,3)
oo=np.asarray(o,dtype=float)
print(oo)
print(type(o))
print(oo.shape)
#将元祖列表转化为ndarray
print('-'*3)
p=[(1,2,3),(4,5)]
pp=np.asarray(p)
print(pp)
print(type(p))
print(pp.dtype)
print(pp.shape)
print('-'*3)
'''
numpy.frombuffer用于实现动态数组
numpy.frombuffer接受buffer输入参数,
以流的形式读入转化为ndarray对象
numpy.frombuffer(buffer,dtype=float,count=-1,offset=0)
注意:buffer是字符串的时候,python3默认str是unicode类型,所以要转成bytestring在原str前加上b
buffer可以是任意对象，会以流的形式读入
dtype返回数组的数据类型,可选
count 读取的数据数量,默认为-1，表示读取所有数据
offset读取的起始位置,默认为0
'''
str=b"hello world"
str_2=np.frombuffer(str,dtype='S1')
print(str_2)
'''
numpy.fromiter方法从可迭代对象中建立ndarray对象,返回一维数组
numpy.fromiter(iterable,dtype,count=-1)
itrable表示可迭代对象
dtype返回数组的数据类型

'''
print("-"*5)
#使用range函数创建列表对象
list=range(5)
it=iter(list)
#使用迭代器创建ndarray
xx=np.fromiter(it,dtype=float)
#print(it)#<range_iterator object at 0x000000000448EE90>
print(xx)

#numpy从数值范围创建数组
'''
numpy.arange创建数值范围并返回ndarray
numpy.arange(start,stop,step,dtype)
根据start,与stop指定的范围及step设定的补偿生成一个ndarray

start起始值默认为0
stop终止值(不包含)
step步长，默认为1
dtype返回ndarray的数据类型,如果没有提供，则会使用输入数据的
'''

print("-"*5)
aa=np.arange(10,20,2,dtype=float)
print(aa)
'''

numpy.linspace
numpy.linspace函数用于创建一个移位数组,数组是一个等差数据构成
numpy.linspace(start,stop,num=50,endpoint=True,retstep=False,dtype=None)

start---序列的起始值
stop---序列的终止值，如果endpoint为true,该值包含于数列中
num---要生成的等步长的样本数量,默认为50
endpoint----该值为true，数列中包含stop的值,反之，不包含,默认为true
retstep---如果为true时,生成的数组中会显示间距,反之不显示
dtype---数据类型
'''
print("-"*5)
#aaa=np.linspace(1,10,3)#[ 1.   5.5 10. ]
aaa=np.linspace(1,1,10)
print(aaa)
bbb=np.linspace(10,20,5,endpoint=False)
print(bbb)
ccc=np.linspace(1,10,10,retstep=True)
print(ccc)
ddd=np.linspace(1,10,10).reshape([10,1])
print(ddd)

'''
numpy.logspace
numpy.logspace函数用于创建一个等比数列
np.logspace(start,stop,num=50,endpoint=True,base=10.0,dtype=None)
base---对数log的底数
'''
print("-"*5)

ee=np.logspace(1.0,2.0,num=10)
print(ee)
ff=np.logspace(0,9,10,base=2)
print(ff)
