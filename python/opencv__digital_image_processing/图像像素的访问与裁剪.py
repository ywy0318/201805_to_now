#图片读入程序中后,是以numpy数组存在的,因此对numpy数组的一切功能,
#对图片也适用,对数组元素的访问,实际上就是对图片像素点的访问
'''
彩色图片访问方式为:
img[i,j,c]
i:表示图片的行,j:表示图片的列数,c:表示图像的通道数(RGB三通道分别对应着0,1,2),坐标从左上角开始
回读图像的访问方式
gray[i,j]
'''
#输出小猫的G通道的第20行30列的像素值
from skimage import io,data,color
import numpy as np 
img=data.chelsea()

pixel=img[20,30,1]
print(pixel)

#将彩色三通道图片转换成为灰度图,转换结果为float类型的数组,范围为[0,1]之间
img_gray=color.rgb2gray(img)
print(img.dtype.name)
print(img_gray.dtype.name)
rows,cols=img_gray.shape

#先对R通道的所有像素值进行判断,如果大于170,将这个地方的像素值变为[0,255,0],即G通道的值为255,RB通道的值为0
reddish=img[:,:,0]>170
print(reddish.shape)
print(reddish.size)
reddish_img=img
reddish_img[reddish]=[0,255,0]

R=img[:,:,0]

roi=img[80:180,100:200,:]

rows,cols,dims=img.shape
#将图片进行二值化,像素大于128的变为1，否则为0
for ii in range(rows):
    pass
    for j in range(cols):
        pass
        if(img_gray[ii,j]<=0.5):
            img_gray[ii,j]=0
        else:
            img_gray[ii,j]=1



#随机生成5000个椒盐噪声
for i in range(5000):
    pass
    x=np.random.randint(0,rows)
    y=np.random.randint(0,cols)
    #img[x,y,:]=255#对像素值进行修改,将原来三通道像素值,变为255


'''
对多个像素点进行操作,使用数组切片方式访问,切片方式返回的是以指定间隔下标访问
该数组的像素值,
img[i:]=img[j:]#将第j行的数组付给第i行
img[:i]=100,#将第i列的所有的数值设为100
img[:100,50:100].sum()#计算前100行,前50行所有数值的和
img[50:100,50:100]#50-100行,50-100列,(不包含第100行和100列)
img[i].mean()#第i行所有数值的平均值
img[:,-1]#最后一列
img[-2,:] or img[-2]倒数第二行
'''
io.imshow(reddish_img)
io.show()