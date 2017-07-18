#include<iostream>
#include<list>
using namespace std;

int lowest(list<int> &tencard_list);
void check_clocknumber(int number);

int main()
{
	list<int> tencard_list;
	int number;

	for (int i = 0; i < 4; i++)
	{
		cin >> number;
		cin.ignore(1, '\n');
		tencard_list.push_back(number);
	}
	number = lowest(tencard_list);
	check_clocknumber(number);
	
	return 0;
}

int lowest(list<int> &tencard_list)
{
	int result = 10000;
	int temp = 0;
	list<int>::iterator it;

	for (int j = 0; j < 4; j++)
	{
		int mul = 1000;
		for (it = tencard_list.begin(); it != tencard_list.end(); ++it)
		{
			temp += (*it)*mul;
			mul /= 10;
		}
		it = tencard_list.begin();
		tencard_list.push_back((*it));
		tencard_list.pop_front();

		if (temp < result)
		{
			result = temp;
		}
		temp = 0;
	}
	return result;
}

void check_clocknumber(int number)
{
	list<int> check_list;
	int check_arr[10000] = { 0, };
	int k, count = 1;
	int arr[4];

	for (int i = 1111; i < number; i++)
	{
		arr[0] = i / 1000;
		arr[1] = (i % 1000) / 100;
		arr[2] = ((i % 1000) % 100) / 10;
		arr[3] = (i % 10);

		if (arr[0] == 0 || arr[1] == 0 || arr[2] == 0 || arr[3] == 0)
			continue;
		
		check_list.push_back(arr[0]);
		check_list.push_back(arr[1]);
		check_list.push_back(arr[2]);
		check_list.push_back(arr[3]);

		k = lowest(check_list);
		check_list.clear();
		
		if (check_arr[k] == 0)
		{
			check_arr[k]++;
			count++;
		}
	}
	cout << count << endl;
}
