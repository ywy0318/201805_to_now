#Pandas —— 日期范围date_range()、移动数据shift()及日期位移rollforward()和rollback()


import pandas as pd 
from pandas import Series,DataFrame
import numpy as np 
from pandas.tseries.offsets import Day,MonthEnd

#传入开始和结束时间
#print(pd.date_range("2012-4-10","2015-1-4"))#dtype='datetime64[ns]', length=1000, freq='D')
#传入开始时间和时间间隔
#print(pd.date_range(start="4/1/2019",periods=20))#开始日期，和个数
#传入结束时间和时间间隔
#print(pd.date_range(end="4/1/2019",periods=3))#结束日期，和个数

#normalize规范化
#如果我们传入的是一个带有时间戳的日期，但是希望产生得到的时间都被规范到午夜，可以传入normalize选项
#print(pd.date_range("5/2/2019 10:42:31",periods=5,normalize=True))

#freq指定频率
#print(pd.date_range("5/2/2019 10:42:31",periods=5,normalize=True,freq="M"))

# 移动数据shift()
#shift()是指在索引不变的条件下，沿着时间轴将数据迁移或者后移，通常用于计算时间序列中百分比的变化,即ts/ts.shift(1)-1
#标准正态分布俗称高斯分布，正态分布是大自然中最常见的分布，标准正态分布就是期望为0，方差为1的正态分布。(数学期望为μ、方差为σ^2的正态分布)
#2.5 * np.random.randn(2, 4) + 3 #生成2行4列的符合（3,2.5^2）正态分布矩阵 其中u=3 σ=2.5
ts=pd.Series(np.random.randn(4),index=pd.date_range("4/8/2019",periods=4,freq="M"))
print(ts)
print("*"*5)
print(ts.shift(2))
print("*"*5)
print(ts.shift(-2))
print("*"*5)
print(ts.shift(-2,freq="D"))
print("*"*5)
print(ts.shift(-2,freq="M"))

'''
!!!!!!!日期位移待续!!!!!!!!!!!!!!!!!!!!!!!!!!
print("*"*10)
now=datetime(2011,11,17)
now+3.Day()
#Timestamp("2011-11-20 00:00:00")
print(now)
offset=MonthEnd()
offset.rollforward(now)
print(now)
'''
"""
#如果是日期偏移量
from pandas.tseries.offsets import Day, MonthEnd
now = datetime(2011, 11, 17)
now + 3 * Day()
Timestamp('2011-11-20 00:00:00')

#如果加的是锚点偏移量（比如 MonthEnd 当月月底） 第一次增量会将原日期向前滚动到符合频率规则的下一个日期：
offset = MonthEnd()
offset.rollforward(now)
Timestamp('2011-11-30 00:00:00')


#通过锚点偏移量的rollforward 和rollback 方法，可以显式地将日期向前或者向后‘滚动’
offset = MonthEnd()
offset.rollforward(now)
Timestamp('2011-11-30 00:00:00')
offset.rollback(now)
Timestamp('2011-10-31 00:00:00')
"""


"""
别名	偏移量类型	说明
D	Day	每日历日
B	BusinessDay	每工作日
H	Hour	每小时
T/min	Minute	每分
S	Second	每秒
L/ms	Million	每毫秒
U	Micro	每微妙
M	MonthEnd	每月最后一个日历日
BM	BusinessMonthEnd	每月最后一个工作日
MS	MonthBegin	每月第一个日历日
BMS	BusinessMonthBegin	每月第一个工作日
W-MON、W-TUE…	Week	从指定的星期几开始算起，每周
WOM-1MON、WOM-2MON…	WeekOfMonth	产生每月第一、二、三、四周的星期几，例如WOM-1MON表示每月的第一个星期一
Q-JAN、Q-FEB…	QuarterEnd	对于以指定月份（JAN、FEB、…、DEC）结束的年度，每季度的最后一月的最后一个日历日
BQ-JAN、BQ-FEB…	BusinessQuarterEnd	对于以指定月份（JAN、FEB、…、DEC）结束的年度，每季度的最后一月的最后一个工作日
QS-JAN、QS-FEB…	QuarterBegin	对于以指定月份（JAN、FEB、…、DEC）结束的年度，每季度的最后一月的第一个日历日
BQS-JAN、BQS-FEB…	BusinessQuarterBegin	对于以指定月份（JAN、FEB、…、DEC）结束的年度，每季度的最后一月的第一个工作日
A-JAN、A-FEB…	YearEnd	每年指定月份最后一个日历日
BA-JAN、BA-FEB…	BusinessYearEnd	每年指定月份最后一个工作日
AS-JAN、AS-FEB…	YearBegin	每月指定月份第一个日历日
BAS-JAN、BAS-FEB…	BusinessYearBegin	每月指定月份第一个工作日

"""