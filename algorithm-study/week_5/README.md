> 문제를 풀면서 알게된 팁 공유

## To-Do List
- 알고리즘 문제집 [기본 알고리즘 이해](https://www.acmicpc.net/workbook/view/1443)
    - 5주차 : [힙 정렬](https://www.acmicpc.net/problem/2220) / 
    [소트인사이드](https://www.acmicpc.net/problem/1427) / 
    [바이러스](https://www.acmicpc.net/problem/2606) / 
    [플로이드](https://www.acmicpc.net/problem/11404)

## Tip
- 신광식
    - [2220번](https://github.com/mel1015/algorithm-study/blob/2220/Winter_Vacation/week_5/2220_mel1015.cpp)
        - [힙 정렬](https://ratsgo.github.io/data%20structure&algorithm/2017/09/27/heapsort/) 참고
        - 삭제 연산 후 힙 구성 과정을 직접 해보면 규칙이 나온다
    - [1427번](https://github.com/mel1015/algorithm-study/blob/1427/Winter_Vacation/week_5/1427_mel1015.cpp)
        - 주어지는 수의 길이가 길어서 string으로 입력 받고 정렬했다
        - string은 자동으로 배열 형식으로 문자를 입력 받고, 마지막 요소는 널 문자(\0)이므로<br>
        for문의 i의 초기값은 `n.size() - 1` 이다.
    - [2606번](https://github.com/mel1015/algorithm-study/blob/2606/Winter_Vacation/week_5/2606_mel1015.cpp)
        - [너비 우선 탐색](https://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/) 참고
    - [11404](https://github.com/mel1015/algorithm-study/blob/11404/Winter_Vacation/week_5/11404_mel1015.cpp)
        - [플로이드-워셜 알고리즘](https://ko.wikipedia.org/wiki/%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%9B%8C%EC%85%9C_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98) 참고        
## Progress
- 신광식 : 2220, 1427, 2606, 11404