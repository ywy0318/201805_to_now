import numpy as np 
from matplotlib import pyplot as plt 
#x=np.arange(1,11)
#y=2*x+5
x=np.arange(0,3*np.pi,0.1)
y_sin=np.sin(x)
y_cos=np.cos(x)

plt.subplot(2,1,1)
plt.plot(x,y_sin)
plt.title('y_sin')
plt.xlabel(' x axis caption')
plt.ylabel(' y axis caption')
#plt.plot(x,y)
#plt.plot(x,y,'om')
plt.subplot(2,1,2)
plt.plot(x,y_cos)
plt.title('y_cos')
plt.show()
#subplot可以在同衣服图中绘制不同的东西
'''
'-'  实线样式
'--'  短横线样式
'-.'  点划线样式
':'   虚线样式
'.'   点标记
','   像素标记
'o'   圆标记
'v'   倒三角标记
'^'   正三角标记
'&lt;'  左三角标记
'&gt;'  右三角标记
'1'     下箭头标记
'2'     上箭头标记
'3'     左箭头标记
'4'     右箭头标记
's'     正方形标记
'p'     五边形标记
'*'     星形标记
'h'     六边形标记1
'H'     六边形标价2
'+'     加号标记
'x'     X标记
'D'     菱形标记
'd'     窄菱形标记
'&#124;'竖直线标记
'_'     水平线标记
'b'     蓝色
'g'     绿色
'r'     红色
'c'     青色
'm'     品红色
'y'     黄色
'k'     黑色
'w'     白色

'''