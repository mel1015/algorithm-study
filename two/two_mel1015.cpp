#include<iostream>
using namespace std;

int two[100000] = { 1 };

int main()
{
	int i, f, last = 1;
	int mok, n;

	cin >> n;

	for (f = 1; f <= n; f++)
	{
		mok = 0;
		for (i = 0; i < last; i++)
		{
			two[i] = two[i] * 2 + mok;
			mok = two[i] / 10;
			two[i] = two[i] % 10;
		}
		for (; mok != 0; last++)
		{
			two[last] = mok % 10;
			mok /= 10;
		}
	}

	for (i = last - 1; i >= 0; i--)
		cout << two[i];
	cout << endl;

	return 0;
}