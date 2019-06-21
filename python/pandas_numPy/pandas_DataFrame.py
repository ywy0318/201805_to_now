#DataFrame对象的构建
#用包含等长的列表或者Numpy数组的字典创建DataFrame对象
import pandas as pd 
from pandas import *
#建立包含等长列表的字典类型
data={'state':['Ohio','ohio','ohio','ohio','ohio'],
'year':[2000,2001,2200,2002,2003],
'pop':[1.5,1.6,1.7,2.4,3.1]}
print(data)
frame_1=DataFrame(data)
print(frame_1)
#建立过程可以指定列的顺序
frame_2=DataFrame(data,columns=['year','pop','state'])
print("---")
print(frame_2)
#和Series一样,DataFrame也可以指定
index_1=['one','two','three','four','five']
frame_3=DataFrame(data,index=index_1)
print(frame_3)
#用由字典类型组成的嵌套字典类型来生成DataFrame对象
#当由嵌套的字典类型生成DataFrame的时候,外部的字典索引会成为列名
#内部的字典索引会成为行名,生成的DataFrame会根据行索引排序
pop_1={'nevada':{2022:2.4,2002:2.9},
'oohi':{2000:2.1,2201:3.2}}
frame_4=pd.DataFrame(pop_1)
print(frame_4)
#除了使用默认的按照行索引排序之外，还可以指定行序列
frame_5=DataFrame(pop_1,[2002,2000,2201,2022])
print(frame_5)

#dataFrame内容访问
#从DataFrame中获取一列的结果，为一个series,可以通过以下两种方式获取
#以字典索引方式获取
print(frame_1['state'])
print("---")
print(frame_1.state)
print("---")
#print(frame_3.index['one'])
print("---")
#print(frame_3.index[1])

