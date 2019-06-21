def multiple_table():
    row=1
    while row<10:
        col=1
        while col<=row:
            print("%d*%d=%d"%(row,col,row*col),end="\t")
            col+=1
        print("")
        row+=1
    #print("end")
def say_hello():
    print("hello1")
    print("hello2")
    print("hello3")
def sum_2_num(num1,num2):
    result=num1+num2
    return result
    #print("%d+%d=%d"%(num1,num2,num1+num2))
#print(sum_2_num(10,20))
def test1():
    print("*"*5)
def test2():
    print("+"*5)
    test1()
    print("-"*5)
def print_line(char,times):
    print(char*times)

def print_multi_line(ch,Times):
    row=0
    while row<5:
        print_line(ch,Times)
        row+=1
#print_multi_line(">",3)
    #print_line("hi",5)
#test2()
#say_hello()
"""
定义好函数之后，表示这个函数封装了一段代码，
如果不主动调用这个函数，那么函数不会主动执行
"""
#multiple_table()