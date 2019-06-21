class Animal():
    def eat(self):
        print("吃---")
    def drink(self):
        print("喝---")
    def run(self):
        print("跑---")
    def sleep(self):
        print("睡---")
class dog(Animal):#继承把基类放在()中
    #子类拥有父类的所有的属性和方法
    '''
    def eat(self):
        print("吃")
    def drink(self):
        print("喝")
    def run(self):
        print("跑")
    def sleep(self):
        print("睡")
    '''
    def bark(self):
        print("汪汪叫")

class xiaotianquan(dog):
    def fly(self):
        print("︿(￣︶￣)︿飞--")
    def bark(self):
        print("叫的跟其他狗不一样")
        #2.使用super().调用原本在父类中封装的方法
        #super().bark()
        #父类名.方法(self)
        dog.bark(self)
        #注意：如果使用子类调用方法,会出现递归调用死循环
        #xiaotianquan.bark()
        #3.增加其他子类的代码
        print("^_^_^")
#如果在子类中，重写了父类的方法
#在使用子类对象调用方法,会调用子类中重写的方法
class Cat(Animal):
    def catch(self):
        print("抓老鼠")

#创建一个对象--狗对象
'''
wangcai=dog()
wangcai.eat()
wangcai.drink()
wangcai.run()
wangcai.sleep()
wangcai.bark()
'''
#创建一个哮天犬的对象


xtq=xiaotianquan()
#xtq.fly()
xtq.bark()
#xtq.eat()

#xtq.catch()


