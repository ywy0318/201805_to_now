i=0
result=0
while i<6:
    #print("hello world")
    #print("*"*i,end="#")
    print("*"*i)
    i+=1
    '''
    if i==3:
        #result+=i
        i+=1
        continue
    print(i)
    i+=1   
    '''
print("end---while")
#print("i=%d"% i )
print("********")
print("*",end="---")
print("*",end="SSS")
print("*****")


row=1
col=1
#col每次外循环外面都要清一次零
while row<10:
    col=1
    while col<=row:
        #print("*",end="")
        print("%d*%d=%d"%(row,col,row*col),end="\t")
        col+=1
        #print("cl=%d"%col)   
    print("")

    row+=1
    #print("row=%d"%row)
print("end---while---while")
#\t在控制台输出一个制表符，协助在输出文本时，垂直方向保持对齐
print("1\t2\t3\t")
print("10\t20\t30\t")
#\n在控制台输出一个换行符
print("hello\npython")
#\可以在控制台输出?????
print("hello \ hello")

