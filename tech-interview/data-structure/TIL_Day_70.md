# TIL_Day_70

> 2022년 10월 13일

## 해시 테이블(Hash Table)

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbCxSRM%2Fbtral7blCDy%2F11IMfD8j5xOXjv83VYay20%2Fimg.png)

- 해시 테이블은 (Key, Value)식으로 데이터를 저장하는 자료구조 중 하나로 key를 통해 평균 O(1)에 value를 검색할 수 있는 자료구조이다.
- 해시 테이블은 Key 값을 해시함수(Hash Function)를 사용하여 변환한 값을 색인(index)으로 삼는다.
- 해시 함수(Hash Function)을 사용해 Key 값을 색인(index)으로 변환하는 과정을 해싱(Hashing)이라고 한다.

### 해시 함수(Hash Function)

- 해시 함수의 가장 중요한 점은 **고유한 인덱스**를 만드는 것이다.
- 만약 중복되는 인덱스가 발생한다면 이는 **충돌**(Collision)으로 이어지게 된다.
- 따라서 해시 함수를 구현하는 **해시 알고리즘**을 적절히 구현하는 것이 중요하다.
- 해시 테이블에 사용되는 대표적인 해시 알고리즘에는 다음과 같은 것들이 있다.
  - Division Method
    - 숫자 Key를 테이블의 크기로 나누어 나온 나머지를 인덱스로 사용한다. (index = Key % 테이블 크기) 이떄 테이블의 크기를 소수(Prime Number)로 정하고 2의 제곱수와 먼 값을 사용하는 것이 효과가 좋다. 예를 들어 Key 값이 23일 때 테이블 사이즈가 7이라면 index는 2다.
  - Digit Folding
    - Key의 문자열을 아스키 코드로 바꾸고 그 값을 합해 테이블 내의 주소로 사용하는 방법이다. 위 예시와 비슷한 상황에서 사용될 수 있다. "Ryan" 같은 문자열을 R->82 + y->121 + a->97 + n->110 = 410 을 index로 사용하면 된다. 만약 이 때 index가 테이블의 크기를 넘어간다면 Division Method를 적용할 수 있을 것이다.
  - Multiplication Method
    - 숫자로 된 Key 값 K와 0과 1 사이의 실수 A, 보통 2의 제곱수인 m을 사용하여 다음과 같이 계산한 값을 index로 사용한다. index = (K * A mod 1) * m

#### 충돌(Collision)

- 해시 함수를 통해 index 값을 구했을 때 중복이 생기는 충돌이 발생할 수 있다. 이러한 충돌이 발생했을 때의 해결법으로 분리연결법(Separate Chaining)과 개방 주소법(Open Addressing) 등이 있다.

##### 분리연결법(Seperate Chaining)

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbAtCLn%2FbtraoCclrqF%2FSpaQbUasy89TSWb9nVbfA0%2Fimg.png)

>  분리 연결법이란 동일한 버킷(bucket)의 데이터에 대해 연결리스트, 트리 등의 자료구조를 활용해 다음 데이터의 주소를 저장하는 것이다.

- 위의 그림처럼 예를 들어 "둘리"와 "무지"를 해시 함수로 변경하였더니 11이라는 index로 충돌 되었다면, 먼저 저장한 "둘리"의 다음 원소로 "무지"를 저장하면 된다.
- 이러한 chaining 방식은 해시 테이블의 확장이 필요없고 구현이 간단하며 쉽게 삭제할 수 있다는 장점이 있다.
- 하지만 데이터 수가 많아지면 동일한 버킷에 chaining 되는 데이터가 많아지며 그에 따라 캐시의 효율성이 감소한다는 단점이 있다.

##### 개방 주소법(Open Addressing)

> 개방 주소법이란 추가적인 메모리를 사용하는 chaining 방식과 다르게 비어있는 해시 테이블의 공간을 활용하는 방법이다.

- 개방 주소법을 구현하기 위한 방법으로는 다음과 같은 3가지 방식이 존재한다.
  1. Linear Probing
     - 현재의 버킷 index로부터 고정폭만큼 이동하여 차례대로 검색해 비어 있는 버킷에 데이터를 저장한다.
  2. Quadratic Probing
     - 해시의 저장순서 폭을 제곱으로 저장하는 방식. 예를 들어 처음 충돌이 발생한 경우 1만큼 이동하고, 그 다음 충돌이 발생하면 2^2, 3^2 칸 씩 옮기는 방식이다.
  3. Double Hashing Probing
     - 해시된 값을 한 번 더 해싱하여 해시의 규칙성을 없애버리는 방식. 해시된 값을 한 번 더 해싱하여 새로운 주소를 할당하므로 기존 방식보다 더 많은 연산을 하게 된다.