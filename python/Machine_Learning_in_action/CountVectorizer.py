#使用counterVectorizer并且不去掉停用词的条件下，对文本特征进行量化的朴素贝叶斯分类性能测试


from sklearn.datasets import fetch_20newsgroups
from sklearn.model_selection import train_test_split
#
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfVectorizer

#从sklearn.naive_bayes 导入朴素贝叶斯分类器
from sklearn.naive_bayes import MultinomialNB

from sklearn.metrics import classification_report

news=fetch_20newsgroups(subset='all')
print(type(news))

#print(news.shape)
print(type(news.data))
#print(news.data.shape)
print(type(news.target))
print(news.target.shape)
x_train,x_test,y_train,y_test=train_test_split(news.data,news.target,test_size=0.25,random_state=33)
#采用默认的配置对CounterVectorizer进行初始化(默认配置不去除英文停用词),并且赋值给变量conut_vec

#print()
count_vec=CountVectorizer()

tfidf_vec=TfidfVectorizer()
x_tfidf_train=tfidf_vec.fit_transform(x_train)
x_tfidf_test=tfidf_vec.fit_transform(x_test)
#x_tfidf_train=tfidf_vec.transform(x_train)
#x_tfidf_test=tfidf_vec.transform(x_test)

#只使用词频统计的方式将原始训练和测试文本转化为特征向量
x_count_train=count_vec.fit_transform(x_train)
#x_count_train=count_vec.transform(x_train)
#x_count_test=count_vec.fit_transform(x_test)
x_count_test=count_vec.transform(x_test)

mnb_count=MultinomialNB()


mnb_tfidf=MultinomialNB()
mnb_tfidf.fit(x_tfidf_train,y_train)
print(mnb_tfidf.score(x_tfidf_test,y_test))
y_tfidf_predict=mnb_tfidf.predict(x_tfidf_test)
print(classification_report(y_test,y_tfidf_predict,target_names=news.target_names))

#使用朴素贝叶斯分类器,对counterVectorizer(不去除停用词)后的训练样本进行参数学习
mnb_count.fit(x_count_train,y_train)
print(mnb_count.score(x_count_test,y_test))
y_count_predict=mnb_count.predict(x_count_test)
print(classification_report(y_test,y_count_predict,target_names=news.target_names))

