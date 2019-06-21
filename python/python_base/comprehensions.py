#python的各种推导式(列表推导式,字典推导式,集合推导式)
#推导式comprehensions(又称解析式),是python的一种独特的特性，
# 推导式是可以从一个数据序列构建另一个数据序列的结构体，
import sys
#列表(list)推导式
#字典(dict)推导式
#集合(set)推导式


#1.>列表推导式
#1.使用[]生成list
'''
variable=[out_exp_res for out_exp in input_list if out_exp==2]
    out_exp_res:列表生成元素表达式,可以是有返回值的函数
    for out_exp in input_list:迭代input_list将out_exp传入out_exp_res表达式中
    if out_exp==2:  根据条件过滤哪些值可以

'''
#例1:
multiples=[i for i in range(30) if i%3 is 0]
print(multiples)#output:[0,3,6,9,12,15,18,21,24,27]

#列2
def squared(x):
    pass
    return x*x
multiples_1=[squared(i) for i in range(30) if i % 3 is 0]
print(multiples_1)#output:[0,9,36,81,144,225,324,441,576,729]

#运算符优先级
#not > and > or。
print('\na')
#例3
a=[i for i in range(100) if not (i%2) and (i%3)]#注意列表是中括号 三项内容 变量 循环体 判断条件
print(a)
print('\n') 

#2.>使用()生成generator
#将两表推导式的[]改成()即可得到生成器
multiples_2=(i for i in range(30) if i % 3 is 0)
print(type(multiples_2))#output:<type 'generator'>


#2.>字典推导式
#字典推导和列表推导的使用方法是类似的,只不过中括号改成大括号,直接举例说明
#例1:大小写key合并
mcase={'a':10,'b':34,'A':7,'B':3}
mcase_frequency={
    k.lower():mcase.get(k.lower(),0)+mcase.get(k.upper(),0)
    for k in mcase.keys()
    if k.lower() in ['a','b']

}
print(mcase_frequency)#output;{'a':17,'b':37}

#2.>快速更换key和value
mcase_1={'a':10,'b':34}

mcase_1_frequency={v:k for k,v in mcase_1.items()}
print(mcase_1_frequency)#output:{10:'a',34:'b'}


print('\nb')
#字典推导式
b={i:i%2==0 for i in range(20)}#字典推导式注意那个独特的冒号':'三项内容 变量 条件 循环
print(b)


#3.>集合推导式
#它们跟列表推导式是类似的,唯一的区别在于它使用大括号{}
#集合(set)是一个无序不重复元素的序列,它的主要作用如下:去重,把一个列表编程集合,就自动去重了
#关系测试，测试两组数据之前的交集，差集，并集等关系
#set和dict类似，也是一组key的集合,但是不存储value,由于key不能重复,所以在，set中没有重复的key
#可以使用大括号{}或set()函数创建集合,
#注意:创建一个空集合必须用set()而不是{},因为{}是用来创建一个空字典的
#例1.:
squared_1={x**2 for x in [1,1,3]}
print(squared_1)#output:set([1,9])

#字符串推导式 
str_d="i for i in 'I Love you '"
print(str_d)#不可以，打印出来的是原版的字符串，没有做任何推导式的工作


#元祖推导式
e=(i for i in range(10))#元祖使用小括号括起来
print(e)#生成器的推导式<generator object <genexpr> at 0x00000000042ABDB0>

next(e)#生成器可以使用next()这个函数类查看
next(e)

for i in e:
    pass
    print(i)


#生成器推导式,作为一个函数的参数时,可以直接写推导式而不用带上自己的小括号
print(sum((i for i in range(10))))

print(sum(i for i in range(10)))

tuple_1=tuple(x for x in range(10))
print(tuple_1)
print(type(tuple_1))

result=[lambda x:x+i for i in range(10)]
print(result)
print(type(result))
print(result[0](10))
print(result[0](100))
i=0;
while i<10:
    #print(result[0](i))
    #print(result[i])
    i+=1;



print([i for i in range(10) if not(i%2)])
print([j for j in range(10) if (i%3)])


print(not (2%2))
print(not (3%2))