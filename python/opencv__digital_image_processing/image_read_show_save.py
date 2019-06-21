#图像的读取,skimage提供了io模块,
from skimage import io ,data_dir,data
#从外部读取图片并显示
#读取单张彩色rgb图片,使用skimage.io.imread(fname)函数
#表示需要读取的文件路径,显示图片使用skimage.io.imshow(arr)函数
#带一个参数,表示需要显示的arr数组(读取的图片以numpy数组形式计算)

#第二个参数默认为as_gray,bool型值,默认为False
#img=io.imread('E:/Visual Studio 2010/python_for_vscode/opencv__digital_image_processing/lena.jpg',as_gray=True)
#img=data.hubble_deep_field()
img=data.chelsea()
io.imshow(img)

print(type(img))#显示类型
print(img.shape)#显示尺寸
print(img.shape[0])#图片宽度
print(img.shape[1])#图片高度
print(img.shape[2])#图片的通道数
print(img.size)#显示响度总数
print(img.max())#显示最大像素值
print(img.min())#最小像素值
print(img.mean())#像素平均值

print(data_dir)
io.show()
'''
程序自带图片,
astronaut--宇航员图片
camera---拿相机的人图片
checkerboard--棋盘图片
chelaea--猫咪图片
clock--时钟图片
coffee--咖啡
coins--硬币
horse--马图片
hubble_deep_field--星空图片
immunohistochemistry--结肠图片
lena--lena图片
moon--月亮图片
page--书页图片
text--文字图片
'''