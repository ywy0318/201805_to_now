'''
函数内部通过方法修改可变参数
数值的加等于操作和list的加等于操作
'''

def demo(num,num_list):
    print("函数内部的代码")
    #在函数内部，针对参数使用赋值语句,不会修改到外部的实参变量
    #num=100
    #num_list=[1,2,3]    
    #num_list.append(9)

    #num=num+num
    num+=num
    #列表变量使用+不会做相加再赋值的操作
    #num_list=num_list+num_list
    #本质上是在调用列表的extend方法
    #num_list.extend(num_list)
    num_list+=num_list
    print(num)
    print(num_list)
    print("函数执行完成")

gl_num=10
gl_num_list=[7,3,2,1,4,5,6]

#默认按照升序排序--可能会多
#gl_num_list.sort()
#如果需要降序排序的话，需要执行reverse参数
gl_num_list.sort(reverse=True)
#demo(gl_num,gl_num_list)
#print(gl_num)
print(gl_num_list)