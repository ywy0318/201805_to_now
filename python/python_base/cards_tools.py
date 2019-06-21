#记录所有的名片字典
card_list=[]

def show_menu():

    #显示菜单
    print("*"*10)
    print("欢迎使用[名片管理系统]   V1.0")
    print("")
    print("1.新增名片")
    print("2.显示全部")
    print("3.搜索名片")
    print("")
    print("0.退出系统")
    print("*"*10)

def new_card():

    """新增名片 """
    print("-"*10)
    print("新增名片")
    #1.提示用户输入名片的详细信息
    name_num=input("请输入姓名:")
    phone_num=input("请输入电话:")
    qq_num=input("请输入QQ:")
    email_num=input("请输入邮箱地址:")
    #2.使用用户输入的信息建立一个名片
    card_dict={"name":name_num,
                "phone":phone_num,
                "qq":qq_num,
                "email":email_num}
    #3.将名片字典添加到列表中
    card_list.append(card_dict)
    print(card_list)
    #4.提示用户添加成功
    print("添加%s的名片成功!"%name_num)

def show_all():

    print("$"*10)
    print("显示所有名片")
    if len(card_list)==0:
        print("当前没有名片记录")
        #return可以返回一个函数的执行结果
        #下方的代码不会被执行
        #如果return后面没有任何的内容,表示会返回到函数调用的位置
        #并且不返回任何的结果
        return
    #打印表头
    for name in ["姓名","电话","QQ","邮箱"]:
        print(name,end="\t\t")
    print("")
    #打印分割线
    print("*"*10)
    #遍历名片列表依次输出字典信息
    for card_dict1 in card_list:
        print("%s\t\t%s\t\t%s\t\t%s"%(card_dict1["name"],card_dict1["phone"],
            card_dict1["qq"],card_dict1["email"]))


def search_card():

    print("#"*10)
    print("搜索名片")
    #1.提示用户输入要搜索的姓名
    find_name=input("请输入要搜索的姓名:")
    #2.遍历名片列表,查询要搜索的姓名,如果没找到,需要提示用户
    for card_dict in card_list:
        if card_dict["name"]==find_name:
            print("姓名\t\t电话\t\tQQ\t\t邮箱")
            print("="*10)
            print("%s\t\t%s\t\t%s\t\t%s"%(card_dict["name"],
                card_dict["phone"],card_dict["QQ"],
                card_dict["email"]))
            #TODO 针对找到的名片记录执行修改和删除操作
            break
        else:
            print("没找到%s"%find_name)


def deal_card(find_dict):
    print(find_dict)
    action_string=0
    if action_string==1:
        find_dict["name"]="sss"
        find_dict["phone"]=123456789
        find_dict["QQ"]=123456
        find_dict["email"]="123@123.com"
        print("修改名片")
    elif action_string==2:
        print("删除名片")
        card_list.remove(find_dict)


def input_card_info(dict_value,tip_message):
    """
    param dict_value:字典中原有的值
    param tip_message:输入的提示文字
    return :如果用户输入了内容，就返回内容，否则就返回字典中的原有值
    """    
    #1，提示用户输入内容
    result_string=input(tip_message)
    #2,针对用户的输入进行判断，如果用户输入了内容，直接返回结果
    if len(result_string)>0:
        return result_string
    else:
        return dict_value
    #3,如果用户没有输入内容，返回字典中原有的值
    pass
        
