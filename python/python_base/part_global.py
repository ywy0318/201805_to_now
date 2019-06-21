"""
#在python中,不允许直接修改全局变量的值
#如果使用赋值语句,会在函数内部，定义一个局部变量

#在开发时,应该把模块中所有的全局变量
#都定义在所有函数的上方，就可以保证所有的函数
#都能正常的访问到每一个全局变量


"""
gl_num=18
gl_title="黑马程序员"
gl_name="小明"
def demol_1():
    #定义一个局部变量
    #1>出生:执行了下方的代码之后，才会被创建
    #2>死亡:函数执行完成之后
    #num=10
    print("demol_1函数内部的变量是%d--%d"%(gl_num,id(gl_num)))
def demol_2():
    global gl_num 

    gl_num=99
    print("demol_2函数内部的变量是%d--%d"%(gl_num,id(gl_num)))
    pass
#在函数内部定义的变量,不能在其他位置使用
#print("%d"%num)

print("demol_0函数内部的变量是%d--%d"%(gl_num,id(gl_num)))

demol_2()
demol_1()
