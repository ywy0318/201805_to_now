class Tool():
    #使用赋值语句定义类属性,记录所有工具对象的数量
    count=0
    @classmethod
    def show_tool_count(cls):
        print("工具对象的数量%d"%cls.count)
    def __init__(self,name_1):
        self.name=name_1
        #让类的属性值+1
        Tool.count+=1

class A(object):
    def foo(self,x):
        print("executing foo(%s,%s)"%(self,x))
        print("self:",self)
    @classmethod
    def class_foo(cls,x):
        print("executing class_foo(%s,%s)"%(cls,x))
        print("cls:",cls)
    @staticmethod
    def static_foo(x):
        print("executing static_foo(%s)"%x)


class Game(object):
    #历史最高分
    top_score=0
    def __init__(self,name_1):
        self.name=name_1
    @staticmethod
    def show_help():
        print("帮助信息:让僵尸进入大门")
    @classmethod
    def show_top_score(cls):
        print("历史记录%d"%cls.top_score)
        pass
    def start_game(self):
        print("%s开始游戏了"%self.name)
        pass
    pass
#1.查看游戏的帮助信息
Game.show_help()
#2.查看历史最高分
Game.show_top_score()
#3.创建游戏对象
game=Game("小明")
game.start_game()


"""
1.>定义方式
普通的类方法foo()需要通过self参数隐式的传递当前类对象的实例
@classmethod修饰的方法class_foo()需要通过cls参数传递当前类对象
@staticmethod修饰的方法定义与普通函数是一样的
self和cls的区别不是强制的，
只是PEP8中的一种编码风格,
self通常用作实例方法的第一参数,cls通常用作类方法的第一参数,
即通常用self来传递当前类对象的实例，cls传递当前类对象


"""

'''
#创建工具对象
tool_1=Tool("斧头")
tool_2=Tool("榔头")

#调用类方法
Tool.show_tool_count()
'''
aa=A()
'''
foo方法绑定对象A的实例，class_foo方法绑定对象A,static_foo没有参数绑定
'''
#print(aa.foo)
#print(aa.class_foo)
#print(aa.static_foo)
"""
调用方式不同,
foo可通过实例a调用,类对象A直接调用会参数错误
但是foo如下方式可以使用正常，显示的传递实例参数a
A.foo(aa,1)
"""

"""
class_foo通过类对象或对象实例调用
A.class_foo(1)
a.class_foo(1)

static_foo通过类对象或对象实例调用
A.static_foo(1)

a.static_foo(1)

继承与覆盖普通类函数是一样的

"""
class B(A):
    pass
"""
@staticmethod修饰的方法函数与普通的类外函数,
@staticmethod是把函数嵌入到类中的一种方式，函数就属于类,同时表明函数不需要访问这个类
通过子类的继承覆盖，能更好的组织代码
"""
#b=B()
#b.foo(1)


