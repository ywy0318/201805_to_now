# -*- coding:utf-8 -*-
import random
age=33
isss = True
ticket =False
knife_length=120
if age>18 and age<60:
    print("成年人")
else:
    print("未成年")

if not isss or age<18:
    print("111")
else:
    print("222")
print("end")

if age==18:
    print(18)
elif age==19:
    print(19)
elif age==20:
    print(20)
else:
    print(21)

print("----")
if ticket:
    print("可以进站，开始安检")
    if knife_length>20:
        print("刀子太长")
    else:
        print("进站")
else:
    print("请先买票")
print("----")
print("%d"%random.randint(0,50))