#include <iostream>
#include <algorithm>
#define MAX 10000
#define ff long long
using namespace std;

int data_[MAX];
int hLan, rLan;
int res;


int Search(int k, ff left, ff right)
{
	int idf = 0;
	if (left > right)
		return -1;

	ff mid = (left + right) / 2;

	for (int i = 0; i < hLan; i++)
		idf += data_[i] / mid;

	if (idf >= k)
	{
		res = mid > res ? mid : res;
		return Search(k, mid + 1, right);
	}
	else if (idf < k)
		return Search(k, left, mid - 1);

}

int main()
{
	cin >> hLan >> rLan;
	
	for (int i = 0; i < hLan; i++)
		cin >> data_[i];
	
	Search(rLan, 1, 0x7fffffff);

	cout << res << endl;

	return 0;
}