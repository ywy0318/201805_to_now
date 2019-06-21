info_tuple=("zhangsan",18,1.75,"zhangsan")



#取值和索引
print(info_tuple[0])
#已知数据的内容,希望知道该数据在元素中的索引
print(info_tuple.index("zhangsan"))
print(info_tuple.count("zhangsan"))
print(len(info_tuple))
#遍历
#使用格式化字符串拼接，my_info这个变量不方便
#因为元祖中通常保存的数据类型是不同的
for my_info in info_tuple:
    print(my_info)

#格式化字符串后面的()本质上就是元祖
print("%s年龄是%d,身高是%.2f,--%s"%info_tuple)
info_str="%s年龄是%d,身高是%.2f,--%s"%info_tuple
print(info_str)


#字典是一个无序的数据集合，使用print函数输出字典时,
#通常输出的顺序和定义的顺序不一致的
xiaoming={"name":"xiaoming",
            "age":18,
            "gender":True,
            "height":1.75,
            "weight":75.0}

print("end--end")
print(xiaoming)

#取值
#取值的时候,如果指定的key不存在的话，程序就会报错
print(xiaoming['name'])

#增加/修改,如果不存在，就新增键值对
##########----字典访问没有"."---##########
xiaoming["id"]=233
#如果key存在，就会修改已经存在的键值对
xiaoming["name"]="大明"
#删除
xiaoming.pop("gender")
#在删除指定键值对的时候,如果指定的不存在就会报错
print(xiaoming)
#统计键值对数量
print(len(xiaoming))
temp_dict={"addr":"add",
            "QQ":8255}
xiaoming.update(temp_dict)
print(xiaoming)

#迭代遍历字典
#变量k是每一次循环中,获得的键值对的key
for k in xiaoming:
    print("%s--%s"%(k,xiaoming[k]))

#清空字典
#xiaoming.clear()
print("after clear")
#清空的话就会直接打印一个{}出来
print(xiaoming)

print("------")
#使用多个键值对,存储描述一个物体的相关信息---描述更复杂的数据信息
#将多个字典放在一个列表中，在进行遍历

card_list=[
        {
            "name":"张三",
            "qq":"12345",
            "tel":"110"
        },
        {
            "name":"李四",
            "qq":"54321",
            "tel":"10086"
        }
]

for cord_info in card_list:
    print(cord_info)