from tensorflow.examples.tutorials.mnist import input_data

import tensorflow as tf 


def weight_variable(shape):
    pass
    initial=tf.truncated_normal(shape,stddev=0.1)
    return tf.Variable(initial)

def bias_variable(shape):
    pass
    initial=tf.constant(0.1,shape=shape)
    return tf.Variable(initial)

#卷积和池化
#卷积使用步长,边距,池化使用2x2大小的max pooling
def conv2d(x,w):
    pass
    return tf.nn.conv2d(x,w,strides=[1,1,1,1],padding='SAME')
def max_pool_2x2(x):
    pass
    return tf.nn.max_pool(x,ksize=[1,2,2,1],strides=[1,2,2,1],padding='SAME')

mnist=input_data.read_data_sets('F:/zzpersom/dataset/MNIST_data/',one_hot=True)
print(mnist.train.images.shape,mnist.train.labels.shape)#(55000, 784) (55000, 10)
print(mnist.test.images.shape,mnist.test.labels.shape)#(10000, 784) (10000, 10)
print(mnist.validation.images.shape,mnist.validation.images.shape)#(5000, 784) (5000, 784)

print('\n')
sess=tf.InteractiveSession()
#x和y_只是一个占位符，在tensorflow运行某一计算时根据该占位符输入具体的值
#placeholder占位符
x=tf.placeholder('float',shape=[None,784])
y_=tf.placeholder('float',shape=[None,10])
#第一层,卷积层
#初始化W为[5,5,1,32]的张量,表示卷积核大小为5*5，
# 第一层网络的输入和输入神经元个数分别为1和32

W_conv1=weight_variable([5,5,1,32])
#初始化b为[32],即输出大小
b_conv1=bias_variable([32])
#把输入x(二维张量,shape为[batch,784]变成4d的x_image,x_image的shape应该是[batch,28,28,1])
#-1表示自动推测这个维度的大小
x_image=tf.reshape(x,[-1,28,28,1])

#把x_image和权重进行卷积,加上偏置项,然后应用relu激活函数,最后进行max_pooling
#h_pool1的输出即为第一层网络输出,shape为[batch,14,14,1]
h_conv1=tf.nn.relu(conv2d(x_image,W_conv1)+b_conv1)
h_pool1=max_pool_2x2(h_conv1)


#第2层,卷积层
#卷积核大小依然是5*5,这层的输入和输出神经元个数为32和64
W_conv2=weight_variable([5,5,32,64])
b_conv2=weight_variable([64])
#h_pool即为第二层网络输出,shape为[batch,7,7,1]
h_conv2=tf.nn.relu(conv2d(h_pool1,W_conv2)+b_conv2)
h_pool2=max_pool_2x2(h_conv2)


#第3层,全连接层
#这层是拥有1024个神经元的全连接层
#W的第一维size为7*7*64,7*7是h_pool2输出的size,64是第2层输出神经元个数
w_fc1=weight_variable([7*7*64,1024])
b_fc1=bias_variable([1024])

#计算前需要把第2层的输出reshape成[batch,7*7*64]的张量
h_pool2_flat=tf.reshape(h_pool2,[-1,7*7*64])
h_fc1=tf.nn.relu(tf.matmul(h_pool2_flat,w_fc1)+b_fc1)

#dropout层
#为了减少过拟合,在输出层前加入dropout
keep_prob=tf.placeholder('float')
h_fc1_drop=tf.nn.dropout(h_fc1,keep_prob)


#输出层
#最后,添加一个softmax层
#可以理解为另一个全连接层,只不过输出时使用softmax
#将网络输出值转换成了概率


w_fc2=weight_variable([1024,10])
b_fc2=bias_variable([10])

y_conv=tf.nn.softmax(tf.matmul(h_fc1_drop,w_fc2)+b_fc2)


#预测值和真实值之间的交叉熵
cross_entropy=-tf.reduce_sum(y_*tf.log(y_conv))

#train op,使用ADAM优化器来做梯度下降,学习率为0.0001
train_step=tf.train.AdamOptimizer(1e-4).minimize(cross_entropy)


#评估模型,tf.argmax能给出某个tensor对象在某一维数据最大值的索引
#因为标签是由0,1组成了one-hot vector,返回的索引就是数值为位置
correct_predict=tf.equal(tf.argmax(y_conv,1),tf.argmax(y_,1))

#计算正确预测的比例,因为tf.equal返回的是布尔值
#使用tf.cast把布尔值转换成浮点数,然后用tf.reduce_mean求平均值
accuracy=tf.reduce_mean(tf.cast(correct_predict,'float'))

#初始化变量

sess.run(tf.global_variables_initializer())
#sess.run(tf.initialize_all_tables())# Attempting to use uninitialized val

print('for')
#开始训练模型,循环20000次,每次随机从训练集中抓取50幅图像
for i in range(200):
    pass
    batch=mnist.train.next_batch(10)
    if i%100==0:
        pass
        #每100次输出一次日志
        train_accuracy=accuracy.eval(feed_dict={x:batch[0],y_:batch[1],keep_prob:1.0})
        print(i,train_accuracy)
    train_step.run(feed_dict={x:batch[0],y_:batch[1],keep_prob:0.5})

print(accuracy.eval(feed_dict={x:mnist.test.images,y_:mnist.test.labels,keep_prob:1.0}))

'''
tensorflow/core/framework/allocator.cc:101] Allocation of X exceeds 10% of system memory. 
==> 將batch size 縮小
'''


'''
#创建模型之前,先加载MNIST数据集,启动一个Tensorflow的Session
#Tensorflow依赖于一个高效C++的后端来进行计算,与整个后端连接的叫做session
#Tensorflow程序的流程是先创建一个图,然后在session中启动它
sses=tf.InteractiveSession()

#x和y_只是一个占位符，在tensorflow运行某一计算时根据该占位符输入具体的值
#placeholder占位符
x=tf.placeholder('float',shape=[None,784])
y_=tf.placeholder('float',shape=[None,10])

#为模型定义权重W和偏置b
W=tf.Variable(tf.zeros([784,10]))
b=tf.Variable(tf.zeros([10]))

#变量需要通过session初始化后,才能再session中使用,
#为初始值指定具体的值,现在初始化全为0,并且为其分配每个变量
#一次性为所有变量完成此操作
sses.run(tf.initialize_all_variables())

#类别预测与损失函数
y=tf.nn.softmax(tf.matmul(x,W)+b)

#为训练过程指定最小化误差用的损失函数,
#损失函数是目标类别和预测类别之间的交叉熵

#tf.reduce_sum把minibatch里的每张图片的交叉熵值都加起来了,
#计算的交叉熵是指整个minibatch的
cross_entropy=-tf.reduce_sum(y_*tf.log(y))

#训练模型
#用最快下降法让交叉熵下降，步长为0.01
#用来往计算图上添加一个新操作,包含计算梯度，计算每个参数的步长变化,并且计算出新的参数值
#返回的train_step操作对象,在运行时会使用梯度下降来更新参数
#整个模型的训练可以通过反复的运行train_step来完成
train_step=tf.train.GradientDescentOptimizer(0.01).minimize(cross_entropy)


#每一次迭代都会加载50个训练样本,没执行一次train_step,并通过feed_dict
#将x和y_张量占位符用训练数据替代

#在计算图中,可以用feed_dict 来替代任何张量,不仅仅限于替换占位符
for i in range(1000):
    pass
    batch=mnist.train.next_batch(50)
    train_step.run(feed_dict={x:batch[0],y_:batch[1]})
    if (i%50==0):
        pass
        print(i)

#评估模型
#tf.argmax是一个非常有用的函数,它能给出某个tensor对象在某一维
#的数据最大值所在的索引值,由于标签向量是由0,1组成的,因此最大值
#1所在的索引位置就是类别标签,
#比如tf.argmax(y,1)返回的是模型对于任一输入x预测到的标签值,
#而tf.argmax(y_1,1)代表正确的标签，
#可以用tf.equal 来检测我们的预测是否真实标签匹配(索引位置一样表示匹配)
#这里返回一个布尔数组,为了计算我们分类的准确率,
#我们将布尔值转化为浮点数来表示对错,然后取平均值
#例如:[True,False,True,True]变为[1,0,1,1],计算出平均值为0.75
correct_prediction=tf.equal(tf.argmax(y,1),tf.argmax(y_,1))

accuracy=tf.reduce_mean(tf.cast(correct_prediction,'float'))

print(accuracy.eval(feed_dict={x:mnist.test.images,y_:mnist.test.labels}))
'''