'''
eval函数就是实现list,dict,tuple,与str之间的字符串转换
str函数把list，dict,tuple转换为字符串

'''

#字符串转换成为列表
a="[[1,2],[3,4],[4,5],[5,6]]"
print(type(a))
b=eval(a)
print(type(b))
print(b)


#字符串转化为字典
#c="{1:'ccc',2:'sss'}"
c='{33:"ssss",44:"fff"}'
#c="{33:"ssss",44:"fff"}"#错的，字符串的引号要和字典value的值不一样
print(type(c))
d=eval(c)
print(type(d))
print(d)

#字符串转化成为元祖
e="([11,22],[33,44],[44,55],[55,66],[77,88])"
print(type(e))
f=eval(e)
print(type(f))
print(f)
'''集合不行
#字符串转化为set
g="{[11,22],[33,44],[44,55],[55,66],[77,88]}"
print(type(g))
h=eval(g)
print(type(h))
print(h)
''''