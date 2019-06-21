import numpy as np
import pandas as pd 
#Pandas设置数据
#根据loc和iloc设置---#生成6行4列位置
#dates_1=pd.date_range('20190308',periods=6)
#df_for_dates_1=pd.DataFrame(np.random.randn(6,4),index=dates_1,columns=['A','B','C','D'])
#np.arange(24)产生一个0-23的数字排列
dates=pd.date_range("20190308",periods=6)
df=pd.DataFrame(np.arange(24).reshape((6,4)),index=dates,columns=['A','B','C','D'])
print(df)
#单点设置
df.iloc[2,2]=999
df.loc['2019-03-13','D']=777
print("----after-set-data----")
print(df)
#根据条件设置
#将df.A大于0的值改变
df[df.A>0]=666
#根据行或者列设置
print("---")
print("df['F']=np.nan")
df['F']=np.nan
print(df)
#添加数据
print("---")
print("df['E']=pd.Series([1,2,3,4,5,6],index=pd.date_range('20190308',periods=6))")
#增加一列
df['E']=pd.Series([1,2,3,4,5,6],index=pd.date_range('20190308',periods=6))
print(df)


print("process-drop-data")
print("----")
#对0进行操作,1对列进行操作,any:只要存在NaN即可drop掉
#all:必须是全部是NaN才可drop
print("df.dropna(axis=0,how='any'#)")
#print(df.dropna(axis=1,how='any'))


#使用fillna()函数替换NaN值
#将NaN值替换为333
print("----")
print("df.fillna(value=333)")
#print(df.fillna(value=333))

#使用inull()函数判断数据是否丢失
print("---")
#矩阵用布尔来进行表示,是NaN为true,不是Nan为false
print("pd.isnull(df)")
print(pd.isnull(df))
#判断数据中是否会存在NaN值
print("np.any(df.isnull())")
print(np.any(df.isnull()))

#Pandas从文件导入导出
#pandas可以读取与存取像csv,excel,json,html,pickle等格式的资料
'''
data=pd.read_csv('test1.csv')#读取csv文件
data.to_pickle('test2.pickle')#将资料存取成pickle文件
#其他文件导入导出方式相同
'''
