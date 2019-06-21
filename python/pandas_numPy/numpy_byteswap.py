'''
numpy字节交换
多字节对象都存储为连续的字节序列,字节顺序,是跨越多字节的程序对象的存储规则

大端模式:指数据的高字节保存在内存的低地址,而数据的低字节保存在内存的高地址中,
这样的存储模式有点类似于把数据当做字符串顺序处理,地址由小向大增加,而数据从高位
往低位放,

小端模式:指数据的高字节保存在内存中的高地址,而数据的低字节保存在内存的地址值中,
这种存储模式将地址的高低和数据位权有效地址结合起来,高地址部分权值高,低地址部分权值低;

'''
#numpy.ndarray.byteswap()函数将ndarray中每个元素的字节进行大小端转换

import numpy as np 
a=np.array([1,256,8755],dtype=np.int16)
print(a)

#以十六进制表示内存中的数据:
print(map(hex,a))
#byteswap函数通过传入true来原地交换
print('a.byteswap(True)')
print(a.byteswap(True))
print('map(hex.a)')
print(map(hex,a))