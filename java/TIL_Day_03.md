# TIL_Day_03

> 2022년 05월 24일

## 변수와 타입

### 변수 (variable)

> 프로그램 실행 중에 1개의 값을 저장하기 위한 메모리 내의 임시 기억 장소 (메모리 공간)

#### 변수의 특징

- 이름이 있다 - **변수명** (메모리 주소에 붙여진 이름)
- 기억장소 내에서의 **주소**가 있다
- 변수에 저장되는 **값**이 있다
- 저장되는 값의 유형(**데이터 타입**)이 있고 **크기**가 다르다
- 프로그램 실행 중에 저장된 **값이 변경**될 수 있다
- **주의점 : 변수는 동일한 이름으로 한 번만 선언**

#### 변수의 선언

- 변수를 사용하기 위해서는 반드시 변수를 선언해야 한다
- 선언하는 이유 : 실행 중에 필요한 공간 할당 받기 위해
- 선언 형식 : 데이터타입 변수명;

#### 변수 초기화

- 변수 선언과 동시에 값 저장
- 주의 : 초기화 되지 않은 변수 사용 시 오류 발생

#### 상수

> 프로그램 실행 중에 값을 저장하기위한 **메모리 내의 임시 기억장소**로 정해진 값을 가지며, **프로그램 실행 중 값이 변하지 않음**

- final 키워드 사용
- 대문자로 선언
- 상수의 용도 : 프로그램 실행 중에 값이 변해서는 안되는 것을 상수로 선언

#### 리터럴 (Literal)

> 변수에 저장되는 값

#### 리터럴의 종류

- 정수 리터럴
- 실수 리터럴
- 문자 리터럴
- 문자열 리터럴
- 논리 리터럴

### 데이터 타입

- 기본 타입 (기본형)
  - 8개 : byte / char / shor / int / long / float / double / boolean
  - 정수, 실수, 문자, 논리 리터럴을 직접 저장하는 타입
- 참조형
  - 기본 타입을 제외한 나머지 (String, 배열 등)
  - 참조값(객체의 주소값) 저장

- 변수는 선언된 타입과 동일한 데이터 타입의 데이터만 저장 가능

- 데이터 타입에 따라 사용하는 메모리 크기가 다름

|           | 1 byte  | 2 byte | 4 byte | 8 byte |
| :-------: | :-----: | :----: | :----: | :----: |
| 논리 타입 | boolean |        |        |        |
| 문자 타입 |         |  char  |        |        |
| 정수 타입 |  byte   | short  |  int   |  long  |
| 실수 타입 |         |        | float  | double |

### 타입 변환

> 데이터 타입을 다른 타입으로 변환하는 것

#### 타입 변환 종류

1. 자동(묵시적) 타입 변환 (Promotion)

   > 프로그램 실행 도중 자동적으로 작은 크기의 타입이 큰 크기의 타입으로 변환이 일어나는 것

2. 강제(명시적) 타입 변환 (Casting)

   > 큰 크기의 타입을 작은 크기의 타입으로 강제로 변환하는 것

   - 주의 : 데이터의 일부 손실, 정밀도 손실 발생. 문자열(String)은 char 타입으로 강제 타입 변환 불가능

#### 연산식에서 자동 타입 변환

- 연산은 같은 타입의 피연산자(operand)간에만 수행
  - ex) int 타입 변수 + int 타입 변수
- 서로 다른 타입의 피연산자 경우 두 연산자 중 크기가 큰 타입으로 자동 변환
- 정수 연산인 경우 int 타입이 기본

## 연산자

> 연산에 사용되는 표시나 기호

### 연산자의 우선순위

- 괄호()의 우선 순위가 제일 높다
- 단항, 이항, 삼항 연산자 순
- 산술, 비교, 논리, 대입 연산자 순
- 대입 연산자는 마지막에 수행

### 단항 연산자

> 피연산자가 1 개인 연산자

- 부호 연산자 : +, -

- 증감 연산자 : ++, --
  - 주의 : 위치에 따라 변수의 값을 사용하고 증가할 것인지, 먼저 증가해서 증가된 값을 사용할 것인지 구분
- 논리 부정 연산자 : !
- 비트 반전 연산자 : ~

### 이항 연산자

> 피연산자가 2 개인 연산자

- 산술 연산자 : +, -, *, /, %
  - 주의 : 결과값 산출할 때 Overflow 주의. NaN과 Infinity 연산은 주의할 것
- 문자열 연결 연산자 : +
- 비교 연산자 : <, <=, >, >=, ==, !=
  - 문자열 비교에는 ==이 아니라 equals() 메소드 사용
- 논리 연산자 : &&, &, ||, |, ^, !
- 비트 논리 연산자 : &, |, ^, ~
- 비트 이동 연산자 : <<, >>, >>>
- 대입 연산자 : =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=

### 삼항 연산자

> 3 개의 피연산자를 필요로 하는 연산자

```java
조건식 ? (참일 때 수행) 값 또는 연산식 : (거짓일 때) 값 또는 연산식
```

- 앞의 조건식 결과에 따라 콜론 앞 뒤의 피연산자 선택 (조건 연산식)