#include <iostream>
#include <cstring>
using namespace std;

class queue
{
private:
	int *Queue;
	int QSize;
	int head, tail;

public:
	void InitQueue(int size)
	{
		QSize = size;
		Queue = (int *)malloc(QSize * sizeof(int));
		head = tail = 0;
	}

	void FreeQueue()
	{
		free(Queue);
	}

	bool Insert(int data)
	{
		if ((tail + 1) % QSize == head)
		{
			return false;
		}
		Queue[tail] = data;
		tail = (tail + 1) % QSize;
		return true;
	}

	int Delete()
	{
		int data;
		if (head == tail)
		{
			return -1;
		}
		data = Queue[head];
		head = (head + 1) % QSize;
		return data;
	}
	void Empty()
	{
		if (head == tail)
			cout << "1" << endl;
		else
			cout << "0" << endl;
	}
	void Front()
	{
		if (head == tail)
			cout << "-1" << endl;
		else
			cout << Queue[head] << endl;
	}
	void Back()
	{
		if (head == tail)
			cout << "-1" << endl;
		else
			cout << Queue[tail-1] << endl;
	}
	void Size()
	{
		if (head <= tail)
			cout << (tail - head) << endl;
		else
			cout << (QSize - head + tail) << endl;
	}
};
int main()
{
	queue qq;
	int size = 0;
	int num;
	char order[10] = { '\0' };
	//cout << "사이즈 입력" << endl;
	cin >> size;
	qq.InitQueue(size);

	for (int i = 0; i < size; i++)
	{
		cin >> order;
		cin.ignore(1, '\n');

		if (strcmp(order, "push") == 0)
		{
			cin >> num;
			qq.Insert(num);
		}
		else if (strcmp(order, "pop") == 0)
		{
			cout << qq.Delete() << endl;
		}
		else if (strcmp(order, "empty") == 0)
		{
			qq.Empty();
		}
		else if (strcmp(order, "front") == 0)
		{
			qq.Front();
		}
		else if (strcmp(order, "back") == 0)
		{
			qq.Back();
		}
		else if (strcmp(order, "size") == 0)
		{
			qq.Size();
		}
		else
			cout << "Error" << endl;
	}
	qq.FreeQueue();
	return 0;
}
