#使用线性回归模型LinearRegression和SGDRegression分别对美国波士顿地区房价进行预测

#https://scikit-learn.org/stable/tutorial/machine_learning_map/

#从sklearn.datasets导入波士顿房价数据读取器
from sklearn.datasets import load_boston
import numpy as np 
from sklearn.model_selection import train_test_split
#从sklearn.preprocessing 导入数据标准化模块
from sklearn.preprocessing import StandardScaler
#从sklearn.linear_model导入linearRegression
from sklearn.linear_model import LinearRegression
#从sklearn.linear_model导入SGDRegressor
from sklearn.linear_model import SGDRegressor
#从sklearn.metrics 依次导入r2_score,mean_squared_error,以及mean_absolute_error用于回归性能的评估
from sklearn.metrics import r2_score,mean_squared_error,mean_absolute_error

#从Sklearn.svm中导入支持向量机(回归)模型
from sklearn.svm import SVR

#从sklearn.neighbors 导入KNeighborRegressor(K近邻回归器)
from sklearn.neighbors import KNeighborsRegressor

#从sklearn.tree中导入DecisionTreeRegressor
from sklearn.tree import DecisionTreeRegressor

#从sklearn.ensemble中导入RandomForestRegressor,ExtraTreeGressor以及GradientBoostingRegressor
from sklearn.ensemble import RandomForestRegressor,ExtraTreesRegressor,GradientBoostingRegressor

#从读取房价数据存储在变量boston
boston=load_boston()#该数据没有缺失的属性/特征值(Missing Attribute Values)
#print(boston.DESCR)

x=boston.data

y=boston.target

x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.25,random_state=33)
#分析回归目标值的差异
"""
print("the max target value is ")
print(np.max(boston.target))
print("the min target value is ")
print(np.min(boston.target))
print("the average target value is ")
print(np.mean(boston.target))
"""

'''
x_new = [50000,8,1.2]
y_pred = knn.predict(x_new)
//
x_new = np.array(x_new).reshape(1, -1)
y_pred = knn.predict(x_new)
'''
#print(y_train.shape)
#print(y_test.shape)
#.reshape(1,-1)的话就会变成一行n列---.reshape(-1,1)变成n行1列
#ValueError: Found input variables with inconsistent numbers of samples: [379, 1]
#y_train = np.array(y_train).reshape(1, -1)
y_train = np.array(y_train).reshape(-1, 1)
y_test = np.array(y_test).reshape(-1, 1)
#print(y_train.shape)
#print(y_test.shape)
#分别初始化对特征和目标值的标准化器
ss_x=StandardScaler()
ss_y=StandardScaler()

#分别对训练数据和测试数据的特征及目标值进行标准化处理
#训练数据和测试数据处理不一样!!!!!!!!!!!
x_train=ss_x.fit_transform(x_train)#特征标准化处理

x_test=ss_x.transform(x_test)#目标值标准化处理

y_train=ss_y.fit_transform(y_train)
y_test=ss_y.fit_transform(y_test)
'''
y_test=ss_y.transform(y_test)



y_test=ss_y.fit_transform(y_test)
y_test=ss_y.transform(y_test)

y_train=ss_y.fit_transform(y_train)
'''


#使用默认配置初始化线性回归器LinearRegeression
lr=LinearRegression()
#使用训练数据进行参数估计
lr.fit(x_train,y_train)
#对数据进行回归预测
lr_y_predict=lr.predict(x_test)



#print(help(lr.fit))
#print(x_train.shape)
#print(y_train.shape)
#print(type(x_train))
#print(type(y_train))




#使用默认配置初始化线性回归器SGDRegressor
sgdr=SGDRegressor()
sgdr.fit(x_train,y_train)
sgdr_y_predict=sgdr.predict(x_test)


#使用线性核函数配置的支持向量机进行回归训练,并且对测试样本进行预测
linear_svr=SVR(kernel='linear')
linear_svr.fit(x_train,y_train)
Linear_svr_y_predict=linear_svr.predict(x_test)

#使用多项式核函数配置的支持向量机进行回归训练,并且对测试样本进行预测
poly_svr=SVR(kernel='poly')
poly_svr.fit(x_train,y_train)
poly_svr_y_predict=poly_svr.predict(x_test)

#使用径向基核函数配置的支持向量机进行回归训练,并且对测试样本进行预测
rbf_svr=SVR(kernel='rbf')
rbf_svr.fit(x_train,y_train)
rbf_svr_y_predict=rbf_svr.predict(x_test)

#初始化K近邻回归器,并且调整配置,使得预测的方式为平均回归,weight='uniform'
uni_knr=KNeighborsRegressor(weights='uniform')
uni_knr.fit(x_train,y_train)
uni_knr_y_predict=uni_knr.predict(x_test)

#初始化K近邻回归器,并且调整配置,使得预测的方式为根据距离加权回归,weight='distance'
dis_knr=KNeighborsRegressor(weights='distance')
dis_knr.fit(x_train,y_train)
dis_knr_y_predict=dis_knr.predict(x_test)


#使用默认配置初始化DecisionTreeRegressor
dtr=DecisionTreeRegressor()
dtr.fit(x_train,y_train)
dtr_y_predict=dtr.predict(x_test)

#使用RandomForestRegressor训练模型
rfr=RandomForestRegressor()
rfr.fit(x_train,y_train)
rfr_y_predict=rfr.predict(x_test)

#使用 ExtraTreesRegressor 训练模型
etr=ExtraTreesRegressor()
etr.fit(x_train,y_train)
etr_y_predict=etr.predict(x_test)

#使用 GradientBoostingRegressor 训练模型--GradientBoostingRegressor
gbr=GradientBoostingRegressor()
gbr.fit(x_train,y_train)
gbr_y_predict=gbr.predict(x_test)

print("linearRegression\n")
#使用Linear_regression模型自带的评估模块，并输出评估结果
print("the value of default measurement of linearRegression is ")
print(lr.score(x_test,y_test))

print("the value of R-squared of LinearRegression is ")
print(r2_score(y_test,lr_y_predict))

print("the mean squared error of linearRegression is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(lr_y_predict)))

print("the mean absolute error of linearRegeression is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(lr_y_predict)))

print("SGDRegressor\n")
#使用 SGDRegressor 模型自带的评估模块，并输出评估结果

print("the value of default measurement of SGDRegressor is ")
print(sgdr.score(x_test,y_test))

print("the value of R-squared of SGDRegressor is ")
print(r2_score(y_test,sgdr_y_predict))

print("the mean squared error of SGDRegressor is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(sgdr_y_predict)))

print("the mean absolute error of SGDRegressor is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(sgdr_y_predict)))

print("\n")
#使用 SGDRegressor 模型自带的评估模块，并输出评估结果
print("linear")

print("the value of R-squared of linear is ")
print(r2_score(y_test,Linear_svr_y_predict))

print("the mean squared error of linear is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(Linear_svr_y_predict)))

print("the mean absolute error of linear is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(Linear_svr_y_predict)))


print("\n")
#使用 SGDRegressor 模型自带的评估模块，并输出评估结果
print("poly")

print("the value of R-squared of poly is ")
print(r2_score(y_test,poly_svr_y_predict))

print("the mean squared error of poly is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(poly_svr_y_predict)))

print("the mean absolute error of poly is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(poly_svr_y_predict)))

#使用 SGDRegressor 模型自带的评估模块，并输出评估结果
print("\n")
print("rbf")

print("the value of R-squared of rbf is ")
print(r2_score(y_test,rbf_svr_y_predict))

print("the mean squared error of rbf is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(rbf_svr_y_predict)))

print("the mean absolute error of rbf is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(rbf_svr_y_predict)))

print("\n")
print("uni_knr")
print("the value of R-squared of uni_knr is ")
print(r2_score(y_test,uni_knr_y_predict))

print("the mean squared error of knr is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(uni_knr_y_predict)))

print("the mean absolute error of knr is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(uni_knr_y_predict)))

print("\n")
print("dis_knr")
print("the value of R-squared of dis_knr is ")
print(r2_score(y_test,dis_knr_y_predict))

print("the mean squared error of knr is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(dis_knr_y_predict)))

print("the mean absolute error of knr is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(dis_knr_y_predict)))

print("\n")
print("dtr")
print("the value of R-squared of dis_knr is ")
print(r2_score(y_test,dtr_y_predict))
print("the mean squared error of knr is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(dtr_y_predict)))
print("the mean absolute error of knr is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(dtr_y_predict)))

print("\n")
print("rfr")
print("the value of R-squared of rfr is ")
print(r2_score(y_test,rfr_y_predict))
print("the mean squared error of rfr is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(rfr_y_predict)))
print("the mean absolute error of rfr is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(rfr_y_predict)))

print("\n")
print("etr")
print("the value of R-squared of etr is ")
print(r2_score(y_test,etr_y_predict))
print("the mean squared error of etr is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(etr_y_predict)))
print("the mean absolute error of etr is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(etr_y_predict)))

print("\n")
print("gbr")
print("the value of R-squared of gbr is ")
print(r2_score(y_test,gbr_y_predict))
print("the mean squared error of gbr is ")
print(mean_squared_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(gbr_y_predict)))
print("the mean absolute error of gbr is ")
print(mean_absolute_error(ss_y.inverse_transform(y_test),ss_y.inverse_transform(gbr_y_predict)))