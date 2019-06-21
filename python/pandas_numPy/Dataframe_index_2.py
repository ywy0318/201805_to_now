import pandas as pd 
import random
'''
rnd_1=[random.randrange(1,20) for x in range(1000)]
rnd_2=[random.randrange(1,20) for x in range(1000)]
rnd_3=[random.randrange(1,20) for x in range(1000)]
fecha=pd.date_range("2012-4-10","2015-1-4")
'''
rnd_1=[random.randrange(1,20) for x in range(20)]
rnd_2=[random.randrange(1,20) for x in range(20)]
rnd_3=[random.randrange(1,20) for x in range(20)]
fecha=pd.date_range(start="4/8/2019",periods=20)
#
data=pd.DataFrame({"fecha":fecha,"rnd_1":rnd_1,"rnd_2":rnd_2,"rnd_3":rnd_3})
print(data)
print("*"*7)
#print(rnd_1)
#print(random.randrange(1,20))

##基本统计量--数量---均值--标准差--最小值--下四分位--中位数--最大值
# --极差max-min(range)--var(变异系数=std/mean(标准差/均值))
#--dis(四分位间距(75%-25%)
#print(data.describe())
print("*"*5)
#print(data.corr())

#data.corr()#相关系数矩阵,给出任意两个变量的相关系数
#data.corr()[u“好”]#只显示"好""与其他感情色彩的相关系数
#data.corr()[data[u'哭']]#两个感情色彩的相关系数
#print(data.corr()[])
print(data[1:5])
print("*"*5)
print(data[2:5][['rnd_2','rnd_3']])

#.loc函数
print("*"*5)
print(data.loc[0:5,"fecha":"rnd_2"])
print("*"*5)
#iloc是按照索引的位置进行选取，iloc不关心索引的具体值是多少
#只关心位置
print(data.iloc[1:2,1:2])
print(data.iloc[[1,3,5],[0,2]])
#at的使用方法与loc类似,但是比loc有更快的访问数据的速度,而且只能访问单个元素,不能访问多个元素
#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!有问题
#print(data.iat["fecha","rnd_1"])
#data.at[1,1]
#print(data.at[1,1])