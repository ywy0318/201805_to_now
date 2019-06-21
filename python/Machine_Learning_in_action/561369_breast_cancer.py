#-*-coding:utf-8 -*-
#print("中文测试")
import numpy as np 
import pandas as pd 
import warnings
import matplotlib.pyplot as plt 
from sklearn.linear_model import LogisticRegression

#其他消除警告的方法
warnings.filterwarnings("ignore")

df_train=pd.read_csv("F:/zzpersom/dataset/561369_breast_cancer/breast-cancer-train.csv")
df_test=pd.read_csv("F:/zzpersom/dataset/561369_breast_cancer/breast-cancer-test.csv")
print(type(df_train))
print(type(df_test))
#print(df_train.head(3))
#print(df_test.head(3))
#选取Clump--Thickness--Cell Size作为特征,构建测试集中的政府分类样本
df_test_negetive=df_test.loc[df_test['Type']==0][['Clump Thickness','Cell Size']]
df_test_positive=df_test.loc[df_test['Type']==1][['Clump Thickness','Cell Size']]
#print(type(df_test_negetive))
#print(type(df_test_positive))
#print(df_test_negetive.head(3))
#print(df_test_positive.head(3))
#绘制图中良性的肿瘤样本点，标记为红色的0
plt.scatter(df_test_negetive['Clump Thickness'],df_test_negetive['Cell Size'],marker='o',s=200,c='red')
plt.scatter(df_test_positive['Clump Thickness'],df_test_positive['Cell Size'],marker='x',s=150,c='black')

plt.xlabel("Clump Thickness")
plt.xlabel("Cell Size")
#plt.show()
#利用numpy中的random函数随机采样直线的截距和系数
intercept=np.random.random([1])#截距
coef=np.random.random([2])#系数

lx=np.arange(0,11)
ly=(-intercept-lx*coef[0])/coef[1]
#print()
#plt.plot(lx,ly,c='blue')
#plt.show()
#传入参数后即可消除警告：model=LogisticRegression(solver=’liblinear’)  。
#lr=LogisticRegression(solver=’liblinear’)
lr=LogisticRegression()
#print(type(lr))

#使用前10条训练样本学习直线的系数和截距
#lr.fit(df_train[["Clump Thickness","Cell Size"]][:10],df_train['Type'][:10])


#使用所有训练样本学习直线的系数和截距
lr.fit(df_train[["Clump Thickness","Cell Size"]],df_train['Type'])
print("lr.score(df_test[['Clump Thickness','Cell Size']],df_test['Type'])",end="--:")
print(lr.score(df_test[['Clump Thickness','Cell Size']],df_test['Type']))
'''
print("lr.coef_",end="--:")
print(lr.coef_)
print("lr.intercept_",end="--:")
print(lr.intercept_)
print("lr.score(df_test[['Clump Thickness','Cell Size']],df_test['Type'])",end="--:")
print(lr.score(df_test[['Clump Thickness','Cell Size']],df_test['Type']))
'''
#print("Test accuracy(10 train samples):"lr.score(df_test[['Clump Thickness','Cell Size']],df_test['Type']))
#print(df_train[["Clump Thickness","Cell Size"]][:10])
#print(df_train['Type'][:10])
print(type(lr.intercept_))
print("   coef   ",end="--:")
print(coef)
#print(coef[1])
print("intercept_",end="--:")
print(intercept)
#print(type(coef))
#print(type(lr.coef_))
intercept=lr.intercept_
coef=lr.coef_[0,:]
'''
print(coef[0])
print(coef[1])
print(intercept)
'''
print("-*-after update -*-")
print("   coef   ",end="--:")
print(coef)
#print(coef[1])
print("intercept_",end="--:")
print(intercept)
ly=(-intercept-lx*coef[0])/coef[1]
plt.plot(lx,ly,c='blue')
plt.show()