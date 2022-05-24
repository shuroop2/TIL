# TIL_Day_04

> 2022년 05월 11일

## 제어문

> 프로그램 흐름을 제어, 코드 실행 흐름을 개발자가 원하는 방향으로 변경할 수 있도록 도와줌

![제어문](C:\Users\haan0\AppData\Roaming\Typora\typora-user-images\image-20220524214132899.png)

### if 문

> 조건식이 true일 때 { }안의 문장을 반복 수행할 때 사용

```java
if (조건식) {
    조건식의 결과가 true일 때 수행되는 문장;
}
```

### if ~ else 문

```java
if (조건식){
    조건식의 결과가 true일 때 수행되는 문장;
} else {	// 주의 : 여기에 조건식 없음
    false일 때 수행되는 문장
}
```

### 다중 if ~ else 문

```java
if (조건식1) {
    조건식1의 결과가 true일 때에만 수행되는 문장;
} else if (조건식2) {
    조건식1의 결과가 false이면서
    조건식2의 결과가 true일 때 수행되는 문장
} else {
    조건식1, 2 모두 false인 경우에 수행되는 문장
}
```

### 중첩 if 문

```java
if (조건식1) {
    if (조건식2) {
    
    } else {
        
    }
} else {
    
}
```

### switch 문

> 변수 또는 연산식의 값에 따라 실행문 선택할 때 사용

```java
switch (값 또는 수식) { // (score) 또는 (score/10)
    case value1: 처리할 문장 1; break;
    case value2: 처리할 문장 2; break;
    case value3: 처리할 문장 3; break;
        ...
    default : 처리할 문장 n;
}
```

- 주의사항
  - 수식으로 값의 결과나 정수 또는 문자열 또는 문자 값이어야함 (실수 사용 불가)
  - case 뒤의 value 로는 반드시 하나의 값만 사용
  - case 다음에는 콜론(:) 사용
  - break 문이 없는 경우 해당 case에서 실행이 멈추지 않고 다음 case까지 수행됨

### for 문

> 주어진 횟수만큼 실행문을 반복 실행할 때 적합한 반복 제어문

```java
for (초기식; 조건식; 증감식){
    반복 수행되는 문장 (조건식의 결과가 true일 때 수행)
}
```

- 주의
  - 초기값 설정 시 사용하는 변수 i
    - for문 안에서 선언했으면 for문 안에서만 사용 가능. for문 {} 밖에서는 사용 불가
  - sum 변수 사용 시 반드시 값을 0으로 초기화하고 사용

### 중첩 for 문

```java
for (초기식1; 조건식1; 증감식1) {
    for (초기식2; 조건식2; 증감식2;){
        반복 수행되는 문장 (조건식1, 2의 결과가 true일 때 수행)
    }
}
```

### for 무한 루프

```java
for(;;)	// 무한반복
```

- 주의
  - 반복문을 종료할 수 있는 값 필요
  - for 문 전에 반복문을 종료시키기 위한 변수 필요
  - for 문 안에서 종료되기 위한 조건 필요

### while 문

> 조건식에 따라 반복을 계속할지 결정할 때 사용

- 조건식이 true일 경우 계속해서 반복

```java
(초기값)
while (조건식) {
    (조건식의 결과가 true일 때 반복 수행되는 문장)
    (증감)
}
```

- 주의
  1. 초기값이 없으면 조건을 알 수 없고
  2. 증감식 없으면 반복문을 빠져 나올 수 없어서 무한 반복

### while 무한 루프

```java
(초기값)
while (true) {
    
}
```

- 조건이 무조건 true
- 초기값
- 종료 조건
- 종료되기 위한 증감

### do ~ while 문

```java
do {
    (조건식의 결과가 true일 때 반복 수행되는 문장)
} while (조건식) ;
```

- 조건에 따라 반복을 계속할지 결정할 때 사용하는 것은 while 문과 동일
- 먼저 무조건 중괄호 { } 블록을 한 번 실행 한 후, 조건을 검사해서 반복 결정
- 최소 한 번은 수행됨

### 기타 제어문 (break / continue)

#### break 문

- 반복문 하나를 빠져 나갈 때 사용
- for 문, while 문, do ~ while 문 종료 (반복 취소)
- switch 문 종료 시 사용
- 주로 if 문과 같이 사용
- 주의
  - 반복문이 중첩되어 있는 경우 자신이 속한 가장 가까운 하나의 반복문만 벗어남
  - 바깥쪽 반복문까지 종료시키려면 반복문에 이름(라벨)을 붙이고 "break 이름;" 사용

#### continue 문

- 수행 중인 문장은 중단하고, 다음 반복 계속 수행
- 반복문은 종료하지 않고 계속 반복 수행
