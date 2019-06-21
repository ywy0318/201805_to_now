#pragma once

#ifndef __PERSON_H__
#define __PERSON_H__
#include<iostream>
using namespace std;

namespace output
{
	int op( int a);
}

class cperson
{
	cperson *ano;//只能定义自己的类指针，不能包含自己的类；
	static cperson bol;//静态的类自己可以

public:
	cperson(cperson & copyperson);
	cperson();//默认构造函数
	cperson::cperson(int index,short age,double sal,char *buf);
	~cperson();
	//
	static int m_nd;

	/**成员为当前类，类指针，静态成员为当前类*/
	//cperson m_person;
	static cperson m_per;
	cperson *m_pson;
	/**成员为当前类，类指针，静态成员为当前类*/


	int m_index;
	char m_name[20];
	short m_age;
	double m_salary;
	int getindex();
	int setindex(int index);
	short getage();
	short setage(int age);
	char *getname();
	int setname(char name[]);
	double getsalary();
	double setsalary(double sala);
	static void outputinfo() ;
	//static void outputinfo() const;//静态成员函数不能使用const关键字
	void otptinfo(int data = m_nd)
	{
		cout << data << endl;
	}
	/*void otptpage(int dta = m_age)
	{
		cout << dta << endl;
	}*/
private:

};

#endif