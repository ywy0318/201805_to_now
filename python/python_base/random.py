import random
import sys 
import numpy as np 
'''
random.random()用于生成一个0到1的随机浮点数:0<=n<1.0
random.uniform(a,b),用于生成一个指定范围内的随机浮点数,两个参数其中一个是上限,一个是下限
random.randint(a,b),用于生成一个指定范围内的整数,其中参数a是下限，参数b是上限
random.randrange([start],stop,[step])从指定范围内,按指定基数递增的集合中获取一个随机数
random.choice从序列中获取一个随机元素,函数原型为:random.choice(sequence);
参数sequence表示一个有序类型,sequence不是一种特定的类型,而是泛指一系列的类型，list,tuple,字符串都属于sequence
random.shuffle(x[,random]),用于将一个列表中的元素打乱
random.sample(squence,k)从指定序列中随机获取指定长度的片段，sample函数不会修改原有序列

'''
print(random.uniform(10,20))
print(random.uniform(20,10))
print(random.randint(10,20))
print(random.randint(20,20))
print(random.randrange(10,100,2))#与random.choice(range(10,100,2))等效
print(random.choice(range(10,100,2)))

print(random.choice("hello world"))
print(random.choice(['hello','world','sss','boy']))
print(random.choice(('tuple','list','dict')))

p=['python','c','java','c++','c#','scale']
random.shuffle(p)
print(p)

list_1=[1,2,3,4,5,6,7,8,9,10]
slice_1=random.sample(list_1,5)
print(slice_1)
print(list_1)

#随机整数
print(random.randint(0,99))

#随机选取0到101之间的偶数
print(random.randrange(0,101,2))

print(np.random.random((2,6)))