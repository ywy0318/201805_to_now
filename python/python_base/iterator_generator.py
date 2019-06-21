#迭代器和生成器
#1.>迭代器
import sys 

#创建一个迭代器
'''
把一个类作为一个迭代器使用需要在类中实现两个方法__iter__()与__next__()
__iter__()方法返回一个特殊的迭代器对象,这个迭代器对象实现了__next__()
方法并通过StopItration异常标识迭代的完成
创建一个返回数字的迭代器,初始值1，逐步递增1:

StopIteration
StopIteration异常用于标识迭代的完成,防止出现无限循环的情况,
在__next__()方法中,我们可以设置在完成指定循环次数触发StopIteration
异常来结束迭代
'''

'''
迭代器是一个可以记住遍历的位置的对象
迭代器对象从集合的第一个元素开始访问，
直到所有元素被访问完结束，迭代器只能往前不能后退
迭代器有两个基本的方法:iter()和next()
字符串，列表,和元素对象都可以用于创建迭代器
'''

class mynumbers():
    pass
    def __iter__(self):
        pass
        self.a=1
        return self
    def __next__(self):
        pass
        if self.a<=20:
            pass
            x=self.a
            self.a+=1
            return x
        else:
            pass
            raise StopIteration
        

def fibonacci(n):#生成器函数-斐波那契
    pass
    a,b,counter=0,1,0
    while True:
        pass
        if (counter>n):
            pass
            return
        yield a 
        a, b=b,a+b
        counter+=1
f=fibonacci(10)#f是一个迭代器,由生成器返回生成

for i in f:
    print(i)

print("\n")
list_1=[1,2,3,4]
it=iter(list_1)#创建迭代器对象
print(next(it))
print(next(it))


print("myclass")
myclass=mynumbers()
myiter=iter(myclass)
for x in myiter:
    pass
    print(x)
'''
for x in it:
    print(x,end=',')
'''
while True:
    pass
    try:
        print(next(it))
    except StopIteration:
        pass
        #sys.exit()
        exit()

'''
生成器
在python中,使用了yield的函数被称为生成器(generator)
跟普通函数不同的是,生成器是一个返回迭代器的函数,只能用于迭代操作,
更简单点解释生成器是一个迭代器
在调用生成器运行的过程中,每次遇到yield时候数会暂停并保存当前所有运行的信息,
返回yield的值,并在下一次执行next()方法时，从当前位置继续运行
调用一个生成器函数,返回的是一个迭代器对象


生成器也是一种迭代器,简单的讲，yield的作用就是把一个函数变成一个generator,
带有yield的函数不再是一个普通函数,python解释器会将其视为一个generator,
在for循环执行时，每次循环都执行函数内部的代码,直行到yield的时候，
函数就会返回一个迭代值，下一次迭代时，代码从yield b 的下一句继续执行,
而函数的本地变量看起来哈儿上次中断执行前是完全一样的，于是函数继续执行，
知道再次遇到yield,看起来就好像一个函数正常执行的过程中,被yield中断了数次，
每次中断都会通过yield返回当前的迭代值

'''