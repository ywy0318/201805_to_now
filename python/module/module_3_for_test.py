
#全局变量,函数,类,注意:直接执行的代码不是向外界提供的工具
#if __name__=="__main__":# 用来进行测试
#方法1
'''
创建一个文件夹
将需要做成模块的xx.py文件放到文件夹中 
新建一个setup.py文件
最简单setup.py
from distutils.core import setup
setup(
    name='helloworld',
    version='1.0.0.0',
    py_modules=['helloworld']#'文件名'
)

  setup(name='压缩包的名字'，version='1.0',author='作者'，pymodules=['my_package.module1'])
py_modules=["hm_message.send_message",
                  "hm_message.receive_message"])
注意：要是你写了多个.py文件的时候，按列表里的格式继续写在后面就行了。完了之后保存退出。


python setup.py build
在cmd中切换到文件夹中python setup.py sdist就会生成压缩包

4.helloWorld.pyc是『编译』版本的代码

解压压缩包，切换到目录中执行python setup.py install 


1、.PYD是一种PYTHON动态模块。

2、实质上还是dll文件，只是改了后缀为PYD

pyc文件就是 py程序编译后得到的字节码文件 (py->pyc)，
python为了提高运行效率也会进行编译，有时候编译出pyc文件后，删除py文件也不会出错
助于pyc文件的产生，给楼主举例
加入你有一个逻辑文件abcd.py，里面有很多函数A,B,C,D，这个时候，
如果你有一个test脚本去导入了abcd.py,只要你运行test脚本，
在adcd.py目录下就会生成一个abcd.pyc文件，而不管你是否需要调用A,B,C,D函数
'''


def say_hello():
    pass
    print("hello,this is model_3_for_test")
#如果直接执行模块,__main__
if __name__=="__main__":
    pass
    print(__name__)
    #文件被导入时,能够直接执行的代码不需要被执行
    print("import model")
    say_hello()