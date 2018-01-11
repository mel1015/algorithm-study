#include <iostream>
#include <algorithm>
#include <cstring>
#include <stdio.h>

#define MAX 1000000
using namespace std;

int idx;
char st[MAX];
char bomb[40];
char str[MAX];


int main()
{
	int size;

	cin >> st;
	cin >> bomb;

	size = strlen(bomb);

	for (int i = 0; st[i]; i++)
	{
		str[idx++] = st[i];
		if (i >= size - 1 && st[i] == bomb[size - 1])
		{
			bool chk = false;
			for(int k = size -1, j = idx -1; k>=0; k--, j--)	
				if (bomb[k] != str[j])
				{
					chk = true;
					break;
				}
			if (!chk)
				idx -= size;
		}
	}

	if (idx != 0)
	{
		for (int i = 0; i < idx; i++)
			cout << str[i];
	}
	else
		cout << "FRULA" << '\n';

	return 0;


}