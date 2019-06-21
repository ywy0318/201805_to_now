
#-*- coding:utf-8 -*-
#coding=utf-8

from 模块_2 import *
from 模块_1 import *

import random#模块的搜索顺序
"""
import 模块_1  as model_1
import 模块_2  as model_2
"""
'''
from 模块_1 import Dog
from 模块_2 import say_hello as model_2_say_hello
from 模块_1 import say_hello
'''
'''
模块_1.say_hello()
模块_2.say_hello()
dog=模块_1.Dog()
cat=模块_2.CAT()
print(dog)
print(cat)
'''
'''
model_1.say_hello()
model_2.say_hello()
dog=model_1.Dog()
cat=model_2.CAT()
print(dog)
print(cat)
'''
"""
say_hello()
dog=Dog()
print(dog)
"""
'''
say_hello()
model_2_say_hello()
'''
"""
print(title)
say_hello()
dog=Dog()
print(dog)  
"""
print(random.__file__)
rand=random.randint(0,10)
print(rand)