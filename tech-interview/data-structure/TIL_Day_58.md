# TIL_Day_58

> 2022년 09월 30일

## 자료구조

### 자료구조의 정의

> 자료구조는 컴퓨터 과학에서 효율적인 접근 및 수정을 가능케 하는 자료의 조직, 관리, 저장을 의미한다. 더 정확히 말해, 자료 구조는 데이터 값의 모임, 또 데이터 간의 관계, 그리고 데이터에 적용할 수 있는 함수나 명령을 의미한다. 신중히 선택한 자료구조는 보다 효율적인 알고리즘을 사용할 수 있게 한다. 이러한 자료구조의 선택문제는 대게 추상 자료형의 선택으로부터 시작하는 경우가 많다. 효과적으로 설계된 자료구조는 실행시간 혹은 메모리 용량과 같은 자원을 최소한으로 사용하면서 연산을 수행하도록 해준다.

### 자료구조의 선택 기준

- 자료의 처리시간
- 자료의 크기
- 자료의 활용 빈도
- 자료의 갱신 정도
- 프로그램의 용이성

### 자료구조의 특징

1. 효율성
   - 자료구조를 사용하는 목적은 데이터를 목적에 맞게 효율적으로 관리 및 사용하는 것이다.
   - 적절한 자료구조를 선택하여 사용한다면 코드의 효율이 올라갈 것이다.
2. 추상화
   - 추상화란 복잡한 자료, 모듈, 시스템 등으로부터 핵심적인 개념만을 간추려 내는 것이다.
   - 자료구조를 구현할 때 중요한 것은 어느 시점에 데이터를 삽입할 것이며, 어느 시점에 이러한 데이터를 어떻게 사용할 것인지에 대해 초점을 맞출 수 있기 때문에 구현 외적인 부분에 더 시간을 쏟을 수 있다.
3. 재사용성
   - 다양한 프로그램에서 동작할 수 있도록 범용성 있게 설계되어있다.

### 자료구조의 분류

- 자료의 특성과 크기, 주요 사용법과 수행하는 연산의 종류, 구현에 필요한 기억 공간 크기에 따라 여러 가지 종류의 자료구조 중 하나를 선택할 수 있다.
- 자료구조의 종류로는 자료형의 따라 분류하는 단순 구조와 자료 간 관계가 1 대 1인 선형 구조, 1 대 다 혹은 다 대 다 구조인 비선형 구조, 마지막으로 파일 구조가 있다.

#### 구현에 따라 분류

- 배열
  - 가장 일반적인 구조이다.
  - 메모리 상에 같은 타입의 자료가 연속적으로 저장된다.
  - 자료값을 나타내는 가장 작은 단위가 자료를 다루는 단위이다.
- 튜플
  - 둘 이상의 자료형을 묶음으로 다루는 구조이다.
- 연결 리스트
  - 노드를 단위로 한다.
  - 노드는 자료와 다음 노드를 가리키는 참조값으로 구성되어 있다.
  - 노드가 다음 노드로 아무것도 가리키지 않으면 리스트의 끝이다.
- 원형 연결 리스트
  - 각 노드는 다음 노드를 가리키고, 마지막 노드가 처음 노드를 가리키는 연결 리스트이다.
- 이중 연결 리스트
  - 각 노드는 이전 노드와 다음 노드를 기리키는 참조값으로 구성된다.
  - 처음 노드의 이전 노드와 마지막 노드의 다음 노드는 없다.
- 환형 이중 연결 리스트
  - 처음 노드가 이전 노드로 마지막 노드를 기리키고, 마지막 노드가 다음 노드로 처음 노드를 가리키는 이중 연결 리스트이다.
- 해시 테이블
  - 개체가 해시값에 따라 인덱싱된다.

#### 형태에 따라 분류

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FuGE5R%2FbtrhA3lOp6X%2FUK1vpqPfCfj874lMLygAI0%2Fimg.png)

- 선형 구조
  - 스택
    - 스택 자료구조에 먼저 저장된 것이 꺼내어 쓸 때는 제일 나중에 나온다.
    - 반대로, 가장 최근에 저장된 것이 꺼내어 쓸 때는 제일 먼저 나온다.
    - 만약, 자료들의 나열 순서를 바꾸고 싶다면 스택에 집어 넣었다가 꺼내면 역순으로 바뀐다.
  - 큐
    - 스택과 반대로 큐 자료구조에 먼저 저장된 것이 제일 먼저 나온다.
    - 반대로, 가장 나중에 저장된 것이 꺼내어 쓸 때는 가장 나중에 나온다.
    - 환형 큐
      - 한정된 길이 안에서 부수적인 작업 없이 일고 쓰기를 할 수 있는 큐이다.
  - 덱
    - 양쪽에서 넣기와 빼기를 할 수 있는 일반화된 선형 구조이다.
- 비선형 구조
  - 그래프
    - 꼭짓점과 꼭짓점을 잇는 변으로 구성된다.
    - 유향 그래프, 무향 그래프
      - 변이 방향성을 갖는지 갖지 않는지에 따른 그래프의 분류이다.
      - 무향 그래프의 경우, 순환이 없는 연결 그래프를 뜻한다.
      - 유향 그래프의 경우 변의 방향은 보통 부모를 가리키도록 구현된다.
  - 트리
    - 뿌리와, 뿌리 또는 다른 꼭짓점을 단 하나의 부모로 갖는 꼭짓점들로 이루어진 구조.
    - 부모 자식 관계는 변으로 표현된다.
    - 이진 트리
      - 자식이 최대 두 개인 트리
      - 힙
        - 이진트리의 일종으로 이진트리에 어떤 특성을 부여한 것이라 할 수 있다.