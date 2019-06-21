#使用Titanic数据集,通过特征筛选的方法一步步提升决策树的预测性能
import pandas as pd 
#通过交叉验证(下一节将详细介绍)的方法，按照固定间隔的百分比筛选，并作图展示性能随筛选比例的变换
from sklearn.model_selection import train_test_split,cross_val_score
from sklearn.tree import DecisionTreeClassifier
from sklearn.feature_extraction import DictVectorizer

import numpy as np 

#从sklearn 导入特征筛选器
from sklearn import feature_selection

import pylab as pl 


#利用pandas的read_csv模块直接从互联网手机泰坦尼克号乘客数据
titanic=pd.read_csv("http://biostat.mc.vanderbilt.edu/wiki/pub/Main/DataSets/titanic.txt")

#分类数据特征与预测目标
y=titanic['survived']
x=titanic.drop(['row.names','name','survived'],axis=1)

#对缺失数据进行填充
x['age'].fillna(x['age'].mean(),inplace=True)
x.fillna('UNKNOWN',inplace=True)

#分割数据，依然采样25%用于测试
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.25,random_state=33)

#类别型特征向量化
vec=DictVectorizer()
x_train=vec.fit_transform(x_train.to_dict(orient='record'))
x_test=vec.transform(x_test.to_dict(orient='record'))

#输出处理后特征向量的维度
print(len(vec.feature_names_))

#使用决策树模型依靠所有特征进行预测，并且做出性能评估
dt=DecisionTreeClassifier(criterion='entropy')
dt.fit(x_train,y_train)
print(dt.score(x_test,y_test))

#筛选前20%的特征，使用相同配置的决策树模型进行预测,并且评估性能
fs=feature_selection.SelectPercentile(feature_selection.chi2,percentile=20)

x_train_fs=fs.fit_transform(x_train,y_train)

x_test_fs=fs.transform(x_test)

dt.fit(x_train_fs,y_train)
print(dt.score(x_test_fs,y_test))

percenriles=range(1,100,2)

results=[]
for i in percenriles:
    fs_1=feature_selection.SelectPercentile(feature_selection.chi2,percentile=i)
    x_train_fs_1=fs_1.fit_transform(x_train,y_train)
    scores=cross_val_score(dt,x_train_fs_1,y_train,cv=5)
    results=np.append(results,scores.mean())
print(results)

#找到体现最佳性能的特征筛选的百分比
opt=np.where(results==results.max())[0]
print('Optimal number of features %d'%np.array(percenriles)[opt])


#使用最佳筛选后的特征，利用相同配置的模型在测试集上进行性能评估
fs_2=feature_selection.SelectPercentile(feature_selection.chi2,percentile=7)


x_train_fs_2=fs_2.fit_transform(x_train,y_train)
dt.fit(x_train_fs_2,y_train)
x_test_fs_2=fs_2.transform(x_test)
print(dt.score(x_test_fs_2,y_test))


pl.plot(percenriles,results)
pl.xlabel('percenriles of features')
pl.ylabel('accuracy')
pl.show()
