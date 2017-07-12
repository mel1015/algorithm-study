#include <iostream>
#include <vector>
using namespace std;

void robot_working(int r, int c, int s, vector<vector<char> > arr)
{
	int step = 1;
	int row = 1;
	int column = s;
	char direction;
	bool flag = true;
	int visited_arr[11][11] = { 0, };

	direction = arr[1][s];
	arr[1][s] = 'V';
	visited_arr[1][s] = step;
	while (flag)
	{
		switch (direction)
		{
		case 'e':
		case 'E':
			if (column == c)
			{
				cout << step << " step(s) to exit" << endl;
				flag = false;
				break;
			}
			else if (visited_arr[row][column + 1] != 0)
			{
				int loop_step;
				loop_step = visited_arr[row][column+1];
				cout << loop_step - 1
					<< " step(s) before a loop of "
					<< step - loop_step + 1
					<< " step(s)" << endl;
				flag = false;
				break;
			}
			++column;
			direction = arr[row][column];
			arr[row][column] = 'V';
			step++;
			visited_arr[row][column] = step;
			break;
		case 'w':
		case 'W':
			if (column == 1)
			{
				cout << step << " step(s) to exit" << endl;
				flag = false;
				break;
			}
			else if (visited_arr[row][column - 1] != 0)
			{
				int loop_step;
				loop_step = visited_arr[row][column-1];
				cout << loop_step - 1
					<< " step(s) before a loop of "
					<< step - loop_step + 1
					<< " step(s)" << endl;
				flag = false;
				break;
			}
			--column;
			direction = arr[row][column];
			arr[row][column] = 'V';
			step++;
			visited_arr[row][column] = step;
			break;
		case 's':
		case 'S':
			if (row == r)
			{
				cout << step << " step(s) to exit" << endl;
				flag = false;
				break;
			}
			else if (visited_arr[row + 1][column] != 0)
			{
				int loop_step;
				loop_step = visited_arr[row + 1][column];
				cout << loop_step - 1
					<< " step(s) before a loop of "
					<< step - loop_step + 1
					<< " step(s)" << endl;
				flag = false;
				break;
			}
			++row;
			direction = arr[row][column];
			arr[row][column] = 'V';
			step++;
			visited_arr[row][column] = step;
			break;
		case 'n':
		case 'N':
			if (row == 1)
			{
				cout << step << " step(s) to exit" << endl;
				flag = false;
				break;
			}
			else if (visited_arr[row - 1][column] != 0)
			{
				int loop_step;
				loop_step = visited_arr[row - 1][column];
				cout << loop_step - 1
					<< " step(s) before a loop of "
					<< step - loop_step + 1
					<< " step(s)" << endl;
				flag = false;
				break;
			}
			--row;
			direction = arr[row][column];
			arr[row][column] = 'V';
			step++;
			visited_arr[row][column] = step;
			break;
		}
	}
}


int main()
{
	int r, c, s;

	cin >> r >> c >> s;

	vector<vector<char> > arr(r + 1, vector<char>(c + 1, 0));

	for (int i = 1; i <= r; i++)
		for (int j = 1; j <= c; j++)
			cin >> arr[i][j];

	robot_working(r, c, s, arr);

	return 0;
}