#include<iostream>//输入输出流标准库文件
using namespace std;//using指示符
void read() {
	cout << "read()\n";
}
void sort()
{
	cout << "sort()\n";
}
void compact()
{
	cout << "compact()\n";
}
void write()
{
	cout << "write()\n";
}
int main()
{
	read();
	sort();
	compact();
	write();

	system("pause");
	return 0;

}