#假设以下内容是从网络上抓取的
#要求:顺序并且居中对齐输出一下内容
poem=["\t\n登鹳雀楼",
        "王之涣",
        "白日依山尽\t\n",
        "黄河入海流",
        "欲穷千里目",
        "更上一层楼"
    ]
for poem_str in poem:
    #先使用strip方法去除字符串中的空白字符
    #在使用 center方法居中显示文本
    print("|%s|"%poem_str.strip().center(10," "))
poem_str_2="登鹳雀楼\t 王之涣\t 白日依山尽\t \n黄河入海流\t\t欲穷千里目\t\t\n更上一层楼"
print(poem_str_2)

#1拆分字符串
poem_list=poem_str_2.split()
print(poem_list)

#2合并字符串
result=" ".join(poem_list)
print(result)
print("---")




for num in [1,2,3]:
    print(num)
    if num==2:
        break
    else:
        print("会执行吗")
print("循环结束")

print("----")

students=[
    {"name":"闰土"},
    {"name":"鲁迅"}
]
find_name="张三"
for stu_dict in students:
    print(stu_dict)
    if stu_dict["name"]==find_name:
        print("找到了%s"%find_name)
        break
    else:
        print("没有找到%s"%find_name)
print("循环结束")