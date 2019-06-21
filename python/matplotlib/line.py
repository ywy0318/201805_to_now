# -*- coding :utf-8 -*-
'''
简单的线条
matplotlib的figure就是一个单独的figure小窗口,
小窗口里面还可以有更多的小图片,
使用import导入模块matplotlib.pyplot,
并简写成plt
使用import 导入模块numpy，简写成np
'''#import matplotlib as mpt
#print(matplotlib.__file__)
#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import matplotlib.pyplot as plt
#import matplotlib.pyplot as plt
import numpy as np#np.linspace定义x,范围(-3,3)个数50
#仿真一位数组(x,y1)表示曲线1
#仿真一位数组(x,y2)表示曲线2
x=np.linspace(-3,3,50)
y1=2*x+1
y2=x**2
#使用plt.figure定义一个窗口,
#使用plt.plot画(x,y1)曲线
plt.figure()
plt.plot(x,y2)
#plt.plot(x,y1)
#mpt.pyplot.plot(x,y1)

plt.show()
#mpt.pyplot.show()
