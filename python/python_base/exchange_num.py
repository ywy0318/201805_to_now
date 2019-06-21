a=6
b=100
"""
解法1:使用其他变量
c=a
a=b
b=c
解决2:不使用其他变量
a=a+b
b=a-b
a=a-b
解法3:python专有
a,b=(b,a)
提示:等号右边是一个元祖,只是把括号省略了

"""
a=a+b
b=a-b
a=a-b

#a,b=(b,a)
print(a)
print(b)