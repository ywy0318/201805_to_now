class A():
    def __init__(self):
        self.num_1=100
        self.__num_2=200
    def __test(self):
        print("私有方法%d %d"%(self.num_1,self.__num_2))
    def test(self):
        #print("父类的公有方法%d"self.__num_2)
        #self.__test()
        print("A的test方法")
    def demo(self):
        print("A的demo方法")
    

class B():
    def demo(self):
        #1.在子类的对象方法中,不能访问父类的私有属性
        #print("访问父类的私有属性%d"%(self.__num_2))
        #print("子类的方法%d"%self.num_1)
        #4,调用父类的公有方法
        #self.test()
        #print()
        print("B的demo方法")
    def test(self):
        print("B的test方法")
class C(B,A):
    #多继承可以让子类对象,同时具有多个父类的属性和方法
    pass

#创建子类对象
c=C()
c.test()#C先继承哪个就先打印哪个
c.demo()


#确定C对象调用方法的顺序
print(C.__mro__)
#(<class '__main__.C'>, <class '__main__.B'>, <class '__main__.A'>, <class 'object'>)

#创建一个子类对象
#b=B()
#print(b)
#b.demo()
#在外界不能直接访问对象的私有属性/调用私有方法
#print(b.__num_2)
#b.__test()