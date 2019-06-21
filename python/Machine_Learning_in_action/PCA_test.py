#线性相关矩阵秩计算样例
#显示手写体数字图片经PCA压缩后的二维空间分布
#待续有问题!!!!!!!!!!!!!!!!!画图有问题,降维以后有问题
import numpy as np 
import pandas as pd 
import sys 
#从sklearn.decomposition 导入PCA
from sklearn.decomposition import PCA
#显示10类手写体数字图片经PCA压缩后的2维空间分布
from  matplotlib import pyplot as plt 
#导入基于线性和的支持向量机分类器
from sklearn.svm import LinearSVC

from sklearn.metrics import classification_report


def plot_pca_scatter():
    pass
    fig=plt.figure()
    ax1=fig.add_subplot(111)
    colors=['black','blue','purple','yellow','whilte','red','lime','cyan','orange','gray']
    cValue=['r','y','g','b','r','b','g','g','b']
    colors_1=['k','b','p','y','w','r','r','c','o','g']
    for i in range(len(colors)):
        #pass
        px=x_pca[:,0][y_digits.as_matrix()==i]
        py=x_pca[:,1][y_digits.as_matrix()==i]

        #px=x_pca[0][y_digits.as_matrix()==i]
        #py=x_pca[1][y_digits.as_matrix()==i]
        #print(px)
        #print(py)
        #print("px=%d--py=%d"%(px,py))
        
        plt.scatter(px,py,c=colors[i])
        #print(colors[i])
        #ax1.scatter(px,py,c=colors_1[i])
        #plt.scatter(px,py,c=colors_1[i])

    plt.legend(np.arange(0,10).astype(str))
    plt.xlabel('First Principle Component')
    plt.ylabel('second principle Component')
    plt.show()

#digits_train=pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/optdigits/optdigits.tra',header=None)
#digits_test=pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/optdigits/optdigits.tes',header=None)

digits_train=pd.read_csv('F:/zzpersom/dataset/optdigits/optdigits.tra',header=None)
digits_test=pd.read_csv('F:/zzpersom/dataset/optdigits/optdigits.tes',header=None)
'''
#初始化一个2*2的线性相关矩阵
M=np.array([[1,2],[2,4]])
#计算2*2线性相关矩阵的秩
np.linalg.matrix_rank(M,tol=None)
print(M)
print(M.shape)
print(np.linalg.matrix_rank(M,tol=None))
'''
#分割训练数据的特征向量和标记
X_digits=digits_train[np.arange(63)]
y_digits=digits_train[64]



#初始化一个可以将高维度特征向量(六十四维)压缩至两个维度的PCA
#estimator=PCA(n_components=2)
#globals x_pca
#x_pca=estimator.fit_transform(X_digits)

print(type(digits_train))
print(type(X_digits))
#print(type(x_pca))

print(digits_train.shape)
print(X_digits.shape)
#print(x_pca.shape)


#print(x_pca[0])
#print(x_pca[1])
#print(x_pca[2])
#print(x_pca[3])

#print(x_pca[0][0])
#print(x_pca[0][1])

#print(x_pca[1][0])
#print(x_pca[1][1])


x_train=digits_train[np.arange(64)]
y_train=digits_train[64]

x_test=digits_test[np.arange(64)]
y_test=digits_test[64]

#在数据上做出预测，存储在y_predict
svc=LinearSVC()
svc.fit(x_train,y_train) 
y_predict=svc.predict(x_test)

print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
#使用PCA将原来64维的图像数据压缩到20个维度
estimator_1=PCA(n_components=20)
#利用 训练特征决定(fit)20个正交维度的方向，并转化(transform)源训练特征
pca_x_train=estimator_1.fit_transform(x_train)
#测试特征也按照上述的20个正交维度方向进行转化(transform)
pca_x_test=estimator_1.fit_transform(x_test)

print(pca_x_train.shape)

#使用默认配置初始化LinearSVC,对压缩过后的二十个维特征的训练数据进行建模，
#并在测试数据上做出预测，存储在pca_y_predict中
pca_svc=LinearSVC()
pca_svc.fit(pca_x_train,y_train)
pca_y_predict=pca_svc.predict(pca_x_test)


print("svc")
print(svc.score(x_test,y_test))

#print(np.arange(10).astype(str))
print(classification_report(y_test,y_predict,target_names=np.arange(10).astype(str)))

print("pca")
print(pca_svc.score(pca_x_test,y_test))
print(classification_report(y_test,pca_y_predict,target_names=np.arange(10).astype(str)))

#plot_pca_scatter()
'''



print(x_train)






'''

