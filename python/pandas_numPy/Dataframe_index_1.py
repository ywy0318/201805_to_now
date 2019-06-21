#pandas中Dataframe索引.ix,.iloc,.loc的使用以及区别
import pandas as pd 
#定义一个pandas的DataFrame
data=pd.DataFrame({
    'A':[1,2,3],
    'B':[4,5,6],
    'C':[7,8,9],
    
},index=["a","b","c"])#index横向索引,index=["a","b","c"],如果不指定索引，则会默认添加0-----n-1的索引 

print("--")
print(data)
print("--")
#.loc的使用
#.loc[],中括号里面是先行后列，以逗号分隔,行和列分别是行标签和列标签，

print(data.loc["b","B"])
print("--")
#选择一个区域的例子,行列标签之间用逗号分开，行标签与行标签之间，列标签与列标签之间用冒号隔开,
#.loc[]是用行列标签来进行数据选择的
print(data.loc["a":"c","B":"C"])
print("-"*5)
print("iloc")
#.iloc[行索引,列索引],加上分号是用来选择一个区域
print(data.iloc[0,0])
print("*"*5)
print(data.iloc[0:3,0:3])
print("*"*5)
#.ix[]
print(".ix")
print(data.ix[0,0])
print(data.ix[0:3,0:3])



