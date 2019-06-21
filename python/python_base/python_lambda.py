#匿名函数
import sys 
func=lambda x:x+1
print(func(1))

#以上lambda等同于一下函数
def fun(x):
    pass
    return (x+1)

func_1=lambda x,y:x+y
print(func_1(1,2))
#Lambda主要应用场合:
print(list(map(lambda x:x+1,[1,2,3])))#返回[2,3,4]

#但是,如果把上面map的例子，写成:print([x+1 for x in [1,2,3]])
#能达到同样的效果,python 的 for 语法非常强大，并且
#在易读上胜过了lambda,非常简洁，易懂
