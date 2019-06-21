#朴素贝叶斯分类器对新闻文本数据进行类别预测
#！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！待续
#从sklearn.datasets里导入新闻数据抓取器fetch_20newsgroups
from sklearn.datasets import fetch_20newsgroups
#从sklearn.model_selection 导入train_test_split
from sklearn.model_selection import train_test_split

#从sklearn.feature_extraction.text导入文本特征向量转化模块
from sklearn.feature_extraction.text import CountVectorizer

#从sklearn.naive_bayes里面导入朴素贝叶斯模型
from sklearn.naive_bayes import MultinomialNB

#从sklearn,metrics里导入classification_report用于详细的分类性能报告
from sklearn.metrics import classification_report

#与之前预存的数据不同，fetch_20newsgroups需要即时从互联网下载数据
news=fetch_20newsgroups(subset="all")#下载太慢改为读取本地文件
#df_train=pd.read_csv("F:/zzpersom/dataset/561369_breast_cancer/breast-cancer-train.csv")


#查验数据规模和细节
print(len(news.data))
print(news.data[0])

print(type(news))
print("type(new.data)")
print(type(news.data))
print("type(new.target)")
print(type(news.target))
print("news.target")
print(news.target)
#20类新闻文本数据分割
#随机采样25%的数据样本作为测试集
x_train,x_test,y_train,y_test=train_test_split(news.data,news.target,test_size=0.25,random_state=33)

#使用朴素贝叶斯分类器对新闻文本数据进行类别预测
vec=CountVectorizer()

x_train=vec.fit_transform(x_train)
x_test=vec.fit_transform(x_test)


#从使用默认配置初始化贝叶斯模型
mnb=MultinomialNB()
#利用训练数据对模型参数进行估计
mnb.fit(x_train,y_train)
#对测试样本进行类别预测，结果存储在变量y_predict
y_predict=mnb.predict(x_test)

print("*"*8)
#对朴素贝叶斯分类器在新闻文本数据上的表现性能进行评估
print("the accuracy of naive bayes classifier is ")
print(mnb.score(x_test,y_test))

print("classification_report")
print(y_test,y_predict,target_names=news.target_names)
