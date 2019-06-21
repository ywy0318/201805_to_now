def demo(*arg,**kwargs):
    print(arg)
    print(kwargs)
#元祖变量/字典变量
tuple_1=(1,2,3)
dict_1={"name":"sss","age":18}


def unpack(a,b,c,*args,**kargs):
    pass
    print(a)
    print(b)
    print(c)
    print(args)
    print(kargs)
#demo(gl_tuple_num,gl_dict_1)

#拆包语法，简化元祖变量/字典变量的传递
#demo(*gl_tuple_num,**gl_dict_1)
#print("122")
#print(gl_dict_1)
#demo(1,2,3,name="小明",age=18)

#unpack(11,22,33,tuple_1,dict_1)
print("---")
#unpack(11,22,33,*tuple_1,**dict_1)
print(type(dict_1["name"]))