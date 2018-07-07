> 문제를 풀면서 알게된 팁 공유

## To-Do List
- [SW Expert Academy](https://www.swexpertacademy.com/main/main.do)
    - 10주차 : [Part3](https://www.swexpertacademy.com/main/talk/solvingClub/problemBoxDetail.do?solveclubId=AV6kld8aisgDFASb&probBoxId=AV-HZfeqN3ADFASP&leftPage=1) 
    
## Tip
- 신광식
    - [1954. 달팽이배열](https://github.com/mel1015/algorithm-study/blob/1954/algorithm-study/week_10/1954_mel1015.cpp)
        - 배열을 채워 나가는 횟수와 방향 변경이 규칙적
    - [1213. String](https://github.com/mel1015/algorithm-study/blob/1213/algorithm-study/week_10/1213_mel1015.cpp)
        - [string::find](http://www.cplusplus.com/reference/string/string/find/)함수 사용
    - [1209. Sum](https://github.com/mel1015/algorithm-study/blob/1209/algorithm-study/week_10/1209_mel1015.cpp)
        - [max_element](https://en.cppreference.com/w/cpp/algorithm/max_element)사용
    - [1208. Flatten](https://github.com/mel1015/algorithm-study/blob/1208/algorithm-study/week_10/1208_mel1015.cpp)
        - [iterator 개념](http://hyeonstorage.tistory.com/318)
        - iterator와 max_element로 벡터내의 최댓값 구하는법  
        ```
        #include <algorithm>    // max_element 사용
        vector<int>::iterator maxValue; // iterator 선언
        maxValue = max_element(vec.begin(), vec.end()); // iterator가 최댓값을 가리킴
        ```
    - [1206. View](https://github.com/mel1015/algorithm-study/blob/1206/algorithm-study/week_10/1206_mel1015.cpp)
        - 메모리 사용량이 많다. 메모리랑 실행시간도 생각하면서 풀자.
    - [1204. 최빈수 구하기](https://github.com/mel1015/algorithm-study/blob/1204/algorithm-study/week_10/1204_mel1015.cpp)
        - max_element와 distance 사용해서 풀면 최빈수가 여러개일 경우에 틀림
        - max_element는 최댓값이 여러 개 있을 시, 첫번째 요소의 위치를 반환함
        
## Progress
- 신광식 : 1954, 1213, 1209, 1208, 1206, 1204