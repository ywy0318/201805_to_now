#绘制pairplot
#用于显示各个特征对分类的影响,使用pairplot会生成散点图和直方图,
#每个图都显示不同的特征与分类关系

import seaborn as sns 
import matplotlib.pyplot as plt 
import numpy as np 
import pandas as pd 

df_iris=sns.load_dataset('iris')
#hue:确定关注的特征,即画该特征与其他特征的关系,palette：固定用法,图中各类别使用不同颜色
sns.pairplot(df_iris,hue='species',palette='husl')
plt.show()