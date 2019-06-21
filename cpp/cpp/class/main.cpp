/*!!!!!!!!!普通函数访问静态变量居然没事!!!!!!!!!!!*/
/*!!!!!!!!调用类的成员函数的时候注意加()!!!!!!!!!*/
#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include"person.h"
#include<string>
#include<stdlib.h>

namespace myname1
{
	int ivalue = 10;
}
namespace myname2
{
	int ivalue = 20;
}

int ivalue = 30;

char buffer[] = "skye_dysi";
using namespace std;

int cperson::m_nd=100;//可能只能在全局变量的地方初始化


int main()
{
	//using namespace ;
	//using namespace output;
	cout << output::op(myname1::ivalue) << endl;
	/*
	cout << myname1::ivalue << endl;
	cout << myname2::ivalue << endl;
	cout << ivalue << endl;
	*/
	
	cout<<ivalue<<endl;
	cout << "****" << endl;


	/*
	int a;
	cperson p(22, 22, 22.00, buffer);
	
	cperson p1(p);
	cperson p2;
	cout << "****" << endl;
	p.outputinfo();
	a=p2.getindex();
	cout << a << endl;
	cout << "****" << endl;
	cout << "m_nd " << cperson::m_nd << endl;
	cout << "m_nd " << p.m_nd << endl;
	cout << "p1.m_nd " << p1.m_nd << endl;
	cout << "p2.m_nd  " << p2.m_nd << endl;
	cout << "****" << endl;
	cout << "index age sal name " << p.m_index<<" "<< p.m_age << p.m_salary << p.m_name << endl;
	cout << "index : " << p1.m_index << endl;
	//cperson p1, p2, p3;
	int iResult = -1;
	cout << "****" << endl;
	cout << "p1.m_index " << p1.m_index << endl;
	cout << "p1.m_age " << p1.m_age << endl;
	cout << "p1.m_salary " << p1.m_salary << endl;
	//cout << "index" << p3.m_index << endl;
	iResult = p.setage(25);
	if (iResult>=0)
	{
		//cout << "m_age is : " <<  p.m_age << endl;
	}
	if (iResult >= 0)
	{
		cout << "getage is : " << p.getage() << endl;
	}
	iResult = p.setindex(1);
	if (iResult >= 0)
	{
		cout << "getindex is : " << p.getindex() << endl;
	}
	iResult = p.setsalary(1000.00);
	if (iResult >= 0)
	{
		cout << "getsalary is : " << p.getsalary() << endl;
	}
	char buf[] = "skye";	
	iResult = p.setname(buf);
	if (iResult >= 0)
	{
		cout << "getname is : " << p.getname() << endl;
	}
	*/


	system("pause");
	return 0;
}