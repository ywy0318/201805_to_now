#添加水印

#图片水印待续---------
#文字水印
from PIL import Image,ImageDraw,ImageFont
img=Image.open('E:/Visual Studio 2010/python_for_vscode/opencv__digital_image_processing/lena_2.jpg')
gray=img.convert('RGBA')# 1 L P RGB RGBA CMYK(没有转化图像) YCbCr I F 
print(img.mode)
txt=Image.new('RGBA',img.size,(0,0,0,0))
fnt=ImageFont.truetype('C:/Windows/Fonts/tahoma.ttf',20)
d=ImageDraw.Draw(txt)
d.text((txt.size[0]-80,txt.size[1]-30),'cnblogs',font=fnt,fill=(255,255,255,255))
#out=Image.alpha_composite(img,txt)
#待续---
'''
Image.alpha_composite(im1,im2)
将im2复合到im1上面，返回一个image对象，
im1--im2的size要相同,且im1和im2的mode都必须是RGBA

PIL.Image.composite(im1,im2,mask)
通过使用透明遮罩混合图像创建复合图像

im1--第一个图像
im2--第二个图像  im1和im2的size和mode必须相同
mask--也是一个图像,mode可以为'1','L','RGBA',并且大小要和im1,im2一样


'''
out=Image.alpha_composite(gray,txt)
out.show()

