'''
sklearn里面的sklearn_model_selection.train_test_split
训练数据和测试数据

random_state：是随机数的种子。

随机数种子：其实就是该组随机数的编号，在需要重复试验的时候，保证得到一组一样的随机数。
比如你每次都填1，其他参数一样的情况下你得到的随机数组是一样的。但填0或不填，每次都会不一样。

随机数的产生取决于种子，随机数和种子之间的关系遵从以下两个规则：

种子不同，产生不同的随机数；种子相同，即使实例不同也产生相同的随机数。

!!!!!!!!!!不填的话不一样
'''
import pandas as pd 
from sklearn.model_selection import train_test_split
rand_seed  = 0
name_list=pd.DataFrame({
    "name":["suzuki","sss","ddd","sssd","ccc","xxx","aaa","www","zzz","aaas"],
    "age":[30,20,44,41,42,10,18,19,50,43],
    "department":["HR","Legal","IT","HR","HR","IT",
    "HR","Legal","Legal","IT"],
    "attendance":[1,1,1,0,1,1,1,0,0,1]
})
print(name_list)
print("--")
#name_list_train,name_list_test=train_test_split(name_list,test_size=0.3)#,random_state=rand_seed
name_list_train,name_list_test=train_test_split(name_list,test_size=2)
print(name_list_train)
print("--")
print(name_list_test)
