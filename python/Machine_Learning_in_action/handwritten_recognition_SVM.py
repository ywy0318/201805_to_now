#支持向量机对手写体数字图像进行识别

#从sklearn.datasets里导入手写体数字加载器
from sklearn.datasets import load_digits
#从sklearn.model_selection导入train_test_split用于数据分割
from sklearn.model_selection import train_test_split
#从sklearn.preprocessing里面导入数据标准化模块
from sklearn.preprocessing import StandardScaler
#从sklearn.svm里导入基于线性假设的支持向量机分类器LinearSVC
from sklearn.svm import LinearSVC

from sklearn.metrics import classification_report

#从通过数据加载器获得手写体数字图像数据存储在digits变量中

digits=load_digits()
#检查数据规模和特征维度
#print(digits.data.shape)#(1797, 64)
#将2D的图片像素军阵逐行拼接位1D的像素特征向量
#每幅图片是8*8=64的像素矩阵表示
#经典模型都没有对结构性信息进行学习的能力
#按照惯例对于没有直接提供测试样本的数据，通过数据分割获取75%的训练样本和25%的测试样本
#随机选取75%的数据作为训练样本,其余25%的数据作为测试样本
x_train,x_test,y_train,y_test=train_test_split(digits.data,digits.target,test_size=0.25,random_state=33)
#print(y_train.shape)
#print(y_test.shape)


#对训练和测试的特征数据进行标准化
ss=StandardScaler()
x_train=ss.fit_transform(x_train)
x_test=ss.fit_transform(x_test)

#初始化线性假设的支持向量机分类器LinearSVC
lsvc=LinearSVC()
#进行模型训练
lsvc.fit(x_train,y_train)
#利用训练好的模型对测试样本的数字类别进行预测,预测结果春存在变量y_predict中
y_predict=lsvc.predict(x_test)

#使用模型自带的评估函数进行准确性测评
print("the Accuracy of Linear SVC is ")
print(lsvc.score(x_test,y_test))
#依然使用sklearn,metrics import classification_report
print("classification_rport")
print(classification_report(y_test,y_predict,target_names=digits.target_names.astype(str)))
