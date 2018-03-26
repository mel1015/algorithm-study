#include <iostream>
#include <stdlib.h>
#include <cstring>
using namespace std;

int top = -1;
typedef int element;
element* stack = nullptr;


void empty()
{
	if (top == -1)
		cout << "1" << endl;
	else
		cout << "0" << endl;
}

void push(element item)
{
	
	//cin >> item;
	
	stack[++top] = item;

}

element pop()
{
	if (top == -1)
		cout << "-1" << endl;
	else
	{
		cout << stack[top] << endl;
		return stack[top--];
	}
}

void peek()
{
	if (top == -1)
		cout << "-1" << endl;
	else
		cout << stack[top] << endl;
}	

void size()
{
	cout << top+1<< endl;
}


int main()
{
	int ssize;
	char order[10] = { '\0' };
	//cout << "사이즈 입력" << endl;
	cin >> ssize;
	stack = (int*)malloc(sizeof(int)*ssize);
	getchar();
	
	int num;

	for (int i = 0; i < ssize; i++)
	{
		//cout << "명령 입력" << endl;
		cin >> order;
		cin.ignore(1, '\n');


		if (strcmp(order, "push") == 0)
		{
			//cout << "푸시 실행" << endl;
			cin >> num;
			push(num);
		}
		else if (strcmp(order, "pop") == 0)
			pop();
		else if (strcmp(order, "top") == 0)
			peek();
		else if (strcmp(order, "empty") == 0)
			empty();
		else if (strcmp(order, "size") == 0)
			size();
		else
			cout << "다시 입력해 주세요" << endl;
	}

	
	delete [] stack;
}
