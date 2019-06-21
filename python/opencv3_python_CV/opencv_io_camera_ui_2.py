
import numpy
import cv2
import os 

img=numpy.zeros((3,3),dtype=numpy.uint8)

print(img)
print(img.dtype)
print(cv2.cvtColor(img,cv2.COLOR_GRAY2BGR))

#image=cv2.imread('E:/Visual Studio 2010/python_for_vscode/opencv__digital_image_processing/lena.jpg')
#cv2.imwrite('E:/Visual Studio 2010/python_for_vscode/opencv3_python_CV/lena.png',image)
image=cv2.imread('E:/Visual Studio 2010//python_for_vscode/opencv3_python_CV/1.png')
'''
imread()函数的参数
IMREAD_ANYCOLOR=4
IMREAD_ANYDEPTH=2
IMREAD_COLOR=1
IMREAD_GRAYSCALE=0
IMREAD_LOAD_GDAL=8
IMREAD_UNCHANGED=-1
'''
cv2.imwrite('E:/Visual Studio 2010/python_for_vscode/opencv3_python_CV/1_1_1.jpg',image)
gray_image=cv2.imread('E:/Visual Studio 2010/python_for_vscode/opencv3_python_CV/1.png',cv2.IMREAD_GRAYSCALE)
cv2.imwrite('1_gray_image.png',gray_image)
print('*'*5)

randomByteArray=bytearray(os.urandom(120000))
flatNumpyArray=numpy.array(randomByteArray)

gray_image_2=flatNumpyArray.reshape(300,400)
cv2.imwrite('E:/Visual Studio 2010/python_for_vscode/opencv3_python_CV/RandomGray.png',gray_image_2)

bgr_image=flatNumpyArray.reshape(100,400,3)
cv2.imwrite('E:/Visual Studio 2010/python_for_vscode/opencv3_python_CV/RandomBGR.png',bgr_image)
#cv2.imwrite('RandomBGR.png',bgr_image,[int(cv2.CV_IMWRITE_PNG_COMPRESSION),3])
print('**'*5)

'''
1、使用opencv保存图像
cv2.imwrite(存储路径，图像变量[,存盘标识])
cv2.imwrite('test.jpg',img,[int(cv2.IMWRITE_JPEG_QUALITY),70])
存盘标识：

　cv2.CV_IMWRITE_JPEG_QUALITY  设置图片格式为.jpeg或者.jpg的图片质量，其值为0---100（数值越大质量越高），默认95
   cv2.CV_IMWRITE_WEBP_QUALITY  设置图片的格式为.webp格式的图片质量，值为0--100
  cv2.CV_IMWRITE_PNG_COMPRESSION  设置.png格式的压缩比，其值为0--9（数值越大，压缩比越大），默认为3
'''