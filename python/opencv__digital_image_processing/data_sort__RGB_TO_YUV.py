#图像的数据类型及颜色空间转换
'''
在skimage中,一张图片就是一个单间的numpy数组
图像数据类型及转换
Data type  range
uint8      0-255
uint16     0-65535
uint32     0-232
float      -1 to 1 or 0 to 1
int8       -128 to 127
int16      -32768 to 32767
int32       -231 to 231-1
...

一张图片的像素值取值范围为[0,255],
float类型,它的范围是[-1,1] or [0,1]之间,一张彩色图片转换为灰度图后
它的类型就由uint8变成了float

function name Description
img_as_float Convert to 64-bit floating point
img_as_ubyte Convert to 8-bit uint
img_as_uint  Convert to 16-bit uint
img_as_int   Convert to 16-int


'''
from skimage import data,img_as_float
from skimage import io,data  
from skimage import img_as_ubyte
import numpy as np 
from skimage import color
import matplotlib.pyplot as plt
img=data.chelsea()
print(img.dtype.name)

#uint8转换为float
dst=img_as_float(img)
print(dst.dtype.name)

#float转换为uin8可能会造成数据损失
img_1=np.array([0,0.5,1],dtype=float)
print(img_1)
print(img_1.dtype.name)
dst_1=img_as_ubyte(img_1)
print(dst_1)
print(dst_1.dtype.name)
print('*'*5)
'''
二.颜色空间及其转换
除了直接转换可以改变数据类型外,还可以通过图像的颜色空间转换来改变数据类型
常见的颜色空间有灰度空间,rgb空间,hsv空间,cmy空间,颜色空间转换以后,
图片类型都变成了float
所有的颜色空间转换的函数,都放在skimage的color模块内

sklearn.color.rgb2grey(rgb)
sklearn.color.rgb2hsv(rgb)
sklearn.color.rgb2lab(rgb)
sklearn.color.gray2rgb(image)
sklearn.color.hsv2rgb(hsv)
sklearn.color.lab2rgb(lab)
上面的函数可以用一个函数来代替
skimage.color.convert_colorspace(arr,fromspace,tospace)
表示将arr从fromspace颜色空间转换到tospace颜色空间

skimage.color.label2rgb(arr),可以根据标签值,对图片进行着色,
以后的图片分类后着色就可以使用这个函数

'''
#rgb转灰度图

img_2=data.chelsea()
gray_2=color.rgb2gray(img_2)
io.imshow(gray_2)

#rgb转换为hsv
hsv_2=color.convert_colorspace(img_2,'RGB','HSV')
io.imshow(hsv_2)

#将图片分成三类,然后用默认颜色对三类进行着色
rows,cols=gray_2.shape
print(rows,cols)
labels=np.zeros([rows,cols])
for i in range(rows):
    pass
    for j in range(cols):
        pass
        if(gray_2[i,j]<0.4):
            labels[i,j]=0
        elif(gray_2[i,j]<0.75):
            labels[i,j]=1
        else:
            labels[i,j]=2

dst_2=color.label2rgb(labels)
io.imshow(dst_2)

io.show()