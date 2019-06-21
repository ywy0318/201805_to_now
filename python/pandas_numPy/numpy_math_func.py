#numpy包含大量的各种数学运算的函数,
#三角函数:sin(),cos(),tan()
import numpy as np 
a=np.array([0,30,45,60,90])
print(np.sin(a*np.pi/180))

print(np.cos(a*np.pi/180))

print(np.tan(a*np.pi/180))

#arcsin,arccos,arctan函数给定角度的sin,cos,tan的反三角函数
#这些函数的结果可以通过numpy.degrees()函数将弧度转换为角度
b=np.array([0,30,45,60,90])
b_sin=np.sin(b*np.pi/180)
print(np.arcsin(b_sin))
print(np.degrees(np.arcsin(b_sin)))
b_cos=np.cos(b*np.pi/180)
print(np.arccos(b_cos))
print(np.degrees(np.arccos(b_cos)))
b_tan=np.tan(b*np.pi/180)
print(np.arctan(b_tan))
print(np.degrees(np.arctan(b_tan)))

#舍入函数numpy.around()函数返回指定数字的四舍五入值
#numpy.around(a,decimals)#a:数组,decimals:舍入的小数位数，默认为0
#如果为负,整数将四舍五入到小数点左侧的位置
c=np.array([1.0,5.55,123,0.567,25.532,33.11])
print(c)
print(np.around(c))#四舍五入保留整数
print(np.around(c,decimals=1))#保留一位小数
print(np.around(c,decimals=-1))#四舍五入到10位


#numpy.floor()返回数字的下舍整数
d=np.array([-1.7,1.5,-0.2,0.6,10])
print(np.floor(d))
#numpy.ceil()返回数字的上入整数
print(np.ceil(d))
