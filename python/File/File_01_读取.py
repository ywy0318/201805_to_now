#txt = open('E:\\python_project\\test\github\\filtered_words.txt','rb')
#txt = open('E:/python_project/test/github/filtered_words.txt','rb')
#txt = open('filtered_words.txt','r',encoding='UTF-8')
#1.打开文件
file_for_read=open('E:\\Visual Studio 2010\\python_for_vscode\\File\\README','r')
file_for_write=open('E:\\Visual Studio 2010\\python_for_vscode\\File\\README_for_write_2','w')
#a+文件内容会被清空
#file=open('E:/Visual Studio 2010/python_for_vscode/File/README','a+')
#w+如果该文件已存在则打开文件，并从开头开始编辑，即原有内容会被删除。
#file=open('E:/Visual Studio 2010/python_for_vscode/File/README','w+')

while True:
    pass
    text=file_for_read.readline()
    #如果没有读取到文件
    if not text:
        pass
        break
    file_for_write.write(text)
'''
#2.读取文件内容
text=file_for_read.read()#读取文件后文件指针会改变
#text=file.readlines()#在输出中显示成列表[b'hello 1\n', b'hello 2\n', b'hello 345']
#text=file_for_read.readline()#\n都会打印出来

#print(text)
#print(len(text))
#2.5>写文件
file_for_write.write(text)
print("-"*10)
#file.write("\n")
#file.write("hello world 333")
print("-"*10)
'''
#text=file.read()
#print(text)
#print(len(text))

#3.关闭文件
file_for_read.close()
file_for_write.close()