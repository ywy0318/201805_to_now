class dog():

    #使用赋值语句定义类属性，记录所有工具对象的数量
    count=0
    def __init__(self,name_1):
        self.name=name_1
        #让类属性的值+1
        dog.count+=1
    def game(self):
        print("%s蹦蹦跳跳的玩耍..."%self.name)

class xiaotianquan(dog):
    def game(self):
        print("%s飞到天上玩耍"%self.name)

class person(object):
    def __init__(self,name_2):
        self.name=name_2
    def game_with_Dog(self,dog):
        print("%s和%s快了的玩耍..."%(self.name,dog.name))
        dog.game()


#1,创建工具对象
d_1=dog("博美")
print(dog.count)
d_2=dog("萨摩耶")
print(dog.count)
d_3=dog("二哈")
print("---")
#输出工具对象的总数
print(d_1.count)
print(d_2.count)
print(d_3.count)
print(dog.count)
d_3.count=99
print("----")
print(d_1.count)
print(d_2.count)
print(d_3.count)
print(dog.count)
print("-----")
print(id(d_1.count))
print(id(d_2.count))
print(id(d_3.count))
print(id(dog.count))

#创建一个对象
#wangcai=dog("wangcai")
#wangcai=xiaotianquan("飞天旺财")

#创建一个小明对象
#xiaoming=person("小明")

#小明调用和狗玩的方法
#xiaoming.game_with_Dog(wangcai)