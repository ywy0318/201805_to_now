
import math 
import sys 
def soft_max(list_1=[]):
    pass
    list_2=[]
    sum=0
    for x in list_1:
        pass
        sum+=math.exp(x)
    for x_1 in list_1:
        pass
        list_2.append((math.exp(x_1))/sum)    
    return list_2
    
a=[3,1,-3]
b=soft_max(a)
print(b)
