#define _CRT_SECURE_NO_WARNINGS
#include"person.h"
#include<string>
#include<iostream>
using namespace std;
int output::op(int a)
{
	cout << a << endl;
	return 999;
}


cperson::cperson(cperson &copyperson)
{
	m_index=copyperson.m_index;
	m_age= copyperson.m_age;
	m_salary = copyperson.m_salary;
}
cperson::cperson()
{
	m_index = 99;
}
cperson::~cperson()
{
	cout<<"destruction"<<endl;
}
cperson::cperson(int index, short age, double sal, char *buf)
{
	m_index = index;
	m_age = age;
	m_salary = sal;
	strcpy(m_name, buf);
	cout << "cperson::cperson" << endl;
}
/**静态成员函数定义的时候不能使用static关键字，*/
void cperson::outputinfo()
{
	cout << m_nd << endl;
	//cout << m_index << endl;
}

short cperson::getage()
{	 
	
	return m_age;
}
short cperson::setage(int age)
{
	m_age = age;
	return 0;
}
int cperson::getindex()
{
	cout << m_nd << endl;//!!!!!!!!!访问静态变量居然没事
	return m_index;
}
int cperson::setindex(int index)
{
	m_index = index;
	return 0;
}
char *cperson::getname()
{
	return m_name;
}
int cperson::setname(char name[])
{
	strcpy(m_name,name);
	
	return 0;
}
double cperson::getsalary()
{
	return m_salary;
}
double cperson::setsalary(double sala)
{
	m_salary = sala;
	return 0;
}