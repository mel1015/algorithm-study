#include <iostream>
#include <algorithm>
#include <stack>
#include <queue>
#define MAX 100000
using namespace std;


int main(void)
{
	int temp[MAX];
	int i, n;
	int count = 0;
	stack<int> sNum;
	queue<char> qChar;
	cin >> n;

	for (i = 0; i < n; i++)
		cin >> temp[i];

	for (i = 0; i < n; i++)
	{
		if (count < temp[i])
		{
			while (count < temp[i])
			{
				count++;
				sNum.push(count);
				qChar.push('+');
			}
			sNum.pop();
			qChar.push('-');
		}
		else
		{
			if (sNum.empty())
			{
				cout << "NO" << '\n';
				return 0;
			}
			else
			{
				if (sNum.top() < temp[i])
				{
					cout << "NO" << '\n';
					return 0;
				}
				else
				{
					while (!sNum.empty() && sNum.top() >= temp[i])
					{
						sNum.pop();
						qChar.push('-');
					}
				}
			}
		}
	
	}

	while (!qChar.empty())
	{
		cout << qChar.front() << '\n';
		qChar.pop();
	}

  return 0;
}

