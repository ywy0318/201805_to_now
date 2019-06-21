'''
Python之Matplotlib库
plt.saving('test',dpi=600)；将绘制的图画保存成png格式,命名为test
plt.ylabel('Grade'):y轴的名称
plt.axis([-1,10,0,6]):x轴起始于-1，终止于10,y轴起始于0,终止于6
plt.subplot(3,2,4):分成3行2列,共6个绘图区域,在第4个区域绘图,排序为行优先,都好可以省略

.plot函数
plt.plot(x,y,format_string,**kwargs):x为X轴数据，可为列表或数组；
y同理;format_string 为控制曲线的格式字符串,**kwargs第二组或更多的(x,y,format_string)

format_string:由颜色，字符，风格字符和标记字符组成
颜色字符:'b'蓝色;'#080000'RGB某颜色;'08'灰度值字符串
风格字符:'-'实线;'-'破折线;'-.'点划线;':'虚线," "无线条;
标记字符:'-',点标记,'o'实心圈,'v'倒三角,'^'上三角

eg:plt.plot(a,a*15，'go-',a,a*2,'*')第二条无曲线,只有点

.plot显示中文字符
pyplot并不默认支持中文显示,需要rcParam修改字体来实现
rcParam的属性:
'font.family'用于显示字体的名字
'font.style'字体风格,正常'normal'或斜体'italic'
'font.size'字体大小，整数字号或者'large'  'x-small'

eg:
import matplotlib
matplotlib.rcParam['font.family']='STsong'
matplotlib.rcParam['font.size']=20
设置绘制区域的全部字体变成华文仿宋,字体大小为20

中文显示2:只希望在某地方绘制中文字符，不改变别的地方字体
在有中文输出的地方,增加一个属性:fontproperties
eg:
plt.xlabel('横轴:时间',fontproperties='simHei',fontsize=20)

pyplot文本显示函数:
plt.xlabel():对x轴增加文本标签
plt.ylabel():同理
plt.title():对图形整体增加文本标签
plt.text():在任意位置增加文本
plt.annotate(s,xy=arrow_crd,xytext=text_crd,arrowprops=dict):
在图形中增加箭头的注释,s表示要注释的字符串是什么，xy对应箭头所在的位置,
xytext对应文本所在位置,arrowprops定义显示的属性
eg:
plt.xlabel('横轴:时间',fontproperties='SimHei',fontsize=15,color='green')
plt.ylabel('纵轴:振幅',fontproperties='SimHei',fontsize=15)
plt.title(r'正弦波实例y=cons(2∏x)’，fontsizeproperties='SimHei',fontsize=25)
plt.annotate(r'%mu=100$,xy=(2,1),xytext=(3,1.5)')
arrowprops=dict(factor='black',shrink=0.1,width=2)#width表示箭头宽度
plt.text(2,1,r'u=100,fontsize=15)
plt.grid(True)

plt.annotate(s,xy=arrow_crd,xytext=text_crd,arrowprops=dict)

plt子绘图区域

plt.subplot2grid(GridSpec,CurSpec,colspan=1,rowspan=1):设定网格，选中网格,确定选中行列区域数量，从0开始编号

eg:
plt.subplot2grid((3,3),(1,0),colspan=2):(3,3)表示分为3行3列,
(1,0)表示选中第一行,第0列的区域进行绘图,colspan=2表示在选中区域的延伸


plot的图表函数
plt.plot(x,y,fmt):绘制坐标图
plt.boxplot(data,notch,position):绘制箱式图
plt.bar(left,height,width,bottom):绘制条形图
plt.barh(width,bottom,left,height):绘制横向条形图
plt.polar(theta,r):绘制极坐标图
plt.pie(data,explode):绘制饼图
plt.scatter(x,y):绘制散点图
plt.hist(x,bings,normal):绘制直方图

10表示直方图的个数
plt.hist(a,10,normed=1,histtype='stepfilled',facecolor='b',alpha=0.75)


'''

import matplotlib.pyplot as plt 
import matplotlib.gridspec as gridspec
import numpy as np 
'''
plt.subplot2grid()
plt.subplot2grid((3,3),(0,0),colspan=3)
plt.subplot2grid((3,3),(1,0),colspan=2)
plt.subplot2grid((3,3),(1,2),colspan=2)
plt.subplot2grid((3,3),(2,0))
plt.subplot2grid((3,3),(2,1))
'''
'''
gs=gridspec.GridSpec(3,3)
ax_1=plt.subplot(gs[0,:])
ax_2=plt.subplot(gs[1,:-1])
ax_3=plt.subplot(gs[1:,-1])
ax_4=plt.subplot(gs[2,0])
ax_5=plt.subplot(gs[2,1])
'''

#绘制饼图
#explode表示突出；autopct 表示显示数据的格式;shadow表示二维饼图;
#startangle表示起始的角度;
#此为椭圆形饼图,要为圆形,可添加:plt.axis('equal')
'''
labels_1='Frogs','Hogs','dogs','Logs'
sizes_1=[15,30,10,15]
explode_1=(0,0.1,0,0)
plt.pie(sizes_1,explode=explode_1,labels=labels_1,autopct='%1.1f%%',shadow=False,startangle=90)
'''
#bings将直方图的取值范围进行均等划分bings个区间
#normal=1表示将出现频次进行了归一化.normal=0,则为频次
#alpha表示直方图的透明度[0,1]
#histtype='stepfilled'表示去除跳珠的黑色边框
'''
np.random.seed(0)
mu,sigma=100,20
a=np.random.normal(mu,sigma,size=100)
#plt.hist(a,10,normed=1,histtype='stepfilled',facecolor='b',alpha=0.75)
plt.hist(a,40,normed=1,histtype='stepfilled',facecolor='b',alpha=0.75)
plt.title('Histogram')
'''

#面向对象的极坐标图绘制
'''
N=20
theta=np.linspace(0.0,2*np.pi,N,endpoint=False)
#a=np.logspace
radii=10*np.random.rand(N)
width=np.pi/4*np.random.rand(N)
ax=plt.subplot(111,projection='polar')
bars=ax.bar(theta,radii,width=width,bottom=0.0)
for r,bar in zip(radii,bars):
    pass
    bar.set_facecolor(plt.cm.viridis(r/10.))
    bar.set_alpha(0.5)
'''
#面向对象画散点图绘制
#将subplots()变成一个对象,fig和ax表示subplots生成的图表以及相关区域,
#subplots为空时,默认为subplots(111)
fig,ax=plt.subplots()
ax.plot(10*np.random.randn(100),10*np.random.randn(100),'o')
ax.set_title('simple Scatter')

plt.show()