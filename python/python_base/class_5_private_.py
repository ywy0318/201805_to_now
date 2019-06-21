"""
类的私有变量和私有方法
1>> 在python中可以通过在属性变量名前面，加上双下划线定义属性为私有属性
2>> 特殊变量命名
a._xx  单下划线开头的表示protected(受保护的)类型的变量，即保护类型只能靠允许其本身
和子类进行访问;若内部变量表示,如当使用"from M import"时，不会将一个下划线开头的对象引入;
b.__xx 双下划线的表示的是私有类型的变量;只能允许这个类本身进行访问了，连子类也不可以；
用于命名一个类属性(类变量),调用时名字被改变
(在FooBar内部,__boo变成__FooBar_boo,如self.__FooBar_boo)

"""

class Woman():
    def __init__(self,name_1):
        self.name=name_1
        self.__age=18
    def __secret(self):
        #在对象的方法内部，是可以访问对象的私有属性的
        print("%s的年龄是%d"%(self.name,self.__age))

xiaofang=Woman("小芳")

#私有属性,在外接不能够被直接访问
#print(xiaofang.__age)

#伪私有属性,在外界不能够被直接访问
print(xiaofang._Woman__age)


#私有方法,同样不允许在外界直接访问
#xiaofang.__secret()

#伪私有方法，同样不允许在外界直接访问
xiaofang._Woman__secret()
