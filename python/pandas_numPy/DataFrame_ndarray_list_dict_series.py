#python数据类型dataframe,ndarray,list,dict,series之间转换
'''
dataframe是pandas的数据类型
ndarray是numpy的数据类型
list和dict是python的数据类型
series是pandas的一种数据类型,是一个定长的有序的字典，
他把索引和值映射起来了
'''
import numpy as np 
import pandas as pd 
from pandas import Series,DataFrame 
import sys 

#list
data_list=[[2000,'ddda',1.3],
[2001,'ddds',1.4],[2002,'dddd',1.5],[2003,'ffff',1.6],[2004,'gggg',1.7]]

#list to series
data_list_to_series=Series(data=data_list,index=['one','two','three','four','five'])
print('\nlist to series')
print(data_list_to_series)
print(type(data_list_to_series))
print(data_list_to_series.shape)

#list to dataframe
data_list_to_dataframe=DataFrame(data_list,index=['one','two','three','four','five'],columns=['year','state','pop'])
print('\nlist to dataframe')
print(data_list_to_dataframe)
print(type(data_list_to_dataframe))
print(data_list_to_dataframe.shape)

#list to array
print("\nlist to array")
data_list_to_array=np.array(data_list)
print(data_list_to_array)
print(type(data_list_to_array))
print(data_list_to_array.shape)

#dict
data_dict={'state':['sss','ddd','aaa','xxx','zzz'],
            'year':[2000,2001,2002,2003,2004],
            'pop':[1.3,1.5,1.7,1.8,2.3]}

#dict to series,若不指定index,data的key充当Series的index
data_dict_to_series=Series(data=data_dict)
print("\ndict to series")
print(data_dict_to_series)
print(data_dict_to_series.shape)
print(type(data_dict_to_series))

#dict to dataframe,若不指定columens,data的key充当dataFrame的columns
data_dict_to_dataframe=DataFrame(data=data_dict)
print('\ndict to dataframe')
print(data_dict_to_dataframe)
print(type(data_dict_to_dataframe))
print(data_dict_to_dataframe.shape)

#array
#使用array
#array to datafram
# data_list_to_array
data_array_to_dataframe=DataFrame(data=data_list_to_array,index=['1','2','3','4','5'],columns=['year','state','pop'])
print('\narray to datafram')
print(data_array_to_dataframe)
print(type(data_array_to_dataframe))
print(data_array_to_dataframe.shape)

#series to array
#data_dict_to_series

series_to_array_1=data_dict_to_series.as_matrix()
series_to_array_2=Series.as_matrix(data_dict_to_series)
print('\nseries to array')
print(series_to_array_1)
print(series_to_array_2)
print(type(series_to_array_1))
print(type(series_to_array_2))
print(series_to_array_1.shape)
print(series_to_array_2.shape)

#dataframe to array
data_dataframe_to_array_1=DataFrame.as_matrix(data_list_to_dataframe)
data_dataframe_to_array_2=data_list_to_dataframe.as_matrix()
data_dataframe_to_array_3=data_list_to_dataframe.values
data_dataframe_to_array_4=np.array(data_list_to_dataframe)

print('\ndataframe to array')
print(data_dataframe_to_array_1)
print(data_dataframe_to_array_2)
print(data_dataframe_to_array_3)
print(data_dataframe_to_array_4)
print(data_dataframe_to_array_1.shape)
print(data_dataframe_to_array_2.shape)
print(data_dataframe_to_array_3.shape)
print(data_dataframe_to_array_4.shape)
print(type(data_dataframe_to_array_1))
print(type(data_dataframe_to_array_2))
print(type(data_dataframe_to_array_3))
print(type(data_dataframe_to_array_4))

#dataframe to dict
#outtype的参数为dict,list,series,records
#dict返回的是 dict of dict ,list返回的是list的字典，
# series返回的是序列的字典，records返回的是字典的列表
dict_dict=data_array_to_dataframe.to_dict(orient='dict')
dict_list=data_array_to_dataframe.to_dict(orient='list')
dict_series=data_array_to_dataframe.to_dict(orient='series')
dict_records=data_array_to_dataframe.to_dict(orient='records')
print('\ndataframe to dict')
print("[--line_num--=:(%s)]" % (sys._getframe().f_lineno))
print(dict_dict)
print('\n')
print(dict_list)
print('\n')
print(dict_series)
print('\n')
print(dict_records)

print(type(dict_dict))
print(type(dict_list))
print(type(dict_series))
print(type(dict_records))

#print(dict_dict.shape)
'''
Series
Series是一个一维的类似的数组对象,包含一个数组的数据(任何numpy的数据类型)和一个与数组关联的数据标签，
被叫做索引，最简单的Series是由一个数组的数据构成
Series是一个定长的，有序的字典，因为它把索引和值映射起来了
Series与numpy中的一维array类似,二者与python基本的数据结构list很相似,
区别是:list中的原始可以是不同的数据类型,Array和Series则只允许存储相同的数据类型,
Time-Series:以时间为索引的Series

DataFrame
DataFrame:二维的表格型数据结构,功能与R中的data.frame相似，可以将DataFrame理解为Series的容器
有很多方法来构建一个DataFrame,最常用的一个是用一个相等长度列表的字典或Numpy数组
像Series一样，DataFrame的Values属性返回一个包含在DataFrame中的数据的二维ndarray
Panel,三维的数组，可以理解为DataFrame的容器
可能的传递到DataFrame的构造器
二维ndarray 一个数据矩阵，有可选的行标和列标
数组，列表或元祖的字典， 每一个序列成为dataframe中的一列，所有的序列必须有相同的长度
numpy的结构/记录数组  和"数组字典"一样处理
Series的字典,  每一个值成为一列，没有明显的传递索引，将结合每一个Series的索引来形成结果的行索引
字典的字典   每一个内部的字典成为一列,和Series的字典一样，结合键值来形成航索引
字典或者Series的列表  每一项成为DataFrame中的一列,结合字典键或Series索引形成DataFrame的列标
列表或元祖的列表  和"二维ndarray"一样处理
另一个DataFrame dataframe的索引降备使用，除非传递另一个
numpy伪装数组(maskedArray)      除了蒙蔽值在DataFrame中的成为NA/丢失数据之外，其他和‘二维ndarray’一样

'''