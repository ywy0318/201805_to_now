import re
import requests
from bs4 import BeautifulSoup
 
word = '夜景城市'
print('找到关键词:'+word+'的图片，现在开始下载')
page=1
i=1
while page<5:
    url='https://stock.tuchong.com/search?term=%E5%A4%9C%E6%99%AF%E5%9F%8E%E5%B8%82&use=0&type=&layout=&sort=0&category=0&page='+str(page)+'&size=100&search_from=suggest&exact=0&platform=weili&tp=%E5%A4%9C%E6%99%AF&abtest=&royalty_free=0&option=&has_person=0&face_num=&gender=0&age=&racial='
    print('当前页数',page)
    result = requests.get(url)
    result.encoding="gbk2312"
    html=result.text
    pic_url=re.findall('"imageId":"(.*?)"',html,re.S)
    address='http://p9.pstatp.com/weili/ms/'
    for each in pic_url:
        #拼接地址
        picadres=address+str(each)+'.webp'
        print ('正在下载第' + str(i) + '张图片，图片地址:' + picadres)
        try:
            #用requests.get获取图片，因为有延迟的问题，就设置timeout为10秒
            pic=requests.get(picadres,timeout=10)
            #无法连接就跳过错误，免得打断进程
        except requests.exceptions.ConnectionError :
            print('【错误】当前图片无法下载')
            continue
        except requests.exceptions.ReadTimeout:
            print("【错误】ReadTimeout")
            continue
        #保存到当地目录
        dir='F:/3/'+str(i)+'.jpg'
        fp=open(dir,'wb')
        fp.write(pic.content)
        fp.close()
        i+=1    
    page+=1
