'''
NumPy 通常与 SciPy（Scientific Python）和 Matplotlib（绘图库）一起使用， 
这种组合广泛用于替代 MatLab，是一个强大的科学计算环境，
有助于我们通过 Python 学习数据科学或者机器学习。

SciPy 是一个开源的 Python 算法库和数学工具包。
SciPy 包含的模块有最优化、线性代数、积分、插值、特殊函数、快速傅里叶变换、
信号处理和图像处理、常微分方程求解和其他科学与工程中常用的计算。

Matplotlib 是 Python 编程语言及其数值数学扩展包 NumPy 的可视化操作界面。
它为利用通用的图形用户界面工具包，如 Tkinter, wxPython,
Qt 或 GTK+ 向应用程序嵌入式绘图提供了应用程序接口（API）。

安装命令
python -m pip install --user numpy scipy matplotlib ipython jupyter pandas sympy nose

eye(n)生成对角矩阵


Numpy最重要的一个特点是其N维数组对象ndarray，是一系列同类型数据的集合，
以0下标为开始进行集合中元素的索引

ndarray对象是用于存放同类型元素的多维数组
ndarray中的每个元素在内存中都有相同存储大小的区域
ndarray内部由以下内容组成:
1.>一个指向数据(内存或内存映射文件中的一块数据)的指针
2.>数据类型或dtype,描述在数组中的固定大小值的格子
3.>一个表示数组形状的元祖，表示各个维度大小的元祖
4.>一个跨度元祖，其中的整型指的是为了前进到当前维度下一个元素需要跨国的字节数
跨度可以是负数,这样会使数组在内存中后向移动，切片中obj[::-1]或者obj[:,::-1]就是如此

创建一个ndarray只需调用Numpy的array函数即可
numpy.array(object,dtype=None,copy=True,order=None,subok=False,ndmin=0)
@parameter
object--数组或嵌套的数列
dtype--数组元素的数据类型，可选
copy--对象是否需要复制，可选
order--创建数组的样式，C为行方向，F为列方向,A为任意方向(默认)
subok--默认返回一个与基类类型一致的数组
ndmin--指定生成数组的最小维度
数据类型
1.	bool_ 存储为一个字节的布尔值（真或假）
2.	int_ 默认整数，相当于 C 的long，通常为int32或int64
3.	intc 相当于 C 的int，通常为int32或int64
4.	intp 用于索引的整数，相当于 C 的size_t，通常为int32或int64
5.	int8 字节（-128 ~ 127）
6.	int16 16 位整数（-32768 ~ 32767）
7.	int32 32 位整数（-2147483648 ~ 2147483647）
8.	int64 64 位整数（-9223372036854775808 ~ 9223372036854775807）
9.	uint8 8 位无符号整数（0 ~ 255）
10.	uint16 16 位无符号整数（0 ~ 65535）
11.	uint32 32 位无符号整数（0 ~ 4294967295）
12.	uint64 64 位无符号整数（0 ~ 18446744073709551615）
13.	float_ float64的简写
14.	float16 半精度浮点：符号位，5 位指数，10 位尾数
15.	float32 单精度浮点：符号位，8 位指数，23 位尾数
16.	float64 双精度浮点：符号位，11 位指数，52 位尾数
17.	complex_ complex128的简写
18.	complex64 复数，由两个 32 位浮点表示（实部和虚部）
19.	complex128 复数，由两个 64 位浮点表示（实部和虚部）

数据类型对象(dtype)
数据类型对象是用来描述与数组对应的内存区域如何使用

数据类型(整数，浮点，或者python对象)
数据的大小(例如,整数使用多少个字节存储)
数据的字节顺序(小端法或者大端法)
在结构化类型的情况下，字段的名称，每个字段的数据类型和每个字段所取的内存块的部分
如果数据类型是子数组，它的形状和数据类型
字节顺序是通过对数据类型预先设定"<"或">"来决定,
"<"意味着小端法(最小值存储在最小的地址，即低位组放在最前面)
">"意味着大端法(最重要的字节存在在最小的地址，高位组放在最前面)

dtype对象是使用一下语法构造的
numpy.dtype(object,align,copy)
object->要转化为的数据类型对象
align->如果为true,填充字段使其类似于C的结构体
copy->复制dtype对象，如果为false,则是对内置数据类型对象的引用

'''

#from numpy import *
import numpy as np
#print(eye(3))
a=np.array([1,2,3])
b=np.array([[1,2],[3,4]])
c=np.array([1,2,3,4,5],ndmin=4)#ndmin=3[[[1 2 3 4 5]]];ndmin=2[[1 2 3 4 5]]
d=np.array([1,2,3],dtype=complex)
print(a)
print(b)
print(c)
print(d)

dt=np.dtype(np.int32)
print(dt)
#int8 ,int16,int32,int64四种数据类型可以使用字符串'i1','i2','i4','i8'代替
dt_1=np.dtype('i4')
print(dt_1)
dt_2=np.dtype('<i2')#字节顺序标注
print(dt_2)

#首先创建结构化数据类型
dt_2=np.dtype([('age',np.int8)])
print(dt_2)

a=np.array([(10,),(20,),(30,)],dtype=dt_2)
print(a)

#定义一个结构化数据类型student,包含字符串字段name,整数字段age,浮点字段marks,
#并且将dtype应用到ndarray对象
###############有错误
# student = np.dtype([('name', 's20'), ('age', 'i1'), ('marks', 'f4')])
#student = np.dtype([('name','S20'), ('age', 'i1'), ('marks', 'f4')]) 
#print(student)