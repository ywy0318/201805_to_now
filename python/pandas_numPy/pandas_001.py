'''

[pandas 官方文档]((http://pandas.pydata.org/)


pandas是python的一个数据分析包，该工具为解决数据分析任务而创建
pandas纳入大量库和标准数据模型，提供高效的操作数据集所需的工具
提供了大量能使我们快速便捷的处理数据的函数和方法
pandas是字典形式，基于Numpy创建，让numpy为中心的应用变得更加简单

DataFrame是表格型数据结构，包含一组有序的列，每列可以是不同的值类型,
DataFrame有行索引和列索引，可以看成由Series组成的字典


Series: 一维数组，与Numpy中的一维array类似。二者与Python基本的数据结构List也很相近，
其区别是：List中的元素可以是不同的数据类型，
而Array和Series中则只允许存储相同的数据类型，这样可以更有效的使用内存，提高运算效率。

DataFrame：二维的表格型数据结构。很多功能与R中的data.frame类似。
可以将DataFrame理解为Series的容器。以下的内容主要以DataFrame为主。

Panel: 三维数组，可以理解为DataFrame的容器。


'''
import numpy as np
import pandas as pd 
s=pd.Series([1,2,3,np.nan,5,6])
#print(s)#索引在左边,值在右边

dates=pd.date_range('20190307',periods=6)
df=pd.DataFrame(np.random.randn(6,4),index=dates,columns=['A','B','C','D'])#生成6行4列位置
#print(df)#输出6行4列的表格
#print(df['B'])


#F列!!!!!!!!!!!!!!!!!有问题
'''
df_1=pd.DataFrame({ 'A':1.,
                    'B':pd.Timestamp('20190307'),
                    'C':pd.Series(1,index=list(range(4)),dtype='float32'),
                    'D':np.array([3]*4,dtype='int32'),
                    'E':pd.Categorical({"test","train","test","train"}),
                    'F':{'foo','foo','foo','foo'}})
                    
print(df_1)

#print(df_1)
print(df_1.dtypes)
print(df_1.index)#行的序号
#Int64Index([0,1,2,3],dtype='int64')
print(df_1.column)#列的序号名字
print(df_1.values)#把每个值打印出来
print(df_1.describe())#数字总结
print(df_1.T)#翻转数据
#axis等于1按列进行排序,如ABCDEF然后ascending倒序进行显示
print(df_1.sort_index(axis=1,ascending=False))
#按值进行排序
print(df_1.sort_values(by='E'))
'''
"""
Pandas选择数据
"""
dates_1=pd.date_range('20190308',periods=6)
#生成6行4列位置
df_for_dates_1=pd.DataFrame(np.random.randn(6,4),index=dates_1,columns=['A','B','C','D'])
print("--the whole dataB")
print(df_for_dates_1)
print("--.dtypes")
print(df_for_dates_1.dtypes)
print(".index--index-name")
print(df_for_dates_1.index)
print("--columns--.columns")
print(df_for_dates_1.columns)
print(".values--foreach--")
print(df_for_dates_1.values)
#数据总结
print("---data_sum---.describe()")
print(df_for_dates_1.describe())
#数据翻转
print("--data--reverse--.T")
print(df_for_dates_1.T)
print("-------------")
#axis等于按列进行排序，ABCDEF,然后ascnding倒序显示
print(".sort_index(axis=1,ascending=False)")
print(df_for_dates_1.sort_index(axis=0,ascending=False))
#print(df_for_dates_1.sort_index(axis=2,ascending=False))
#print(df_for_dates_1.sort_index(axis=3,ascending=False))
#print(df_for_dates_1.sort_index(axis=4,ascending=False))
print("-------------")
#按值进行排序
print("--.sort_values(by='B')--")
print(df_for_dates_1.sort_values(by='B'))
#或者df.A选择某列
print("--df['A']")
print(df_for_dates_1['A'])

#切片选择
#两次进行选择,第一次切片选择，第二次按照筛选条件进行选择
print("---df_for_dates_1[0:3],df_for_dates_1['20190310':'20190314']---")
#print(df_for_dates_1[0:3],df_for_dates_1['20190310':'20190314'])
print(df_for_dates_1[0:3])#按照行切片的
print(df_for_dates_1['20190310':'20190314'])

print("------")
print("df_for_dates_1.loc['20190312',['A','B']]")
#按照行标签进行选择，精确选择
print(df_for_dates_1.loc['20190312',['A','B']])

#根据序列iloc-行号进行选择数据
#输出第三行第一列的数据
print("---")
print("df_for_dates_1.iloc[3,1]")
print(df_for_dates_1.iloc[3,2])

#切片选择
print("---")
print("-df_for_dates_1.iloc[3:5,0:2]-")
print(df_for_dates_1.iloc[3:5,0:2])

#进行不连续筛选
#print("---")!!!!!!有问题
#print("df_for_dates_1.iloc([1,2,4],[0,2])")
#print(df_for_dates_1.iloc([0,1,3],[0,2],))

#根据混合的两种ix!!!!!!!!!!!!!!有问题
#print("---")
#print("df_for_dates_1._ix[:3,['A','C']]")
#print(df_for_dates_1._ix[:2,['A','C']])


#根据判断筛选
#筛选出df.A大于0的元素,bool条件筛选
print("---")
print("df_for_dates_1.A>0")
print(df_for_dates_1.A>0)


