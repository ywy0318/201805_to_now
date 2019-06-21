#图像的绘制
'''
imshow()函数格式:
matplotlib.pyplot.imshow(X,cmap=None)
X:要沪指的图像或数组
cmap:颜色图谱(colormap),默认绘制为RGB(A)颜色空间

颜色图谱---描述
autumn 红橙黄
bone 黑白,x线
cool 青--洋红
copper 黑铜
flag 红白蓝黑
gray 黑白---------------
hot  黑红黄白
hsv  hsv颜色空间,红黄绿青蓝-洋红-红
infern 黑红黄
jet 蓝青黄红------------------
magma 黑红白
pink 黑粉白
plasma 绿红黄
prism 红黄绿蓝紫...绿模式
spring 洋红-黄
summer 绿-黄
viridis 蓝绿黄
winter 蓝绿

plt.imshow(image,plt.cm.gray)
plt.imshow(image,plt.cm.jet)

'''
