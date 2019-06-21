#numpy字符串函数
#以下函数用于对dtype为numpy.string_或numpy.unicode_的数组执行向量化字符串操作;
#他们基于python内置库中的标准字符串函数
#这些函数在字符数组中定义
'''
add()---对两个数组的逐个字符串元素进行连接
multiply()---返回按元素多重连接后的字符串
center()---居中字符串
capitalize()---将字符串第一个字母转换为大写
title()---将字符串的每个单词的第一个字母转换为大写
lower()---数组元素转换为小写
upper()---数组元素转换为大写
split()---指定分隔符对字符串进行分割,并返回数组列表
splitlines()---返回元素中的行列表,以换行符分割
strip()---移除元素开头或者结尾处的特定字符
join()---通过指定分隔符来连接数组的元素
replece()---使用新字符串替换字符串中的所有子字符串
decode()---数组元素依次调用str.decode
encode()---数组元素一次调用str.encode


'\r'是回车，前者使光标到行首，（carriage return）

'\n'是换行，后者使光标下移一格，（line feed）

\r 是回车，return

\n 是换行，newline
'''

import numpy as np 
#numpy.char.add()函数依次对两个数组元素进行字符串连接
print(np.char.add(['hello'],['xyz']))
print(np.char.add(['hello','hi'],['abc','xyz']))
#numpy.char.multiply()函数执行多重连接
print(np.char.multiply('Ruhoob',3))

#numpy.char.center()函数用于将字符串居中,并使用指定字符在左侧和右侧进行填充
#numnpy.char.center(str,width,fillchar)
print(np.char.center('runoob',10,fillchar='*'))

#numpy.char.capitalize()将字符串的第一个字母转换为大写
print(np.char.capitalize('runoob'))

#numpy.char.title()函数将字符串的每个单词的第一个字母转换为大写
print(np.char.title('i like python'))

#numpy.char.lower()函数对数组的每个元素转换为小写,它对每个元素调用str.lower

print(np.char.lower(['PYTHON','GOOGLE']))
print(np.char.lower('PYTHON'))

#numpy.char.upper()函数对数组的每个元素转换为大写，它对每个元素调用str.upper
print(np.char.upper(['runoob','google']))
print(np.char.upper('runoob'))
#numpy.char.split()通过指定分隔符对字符串进行分割,并返回数组,默认情况下,分隔符为空格
print(np.char.split('i like python'))
print(np.char.split('www.runoob.com',sep='.'))

#numpy.char.splitlines()函数以换行符来分割字符串,并返回数组
#\n，\r，\r\n 都可用作换行符。
print(np.char.splitlines(' i\nlike runnob'))
print(np.char.splitlines('i\rlike runoob'))

#numpy.char.strip()函数用于移除开头或结尾处的特定字符
#移除字符串头尾的a字符
print(np.char.strip('ashok arunooba','a'))
#移除数组元素头尾的a字符
print(np.char.strip(['ashok',' arunooba','java'],'a'))

#numpy.char.join()函数通过指定分隔符来连接数组中的元素或字符串
#是每个字符之间都用分隔符连接

#操作字符串
print(np.char.join(':','runnob'))
#指定多个分隔符操作数组元素
print(np.char.join([':','-'],['runoob','google']))


#numpy.char.replace()使用新字符串替换字符串中的所有子字符串
print(np.char.replace('i like runoob','oo','cc'))

#numpy.char.encode()函数对数组中的每个元素调用str.encode函数
#默认编码是utf-8,可以使用标准python库中的编解码器
print(np.char.encode('runoob','cp500'))

#numpy.char.decode()函数对编码的元素进行str.decode()解码
print(np.char.decode(np.char.encode('runoob','cp500'),'cp500'))
