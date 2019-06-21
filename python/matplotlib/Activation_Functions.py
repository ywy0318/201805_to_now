import numpy as np 
#import math
import matplotlib.pyplot as plt 
def sigmoid(x):
    pass
    return 1.0/(1.0+np.exp(-x))
def Softplus(x):
    pass
    #return math.log(1.0+np.exp(x))---math.log()函数的参数是标量,np.log()函数的参数可以是<class 'numpy.ndarray'>
    return np.log10(1.0+np.exp(x))*1.0

def tanh_1(x):
    pass 
    return (1.0-np.exp(-2*x))/(1.0+np.exp(-2*x))   
def tanh(x):
    pass
    return 2.0/(1.0+np.exp(-2*x))-1
def relu(x):
    pass
    y=x.copy()
    y[y<0]=0
    return y
def elu(x,a):
    pass
    y=x.copy()
    for i in range(y.shape[0]):
        pass
        if y[i]<0:
            pass
            y[i]=a*(np.exp(y[i])-1)
    return y
def plot_sigmoid():
    pass
    x=np.arange(-10,10,1)
    #y=sigmoid(x)
    #y=tanh(x)
    y=tanh_1(x)
    y=elu(x,0.25)
    plt.plot(x,y)
    plt.show()


if __name__=='__main__':
    pass
    #plot_sigmoid()
    x=np.linspace(-50,50)
    
    y_sigmoid=sigmoid(x)
    y_tanh=tanh(x)
    y_tanh_1=tanh_1(x)
    y_relu=relu(x)
    y_elu=elu(x,0.25)
    #print(type(x))
    #print(type(y_elu))
    #print(x.shape)
    y_soft_plus=Softplus(x)

    #plt.plot(x,y_sigmoid,'r',linewidth=2.5,label=u'sigmoid')
    #plt.plot(x,y_tanh,'y',linewidth=2.5,label=u'tanh')
    plt.plot(x,y_tanh_1,'g',linewidth=2.5,label=u'tanh_1')
    plt.plot(x,y_relu,'b',linewidth=2.5,label=u'relu')
    plt.plot(x,y_elu,'k',linewidth=2.5,label=u'elu')
    plt.plot(x,y_soft_plus,'r',linewidth=2.5,label=u'Softplus')
    plt.ylim([-2,3])#用于限制y的范围
    plt.legend()
    plt.show()