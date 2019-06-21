# -*-coding:utf-8-*-

dict_1={'name':'zara','age':18,'class':'first'}
tuple_1=(1,2,3,4,5)
list_1=[11,22,33,44,55]

print("\n")
#1.dict
#字典转化为字符串
print(type(str(dict_1)))#<class 'str'>
print(str(dict_1))#{'class': 'first', 'name': 'zara', 'age': 18}
print(str(dict_1))
print(dict_1)
print("*"*8)
#字典转化为元祖
print(tuple(dict_1))#('class', 'name', 'age')
print(type(tuple(dict_1)))
print("*"*8)
#字典转化为列表
print(list(dict_1))#['name', 'class', 'age']
print(type(list(dict_1)))
print("*"*8)

#2.元祖
#元祖转化为字符串
print(type(str(tuple_1)))
print(str(tuple_1))#(1, 2, 3, 4, 5)
print("*"*8)
#__str__()不行
#print(type(tuple_1.__str__()))
#print(tuple_1.__str__()))
#元祖转化为列表
print(type(list(tuple_1)))
print(list(tuple_1))
print("*"*8)
#3.列表
#列表转化为字符串
print(str(list_1))
print("*"*8)
#列表转化为元祖
print("list->tuple")
print(tuple(list_1))
print("*"*8)
#4.字符串
#字符串转化为元祖
print(tuple(eval("[21,22,23]")))
print(tuple(eval("(1,2,3)")))
print(type(tuple(eval("(1,2,3)"))))
#字符串转化为列表
print(list(eval("(11,12,13)")))
print(type(list(eval("(11,12,13)"))))
#字符串转化字典
print(dict(eval("{'name':'aa','age':23}")))
print(type(dict(eval("{'name':'aa','age':23}"))))
