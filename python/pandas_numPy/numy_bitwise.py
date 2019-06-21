'''
numpy bitwise_开头的函数是位运算函数
numpy位运算包含以下几个函数
bitwise_and---对数组元素执行位与操作
bitwise_or---对数组元素执行位或操作
invert---按位取反
left_shift---向左移动二进制表示的位
right_shift---向右移动二进制表示的位
'''

import numpy as np 
a,b=13,17
print(bin(a),bin(b))
#位与
print(np.bitwise_and(13,17))

#位或
print(np.bitwise_or(13,17))

#invert
#invert()函数对数组中的整数进行位取反运算，0变成1,1变成0
#对于有符号整数,取该二进制数的补码，然后+1
# 二进制数，最高位为0表示正数,最高位为1表示负数

#left_shift()函数将数组元素的二进制形式向左移动到指定位置,右侧附加相等数量的0

print(np.left_shift(10,2))
#10的二进制表示:
print(np.binary_repr(10,width=8))

#right_shift()函数将数组元素的二进制形式向右移动到指定位置,左侧附加相等数量的0

print(np.right_shift(40,2))
