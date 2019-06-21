"""
nupy数组操作
numpy中一些函数用于处理数组,大概分为一下几类
修改数组形状
翻转数组
修改数组维度
连接数组
分割数组
数组元素的增加与删除

修改数组形状
reshape 不改变数据的条件下修改形状
flat数组元素迭代器

flatten返回一份数组拷贝,对拷贝所做的修改不会影响原数组
ravel返回展开数组

"""

import sys 
import numpy as np 
'''
#--coding=utf8
sys.stdout.write(chr(1))
sys.stdout.write(chr(1))     #Q
print('')
for i in range(1,11):
    for j in range(1,i):
        sys.stdout.write(chr(219))
        sys.stdout.write(chr(219))   
    print('')
'''
"""
numpy.reshape函数可以在不改变数据的条件下修改形状
numpy.reshape(arr,newshape,order='c')
要修改形状的数组，整数或者整数数组，新的形状应当兼容原有形状
order :'c'--按行，‘F’--按列,'A'--原顺序，‘k’--元素在内存中出现顺序
"""

a=np.arange(8)
print(a)
print('\n')
b=a.reshape(4,2)
print(b)
print('\n')
#np.ndarray.flat是一个数组元素迭代器.
print('row')
for row in b:
    print(row)
#对数组中每个元素都进行处理，可以使用flat属性该属性是一个数组元素迭代器
print('\n')
for element in b.flat:
    pass
    print(element)
#numpy.ndarray.flattn返回一份数组拷贝，对拷贝所做的修改不会影响原始数据
print('\n')
print(b.flatten())
print('\n')
print(b.flatten(order='F'))
#numpy.ravel()展开的数组元素,顺序通常是'C风格',返回的事数组视图
#(view,有点类似C/C++引用reference的意味)修改会影响原始数组
print('b.ravel()\n')
print(b.ravel())
print("b.ravel()-oreder=F")
print(b.ravel(order='F'))
"""
翻转数组
transpose 对换数组的维度
ndarray.T 和self.transpose()相同
rollaxis--向后滚动指定的轴
swapaxes兑换数组的两个轴

numpy.transpose函数用于对换数组的维度
numpy.transpose(arr,axes)
axes:整数列表，对应维度，通常所有维度都会兑换

"""
print('--')
print(b)
print('--np.transpose(b)-')
print(np.transpose(b))
print('--b.T-')
print(b.T)
"""
numpy.rollaxis函数向后滚动特定的轴到一个特定位置
numpy.rollaxis(arr,axis,start)
axis:要向后滚动的轴，其他的轴相对位置不会改变
start:默认为0,表示完整的滚动，会滚动到特定的位置

//待续!!!!!!!!!!!!!!!!!!!!!!!
"""
c=np.arange(8).reshape(2,2,2)
print('--c--\n')
print(c)
print('-np.rollaxis(c,0,2)-\n')
print(np.rollaxis(c,2))
print("-np.rollaxis(c,2,1)-\n")
print(np.rollaxis(c,2,1))

"""
c=np.arange(27).reshape(3,3,3)
print('--c--\n')
print(c)
print('-np.rollaxis(c,0,2)-\n')
print(np.rollaxis(c,0,2))
print("-np.rollaxis(c,2,1)-\n")
print(np.rollaxis(c,2,1))
"""


'''
numpy.swapaxes
用于交换数组的两个轴
numpy.swapaxes(arr,axis1,axis2)
axis1--->第一个数轴
axis2--->第二个数轴
!!!!!!!!!!没看懂
'''
aaa=np.arange(8).reshape(2,2,2)
print("aaa")
print(aaa)

#现在交换轴0(深度方向)到轴2(宽度方向)
print("np.swapaxes(aaa,2,0)")
print(np.swapaxes(aaa,2,0))

"""
修改数组维度
broadcast---产生模仿广播的对象
broadcast_to---将数组广播到新形状
expand_dims---扩展数组的形状
squeeze---从数组的形状中删除一维条目

"""

x=np.array([[1],[2],[3]])
y=np.array([4,5,6])
#对y广播x
#它拥有iterator属性,基于自身组件的迭代器元祖
xy=np.broadcast(x,y)
print("--")
print(x)
print(y)
r,c=xy.iters
print(next(r),next(c))
print("\n")
print(xy.shape)
xy_c=np.empty(xy.shape)
print(xy_c)
print(xy_c.shape)
#print(xy)

'''
如果是：2.000000e+10，那么就是：2.000000x10^10，
即e后面的数字是10的多少次方，这就是科学计数法。
'''

xy_c.flat=[u + v for(u,v) in xy]
print(xy_c)
print(x)
print(y)

print(x+y)

"""
numpy.broadcast_to函数将数组广播到新形状;
它在原始数组上返回只读视图,它通常不连续,
如果新形状不符合numpy的广播规则，则该函数抛出valueError
numpy.broadcast_to(array,shape,subok)


"""
print("--")
abc=np.arange(4).reshape(1,4)
print(abc)
print("--")
print(np.broadcast_to(abc,(4,4)))

"""
numpy.expand_dims
numpy.expand_dims函数通过在指定位置插入新的轴来扩展数组形状
numpy.expand_dims(arr,axis)
axis---新轴的位置
"""
print("-"*5)
print("abcd")
abcd=np.array(([1,2],[3,4]))
print(abcd)
print("-"*5)
abcy=np.expand_dims(abcd,axis=0)
print(abcy)
print("-"*5)
print(abcd.shape,abcy.shape)
print(abcd.ndim,abcy.ndim)
abcy=np.expand_dims(abcd,axis=1)
print(abcy)
print("-"*5)
print(abcy.shape)
print(abcd.ndim,abcy.ndim)

#-----#
#numpy.sequeeze函数从给定的数组形状中删除一维的条目
#numpy.squeeze(arr,axis) arr:输入数组,axis:整数或整数元祖,用于选择形状中一维条目的子集
print('\nnp.squeeze')
x_se=np.arange(9).reshape(1,3,3)
print(x_se)
print('\n')
y_se=np.squeeze(x_se)
print(y_se)
print(x_se.shape)
print(y_se.shape)
'''
#连接数组
concatenate---连接沿现有轴的数组序列
stack----沿着新的轴加入一系列数组
hstack----水平堆叠序列中的数组(列方向)
vstack----竖直堆叠序列中的数组(行方向)
numpy.concatenate
用于沿着指定轴连接相同形状的两个或多个数组,格式如下
numpy.concatenate((a1,a2...),axis)
'''
print('concatenate')

a_concatenate=np.array([[1,2],[3,4]])
b_concatenate=np.array([[5,6],[7,8]])

print(a_concatenate)
print('\n')
print(b_concatenate)
print('\n')
print(np.concatenate((a_concatenate,b_concatenate)))
print('\n')
print(np.concatenate((a_concatenate,b_concatenate),axis=1))

print('\nnumpy.stack')
#numpy.stack
#用于沿着新轴连接数组序列
print(np.stack((a_concatenate,b_concatenate),0))
print('np.stack((a_concatenate,b_concatenate),1)')
print(np.stack((a_concatenate,b_concatenate),1))

print('\nnumpu.hstack--numpy.vstack')
#numpy.hstack是numpy.stack函数的变体,通过水平堆叠来生成数组
print(np.hstack((a_concatenate,b_concatenate)))
#numpy.vstack是numpy.stack函数的变体,通过垂直堆叠来生成数组
print(np.vstack((a_concatenate,b_concatenate)))

'''
分割数组
split---将一个数组分割成多个子数组
hsplit---将一个数组水平分割成多个子数组(按行)
vsplit---将一个数组垂直分割成多个子数组(按列)

numpy.split函数沿特定的轴将数组分割为子数组
numpy.split(arr,indices_sections,axis)
indices_sections:如果是一个整数,就用该整数平均切分,如果是一个数组，为沿轴切分的位置
axis:沿着哪个维度进行切向,默认为0,横向切分,为1时,纵向切分
'''
a_split=np.arange(9)
print(a_split)
b_split=np.split(a_split,3)
print(b_split)
c_split=np.split(a,[4,7])
print(c_split)

print("a_hsplit")
#print(help(np.floor))
print('\n')
a_hsplit=np.floor(10*np.random.random((3,6)))
print(a_hsplit)
print(np.hsplit(a_hsplit,3))
print(np.vsplit(a_hsplit,3))
print('\n')
#print(np.random.random((2,6)))


'''
数组元素的添加与删除
resize---返回指定形状的新数组
append---将数值添加到数组末尾
insert---沿指定轴将值插入到指定下标之前
delete---删掉某个轴的子数组,并返回删除后的新数组
unique---查找树组内的唯一元素
'''
#numpy.resize函数返回指定大小的新数组
#如果新数组大小大于原始数组，则包含原始数组中的元素的副本
a_resize=np.array([[1,2,3],[4,5,6]])
print(a_resize)
print(a_resize.shape)
print(np.resize(a_resize,(3,2)))
print(np.resize(a_resize,(3,3)))
#numpy.append函数在数组的末尾添加值,追加操作会分配整个数组，并把原来的数组复制到新数组中
#此外,数组的维度必须匹配否侧出现valueError
#numpy.append(arr,values,axis=None)

a_append=np.array([[1,2,3],[4,5,6]])

print(a_append)
print(np.append(a_append,[7,8,9]))
print(np.append(a_append,[[7,8,9]],axis=0))
print(np.append(a_append,[[5,5,5,],[7,8,9]],axis=1))

#numpy.insert
#numpy.insert函数在给定的索引之前，沿给定的轴在输入数组中插入值
#如果值的类型转换为要插入,则它与插入数组不同,插入没有原地的,函数会返回一个新数组
#如果没有提供轴,输入数组会被展开
#numpy.insert(arr,obj,values,axis)
#
a_insert=np.array([[1,2],[3,4],[5,6]])

print(a_insert)
print(np.insert(a_insert,3,[11,12]))
print(np.insert(a_insert,1,[11],axis=0))
print(np.insert(a_insert,1,11,axis=1))

#numpy.delete函数返回从输入数组中删除指定子数组的新数组,
#与insert()函数的情况一样,如果没有提供轴参数,则数组数组将展开
#numpy.delete(arr,obj,axis)

a_delete=np.arange(12).reshape(3,4)
print(a_delete)
print(np.delete(a_delete,5))
print(np.delete(a_delete,1,axis=1))


'''
numpy.unique函数用于去除数组中的重复元素
numpy.unique(arr,return_index,return_inverse,return_counts)
arr:输入数组，如果不是一维数组则会展开
return_index:如果为true,返回新列表元素在旧列表元素中的位置(下标),并以列表形式存储
retrun_inverse:如果为true,返回旧列表元素在新列表元素中的位置(下标),并以列表形式存储
return_counts:如果为True,返回去除数组中的元素在原数组中出现的次数
!!!!!!!!!!!!!!
'''
a_unique=np.array([5,2,6,2,7,5,6,8,2,9])
print(a_unique)

print("return_index=True")
u,indices=np.unique(a_unique,return_index=True)
print(u)
print(indices)
print("return_inverse=True")
u_1,indices_1=np.unique(a_unique,return_inverse=True)
print(u_1)
print(indices_1)
print("return_counts=True")
u_2,indices_2=np.unique(a_unique,return_counts=True)
print(u_2)
print(indices_2)