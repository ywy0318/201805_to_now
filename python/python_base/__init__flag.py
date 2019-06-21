class Musicplayer(object):
    #记录第一个被创建对象的引用
    instance=None
    #记录是否执行过初始化动作
    init_flag=False
    def __new__(cls,*arg,**kwargs):
        #判断类属性是否为空对象
        if cls.instance is None:
            #2,调用父类的方法，为第一个对象分配空间
            cls.instance=super().__new__(cls)
            pass
        return cls.instance
    def __init__(self):
        #1.判断是否执行过初始化动作
        if Musicplayer.init_flag:
            return
        #2.如果没有执行过,在执行初始化动作
        print("初始化播放器")
        pass
        #3.修改类属性的标记
        Musicplayer.init_flag=True

    
#创建多个对象
player_1= Musicplayer()
print(player_1)
player2= Musicplayer()
print(player2)