#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int *n;
	int size;
	int req;
	int budget = 0;

	cin >> size;
	n= (int *)malloc(size * sizeof(int));

	for (int i = 0; i < size; i++)
	{
		cin >> req;
		n[i] = req;
	}
	cin >> budget;

	int temp = budget;
	int max = 0;
	
	for (int i = 0; i < size; i++)
	{
		temp -= n[i];
		max = n[i] > max ? n[i] : max;
	}

	if (temp >= 0)
	{
		cout << max << endl;
		return 0;
	}

	int w1 = budget / size, w2 = max;

	while (w1 <= w2)
	{
		int mid = (w1+ w2) / 2;
		temp = budget;

		for (int i = 0; i < size; i++)
		{
			if (mid >= n[i]) temp -= n[i];
			else temp -= mid;
		}

		if (temp >= 0) 
			w1 = mid + 1;
		else 
			w2 = mid - 1;
	}

	cout << w2 << endl;

	return 0;
}
