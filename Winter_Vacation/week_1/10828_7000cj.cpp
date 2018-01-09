#include <iostream>
#include <string>
#include <stack>
using namespace std;


class stack1
{
private:
	int capacity;
	stack<int> st;
	string str;
public:
	~stack1()
	{

	}
	stack1()
	{

	}
	void pcj()
	{
		cin >> capacity;
		for (int i = 0; i < capacity; i++)
		{
			cin >> str;
			if (str == "push")
			{
				int num;
				cin >> num;
				st.push(num);
			}
			else if (str == "size")
			{
				cout << st.size() << endl;
			}
			else if (str == "empty")
			{
				if (st.empty()) {
					cout << "1" << endl;
				}
				else {
					cout << "0" << endl;
				}
			}
			else if (str == "top")
			{
				if (!st.empty()) {
					cout << st.top() << endl;
				}
				else {
					cout << "-1" << endl;
				}
			}
			else if (str == "pop")
			{
				if (!st.empty()) {						//������� ������ Ƽ���� ����ϰ� ��   
					cout << st.top() << endl;
					st.pop();
				}
				else {
					cout << "-1" << endl;					//�ƴϸ� -1
				}
			}
		}
	}
};

int main() {

	stack1 ps;
	ps.pcj();
	
	
	return 0;
}