"""
多值参数
有些函数的参数前面是带*的，和**的，也有的没有任何*

"""
def demo(num,*nums,**person):
    print(num)
    print(nums)
    print(person)

def add_1(data):
    sum=0
    for i in data:
        sum=sum+i
    return sum

def add_2(*data):
    sum=0
    for i in data:
        sum=sum+i
    return sum
def add_3(**data):
    print(data)
"""
在add_1中,想要利用计算和,传参的正确方法是:add([23,24,25])
在add_2中,想要正确的传参是:add(2,3,4,5)也可以这样,add(2,3),
但是想要在add_2中把列表或者元祖传入,add_2([2,3,4,5])就会报错,
正确的写法可以写成add(*[3,4,5,6])

在list或者tuple传入的时候,前面加上*会自动将list或者tuple转化为可变参数传入

如果在一个参数前面有这样的符号,那么这就是关键字参数,主要作用，能够扩展函数的功能
**data是关键字参数,接收的是一个dict
"""
#demo(1,2,3,4,5,name="小明",age=18)
#add_3(data={"a":1,"b":2,"c":4})
#add_3(city="beijing",age="10")
#print(add_1([2,3,4]))
#print(add_1((2,3,4)))
#print(add_2(3,4,5,6))
#print(add_2(*[3,4,5,6]))
#print(add_2(*(3,4,5,6)))