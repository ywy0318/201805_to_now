from PIL import Image 
import matplotlib.pyplot as plt 
img=Image.open('E:/Visual Studio 2010/python_for_vscode/opencv__digital_image_processing/lena.jpg')

print(img.size)
gray=img.convert('L')# 1 L P RGB RGBA CMYK(没有转化图像) YCbCr I F 
plt.figure('bearuty')
'''

plt.imshow(gray,cmap='gray')
plt.axis('off')
'''
r,g,b=img.split()#分离三通道
pic=Image.merge('RGB',(r,g,b))

plt.subplot(2,6,1), plt.title('origin')
plt.imshow(img),plt.axis('off')

plt.subplot(2,6,2),plt.title('gray')
plt.imshow(gray,cmap='gray'),plt.axis('off')

plt.subplot(2,6,3),plt.title('merge')
plt.imshow(pic),plt.axis('off')

plt.subplot(2,6,4),plt.title('r')
plt.imshow(r),plt.axis('off')

plt.subplot(2,6,5),plt.title('g')
plt.imshow(g),plt.axis('off')

plt.subplot(2,6,6),plt.title('b')
plt.imshow(b),plt.axis('off')

box=(80,100,260,300)

roi=img.crop(box)
plt.subplot(2,6,7),plt.title('img.crop()')
plt.imshow(roi),plt.axis('off')

dst=img.resize((128,128))
dst_1=img.rotate(45)#顺时针角度表示---img.transpose()和rotate()没有性能差别

plt.subplot(2,6,8),plt.title('dst')
plt.imshow(dst),plt.axis('off')

plt.subplot(2,6,9),plt.title('dst_1')
plt.imshow(dst_1),plt.axis('off')

plt.subplot(2,6,10),plt.title('img.crop()')
plt.imshow(img.transpose(Image.FLIP_LEFT_RIGHT)),plt.axis('off')#左右互换

plt.subplot(2,6,11),plt.title('img.crop()')
plt.imshow(img.transpose(Image.FLIP_TOP_BOTTOM)),plt.axis('off')#上下互换

plt.subplot(2,6,12),plt.title('img.crop()')
plt.imshow(img.transpose(Image.ROTATE_270)),plt.axis('off')#旋转90度
plt.show()
'''
Image类有resize(),retate()和transpose()方法进行几何变换
'''




'''
函数convert()来进行转换,它是图像实例的一个方法，接收一个mode参数,
mode的取值可以是如下几种:
1(1-bit pixels,black and while,stored with one pixel per byte)
L(8-bit piex,black and white)
P(8-bit piex mapped to any other mode using a color palette)
RGB(3x8-bit pixels ,true color )
RGBA(4x8-bit pixels ,true color with transparency mask)
CMYK(4x8-bit pixels ,color separation)
YCbCr(3x8-bit pixels ,color vedio format)
I(32-bit signed inter pixels)
F(32-bit float point pixels)
'''
