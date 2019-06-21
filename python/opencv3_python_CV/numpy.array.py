#使用numpy.array访问图像数据
import cv2 
import numpy as np 
img=cv2.imread('E:/Visual Studio 2010/python_for_vscode/opencv3_python_CV/lena.png')
img[10,10]=[255,255,255]
cv2.imshow('image',img)
#打印出当前B通道的值
print(img.item(150,120,0))
img.itemset((150,120,0),255)

print(img.item(150,120,0 ))

cv2.waitKey(0)
