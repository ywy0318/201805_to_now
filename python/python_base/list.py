name_list = ["zhangssan","lisi","wanger"]
print(name_list)
#取值和取索引,----list index out of range----
# list assignment index out of range
print(name_list[2])
print(name_list.index("lisi"))
name_list[1]="李斯"
#append方法可以向列表的末尾追加数据
name_list.append("赵五")
#insert 方法可以在列表的指定索引位置插入数据
name_list.insert(1,"貂蝉")
temp_list=["孙悟空","猪八戒","沙师弟"]
#extend 方法可以把其他列表中的完整内容，追加到当前列表的末尾
name_list.extend(temp_list)
print(name_list)
#remove 方法可以从列表中删除指定的数据
name_list.remove("赵五")
print("name_list.pop()")
#pop方法默认可以把列表中最后一个元素删除
name_list.pop()
print(name_list)
name_list.pop(0)
print(name_list)
#name_list.clear()

#使用del删除列表元素
#在日常开发中,要从列表删除数据，建议使用列表提供的方法
#del 关键字的本质上是用来讲一个变量从内存中删除的
name ="小米"
del name_list[1]
del name
#注意:如果使用del关键字将变量从内存中删除
#后续的代码不能在使用这个变量了
#print(name)

print(name_list)
name_list.append("貂蝉")
print("列表中包含的元素个数:%d"%len(name_list))
print("貂蝉个数:%d"%(name_list.count("貂蝉")))
#从列表中删除第一次出现的数据，如果数据不存在,程序会报错
#name_list.remove("貂蝉")
name_list.pop()
print(name_list)
num_list=[3,2,4,1,11,33,22]
#升序
#升序结果:['貂蝉', 'wanger', '孙悟空', '猪八戒']
#name_list.sort()
#num_list.sort()

#降序
#降序结果:['貂蝉', '猪八戒', '孙悟空', 'wanger']
#name_list.sort(reverse=True)
#num_list.sort(reverse=True)

print("\n")

#逆序(反转)
name_list.reverse()
num_list.reverse()

print(name_list)
print(num_list)

for name_1 in name_list:
    print("name_list:%s"%name_1)

for num_1 in num_list:
    print("num_list:%d"%num_1)