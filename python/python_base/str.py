str1="hello python"
str2="两只老虎两只老虎"
print(str2)
print(str1[6])
'''
for char1 in str2 :
    print(char1)
'''
print("---")
'''
for char in str1:
    print(char)
'''
print(len(str1))
print(len(str2))
#统计某一个(子)字符出现的次数
print(str1.count("l"))
print(str2.count("两"))
#某一个字符串出现的位置
print(str1.index("llo"))
#注意:如果使用index方法传递的子字符串不存在，程序报错

#判断空白字符
space_str="   \t\n\r"
#返回值是True
print(space_str.isspace())

#判断字符串中是否值包含数字
# 1>都不能判断小数
#num_Str=1.1
# 2> unicode 字符串
"""
isdecimal()方法检查字符串是否只包含十进制字符，
这种方法只存在于unicode对象
注意:定义一个十进制字符串，只需要在字符串前添加"u"前缀即可
字符串是否只包含十进制字符，返回True,否则返回False
"""
num_Str= u"0042"
# 3>中文数字
#print(num_Str)
print(num_Str.isdecimal())

"""
isnumeric()方法检测字符串是否只由数字组成
这种发放只是针对unicode对象
如果只包含数字字符，返回True,否则返回False
"""
num_Str1=u"00b2"#返回False
print(num_Str1.isnumeric())
"""
isdigit()方法检测字符串是否只由数字组成
"""
print(num_Str1.isdigit())
print("----")

hello_str="hello world"

#判断是否以指定字符串开始
print(hello_str.startswith("he"))
#判断是否以指定字符串结束
print(hello_str.endswith("ld"))

#查找指定字符串
#index同样可以查找指定的字符串在大字符串中的索引
#index如果指定的字符串不存在，会报错
#find如果指定的字符串不存在，会返回-1
print(hello_str.index("l"))
print(hello_str.find("l"))

#替换字符串
#replace方法执行完成以后，会返回一个新的字符串
#注意:不会修改原有字符串的内容

print(hello_str.replace("world","python"))
print(hello_str)


