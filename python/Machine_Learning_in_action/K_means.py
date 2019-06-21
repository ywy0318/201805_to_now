#K均值(K-means)算法在手写体数字图像数据上的使用示例
#
import numpy as np 
import matplotlib.pyplot as plt
import pandas as pd 
from sklearn.cluster import KMeans
from sklearn.metrics import adjusted_rand_score
#从sklearn.metrics导入silhousete_score用于计算轮廓系数
from sklearn.metrics import silhouette_score
import matplotlib.pyplot as plt 
import sys

digits_train=pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/optdigits/optdigits.tra',header=None)
digits_test=pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/optdigits/optdigits.tes',header=None)


#print(type(digits_train))
#print(digits_train.head(2))

#从训练与测试数据集上都分离出64维度的像素特征与1维度的数字目标
x_train=digits_train[np.arange(64)]
y_train=digits_train[64]

x_test=digits_test[np.arange(64)]
y_test=digits_test[64]


#初始化KMeans模型,并设置聚类中心数量为10
kmeans=KMeans(n_clusters=10)
kmeans.fit(x_train)
kmeans_y_predict=kmeans.predict(x_test)

#使用ARI进行KMeans聚类性能评估
#print(adjusted_rand_score(labels_true=y_test, labels_pred=kmeans_y_predict))
print(adjusted_rand_score(labels_true=y_test, labels_pred=kmeans_y_predict))
#print(adjusted_rand_score(y_test,kmeans_y_predict))

#分割出3*2=6个子图,并且在一号子图作图
plt.subplot(3,2,1)
#初始化原始点数据
x_1=np.array([1,2,3,1,5,6,5,5,6,7,8,9,7,9])
x_2=np.array([1,3,2,2,8,6,7,6,7,1,2,1,1,3])
#zip(a,b)打包成元祖的列表,(),每个元祖从a,b中各取一个元素
#Python2中直接返回一个由元组组成的列表，Python3中返回的是一个对象，如果想要得到列表，可以用 list() 函数进行转换。
X=np.array(list(zip(x_1,x_2))).reshape(len(x_1),2)
#x_3=np.array(list(zip(x_1,x_2))).reshape(len(x_1),2)
#print(x)
#print(x_1)
#print(x_3)
#print(type(np.array(zip(x_1,x_2))))
'''
while True:
    pass
'''
#在1号子图做出原始数据点阵的分布
plt.xlim([0,10])
plt.ylim([0,10])
plt.title('Instances')
plt.scatter(x_1,x_2)
print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))

colors=['b','g','r','c','m','y','k','b']
markers=['o','s','D','v','^','p','*','+']
clusters=[2,3,4,5,8]#类簇
subplot_counter=1
sc_scores=[]

#待续!!!!!!!!!!!!!!!!!!
for t in clusters:
    pass
    subplot_counter+=1
    plt.subplot(3,2,subplot_counter)
    kmeans_model=KMeans(n_clusters=t).fit(X)

    for i,l in enumerate(kmeans_model.labels_):
        #pass
        #linestyle or ls
        #plt.plot(x_1[i],x_2[i],colors=colors[l],markers=markers[l])
        plt.plot(x_1[i],x_2[i],colors=colors[l],markers=markers[l],ls='None')
    plt.xlim([0,10])
    plt.ylim([0,10])
    sc_scores=silhouette_score(X,kmeans_model.labels_,metric='euclidean')
    sc_scores.append(sc_scores)
    #绘制轮廓系数与不同类簇数量的直观显示图
    plt.title('K=%s,silhousette coefficient=%0.03f'%(t,sc_scores))
#绘制轮廓系数与不同类簇数量的关系曲线
plt.figure()
plt.plot(clusters,sc_scores,'*-')
plt.xlabel('Number of Clusters')
plt.ylabel('Silhousette Coefficient Score ')

plt.show()
 