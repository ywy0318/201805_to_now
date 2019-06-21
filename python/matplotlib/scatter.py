import numpy as np 
import matplotlib.pyplot as plt 
#当scatter后面的参数中的数组的使用方法,s是同x大小的数组,表示x中的每个点对应s中一个大小，
X_list=[1,2,3,4,5,6]
Y_list=[2.5,3.51,4.45,5.52,6.47,7.51]

x=np.arange(1,10)
print(x)
y=x 
print(type(x))
print(type(y))
fig=plt.figure()
ax1=fig.add_subplot(111)
#设置标题
ax1.set_title("Scatter Plot")
#设置X轴标签
plt.xlabel("X")
#设置Y轴标签
plt.ylabel("Y")
#画散点图
sValue=40*x
cValue=['r','y','g','b','r','b','g','g','b']
IValue=x
#ax1.scatter(x,y,s=100,linewidths=IValue,marker='o')#linewidths  # 控制points边缘线的粗细
#ax1.scatter(x,y,c='r',marker='o')
#ax1.scatter(x,y,c='r',marker='o')
#ax1.scatter(x,y,s=sValue,c='r',marker='x')#s--控制points大小
#list类型的也可以画出来
ax1.scatter(X_list,Y_list,s=sValue,c='r',marker='x')#s--控制points大小

#ax1.scatter(x,y,c=cValue,marker='s')
#设置图标
plt.legend("x1")
#显示所画的图
plt.show()