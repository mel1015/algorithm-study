//
// Created by sks10 on 2018-01-11.
//
#include <iostream>

using namespace std;

class Node {
private:
    char Data; // 데이터 필드
    Node *Left; // 왼쪽 자식 노드를 가리키는 포인터
    Node *Right; // 오른쪽 자식 노드를 가리키는 포인터
public:
    // 생성자 : 데이터 초기화
    Node() {
        Data = '\0';
        Left = nullptr;
        Right = nullptr;
    }

    // 해당 노드의 Data 입력
    void setData(char data) {
        this->Data = data;
    }

    // 왼쪽 자식 노드를 지정함
    void setLeft(Node *Left) {
        this->Left = Left;
    }

    // 오른쪽 자식 노드를 지정함
    void setRight(Node *Right) {
        this->Right = Right;
    }

    // 데이터를 반환함
    char getData() {
        return Data;
    }

    // 왼쪽 자식 노드의 주소값을 반환함
    Node *getLeft() {
        return Left;
    }

    // 오른쪽 자식 노드의 주소값을 반환함
    Node *getRight() {
        return Right;
    }
};

class Tree {
private:
    Node *root; // 루트 노드를 가리키는 포인터
public:
    // 디폴트 생성자, 루트 노드를 가리키는 포인터 초기화
    Tree() {
        root = nullptr;
    }

    // 생성자, 노드의 주소값을 넘겨받고 그 주소값으로 root를 초기화
    Tree(Node *root) {
        this->root = root;
    }

    // 새로운 루트 노드를 지정함
    void newRoot(Node *root) {
        this->root = root;
    }

    void PreorderPrint(Node *Leaf) {
        if (Leaf == nullptr) return; // 넘겨받은 Leaf의 주소값이 NULL이면 return
        cout << Leaf->getData(); // 넘겨받은 Leaf의 데이터를 출력한다, 루트 노드
        PreorderPrint(Leaf->getLeft()); // 재귀 호출, 넘겨받은 노드의 왼쪽 자식 노드의 주소값을 넘긴다, 왼쪽 하위 트리
        PreorderPrint(Leaf->getRight()); // 재귀 호출, 넘겨받은 노드의 오른쪽 자식 노드의 주소값을 넘긴다, 오른쪽 하위 트리
    }

    void InorderPrint(Node *Leaf) {
        if (Leaf == nullptr) return; // 넘겨받은 Leaf의 주소값이 NULL이면 return
        InorderPrint(Leaf->getLeft()); // 재귀 호출, 넘겨받은 노드의 왼쪽 자식 노드의 주소값을 넘긴다, 왼쪽 하위 트리
        cout << Leaf->getData(); // 넘겨받은 Leaf의 데이터를 출력한다, 루트 노드
        InorderPrint(Leaf->getRight()); // 재귀 호출, 넘겨받은 노드의 오른쪽 자식 노드의 주소값을 넘긴다, 오른쪽 하위 트리
    }

    void PostorderPrint(Node *Leaf) {
        if (Leaf == nullptr) return; // 넘겨받은 Leaf의 주소값이 NULL이면 return
        PostorderPrint(Leaf->getLeft()); // 재귀 호출, 넘겨받은 노드의 왼쪽 자식 노드의 주소값을 넘긴다, 왼쪽 하위 트리
        PostorderPrint(Leaf->getRight()); // 재귀 호출, 넘겨받은 노드의 오른쪽 자식 노드의 주소값을 넘긴다, 오른쪽 하위 트리
        cout << Leaf->getData(); // 넘겨받은 Leaf의 데이터를 출력한다, 루트 노드
    }
};

int main() {
    int n;
    cin >> n;

    // 객체 배열 동적 할당
    Node *node = new Node[n];

    // 노드의 이름은 A부터 차례대로 영문자 대문자이므로
    char data = 65;
    for (int i = 0; i < n; ++i) {
        //
        node[i].setData(data++);
    }

    // 트리의 루트 노드 지정
    Tree tree(&node[0]);

    char root, left, right;
    for (int i = 0; i < n; ++i) {
        // 부모 노드, 왼쪽 자식 노드, 오른쪽 자식 노드
        cin >> root >> left >> right;

        // 부모 노드 지정
        Node *parent;
        for (int k = 0; k < n; ++k) {
            if (root == node[k].getData()) {
                parent = &node[k];
                break;
            }
        }

        // 왼쪽 자식 노드 지정
        if (left == '.') {
            parent->setLeft(nullptr);
        } else {
            Node *target;
            for (int j = i; j < n; ++j) {
                if (left == node[j].getData()) {
                    target = &node[j];
                    break;
                }
            }
            parent->setLeft(target);
        }

        // 오른쪽 자식 노드 지정
        if (right == '.') {
            parent->setRight(nullptr);
        } else {
            Node *target;
            for (int j = i; j < n; ++j) {
                if (right == node[j].getData()) {
                    target = &node[j];
                    break;
                }
            }
            parent->setRight(target);
        }
    }

    tree.PreorderPrint(&node[0]); // 전위 순회
    cout << endl;
    tree.InorderPrint(&node[0]); // 중위 순회
    cout << endl;
    tree.PostorderPrint(&node[0]); // 후위 순회

    // 객체 배열 반환
    delete[] node;
}

