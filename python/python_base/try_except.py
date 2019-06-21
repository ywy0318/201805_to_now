try:
    #不能确定正确执行的代码
    pass
except ZeroDivisionError:
    #错误的处理代码
    pass
except ValueError:
    pass
except Exception as result:
    pass
else:
    pass
    print("尝试成功")
finally:
    print("无论是否出现错误都会执行的代码")
def demo_1():
    pass
    return int(100)
def demo_2():
    pass
    return demo_1()

def input_password():
    pass
    #1.提示用户输入密码
    pwd=input("请输入密码:")

    #2.判断密码长度>=8,返回用户输入的密码
    if len(pwd)>=8:
        pass
        return pwd
    #3.如果<8主动抛出异常
    print("主动抛出异常")
    #1>创建异常对象--可以使用错误信息字符串作为参数
    ex=Exception("密码长度不够")
    #2>主动抛出异常
    raise ex

#利用异常的传递性，在主程序捕获异常
try:
    print(demo_2())
except Exception as identifier:
    pass
    print("未知错误%s"%result)

#提示用户输入密码
try:
    pass
    print("请输入密码")
    print(input_password())
except Exception as result:
    pass
    print(result)