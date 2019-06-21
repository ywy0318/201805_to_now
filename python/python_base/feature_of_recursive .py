#顶一个一个函数,能够接受一个num的参数,计算1+2+...+num的和
def sum_num(num):
    #temp=0
    #print(num)
    #递归的出口,当参数满足某个条件时,不再执行函数
    if num==1:
        return 1#当对递归的出口执行操作的时候需要注意出口的返回值
    #自己调用自己
    temp=sum_num(num-1)
    return temp+num
print(sum_num(100))