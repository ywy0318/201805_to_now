#线性分类器与随机梯度下降法预测良性/恶性乳腺癌肿瘤
import pandas as pd 
import numpy as np 
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.linear_model import SGDClassifier 
from sklearn.metrics import classification_report

#创建特征列表
column_names=['Sample code number','Clump Thickness','Uniformity of Cell Size',
'Uniformity of Cell Shape','Marginal Adhesion','Sinle Epithelial Cell Size',
'Bare Nuclei','Bland Chromatin','Normal Nucleoli','Mitonses','Class']
#使用pandas.read_csv函数从互联网读取指定数据
#跨越多行的字符串
#1.使用三引号
#2.使用反斜杠\
#3.使用小括号()
data=pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-\
databases/breast-cancer-wisconsin/breast-cancer-wisconsin.data',names=column_names)
#将?代替为标准缺失值表示
data=data.replace(to_replace='?',value=np.nan)
#将丢弃带有缺失值的数据(只要一个维度有缺失)
data=data.dropna(how='any')
#输出data的数据量和维度
#print(data.shape)
'''
print(data.head(2))
print(column_names[1:10])
print(column_names[10])
'''

#随机采样25%的数据用于测试，剩下的75%用于构建训练集合
x_train,x_test,y_train,y_test=train_test_split(data[column_names[1:10]],data[column_names[10]],test_size=0.25,random_state=33)
#print(data.head(2)[,1:10])
#查验训练样本的数量和类别分布
#print(y_train.value_counts())
#print(y_test.value_counts())

#标准化数据，保证每个维度的特征数据方差为1，均值为0,使得预测结果不会被某些维度过大的特征值而主导
ss=StandardScaler()
x_train=ss.fit_transform(x_train)
x_test=ss.fit_transform(x_test)


#初始化LogisticRegression与SGDClassifier
lr=LogisticRegression()
sgdc=SGDClassifier()
#调用LogisticRegression中的fit函数/模块用来训练模型参数
lr.fit(x_train,y_train)
#使用训练好的模型lr对x_test进行预测,结果储存在变量lr_y_predict中
lr_y_predict=lr.predict(x_test)
#调用SGDClassifier中的fit函数/模块用来训练模型参数
sgdc.fit(x_train,y_train)
#使用训练好的模型sgdc对x_test进行预测,结果存储在sgdc_y_predict
sgdc_y_predict=sgdc.predict(x_test)

#使用LR模型自带的评分函数score获得模型在测试集上的准确性结果
print("accuracy of LR Classifier:")
print(lr.score(x_test,y_test))
#利用classification_report模块 获得LogisticRegression其他三个指标的结果
print("classification_report")
print(classification_report(y_test,lr_y_predict,target_names=['Bengin','Malignant']))

#使用随机梯度下降模型自带的评分函数score获得模型在测试集上的准确性结果
print("accuarcy of SGD Classifier")
print(sgdc.score(x_test,y_test))
print("classification_report")
print(classification_report(y_test,sgdc_y_predict,target_names=['Bengin','Malignant']))
