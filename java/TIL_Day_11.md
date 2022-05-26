# TIL_Day_11

> 2022년 05월 26일

## 기본 API 클래스

### 자바 API 도큐먼트

- 자바 API

  > 자바에서 기본적으로 제공하는 라이브러리
  >
  > 프로그램 개발에 자주 사용되는 클래스 및 인터페이스 모음

- API 도큐먼트

  > 쉽게 API를 찾아 이용할 수 있도록 문서화한 것

  - HTML 페이지로 작성되어 있어 웹 브라우저로 바로 볼 수 있음

### java.long과 java.util 패키지

#### java.lang 패키지

> 자바 프로그램의 기본적인 클래스를 담은 패키지

- 포함된 클래스와 인터페이스는 import없이 사용
  - Object, System, Math ...

<img src="https://lh4.googleusercontent.com/l-xg4LagNvtf9JtXsxGbE1lg74NPi98vQ-Vc3MhmZdeghmPYCY-qB-rqXR-BvtZWGoP_nr26p3bSuej9Y3t8WJi9fDkWNCaYqNyZaUN-mArN42Y0oG7YBmQiboqYPCESj4ezXNA" alt="img" style="zoom:50%;" />

### Object 클래스

> 자바의 최상위 부모 클래스

- 다른 클래스를 상속하지 않으면 java.lang.Object 클래스 상속 암시
- Object의 메소드는 모든 클래스에서 사용 가능

<img src="https://lh5.googleusercontent.com/XzNH-qfVL3duuHU5SdR5RgZS-o7rZAhTXriZedo-wCupa_D6SMTD9mzJbDgPy6nLuVXhMv_0fFQvphac3GN9z3a7x_qTIz5eFjbaZ2e8Ro4-fi6bNNhXNbrJdJMjzkkUozFumi0" alt="img" style="zoom:50%;" />

#### Object 클래스의 메소드

- Object클래스는 필드는 없고 메소드들로 구성
- 모든 클래스가 Object 클래스를 상속하기 때문에 Object 클래스의 메소드는 모든 클래스에서 사용
- equals(), hashCode(), toString(), clone(), finalize() ...

#### 객체 비교 (equals())

- 기본적으로 == 연산자와 동일한 결과 리턴

<img src="https://lh4.googleusercontent.com/9IXZ1JNeHSm5-6Gjwccvrj5ml_dC_iLtTulb91uMSnmLs2RZUJCcdralXSlnnOfILk4qJpVTaaucErcykJ0rzt2ihtoQF4LF_jGqyaw-7sPee_DUtFhIeDOYyKAp3osNoikTOCI" alt="img" style="zoom:50%;" />

#### 객체 해시코드 (hashCode())

> 객체를 식별할 하나의 정수값

- Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해 해시코드를 만들어서 리턴
  - 개별 객체는 해시코드가 모두 다름

#### 객체 문자 정보 (toString())

> 객체를 문자열로 표현한 값

```java
Object obj = new Object();
System.out.println(obj.toString());
```

```java
java.lang.Object@de6ced
```

- Object 클래스의 toString() 메소드는 객체의 문자 정보 리턴
  - 자바에서는 별 값어치 없는 정보
  - Object 하위 클래스에서 메소드 재정의해서 사용
    - String 클래스 : 문자열 리턴
    - Date 클래스 : 현재 시스템의 날짜와 시간 정보 리턴

#### 객체 복제 (clone())

> 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것

- 객체 복제 이유

  - 원본 객체를 안전하게 보호가 위해
  - 신뢰하지 않은 영역으로 원본 객체를 넘겨야할 경우 원본 객체의 데이터가 훼손될 수 있기 때문에 복제된 객체를 만들어서 넘김
  - 복제된 객체의 데이터가 훼손되더라도 원본 객체는 아무런 영향을 받지 않기 때문

- 객체 복제 방법

  1. 얕은 복제 (thin clone)

     > 단순히 필드 값만 복제해서 객체를 복제하는 방법

     - 기본 타입 : 값 복사

     - 참조 타입 : 객체의 번지 복사 (같은 객체 참조)

     - Object 클래스의 clone() 메소드

       - 자신과 동일한 필드값을 가진 얕은 복제된 객체 리턴

       - clone() 메소드로 객체를 복제하려면 원본 객체는 반드시 java.lang.Cloneable 인터페이스를 구현하고 있어야 하는데 (클래스 설계자가 복제를 허용한다는 의미) Cloneable 인터페이스를 구현하지 않으면 clone() 호출 시 CloneNotSupportedException 예외 발생되어 복제가 실패

       - clone() 메소드는 호출 시 예외 처리 필요

         - try ~ catch 구문 사용

           ```java
           try {
               Object obj = clone();
           } catch (CloneNotSupportedException e) { }

  2. 깊은 복제 (deep clone)

     > 참조하고 있는 객체도 복제하는 방법

     - 얕은 복제에서 참조 타입의 경우 객체의 번지 복사 (같은 객체 참조)
       - 복제 객체를 변경하면 원본 객체도 변경됨 (얕은 복제의 단점)
     - Object의 clone() 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 생성해야 함

#### 객체 소멸자 (finalize())

- 참조하지 않는 배열이나 객체는 쓰레기 수집기(Garbage Collector : GC)가 자동으로 힙영역에서 소멸시킴
- GC는 객체를 소멸하기 전에 객체 소멸자(finalize()) 실행
- Object의 finalize()는 기본적으로 실행 내용이 없음
- 객체 소멸되기 전에 실행코드가 있다면
  - Object의 finalize() 재정의

#### Throwable 클래스

> java 언어의 모든 에러와 예외의 수퍼 클래스

<img src="https://lh4.googleusercontent.com/y6hq2a1t4mi0IXjaRKmtEqYnjyQgNvfQS7C3mIaGZttOs_YuxwPOiZ1YinIDQuX-E8MjkLCZ067BV1L_l7wZzEwAPzYtJRMMhSwn6W2VyVwbWGFlPa72eFQ0uvBn7fhQKmQTnY0" alt="img" style="zoom: 33%;" />

#### System.gc()

> Garbage Collector 호출

- Garbage Collector를 호출하여 JVM에게 요청하면 바로 Garbace Collector가 실행되는 것은 아님
- Garbage Collector는 메모리가 부족하거나 CPU가 한가할 때 JVM에 의해서 자동 실행
- 따라서 finalize()가 언제 호출될지는 확실히 알 수 없음
- 주의
  - 될 수 있으면 소멸자는 사용하지 않음
    - Garbage Collector는 메모리의 모든 쓰레기, 객체를 소멸하지 않음
    - Garbage Collector의 구동 시점이 일정하지 않음

#### Objects 클래스

> 객체 비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성된 Object의 유틸리티 클래스

<img src="https://lh4.googleusercontent.com/bLFYmkHA3Ut6PDbKGQHoG1RbuFLce3f6R6PBNJVsuk4eHFcgVBYkpp-yh6UkgkO-L6FA2rkDpAxKMzfbyFmAhqO8BBOrxI5-v3kpgAkKj5T3rAR2J4-93Dh49uPTMh0ZfHIGTE8" alt="Object 클래스가 가지고 있는 정적 메소스" style="zoom:50%;" />

### System 클래스

#### System 클래스 용도

- 운영체제의 기능 일부 이용 가능
  - 프로그램 종료, 키보드로부터 입력, 모니터 출력, 메모리 정리, 현재 시간 읽기 등
  - 시스템 프로퍼티 읽기, 환경 변수 읽기 등

#### exit() 메소드

> 현재 실행하고 있는 프로세스 강제 종료시키는 역할

```java
System.exit(0)
```

- 강제적으로 JVM 종료
- int 매개값 지정 - 종료 상태 값
- exit(0) / exit(1)
- 정상종료 : 0
- 비정상 종료 : 0 이외의 값
- 어떤 값 주더라도 종료