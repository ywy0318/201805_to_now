"""
当我们删除的是类的属性(del xx.属性名)的时候并不会去调用__del__方法,
所以会先执行后续的语句，然后等到程序结束的才执行__del__方法,

如果当我们删除的是类的时候,这个类的实例就会立即释放内存,__del__就会先于后续语句被调用
如果不删除类的时候，就等到程序执行完毕，以后调用__del__方法
"""

class Cat:
    def __init__(self,new_name):
        print("这是一个初始化的方法")
        #self.属性名=属性的初始值
        #self.name="Tommmm"
        self.name=new_name
    def eat(self):
        #哪一个对象调用的方法,self就是哪一个对象的引用
        print("%s小猫爱吃鱼"%self.name)
    def drink(self):
        print("%s小猫要喝水"%self.name)
    #程序结束以后__del__会执行，析构方法
    def __del__(self):
        print("%s我去了"%self.name)
    def __str__(self):
        #必须返回一个字符串
        return"我是小猫[%s]"%self.name
#创建猫对象
#使用类名()创建对象的时候,会自动调用初始化方法__init__
tom=Cat("DDD")
print(tom.name)
tom.eat()

#del关键字可以删除一个对象
#del tom

print(tom)

#使用.属性名.利用赋值语句就可以设置对象属性
#tom.name="TOM"
"""
lazy_cat_1=Cat()
lazy_cat_1.name="大懒猫"
lazy_cat_2=Cat()


tom.eat()
tom.drink()

lazy_cat_1.eat()
lazy_cat_1.drink()
"""
'''
lazy_cat_2.eat()
lazy_cat_2.drink()

'''

print("-"*10)

"""
print(tom)
print(lazy_cat_1)
#print(lazy_cat_2)
print("****")
print(id(tom))
print(id(lazy_cat_1))
#print(id(lazy_cat_2))

#addr=id(tom)
#print("%x"%addr)
"""