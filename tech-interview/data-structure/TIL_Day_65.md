# TIL_Day_65

> 2022년 10월 8일

## 우선순위 큐(Priority Queue)

> Queue는 먼저 넣은 데이터가 먼저 나오는 FIFO(First In First Out)의 특징을 가진 선형 자료구조이다. 우선순위 큐(Priority Queue) 또한 큐와 비슷하지만 다른 점은 **들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 자료구조**이다.

### 우선순위 큐 구현 방법

1. 배열
2. 연결 리스트
3. 힙(Heap)

#### 시간 복잡도

|  구현방법   | 삽입    | 삭제    |
| :---------: | ------- | ------- |
|    배열     | 0(1)    | 0(N)    |
| 연결 리스트 | 0(1)    | 0(N)    |
|     힙      | 0(logN) | 0(logN) |

- 배열이나 연결 리스트로 우선순위 큐를 구현 시 쉽게 구현이 가능하다.
- 하지만 배열과 연결 리스트는 데이터 삽입, 삭제 과정에서 데이터들을 한 칸 밀거나 당겨야 하는 연산이 필요하고 또한 삽입 위치를 찾기 위해 모든 데이터와 비교가 필요하다는 단점이 있다.
- 그렇기 때문에 우선순위 큐는 일반적으로 힙(Heap)을 이용해서 구현한다.

#### 힙(Heap)

> 완전 이진트리 형태의 자료구조이다. 최댓값 혹은 최솟값을 빠르게 찾아내기에 유리한 자료구조이다. 느슨한 정렬 상태이지만 루트 노드는 최대 힙이냐 최소 힙이냐에 따라 최댓값 혹은 최솟값을 가지고 있다.

##### 최대 힙(Max Heap) 예제

- 핵심 내용
  1. 부모 노드는 항상 자식 노드보다 큰 값을 가진다.
  2. 자식 노드들의 정렬 상태는 중요하지 않으며, **루트 노드의 값은 가장 큰 값**이다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F3XKc0%2Fbtrp6IaJrNc%2FzDz7zJreFsaLKntk7w7tkK%2Fimg.png)

- 위의 상황에서 18을 삽입한다고 가정했을시에, **새로운 데이터는 우선순위가 가장 낮다는 가정하에 마지막 위치에 저장**한다. (여기서 마지막 위치는 완전 이진트리가 유지되는 마지막 레벨의 가장 오른쪽 위치)

###### 삽입

![18 삽입](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbNcok8%2FbtrqnkSVYw8%2FeTfMotLz6CFWc5kITFwWGk%2Fimg.png)

- 18을 트리의 마지막 레벨 가장 오른쪽에 삽입

![7과 18 교체](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbP6n7k%2Fbtrp8p93R1g%2FTTHbOK61DEsHx2fgwTpoek%2Fimg.png)

- 자식 노드인 18이 부모 노드인 7보다 크므로 자리 교체

![9와 18 교체](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbXpHZz%2Fbtrp95csXFX%2FdelZaZaitjUo8UwcZxosp0%2Fimg.png)

- 자식 노드인 18이 부모 노드인 9보다 크므로 자리 교체
- 그리고 18인 부모 노드인 22보다 작으므로 삽입 연산을 종료

###### 삭제

![루트노드 삭제](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FetZH2n%2FbtrqnkFqYw9%2FGMzICENwdeScQzUMKgKwck%2Fimg.png)

- 루트 노드의 우선순위가 가장 높으므로 루트 노드 삭제

![마지막 노드를 루트노드로 이동](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcYnose%2FbtrqdTJnoPZ%2FXTPvN0dhHWf7Rwrg4x32v1%2Fimg.png)

- 루트 노드의 자리가 비어있으므로 마지막 노드를 루트 노드로 옮김(**루트 노드 삭제후엔 마지막 레벨의 가장 오른쪽 데이터를 루트 노드로 옮김**)

![자식 노드들 중 우선순위가 높은 노드와 위치 교체](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FJW6MI%2FbtrqgbiGGvW%2FXvtkRQ5hgh7L9qkiDwd4y0%2Fimg.png)

- 자식 노드들 중 우선순위가 높은 노드와 위치 교체
- 18과 13중 18이 우선순위가 높으므로 7과 18을 교체

![9와 7 교체](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcGNPQS%2FbtrqaIARWI2%2FvRrWQo8kM9AV2nlfkoF7J1%2Fimg.png)

- 9가 7보다 우선순위가 높으므로 둘의 자리 교체
- 그리고 7은 자식 노드보다 큰 값이므로 삭제 연산 종료