#include<iostream>
#include<string>
#include<fstream>
#include<iomanip>
using namespace std;

int main()
{

	double a = 123.4567890123;
	cout << a << endl;
	cout << setprecision(9) <<a<< endl;//ÓÐÐ§Êý×Ö
	cout << setprecision(6) ;
	cout << setiosflags(ios::fixed) << endl;
	cout << setiosflags(ios::fixed) << setprecision(8)<<a << endl;
	cout << setiosflags(ios::scientific)  << a << endl;
	cout << setiosflags(ios::scientific) << setprecision(4) << a << endl;

	cout << sizeof(66) << endl;
	system("pause");
	return 0;
}