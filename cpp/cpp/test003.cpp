/*从输入文件中读取一个字符串然后加个空格写入到输出文件中*/
#include<iostream>
#include<string>
#include<fstream>
using namespace std;

int main()
{
	ofstream outfile("out_file");
	ifstream infile("in_file");
	if (!infile)
	{
		cerr << "error:unable to open infile\n"  ;
		return -1;
	}
	if (!outfile)
	{
		cerr << "error:unable to open outfile\n"  ;
		return -2;
	}

	string word;
	while (infile>>word)
	{
		outfile << word << ' ';
	}

	system("pause");
	return 0;

}