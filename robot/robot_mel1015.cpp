#include <iostream>
#include <vector>
using namespace std;

void robot(int x, int y, vector<vector<char> > arr);

int r, c;

int main()
{
	int s;

	cin >> r >> c >> s;

	vector<vector<char> > arr(r, vector<char>(c, 0));

	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++)
			cin >> arr[i][j];

	robot(0, s-1, arr);

	return 0;
}

void robot(int x, int y, vector<vector<char> > arr)
{
	static int count = 0;
	static int visited[10][10] = { 0 };
	if (x == -1 || y == -1 || x == r || y == c)
	{
		cout << count << " step(s) to exit" << endl;
		return;
	}
	count++;

	if (visited[x][y] != 0)
	{
		cout << visited[x][y] - 1 << " step(s) before a loop of "
			<< count - visited[x][y] << " step(s)" << endl;
		return;
	}
	visited[x][y] = count;

	switch (arr[x][y])
	{
	case 'n':
	case 'N':
		robot(x - 1, y, arr);
		break;
	case 'e':
	case 'E':
		robot(x, y + 1, arr);
		break;
	case 'w':
	case 'W':
		robot(x, y - 1, arr);
		break;
	case 's':
	case 'S':
		robot(x + 1, y, arr);
		break;
	}
}
