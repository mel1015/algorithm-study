> 문제를 풀면서 알게된 팁 공유

## To-Do List
- 알고리즘 문제집 [자료구조](https://www.acmicpc.net/workbook/view/1442)
    - 3주차 : [트리](https://www.acmicpc.net/problem/1068) / 
    [트리 순회](https://www.acmicpc.net/problem/1991) / 
    [고스택](https://www.acmicpc.net/problem/3425) / 
    [스택 수열](https://www.acmicpc.net/problem/1874)

## Tip
- 신광식
    - [1068번](https://github.com/mel1015/algorithm-study/blob/1068/Winter_Vacation/week_3/1068_mel1015.cpp)
        - [깊이 우선 탐색](http://blog.eairship.kr/268)을 이용해 시작 노드에서 리프까지 내려가서 리프의 총 개수를
        확인 하고, leaf 배열에 자신에게 연결 된 총 리프 수를 저장한다.
    - [1991번](https://github.com/mel1015/algorithm-study/blob/1991/Winter_Vacation/week_3/1991_mel1015.cpp)
        - 클래스를 활용하여 노드와 트리를 구현함.
        - 객체 배열 동적 할당은 `클래스명 *배열명 = new 클래스명[크기];` 이다.<br>
        ex) `Node *node_arr = new Node[10]`;
        - 동적 할당을 했으면 반드시 반환을 해주어야 한다. `delete[] 배열명;`

## Progress
- 최현석 : 1874
- 신광식 : 1068, 1991

