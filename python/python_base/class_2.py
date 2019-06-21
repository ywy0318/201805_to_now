class person():
    def __init__(self,name_1,weight_1):
        #self.属性=形参
        self.name=name_1
        self.weight=weight_1
    def __str__(self):
        return  "我的名字叫%s体重是%.2f公斤"%(self.name,self.weight)
    def run(self):
        print("%s爱跑步,跑步锻炼身体"%self.name)
        self.weight-=0.5
    def eat(self):
        print("%s是吃货,吃完这顿在减肥"%self.name)
        self.weight+=1
xiaoming=person("小明",75.0)
xiaoming.run()
xiaoming.eat()
print(xiaoming)

#小美爱跑步
xiaomei=person("小美",45)
xiaomei.run()
xiaomei.eat()
print(xiaomei)