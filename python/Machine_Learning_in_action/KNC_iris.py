#使用K近邻对""鸢尾(Iris)"数据集进行物种分类
#从sklearn.datasets导入iris数据加载器
from sklearn.datasets import load_iris
#从sklearn.model_selection import train_test_split用于 数据分割
from sklearn.model_selection import train_test_split
#从sklearn.preprocessing  import StandardScaler数据标准化模块
from sklearn.preprocessing  import StandardScaler
#sklearn.neighbors import KNeighborsClassifier K近邻分类器
from sklearn.neighbors import KNeighborsClassifier

#使用sklearn.metrics import classification_report模块对预测结果做更加详细的分析
from sklearn.metrics import classification_report


#使用加载器读取数据并且存入变量 iris
iris=load_iris()
#查验数据规模
#print(iris.data.shape)
#查看数据说明
#print(iris.DESCR)
#print(type(iris))#<class 'sklearn.utils.Bunch'>
#print(type(iris.data))#<class 'numpy.ndarray'>
#print(type(iris.target))
#print(iris.target)
x_train,x_test,y_train,y_test=train_test_split(iris.data,iris.target,test_size=0.25,random_state=33)

#对训练和测试的特征数据进行标准化
ss=StandardScaler()
x_train=ss.fit_transform(x_train)
x_test=ss.fit_transform(x_test)

#使用K近邻分类器对测试数据进行类别预测，预测结果储存在变量 y_predict
knc=KNeighborsClassifier()
knc.fit(x_train,y_train)
y_predict=knc.predict(x_test)

#对K近邻分类器在鸢尾花数据上的预测性能进行评估
#使用模型自带的评估函数进行准确性评测
print(" the accuracy of K-Nearest neighbor classifier is ")
print(knc.score(x_test,y_test))

#使用sklearn.metrics import classification_report模块对预测结果做更加详细的分析
print("the accuracy of k-nearest neighbor classifier is ")
print(classification_report(y_test,y_predict,target_names=iris.target_names))
