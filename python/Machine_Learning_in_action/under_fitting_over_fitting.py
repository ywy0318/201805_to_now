#使用线性回归模型在披萨饼训练样本上进行拟合
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt 
import numpy as np 

#使用2次多项式回归模型在披萨饼训练样本上进行拟合
#导入多项式特征产生器
from sklearn.preprocessing import PolynomialFeatures

#输入训练样本的特征及目标值,分别存储在变量x_train与y_train
x_train=[[6],[8],[10],[14],[18]]
y_train=[[7],[9],[13],[17.5],[18]]



x_test=[[6],[8],[11],[16]]
y_test=[[8],[12],[15],[18]]

#使用默认配置初始化线性回归模型
regessor=LinearRegression()
#直接以披萨饼的直径作为特征训练模型
regessor.fit(x_train,y_train)
#在x轴上从0-25均匀采样100个数据点
xx=np.linspace(0,26,100)
xx=xx.reshape(xx.shape[0],1)
#以上述100个数据点作为基准，预测回归直线
yy=regessor.predict(xx)
print(regessor.score(x_train,y_train))


#使用polynominalFeatures(degree=2)映射出2次多项式特征,存储在变量x_train_poly2
poly2=PolynomialFeatures(degree=2)
x_train_poly2=poly2.fit_transform(x_train)
#以线性回归器作为基础，初始化回归模型，尽管特征的维度有所提升，但是模型基础仍然是线性模型
regessor_ploy2=LinearRegression()
#多2次多项式回归模型进行训练
regessor_ploy2.fit(x_train_poly2,y_train)
#从新映射绘图用x轴采样数据
xx_ploy2=poly2.transform(xx)
#使用2次多项式回归模型对应x轴采样数据进行回归预测
yy_poly_2=regessor_ploy2.predict(xx_ploy2)
print(regessor_ploy2.score(x_train_poly2,y_train))


poly_4=PolynomialFeatures(degree=4)
x_train_poly_4=poly_4.fit_transform(x_train)
regessor_ploy_4=LinearRegression()

regessor_ploy_4.fit(x_train_poly_4,y_train)
xx_ploy_4=poly_4.transform(xx)
yy_poly_4=regessor_ploy_4.predict(xx_ploy_4)
print(regessor_ploy_4.score(x_train_poly_4,y_train))

print("test")
x_test_poly_2=poly2.transform(x_test)
x_test_poly_4=poly_4.transform(x_test)
print(regessor.score(x_test,y_test))
print(regessor_ploy2.score(x_test_poly_2,y_test))
print(regessor_ploy_4.score(x_test_poly_4,y_test))


#分别对训练数据点，线性回归直线，2次多项式回归曲线进行作图
plt.scatter(x_train,y_train)

plt1,=plt.plot(xx,yy,label='Degree=1')
plt2,=plt.plot(xx,yy_poly_2,label='Degree=2')
plt4,=plt.plot(xx,yy_poly_4,label='Degree=4')

plt.xlabel("diameter of pizza ")
plt.ylabel('price of pizza')
plt.legend(handles=[plt1,plt2,plt4])
plt.show()