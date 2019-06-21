#使用泰坦尼克号的乘客数据，利用单一决策树，随机森林分类，以及梯度上升决策树，
#3种模型各自的默认配置进行初始化，从事预测活动
import pandas as pd 

from sklearn.model_selection import train_test_split
#使用sklearn.feature_extraction中的特征转换器
from sklearn.feature_extraction import DictVectorizer

#从sklearn.tree 导入决策树分类器
from sklearn.tree import DecisionTreeClassifier
#使用随机森林分类器进行集成模型的训练及预测分析
from sklearn.ensemble import RandomForestClassifier
#使用梯度提升决策树进行集成模型的训练及预测分析
from sklearn.ensemble import GradientBoostingClassifier

#
from sklearn.metrics import classification_report

#利用pandas的read_csv模块直接从互联网手机泰坦尼克号乘客数据
titanic=pd.read_csv("http://biostat.mc.vanderbilt.edu/wiki/pub/Main/DataSets/titanic.txt")

x=titanic[['pclass','age','sex']]
y=titanic['survived']
x['age'].fillna(x['age'].mean(),inplace=True)
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.25,random_state=33)
vec=DictVectorizer(sparse=False)
#转换特征后,类别的特征都被单独剥离出来，独立成一列特征，数值型的则保持不变
x_train=vec.fit_transform(x_train.to_dict(orient='record'))
x_test=vec.fit_transform(x_test.to_dict(orient='record'))

#使用单一决策树进行模型训练及预测分析
dtc=DecisionTreeClassifier()
dtc.fit(x_train,y_train)
dtc_y_predict=dtc.predict(x_test)

rfc=RandomForestClassifier()
rfc.fit(x_train,y_train)
rfc_y_predict=rfc.predict(x_test)

gbc=GradientBoostingClassifier()
gbc.fit(x_train,y_train)
gbc_y_predict=gbc.predict(x_test)


print("accuracy--:==decition--random_forest_c--gradient_tree_c")
print(dtc.score(x_test,y_test))
print(rfc.score(x_test,y_test))
print(gbc.score(x_test,y_test))
print("classification_report--:==decition--random_forest_c--gradient_tree_c")
print(classification_report(dtc_y_predict,y_test))
print(classification_report(rfc_y_predict,y_test))
print(classification_report(gbc_y_predict,y_test))