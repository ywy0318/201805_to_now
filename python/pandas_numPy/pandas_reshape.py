#pandas reshape相关函数介绍(pivot,pivot_table,stack,unstack,melt)
'''
pandas需要行列切换的情况,所谓的数据透视表,pivot,pivot_table,unstack,stack,melt
'''
#pivot
#pivot做的就是从元数据构造透视表的过程,透视表是在数据统计中一个数据汇总的方式
import pandas as pd 
import numpy as np 
#原始数据
data={'date':['2018-08-01','2018-08-02','2018-08-03',
'2018-08-04','2018-08-05','2018-08-06','2018-08-07','2018-08-08'],
'variable':['A','A','A','B','B','C','C','C'],
'value':[3.0,4.0,6.0,2.0,8.0,5.0,9.0,7.0]}

df=pd.DataFrame(data=data,columns=['date','variable','value'])
print(df)

#如果value有多个的情况下，列名会变成Hierarchical columns的结构,即MultiIndex

df['value_other']=df['value']*2
df_2=df.pivot(index='date',columns='variable',values=['value','value_other'])
print(df_2)
print(df_2['value_other'])

#melt
#pd.melt或者DataFrame.melt做的是一种和pivot相反的操作,它将一个Dataframe伸展成如下格式
#(一列或多列做identifier变量,其他的列做measured variabel)
#主要的参数为:
#id_vars:identifier的变量的列
#value_vars:measured变量的列
#var_name:变量列的名字
#value_name:value列的名字
#col_level:列索引的级别(如果列是多重索引的话需要)

cheese=pd.DataFrame({'first':['John','Mary'],
'last':['Doe','Bo'],'Height':[5.5,6.0],'weight':[130,150]})
print('\ncheese')
print(cheese)

print('\n')
    
#.idenfier变量为first和last(其他为默认为measured变量)
print(cheese.melt(id_vars=['first','last']))
print('\n')
#自定义的variable 和value列的名字
print(cheese.melt(id_vars=['first','last'],var_name='myvatiable',value_name='myvalue'))

#stack和unstack
#DataFrame.stack和unstack是用来操作MultiIndex的,其实多重索引相当于用
#二维的形式来表征高位数据;
#作为二维数据的行和列都可以来做多重,stack和unstack就是在多重行索引和多重列索引
#之间转换的
tuples=list(zip(*[['bar','bar','baz','baz','foo','foo','qux','qux'],
['one','two','one','two','one','two','one','two']]))

index=pd.MultiIndex.from_tuples(tuples,names=['first','second'])
df_1=pd.DataFrame(np.random.randn(8,2),index=index,columns=['A','B'])
print(df_1)
#.stack方法可以来'压缩'一下列索引，这可能产生一个Series(如果本身列所以就是一重的)
#或者一个DataFrame(列是多重索引)
#这里的结果就是产生一个Series,行索引是三重的
df_3=df.stack()
print(df_3)
print(df_3.index)
#unstack()是相反的操作,即减少一重行索引，增加一重列索引
df_4=df_3.unstack()
print(df_4)

#如果索引是多重的，我们可以指定去'压缩'哪一层的索引,
#对于行索引来说
#行索引:从0开始，最左边最小为0
#列索引:从0开始，最上边最小为0
#也可以不用0和1,用索引层的名字，比如这里的first和second,这样有可能的索引层没有名字
#比如第一次stack的df1，数字和名字但不能混用，可以同时指定多个level值

df_5=df_3.unstack(level=0)
print(df_5)

'''
stack和unstack内部都实现了排序，如果对一个Dataframe进行了stack再进行unstack,
DataFrame会按照行索引排好顺序,
#经过试验列索引不会排好顺序
'''
index_1=pd.MultiIndex.from_product([[2,1],['a','b']])
df_6=pd.DataFrame(np.random.randn(4,1),index=index_1,columns=[100])

#AttributeError: 'Series' object has no attribute 'unstak'
#print(all(df_6.stack().unstak()==df_6.sort_index()))
df_7=pd.DataFrame(np.random.randn(4,3),index=index_1,columns=[100,99,102])
print(df_7)

#!!!!!!!!!!
#对缺失值的处理比较智能
#列是多重索引,最外层不是AABB的形式而是ABBA的形式，列索引看起来怪怪的

columns_1=pd.MultiIndex.from_tuples([('A','cat'),('B','dog'),('B','cat'),('A','dog')])
index_2=pd.MultiIndex.from_product([('bar','baz','foo','qux'),('one','two')],names=['first','second'])

df_8=pd.DataFrame(np.random.randn(8,4),index=index,columns=columns_1)
print(df_8)

#缺失值int和float会填充Nan,时间类型填充NaT,也可以用fill_value=-999指定
#有问题
#df_9=df_8.iloc([0,1,4,7],[1,2]).unstack()
#print(df_9)
'''
pivot_table
pivot_table根据文档上的解释是可以create一些spreadsheet-stype类型的数据表,
主要参数:
data:DataFrame
index:index列,可以多个,pivot不可以
columns:column列
values:value列
aggFuc:聚合函数，可以是多个,相同的index和columns确定的值如果有多个,
则根据这个函数计算除一个值作为这个index和columns的值,默认情况是np.mean
'''

df_11=pd.DataFrame({
'A':['foo','foo','foo','foo','foo',
'bar','bar','bar','bar'],
'B':['one','one','one','two','two','one',
'one','two','two'],
'C':['small','large','large','small','small','large','small','small','large'],
'D':[1,2,2,3,3,4,5,6,7]
})

print(df_11)

print(pd.pivot_table(df_11,index=['A','B'],columns=['C'],values=['D']
,aggfunc=[np.mean,np.sum,np.max]))
