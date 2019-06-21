#等高线绘图，画三维图像,z=x^2+y^2
import numpy as np 
from matplotlib import cm 
import matplotlib.pyplot as plt 
from mpl_toolkits.mplot3d import Axes3D

from matplotlib.ticker import MultipleLocator,FormatStrFormatter

#画z=x^2+y^2的三维图像
delta=1
#此处故意把x和y的取值设置成不一样的,用于更方便的区分三维坐标中x,y,z
x=np.arange(-3,4,delta)
y=np.arange(-3,4,delta)
z=np.arange(-3,4,delta)
X,Y=np.meshgrid(x,y)
Z=X**2+Y**2
x=X.flatten()
y=Y.flatten()
z=Z.flatten()

fig=plt.figure()
#画三维图片
#ax=fig.gca(projection='3d')
#ax.plot_trisurf(x,y,z,cmap=cm.jet,linewidth=0.01)


#注意这里的X,Y,Z为大写,只想画出z=1,z=2,z=3,这里的等高线
pc=plt.contour(X,Y,Z,[1,2,3],cmap='jet')
#设置主刻度标签的位置,标签文本的格式
#将x主刻度标签设置为20的倍数
pc.ax.xaxis.set_major_locator(MultipleLocator(0.5))
#设置x轴标签文本的格式
pc.ax.xaxis.set_major_formatter(FormatStrFormatter('%1.1f'))

#将y轴主刻度标签设置为0.5的倍数
pc.ax.yaxis.set_major_locator(MultipleLocator(0.5))
pc.ax.yaxis.set_major_formatter(FormatStrFormatter('%1.1f'))

#设置次刻度标签的位置，请注意次标签，没有标签文本，这也是它和主刻度的区别
#将x轴次刻度标签设置为5的倍数
pc.ax.xaxis.set_major_locator(MultipleLocator(0.1))
#将y轴次刻度标签设置为0.1的倍数
pc.ax.yaxis.set_major_locator(MultipleLocator(0.3))

#设置坐标系中,X轴和Y轴坐标 网络使用主刻度还是次刻度
#将x坐标轴的网络使用主刻度
pc.ax.xaxis.grid(True,which='major')
#将y坐标轴的网络使用次刻度
pc.ax.yaxis.grid(True,which='minor')


plt.show()

'''
X,Y,Z的值分别是
X [[-2 -1  0  1  2]
 [-2 -1  0  1  2]
 [-2 -1  0  1  2]
 [-2 -1  0  1  2]
 [-2 -1  0  1  2]
 [-2 -1  0  1  2]
 [-2 -1  0  1  2]]
(7, 5)
Y [[-3 -3 -3 -3 -3]
 [-2 -2 -2 -2 -2]
 [-1 -1 -1 -1 -1]
 [ 0  0  0  0  0]
 [ 1  1  1  1  1]
 [ 2  2  2  2  2]
 [ 3  3  3  3  3]]
(7, 5)
Z [[13 10  9 10 13]
 [ 8  5  4  5  8]
 [ 5  2  1  2  5]
 [ 4  1  0  1  4]
 [ 5  2  1  2  5]
 [ 8  5  4  5  8]
 [13 10  9 10 13]]
(7, 5)

'''
#下面画它的等高线图,只画出三条等高线,如果想要画出X,Y区域内所有等高线
#只用去掉pc=plt.contour(X,Y,Z,[1,2,3],cmap='jet')中的[1,2,3]参数即可

