#用python的numpy做线性拟合，多项式拟合，对数拟合
import math
import sys
import numpy as np
import matplotlib.pyplot as plt 
#from scipy import log as log print pcov
from scipy import log
from scipy.optimize import curve_fit
#线性拟合
def linear_fit(x,y):
    pass
    #N=float(len(x))
    N=len(x)
    sx,sy,sxx,syy,sxy=0,0,0,0,0
    for i in range(0,N):
        pass
        sx+=x[i]
        sy+=y[i]
        sxx+=x[i]**2
        syy+=y[i]**2
        sxy+=x[i]*y[i]
    a=(sy*sx/N-sxy)/(sx*sx/N-sxx)
    b=(sy-a*sx)/N
    r=abs(sy*sx/N-sxy)/math.sqrt((sxx-sx*sx/N)*(syy-sy*sy/N))
    return  a,b,r
#多项式拟合
def poly_fit_2(x,y,degree):
    pass
    result={}
    print(type(result))
    print("[--line_num=:(%s)]" % (sys._getframe().f_lineno))
    coefits=np.polyfit(x,y,degree)
    result['polynormal']=coefits.tolist()
    #r-squared
    p=np.poly1d(coefits)
    #fit values and mean
    yhat=p(x)# or [p(z) for z in x]
    ybar=np.sum(y)/len(y)#or sum(y)/len(y)
    ssreg=np.sum((yhat-ybar)**2)
    sstot=np.sum((y-ybar)**2)
    result['determination']=ssreg/sstot#准确率
    return result
#对数拟合,指数拟合，指数，幂数,拟合都这个!!!!!!!!!!!!!!!!!!!有问题
#修改func即可
def func(x,a,b):
    pass
    y=a*log(x)+b
    return y

def poly_fit_for_func(x,y,degree):
    pass
    result={}
    print(type(result))
    #coefits=np.polyfit(x,y,degree)
    popt,pcov=curve_fit(func,x,y)
    #result['polynormal']=coefits.tolist()
    result['polynormal']=popt
    #r-squared
    #p=np.poly1d(coefits)
    #fit values and mean
    #yhat=p(x)# or [p(z) for z in x]
    yhat=func(x,popt[0],popt[1])
    ybar=np.sum(y)/len(y)#or sum(y)/len(y)
    ssreg=np.sum((yhat-ybar)**2)
    sstot=np.sum((y-ybar)**2)
    result['determination']=ssreg/sstot#准确率
    return result

X=[1,2,3,4,5,6]
Y=[2.5,3.51,4.45,5.52,6.47,7.51]
#Y_2=[]
xxx=np.linspace(2,10)
print(xxx)
#用于画散点图
fig=plt.figure()
ax1=fig.add_subplot(111)
plt.xlabel("X")
#设置Y轴标签
plt.ylabel("Y")
a,b,r=linear_fit(X,Y)
print("\n")
print("linear_fit result:y=%10.5fx+%10.5f,r=%10.5f"%(a,b,r))
z1=np.polyfit(X,Y,1)#一次多项式拟合，相当于线性拟合
p1=np.poly1d(z1)
print(z1)
print(p1)

z2=np.polyfit(X,Y,2)#一次多项式拟合，相当于线性拟合
p2=np.poly1d(z2)
print(z2)
print(p2)

z3=poly_fit_2(X,Y,2)
p3=np.poly1d(z2)
print(z3)
print(p3)

print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
z4=poly_fit_for_func(X,Y,2)
#p4=np.poly1d(z4)
print(z4)
#print(type(z4))
#print(z4['polynormal'])
#print(type(z4['polynormal']))
print(z4['polynormal'][0])
print(z4['polynormal'][1])
#print(z4['polynormal'].shape)
'''
while True:
    pass
'''
#print(z4[1])
#print(p4)
#print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
#print(type(X))
#print(type(Y))

#yyy=a*xxx+b
#yyy=a*xxx+b

#yy=z1[0]*xxx+z1[1]
#yy=z2[0]*(xxx**2)+z2[1]*xxx+z2[2]


for xxx_1 in xxx:
    pass
    #yy_for_log=1.01*math.log(2,xxx_1)+1 
    #yy_for_log=z4['polynormal'][0]*math.log(2,xxx_1)+z4['polynormal'][1]
#yy_for_log=z4['polynormal'][0]*math.log(2,xxx)+z4['polynormal'][1]

ax1.scatter(X,Y,s=80,c='b',marker='o')#s--控制points大小
#ax1.scatter(xxx,yy_for_log,s=80,c='g',marker='o')#s--控制points大小
#plt.plot(xxx,yyy,'g',linewidth=2,label=u'sigmoid')
#plt.plot(xxx,yy,'y',linewidth=4,label=u'sigmoid')
#plt.plot(xxx,yy_for_log,'y',linewidth=4,label=u'sigmoid')
#plt.plot(xxx,yyy,'r',linewidth=2.5,label=u'sigmoid')
#plt.plot(X,Y,'r',linewidth=2.5,label=u'sigmoid')

plt.show()