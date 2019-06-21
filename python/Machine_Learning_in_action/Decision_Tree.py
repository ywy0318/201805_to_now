#使用决策树模型预测泰坦尼克号乘客生还情况
#导入pandas用于数据分析
import pandas as pd 

from sklearn.model_selection import train_test_split
#使用sklearn.feature_extraction中的特征转换器
from sklearn.feature_extraction import DictVectorizer
#从sklearn.tree 导入决策树分类器
from sklearn.tree import DecisionTreeClassifier

#
from sklearn.metrics import classification_report

#利用pandas的read_csv模块直接从互联网手机泰坦尼克号乘客数据
titanic=pd.read_csv("http://biostat.mc.vanderbilt.edu/wiki/pub/Main/DataSets/titanic.txt")
#观察前几行数据,数据类型，数值型，类别型
#print(titanic.head(5))
#使用pandas数据都转入pandas独有的dataframe格式(二维数据表格)，直接使用info()，查看数据的统计特性
#print(titanic.info())

#使用决策树模型预测泰坦尼克号乘客的生还情况
#机器学习有一个不太被初学者重视并且耗时，但是十分重要的一环，特征选择，,sex,age,pclass
x=titanic[['pclass','age','sex']]
y=titanic['survived']
#print(x.info())

# 1>把age里面的数据里的数据补充完成，
# 2>sex与pclass两个数据列的值都是类别型的,需要转化为数值特征，用0/1代替

#补充age里的数据，使用平均数或者中位数都是对模型偏离造成最小影响的策略
x['age'].fillna(x['age'].mean(),inplace=True)
#print(x.info())

#数据分割
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.25,random_state=33)

vec=DictVectorizer(sparse=False)
#转换特征后,类别的特征都被单独剥离出来，独立成一列特征，数值型的则保持不变
x_train=vec.fit_transform(x_train.to_dict(orient='record'))
x_test=vec.fit_transform(x_test.to_dict(orient='record'))
#print(vec.feature_names_)

#使用默认配置初始化决策时分类器
dtc=DecisionTreeClassifier()
#使用分割到的训练数据进行模型学习
dtc.fit(x_train,y_train)
#用训练好的决策树模型对测试特征数据进行预测
y_predict=dtc.predict(x_test)

print("dtc.score")
print(dtc.score(x_test,y_test))

print("classification_report")
print(classification_report(y_predict,y_test,target_names=['died','survived']))
