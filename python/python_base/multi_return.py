def measure():
    """ 测量温度和湿度"""
    print("测量开始...")
    temp=30
    wetness=50
    print("测量结束")
    #元祖--可以包含多个数据,因此可以使用元祖让函数一次返回多个值
    #如果函数返回的类型是元祖,小括号可以省略
    #return(temp,wetness)
    return temp,wetness

#元祖
result=measure()
print(result)
#需要单独的处理温度或者湿度--不方便
print(result[0])
print(result[1])
"""
如果函数返回的类型是元祖,同时希望单独的处理元祖中的元素,
可以使用多个变量,一次接受函数的返回结果
使用多个变量接受结果时,变量的个数应该和元素中元素的个数保持一致
"""
gl_temp,gl_wetness=measure()
print(gl_temp)
print(gl_wetness)