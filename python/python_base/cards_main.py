
import cards_tools
#无限循环,由用户决定什么时候退出循环
'''
while True:
    pass
'''
cards_tools.show_menu()
action_str="1"
#action_str=input("请选择希望执行的操作:")
#vscode执行输入操作的时候出问题!!!!!
print("您的选择操作是[%s]"%action_str)

#1,2,3针对名片的操作
if action_str in ["1","2","3"]:
    if action_str=="1":
        cards_tools.show_all()
    elif action_str=="2":
        cards_tools.new_card()
    elif action_str=="3":
        cards_tools.search_card()
#0退出系统
elif action_str=="0":
    #如果再开发从程序时,不希望立刻编写分支内部的代码
    #可以使用pass关键字,表示一个占位符,能够保证代码的结构正确
    #程序运行时,pass关键字不会执行任何的操作
    print("欢迎再次使用名片管理系统")    
    #break

else:
    print("输入错误")






