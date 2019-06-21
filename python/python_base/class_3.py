class  HouseItem:
    def __init__(self,name_1,area_1):
        self.name=name_1
        self.area=area_1
    def __str__(self):
        return  "[%s]占地%.2f"%(self.name,self.area)
class house(object):
    def __init__(self,house_type_2,area_2):
        self.house_type=house_type_2
        self.area=area_2
        #剩余面积
        self.free_area=area_2
        #家具名称列表
        self.item_list=[]
    def __str__(self):
        #python能够自动的将一对括号内的代码链接在一起
        return  ("户型:%s\n总面积:%.2f[剩余:%.2f]\n家具:%s"
            %(self.house_type,self.area,self.free_area,self.item_list))
    #添加家具函数没有具体的实现什么操作
    def add_item(self,item_1):
        print("要添加%s"%item_1)
        #1.判断家具的面积
        if item_1.area>self.free_area:
            print("%s的面积太大了,无法添加"%item_1)
            return
        #2.将家具的名称添加到列表中
        self.item_list.append(item_1.name)
        #3.计算剩余面积
        self.free_area-=item_1.area

#1.创建家具
bed=HouseItem("席梦思",4)
chest=HouseItem("衣柜",2)
table=HouseItem("餐桌",1.5)
print(bed)
print(chest)
print(table)

#2.创建房子对象
my_home=house("两室一厅",60)
my_home.add_item(bed)
my_home.add_item(chest)
my_home.add_item(table)
print(my_home)
