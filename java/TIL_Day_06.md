# TIL_DAY_06

> 2022년 05월 25일

## 클래스

### 객체 지향 프로그래밍

> OOP : Object Oriented Programming

- 존재하는 모든 것을 객체로 표현
- 객체를 중심으로 생각

### 객체(Object)란?

> 물리적으로 존재하거나 추상적으로 생각할 수 있는 것 중에서 자신의 속성을 가지고 있고 다른 것과 식별 가능한 것

- 객체는 필드와 메소드로 구성된 자바 객체로 모델링 가능
- 객체를 생성하기 위해서는 클래스를 설계한 후 객체를 통해 필드와 메소드에 접근하여 작업 수행

### 객체 지향 프로그래밍의 특징

1. 캡슐화

   > 객체의 필드, 메소드를 하나로 묶고, 실제 구현 내용을 감추는 것

   - 필드와 메소드를 캡슐화하여 보호하는 이유는 외부의 잘못된 사용으로 인해 객체가 손상되지 않도록 (데이터 은닉)

2. 상속

   > 상위(부모) 객체의 필드와 메소드를 하위(자식) 객체에게 물려주는 행위

   - 하위 객체는 상위 객체를 확장해서 추가적인 필드와 메소드를 가질 수 있음
   - 상속의 효과
     - 코드 경제성 : 객체 재사용

3. 다형성

   > 같은 타입이지만 실행 결과가 다양한 객체를 대입할 수 있는 개념

   - 부모 타입에는 모든 자식 객체 대입 가능
   - 인터페이스 타입에는 모든 구현 객체 대입 가능
   - 효과
     - 객체를 부품화시키는 것 가능
     - 유지보수 용이

### 객체와 클래스

- 클래스

  > 제품 설계도 (객체를 만들어내는 툴)

  ```java
  접근제어자 class 클래스이름 {
      멤버 필드;
      생성자()
      멤버 메소드()
  }
  ```

  - 사용자가 임의로 정의

  - 클래스에는 객체를 생성하기 위해 필드와 메소드 정의

  - 클래스의 구성 멤버

    1. 필드

       > 객체의 고유 데이터, 부품 객체, 상태 정보를 저장하는 곳

       - 생성자와 메소드 전체에서 사용되며 객체가 소멸되지 않는 한 객체와 함께 존재

    2. 생성자

       > 객체가 생성되는 순간에 자동으로 호출되는 메소드

       - 객체가 생성될 때 초기화를 위해 사용

       - 클래스 이름으로 되어 있고 리턴 타입이 없다

       - 생성자가 없다면 객체를 초기화하는 메소드를 만들고 초기화를 위해 반드시 호출해야 함

       - 생성자 특징

         - 클래스 이름과 동일
         - 반환값 / 반환형 없음
         - new 연산자를 통해 객체를 생성할 때만 단 한 번 자동으로 호출
         - 오버로딩 가능 - 여러 개의 생성자(매개변수 다르게)
         - 생성자 오버로딩
           - 하나의 클래스에 생성자를 여러 개 기술하면 객체 생성 시 매개변수의 개수, 데이터 타입, 순서가 일치하는 생성자를 알아서 호출

       - 생성자 유형

         - 디폴트 생성자 (default constructor)

           > 매개변수 없고 실행 내용도 없이 자동 생성되는 생성자

         - 매개변수가 있는 생성자

           > 객체 생성 시 값을 자동으로 전달하는 생성자

           - 주의 : 객체 생성 시 반드시 값을 전달해야 함

    3. 메소드

       > 객체의 동작(기능, 업무처리)

       ```java
       접근제어자 반환형 메소드명(매개 변수 목록){
           처리 작업
           return 문; // 반환값이 있는 경우
       }
       ```

       - 클래스 내에서 작업을 처리하는 단위
       - 특정 기능을 수행하고 결과를 반환하는 독립적인 코드 집합
       - 여러 개의 메소드로 나누어서 작업 시 프로그램 재사용(경제성)의 이점이 있다

- 인스턴스

  > 클래스로부터 만들어진 객체를 해당 클래스의 인스턴스라고 함

  - 하나의 클래스로부터 여러 개의 인스턴스 만들 수 있음

- 접근 제어자

  > 클래스 외부에서 메소드에 접근, 사용을 허용할지 제한할지를 정하기 위해 사용

  - public : 완전 허용
  - protected : 일부 허용 (상속 받은 클래스만 허용)
  - private : 완전 접근 금지

- 반환형 (return 문)

  - 메소드가 실행 후 결과값을 반환할 때 사용
  - 반환값이 없는 경우 : void
    - 이 경우에는 메소드 안에 return 문 없음
  - 반환되는 값의 유형과 일치하게 반환형 사용

- this 레퍼런스

  > 클래스 내에서 객체 자신을 가리키는 레퍼런스

  - 컴파일러에 의해 자동 생성
  - 매개변수 이름과 멤버 필드명을 구별하기 위해서 사용

- this() 메소드

  - 한 생성자 안에서 다른 생성자를 호출할 때 사용
  - 생성자 안에서만 사용 가능
  - 주의 : this() 메소드는 생성자 내에서 첫 번째 줄에 기술해야함

### 인스턴스 멤버와 정적(static) 멤버

#### 인스턴스 멤버

> 객체를 생성한 후 사용할 수 있는 필드와 메소드

- 객체를 통해서 접근
- 객체가 생성될 때 각 객체 내부에 하나씩 생성
- 객체마다 자신의 고유 멤버 공간을 가짐
- 다른 객체들과 공유하지 않음

#### static 멤버

> 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드

```java
static int staticVar; // static 필드
static void staticMethod() {} // static 메소드
```

- 클래스에 소속된 멤버 (클래스 당 하나만 생성)
  - 객체를 생성하지 않고 클래스로 바로 접근해서 사용
- 클래스 내의 모든 객체들이 공유

- 클래스 이름과 함께 도트(.) 연산으로 접근

  ```java
  클래스명.static 필드
  클래스명.static 메소드(...)
  ```

- static의 활용
  1. 객체들 간의 공유 멤버로 활용
  2. 전역 변수와 전역 함수 만들 때 사용
- static 메소드 제약
  - static 메소드는 static 멤버만 접근 가능

#### static 초기화 블록

> 클래스가 메소드 영역(static 영역)으로 로딩될 때 자동으로 실행되는 블록

```java
static {
    ...
}
```

- 클래스 내부에 여러 개가 선언되면 선언된 순서대로 실행
- static 필드의 복잡한 초기화 작업과 static 메소드 호출 가능
- 주의 : static 블록 내부에 인스턴스 필드나 인스턴스 메소드 사용 불가, 객체 자신을 참조하는 this 사용 불가

### 변수(필드)의 초기화 정리

- 초기화
  - 변수를 선언하고 처음으로 값을 저장하는 것
  - 이전에 사용한 다른 값이 들어 있을 수 있으므로 초기화하고 사용
- 기본값으로 자동 초기화되는 변수
  - 멤버필드(멤버변수)
    - 인스턴스 필드(변수)
    - static 필드(변수)
    - 0, 0.0, null, false
  - 배열
- 사용 전에 반드시 초기화가 필요한 변수
  - 메소드 내에 선언된 지역 변수

### 싱글톤 (Singleton)

> 하나의 애플리케이션 내에서 단 하나만 생성되는 객체

- 객체 중에는 하나만 있어도 되는 (또는 하나만 있어야 하는) 것들이 있는데 이런 객체의 경우 인스턴스 2개 이상 만들 경우 에러나 자원의 낭비를 야기할 수 있기 때문에 싱글톤 패턴 사용

#### 싱글톤을 만드는 방법

- 외부에서 new 연산자로 생성자를 호출할 수 없도록 private 접근 제한자를 생성자 앞에 붙임
- 클래스 자신의 타입으로 static 필드 선언
  - 자신의 객체를 생성해서 초기화
  - private 접근 제한자를 붙여 외부에서 필드 값 변경 불가하도록
- 외부에서 호출할 수 있는 static 메소드인 getInstance() 메소드 선언
  - static 필드에서 참조하고 있는 자신의 객체 리턴

### final 필드 (인스턴스 레벨에서의 상수)

> 최종적인 값을 갖고 있는 필드 (값을 변경할 수 없는 필드)

- 한 번 초기화되면 수정할 수 없는 필드
- 클래스 레벨에서는 통용되지 않음

### 패키지 (package)

> 클래스를 기능별로 묶어서 그룹 이름을 붙여 놓은 것

```java
package 상위패키지.하위패키지;

public class ClassName { ... }
```

- 클래스 작성 시 패키지 선언하지 않으면 default package에 속하게 됨

#### 패키지 사용 방법

- 다른 패키지의 클래스를 사용할 때는 클래스의 경로명을 선언하여 컴파일러에게 알림

  ```java
  import 패키지.클래스;

#### 패키지 사용 이점

- 패키지를 계층 구조로 관리
- 접근 제한
- 동일한 이름의 클래스를 다른 패키지에서 사용 가능
- 높은 소프트웨어 재사용성

### Getter와 Setter 메소드

- Getter

  > 멤버 필드의 값을 가져와서 사용할 때 사용하는 메소드

- Setter

  > 멤버 필드의 값을 설정할 때 사용하는 메소드

- 클래스 멤버 데이터 보호 방법

  - 클래스 멤버 필드를 private으로 선언해서 클래스 외부에서는 직접 접근하지 못하게 하고 멤버 메소드를 통해서만 접근하도록 함

### toString() 메소드

> 객체가 텍스트 값으로 표시되거나 문자열이 예상되는 방식으로 참조될 때 자동으로 호출되는 메소드

- 객체가 가지고 있는 정보나 값들을 문자열 형태로 반환
- 객체 출력시 toString() 자동 호출

### 어노테이션(Annotation)

> 프로그램에게 추가적인 정보를 제공해주는 메타데이터(metadata)

- 어노테이션 용도
  - 컴파일러에게 코드 작성 문법 에러 체크하도록 정보 제공
  - 소프트웨어 개발 툴이 빌드나 배치 시 코드를 자동 생성하게 정보 제공
  - 실행 시 특정 기능을 실행하도록 정보 제공
- 자바에서 기본적으로 제공하는 어노테이션
  - @Override
    - 메소드가 오버라이드 됐는지 검증
    - 클래스 또는 구현해야 할 인터페이스에서 해당 메소드를 찾을 수 없다면 컴파일 오류
  - @Deprecated
    - 메소드를 사용하지 말도록 유도 만일 사용한다면 컴파일 경고
  - SuppressWarnings
    - 컴파일 경고 무시