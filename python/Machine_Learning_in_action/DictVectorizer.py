#DictVectorizer对使用字典存储的数据进行特征抽取和向量化
#定义一组字典列表,用来表示多个数据样本(每个字典代表一个数据样本)
#从sklearn.feature_extraction导入DictVectorizer
from sklearn.feature_extraction import DictVectorizer
measurements=[{'city':'dubai','temp':22.00},
{'city':'london','temp':12.00},
{'city':'san','temp':19.00}]

#初始化DictVectorizer特征抽取器
vec=DictVectorizer()
#输出转化之后的特征矩阵
print(vec.fit_transform(measurements).toarray())
print(vec.fit_transform(measurements).toarray().shape)
#输出各个维度的特征含义
print(vec.get_feature_names())