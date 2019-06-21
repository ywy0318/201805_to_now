import numpy as np
import pandas as pd 

#Pandas合并数据
#axis合并方向
df_1=pd.DataFrame(np.ones((3,4))*0,columns=['a','b','c','d'])
df_2=pd.DataFrame(np.ones((3,4))*1,columns=['a','b','c','d'])
df_3=pd.DataFrame(np.ones((3,4))*2,columns=['a','b','c','d'])

#df_4 和df_5的index不同
df_4=pd.DataFrame(np.ones((3,4))*0,columns=['a','b','c','d'],index=[1,2,3])
df_5=pd.DataFrame(np.ones((3,4))*1,columns=['a','b','c','d'],index=[2,3,4])
#0表示竖项合并1表示横向合并,ingnore_index重置序列in
print("---")
print("df_1")
print(df_1)

print("---")
print("df_1")
print(df_2)

print("---")
print("df_1")
print(df_3)



print("---")
print("res=pd.concat([df_1,df_2,df_3],axis=0,ignore_index=True)")
res=pd.concat([df_1,df_2,df_3],axis=0,ignore_index=True)
print(res)

print("--res_1--")
print("pd.concat([df_4,df_5],axis=0,join='outer')")
#行往外进行合并 join：参数为‘outer’或‘inner’；
#res_1=pd.concat([df_1,df_2],axis=1,join='outer')
res_1=pd.concat([df_4,df_5],axis=0,join='outer')
print(res_1)

print("--res_2--")
print("pd.concat([df_4,df_5],axis=1,join='outer')")
#行往外进行合并 join：参数为‘outer’或‘inner’；
#res_1=pd.concat([df_1,df_2],axis=1,join='outer')
res_2=pd.concat([df_4,df_5],axis=1,join='outer')
print(res_2)


print("--res_3--")
print("pd.concat([df_4,df_5],axis=0,join='inner')")
#行往外进行合并 join：参数为‘outer’或‘inner’；
#res_1=pd.concat([df_1,df_2],axis=1,join='outer')
res_3=pd.concat([df_4,df_5],axis=0,join='inner')
print(res_3)

print("--res_4--")
print("pd.concat([df_4,df_5],axis=1,join='inner')")
#行往外进行合并 join：参数为‘outer’或‘inner’；
#res_1=pd.concat([df_1,df_2],axis=1,join='outer')
res_4=pd.concat([df_4,df_5],axis=1,join='inner')
print(res_4)

print("--res_5--")
print("pd.concat([df_4,df_5],axis=1,join='inner')")
#行往外进行合并 join：参数为‘outer’或‘inner’；
#res_1=pd.concat([df_1,df_2],axis=1,join='outer')
#以df_4的序列进行合并，df_5中没有的序列用NaN值填充
res_5=pd.concat([df_4,df_5],axis=1,join_axes=[df_4.index])
print(res_5)

s1=pd.Series([1,2,3,4],index=['a','b','c','d'])
print("--s1--")
print(s1)

print('--res_6--')
print("df_1.append(df_2,ignore_index=True)")
#将df_2合并到df_1的下面，并且重置index
res_6=df_1.append(df_2,ignore_index=True)
print(res_6)

print('--res_7--')
print("df_1.append(s1,ignore_index=True)")
#将s1合并到df_1的下面，并且重置index
res_7=df_1.append(s1,ignore_index=True)
print(res_7)

#pandas合并merge
#依据一组key合并
left=pd.DataFrame({'key':['k0','k1','k2','k3'],
                    'A':['A0','A1','A2','A3'],
                    'B':['B0','B1','B2','B3']})
print(left)

right=pd.DataFrame({'key':['k0','k1','k2','k3'],
                    'C':['C0','C1','C2','C3'],
                    'D':['D0','D1','D2','D3']
                    })
print(right)
print("---")
print("pd.merge(left,right,on='key')")
res_8=pd.merge(left,right,on='key')
print(res_8)
print("-------------------")
#依据两组key合并
left_1=pd.DataFrame({'key1':['k0','k0','k1','k2'],
                    'key2':['k0','k1','k0','k1'],
                    'A':['A0','A1','A2','A3'],
                    'B':['B0','B1','B2','B3']})
                    
print(left_1)
right_1=pd.DataFrame({'key1':['k0','k1','k2','k3'],
                    'key2':['k0','k0','k0','k0'],
                    'C':['C0','C1','C2','C3'],
                    'D':['D0','D1','D2','D3']})
print(right_1)
#内敛合并
res_9=pd.merge(left_1,right_1,on=['key1','key2'],how='inner')
#外联合并
res_10=pd.merge(left_1,right_1,on=['key1','key2'],how='outer')
#左联合并
res_11=pd.merge(left_1,right_1,on=['key1','key2'],how='left')
#右联合并
res_12=pd.merge(left_1,right_1,on=['key1','key2'],how='right')
print(res_9)
print(res_10)
print(res_11)
print(res_12)

print("---")
#indicator合并
df_5=pd.DataFrame({'col_1':[0,1],
                    'col_left':['a','b']})
print(df_5)
df_6=pd.DataFrame({'col_1':[1,2,3],
                    'col_right':[2,2,2]
})
print(df_6)
print("---")
#依据col1进行合并，并且启用indicator=True输出每项合并方式
res_13=pd.merge(df_5,df_6,on='col_1',how='outer',indicator=True)

print(res_13)
print(pd.merge(df_5,df_6,how='outer',indicator=True))
print("---")
#自定义indicator_column名称
res_14=pd.merge(df_5,df_6,on='col_1',how='outer',indicator='indicator_column')
print(res_14)
print(pd.merge(df_5,df_6,how='outer',indicator='indicator_column'))
print("---")
#依据index合并

'''
left_2=pd.DataFrame({'A':['A0','A1','A2']},
{'B':['','','']},
index=['K0','K1','K2'])
print(left_2)

print('---')

right_2=pd.DataFrame({'C':['C0','C1','C2']},
{'D':['D0','D1','D2']},
index=['K0','K2','K3'])
print(right_2)

#根据index索引进行合并并且选择外联合并
res_15=pd.merge(left_2,right_2,left_index=True,right_index=True,how='outer')
res_16=pd.merge(left_2,right_2,left_index=True,right_index=True,how='inner')
print(res_15)
print(res_16)
'''