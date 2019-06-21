#matplotlib绘制图片
#3.>绘制violinplot和heatmap
#violinplot:功能类似于直方图,反应值的分布情况,直方图一般来说数据上是一维数组
#而小提琴图的数据是{key1:一位数据,key2:一维数据}
#heatmap:用于反应{key1:一维数组,key2:反应一维数据}中各个key value的相互关系
import numpy as np 
import matplotlib.pyplot as plt 
import pandas as pd 
import seaborn as sns 

df=pd.DataFrame(data=[[20,167,75,65],[22,183,75,93],[22,156,54,95],[23,158,51,96],
[23,158,51,96],[23,167,62,91],[22,192,87,68]],columns=['age','height(cm)','weight(kg)','athletic score'])

fig=plt.figure(figsize=(10,10))

plt.subplot(2,3,1)
#y的标题为age，数据为df中age那一了
sns.violinplot(y=df.columns[0],data=df)
plt.title('all '+df.columns[0])#设置标题

plt.subplot(2,3,2)
#y的标题为age，数据为df中age那一了
sns.violinplot(y=df.columns[1],data=df)
plt.title('all '+df.columns[1])#设置标题

plt.subplot(2,3,3)
#y的标题为age，数据为df中age那一了
sns.violinplot(y=df.columns[2],data=df)
plt.title('all '+df.columns[2])#设置标题

#绘制出系数(各列)相互关系图
corrmat=df.corr()
plt.figure(figsize=(10,8))
sns.heatmap(data=corrmat,annot=True)
plt.show()