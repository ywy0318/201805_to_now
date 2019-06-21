import pandas

from pandas.plotting import scatter_matrix

import matplotlib.pylab as plt

import matplotlib
import matplotlib.pyplot

import sys
from sklearn import model_selection

from sklearn.metrics import  classification

from sklearn.metrics import classification_report

from sklearn.metrics import confusion_matrix

from sklearn.metrics import accuracy_score

from sklearn.linear_model import LogisticRegression

from sklearn.tree import DecisionTreeClassifier

from sklearn.neighbors import KNeighborsClassifier

from sklearn.discriminant_analysis import LinearDiscriminantAnalysis

from sklearn.naive_bayes import GaussianNB

from sklearn.svm import SVC

#print(matplotlib.__file__)

#print(matplotlib.get_cachedir())

#加载鸢尾花的数据集合

#iris_url = "https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data"
#E:\Visual Studio 2010\python_for_vscode\Machine_Learning_in_action
#iris_url="D:/project/python_instruct/test_data1.txt"
iris_url="E://Visual Studio 2010/python_for_vscode/Machine_Learning_in_action/1_iris_data.txt"
iris_attrs=['hua_e_length','hua_e_width','hua_ban_length','hua_ban_width','class']
#iris_attrs=['花萼长度','花萼宽度','花瓣长度','花瓣宽度','种类']
#注意：这里的参数names需要进行指定，否则或出现数据类型不匹配

iris_dataset=pandas.read_csv(iris_url,names=iris_attrs)

#打印前10行数据
#print(iris_dataset.head(10))


'''
print(type(iris_dataset))#<class 'pandas.core.frame.DataFrame'>
#<class 'pandas.core.series.Series'>
print("[%s----(%s)]" % (__file__, sys._getframe().f_lineno) )
while True:
    pass
'''
#自定义字体,解决中文显示问题

plt.rcParams['font.family'] = ['Microsoft YaHei']

plt.rcParams['axes.unicode_minus'] = False
#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
#单变量绘图


#iris_dataset.plot(kind='box', subplots=True,layout=(2,2),sharex=False,sharey=False)
#iris_dataset.plot(kind='kde', subplots=True,layout=(2,2),sharex=False,sharey=False)#曲线图
#iris_dataset.plot(kind='pie', subplots=True,layout=(2,2),sharex=False,sharey=False)#pie有问题
#iris_dataset.plot(kind='kde', subplots=False,layout=(2,2),sharex=False,sharey=False)#subplot--纵坐标density密度
#iris_dataset.plot(kind='hist', subplots=False,layout=(2,2),sharex=False,sharey=False)#subplot--纵坐标density数量
#iris_dataset.plot(kind='line', subplots=False,layout=(2,2),sharex=False,sharey=False)#subplot--纵坐标density数量--
#iris_dataset.plot(kind='box', subplots=False,layout=(2,2),sharex=False,sharey=False)#--效果不好

#柱状图显示

#iris_dataset.hist()
#print("[%s----(%s)]" % (__file__, sys._getframe().f_lineno) )
#while True:
#   pass

#属性两两对比散点图
#scatter_matrix(iris_dataset)

#plt.grid()


#数据集分割： 80%作为训练集 20%作为验证集
dataset_array = iris_dataset.values
#dataset_array = iris_dataset.head(10).values
#print(dataset_array)
#print("--")
#X = dataset_array[:,0:4]
#Y = dataset_array[:,4]
X = dataset_array[:,0:4]#测量数据--
Y = dataset_array[:,4]  #结论--
#print(X)
#print("--")
#print(Y)
#print("--")
#print(dataset_array[:,,1])#用,分割维度!!!!!!!!!待续array([[[[]]]])!!!!!!!!!!!!!!!待续
#while True:
#    pass

"""
train_test_split里面常用的因数（arguments）介绍：

两种指定方法。1：指定小数。小数范围在0.0~0.1之间，它代表test集占据的比例。
2：指定整数。整数的大小必须在这个数据集个数范围内，总不能指定一个数超出了数据集的个数范围吧。
要是test_size在没有指定的场合，可以通过train_size来指定。（两个是对应关系）。如果train_size也没有指定，那么默认值是0.25.

train_size：和test_size相似。
random_state:这是将分割的training和testing集合打乱的个数设定。如果不指定的话，也可以通过numpy.random来设定随机数。
shuffle和straify不常用。straify就是将数据分层。


random_state：是随机数的种子。

随机数种子：其实就是该组随机数的编号，在需要重复试验的时候，保证得到一组一样的随机数。
比如你每次都填1，其他参数一样的情况下你得到的随机数组是一样的。但填0或不填，每次都会不一样。

随机数的产生取决于种子，随机数和种子之间的关系遵从以下两个规则：

种子不同，产生不同的随机数；种子相同，即使实例不同也产生相同的随机数。

"""


validation_ration = 0.2

rand_seed  = 7

#X_train Y_train 训练集   X_validataion Y_validataion 验证集,

X_train,X_validation,Y_train,Y_validation = model_selection.train_test_split(X,Y,test_size=validation_ration,random_state=rand_seed)
#!!!!!!!!!!!!!!!待续

#测试工具集，使用十折交叉验证来估计算法准确率

scoring = 'accuracy'

#建立模型：通过评估不同的算法，建立模型

iris_models = []



#逻辑回归算法

iris_models.append(('LR',LogisticRegression()))

print(type(iris_models))
#print(type(('LR',LogisticRegression())))
print(iris_models)
print("--")


#线性判别分析法

iris_models.append(('LDA',LinearDiscriminantAnalysis()))

#K近邻法

iris_models.append(('KNN',KNeighborsClassifier()))

#分类回归数/决策树

iris_models.append(('CART',DecisionTreeClassifier()))

#高斯朴素贝叶斯分类器

iris_models.append(('NB',GaussianNB()))

#支持向量机
iris_models.append(('SVM',SVC()))
#iris_models.append(('SVM',SVC()))

#验证每一个模型

results=[]

names = []
print("--")

for name,model in iris_models:

   kfold = model_selection.KFold(n_splits=10,random_state=rand_seed)

   cv_results = model_selection.cross_val_score(model,X_train,Y_train,cv=kfold,scoring=scoring)

   results.append(cv_results)

   names.append(name)

   result_msg = "model=%s: mean=%f (Standard Deviation=%f)" % (name,cv_results.mean(),cv_results.std())
   #result_msg = "模型%s: 均值%f (均方差%f)" % (name,cv_results.mean(),cv_results.std())

   print(result_msg)

#绘制模型评估结果

figure = plt.figure()

figure.suptitle("算法验证比对")

ax = figure.add_subplot(111)

#plt.boxplot(results)

ax.set_xticklabels(names)

plt.grid()#显示网格线
#plt.show()
"""
kind : str

‘line’ : line plot (default)

‘bar’ : vertical bar plot

‘barh’ : horizontal bar plot

‘hist’ : histogram

‘box’ : boxplot

‘kde’ : Kernel Density Estimation plot

‘density’ : same as ‘kde’

‘area’ : area plot

‘pie’ : pie plot

‘scatter’ : scatter plot

‘hexbin’ : hexbin plot
"""