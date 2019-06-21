from PIL import Image
import matplotlib.pyplot as plt
'''
python 进行数字图片处理,需要安装Pillow,PIL(python images library)停止更新

虽然使用的是Pillow，但它是由PIL fork而来，
因此还是要从PIL中进行import. 使用open()函数来打开图片，使用show()函数来显示图片。
这种图片显示方式是调用操作系统自带的图片浏览器来打开图片，
有些时候这种方式不太方便，因此我们也可以使用另上一种方式，让程序来绘制图片。
'''
img=Image.open('E:/Visual Studio 2010/python_for_vscode/opencv__digital_image_processing/lena.jpg')
#img.show()#调用系统的图片浏览器
plt.figure("lena")
plt.axis('off')#用于关闭axis
plt.imshow(img)

print(img.size)#图片的尺寸
print(img.mode)#图片的模式
print(img.format) #图片的格式
#img.save('E:/Visual Studio 2010/python_for_vscode/opencv__digital_image_processing/lena_1.png')
plt.show()