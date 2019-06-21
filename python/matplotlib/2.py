import matplotlib.pyplot as plt
import matplotlib as mpl 
import numpy as np
'''
plt.plot([1,5,0,3,2,4])
plt.show()
x=range(6)
plt.plot(x,[xi**2 for xi in x])
plt.show()


x_2=np.arange(0.0,6.0,0.01)
plt.plot(x_2,[x_2**2 for x_2 in x_2])
plt.show()

'''
"""
#网格
x=np.arange(1,10)
plt.plot(x,x*1.5,x,x*3.0,x,x/3.0)
plt.grid(True)
plt.show()
"""
#设置坐标轴的取值范围=axis xlim ylim
x=np.arange(1,5)
'''
#plt.plot(x,x*1.5,x,x*3.0,x,x/3.0)
plt.plot(x,x*1.5,label="normal")
plt.plot(x,x*3.0,label="fast")
plt.plot(x,x/3.0,label="slow")
#设置图例
#设置图例方法2


plt.plot(x,x*1.5)
plt.plot(x,x*3.0)
plt.plot(x,x/3.0)
plt.legend(['normal','fast','slow'],loc='upper left')
'''
"""
图例的位置参数:loc=code
string code
best    0
upper right 1
upper left  2
lower left  3
lower right 4
right       5
center left  6
center right  7
lower center    8
upper center    9
center       10
"""
'''
plt.legend()
#显示当前坐标轴的极限取值范围
plt.axis()
#设置当前坐标轴的范围
#整体设置
#[xmin,xmax,ymin,ymax]-->plt.asix([xmin,xmax,ymin,ymax])
#分别设置
#plt.xlim([xmin,xmax])
#plt.ylim([ymin,ymax])

plt.axis([0,5,-1,18])
plt.title("simple plot")
#x轴标签
plt.xlabel("this is x axis")
#y轴标签
plt.ylabel("this is y axis")
plt.show()
'''

plt.plot([1,6,2,5,3,4])
plt.savefig("123.png")



##############有问题

mpl.rcParams['figure.figsize']
#mpl.rcParams['saving.dpi']

#mpl.rcParams['Agg']

plt.savefig("123_2.png",dpi=400)