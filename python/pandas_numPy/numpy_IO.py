'''
Numpt IO
numpy 可以读写磁盘上的文本数据或二进制数据
numpy 为ndarray对象引入了一个简单的文件格式:npy
npy文件用于存储重建ndarray所需的数据,图像,dtype和其他信息
常用的IO函数有:
load()和save()函数是读写文件数组数据的两个主要函数,默认情况下,数组是以
未压缩的原始二进制格式保存在扩展名为npz的文件中
loadtxt()和savetxt()函数处理正常的文件(txt等)

numpy.save()函数将数组保存在以.npy为扩展名的文件中
numpy.save(file,arr,allow_pickle=True,fix_imports=True)
file:要保存的文件,扩展名为.npy,如果文件路径末尾没有扩展名.npy,该扩展名会被自动加上
arr:要保存的数组 
allow_pickle:可选,布尔值,允许使用python pickles保存对象数组,python中的pickle用于在保存
到磁盘文件或从磁盘文件读取之前,对对象进行序列化和反序列化
fix_imports :可选,
'''

import numpy as np 
a=np.array([1,2,3,4,5])
#np.save('outfile.npy',a)#E:\Visual Studio 2010\python_for_vscode保存以后的文件路径
#np.save('outfile2',a)

b=np.load('outfile.npy')
print(b)
'''
np.savez()函数将多个数组保存到以npz为扩展名的文件中
numpy.savez(*file ，*args,**kwds)
file:要保存的的文件,扩展名为.npz,如果文件路径末尾没有扩展名,会自动加上
args:要保存的数组,可以使用关键字参数为数组起一个名字,非关键字参数传递的数组会自动起名为arr_0,arr_1...
kwds:要保存的数组使用关键字名称;


savetxt()函数是以简单的文本本间格式存储数据,对应的使用loadtxt()函数来获取数据
np.loadtxt(FILENAME,dtype=int,delimiter='')
np.savetxt(FILENAME，a,fmt="%d",delimiter=',')
参数delimiter可以指定各种分隔符,针对特定列的转换器函数,需要跳过的行数等

'''

c=np.array([[1,2,3],[4,5,6]])
d=np.arange(0,1.0,0.1)
cc=np.sin(d)
np.savez('runoob.npz',c,d,sin_array=cc)
e=np.load('runoob.npz')
#查看各个数组名称
print(c)
print(e.files)
print(e['arr_0'])
print(e['arr_1'])
print(e['sin_array'])
f=np.array([11,12,13,14,15])
np.savetxt('out.txt',f)
g=np.loadtxt('out.txt')
print(g)