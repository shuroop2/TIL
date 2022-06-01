# TIL_Day_08

> 2022년 05월 28일

## 인터페이스

> 객체의 사용 방법을 정의한 타입

- 클래스들이 구현해야 하는 동작을 지정하는데 사용되는는 추상형
- 미리 정해진 규칙에 맞게 구현하도록 표준을 제시하기 위해 사용
- 추상 클래스와 유사
- 기본 설계도의 의미 (규격 / 표준을 정함)

### 인터페이스의 역할

- 개발 코드와 객체가 서로 통신하는 접점 역할
- 개발 코드가 인터페이스의 메소드를 호출하면 인터페이스는 객체의 메소드 호출
- 개발 코드는 객체의 내부 구조를 알 필요 없고 인터페이스의 메소드만 알면 됨

### 개발 코드와 객체 중간에 인터페이스를 사용하는 이유

- 개발 코드를 수정하지 않고 사용하는 객체를 변경하기 위함
- 인터페이스는 하나의 객체가 아니라 여러 객체들과 사용이 가능하므로 어떤 객체를 사용하느냐에 따라 실행 내용과 리턴 값이 달라짐
- 따라서 개발 코드 측면에서는 사용하는 객체에 따라 코드를 변경하지 않고 실행 내용과 리턴값을 다양화할 수 있다는 장점(다형성)을 가지게 됨
- 개발 코드가 객체에 종속되지 않게 객체 교체할 수 있도록 하는 역할

### 인터페이스 특징

- 인터페이스는 객체를 생성할 수 없다
  - 구현되지 않은 추상 메소드를 포함하고 있기 때문
- 객체를 생성할 수 없기 때문에 생성자를 가질 수 없음
- 인터페이스 간에 상속
- 인터페이스를 상속받아 클래스를 구현하면 모든 추상 인터페이스의 메소드를 구현해야 함

### 인터페이스 작성 과정

1. 선언
   - interface 키워드로 선언
2. 구현
   - 클래스에서 인터페이스 구현
   - implements 키워드로 명시
3. 사용
   - 인터페이스에 구현된 클래스의 객체 대입

### 인터페이스 선언

- 인터페이스 이름

  - 자바 식별자(변수, 메소드, 클래스) 작성 규칙에 따라 작성

- 소스 파일 생성

  - 인터페이스 이름과 대소문자가 동일한 소스 파일 생성 (인터페이스명.java)
  - 컴파일러를 통해 .class 형태로 컴파일
  - 물리적 형태는 클래스와 동일 (선언 방법은 다름)

- 인터페이스 선언

  - interface 키워드 사용

    ```java
    [public] interface 인터페이스명 {...}

#### 인터페이스 구성 멤버

```java
interface 인터페이스명 {
	// 상수
	타입 상수명 = 값;
	// 추상 메소드
	타입 메소드명(매개변수, ...);
	// default 메소드
	default 타입 메소드명(매개변수, ...) {...}
	// 정적 메소드
	static 타입 메소드명(매개변수) {...}
}
```

- 상수 필드

  - 인터페이스는 런타임 시 데이터를 저장할 수 있는 필드를 선언할 수 없지만 상수 필드는 선언 가능
    - 인터페이스에 고정된 값으로 런타임 시 데이터를 바꿀 수 없음
  - 인터페이스에 선언된 필드는 모두 public static final
    - 자동적으로 컴파일 과정에 붙음
  - 인터페이스는 인스턴스 필드는 가질 수 없음

- 추상 메소드

  > 선언은 되어 있으나 body가 정의되어 있지 않은 메소드 (중괄호 { } 없음)

  - 객체가 가지고 있는 메소드를 설명한 것으로 메소드명, 매개변수, 리턴 타입만 기술
  - 실제 실행 내용은 객체(구현 객체)에 작성
    - 실체 클래스에서 메소드의 실행 내용 작성
    - 오버라이딩
  - 이클립스에서 구현 클래스 생성하면서 인터페이스 지정하면 추상 메소드 자동 오버라이딩 되어 생성

- default 메소드

  > 인터페이스에 선언되지만 사실은 객체(구현 객체)가 가지고 있는 인스턴스 메소드

  - 자바 8부터 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해 default 메소드 허용

- private 메소드

- static 메소드

  > default 메소드와 달리 객체 없어도 인터페이스만으로 호출 가능한 메소드

#### 상수 필드 선언

```java
[public static final] 타입 상수명 = 값;
```

- 인터페이스는 데이터를 저장할 수 없기 때문에 데이터를 저장할 인스턴스 또는 정적 필드를 선언할 수 없고 상수 필드만 선언 가능
- 선언과 동시에 초기값 지정
  - static {} 블록 작성 불가 (static {}으로 초기화 불가)
- 상수명은 대문자로 작성
  - 서로 다른 단어로 구성되어 있을 경우에는 밑줄 문자(_)로 연결

#### 추상 메소드 선언

```java
[public abstract] 리턴타입 메소드명(매개변수, ...);
```

- 인터페이스를 통해 호출된 메소드는 최정적으로 객체에서 실행
- 따라서 인터페이스의 메소드는 기본적으로 실행 블록이 없는 추상 메소드로 선언
- 메소드명, 매개변수, 리턴 타입만 기술하고 중괄호(body) {} 없음
- 인터페이스에서 선언된 추상 메소드는 모두 public abstract이고 생략하더라도 자동으로 컴파일 과정에서 붙게 됨

#### default 메소드 선언

```java
[public] default 리턴타입 메소드명(매개변수, ...) {
	// 실행 블록
}
```

- 실행 블록을 가지고 있는 메소드
- default 키워드를 반드시 붙여야함
- 기본적으로 public 접근 제한이며 public을 생략하더라도 컴파일 과정에서 자동으로 붙음
- 자바 8에서 추가된 인터페이스의 새로운 멤버

#### 정적 메소드 선언

```java
[public] static 리턴타입 메소드명(매개변수, ...) {
	// 실행 블록
}
```

- 객체 생성 없이 인터페이스만으로 호출 가능한 메소드
- static 키워드 사용
- 실행 블록을 가지고 있는 메소드

#### private 메소드

- 인터페이스 내에서만 사용 가능한 메소드
- default 또는 정적 메소드 내에서 사용하기 위해 작성되는 메소드
- 인터페이스를 구현 클래스에서 재정의하거나 사용할 수 없음

### 인터페이스 구현

- 인터페이스에서 정의된 추상 메소드와 동일한 메소드 이름, 매개 타입, 리턴 타입을 가진 실체 메소드를 가지고 있는 객체를 인터페이스 구현 객체라고 한다

#### 구현 클래스

> 인터페이스 구현 객체를 생성하는 클래스

```java
public class 구현클래스명 implements 인터페이스명 {
	// 인터페이스에 선언된 추상 메소드의 실체 메소드 선언
}
```

- 보통의 클래스와 동일하지만 인터페이스 타입으로 사용할 수 있음을 알려주기 위해 클래스 선언부에 implements 키워드를 추가하고 인터페이스명을 명시해야 함
- 인터페이스에 선언된 추상 메소드의 실체 메소드를 선언해야 함
- 인터페이스의 모든 메소드는 기본적으로 public 접근 제한을 갖기 때문에 public보다 더 낮은 접근 제한으로 작성할 수 없음
- 만약 인터페이스에 선언된 추상 메소드에 대응하는 실체 메소드를 구현 클래스가 작성하지 않으면 구현 클래스는 자동적으로 추상 클래스가 되기 때문에 클래스 선언부에 abstract 키워드를 추가해야 함

#### 익명 구현 객체

```java
인터페이스 변수 = new 인터페이스() {
	// 인터페이스에 선언된 추상 메소드 재정의
}
```

- 구현 클래스를 만들어서 사용하는 것이 일반적이고 클래스를 재사용할 수 있기 때문에 편리하지만 일회성으로 객체가 필요한 경우에는 익명 구현 객체를 사용
- new 연산자 뒤에 클래스 이름 없음

#### 다중 인터페이스

```java
public class 구현클래스명 implements 인터페이스 A, 인터페이스 B {
	// 인터페이스 A에 선언된 추상 메소드의 실체 메소드 선언
	// 인터페이스 B에 선언된 추상 메소드의 실체 메소드 선언
}
```

- 다수의 인터페이스 타입으로 사용
- 다중 인터페이스를 구현할 경우 구현 클래스는 모든 인터페이스의 추상 메소드에 대해 실체 메소드를 작성해야 함

### 타입 변환과 다형성

#### 다형성

> 하나의 타입에 여러 가지 객체 대입해서 다양한 실행 결과를 얻는 것

- 다형성 구현 기술
  - 상속 또는 인터페이스의 자동 타입 변환
- 다형성의 효과
  - 다양한 실행 결과를 얻을 수 있음
  - 객체를 부품화시킬 수 있어 유지보수 용이
  - 메소드의 매개변수로 사용 효율적 사용

#### 자동 타입 변환 (Promotion)

> 프로그램 실행 도중에 자동적으로 타입 변환이 일어나는 것

```java
인터페이스 변수 = 구현객체; // 구현 객체가 인터페이스 타입으로 자동 타입 변환
```

#### 필드의 다형성

- 상속에서와 마찬가지로 인터페이스도 다형성을 구현하는 기술 사용
- 요즘은 상속보다는 인터페이스를 통해 다형성을 구현하는 경우가 더 많음

#### 매개변수의 다형성

- 매개변수의 타입이 인터페이스인 경우
  - 어떠한 구현 객체도 매개값으로 사용 가능
  - 구현 객체에 따라 메소드 실행 결과 달라짐

#### 강제 타입 변환 (Casting)

> 인터페이스 타입으로 자동 타입 변환 후, 구현 클래스 타입으로 다시 변환하는 것

```java
구현클래스 변수 = (구현클래스) 인터페이스변수; // 인터페이스 타입에서 구현 클래스 타입으로 강제 타입 변환
```

- 구현 객체가 인터페이스 타입으로 자동 변환하면, 인터페이스에 선언된 메소드만 사용 가능하기 때문에 구현 클래스 타입에 선언된 다른 멤버 사용하기 위해 쓰여짐

#### 객체 타입 확인 (instanceof)

- 강제 타입 변환 전에 구현 클래스 타입 조사

- 구현 객체가 인터페이스 타입으로 변환되어 있는 상태에서 가능

- 어떤 구현 객체가 변환되어 있는지 알 수 없는 상태에서 무작정 변환할 경우, 변환 불가 타입이면 ClassCastException 예외 발생

- 따라서 먼저 인터페이스 타입으로 변환된 객체 확인

  - instanceof 연산자 사용

    ```java
    참조변수(객체) instanceof 타입(클래스명)
    ```

    - 왼쪽의 객체가 오른쪽 타입의 인스턴스이면 true 반환
    - true 반환하면 참조변수가 검사한 타입으로 타입 변환 가능

### 인터페이스 상속

```java
public interface 하위인터페이스 extends 상위인터페이스1, 상위인터페이스2 {...}
```

- 인터페이스 간 상속 가능
- 다중 상속 가능
- 주의 : 하위 인터페이스를 구현한 클래스는 아래 추상 메소드를 모두 재정의 해야 함 (모든 인터페이스의 추상 메소드를 재정의해야 함)
  - 하위인터페이스의 추상 메소드
  - 상위인터페이스1의 추상 메소드
  - 상위인터페이스2의 추상 메소드

#### 인터페이스 자동 타입 변환

- 구현 클래스로부터 객체 생성 후 하위 및 상위 인터페이스 타입으로 변환 가능

```java
하위인터페이스 변수 = new 구현클래스();
상위인터페이스1 변수 = new 구현클래스();
상위인터페이스2 변수 = new 구현클래스();
```

- 하위인터페이스로 타입 변환되는 경우
  - 상/하위 인터페이스에 선언된 모든 메소드 사용 가능
- 상위인터페이스로 타입 변환되는 경우
  - 상위인터페이스에 선언된 메소드만 사용 가능하고 하위인터페이스에 선언된 메소드는 사용 불가

### default 메소드와 인터페이스 확장

#### default 메소드

- 실행 블록을 가지고 있는 메소드

- 인터페이스에 선언된 인스턴스 메소드로 구현 객체가 있어야 사용 가능

- 선언은 인터페이스에서 하고, 사용은 구현 객체를 통해 사용

- default 메소드를 허용하는 이유

  - 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해

  - 추상 메소드로 선언하면 구현 클래스에서 필요 없어도 반드시 구현해야 하지만 default 메소드로 선언하면 구현 클래스에서 실제 메소드를 작성할 필요가 없음

#### default 메소드가 있는 인터페이스 상속

- 부모 인터페이스의 default 메소드를 자식 인터페이스에서 활용 방법
  1. default 메소드를 단순히 상속만 받음
  2. default 메소드를 재정의해서 실행 내용을 변경
  3. default 메소드를 추상 메소드로 재선언